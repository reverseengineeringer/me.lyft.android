package com.squareup.tape;

import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;

final class QueueFile$ElementInputStream
  extends InputStream
{
  private int position;
  private int remaining;
  
  private QueueFile$ElementInputStream(QueueFile paramQueueFile, QueueFile.Element paramElement)
  {
    position = QueueFile.access$100(paramQueueFile, position + 4);
    remaining = length;
  }
  
  public int read()
    throws IOException
  {
    if (remaining == 0) {
      return -1;
    }
    this$0.raf.seek(position);
    int i = this$0.raf.read();
    position = QueueFile.access$100(this$0, position + 1);
    remaining -= 1;
    return i;
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    QueueFile.access$200(paramArrayOfByte, "buffer");
    if (((paramInt1 | paramInt2) < 0) || (paramInt2 > paramArrayOfByte.length - paramInt1)) {
      throw new ArrayIndexOutOfBoundsException();
    }
    if (remaining > 0)
    {
      int i = paramInt2;
      if (paramInt2 > remaining) {
        i = remaining;
      }
      QueueFile.access$300(this$0, position, paramArrayOfByte, paramInt1, i);
      position = QueueFile.access$100(this$0, position + i);
      remaining -= i;
      return i;
    }
    return -1;
  }
}

/* Location:
 * Qualified Name:     com.squareup.tape.QueueFile.ElementInputStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */