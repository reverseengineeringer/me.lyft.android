package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;

final class HttpEngine$1
  extends ResponseBody
{
  public long contentLength()
  {
    return 0L;
  }
  
  public MediaType contentType()
  {
    return null;
  }
  
  public BufferedSource source()
  {
    return new Buffer();
  }
}

/* Location:
 * Qualified Name:     com.squareup.okhttp.internal.http.HttpEngine.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */