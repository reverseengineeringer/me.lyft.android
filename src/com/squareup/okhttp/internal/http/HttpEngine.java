package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Address;
import com.squareup.okhttp.CertificatePinner;
import com.squareup.okhttp.Connection;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Headers.Builder;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.Interceptor.Chain;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Request.Builder;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.Response.Builder;
import com.squareup.okhttp.ResponseBody;
import com.squareup.okhttp.Route;
import com.squareup.okhttp.internal.Internal;
import com.squareup.okhttp.internal.InternalCache;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.Version;
import com.squareup.okhttp.internal.io.RealConnection;
import java.io.IOException;
import java.net.CookieHandler;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.GzipSource;
import okio.Okio;
import okio.Sink;
import okio.Source;
import okio.Timeout;

public final class HttpEngine
{
  private static final ResponseBody EMPTY_BODY = new ResponseBody()
  {
    public long contentLength()
    {
      return 0L;
    }
    
    public MediaType contentType()
    {
      return null;
    }
    
    public BufferedSource source()
    {
      return new Buffer();
    }
  };
  public static final int MAX_FOLLOW_UPS = 20;
  public final boolean bufferRequestBody;
  private BufferedSink bufferedRequestBody;
  private Response cacheResponse;
  private CacheStrategy cacheStrategy;
  private final boolean callerWritesRequestBody;
  final OkHttpClient client;
  private final boolean forWebSocket;
  private HttpStream httpStream;
  private Request networkRequest;
  private final Response priorResponse;
  private Sink requestBodyOut;
  long sentRequestMillis = -1L;
  private CacheRequest storeRequest;
  public final StreamAllocation streamAllocation;
  private boolean transparentGzip;
  private final Request userRequest;
  private Response userResponse;
  
  public HttpEngine(OkHttpClient paramOkHttpClient, Request paramRequest, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, StreamAllocation paramStreamAllocation, RetryableSink paramRetryableSink, Response paramResponse)
  {
    client = paramOkHttpClient;
    userRequest = paramRequest;
    bufferRequestBody = paramBoolean1;
    callerWritesRequestBody = paramBoolean2;
    forWebSocket = paramBoolean3;
    if (paramStreamAllocation != null) {}
    for (;;)
    {
      streamAllocation = paramStreamAllocation;
      requestBodyOut = paramRetryableSink;
      priorResponse = paramResponse;
      return;
      paramStreamAllocation = new StreamAllocation(paramOkHttpClient.getConnectionPool(), createAddress(paramOkHttpClient, paramRequest));
    }
  }
  
  private Response cacheWritingResponse(final CacheRequest paramCacheRequest, Response paramResponse)
    throws IOException
  {
    if (paramCacheRequest == null) {}
    Sink localSink;
    do
    {
      return paramResponse;
      localSink = paramCacheRequest.body();
    } while (localSink == null);
    paramCacheRequest = new Source()
    {
      boolean cacheRequestClosed;
      
      public void close()
        throws IOException
      {
        if ((!cacheRequestClosed) && (!Util.discard(this, 100, TimeUnit.MILLISECONDS)))
        {
          cacheRequestClosed = true;
          paramCacheRequest.abort();
        }
        val$source.close();
      }
      
      public long read(Buffer paramAnonymousBuffer, long paramAnonymousLong)
        throws IOException
      {
        try
        {
          paramAnonymousLong = val$source.read(paramAnonymousBuffer, paramAnonymousLong);
          if (paramAnonymousLong == -1L)
          {
            if (!cacheRequestClosed)
            {
              cacheRequestClosed = true;
              val$cacheBody.close();
            }
            return -1L;
          }
        }
        catch (IOException paramAnonymousBuffer)
        {
          if (!cacheRequestClosed)
          {
            cacheRequestClosed = true;
            paramCacheRequest.abort();
          }
          throw paramAnonymousBuffer;
        }
        paramAnonymousBuffer.copyTo(val$cacheBody.buffer(), paramAnonymousBuffer.size() - paramAnonymousLong, paramAnonymousLong);
        val$cacheBody.emitCompleteSegments();
        return paramAnonymousLong;
      }
      
      public Timeout timeout()
      {
        return val$source.timeout();
      }
    };
    return paramResponse.newBuilder().body(new RealResponseBody(paramResponse.headers(), Okio.buffer(paramCacheRequest))).build();
  }
  
  private static Headers combine(Headers paramHeaders1, Headers paramHeaders2)
    throws IOException
  {
    Headers.Builder localBuilder = new Headers.Builder();
    int i = 0;
    int j = paramHeaders1.size();
    if (i < j)
    {
      String str1 = paramHeaders1.name(i);
      String str2 = paramHeaders1.value(i);
      if (("Warning".equalsIgnoreCase(str1)) && (str2.startsWith("1"))) {}
      for (;;)
      {
        i += 1;
        break;
        if ((!OkHeaders.isEndToEnd(str1)) || (paramHeaders2.get(str1) == null)) {
          localBuilder.add(str1, str2);
        }
      }
    }
    i = 0;
    j = paramHeaders2.size();
    if (i < j)
    {
      paramHeaders1 = paramHeaders2.name(i);
      if ("Content-Length".equalsIgnoreCase(paramHeaders1)) {}
      for (;;)
      {
        i += 1;
        break;
        if (OkHeaders.isEndToEnd(paramHeaders1)) {
          localBuilder.add(paramHeaders1, paramHeaders2.value(i));
        }
      }
    }
    return localBuilder.build();
  }
  
  private HttpStream connect()
    throws RouteException, RequestException, IOException
  {
    if (!networkRequest.method().equals("GET")) {}
    for (boolean bool = true;; bool = false) {
      return streamAllocation.newStream(client.getConnectTimeout(), client.getReadTimeout(), client.getWriteTimeout(), client.getRetryOnConnectionFailure(), bool);
    }
  }
  
  private static Address createAddress(OkHttpClient paramOkHttpClient, Request paramRequest)
  {
    SSLSocketFactory localSSLSocketFactory = null;
    HostnameVerifier localHostnameVerifier = null;
    CertificatePinner localCertificatePinner = null;
    if (paramRequest.isHttps())
    {
      localSSLSocketFactory = paramOkHttpClient.getSslSocketFactory();
      localHostnameVerifier = paramOkHttpClient.getHostnameVerifier();
      localCertificatePinner = paramOkHttpClient.getCertificatePinner();
    }
    return new Address(paramRequest.httpUrl().host(), paramRequest.httpUrl().port(), paramOkHttpClient.getDns(), paramOkHttpClient.getSocketFactory(), localSSLSocketFactory, localHostnameVerifier, localCertificatePinner, paramOkHttpClient.getAuthenticator(), paramOkHttpClient.getProxy(), paramOkHttpClient.getProtocols(), paramOkHttpClient.getConnectionSpecs(), paramOkHttpClient.getProxySelector());
  }
  
  public static boolean hasBody(Response paramResponse)
  {
    if (paramResponse.request().method().equals("HEAD")) {}
    do
    {
      return false;
      int i = paramResponse.code();
      if (((i < 100) || (i >= 200)) && (i != 204) && (i != 304)) {
        return true;
      }
    } while ((OkHeaders.contentLength(paramResponse) == -1L) && (!"chunked".equalsIgnoreCase(paramResponse.header("Transfer-Encoding"))));
    return true;
  }
  
  private void maybeCache()
    throws IOException
  {
    InternalCache localInternalCache = Internal.instance.internalCache(client);
    if (localInternalCache == null) {}
    do
    {
      return;
      if (CacheStrategy.isCacheable(userResponse, networkRequest)) {
        break;
      }
    } while (!HttpMethod.invalidatesCache(networkRequest.method()));
    try
    {
      localInternalCache.remove(networkRequest);
      return;
    }
    catch (IOException localIOException)
    {
      return;
    }
    storeRequest = localIOException.put(stripBody(userResponse));
  }
  
  private Request networkRequest(Request paramRequest)
    throws IOException
  {
    Request.Builder localBuilder = paramRequest.newBuilder();
    if (paramRequest.header("Host") == null) {
      localBuilder.header("Host", Util.hostHeader(paramRequest.httpUrl()));
    }
    if (paramRequest.header("Connection") == null) {
      localBuilder.header("Connection", "Keep-Alive");
    }
    if (paramRequest.header("Accept-Encoding") == null)
    {
      transparentGzip = true;
      localBuilder.header("Accept-Encoding", "gzip");
    }
    CookieHandler localCookieHandler = client.getCookieHandler();
    if (localCookieHandler != null)
    {
      Map localMap = OkHeaders.toMultimap(localBuilder.build().headers(), null);
      OkHeaders.addCookies(localBuilder, localCookieHandler.get(paramRequest.uri(), localMap));
    }
    if (paramRequest.header("User-Agent") == null) {
      localBuilder.header("User-Agent", Version.userAgent());
    }
    return localBuilder.build();
  }
  
  private Response readNetworkResponse()
    throws IOException
  {
    httpStream.finishRequest();
    Response localResponse2 = httpStream.readResponseHeaders().request(networkRequest).handshake(streamAllocation.connection().getHandshake()).header(OkHeaders.SENT_MILLIS, Long.toString(sentRequestMillis)).header(OkHeaders.RECEIVED_MILLIS, Long.toString(System.currentTimeMillis())).build();
    Response localResponse1 = localResponse2;
    if (!forWebSocket) {
      localResponse1 = localResponse2.newBuilder().body(httpStream.openResponseBody(localResponse2)).build();
    }
    if (("close".equalsIgnoreCase(localResponse1.request().header("Connection"))) || ("close".equalsIgnoreCase(localResponse1.header("Connection")))) {
      streamAllocation.noNewStreams();
    }
    return localResponse1;
  }
  
  private static Response stripBody(Response paramResponse)
  {
    Response localResponse = paramResponse;
    if (paramResponse != null)
    {
      localResponse = paramResponse;
      if (paramResponse.body() != null) {
        localResponse = paramResponse.newBuilder().body(null).build();
      }
    }
    return localResponse;
  }
  
  private Response unzip(Response paramResponse)
    throws IOException
  {
    if ((!transparentGzip) || (!"gzip".equalsIgnoreCase(userResponse.header("Content-Encoding")))) {}
    while (paramResponse.body() == null) {
      return paramResponse;
    }
    GzipSource localGzipSource = new GzipSource(paramResponse.body().source());
    Headers localHeaders = paramResponse.headers().newBuilder().removeAll("Content-Encoding").removeAll("Content-Length").build();
    return paramResponse.newBuilder().headers(localHeaders).body(new RealResponseBody(localHeaders, Okio.buffer(localGzipSource))).build();
  }
  
  private static boolean validate(Response paramResponse1, Response paramResponse2)
  {
    if (paramResponse2.code() == 304) {}
    do
    {
      return true;
      paramResponse1 = paramResponse1.headers().getDate("Last-Modified");
      if (paramResponse1 == null) {
        break;
      }
      paramResponse2 = paramResponse2.headers().getDate("Last-Modified");
    } while ((paramResponse2 != null) && (paramResponse2.getTime() < paramResponse1.getTime()));
    return false;
  }
  
  public void cancel()
  {
    streamAllocation.cancel();
  }
  
  public StreamAllocation close()
  {
    if (bufferedRequestBody != null)
    {
      Util.closeQuietly(bufferedRequestBody);
      if (userResponse == null) {
        break label53;
      }
      Util.closeQuietly(userResponse.body());
    }
    for (;;)
    {
      return streamAllocation;
      if (requestBodyOut == null) {
        break;
      }
      Util.closeQuietly(requestBodyOut);
      break;
      label53:
      streamAllocation.connectionFailed();
    }
  }
  
  public Request followUpRequest()
    throws IOException
  {
    if (userResponse == null) {
      throw new IllegalStateException();
    }
    Object localObject = streamAllocation.connection();
    label43:
    String str;
    if (localObject != null)
    {
      localObject = ((Connection)localObject).getRoute();
      if (localObject == null) {
        break label143;
      }
      localObject = ((Route)localObject).getProxy();
      int i = userResponse.code();
      str = userRequest.method();
      switch (i)
      {
      }
    }
    label143:
    do
    {
      do
      {
        do
        {
          return null;
          localObject = null;
          break;
          localObject = client.getProxy();
          break label43;
          if (((Proxy)localObject).type() != Proxy.Type.HTTP) {
            throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
          }
          return OkHeaders.processAuthHeader(client.getAuthenticator(), userResponse, (Proxy)localObject);
        } while (((!str.equals("GET")) && (!str.equals("HEAD"))) || (!client.getFollowRedirects()));
        localObject = userResponse.header("Location");
      } while (localObject == null);
      localObject = userRequest.httpUrl().resolve((String)localObject);
    } while ((localObject == null) || ((!((HttpUrl)localObject).scheme().equals(userRequest.httpUrl().scheme())) && (!client.getFollowSslRedirects())));
    Request.Builder localBuilder = userRequest.newBuilder();
    if (HttpMethod.permitsRequestBody(str))
    {
      if (!HttpMethod.redirectsToGet(str)) {
        break label366;
      }
      localBuilder.method("GET", null);
    }
    for (;;)
    {
      localBuilder.removeHeader("Transfer-Encoding");
      localBuilder.removeHeader("Content-Length");
      localBuilder.removeHeader("Content-Type");
      if (!sameConnection((HttpUrl)localObject)) {
        localBuilder.removeHeader("Authorization");
      }
      return localBuilder.url((HttpUrl)localObject).build();
      label366:
      localBuilder.method(str, null);
    }
  }
  
  public BufferedSink getBufferedRequestBody()
  {
    Object localObject = bufferedRequestBody;
    if (localObject != null) {
      return (BufferedSink)localObject;
    }
    localObject = getRequestBody();
    if (localObject != null)
    {
      localObject = Okio.buffer((Sink)localObject);
      bufferedRequestBody = ((BufferedSink)localObject);
    }
    for (;;)
    {
      return (BufferedSink)localObject;
      localObject = null;
    }
  }
  
  public Connection getConnection()
  {
    return streamAllocation.connection();
  }
  
  public Request getRequest()
  {
    return userRequest;
  }
  
  public Sink getRequestBody()
  {
    if (cacheStrategy == null) {
      throw new IllegalStateException();
    }
    return requestBodyOut;
  }
  
  public Response getResponse()
  {
    if (userResponse == null) {
      throw new IllegalStateException();
    }
    return userResponse;
  }
  
  public boolean hasResponse()
  {
    return userResponse != null;
  }
  
  boolean permitsRequestBody(Request paramRequest)
  {
    return HttpMethod.permitsRequestBody(paramRequest.method());
  }
  
  public void readResponse()
    throws IOException
  {
    if (userResponse != null) {}
    label418:
    label430:
    label440:
    do
    {
      do
      {
        return;
        if ((networkRequest == null) && (cacheResponse == null)) {
          throw new IllegalStateException("call sendRequest() first!");
        }
      } while (networkRequest == null);
      if (forWebSocket) {
        httpStream.writeRequestHeaders(networkRequest);
      }
      for (Object localObject = readNetworkResponse();; localObject = new NetworkInterceptorChain(0, networkRequest).proceed(networkRequest))
      {
        receiveHeaders(((Response)localObject).headers());
        if (cacheResponse == null) {
          break label440;
        }
        if (!validate(cacheResponse, (Response)localObject)) {
          break label430;
        }
        userResponse = cacheResponse.newBuilder().request(userRequest).priorResponse(stripBody(priorResponse)).headers(combine(cacheResponse.headers(), ((Response)localObject).headers())).cacheResponse(stripBody(cacheResponse)).networkResponse(stripBody((Response)localObject)).build();
        ((Response)localObject).body().close();
        releaseStreamAllocation();
        localObject = Internal.instance.internalCache(client);
        ((InternalCache)localObject).trackConditionalCacheHit();
        ((InternalCache)localObject).update(cacheResponse, stripBody(userResponse));
        userResponse = unzip(userResponse);
        return;
        if (callerWritesRequestBody) {
          break;
        }
      }
      if ((bufferedRequestBody != null) && (bufferedRequestBody.buffer().size() > 0L)) {
        bufferedRequestBody.emit();
      }
      if (sentRequestMillis == -1L)
      {
        if ((OkHeaders.contentLength(networkRequest) == -1L) && ((requestBodyOut instanceof RetryableSink)))
        {
          long l = ((RetryableSink)requestBodyOut).contentLength();
          networkRequest = networkRequest.newBuilder().header("Content-Length", Long.toString(l)).build();
        }
        httpStream.writeRequestHeaders(networkRequest);
      }
      if (requestBodyOut != null)
      {
        if (bufferedRequestBody == null) {
          break label418;
        }
        bufferedRequestBody.close();
      }
      for (;;)
      {
        if ((requestBodyOut instanceof RetryableSink)) {
          httpStream.writeRequestBody((RetryableSink)requestBodyOut);
        }
        localObject = readNetworkResponse();
        break;
        requestBodyOut.close();
      }
      Util.closeQuietly(cacheResponse.body());
      userResponse = ((Response)localObject).newBuilder().request(userRequest).priorResponse(stripBody(priorResponse)).cacheResponse(stripBody(cacheResponse)).networkResponse(stripBody((Response)localObject)).build();
    } while (!hasBody(userResponse));
    maybeCache();
    userResponse = unzip(cacheWritingResponse(storeRequest, userResponse));
  }
  
  public void receiveHeaders(Headers paramHeaders)
    throws IOException
  {
    CookieHandler localCookieHandler = client.getCookieHandler();
    if (localCookieHandler != null) {
      localCookieHandler.put(userRequest.uri(), OkHeaders.toMultimap(paramHeaders, null));
    }
  }
  
  public HttpEngine recover(RouteException paramRouteException)
  {
    if (!streamAllocation.recover(paramRouteException)) {}
    while (!client.getRetryOnConnectionFailure()) {
      return null;
    }
    paramRouteException = close();
    return new HttpEngine(client, userRequest, bufferRequestBody, callerWritesRequestBody, forWebSocket, paramRouteException, (RetryableSink)requestBodyOut, priorResponse);
  }
  
  public HttpEngine recover(IOException paramIOException)
  {
    return recover(paramIOException, requestBodyOut);
  }
  
  public HttpEngine recover(IOException paramIOException, Sink paramSink)
  {
    if (!streamAllocation.recover(paramIOException, paramSink)) {}
    while (!client.getRetryOnConnectionFailure()) {
      return null;
    }
    paramIOException = close();
    return new HttpEngine(client, userRequest, bufferRequestBody, callerWritesRequestBody, forWebSocket, paramIOException, (RetryableSink)paramSink, priorResponse);
  }
  
  public void releaseStreamAllocation()
    throws IOException
  {
    streamAllocation.release();
  }
  
  public boolean sameConnection(HttpUrl paramHttpUrl)
  {
    HttpUrl localHttpUrl = userRequest.httpUrl();
    return (localHttpUrl.host().equals(paramHttpUrl.host())) && (localHttpUrl.port() == paramHttpUrl.port()) && (localHttpUrl.scheme().equals(paramHttpUrl.scheme()));
  }
  
  public void sendRequest()
    throws RequestException, RouteException, IOException
  {
    if (cacheStrategy != null) {
      return;
    }
    if (httpStream != null) {
      throw new IllegalStateException();
    }
    Request localRequest = networkRequest(userRequest);
    InternalCache localInternalCache = Internal.instance.internalCache(client);
    if (localInternalCache != null) {}
    long l;
    for (Response localResponse = localInternalCache.get(localRequest);; localResponse = null)
    {
      cacheStrategy = new CacheStrategy.Factory(System.currentTimeMillis(), localRequest, localResponse).get();
      networkRequest = cacheStrategy.networkRequest;
      cacheResponse = cacheStrategy.cacheResponse;
      if (localInternalCache != null) {
        localInternalCache.trackResponse(cacheStrategy);
      }
      if ((localResponse != null) && (cacheResponse == null)) {
        Util.closeQuietly(localResponse.body());
      }
      if (networkRequest == null) {
        break label302;
      }
      httpStream = connect();
      httpStream.setHttpEngine(this);
      if ((!callerWritesRequestBody) || (!permitsRequestBody(networkRequest)) || (requestBodyOut != null)) {
        break;
      }
      l = OkHeaders.contentLength(localRequest);
      if (!bufferRequestBody) {
        break label270;
      }
      if (l <= 2147483647L) {
        break label223;
      }
      throw new IllegalStateException("Use setFixedLengthStreamingMode() or setChunkedStreamingMode() for requests larger than 2 GiB.");
    }
    label223:
    if (l != -1L)
    {
      httpStream.writeRequestHeaders(networkRequest);
      requestBodyOut = new RetryableSink((int)l);
      return;
    }
    requestBodyOut = new RetryableSink();
    return;
    label270:
    httpStream.writeRequestHeaders(networkRequest);
    requestBodyOut = httpStream.createRequestBody(networkRequest, l);
    return;
    label302:
    if (cacheResponse != null) {}
    for (userResponse = cacheResponse.newBuilder().request(userRequest).priorResponse(stripBody(priorResponse)).cacheResponse(stripBody(cacheResponse)).build();; userResponse = new Response.Builder().request(userRequest).priorResponse(stripBody(priorResponse)).protocol(Protocol.HTTP_1_1).code(504).message("Unsatisfiable Request (only-if-cached)").body(EMPTY_BODY).build())
    {
      userResponse = unzip(userResponse);
      return;
    }
  }
  
  public void writingRequestHeaders()
  {
    if (sentRequestMillis != -1L) {
      throw new IllegalStateException();
    }
    sentRequestMillis = System.currentTimeMillis();
  }
  
  class NetworkInterceptorChain
    implements Interceptor.Chain
  {
    private int calls;
    private final int index;
    private final Request request;
    
    NetworkInterceptorChain(int paramInt, Request paramRequest)
    {
      index = paramInt;
      request = paramRequest;
    }
    
    public Connection connection()
    {
      return streamAllocation.connection();
    }
    
    public Response proceed(Request paramRequest)
      throws IOException
    {
      calls += 1;
      Object localObject1;
      Object localObject2;
      if (index > 0)
      {
        localObject1 = (Interceptor)client.networkInterceptors().get(index - 1);
        localObject2 = connection().getRoute().getAddress();
        if ((!paramRequest.httpUrl().host().equals(((Address)localObject2).getUriHost())) || (paramRequest.httpUrl().port() != ((Address)localObject2).getUriPort())) {
          throw new IllegalStateException("network interceptor " + localObject1 + " must retain the same host and port");
        }
        if (calls > 1) {
          throw new IllegalStateException("network interceptor " + localObject1 + " must call proceed() exactly once");
        }
      }
      if (index < client.networkInterceptors().size())
      {
        paramRequest = new NetworkInterceptorChain(HttpEngine.this, index + 1, paramRequest);
        localObject2 = (Interceptor)client.networkInterceptors().get(index);
        localObject1 = ((Interceptor)localObject2).intercept(paramRequest);
        if (calls != 1) {
          throw new IllegalStateException("network interceptor " + localObject2 + " must call proceed() exactly once");
        }
        paramRequest = (Request)localObject1;
        if (localObject1 == null) {
          throw new NullPointerException("network interceptor " + localObject2 + " returned null");
        }
      }
      else
      {
        httpStream.writeRequestHeaders(paramRequest);
        HttpEngine.access$102(HttpEngine.this, paramRequest);
        if ((permitsRequestBody(paramRequest)) && (paramRequest.body() != null))
        {
          localObject1 = Okio.buffer(httpStream.createRequestBody(paramRequest, paramRequest.body().contentLength()));
          paramRequest.body().writeTo((BufferedSink)localObject1);
          ((BufferedSink)localObject1).close();
        }
        paramRequest = HttpEngine.this.readNetworkResponse();
        int i = paramRequest.code();
        if (((i == 204) || (i == 205)) && (paramRequest.body().contentLength() > 0L)) {
          throw new ProtocolException("HTTP " + i + " had non-zero Content-Length: " + paramRequest.body().contentLength());
        }
      }
      return paramRequest;
    }
    
    public Request request()
    {
      return request;
    }
  }
}

/* Location:
 * Qualified Name:     com.squareup.okhttp.internal.http.HttpEngine
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */