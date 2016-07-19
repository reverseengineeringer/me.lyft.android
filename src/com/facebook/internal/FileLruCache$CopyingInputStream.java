package com.facebook.internal;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

final class FileLruCache$CopyingInputStream
  extends InputStream
{
  final InputStream input;
  final OutputStream output;
  
  FileLruCache$CopyingInputStream(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    input = paramInputStream;
    output = paramOutputStream;
  }
  
  public int available()
    throws IOException
  {
    return input.available();
  }
  
  public void close()
    throws IOException
  {
    try
    {
      input.close();
      return;
    }
    finally
    {
      output.close();
    }
  }
  
  public void mark(int paramInt)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean markSupported()
  {
    return false;
  }
  
  public int read()
    throws IOException
  {
    int i = input.read();
    if (i >= 0) {
      output.write(i);
    }
    return i;
  }
  
  public int read(byte[] paramArrayOfByte)
    throws IOException
  {
    int i = input.read(paramArrayOfByte);
    if (i > 0) {
      output.write(paramArrayOfByte, 0, i);
    }
    return i;
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    paramInt2 = input.read(paramArrayOfByte, paramInt1, paramInt2);
    if (paramInt2 > 0) {
      output.write(paramArrayOfByte, paramInt1, paramInt2);
    }
    return paramInt2;
  }
  
  public void reset()
  {
    try
    {
      throw new UnsupportedOperationException();
    }
    finally {}
  }
  
  public long skip(long paramLong)
    throws IOException
  {
    byte[] arrayOfByte = new byte['Ѐ'];
    int i;
    for (long l = 0L;; l += i) {
      if (l < paramLong)
      {
        i = read(arrayOfByte, 0, (int)Math.min(paramLong - l, arrayOfByte.length));
        if (i >= 0) {}
      }
      else
      {
        return l;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.facebook.internal.FileLruCache.CopyingInputStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */