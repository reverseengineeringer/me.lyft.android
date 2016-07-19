package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Headers;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.ResponseBody;
import okio.BufferedSource;

public final class RealResponseBody
  extends ResponseBody
{
  private final Headers headers;
  private final BufferedSource source;
  
  public RealResponseBody(Headers paramHeaders, BufferedSource paramBufferedSource)
  {
    headers = paramHeaders;
    source = paramBufferedSource;
  }
  
  public long contentLength()
  {
    return OkHeaders.contentLength(headers);
  }
  
  public MediaType contentType()
  {
    String str = headers.get("Content-Type");
    if (str != null) {
      return MediaType.parse(str);
    }
    return null;
  }
  
  public BufferedSource source()
  {
    return source;
  }
}

/* Location:
 * Qualified Name:     com.squareup.okhttp.internal.http.RealResponseBody
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */