package com.squareup.okhttp.internal;

import android.util.Log;
import com.squareup.okhttp.Protocol;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.List;
import javax.net.ssl.SSLSocket;

class Platform$Android
  extends Platform
{
  private static final int MAX_LOG_LENGTH = 4000;
  private final OptionalMethod<Socket> getAlpnSelectedProtocol;
  private final OptionalMethod<Socket> setAlpnProtocols;
  private final OptionalMethod<Socket> setHostname;
  private final OptionalMethod<Socket> setUseSessionTickets;
  private final Method trafficStatsTagSocket;
  private final Method trafficStatsUntagSocket;
  
  public Platform$Android(OptionalMethod<Socket> paramOptionalMethod1, OptionalMethod<Socket> paramOptionalMethod2, Method paramMethod1, Method paramMethod2, OptionalMethod<Socket> paramOptionalMethod3, OptionalMethod<Socket> paramOptionalMethod4)
  {
    setUseSessionTickets = paramOptionalMethod1;
    setHostname = paramOptionalMethod2;
    trafficStatsTagSocket = paramMethod1;
    trafficStatsUntagSocket = paramMethod2;
    getAlpnSelectedProtocol = paramOptionalMethod3;
    setAlpnProtocols = paramOptionalMethod4;
  }
  
  public void configureTlsExtensions(SSLSocket paramSSLSocket, String paramString, List<Protocol> paramList)
  {
    if (paramString != null)
    {
      setUseSessionTickets.invokeOptionalWithoutCheckedException(paramSSLSocket, new Object[] { Boolean.valueOf(true) });
      setHostname.invokeOptionalWithoutCheckedException(paramSSLSocket, new Object[] { paramString });
    }
    if ((setAlpnProtocols != null) && (setAlpnProtocols.isSupported(paramSSLSocket)))
    {
      paramString = concatLengthPrefixed(paramList);
      setAlpnProtocols.invokeWithoutCheckedException(paramSSLSocket, new Object[] { paramString });
    }
  }
  
  public void connectSocket(Socket paramSocket, InetSocketAddress paramInetSocketAddress, int paramInt)
    throws IOException
  {
    try
    {
      paramSocket.connect(paramInetSocketAddress, paramInt);
      return;
    }
    catch (AssertionError paramSocket)
    {
      if (Util.isAndroidGetsocknameError(paramSocket)) {
        throw new IOException(paramSocket);
      }
      throw paramSocket;
    }
    catch (SecurityException paramSocket)
    {
      paramInetSocketAddress = new IOException("Exception in connect");
      paramInetSocketAddress.initCause(paramSocket);
      throw paramInetSocketAddress;
    }
  }
  
  public String getSelectedProtocol(SSLSocket paramSSLSocket)
  {
    if (getAlpnSelectedProtocol == null) {}
    while (!getAlpnSelectedProtocol.isSupported(paramSSLSocket)) {
      return null;
    }
    paramSSLSocket = (byte[])getAlpnSelectedProtocol.invokeWithoutCheckedException(paramSSLSocket, new Object[0]);
    if (paramSSLSocket != null) {}
    for (paramSSLSocket = new String(paramSSLSocket, Util.UTF_8);; paramSSLSocket = null) {
      return paramSSLSocket;
    }
  }
  
  public void log(String paramString)
  {
    int i = 0;
    int m = paramString.length();
    if (i < m)
    {
      int j = paramString.indexOf('\n', i);
      if (j != -1) {}
      for (;;)
      {
        int k = Math.min(j, i + 4000);
        Log.d("OkHttp", paramString.substring(i, k));
        i = k;
        if (k >= j)
        {
          i = k + 1;
          break;
          j = m;
        }
      }
    }
  }
  
  public void tagSocket(Socket paramSocket)
    throws SocketException
  {
    if (trafficStatsTagSocket == null) {
      return;
    }
    try
    {
      trafficStatsTagSocket.invoke(null, new Object[] { paramSocket });
      return;
    }
    catch (IllegalAccessException paramSocket)
    {
      throw new RuntimeException(paramSocket);
    }
    catch (InvocationTargetException paramSocket)
    {
      throw new RuntimeException(paramSocket.getCause());
    }
  }
  
  public void untagSocket(Socket paramSocket)
    throws SocketException
  {
    if (trafficStatsUntagSocket == null) {
      return;
    }
    try
    {
      trafficStatsUntagSocket.invoke(null, new Object[] { paramSocket });
      return;
    }
    catch (IllegalAccessException paramSocket)
    {
      throw new RuntimeException(paramSocket);
    }
    catch (InvocationTargetException paramSocket)
    {
      throw new RuntimeException(paramSocket.getCause());
    }
  }
}

/* Location:
 * Qualified Name:     com.squareup.okhttp.internal.Platform.Android
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */