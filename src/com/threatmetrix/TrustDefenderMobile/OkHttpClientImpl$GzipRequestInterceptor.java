package com.threatmetrix.TrustDefenderMobile;

import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.Interceptor.Chain;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Request.Builder;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import java.io.IOException;
import okio.BufferedSink;
import okio.GzipSink;
import okio.Okio;

final class OkHttpClientImpl$GzipRequestInterceptor
  implements Interceptor
{
  private RequestBody gzip(final RequestBody paramRequestBody)
  {
    new RequestBody()
    {
      public long contentLength()
      {
        return -1L;
      }
      
      public MediaType contentType()
      {
        return paramRequestBody.contentType();
      }
      
      public void writeTo(BufferedSink paramAnonymousBufferedSink)
        throws IOException
      {
        paramAnonymousBufferedSink = Okio.buffer(new GzipSink(paramAnonymousBufferedSink));
        paramRequestBody.writeTo(paramAnonymousBufferedSink);
        paramAnonymousBufferedSink.close();
      }
    };
  }
  
  public Response intercept(Interceptor.Chain paramChain)
    throws IOException
  {
    Request localRequest = paramChain.request();
    if ((localRequest.body() == null) || (localRequest.header("Content-Encoding") != null)) {
      return paramChain.proceed(localRequest);
    }
    return paramChain.proceed(localRequest.newBuilder().header("Content-Encoding", "gzip").method(localRequest.method(), gzip(localRequest.body())).build());
  }
}

/* Location:
 * Qualified Name:     com.threatmetrix.TrustDefenderMobile.OkHttpClientImpl.GzipRequestInterceptor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */