package com.threatmetrix.TrustDefenderMobile;

import android.net.Proxy;
import java.lang.reflect.Method;

class ProxyWrapper
  extends WrapperHelper
{
  private static final String TAG = StringUtils.getLogTag(ProxyWrapper.class);
  private static final Method m_getDefaultHost = getMethod(Proxy.class, "getDefaultHost", new Class[0]);
  private static final Method m_getDefaultPort = getMethod(Proxy.class, "getDefaultPort", new Class[0]);
  private String m_host = null;
  private int m_port = 0;
  
  ProxyWrapper()
  {
    Object localObject = System.getProperty("http.proxyHost");
    if ((localObject != null) && (!((String)localObject).isEmpty())) {
      m_host = ((String)localObject);
    }
    localObject = System.getProperty("http.proxyPort");
    if ((localObject != null) && (!((String)localObject).isEmpty())) {}
    try
    {
      m_port = Integer.parseInt((String)localObject);
      if ((m_host == null) || (m_port == 0))
      {
        localObject = (Integer)invoke(null, m_getDefaultPort, new Object[0]);
        if (localObject != null) {
          m_port = ((Integer)localObject).intValue();
        }
        localObject = (String)invoke(null, m_getDefaultHost, new Object[0]);
        if (localObject != null) {
          m_host = ((String)localObject);
        }
      }
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;) {}
    }
  }
  
  String getHost()
  {
    return m_host;
  }
  
  int getPort()
  {
    return m_port;
  }
}

/* Location:
 * Qualified Name:     com.threatmetrix.TrustDefenderMobile.ProxyWrapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */