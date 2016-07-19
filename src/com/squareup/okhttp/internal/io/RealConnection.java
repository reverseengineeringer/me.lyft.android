package com.squareup.okhttp.internal.io;

import com.squareup.okhttp.Address;
import com.squareup.okhttp.CertificatePinner;
import com.squareup.okhttp.Connection;
import com.squareup.okhttp.ConnectionSpec;
import com.squareup.okhttp.Handshake;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Request.Builder;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.Response.Builder;
import com.squareup.okhttp.Route;
import com.squareup.okhttp.internal.ConnectionSpecSelector;
import com.squareup.okhttp.internal.Platform;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.Version;
import com.squareup.okhttp.internal.framed.FramedConnection;
import com.squareup.okhttp.internal.framed.FramedConnection.Builder;
import com.squareup.okhttp.internal.http.Http1xStream;
import com.squareup.okhttp.internal.http.OkHeaders;
import com.squareup.okhttp.internal.http.RouteException;
import com.squareup.okhttp.internal.http.StreamAllocation;
import com.squareup.okhttp.internal.tls.OkHostnameVerifier;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownServiceException;
import java.security.Principal;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Source;
import okio.Timeout;

public final class RealConnection
  implements Connection
{
  public final List<Reference<StreamAllocation>> allocations = new ArrayList();
  public volatile FramedConnection framedConnection;
  private Handshake handshake;
  public long idleAtNanos = Long.MAX_VALUE;
  public boolean noNewStreams;
  private Protocol protocol;
  private Socket rawSocket;
  private final Route route;
  public BufferedSink sink;
  public Socket socket;
  public BufferedSource source;
  public int streamCount;
  
  public RealConnection(Route paramRoute)
  {
    route = paramRoute;
  }
  
  private void connectSocket(int paramInt1, int paramInt2, int paramInt3, ConnectionSpecSelector paramConnectionSpecSelector)
    throws IOException
  {
    rawSocket.setSoTimeout(paramInt2);
    for (;;)
    {
      try
      {
        Platform.get().connectSocket(rawSocket, route.getSocketAddress(), paramInt1);
        source = Okio.buffer(Okio.source(rawSocket));
        sink = Okio.buffer(Okio.sink(rawSocket));
        if (route.getAddress().getSslSocketFactory() != null)
        {
          connectTls(paramInt2, paramInt3, paramConnectionSpecSelector);
          if ((protocol == Protocol.SPDY_3) || (protocol == Protocol.HTTP_2))
          {
            socket.setSoTimeout(0);
            paramConnectionSpecSelector = new FramedConnection.Builder(true).socket(socket, route.getAddress().url().host(), source, sink).protocol(protocol).build();
            paramConnectionSpecSelector.sendConnectionPreface();
            framedConnection = paramConnectionSpecSelector;
          }
          return;
        }
      }
      catch (ConnectException paramConnectionSpecSelector)
      {
        throw new ConnectException("Failed to connect to " + route.getSocketAddress());
      }
      protocol = Protocol.HTTP_1_1;
      socket = rawSocket;
    }
  }
  
  private void connectTls(int paramInt1, int paramInt2, ConnectionSpecSelector paramConnectionSpecSelector)
    throws IOException
  {
    if (route.requiresTunnel()) {
      createTunnel(paramInt1, paramInt2);
    }
    Address localAddress = route.getAddress();
    Object localObject3 = localAddress.getSslSocketFactory();
    Object localObject2 = null;
    Object localObject1 = null;
    Handshake localHandshake;
    try
    {
      localObject3 = (SSLSocket)((SSLSocketFactory)localObject3).createSocket(rawSocket, localAddress.getUriHost(), localAddress.getUriPort(), true);
      localObject1 = localObject3;
      localObject2 = localObject3;
      paramConnectionSpecSelector = paramConnectionSpecSelector.configureSecureSocket((SSLSocket)localObject3);
      localObject1 = localObject3;
      localObject2 = localObject3;
      if (paramConnectionSpecSelector.supportsTlsExtensions())
      {
        localObject1 = localObject3;
        localObject2 = localObject3;
        Platform.get().configureTlsExtensions((SSLSocket)localObject3, localAddress.getUriHost(), localAddress.getProtocols());
      }
      localObject1 = localObject3;
      localObject2 = localObject3;
      ((SSLSocket)localObject3).startHandshake();
      localObject1 = localObject3;
      localObject2 = localObject3;
      localHandshake = Handshake.get(((SSLSocket)localObject3).getSession());
      localObject1 = localObject3;
      localObject2 = localObject3;
      if (!localAddress.getHostnameVerifier().verify(localAddress.getUriHost(), ((SSLSocket)localObject3).getSession()))
      {
        localObject1 = localObject3;
        localObject2 = localObject3;
        paramConnectionSpecSelector = (X509Certificate)localHandshake.peerCertificates().get(0);
        localObject1 = localObject3;
        localObject2 = localObject3;
        throw new SSLPeerUnverifiedException("Hostname " + localAddress.getUriHost() + " not verified:" + "\n    certificate: " + CertificatePinner.pin(paramConnectionSpecSelector) + "\n    DN: " + paramConnectionSpecSelector.getSubjectDN().getName() + "\n    subjectAltNames: " + OkHostnameVerifier.allSubjectAltNames(paramConnectionSpecSelector));
      }
    }
    catch (AssertionError paramConnectionSpecSelector)
    {
      localObject2 = localObject1;
      if (!Util.isAndroidGetsocknameError(paramConnectionSpecSelector)) {
        break label546;
      }
      localObject2 = localObject1;
      throw new IOException(paramConnectionSpecSelector);
    }
    finally
    {
      if (localObject2 != null) {
        Platform.get().afterHandshake((SSLSocket)localObject2);
      }
      if (0 == 0) {
        Util.closeQuietly((Socket)localObject2);
      }
    }
    localObject1 = localObject3;
    localObject2 = localObject3;
    localAddress.getCertificatePinner().check(localAddress.getUriHost(), localHandshake.peerCertificates());
    localObject1 = localObject3;
    localObject2 = localObject3;
    if (paramConnectionSpecSelector.supportsTlsExtensions())
    {
      localObject1 = localObject3;
      localObject2 = localObject3;
      paramConnectionSpecSelector = Platform.get().getSelectedProtocol((SSLSocket)localObject3);
      localObject1 = localObject3;
      localObject2 = localObject3;
      socket = ((Socket)localObject3);
      localObject1 = localObject3;
      localObject2 = localObject3;
      source = Okio.buffer(Okio.source(socket));
      localObject1 = localObject3;
      localObject2 = localObject3;
      sink = Okio.buffer(Okio.sink(socket));
      localObject1 = localObject3;
      localObject2 = localObject3;
      handshake = localHandshake;
      if (paramConnectionSpecSelector == null) {
        break label531;
      }
      localObject1 = localObject3;
      localObject2 = localObject3;
    }
    for (paramConnectionSpecSelector = Protocol.get(paramConnectionSpecSelector);; paramConnectionSpecSelector = Protocol.HTTP_1_1)
    {
      localObject1 = localObject3;
      localObject2 = localObject3;
      protocol = paramConnectionSpecSelector;
      if (localObject3 != null) {
        Platform.get().afterHandshake((SSLSocket)localObject3);
      }
      if (1 == 0) {
        Util.closeQuietly((Socket)localObject3);
      }
      return;
      paramConnectionSpecSelector = null;
      break;
      label531:
      localObject1 = localObject3;
      localObject2 = localObject3;
    }
    label546:
    localObject2 = localObject1;
    throw paramConnectionSpecSelector;
  }
  
  private void createTunnel(int paramInt1, int paramInt2)
    throws IOException
  {
    Object localObject1 = createTunnelRequest();
    Object localObject2 = ((Request)localObject1).httpUrl();
    String str = "CONNECT " + ((HttpUrl)localObject2).host() + ":" + ((HttpUrl)localObject2).port() + " HTTP/1.1";
    do
    {
      localObject2 = new Http1xStream(null, source, sink);
      source.timeout().timeout(paramInt1, TimeUnit.MILLISECONDS);
      sink.timeout().timeout(paramInt2, TimeUnit.MILLISECONDS);
      ((Http1xStream)localObject2).writeRequest(((Request)localObject1).headers(), str);
      ((Http1xStream)localObject2).finishRequest();
      localObject1 = ((Http1xStream)localObject2).readResponse().request((Request)localObject1).build();
      long l2 = OkHeaders.contentLength((Response)localObject1);
      long l1 = l2;
      if (l2 == -1L) {
        l1 = 0L;
      }
      localObject2 = ((Http1xStream)localObject2).newFixedLengthSource(l1);
      Util.skipAll((Source)localObject2, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
      ((Source)localObject2).close();
      switch (((Response)localObject1).code())
      {
      default: 
        throw new IOException("Unexpected response code for CONNECT: " + ((Response)localObject1).code());
      case 200: 
        if ((source.buffer().exhausted()) && (sink.buffer().exhausted())) {
          break;
        }
        throw new IOException("TLS tunnel buffered too many bytes!");
      case 407: 
        localObject2 = OkHeaders.processAuthHeader(route.getAddress().getAuthenticator(), (Response)localObject1, route.getProxy());
        localObject1 = localObject2;
      }
    } while (localObject2 != null);
    throw new IOException("Failed to authenticate with proxy");
  }
  
  private Request createTunnelRequest()
    throws IOException
  {
    return new Request.Builder().url(route.getAddress().url()).header("Host", Util.hostHeader(route.getAddress().url())).header("Proxy-Connection", "Keep-Alive").header("User-Agent", Version.userAgent()).build();
  }
  
  public int allocationLimit()
  {
    FramedConnection localFramedConnection = framedConnection;
    if (localFramedConnection != null) {
      return localFramedConnection.maxConcurrentStreams();
    }
    return 1;
  }
  
  public void cancel()
  {
    Util.closeQuietly(rawSocket);
  }
  
  public void connect(int paramInt1, int paramInt2, int paramInt3, List<ConnectionSpec> paramList, boolean paramBoolean)
    throws RouteException
  {
    if (protocol != null) {
      throw new IllegalStateException("already connected");
    }
    Object localObject2 = null;
    ConnectionSpecSelector localConnectionSpecSelector = new ConnectionSpecSelector(paramList);
    Proxy localProxy = route.getProxy();
    Address localAddress = route.getAddress();
    Object localObject1 = localObject2;
    if (route.getAddress().getSslSocketFactory() == null)
    {
      localObject1 = localObject2;
      if (!paramList.contains(ConnectionSpec.CLEARTEXT)) {
        throw new RouteException(new UnknownServiceException("CLEARTEXT communication not supported: " + paramList));
      }
    }
    for (;;)
    {
      try
      {
        paramList = new Socket(localProxy);
        rawSocket = paramList;
        connectSocket(paramInt1, paramInt2, paramInt3, localConnectionSpecSelector);
      }
      catch (IOException localIOException)
      {
        Util.closeQuietly(socket);
        Util.closeQuietly(rawSocket);
        socket = null;
        rawSocket = null;
        source = null;
        sink = null;
        handshake = null;
        protocol = null;
        if (localObject1 != null) {
          continue;
        }
        paramList = new RouteException(localIOException);
        if (!paramBoolean) {
          continue;
        }
        localObject1 = paramList;
        if (localConnectionSpecSelector.connectionFailed(localIOException)) {
          continue;
        }
        throw paramList;
        ((RouteException)localObject1).addConnectException(localIOException);
        paramList = (List<ConnectionSpec>)localObject1;
        continue;
      }
      if (protocol != null) {
        return;
      }
      if ((localProxy.type() == Proxy.Type.DIRECT) || (localProxy.type() == Proxy.Type.HTTP)) {
        paramList = localAddress.getSocketFactory().createSocket();
      }
    }
  }
  
  public Handshake getHandshake()
  {
    return handshake;
  }
  
  public Protocol getProtocol()
  {
    if (protocol != null) {
      return protocol;
    }
    return Protocol.HTTP_1_1;
  }
  
  public Route getRoute()
  {
    return route;
  }
  
  public Socket getSocket()
  {
    return socket;
  }
  
  boolean isConnected()
  {
    return protocol != null;
  }
  
  public boolean isHealthy(boolean paramBoolean)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((socket.isClosed()) || (socket.isInputShutdown()) || (socket.isOutputShutdown())) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (framedConnection != null);
      bool1 = bool2;
    } while (!paramBoolean);
    try
    {
      int i = socket.getSoTimeout();
      try
      {
        socket.setSoTimeout(1);
        paramBoolean = source.exhausted();
        return !paramBoolean;
      }
      finally
      {
        socket.setSoTimeout(i);
      }
      return true;
    }
    catch (IOException localIOException)
    {
      return false;
    }
    catch (SocketTimeoutException localSocketTimeoutException) {}
  }
  
  public boolean isMultiplexed()
  {
    return framedConnection != null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("Connection{").append(route.getAddress().url().host()).append(":").append(route.getAddress().url().port()).append(", proxy=").append(route.getProxy()).append(" hostAddress=").append(route.getSocketAddress()).append(" cipherSuite=");
    if (handshake != null) {}
    for (String str = handshake.cipherSuite();; str = "none") {
      return str + " protocol=" + protocol + '}';
    }
  }
}

/* Location:
 * Qualified Name:     com.squareup.okhttp.internal.io.RealConnection
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */