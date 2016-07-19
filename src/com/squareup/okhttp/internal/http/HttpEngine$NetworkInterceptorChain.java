package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Address;
import com.squareup.okhttp.Connection;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.Interceptor.Chain;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import com.squareup.okhttp.Route;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.List;
import okio.BufferedSink;
import okio.Okio;

class HttpEngine$NetworkInterceptorChain
  implements Interceptor.Chain
{
  private int calls;
  private final int index;
  private final Request request;
  
  HttpEngine$NetworkInterceptorChain(HttpEngine paramHttpEngine, int paramInt, Request paramRequest)
  {
    index = paramInt;
    request = paramRequest;
  }
  
  public Connection connection()
  {
    return this$0.streamAllocation.connection();
  }
  
  public Response proceed(Request paramRequest)
    throws IOException
  {
    calls += 1;
    Object localObject1;
    Object localObject2;
    if (index > 0)
    {
      localObject1 = (Interceptor)this$0.client.networkInterceptors().get(index - 1);
      localObject2 = connection().getRoute().getAddress();
      if ((!paramRequest.httpUrl().host().equals(((Address)localObject2).getUriHost())) || (paramRequest.httpUrl().port() != ((Address)localObject2).getUriPort())) {
        throw new IllegalStateException("network interceptor " + localObject1 + " must retain the same host and port");
      }
      if (calls > 1) {
        throw new IllegalStateException("network interceptor " + localObject1 + " must call proceed() exactly once");
      }
    }
    if (index < this$0.client.networkInterceptors().size())
    {
      paramRequest = new NetworkInterceptorChain(this$0, index + 1, paramRequest);
      localObject2 = (Interceptor)this$0.client.networkInterceptors().get(index);
      localObject1 = ((Interceptor)localObject2).intercept(paramRequest);
      if (calls != 1) {
        throw new IllegalStateException("network interceptor " + localObject2 + " must call proceed() exactly once");
      }
      paramRequest = (Request)localObject1;
      if (localObject1 == null) {
        throw new NullPointerException("network interceptor " + localObject2 + " returned null");
      }
    }
    else
    {
      HttpEngine.access$000(this$0).writeRequestHeaders(paramRequest);
      HttpEngine.access$102(this$0, paramRequest);
      if ((this$0.permitsRequestBody(paramRequest)) && (paramRequest.body() != null))
      {
        localObject1 = Okio.buffer(HttpEngine.access$000(this$0).createRequestBody(paramRequest, paramRequest.body().contentLength()));
        paramRequest.body().writeTo((BufferedSink)localObject1);
        ((BufferedSink)localObject1).close();
      }
      paramRequest = HttpEngine.access$200(this$0);
      int i = paramRequest.code();
      if (((i == 204) || (i == 205)) && (paramRequest.body().contentLength() > 0L)) {
        throw new ProtocolException("HTTP " + i + " had non-zero Content-Length: " + paramRequest.body().contentLength());
      }
    }
    return paramRequest;
  }
  
  public Request request()
  {
    return request;
  }
}

/* Location:
 * Qualified Name:     com.squareup.okhttp.internal.http.HttpEngine.NetworkInterceptorChain
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */