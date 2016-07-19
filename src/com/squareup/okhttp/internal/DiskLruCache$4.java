package com.squareup.okhttp.internal;

import java.io.IOException;
import okio.Buffer;
import okio.Sink;
import okio.Timeout;

final class DiskLruCache$4
  implements Sink
{
  public void close()
    throws IOException
  {}
  
  public void flush()
    throws IOException
  {}
  
  public Timeout timeout()
  {
    return Timeout.NONE;
  }
  
  public void write(Buffer paramBuffer, long paramLong)
    throws IOException
  {
    paramBuffer.skip(paramLong);
  }
}

/* Location:
 * Qualified Name:     com.squareup.okhttp.internal.DiskLruCache.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */