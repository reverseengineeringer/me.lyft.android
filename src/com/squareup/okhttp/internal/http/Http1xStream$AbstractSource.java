package com.squareup.okhttp.internal.http;

import java.io.IOException;
import okio.BufferedSource;
import okio.ForwardingTimeout;
import okio.Source;
import okio.Timeout;

abstract class Http1xStream$AbstractSource
  implements Source
{
  protected boolean closed;
  protected final ForwardingTimeout timeout = new ForwardingTimeout(Http1xStream.access$600(this$0).timeout());
  
  private Http1xStream$AbstractSource(Http1xStream paramHttp1xStream) {}
  
  protected final void endOfInput()
    throws IOException
  {
    if (Http1xStream.access$500(this$0) != 5) {
      throw new IllegalStateException("state: " + Http1xStream.access$500(this$0));
    }
    Http1xStream.access$400(this$0, timeout);
    Http1xStream.access$502(this$0, 6);
    if (Http1xStream.access$700(this$0) != null) {
      Http1xStream.access$700(this$0).streamFinished(this$0);
    }
  }
  
  public Timeout timeout()
  {
    return timeout;
  }
  
  protected final void unexpectedEndOfInput()
  {
    if (Http1xStream.access$500(this$0) == 6) {}
    do
    {
      return;
      Http1xStream.access$502(this$0, 6);
    } while (Http1xStream.access$700(this$0) == null);
    Http1xStream.access$700(this$0).noNewStreams();
    Http1xStream.access$700(this$0).streamFinished(this$0);
  }
}

/* Location:
 * Qualified Name:     com.squareup.okhttp.internal.http.Http1xStream.AbstractSource
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */