package com.threatmetrix.TrustDefenderMobile;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.RequestBody;
import java.io.IOException;
import okio.BufferedSink;
import okio.GzipSink;
import okio.Okio;

class OkHttpClientImpl$GzipRequestInterceptor$1
  extends RequestBody
{
  OkHttpClientImpl$GzipRequestInterceptor$1(OkHttpClientImpl.GzipRequestInterceptor paramGzipRequestInterceptor, RequestBody paramRequestBody) {}
  
  public long contentLength()
  {
    return -1L;
  }
  
  public MediaType contentType()
  {
    return val$body.contentType();
  }
  
  public void writeTo(BufferedSink paramBufferedSink)
    throws IOException
  {
    paramBufferedSink = Okio.buffer(new GzipSink(paramBufferedSink));
    val$body.writeTo(paramBufferedSink);
    paramBufferedSink.close();
  }
}

/* Location:
 * Qualified Name:     com.threatmetrix.TrustDefenderMobile.OkHttpClientImpl.GzipRequestInterceptor.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */