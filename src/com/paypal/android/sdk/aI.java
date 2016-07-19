package com.paypal.android.sdk;

import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public final class ai
  implements X509TrustManager
{
  private X509TrustManager a = null;
  
  public ai(KeyStore paramKeyStore)
  {
    paramKeyStore = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
    paramKeyStore.init(null);
    paramKeyStore = paramKeyStore.getTrustManagers();
    if (paramKeyStore.length == 0) {
      throw new NoSuchAlgorithmException("no trust manager found");
    }
    a = ((X509TrustManager)paramKeyStore[0]);
  }
  
  public final void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
  {
    a.checkClientTrusted(paramArrayOfX509Certificate, paramString);
  }
  
  public final void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
  {
    if ((paramArrayOfX509Certificate != null) && (paramArrayOfX509Certificate.length == 1))
    {
      paramArrayOfX509Certificate[0].checkValidity();
      return;
    }
    a.checkServerTrusted(paramArrayOfX509Certificate, paramString);
  }
  
  public final X509Certificate[] getAcceptedIssuers()
  {
    return a.getAcceptedIssuers();
  }
}

/* Location:
 * Qualified Name:     com.paypal.android.sdk.ai
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */