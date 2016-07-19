package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.internal.Util;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import okio.Buffer;
import okio.BufferedSource;

class Http1xStream$FixedLengthSource
  extends Http1xStream.AbstractSource
{
  private long bytesRemaining;
  
  public Http1xStream$FixedLengthSource(Http1xStream paramHttp1xStream, long paramLong)
    throws IOException
  {
    super(paramHttp1xStream, null);
    bytesRemaining = paramLong;
    if (bytesRemaining == 0L) {
      endOfInput();
    }
  }
  
  public void close()
    throws IOException
  {
    if (closed) {
      return;
    }
    if ((bytesRemaining != 0L) && (!Util.discard(this, 100, TimeUnit.MILLISECONDS))) {
      unexpectedEndOfInput();
    }
    closed = true;
  }
  
  public long read(Buffer paramBuffer, long paramLong)
    throws IOException
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("byteCount < 0: " + paramLong);
    }
    if (closed) {
      throw new IllegalStateException("closed");
    }
    if (bytesRemaining == 0L) {
      paramLong = -1L;
    }
    long l;
    do
    {
      return paramLong;
      l = Http1xStream.access$600(this$0).read(paramBuffer, Math.min(bytesRemaining, paramLong));
      if (l == -1L)
      {
        unexpectedEndOfInput();
        throw new ProtocolException("unexpected end of stream");
      }
      bytesRemaining -= l;
      paramLong = l;
    } while (bytesRemaining != 0L);
    endOfInput();
    return l;
  }
}

/* Location:
 * Qualified Name:     com.squareup.okhttp.internal.http.Http1xStream.FixedLengthSource
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */