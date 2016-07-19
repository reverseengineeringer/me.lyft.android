package com.squareup.okhttp;

import java.io.IOException;
import okio.BufferedSink;
import okio.ByteString;

final class RequestBody$1
  extends RequestBody
{
  RequestBody$1(MediaType paramMediaType, ByteString paramByteString) {}
  
  public long contentLength()
    throws IOException
  {
    return val$content.size();
  }
  
  public MediaType contentType()
  {
    return val$contentType;
  }
  
  public void writeTo(BufferedSink paramBufferedSink)
    throws IOException
  {
    paramBufferedSink.write(val$content);
  }
}

/* Location:
 * Qualified Name:     com.squareup.okhttp.RequestBody.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */