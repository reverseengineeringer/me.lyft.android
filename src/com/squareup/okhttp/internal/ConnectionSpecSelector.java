package com.squareup.okhttp.internal;

import com.squareup.okhttp.ConnectionSpec;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSocket;

public final class ConnectionSpecSelector
{
  private final List<ConnectionSpec> connectionSpecs;
  private boolean isFallback;
  private boolean isFallbackPossible;
  private int nextModeIndex = 0;
  
  public ConnectionSpecSelector(List<ConnectionSpec> paramList)
  {
    connectionSpecs = paramList;
  }
  
  private boolean isFallbackPossible(SSLSocket paramSSLSocket)
  {
    int i = nextModeIndex;
    while (i < connectionSpecs.size())
    {
      if (((ConnectionSpec)connectionSpecs.get(i)).isCompatible(paramSSLSocket)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public ConnectionSpec configureSecureSocket(SSLSocket paramSSLSocket)
    throws IOException
  {
    Object localObject2 = null;
    int i = nextModeIndex;
    int j = connectionSpecs.size();
    Object localObject1;
    for (;;)
    {
      localObject1 = localObject2;
      if (i < j)
      {
        localObject1 = (ConnectionSpec)connectionSpecs.get(i);
        if (((ConnectionSpec)localObject1).isCompatible(paramSSLSocket)) {
          nextModeIndex = (i + 1);
        }
      }
      else
      {
        if (localObject1 != null) {
          break;
        }
        throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + isFallback + ", modes=" + connectionSpecs + ", supported protocols=" + Arrays.toString(paramSSLSocket.getEnabledProtocols()));
      }
      i += 1;
    }
    isFallbackPossible = isFallbackPossible(paramSSLSocket);
    Internal.instance.apply((ConnectionSpec)localObject1, paramSSLSocket, isFallback);
    return (ConnectionSpec)localObject1;
  }
  
  public boolean connectionFailed(IOException paramIOException)
  {
    isFallback = true;
    if (!isFallbackPossible) {}
    while (((paramIOException instanceof ProtocolException)) || ((paramIOException instanceof InterruptedIOException)) || (((paramIOException instanceof SSLHandshakeException)) && ((paramIOException.getCause() instanceof CertificateException))) || ((paramIOException instanceof SSLPeerUnverifiedException)) || ((!(paramIOException instanceof SSLHandshakeException)) && (!(paramIOException instanceof SSLProtocolException)))) {
      return false;
    }
    return true;
  }
}

/* Location:
 * Qualified Name:     com.squareup.okhttp.internal.ConnectionSpecSelector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */