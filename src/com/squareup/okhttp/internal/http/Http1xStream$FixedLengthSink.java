package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.internal.Util;
import java.io.IOException;
import java.net.ProtocolException;
import okio.Buffer;
import okio.BufferedSink;
import okio.ForwardingTimeout;
import okio.Sink;
import okio.Timeout;

final class Http1xStream$FixedLengthSink
  implements Sink
{
  private long bytesRemaining;
  private boolean closed;
  private final ForwardingTimeout timeout = new ForwardingTimeout(Http1xStream.access$300(this$0).timeout());
  
  private Http1xStream$FixedLengthSink(Http1xStream paramHttp1xStream, long paramLong)
  {
    bytesRemaining = paramLong;
  }
  
  public void close()
    throws IOException
  {
    if (closed) {
      return;
    }
    closed = true;
    if (bytesRemaining > 0L) {
      throw new ProtocolException("unexpected end of stream");
    }
    Http1xStream.access$400(this$0, timeout);
    Http1xStream.access$502(this$0, 3);
  }
  
  public void flush()
    throws IOException
  {
    if (closed) {
      return;
    }
    Http1xStream.access$300(this$0).flush();
  }
  
  public Timeout timeout()
  {
    return timeout;
  }
  
  public void write(Buffer paramBuffer, long paramLong)
    throws IOException
  {
    if (closed) {
      throw new IllegalStateException("closed");
    }
    Util.checkOffsetAndCount(paramBuffer.size(), 0L, paramLong);
    if (paramLong > bytesRemaining) {
      throw new ProtocolException("expected " + bytesRemaining + " bytes but received " + paramLong);
    }
    Http1xStream.access$300(this$0).write(paramBuffer, paramLong);
    bytesRemaining -= paramLong;
  }
}

/* Location:
 * Qualified Name:     com.squareup.okhttp.internal.http.Http1xStream.FixedLengthSink
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */