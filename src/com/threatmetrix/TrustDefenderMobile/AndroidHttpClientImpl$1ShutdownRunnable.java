package com.threatmetrix.TrustDefenderMobile;

import android.net.http.AndroidHttpClient;
import android.util.Log;
import org.apache.http.conn.ClientConnectionManager;

final class AndroidHttpClientImpl$1ShutdownRunnable
  implements Runnable
{
  final AndroidHttpClient t;
  
  AndroidHttpClientImpl$1ShutdownRunnable(AndroidHttpClientImpl paramAndroidHttpClientImpl, AndroidHttpClient paramAndroidHttpClient)
  {
    t = paramAndroidHttpClient;
  }
  
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
      Log.e(AndroidHttpClientImpl.access$000(), "Swallowing", localRuntimeException);
    }
  }
}

/* Location:
 * Qualified Name:     com.threatmetrix.TrustDefenderMobile.AndroidHttpClientImpl.1ShutdownRunnable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */