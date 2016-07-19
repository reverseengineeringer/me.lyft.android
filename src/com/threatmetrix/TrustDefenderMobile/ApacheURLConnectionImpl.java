package com.threatmetrix.TrustDefenderMobile;

import android.content.Context;
import android.net.SSLCertificateSocketFactory;
import android.net.SSLSessionCache;
import android.net.http.AndroidHttpClient;
import android.os.Build.VERSION;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.net.UnknownHostException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.LayeredSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.AbstractHttpEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpParams;

class ApacheURLConnectionImpl
  implements TDURLConnection
{
  private static final String TAG = StringUtils.getLogTag(ApacheURLConnectionImpl.class);
  private Context m_context;
  private boolean m_enablePostCompression;
  private final ArrayList<BasicHeader> m_headers = new ArrayList();
  private final AndroidHttpClient m_httpClient;
  private InputStream m_inputStream;
  private HttpRequestBase m_request;
  private HttpResponse m_response;
  private final CancelState m_state;
  private THMStatusCode m_status;
  
  ApacheURLConnectionImpl(AndroidHttpClient paramAndroidHttpClient, CancelState paramCancelState, Context paramContext, boolean paramBoolean)
  {
    m_httpClient = paramAndroidHttpClient;
    m_status = THMStatusCode.THM_NotYet;
    m_request = null;
    m_state = paramCancelState;
    m_inputStream = null;
    m_enablePostCompression = paramBoolean;
    m_context = paramContext;
  }
  
  private void go(HttpRequestBase paramHttpRequestBase)
  {
    try
    {
      m_request = paramHttpRequestBase;
      paramHttpRequestBase = m_headers.iterator();
      while (paramHttpRequestBase.hasNext())
      {
        BasicHeader localBasicHeader = (BasicHeader)paramHttpRequestBase.next();
        m_request.addHeader(localBasicHeader);
      }
      HttpClientParams.setRedirecting(m_request.getParams(), true);
    }
    finally {}
    paramHttpRequestBase = new ProxyWrapper();
    if ((paramHttpRequestBase.getHost() != null) && (!paramHttpRequestBase.getHost().isEmpty()))
    {
      paramHttpRequestBase = new HttpHost(paramHttpRequestBase.getHost(), paramHttpRequestBase.getPort());
      m_httpClient.getParams().setParameter("http.route.default-proxy", paramHttpRequestBase);
    }
    for (;;)
    {
      try
      {
        m_response = m_httpClient.execute(m_request);
        m_status = THMStatusCode.THM_OK;
        return;
      }
      catch (IOException paramHttpRequestBase)
      {
        if (!(paramHttpRequestBase.getCause() instanceof CertificateException)) {
          continue;
        }
        m_status = THMStatusCode.THM_HostVerification_Error;
        if ((m_state == null) || (!m_state.isCancelled())) {
          continue;
        }
        Log.d(TAG, "Connection interrupted due to cancel!");
        abort();
        return;
        if (!(paramHttpRequestBase instanceof SSLPeerUnverifiedException)) {
          continue;
        }
        m_status = THMStatusCode.THM_HostVerification_Error;
        continue;
        if (!(paramHttpRequestBase instanceof UnknownHostException)) {
          continue;
        }
        m_status = THMStatusCode.THM_HostNotFound_Error;
        continue;
        if (!(paramHttpRequestBase instanceof SocketTimeoutException)) {
          continue;
        }
        m_status = THMStatusCode.THM_NetworkTimeout_Error;
        continue;
        if (m_status != THMStatusCode.THM_NotYet) {
          continue;
        }
        m_status = THMStatusCode.THM_Connection_Error;
        continue;
        Log.e(TAG, "Failed to retrieve URI", paramHttpRequestBase);
        return;
      }
      catch (RuntimeException paramHttpRequestBase)
      {
        Log.e(TAG, "Caught runtime exception:", paramHttpRequestBase);
        m_status = THMStatusCode.THM_Connection_Error;
      }
      m_httpClient.getParams().setParameter("http.route.default-proxy", null);
    }
  }
  
  static void setSSLSocketFactory(Context paramContext, HttpClient paramHttpClient, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 14)
    {
      setSSLTimeout(paramContext, paramHttpClient, paramInt);
      return;
    }
    workAroundReverseDnsBugInHoneycombAndEarlier(paramContext, paramHttpClient, paramInt);
  }
  
  private static void setSSLTimeout(Context paramContext, HttpClient paramHttpClient, int paramInt)
  {
    paramContext = SSLCertificateSocketFactory.getHttpSocketFactory(paramInt, new SSLSessionCache(paramContext));
    paramHttpClient.getConnectionManager().getSchemeRegistry().register(new Scheme("https", paramContext, 443));
  }
  
  private static void workAroundReverseDnsBugInHoneycombAndEarlier(final Context paramContext, HttpClient paramHttpClient, int paramInt)
  {
    paramContext = new LayeredSocketFactory()
    {
      final SSLSocketFactory delegate = SSLCertificateSocketFactory.getHttpSocketFactory(val$timeout_ms, new SSLSessionCache(paramContext));
      
      private void injectHostname(Socket paramAnonymousSocket, String paramAnonymousString)
      {
        try
        {
          Field localField = InetAddress.class.getDeclaredField("hostName");
          localField.setAccessible(true);
          localField.set(paramAnonymousSocket.getInetAddress(), paramAnonymousString);
          return;
        }
        catch (Exception paramAnonymousSocket) {}
      }
      
      public Socket connectSocket(Socket paramAnonymousSocket, String paramAnonymousString, int paramAnonymousInt1, InetAddress paramAnonymousInetAddress, int paramAnonymousInt2, HttpParams paramAnonymousHttpParams)
        throws IOException
      {
        return delegate.connectSocket(paramAnonymousSocket, paramAnonymousString, paramAnonymousInt1, paramAnonymousInetAddress, paramAnonymousInt2, paramAnonymousHttpParams);
      }
      
      public Socket createSocket()
        throws IOException
      {
        return delegate.createSocket();
      }
      
      public Socket createSocket(Socket paramAnonymousSocket, String paramAnonymousString, int paramAnonymousInt, boolean paramAnonymousBoolean)
        throws IOException
      {
        injectHostname(paramAnonymousSocket, paramAnonymousString);
        return delegate.createSocket(paramAnonymousSocket, paramAnonymousString, paramAnonymousInt, paramAnonymousBoolean);
      }
      
      public boolean isSecure(Socket paramAnonymousSocket)
        throws IllegalArgumentException
      {
        return delegate.isSecure(paramAnonymousSocket);
      }
    };
    paramHttpClient.getConnectionManager().getSchemeRegistry().register(new Scheme("https", paramContext, 443));
  }
  
  public void abort()
  {
    Log.d(TAG, "aborting connection");
    try
    {
      if (m_request != null) {
        m_request.abort();
      }
      m_status = THMStatusCode.THM_Interrupted_Error;
      return;
    }
    finally {}
  }
  
  public void addHeader(String paramString1, String paramString2)
  {
    m_headers.add(new BasicHeader(paramString1, paramString2));
  }
  
  public void addHeaders(Map<String, String> paramMap)
  {
    if (paramMap == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        String str2 = (String)paramMap.get(str1);
        if ((str2 != null) && (!str2.isEmpty())) {
          addHeader(str1, str2);
        }
      }
    }
  }
  
  public void consumeContentAndClose()
  {
    if (m_response == null) {}
    for (;;)
    {
      return;
      HttpEntity localHttpEntity = m_response.getEntity();
      Object localObject5 = null;
      Object localObject6 = null;
      InputStream localInputStream = null;
      Object localObject3 = localObject5;
      Object localObject1 = localObject6;
      try
      {
        if (m_inputStream == null) {
          if (localHttpEntity != null)
          {
            localObject3 = localObject5;
            localObject1 = localObject6;
            localInputStream = localHttpEntity.getContent();
            localObject3 = localInputStream;
            localObject1 = localInputStream;
            localHttpEntity.consumeContent();
          }
        }
        while (localInputStream != null)
        {
          try
          {
            localInputStream.close();
            return;
          }
          catch (IOException localIOException1)
          {
            return;
          }
          localObject3 = localObject5;
          localObject2 = localObject6;
          localInputStream = m_inputStream;
        }
      }
      catch (IOException localIOException4)
      {
        Object localObject2 = localObject3;
        Log.d(TAG, "failed to consume content", localIOException4);
        if (localObject3 != null) {
          try
          {
            ((InputStream)localObject3).close();
            return;
          }
          catch (IOException localIOException2)
          {
            return;
          }
        }
      }
      finally
      {
        if (localIOException2 == null) {}
      }
    }
    try
    {
      localIOException2.close();
      throw ((Throwable)localObject4);
    }
    catch (IOException localIOException3)
    {
      for (;;) {}
    }
  }
  
  public long get(String paramString)
  {
    go(new HttpGet(paramString));
    if ((m_response == null) || (m_status != THMStatusCode.THM_OK)) {
      return -1L;
    }
    return m_response.getStatusLine().getStatusCode();
  }
  
  /* Error */
  public AbstractHttpEntity getCompressedEntity(HttpParameterMap paramHttpParameterMap, Context paramContext)
  {
    // Byte code:
    //   0: new 330	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 331	java/lang/StringBuilder:<init>	()V
    //   7: astore 5
    //   9: new 46	java/util/ArrayList
    //   12: dup
    //   13: invokespecial 47	java/util/ArrayList:<init>	()V
    //   16: astore 6
    //   18: aload_1
    //   19: invokevirtual 334	com/threatmetrix/TrustDefenderMobile/HttpParameterMap:keySet	()Ljava/util/Set;
    //   22: invokeinterface 272 1 0
    //   27: astore 7
    //   29: aload 7
    //   31: invokeinterface 84 1 0
    //   36: ifeq +132 -> 168
    //   39: aload 7
    //   41: invokeinterface 88 1 0
    //   46: checkcast 115	java/lang/String
    //   49: astore 8
    //   51: aload_1
    //   52: aload 8
    //   54: invokevirtual 335	com/threatmetrix/TrustDefenderMobile/HttpParameterMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   57: checkcast 115	java/lang/String
    //   60: astore 4
    //   62: aload 4
    //   64: ifnull -35 -> 29
    //   67: aload 4
    //   69: invokevirtual 118	java/lang/String:isEmpty	()Z
    //   72: ifne -43 -> 29
    //   75: aload 4
    //   77: astore_3
    //   78: aload_1
    //   79: invokevirtual 338	com/threatmetrix/TrustDefenderMobile/HttpParameterMap:getPostValueLengthLimit	()I
    //   82: ifeq +29 -> 111
    //   85: aload 4
    //   87: astore_3
    //   88: aload 4
    //   90: invokevirtual 341	java/lang/String:length	()I
    //   93: aload_1
    //   94: invokevirtual 338	com/threatmetrix/TrustDefenderMobile/HttpParameterMap:getPostValueLengthLimit	()I
    //   97: if_icmple +14 -> 111
    //   100: aload 4
    //   102: iconst_0
    //   103: aload_1
    //   104: invokevirtual 338	com/threatmetrix/TrustDefenderMobile/HttpParameterMap:getPostValueLengthLimit	()I
    //   107: invokevirtual 345	java/lang/String:substring	(II)Ljava/lang/String;
    //   110: astore_3
    //   111: aload 6
    //   113: new 347	org/apache/http/message/BasicNameValuePair
    //   116: dup
    //   117: aload 8
    //   119: aload_3
    //   120: invokespecial 348	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   123: invokeinterface 351 2 0
    //   128: pop
    //   129: aload 5
    //   131: invokevirtual 352	java/lang/StringBuilder:length	()I
    //   134: ifle +12 -> 146
    //   137: aload 5
    //   139: ldc_w 354
    //   142: invokevirtual 358	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: pop
    //   146: aload 5
    //   148: new 347	org/apache/http/message/BasicNameValuePair
    //   151: dup
    //   152: aload 8
    //   154: aload_3
    //   155: invokespecial 348	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   158: invokevirtual 361	org/apache/http/message/BasicNameValuePair:toString	()Ljava/lang/String;
    //   161: invokevirtual 358	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: pop
    //   165: goto -136 -> 29
    //   168: aload 5
    //   170: invokevirtual 362	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: ldc_w 364
    //   176: invokevirtual 368	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   179: astore_3
    //   180: aload_3
    //   181: arraylength
    //   182: i2l
    //   183: aload_2
    //   184: invokevirtual 374	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   187: invokestatic 378	android/net/http/AndroidHttpClient:getMinGzipSize	(Landroid/content/ContentResolver;)J
    //   190: lcmp
    //   191: ifge +46 -> 237
    //   194: getstatic 39	com/threatmetrix/TrustDefenderMobile/ApacheURLConnectionImpl:TAG	Ljava/lang/String;
    //   197: new 330	java/lang/StringBuilder
    //   200: dup
    //   201: invokespecial 331	java/lang/StringBuilder:<init>	()V
    //   204: ldc_w 380
    //   207: invokevirtual 358	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: aload_3
    //   211: arraylength
    //   212: invokevirtual 383	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   215: ldc_w 385
    //   218: invokevirtual 358	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: invokevirtual 362	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   224: invokestatic 169	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   227: pop
    //   228: aload_3
    //   229: aload_2
    //   230: invokevirtual 374	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   233: invokestatic 388	android/net/http/AndroidHttpClient:getCompressedEntity	([BLandroid/content/ContentResolver;)Lorg/apache/http/entity/AbstractHttpEntity;
    //   236: areturn
    //   237: getstatic 39	com/threatmetrix/TrustDefenderMobile/ApacheURLConnectionImpl:TAG	Ljava/lang/String;
    //   240: new 330	java/lang/StringBuilder
    //   243: dup
    //   244: invokespecial 331	java/lang/StringBuilder:<init>	()V
    //   247: ldc_w 390
    //   250: invokevirtual 358	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: aload_3
    //   254: arraylength
    //   255: invokevirtual 383	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   258: invokevirtual 362	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   261: invokestatic 169	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   264: pop
    //   265: goto -37 -> 228
    //   268: astore_2
    //   269: getstatic 39	com/threatmetrix/TrustDefenderMobile/ApacheURLConnectionImpl:TAG	Ljava/lang/String;
    //   272: ldc_w 392
    //   275: aload_2
    //   276: invokestatic 193	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   279: pop
    //   280: aload_0
    //   281: aload_1
    //   282: invokevirtual 395	com/threatmetrix/TrustDefenderMobile/ApacheURLConnectionImpl:getEntity	(Lcom/threatmetrix/TrustDefenderMobile/HttpParameterMap;)Lorg/apache/http/client/entity/UrlEncodedFormEntity;
    //   285: areturn
    //   286: astore_2
    //   287: getstatic 39	com/threatmetrix/TrustDefenderMobile/ApacheURLConnectionImpl:TAG	Ljava/lang/String;
    //   290: ldc_w 397
    //   293: aload_2
    //   294: invokestatic 193	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   297: pop
    //   298: goto -18 -> 280
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	301	0	this	ApacheURLConnectionImpl
    //   0	301	1	paramHttpParameterMap	HttpParameterMap
    //   0	301	2	paramContext	Context
    //   77	177	3	localObject	Object
    //   60	41	4	str1	String
    //   7	162	5	localStringBuilder	StringBuilder
    //   16	96	6	localArrayList	ArrayList
    //   27	13	7	localIterator	Iterator
    //   49	104	8	str2	String
    // Exception table:
    //   from	to	target	type
    //   168	228	268	java/io/UnsupportedEncodingException
    //   228	237	268	java/io/UnsupportedEncodingException
    //   237	265	268	java/io/UnsupportedEncodingException
    //   168	228	286	java/io/IOException
    //   228	237	286	java/io/IOException
    //   237	265	286	java/io/IOException
  }
  
  public UrlEncodedFormEntity getEntity(HttpParameterMap paramHttpParameterMap)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramHttpParameterMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str3 = (String)localIterator.next();
      String str2 = (String)paramHttpParameterMap.get(str3);
      if ((str2 != null) && (!str2.isEmpty()))
      {
        String str1 = str2;
        if (paramHttpParameterMap.getPostValueLengthLimit() != 0)
        {
          str1 = str2;
          if (str2.length() > paramHttpParameterMap.getPostValueLengthLimit()) {
            str1 = str2.substring(0, paramHttpParameterMap.getPostValueLengthLimit());
          }
        }
        localArrayList.add(new BasicNameValuePair(str3, str1));
      }
    }
    try
    {
      paramHttpParameterMap = new UrlEncodedFormEntity(localArrayList, "UTF-8");
      return paramHttpParameterMap;
    }
    catch (UnsupportedEncodingException paramHttpParameterMap)
    {
      Log.e(TAG, "Failed url encoding", paramHttpParameterMap);
    }
    return null;
  }
  
  public String getHost()
  {
    if (m_request != null) {
      return m_request.getURI().getHost();
    }
    return "";
  }
  
  public int getHttpStatusCode()
  {
    if (m_response != null) {
      return m_response.getStatusLine().getStatusCode();
    }
    return 0;
  }
  
  public InputStream getResponseStream()
    throws IOException
  {
    if (m_inputStream != null) {
      return m_inputStream;
    }
    if (m_response != null)
    {
      m_inputStream = m_response.getEntity().getContent();
      return m_inputStream;
    }
    return null;
  }
  
  public THMStatusCode getStatus()
  {
    return m_status;
  }
  
  public String getURL()
  {
    if (m_request != null) {
      return m_request.getURI().getScheme() + "://" + m_request.getURI().getHost() + m_request.getURI().getPath();
    }
    return "";
  }
  
  public long post(String paramString, HttpParameterMap paramHttpParameterMap)
  {
    AbstractHttpEntity localAbstractHttpEntity;
    if ((m_enablePostCompression) && (m_context != null))
    {
      localAbstractHttpEntity = getCompressedEntity(paramHttpParameterMap, m_context);
      paramHttpParameterMap = localAbstractHttpEntity;
      if (localAbstractHttpEntity.getContentEncoding() != null)
      {
        Log.d(TAG, "Entity content encoding: " + localAbstractHttpEntity.getContentEncoding().getValue());
        addHeader("Content-Encoding", localAbstractHttpEntity.getContentEncoding().getValue());
        addHeader("Accept-Encoding", "gzip, deflate");
      }
    }
    for (paramHttpParameterMap = localAbstractHttpEntity;; paramHttpParameterMap = getEntity(paramHttpParameterMap))
    {
      paramString = new HttpPost(paramString);
      paramString.setEntity(paramHttpParameterMap);
      go(paramString);
      if ((m_response != null) && (m_status == THMStatusCode.THM_OK)) {
        break;
      }
      return -1L;
    }
    return m_response.getStatusLine().getStatusCode();
  }
}

/* Location:
 * Qualified Name:     com.threatmetrix.TrustDefenderMobile.ApacheURLConnectionImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */