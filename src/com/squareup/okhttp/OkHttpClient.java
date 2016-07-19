package com.squareup.okhttp;

import com.squareup.okhttp.internal.Internal;
import com.squareup.okhttp.internal.InternalCache;
import com.squareup.okhttp.internal.RouteDatabase;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.http.AuthenticatorAdapter;
import com.squareup.okhttp.internal.http.HttpEngine;
import com.squareup.okhttp.internal.http.StreamAllocation;
import com.squareup.okhttp.internal.io.RealConnection;
import com.squareup.okhttp.internal.tls.OkHostnameVerifier;
import java.net.CookieHandler;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class OkHttpClient
  implements Cloneable
{
  private static final List<ConnectionSpec> DEFAULT_CONNECTION_SPECS;
  private static final List<Protocol> DEFAULT_PROTOCOLS = Util.immutableList(new Protocol[] { Protocol.HTTP_2, Protocol.SPDY_3, Protocol.HTTP_1_1 });
  private static SSLSocketFactory defaultSslSocketFactory;
  private Authenticator authenticator;
  private Cache cache;
  private CertificatePinner certificatePinner;
  private int connectTimeout = 10000;
  private ConnectionPool connectionPool;
  private List<ConnectionSpec> connectionSpecs;
  private CookieHandler cookieHandler;
  private Dispatcher dispatcher;
  private Dns dns;
  private boolean followRedirects = true;
  private boolean followSslRedirects = true;
  private HostnameVerifier hostnameVerifier;
  private final List<Interceptor> interceptors = new ArrayList();
  private InternalCache internalCache;
  private final List<Interceptor> networkInterceptors = new ArrayList();
  private List<Protocol> protocols;
  private Proxy proxy;
  private ProxySelector proxySelector;
  private int readTimeout = 10000;
  private boolean retryOnConnectionFailure = true;
  private final RouteDatabase routeDatabase;
  private SocketFactory socketFactory;
  private SSLSocketFactory sslSocketFactory;
  private int writeTimeout = 10000;
  
  static
  {
    DEFAULT_CONNECTION_SPECS = Util.immutableList(new ConnectionSpec[] { ConnectionSpec.MODERN_TLS, ConnectionSpec.COMPATIBLE_TLS, ConnectionSpec.CLEARTEXT });
    Internal.instance = new Internal()
    {
      public void addLenient(Headers.Builder paramAnonymousBuilder, String paramAnonymousString)
      {
        paramAnonymousBuilder.addLenient(paramAnonymousString);
      }
      
      public void addLenient(Headers.Builder paramAnonymousBuilder, String paramAnonymousString1, String paramAnonymousString2)
      {
        paramAnonymousBuilder.addLenient(paramAnonymousString1, paramAnonymousString2);
      }
      
      public void apply(ConnectionSpec paramAnonymousConnectionSpec, SSLSocket paramAnonymousSSLSocket, boolean paramAnonymousBoolean)
      {
        paramAnonymousConnectionSpec.apply(paramAnonymousSSLSocket, paramAnonymousBoolean);
      }
      
      public StreamAllocation callEngineGetStreamAllocation(Call paramAnonymousCall)
      {
        return engine.streamAllocation;
      }
      
      public void callEnqueue(Call paramAnonymousCall, Callback paramAnonymousCallback, boolean paramAnonymousBoolean)
      {
        paramAnonymousCall.enqueue(paramAnonymousCallback, paramAnonymousBoolean);
      }
      
      public boolean connectionBecameIdle(ConnectionPool paramAnonymousConnectionPool, RealConnection paramAnonymousRealConnection)
      {
        return paramAnonymousConnectionPool.connectionBecameIdle(paramAnonymousRealConnection);
      }
      
      public RealConnection get(ConnectionPool paramAnonymousConnectionPool, Address paramAnonymousAddress, StreamAllocation paramAnonymousStreamAllocation)
      {
        return paramAnonymousConnectionPool.get(paramAnonymousAddress, paramAnonymousStreamAllocation);
      }
      
      public HttpUrl getHttpUrlChecked(String paramAnonymousString)
        throws MalformedURLException, UnknownHostException
      {
        return HttpUrl.getChecked(paramAnonymousString);
      }
      
      public InternalCache internalCache(OkHttpClient paramAnonymousOkHttpClient)
      {
        return paramAnonymousOkHttpClient.internalCache();
      }
      
      public void put(ConnectionPool paramAnonymousConnectionPool, RealConnection paramAnonymousRealConnection)
      {
        paramAnonymousConnectionPool.put(paramAnonymousRealConnection);
      }
      
      public RouteDatabase routeDatabase(ConnectionPool paramAnonymousConnectionPool)
      {
        return routeDatabase;
      }
      
      public void setCache(OkHttpClient paramAnonymousOkHttpClient, InternalCache paramAnonymousInternalCache)
      {
        paramAnonymousOkHttpClient.setInternalCache(paramAnonymousInternalCache);
      }
    };
  }
  
  public OkHttpClient()
  {
    routeDatabase = new RouteDatabase();
    dispatcher = new Dispatcher();
  }
  
  private OkHttpClient(OkHttpClient paramOkHttpClient)
  {
    routeDatabase = routeDatabase;
    dispatcher = dispatcher;
    proxy = proxy;
    protocols = protocols;
    connectionSpecs = connectionSpecs;
    interceptors.addAll(interceptors);
    networkInterceptors.addAll(networkInterceptors);
    proxySelector = proxySelector;
    cookieHandler = cookieHandler;
    cache = cache;
    if (cache != null) {}
    for (InternalCache localInternalCache = cache.internalCache;; localInternalCache = internalCache)
    {
      internalCache = localInternalCache;
      socketFactory = socketFactory;
      sslSocketFactory = sslSocketFactory;
      hostnameVerifier = hostnameVerifier;
      certificatePinner = certificatePinner;
      authenticator = authenticator;
      connectionPool = connectionPool;
      dns = dns;
      followSslRedirects = followSslRedirects;
      followRedirects = followRedirects;
      retryOnConnectionFailure = retryOnConnectionFailure;
      connectTimeout = connectTimeout;
      readTimeout = readTimeout;
      writeTimeout = writeTimeout;
      return;
    }
  }
  
  /* Error */
  private SSLSocketFactory getDefaultSSLSocketFactory()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 175	com/squareup/okhttp/OkHttpClient:defaultSslSocketFactory	Ljavax/net/ssl/SSLSocketFactory;
    //   5: astore_1
    //   6: aload_1
    //   7: ifnonnull +23 -> 30
    //   10: ldc -79
    //   12: invokestatic 183	javax/net/ssl/SSLContext:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   15: astore_1
    //   16: aload_1
    //   17: aconst_null
    //   18: aconst_null
    //   19: aconst_null
    //   20: invokevirtual 187	javax/net/ssl/SSLContext:init	([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V
    //   23: aload_1
    //   24: invokevirtual 190	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   27: putstatic 175	com/squareup/okhttp/OkHttpClient:defaultSslSocketFactory	Ljavax/net/ssl/SSLSocketFactory;
    //   30: getstatic 175	com/squareup/okhttp/OkHttpClient:defaultSslSocketFactory	Ljavax/net/ssl/SSLSocketFactory;
    //   33: astore_1
    //   34: aload_0
    //   35: monitorexit
    //   36: aload_1
    //   37: areturn
    //   38: astore_1
    //   39: new 192	java/lang/AssertionError
    //   42: dup
    //   43: invokespecial 193	java/lang/AssertionError:<init>	()V
    //   46: athrow
    //   47: astore_1
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_1
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	OkHttpClient
    //   5	32	1	localObject1	Object
    //   38	1	1	localGeneralSecurityException	java.security.GeneralSecurityException
    //   47	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   10	30	38	java/security/GeneralSecurityException
    //   2	6	47	finally
    //   10	30	47	finally
    //   30	34	47	finally
    //   39	47	47	finally
  }
  
  public OkHttpClient cancel(Object paramObject)
  {
    getDispatcher().cancel(paramObject);
    return this;
  }
  
  public OkHttpClient clone()
  {
    return new OkHttpClient(this);
  }
  
  OkHttpClient copyWithDefaults()
  {
    OkHttpClient localOkHttpClient = new OkHttpClient(this);
    if (proxySelector == null) {
      proxySelector = ProxySelector.getDefault();
    }
    if (cookieHandler == null) {
      cookieHandler = CookieHandler.getDefault();
    }
    if (socketFactory == null) {
      socketFactory = SocketFactory.getDefault();
    }
    if (sslSocketFactory == null) {
      sslSocketFactory = getDefaultSSLSocketFactory();
    }
    if (hostnameVerifier == null) {
      hostnameVerifier = OkHostnameVerifier.INSTANCE;
    }
    if (certificatePinner == null) {
      certificatePinner = CertificatePinner.DEFAULT;
    }
    if (authenticator == null) {
      authenticator = AuthenticatorAdapter.INSTANCE;
    }
    if (connectionPool == null) {
      connectionPool = ConnectionPool.getDefault();
    }
    if (protocols == null) {
      protocols = DEFAULT_PROTOCOLS;
    }
    if (connectionSpecs == null) {
      connectionSpecs = DEFAULT_CONNECTION_SPECS;
    }
    if (dns == null) {
      dns = Dns.SYSTEM;
    }
    return localOkHttpClient;
  }
  
  public Authenticator getAuthenticator()
  {
    return authenticator;
  }
  
  public Cache getCache()
  {
    return cache;
  }
  
  public CertificatePinner getCertificatePinner()
  {
    return certificatePinner;
  }
  
  public int getConnectTimeout()
  {
    return connectTimeout;
  }
  
  public ConnectionPool getConnectionPool()
  {
    return connectionPool;
  }
  
  public List<ConnectionSpec> getConnectionSpecs()
  {
    return connectionSpecs;
  }
  
  public CookieHandler getCookieHandler()
  {
    return cookieHandler;
  }
  
  public Dispatcher getDispatcher()
  {
    return dispatcher;
  }
  
  public Dns getDns()
  {
    return dns;
  }
  
  public boolean getFollowRedirects()
  {
    return followRedirects;
  }
  
  public boolean getFollowSslRedirects()
  {
    return followSslRedirects;
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
  
  public int getReadTimeout()
  {
    return readTimeout;
  }
  
  public boolean getRetryOnConnectionFailure()
  {
    return retryOnConnectionFailure;
  }
  
  public SocketFactory getSocketFactory()
  {
    return socketFactory;
  }
  
  public SSLSocketFactory getSslSocketFactory()
  {
    return sslSocketFactory;
  }
  
  public int getWriteTimeout()
  {
    return writeTimeout;
  }
  
  public List<Interceptor> interceptors()
  {
    return interceptors;
  }
  
  InternalCache internalCache()
  {
    return internalCache;
  }
  
  public List<Interceptor> networkInterceptors()
  {
    return networkInterceptors;
  }
  
  public Call newCall(Request paramRequest)
  {
    return new Call(this, paramRequest);
  }
  
  RouteDatabase routeDatabase()
  {
    return routeDatabase;
  }
  
  public OkHttpClient setAuthenticator(Authenticator paramAuthenticator)
  {
    authenticator = paramAuthenticator;
    return this;
  }
  
  public OkHttpClient setCache(Cache paramCache)
  {
    cache = paramCache;
    internalCache = null;
    return this;
  }
  
  public OkHttpClient setCertificatePinner(CertificatePinner paramCertificatePinner)
  {
    certificatePinner = paramCertificatePinner;
    return this;
  }
  
  public void setConnectTimeout(long paramLong, TimeUnit paramTimeUnit)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("timeout < 0");
    }
    if (paramTimeUnit == null) {
      throw new IllegalArgumentException("unit == null");
    }
    long l = paramTimeUnit.toMillis(paramLong);
    if (l > 2147483647L) {
      throw new IllegalArgumentException("Timeout too large.");
    }
    if ((l == 0L) && (paramLong > 0L)) {
      throw new IllegalArgumentException("Timeout too small.");
    }
    connectTimeout = ((int)l);
  }
  
  public OkHttpClient setConnectionPool(ConnectionPool paramConnectionPool)
  {
    connectionPool = paramConnectionPool;
    return this;
  }
  
  public OkHttpClient setConnectionSpecs(List<ConnectionSpec> paramList)
  {
    connectionSpecs = Util.immutableList(paramList);
    return this;
  }
  
  public OkHttpClient setCookieHandler(CookieHandler paramCookieHandler)
  {
    cookieHandler = paramCookieHandler;
    return this;
  }
  
  public OkHttpClient setDispatcher(Dispatcher paramDispatcher)
  {
    if (paramDispatcher == null) {
      throw new IllegalArgumentException("dispatcher == null");
    }
    dispatcher = paramDispatcher;
    return this;
  }
  
  public OkHttpClient setDns(Dns paramDns)
  {
    dns = paramDns;
    return this;
  }
  
  public void setFollowRedirects(boolean paramBoolean)
  {
    followRedirects = paramBoolean;
  }
  
  public OkHttpClient setFollowSslRedirects(boolean paramBoolean)
  {
    followSslRedirects = paramBoolean;
    return this;
  }
  
  public OkHttpClient setHostnameVerifier(HostnameVerifier paramHostnameVerifier)
  {
    hostnameVerifier = paramHostnameVerifier;
    return this;
  }
  
  void setInternalCache(InternalCache paramInternalCache)
  {
    internalCache = paramInternalCache;
    cache = null;
  }
  
  public OkHttpClient setProtocols(List<Protocol> paramList)
  {
    paramList = Util.immutableList(paramList);
    if (!paramList.contains(Protocol.HTTP_1_1)) {
      throw new IllegalArgumentException("protocols doesn't contain http/1.1: " + paramList);
    }
    if (paramList.contains(Protocol.HTTP_1_0)) {
      throw new IllegalArgumentException("protocols must not contain http/1.0: " + paramList);
    }
    if (paramList.contains(null)) {
      throw new IllegalArgumentException("protocols must not contain null");
    }
    protocols = Util.immutableList(paramList);
    return this;
  }
  
  public OkHttpClient setProxy(Proxy paramProxy)
  {
    proxy = paramProxy;
    return this;
  }
  
  public OkHttpClient setProxySelector(ProxySelector paramProxySelector)
  {
    proxySelector = paramProxySelector;
    return this;
  }
  
  public void setReadTimeout(long paramLong, TimeUnit paramTimeUnit)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("timeout < 0");
    }
    if (paramTimeUnit == null) {
      throw new IllegalArgumentException("unit == null");
    }
    long l = paramTimeUnit.toMillis(paramLong);
    if (l > 2147483647L) {
      throw new IllegalArgumentException("Timeout too large.");
    }
    if ((l == 0L) && (paramLong > 0L)) {
      throw new IllegalArgumentException("Timeout too small.");
    }
    readTimeout = ((int)l);
  }
  
  public void setRetryOnConnectionFailure(boolean paramBoolean)
  {
    retryOnConnectionFailure = paramBoolean;
  }
  
  public OkHttpClient setSocketFactory(SocketFactory paramSocketFactory)
  {
    socketFactory = paramSocketFactory;
    return this;
  }
  
  public OkHttpClient setSslSocketFactory(SSLSocketFactory paramSSLSocketFactory)
  {
    sslSocketFactory = paramSSLSocketFactory;
    return this;
  }
  
  public void setWriteTimeout(long paramLong, TimeUnit paramTimeUnit)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("timeout < 0");
    }
    if (paramTimeUnit == null) {
      throw new IllegalArgumentException("unit == null");
    }
    long l = paramTimeUnit.toMillis(paramLong);
    if (l > 2147483647L) {
      throw new IllegalArgumentException("Timeout too large.");
    }
    if ((l == 0L) && (paramLong > 0L)) {
      throw new IllegalArgumentException("Timeout too small.");
    }
    writeTimeout = ((int)l);
  }
}

/* Location:
 * Qualified Name:     com.squareup.okhttp.OkHttpClient
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */