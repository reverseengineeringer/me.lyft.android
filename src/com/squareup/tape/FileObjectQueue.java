package com.squareup.tape;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

public class FileObjectQueue<T>
  implements ObjectQueue<T>
{
  private final DirectByteArrayOutputStream bytes = new DirectByteArrayOutputStream();
  private final Converter<T> converter;
  private final File file;
  private ObjectQueue.Listener<T> listener;
  private final QueueFile queueFile;
  
  public FileObjectQueue(File paramFile, Converter<T> paramConverter)
    throws IOException
  {
    file = paramFile;
    converter = paramConverter;
    queueFile = new QueueFile(paramFile);
  }
  
  public final void add(T paramT)
  {
    try
    {
      bytes.reset();
      converter.toStream(paramT, bytes);
      queueFile.add(bytes.getArray(), 0, bytes.size());
      if (listener != null) {
        listener.onAdd(this, paramT);
      }
      return;
    }
    catch (IOException paramT)
    {
      throw new FileException("Failed to add entry.", paramT, file);
    }
  }
  
  public T peek()
  {
    try
    {
      Object localObject = queueFile.peek();
      if (localObject == null) {
        return null;
      }
      localObject = converter.from((byte[])localObject);
      return (T)localObject;
    }
    catch (IOException localIOException)
    {
      throw new FileException("Failed to peek.", localIOException, file);
    }
  }
  
  public final void remove()
  {
    try
    {
      queueFile.remove();
      if (listener != null) {
        listener.onRemove(this);
      }
      return;
    }
    catch (IOException localIOException)
    {
      throw new FileException("Failed to remove.", localIOException, file);
    }
  }
  
  public int size()
  {
    return queueFile.size();
  }
  
  public static abstract interface Converter<T>
  {
    public abstract T from(byte[] paramArrayOfByte)
      throws IOException;
    
    public abstract void toStream(T paramT, OutputStream paramOutputStream)
      throws IOException;
  }
  
  private static class DirectByteArrayOutputStream
    extends ByteArrayOutputStream
  {
    public byte[] getArray()
    {
      return buf;
    }
  }
}

/* Location:
 * Qualified Name:     com.squareup.tape.FileObjectQueue
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */