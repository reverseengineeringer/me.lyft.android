package com.squareup.okhttp;

import com.squareup.okhttp.internal.Util;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

public final class Address
{
  final Authenticator authenticator;
  final CertificatePinner certificatePinner;
  final List<ConnectionSpec> connectionSpecs;
  final Dns dns;
  final HostnameVerifier hostnameVerifier;
  final List<Protocol> protocols;
  final Proxy proxy;
  final ProxySelector proxySelector;
  final SocketFactory socketFactory;
  final SSLSocketFactory sslSocketFactory;
  final HttpUrl url;
  
  public Address(String paramString, int paramInt, Dns paramDns, SocketFactory paramSocketFactory, SSLSocketFactory paramSSLSocketFactory, HostnameVerifier paramHostnameVerifier, CertificatePinner paramCertificatePinner, Authenticator paramAuthenticator, Proxy paramProxy, List<Protocol> paramList, List<ConnectionSpec> paramList1, ProxySelector paramProxySelector)
  {
    HttpUrl.Builder localBuilder = new HttpUrl.Builder();
    if (paramSSLSocketFactory != null) {}
    for (String str = "https";; str = "http")
    {
      url = localBuilder.scheme(str).host(paramString).port(paramInt).build();
      if (paramDns != null) {
        break;
      }
      throw new IllegalArgumentException("dns == null");
    }
    dns = paramDns;
    if (paramSocketFactory == null) {
      throw new IllegalArgumentException("socketFactory == null");
    }
    socketFactory = paramSocketFactory;
    if (paramAuthenticator == null) {
      throw new IllegalArgumentException("authenticator == null");
    }
    authenticator = paramAuthenticator;
    if (paramList == null) {
      throw new IllegalArgumentException("protocols == null");
    }
    protocols = Util.immutableList(paramList);
    if (paramList1 == null) {
      throw new IllegalArgumentException("connectionSpecs == null");
    }
    connectionSpecs = Util.immutableList(paramList1);
    if (paramProxySelector == null) {
      throw new IllegalArgumentException("proxySelector == null");
    }
    proxySelector = paramProxySelector;
    proxy = paramProxy;
    sslSocketFactory = paramSSLSocketFactory;
    hostnameVerifier = paramHostnameVerifier;
    certificatePinner = paramCertificatePinner;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof Address))
    {
      paramObject = (Address)paramObject;
      bool1 = bool2;
      if (url.equals(url))
      {
        bool1 = bool2;
        if (dns.equals(dns))
        {
          bool1 = bool2;
          if (authenticator.equals(authenticator))
          {
            bool1 = bool2;
            if (protocols.equals(protocols))
            {
              bool1 = bool2;
              if (connectionSpecs.equals(connectionSpecs))
              {
                bool1 = bool2;
                if (proxySelector.equals(proxySelector))
                {
                  bool1 = bool2;
                  if (Util.equal(proxy, proxy))
                  {
                    bool1 = bool2;
                    if (Util.equal(sslSocketFactory, sslSocketFactory))
                    {
                      bool1 = bool2;
                      if (Util.equal(hostnameVerifier, hostnameVerifier))
                      {
                        bool1 = bool2;
                        if (Util.equal(certificatePinner, certificatePinner)) {
                          bool1 = true;
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public Authenticator getAuthenticator()
  {
    return authenticator;
  }
  
  public CertificatePinner getCertificatePinner()
  {
    return certificatePinner;
  }
  
  public List<ConnectionSpec> getConnectionSpecs()
  {
    return connectionSpecs;
  }
  
  public Dns getDns()
  {
    return dns;
  }
  
  public HostnameVerifier getHostnameVerifier()
  {
    return hostnameVerifier;
  }
  
  public List<Protocol> getProtocols()
  {
    return protocols;
  }
  
  public Proxy getProxy()
  {
    return proxy;
  }
  
  public ProxySelector getProxySelector()
  {
    return proxySelector;
  }
  
  public SocketFactory getSocketFactory()
  {
    return socketFactory;
  }
  
  public SSLSocketFactory getSslSocketFactory()
  {
    return sslSocketFactory;
  }
  
  @Deprecated
  public String getUriHost()
  {
    return url.host();
  }
  
  @Deprecated
  public int getUriPort()
  {
    return url.port();
  }
  
  public int hashCode()
  {
    int m = 0;
    int n = url.hashCode();
    int i1 = dns.hashCode();
    int i2 = authenticator.hashCode();
    int i3 = protocols.hashCode();
    int i4 = connectionSpecs.hashCode();
    int i5 = proxySelector.hashCode();
    int i;
    int j;
    if (proxy != null)
    {
      i = proxy.hashCode();
      if (sslSocketFactory == null) {
        break label185;
      }
      j = sslSocketFactory.hashCode();
      label91:
      if (hostnameVerifier == null) {
        break label190;
      }
    }
    label185:
    label190:
    for (int k = hostnameVerifier.hashCode();; k = 0)
    {
      if (certificatePinner != null) {
        m = certificatePinner.hashCode();
      }
      return (((((((((n + 527) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + i4) * 31 + i5) * 31 + i) * 31 + j) * 31 + k) * 31 + m;
      i = 0;
      break;
      j = 0;
      break label91;
    }
  }
  
  public HttpUrl url()
  {
    return url;
  }
}

/* Location:
 * Qualified Name:     com.squareup.okhttp.Address
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */