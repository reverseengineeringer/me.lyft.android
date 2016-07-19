package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.internal.Util;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Source;
import okio.Timeout;

class HttpEngine$2
  implements Source
{
  boolean cacheRequestClosed;
  
  HttpEngine$2(HttpEngine paramHttpEngine, BufferedSource paramBufferedSource, CacheRequest paramCacheRequest, BufferedSink paramBufferedSink) {}
  
  public void close()
    throws IOException
  {
    if ((!cacheRequestClosed) && (!Util.discard(this, 100, TimeUnit.MILLISECONDS)))
    {
      cacheRequestClosed = true;
      val$cacheRequest.abort();
    }
    val$source.close();
  }
  
  public long read(Buffer paramBuffer, long paramLong)
    throws IOException
  {
    try
    {
      paramLong = val$source.read(paramBuffer, paramLong);
      if (paramLong == -1L)
      {
        if (!cacheRequestClosed)
        {
          cacheRequestClosed = true;
          val$cacheBody.close();
        }
        return -1L;
      }
    }
    catch (IOException paramBuffer)
    {
      if (!cacheRequestClosed)
      {
        cacheRequestClosed = true;
        val$cacheRequest.abort();
      }
      throw paramBuffer;
    }
    paramBuffer.copyTo(val$cacheBody.buffer(), paramBuffer.size() - paramLong, paramLong);
    val$cacheBody.emitCompleteSegments();
    return paramLong;
  }
  
  public Timeout timeout()
  {
    return val$source.timeout();
  }
}

/* Location:
 * Qualified Name:     com.squareup.okhttp.internal.http.HttpEngine.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */