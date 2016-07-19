package com.squareup.okhttp;

import okio.BufferedSource;

final class ResponseBody$1
  extends ResponseBody
{
  ResponseBody$1(MediaType paramMediaType, long paramLong, BufferedSource paramBufferedSource) {}
  
  public long contentLength()
  {
    return val$contentLength;
  }
  
  public MediaType contentType()
  {
    return val$contentType;
  }
  
  public BufferedSource source()
  {
    return val$content;
  }
}

/* Location:
 * Qualified Name:     com.squareup.okhttp.ResponseBody.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */