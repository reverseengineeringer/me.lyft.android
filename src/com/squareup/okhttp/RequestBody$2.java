package com.squareup.okhttp;

import java.io.IOException;
import okio.BufferedSink;

final class RequestBody$2
  extends RequestBody
{
  RequestBody$2(MediaType paramMediaType, int paramInt1, byte[] paramArrayOfByte, int paramInt2) {}
  
  public long contentLength()
  {
    return val$byteCount;
  }
  
  public MediaType contentType()
  {
    return val$contentType;
  }
  
  public void writeTo(BufferedSink paramBufferedSink)
    throws IOException
  {
    paramBufferedSink.write(val$content, val$offset, val$byteCount);
  }
}

/* Location:
 * Qualified Name:     com.squareup.okhttp.RequestBody.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */