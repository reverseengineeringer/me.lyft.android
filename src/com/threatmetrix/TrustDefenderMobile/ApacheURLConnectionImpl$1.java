package com.threatmetrix.TrustDefenderMobile;

import android.content.Context;
import android.net.SSLCertificateSocketFactory;
import android.net.SSLSessionCache;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.InetAddress;
import java.net.Socket;
import org.apache.http.conn.scheme.LayeredSocketFactory;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.params.HttpParams;

final class ApacheURLConnectionImpl$1
  implements LayeredSocketFactory
{
  final SSLSocketFactory delegate = SSLCertificateSocketFactory.getHttpSocketFactory(val$timeout_ms, new SSLSessionCache(val$context));
  
  ApacheURLConnectionImpl$1(int paramInt, Context paramContext) {}
  
  private void injectHostname(Socket paramSocket, String paramString)
  {
    try
    {
      Field localField = InetAddress.class.getDeclaredField("hostName");
      localField.setAccessible(true);
      localField.set(paramSocket.getInetAddress(), paramString);
      return;
    }
    catch (Exception paramSocket) {}
  }
  
  public Socket connectSocket(Socket paramSocket, String paramString, int paramInt1, InetAddress paramInetAddress, int paramInt2, HttpParams paramHttpParams)
    throws IOException
  {
    return delegate.connectSocket(paramSocket, paramString, paramInt1, paramInetAddress, paramInt2, paramHttpParams);
  }
  
  public Socket createSocket()
    throws IOException
  {
    return delegate.createSocket();
  }
  
  public Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean)
    throws IOException
  {
    injectHostname(paramSocket, paramString);
    return delegate.createSocket(paramSocket, paramString, paramInt, paramBoolean);
  }
  
  public boolean isSecure(Socket paramSocket)
    throws IllegalArgumentException
  {
    return delegate.isSecure(paramSocket);
  }
}

/* Location:
 * Qualified Name:     com.threatmetrix.TrustDefenderMobile.ApacheURLConnectionImpl.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */