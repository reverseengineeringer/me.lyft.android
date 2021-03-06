package io.fabric.sdk.android.services.common;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class QueueFile
  implements Closeable
{
  private static final Logger LOGGER = Logger.getLogger(QueueFile.class.getName());
  private final byte[] buffer = new byte[16];
  private int elementCount;
  int fileLength;
  private Element first;
  private Element last;
  private final RandomAccessFile raf;
  
  public QueueFile(File paramFile)
    throws IOException
  {
    if (!paramFile.exists()) {
      initialize(paramFile);
    }
    raf = open(paramFile);
    readHeader();
  }
  
  private void expandIfNecessary(int paramInt)
    throws IOException
  {
    int m = paramInt + 4;
    paramInt = remainingBytes();
    if (paramInt >= m) {
      return;
    }
    int i = fileLength;
    int k;
    int j;
    do
    {
      k = paramInt + i;
      j = i << 1;
      i = j;
      paramInt = k;
    } while (k < m);
    setLength(j);
    paramInt = wrapPosition(last.position + 4 + last.length);
    if (paramInt < first.position)
    {
      FileChannel localFileChannel = raf.getChannel();
      localFileChannel.position(fileLength);
      paramInt -= 4;
      if (localFileChannel.transferTo(16L, paramInt, localFileChannel) != paramInt) {
        throw new AssertionError("Copied insufficient number of bytes!");
      }
    }
    if (last.position < first.position)
    {
      paramInt = fileLength + last.position - 16;
      writeHeader(j, elementCount, first.position, paramInt);
      last = new Element(paramInt, last.length);
    }
    for (;;)
    {
      fileLength = j;
      return;
      writeHeader(j, elementCount, first.position, last.position);
    }
  }
  
  private static void initialize(File paramFile)
    throws IOException
  {
    File localFile = new File(paramFile.getPath() + ".tmp");
    RandomAccessFile localRandomAccessFile = open(localFile);
    try
    {
      localRandomAccessFile.setLength(4096L);
      localRandomAccessFile.seek(0L);
      byte[] arrayOfByte = new byte[16];
      writeInts(arrayOfByte, new int[] { 4096, 0, 0, 0 });
      localRandomAccessFile.write(arrayOfByte);
      localRandomAccessFile.close();
      if (!localFile.renameTo(paramFile)) {
        throw new IOException("Rename failed!");
      }
    }
    finally
    {
      localRandomAccessFile.close();
    }
  }
  
  private static <T> T nonNull(T paramT, String paramString)
  {
    if (paramT == null) {
      throw new NullPointerException(paramString);
    }
    return paramT;
  }
  
  private static RandomAccessFile open(File paramFile)
    throws FileNotFoundException
  {
    return new RandomAccessFile(paramFile, "rwd");
  }
  
  private Element readElement(int paramInt)
    throws IOException
  {
    if (paramInt == 0) {
      return Element.NULL;
    }
    raf.seek(paramInt);
    return new Element(paramInt, raf.readInt());
  }
  
  private void readHeader()
    throws IOException
  {
    raf.seek(0L);
    raf.readFully(buffer);
    fileLength = readInt(buffer, 0);
    if (fileLength > raf.length()) {
      throw new IOException("File is truncated. Expected length: " + fileLength + ", Actual length: " + raf.length());
    }
    elementCount = readInt(buffer, 4);
    int i = readInt(buffer, 8);
    int j = readInt(buffer, 12);
    first = readElement(i);
    last = readElement(j);
  }
  
  private static int readInt(byte[] paramArrayOfByte, int paramInt)
  {
    return ((paramArrayOfByte[paramInt] & 0xFF) << 24) + ((paramArrayOfByte[(paramInt + 1)] & 0xFF) << 16) + ((paramArrayOfByte[(paramInt + 2)] & 0xFF) << 8) + (paramArrayOfByte[(paramInt + 3)] & 0xFF);
  }
  
  private int remainingBytes()
  {
    return fileLength - usedBytes();
  }
  
  private void ringRead(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
    throws IOException
  {
    paramInt1 = wrapPosition(paramInt1);
    if (paramInt1 + paramInt3 <= fileLength)
    {
      raf.seek(paramInt1);
      raf.readFully(paramArrayOfByte, paramInt2, paramInt3);
      return;
    }
    int i = fileLength - paramInt1;
    raf.seek(paramInt1);
    raf.readFully(paramArrayOfByte, paramInt2, i);
    raf.seek(16L);
    raf.readFully(paramArrayOfByte, paramInt2 + i, paramInt3 - i);
  }
  
  private void ringWrite(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
    throws IOException
  {
    paramInt1 = wrapPosition(paramInt1);
    if (paramInt1 + paramInt3 <= fileLength)
    {
      raf.seek(paramInt1);
      raf.write(paramArrayOfByte, paramInt2, paramInt3);
      return;
    }
    int i = fileLength - paramInt1;
    raf.seek(paramInt1);
    raf.write(paramArrayOfByte, paramInt2, i);
    raf.seek(16L);
    raf.write(paramArrayOfByte, paramInt2 + i, paramInt3 - i);
  }
  
  private void setLength(int paramInt)
    throws IOException
  {
    raf.setLength(paramInt);
    raf.getChannel().force(true);
  }
  
  private int wrapPosition(int paramInt)
  {
    if (paramInt < fileLength) {
      return paramInt;
    }
    return paramInt + 16 - fileLength;
  }
  
  private void writeHeader(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    throws IOException
  {
    writeInts(buffer, new int[] { paramInt1, paramInt2, paramInt3, paramInt4 });
    raf.seek(0L);
    raf.write(buffer);
  }
  
  private static void writeInt(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramArrayOfByte[paramInt1] = ((byte)(paramInt2 >> 24));
    paramArrayOfByte[(paramInt1 + 1)] = ((byte)(paramInt2 >> 16));
    paramArrayOfByte[(paramInt1 + 2)] = ((byte)(paramInt2 >> 8));
    paramArrayOfByte[(paramInt1 + 3)] = ((byte)paramInt2);
  }
  
  private static void writeInts(byte[] paramArrayOfByte, int... paramVarArgs)
  {
    int j = 0;
    int k = paramVarArgs.length;
    int i = 0;
    while (i < k)
    {
      writeInt(paramArrayOfByte, j, paramVarArgs[i]);
      j += 4;
      i += 1;
    }
  }
  
  public void add(byte[] paramArrayOfByte)
    throws IOException
  {
    add(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public void add(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    try
    {
      nonNull(paramArrayOfByte, "buffer");
      if (((paramInt1 | paramInt2) < 0) || (paramInt2 > paramArrayOfByte.length - paramInt1)) {
        throw new IndexOutOfBoundsException();
      }
    }
    finally {}
    expandIfNecessary(paramInt2);
    boolean bool = isEmpty();
    int i;
    Element localElement;
    if (bool)
    {
      i = 16;
      localElement = new Element(i, paramInt2);
      writeInt(buffer, 0, paramInt2);
      ringWrite(position, buffer, 0, 4);
      ringWrite(position + 4, paramArrayOfByte, paramInt1, paramInt2);
      if (!bool) {
        break label195;
      }
    }
    label195:
    for (paramInt1 = position;; paramInt1 = first.position)
    {
      writeHeader(fileLength, elementCount + 1, paramInt1, position);
      last = localElement;
      elementCount += 1;
      if (bool) {
        first = last;
      }
      return;
      i = wrapPosition(last.position + 4 + last.length);
      break;
    }
  }
  
  public void clear()
    throws IOException
  {
    try
    {
      writeHeader(4096, 0, 0, 0);
      elementCount = 0;
      first = Element.NULL;
      last = Element.NULL;
      if (fileLength > 4096) {
        setLength(4096);
      }
      fileLength = 4096;
      return;
    }
    finally {}
  }
  
  public void close()
    throws IOException
  {
    try
    {
      raf.close();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void forEach(ElementReader paramElementReader)
    throws IOException
  {
    try
    {
      int j = first.position;
      int i = 0;
      while (i < elementCount)
      {
        Element localElement = readElement(j);
        paramElementReader.read(new ElementInputStream(localElement, null), length);
        j = wrapPosition(position + 4 + length);
        i += 1;
      }
      return;
    }
    finally {}
  }
  
  public boolean hasSpaceFor(int paramInt1, int paramInt2)
  {
    return usedBytes() + 4 + paramInt1 <= paramInt2;
  }
  
  /* Error */
  public boolean isEmpty()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 139	io/fabric/sdk/android/services/common/QueueFile:elementCount	I
    //   6: istore_1
    //   7: iload_1
    //   8: ifne +9 -> 17
    //   11: iconst_1
    //   12: istore_2
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_2
    //   16: ireturn
    //   17: iconst_0
    //   18: istore_2
    //   19: goto -6 -> 13
    //   22: astore_3
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_3
    //   26: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	27	0	this	QueueFile
    //   6	2	1	i	int
    //   12	7	2	bool	boolean
    //   22	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	22	finally
  }
  
  public void remove()
    throws IOException
  {
    try
    {
      if (isEmpty()) {
        throw new NoSuchElementException();
      }
    }
    finally {}
    if (elementCount == 1) {
      clear();
    }
    for (;;)
    {
      return;
      int i = wrapPosition(first.position + 4 + first.length);
      ringRead(i, buffer, 0, 4);
      int j = readInt(buffer, 0);
      writeHeader(fileLength, elementCount - 1, i, last.position);
      elementCount -= 1;
      first = new Element(i, j);
    }
  }
  
  public String toString()
  {
    final StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getClass().getSimpleName()).append('[');
    localStringBuilder.append("fileLength=").append(fileLength);
    localStringBuilder.append(", size=").append(elementCount);
    localStringBuilder.append(", first=").append(first);
    localStringBuilder.append(", last=").append(last);
    localStringBuilder.append(", element lengths=[");
    try
    {
      forEach(new ElementReader()
      {
        boolean first = true;
        
        public void read(InputStream paramAnonymousInputStream, int paramAnonymousInt)
          throws IOException
        {
          if (first) {
            first = false;
          }
          for (;;)
          {
            localStringBuilder.append(paramAnonymousInt);
            return;
            localStringBuilder.append(", ");
          }
        }
      });
      localStringBuilder.append("]]");
      return localStringBuilder.toString();
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        LOGGER.log(Level.WARNING, "read error", localIOException);
      }
    }
  }
  
  public int usedBytes()
  {
    if (elementCount == 0) {
      return 16;
    }
    if (last.position >= first.position) {
      return last.position - first.position + 4 + last.length + 16;
    }
    return last.position + 4 + last.length + fileLength - first.position;
  }
  
  static class Element
  {
    static final Element NULL = new Element(0, 0);
    final int length;
    final int position;
    
    Element(int paramInt1, int paramInt2)
    {
      position = paramInt1;
      length = paramInt2;
    }
    
    public String toString()
    {
      return getClass().getSimpleName() + "[" + "position = " + position + ", length = " + length + "]";
    }
  }
  
  private final class ElementInputStream
    extends InputStream
  {
    private int position;
    private int remaining;
    
    private ElementInputStream(QueueFile.Element paramElement)
    {
      position = QueueFile.this.wrapPosition(position + 4);
      remaining = length;
    }
    
    public int read()
      throws IOException
    {
      if (remaining == 0) {
        return -1;
      }
      raf.seek(position);
      int i = raf.read();
      position = QueueFile.this.wrapPosition(position + 1);
      remaining -= 1;
      return i;
    }
    
    public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      QueueFile.nonNull(paramArrayOfByte, "buffer");
      if (((paramInt1 | paramInt2) < 0) || (paramInt2 > paramArrayOfByte.length - paramInt1)) {
        throw new ArrayIndexOutOfBoundsException();
      }
      if (remaining > 0)
      {
        int i = paramInt2;
        if (paramInt2 > remaining) {
          i = remaining;
        }
        QueueFile.this.ringRead(position, paramArrayOfByte, paramInt1, i);
        position = QueueFile.this.wrapPosition(position + i);
        remaining -= i;
        return i;
      }
      return -1;
    }
  }
  
  public static abstract interface ElementReader
  {
    public abstract void read(InputStream paramInputStream, int paramInt)
      throws IOException;
  }
}

/* Location:
 * Qualified Name:     io.fabric.sdk.android.services.common.QueueFile
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */