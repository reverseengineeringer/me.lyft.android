package com.squareup.okhttp.internal.http;

import java.io.IOException;
import okio.ForwardingSource;
import okio.Source;

class Http2xStream$StreamFinishingSource
  extends ForwardingSource
{
  public Http2xStream$StreamFinishingSource(Http2xStream paramHttp2xStream, Source paramSource)
  {
    super(paramSource);
  }
  
  public void close()
    throws IOException
  {
    Http2xStream.access$000(this$0).streamFinished(this$0);
    super.close();
  }
}

/* Location:
 * Qualified Name:     com.squareup.okhttp.internal.http.Http2xStream.StreamFinishingSource
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */