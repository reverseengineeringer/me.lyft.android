package com.threatmetrix.TrustDefenderMobile;

import android.content.Context;
import android.net.http.AndroidHttpClient;
import android.util.Log;
import java.util.concurrent.Executor;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.params.HttpConnectionParams;

class AndroidHttpClientImpl
  implements TDHttpClient
{
  private static final String TAG = StringUtils.getLogTag(AndroidHttpClientImpl.class);
  Context m_context;
  boolean m_enablePostCompression = false;
  AndroidHttpClient m_httpClient;
  
  public void finit(Executor paramExecutor)
  {
    if (m_httpClient.getConnectionManager() != null) {
      paramExecutor.execute(new Runnable()
      {
        final AndroidHttpClient t;
        
        public void run()
        {
          if (t == null) {
            return;
          }
          try
          {
            t.close();
            t.getConnectionManager().shutdown();
            return;
          }
          catch (RuntimeException localRuntimeException)
          {
            Log.e(AndroidHttpClientImpl.TAG, "Swallowing", localRuntimeException);
          }
        }
      });
    }
  }
  
  public TDURLConnection getURLConnection(CancelState paramCancelState)
  {
    return new ApacheURLConnectionImpl(m_httpClient, paramCancelState, m_context, m_enablePostCompression);
  }
  
  public void init(Context paramContext, int paramInt, String paramString, boolean paramBoolean)
  {
    Log.d(TAG, "Creating AndroidHttpClient instance");
    m_enablePostCompression = paramBoolean;
    m_httpClient = AndroidHttpClient.newInstance(paramString, paramContext);
    m_context = paramContext;
    paramString = m_httpClient.getParams();
    HttpConnectionParams.setConnectionTimeout(paramString, paramInt);
    HttpConnectionParams.setSoTimeout(paramString, paramInt);
    HttpConnectionParams.setTcpNoDelay(paramString, true);
    HttpConnectionParams.setStaleCheckingEnabled(paramString, false);
    ApacheURLConnectionImpl.setSSLSocketFactory(paramContext, m_httpClient, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.threatmetrix.TrustDefenderMobile.AndroidHttpClientImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */