package com.braintreepayments.api.internal;

import com.braintreepayments.api.exceptions.BraintreeSslException;
import com.braintreepayments.api.exceptions.UnexpectedException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.KeyStore;
import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;

public class HttpRequest
{
  private static final String AUTHORIZATION_FINGERPRINT_KEY = "authorizationFingerprint";
  public static boolean DEBUG = false;
  private static final String METHOD_GET = "GET";
  private static final String METHOD_POST = "POST";
  public static final String TAG = "HttpRequest";
  private static final String UTF_8 = "UTF-8";
  private String mAuthorizationFingerprint;
  private int mConnectTimeout = 0;
  
  public HttpRequest(String paramString)
  {
    mAuthorizationFingerprint = paramString;
  }
  
  private static SSLSocketFactory getSslSocketFactory()
    throws BraintreeSslException
  {
    Object localObject2;
    try
    {
      KeyStore localKeyStore = KeyStore.getInstance(KeyStore.getDefaultType());
      localKeyStore.load(null, null);
      localObject2 = CertificateFactory.getInstance("X.509").generateCertificates(BraintreeGatewayCertificate.getCertInputStream()).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Certificate localCertificate = (Certificate)((Iterator)localObject2).next();
        if ((localCertificate instanceof X509Certificate)) {
          localKeyStore.setCertificateEntry(((X509Certificate)localCertificate).getSubjectDN().getName(), localCertificate);
        }
      }
      localObject2 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
    }
    catch (Exception localException)
    {
      throw new BraintreeSslException(localException);
    }
    ((TrustManagerFactory)localObject2).init(localException);
    Object localObject1 = SSLContext.getInstance("TLS");
    ((SSLContext)localObject1).init(null, ((TrustManagerFactory)localObject2).getTrustManagers(), null);
    localObject1 = ((SSLContext)localObject1).getSocketFactory();
    return (SSLSocketFactory)localObject1;
  }
  
  public static String getUserAgent()
  {
    return "braintree/android/1.4.0";
  }
  
  private HttpResponse handleServerResponse(HttpURLConnection paramHttpURLConnection)
    throws IOException
  {
    int i = paramHttpURLConnection.getResponseCode();
    if ((i >= 200) && (i < 400)) {}
    for (Object localObject = readStream(paramHttpURLConnection.getInputStream());; localObject = readStream(paramHttpURLConnection.getErrorStream()))
    {
      log("Received response code: " + i);
      log("Received response: " + (String)localObject);
      localObject = new HttpResponse(i, (String)localObject);
      ((HttpResponse)localObject).setUrl(paramHttpURLConnection.getURL().toString());
      return (HttpResponse)localObject;
    }
  }
  
  private void log(String paramString)
  {
    if (DEBUG) {}
  }
  
  private String readStream(InputStream paramInputStream)
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte['Ѐ'];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i == -1) {
        break;
      }
      localByteArrayOutputStream.write(arrayOfByte, 0, i);
    }
    return new String(localByteArrayOutputStream.toByteArray(), "UTF-8");
  }
  
  public HttpResponse get(String paramString)
    throws UnexpectedException
  {
    Object localObject = null;
    String str = null;
    try
    {
      paramString = init(paramString + "?authorizationFingerprint=" + URLEncoder.encode(mAuthorizationFingerprint, "UTF-8"));
      str = paramString;
      localObject = paramString;
      paramString.setRequestMethod("GET");
      str = paramString;
      localObject = paramString;
      HttpResponse localHttpResponse = handleServerResponse(paramString);
      if (paramString != null) {
        paramString.disconnect();
      }
      return localHttpResponse;
    }
    catch (IOException paramString)
    {
      localObject = str;
      throw new UnexpectedException(paramString.getMessage());
    }
    finally
    {
      if (localObject != null) {
        ((HttpURLConnection)localObject).disconnect();
      }
    }
  }
  
  protected HttpURLConnection init(String paramString)
    throws IOException
  {
    log("Opening url: " + paramString);
    paramString = (HttpURLConnection)new URL(paramString).openConnection();
    if ((paramString instanceof HttpsURLConnection)) {
      ((HttpsURLConnection)paramString).setSSLSocketFactory(getSslSocketFactory());
    }
    paramString.setRequestProperty("Content-Type", "application/json");
    paramString.setRequestProperty("User-Agent", getUserAgent());
    paramString.setRequestProperty("Accept-Language", Locale.getDefault().getLanguage());
    paramString.setConnectTimeout(mConnectTimeout);
    return paramString;
  }
  
  /* Error */
  public HttpResponse post(String paramString1, String paramString2)
    throws UnexpectedException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 8
    //   6: aconst_null
    //   7: astore 6
    //   9: aload 6
    //   11: astore 4
    //   13: aload 7
    //   15: astore_3
    //   16: aload 8
    //   18: astore 5
    //   20: new 298	org/json/JSONObject
    //   23: dup
    //   24: aload_2
    //   25: invokespecial 299	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   28: ldc 8
    //   30: aload_0
    //   31: getfield 39	com/braintreepayments/api/internal/HttpRequest:mAuthorizationFingerprint	Ljava/lang/String;
    //   34: invokevirtual 303	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   37: invokevirtual 304	org/json/JSONObject:toString	()Ljava/lang/String;
    //   40: astore_2
    //   41: aload 6
    //   43: astore 4
    //   45: aload 7
    //   47: astore_3
    //   48: aload 8
    //   50: astore 5
    //   52: aload_0
    //   53: aload_1
    //   54: invokevirtual 237	com/braintreepayments/api/internal/HttpRequest:init	(Ljava/lang/String;)Ljava/net/HttpURLConnection;
    //   57: astore_1
    //   58: aload_1
    //   59: astore 4
    //   61: aload_1
    //   62: astore_3
    //   63: aload_1
    //   64: astore 5
    //   66: aload_1
    //   67: ldc 17
    //   69: invokevirtual 240	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   72: aload_1
    //   73: astore 4
    //   75: aload_1
    //   76: astore_3
    //   77: aload_1
    //   78: astore 5
    //   80: aload_1
    //   81: iconst_1
    //   82: invokevirtual 308	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   85: aload_1
    //   86: astore 4
    //   88: aload_1
    //   89: astore_3
    //   90: aload_1
    //   91: astore 5
    //   93: new 310	java/io/DataOutputStream
    //   96: dup
    //   97: aload_1
    //   98: invokevirtual 314	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   101: invokespecial 317	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   104: astore 6
    //   106: aload_1
    //   107: astore 4
    //   109: aload_1
    //   110: astore_3
    //   111: aload_1
    //   112: astore 5
    //   114: aload 6
    //   116: aload_2
    //   117: invokevirtual 320	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   120: aload_1
    //   121: astore 4
    //   123: aload_1
    //   124: astore_3
    //   125: aload_1
    //   126: astore 5
    //   128: aload 6
    //   130: invokevirtual 323	java/io/DataOutputStream:flush	()V
    //   133: aload_1
    //   134: astore 4
    //   136: aload_1
    //   137: astore_3
    //   138: aload_1
    //   139: astore 5
    //   141: aload 6
    //   143: invokevirtual 326	java/io/DataOutputStream:close	()V
    //   146: aload_1
    //   147: astore 4
    //   149: aload_1
    //   150: astore_3
    //   151: aload_1
    //   152: astore 5
    //   154: aload_0
    //   155: aload_1
    //   156: invokespecial 242	com/braintreepayments/api/internal/HttpRequest:handleServerResponse	(Ljava/net/HttpURLConnection;)Lcom/braintreepayments/api/internal/HttpResponse;
    //   159: astore 6
    //   161: aload_1
    //   162: astore 4
    //   164: aload_1
    //   165: astore_3
    //   166: aload_1
    //   167: astore 5
    //   169: aload 6
    //   171: aload_2
    //   172: invokevirtual 329	com/braintreepayments/api/internal/HttpResponse:setData	(Ljava/lang/String;)V
    //   175: aload_1
    //   176: ifnull +7 -> 183
    //   179: aload_1
    //   180: invokevirtual 245	java/net/HttpURLConnection:disconnect	()V
    //   183: aload 6
    //   185: areturn
    //   186: astore_1
    //   187: aload 4
    //   189: astore_3
    //   190: new 226	com/braintreepayments/api/exceptions/UnexpectedException
    //   193: dup
    //   194: aload_1
    //   195: invokevirtual 248	java/io/IOException:getMessage	()Ljava/lang/String;
    //   198: invokespecial 250	com/braintreepayments/api/exceptions/UnexpectedException:<init>	(Ljava/lang/String;)V
    //   201: athrow
    //   202: astore_1
    //   203: aload_3
    //   204: ifnull +7 -> 211
    //   207: aload_3
    //   208: invokevirtual 245	java/net/HttpURLConnection:disconnect	()V
    //   211: aload_1
    //   212: athrow
    //   213: astore_1
    //   214: aload 5
    //   216: astore_3
    //   217: new 226	com/braintreepayments/api/exceptions/UnexpectedException
    //   220: dup
    //   221: aload_1
    //   222: invokevirtual 330	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   225: invokespecial 250	com/braintreepayments/api/exceptions/UnexpectedException:<init>	(Ljava/lang/String;)V
    //   228: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	229	0	this	HttpRequest
    //   0	229	1	paramString1	String
    //   0	229	2	paramString2	String
    //   15	202	3	localObject1	Object
    //   11	177	4	localObject2	Object
    //   18	197	5	localObject3	Object
    //   7	177	6	localObject4	Object
    //   1	45	7	localObject5	Object
    //   4	45	8	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   20	41	186	java/io/IOException
    //   52	58	186	java/io/IOException
    //   66	72	186	java/io/IOException
    //   80	85	186	java/io/IOException
    //   93	106	186	java/io/IOException
    //   114	120	186	java/io/IOException
    //   128	133	186	java/io/IOException
    //   141	146	186	java/io/IOException
    //   154	161	186	java/io/IOException
    //   169	175	186	java/io/IOException
    //   20	41	202	finally
    //   52	58	202	finally
    //   66	72	202	finally
    //   80	85	202	finally
    //   93	106	202	finally
    //   114	120	202	finally
    //   128	133	202	finally
    //   141	146	202	finally
    //   154	161	202	finally
    //   169	175	202	finally
    //   190	202	202	finally
    //   217	229	202	finally
    //   20	41	213	org/json/JSONException
    //   52	58	213	org/json/JSONException
    //   66	72	213	org/json/JSONException
    //   80	85	213	org/json/JSONException
    //   93	106	213	org/json/JSONException
    //   114	120	213	org/json/JSONException
    //   128	133	213	org/json/JSONException
    //   141	146	213	org/json/JSONException
    //   154	161	213	org/json/JSONException
    //   169	175	213	org/json/JSONException
  }
  
  protected void setConnectTimeout(int paramInt)
  {
    mConnectTimeout = paramInt;
  }
}

/* Location:
 * Qualified Name:     com.braintreepayments.api.internal.HttpRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */