package com.threatmetrix.TrustDefenderMobile;

import android.content.Context;
import android.util.Log;
import com.squareup.okhttp.ConnectionPool;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.Interceptor.Chain;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Request.Builder;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import okio.BufferedSink;
import okio.GzipSink;
import okio.Okio;

class OkHttpClientImpl
  implements TDHttpClient
{
  private static final String TAG = StringUtils.getLogTag(OkHttpClientImpl.class);
  private static final GzipRequestInterceptor s_compressor = new GzipRequestInterceptor();
  OkHttpClient m_httpClient;
  String m_userAgent;
  
  public void finit(Executor paramExecutor)
  {
    if (m_httpClient != null)
    {
      paramExecutor = m_httpClient.getConnectionPool();
      if (paramExecutor != null)
      {
        Log.d(TAG, "Evicting " + paramExecutor.getConnectionCount() + " connections");
        paramExecutor.evictAll();
      }
    }
  }
  
  public OkHttpClient getClient()
  {
    return m_httpClient;
  }
  
  public TDURLConnection getURLConnection(CancelState paramCancelState)
  {
    return new OkHttpURLConnectionImpl(this, paramCancelState);
  }
  
  public String getUserAgent()
  {
    return m_userAgent;
  }
  
  public void init(Context paramContext, int paramInt, String paramString, boolean paramBoolean)
  {
    Log.d(TAG, "Creating OkHttpClient instance");
    m_httpClient = new OkHttpClient();
    m_httpClient.setConnectTimeout(paramInt, TimeUnit.MILLISECONDS);
    m_httpClient.setWriteTimeout(paramInt, TimeUnit.MILLISECONDS);
    m_httpClient.setReadTimeout(paramInt, TimeUnit.MILLISECONDS);
    m_httpClient.setFollowRedirects(true);
    m_httpClient.setFollowSslRedirects(true);
    m_httpClient.setConnectionPool(new ConnectionPool(3, 30000L));
    m_userAgent = paramString;
    paramContext = new ProxyWrapper();
    if (paramContext.getHost() != null) {
      m_httpClient.setProxy(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(paramContext.getHost(), paramContext.getPort())));
    }
    if (paramBoolean) {
      m_httpClient.interceptors().add(s_compressor);
    }
    paramContext = new ArrayList();
    paramContext.add(Protocol.HTTP_1_1);
    m_httpClient.setProtocols(paramContext);
    m_httpClient.setRetryOnConnectionFailure(true);
  }
  
  static final class GzipRequestInterceptor
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
}

/* Location:
 * Qualified Name:     com.threatmetrix.TrustDefenderMobile.OkHttpClientImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */