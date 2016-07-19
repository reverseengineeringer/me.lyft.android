package com.squareup.okhttp.internal.http;

import java.io.IOException;
import okio.Buffer;
import okio.BufferedSource;

class Http1xStream$UnknownLengthSource
  extends Http1xStream.AbstractSource
{
  private boolean inputExhausted;
  
  private Http1xStream$UnknownLengthSource(Http1xStream paramHttp1xStream)
  {
    super(paramHttp1xStream, null);
  }
  
  public void close()
    throws IOException
  {
    if (closed) {
      return;
    }
    if (!inputExhausted) {
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
    if (inputExhausted) {
      paramLong = -1L;
    }
    long l;
    do
    {
      return paramLong;
      l = Http1xStream.access$600(this$0).read(paramBuffer, paramLong);
      paramLong = l;
    } while (l != -1L);
    inputExhausted = true;
    endOfInput();
    return -1L;
  }
}

/* Location:
 * Qualified Name:     com.squareup.okhttp.internal.http.Http1xStream.UnknownLengthSource
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */