package io.fabric.sdk.android.services.network;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.zip.GZIPInputStream;

public class HttpRequest
{
  private static ConnectionFactory CONNECTION_FACTORY = ConnectionFactory.DEFAULT;
  private static final String[] EMPTY_STRINGS = new String[0];
  private int bufferSize = 8192;
  private HttpURLConnection connection = null;
  private String httpProxyHost;
  private int httpProxyPort;
  private boolean ignoreCloseExceptions = true;
  private boolean multipart;
  private RequestOutputStream output;
  private final String requestMethod;
  private boolean uncompress = false;
  public final URL url;
  
  public HttpRequest(CharSequence paramCharSequence, String paramString)
    throws HttpRequest.HttpRequestException
  {
    try
    {
      url = new URL(paramCharSequence.toString());
      requestMethod = paramString;
      return;
    }
    catch (MalformedURLException paramCharSequence)
    {
      throw new HttpRequestException(paramCharSequence);
    }
  }
  
  private static StringBuilder addParamPrefix(String paramString, StringBuilder paramStringBuilder)
  {
    int i = paramString.indexOf('?');
    int j = paramStringBuilder.length() - 1;
    if (i == -1) {
      paramStringBuilder.append('?');
    }
    while ((i >= j) || (paramString.charAt(j) == '&')) {
      return paramStringBuilder;
    }
    paramStringBuilder.append('&');
    return paramStringBuilder;
  }
  
  private static StringBuilder addPathSeparator(String paramString, StringBuilder paramStringBuilder)
  {
    if (paramString.indexOf(':') + 2 == paramString.lastIndexOf('/')) {
      paramStringBuilder.append('/');
    }
    return paramStringBuilder;
  }
  
  public static String append(CharSequence paramCharSequence, Map<?, ?> paramMap)
  {
    Object localObject = paramCharSequence.toString();
    if ((paramMap == null) || (paramMap.isEmpty())) {
      return (String)localObject;
    }
    paramCharSequence = new StringBuilder((String)localObject);
    addPathSeparator((String)localObject, paramCharSequence);
    addParamPrefix((String)localObject, paramCharSequence);
    paramMap = paramMap.entrySet().iterator();
    localObject = (Map.Entry)paramMap.next();
    paramCharSequence.append(((Map.Entry)localObject).getKey().toString());
    paramCharSequence.append('=');
    localObject = ((Map.Entry)localObject).getValue();
    if (localObject != null) {
      paramCharSequence.append(localObject);
    }
    while (paramMap.hasNext())
    {
      paramCharSequence.append('&');
      localObject = (Map.Entry)paramMap.next();
      paramCharSequence.append(((Map.Entry)localObject).getKey().toString());
      paramCharSequence.append('=');
      localObject = ((Map.Entry)localObject).getValue();
      if (localObject != null) {
        paramCharSequence.append(localObject);
      }
    }
    return paramCharSequence.toString();
  }
  
  /* Error */
  private HttpURLConnection createConnection()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 174	io/fabric/sdk/android/services/network/HttpRequest:httpProxyHost	Ljava/lang/String;
    //   4: ifnull +30 -> 34
    //   7: getstatic 54	io/fabric/sdk/android/services/network/HttpRequest:CONNECTION_FACTORY	Lio/fabric/sdk/android/services/network/HttpRequest$ConnectionFactory;
    //   10: aload_0
    //   11: getfield 82	io/fabric/sdk/android/services/network/HttpRequest:url	Ljava/net/URL;
    //   14: aload_0
    //   15: invokespecial 178	io/fabric/sdk/android/services/network/HttpRequest:createProxy	()Ljava/net/Proxy;
    //   18: invokeinterface 182 3 0
    //   23: astore_1
    //   24: aload_1
    //   25: aload_0
    //   26: getfield 84	io/fabric/sdk/android/services/network/HttpRequest:requestMethod	Ljava/lang/String;
    //   29: invokevirtual 187	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   32: aload_1
    //   33: areturn
    //   34: getstatic 54	io/fabric/sdk/android/services/network/HttpRequest:CONNECTION_FACTORY	Lio/fabric/sdk/android/services/network/HttpRequest$ConnectionFactory;
    //   37: aload_0
    //   38: getfield 82	io/fabric/sdk/android/services/network/HttpRequest:url	Ljava/net/URL;
    //   41: invokeinterface 190 2 0
    //   46: astore_1
    //   47: goto -23 -> 24
    //   50: astore_1
    //   51: new 16	io/fabric/sdk/android/services/network/HttpRequest$HttpRequestException
    //   54: dup
    //   55: aload_1
    //   56: invokespecial 87	io/fabric/sdk/android/services/network/HttpRequest$HttpRequestException:<init>	(Ljava/io/IOException;)V
    //   59: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	this	HttpRequest
    //   23	24	1	localHttpURLConnection	HttpURLConnection
    //   50	6	1	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   0	24	50	java/io/IOException
    //   24	32	50	java/io/IOException
    //   34	47	50	java/io/IOException
  }
  
  private Proxy createProxy()
  {
    return new Proxy(Proxy.Type.HTTP, new InetSocketAddress(httpProxyHost, httpProxyPort));
  }
  
  public static HttpRequest delete(CharSequence paramCharSequence)
    throws HttpRequest.HttpRequestException
  {
    return new HttpRequest(paramCharSequence, "DELETE");
  }
  
  /* Error */
  public static String encode(CharSequence paramCharSequence)
    throws HttpRequest.HttpRequestException
  {
    // Byte code:
    //   0: new 71	java/net/URL
    //   3: dup
    //   4: aload_0
    //   5: invokeinterface 77 1 0
    //   10: invokespecial 80	java/net/URL:<init>	(Ljava/lang/String;)V
    //   13: astore_3
    //   14: aload_3
    //   15: invokevirtual 221	java/net/URL:getHost	()Ljava/lang/String;
    //   18: astore_2
    //   19: aload_3
    //   20: invokevirtual 224	java/net/URL:getPort	()I
    //   23: istore_1
    //   24: aload_2
    //   25: astore_0
    //   26: iload_1
    //   27: iconst_m1
    //   28: if_icmpeq +30 -> 58
    //   31: new 103	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 225	java/lang/StringBuilder:<init>	()V
    //   38: aload_2
    //   39: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: bipush 58
    //   44: invokevirtual 111	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   47: iload_1
    //   48: invokestatic 230	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   51: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: invokevirtual 166	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: astore_0
    //   58: new 232	java/net/URI
    //   61: dup
    //   62: aload_3
    //   63: invokevirtual 235	java/net/URL:getProtocol	()Ljava/lang/String;
    //   66: aload_0
    //   67: aload_3
    //   68: invokevirtual 238	java/net/URL:getPath	()Ljava/lang/String;
    //   71: aload_3
    //   72: invokevirtual 241	java/net/URL:getQuery	()Ljava/lang/String;
    //   75: aconst_null
    //   76: invokespecial 244	java/net/URI:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   79: invokevirtual 247	java/net/URI:toASCIIString	()Ljava/lang/String;
    //   82: astore_2
    //   83: aload_2
    //   84: bipush 63
    //   86: invokevirtual 101	java/lang/String:indexOf	(I)I
    //   89: istore_1
    //   90: aload_2
    //   91: astore_0
    //   92: iload_1
    //   93: ifle +56 -> 149
    //   96: aload_2
    //   97: astore_0
    //   98: iload_1
    //   99: iconst_1
    //   100: iadd
    //   101: aload_2
    //   102: invokevirtual 248	java/lang/String:length	()I
    //   105: if_icmpge +44 -> 149
    //   108: new 103	java/lang/StringBuilder
    //   111: dup
    //   112: invokespecial 225	java/lang/StringBuilder:<init>	()V
    //   115: aload_2
    //   116: iconst_0
    //   117: iload_1
    //   118: iconst_1
    //   119: iadd
    //   120: invokevirtual 252	java/lang/String:substring	(II)Ljava/lang/String;
    //   123: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: aload_2
    //   127: iload_1
    //   128: iconst_1
    //   129: iadd
    //   130: invokevirtual 254	java/lang/String:substring	(I)Ljava/lang/String;
    //   133: ldc_w 256
    //   136: ldc_w 258
    //   139: invokevirtual 262	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   142: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: invokevirtual 166	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   148: astore_0
    //   149: aload_0
    //   150: areturn
    //   151: astore_0
    //   152: new 16	io/fabric/sdk/android/services/network/HttpRequest$HttpRequestException
    //   155: dup
    //   156: aload_0
    //   157: invokespecial 87	io/fabric/sdk/android/services/network/HttpRequest$HttpRequestException:<init>	(Ljava/io/IOException;)V
    //   160: athrow
    //   161: astore_0
    //   162: new 172	java/io/IOException
    //   165: dup
    //   166: ldc_w 264
    //   169: invokespecial 265	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   172: astore_2
    //   173: aload_2
    //   174: aload_0
    //   175: invokevirtual 269	java/io/IOException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   178: pop
    //   179: new 16	io/fabric/sdk/android/services/network/HttpRequest$HttpRequestException
    //   182: dup
    //   183: aload_2
    //   184: invokespecial 87	io/fabric/sdk/android/services/network/HttpRequest$HttpRequestException:<init>	(Ljava/io/IOException;)V
    //   187: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	188	0	paramCharSequence	CharSequence
    //   23	107	1	i	int
    //   18	166	2	localObject	Object
    //   13	59	3	localURL	URL
    // Exception table:
    //   from	to	target	type
    //   0	14	151	java/io/IOException
    //   58	90	161	java/net/URISyntaxException
    //   98	149	161	java/net/URISyntaxException
  }
  
  public static HttpRequest get(CharSequence paramCharSequence)
    throws HttpRequest.HttpRequestException
  {
    return new HttpRequest(paramCharSequence, "GET");
  }
  
  public static HttpRequest get(CharSequence paramCharSequence, Map<?, ?> paramMap, boolean paramBoolean)
  {
    paramMap = append(paramCharSequence, paramMap);
    paramCharSequence = paramMap;
    if (paramBoolean) {
      paramCharSequence = encode(paramMap);
    }
    return get(paramCharSequence);
  }
  
  private static String getValidCharset(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0)) {
      return paramString;
    }
    return "UTF-8";
  }
  
  public static HttpRequest post(CharSequence paramCharSequence)
    throws HttpRequest.HttpRequestException
  {
    return new HttpRequest(paramCharSequence, "POST");
  }
  
  public static HttpRequest post(CharSequence paramCharSequence, Map<?, ?> paramMap, boolean paramBoolean)
  {
    paramMap = append(paramCharSequence, paramMap);
    paramCharSequence = paramMap;
    if (paramBoolean) {
      paramCharSequence = encode(paramMap);
    }
    return post(paramCharSequence);
  }
  
  public static HttpRequest put(CharSequence paramCharSequence)
    throws HttpRequest.HttpRequestException
  {
    return new HttpRequest(paramCharSequence, "PUT");
  }
  
  public String body()
    throws HttpRequest.HttpRequestException
  {
    return body(charset());
  }
  
  public String body(String paramString)
    throws HttpRequest.HttpRequestException
  {
    ByteArrayOutputStream localByteArrayOutputStream = byteStream();
    try
    {
      copy(buffer(), localByteArrayOutputStream);
      paramString = localByteArrayOutputStream.toString(getValidCharset(paramString));
      return paramString;
    }
    catch (IOException paramString)
    {
      throw new HttpRequestException(paramString);
    }
  }
  
  public BufferedInputStream buffer()
    throws HttpRequest.HttpRequestException
  {
    return new BufferedInputStream(stream(), bufferSize);
  }
  
  protected ByteArrayOutputStream byteStream()
  {
    int i = contentLength();
    if (i > 0) {
      return new ByteArrayOutputStream(i);
    }
    return new ByteArrayOutputStream();
  }
  
  public String charset()
  {
    return parameter("Content-Type", "charset");
  }
  
  protected HttpRequest closeOutput()
    throws IOException
  {
    if (output == null) {
      return this;
    }
    if (multipart) {
      output.write("\r\n--00content0boundary00--\r\n");
    }
    if (ignoreCloseExceptions) {}
    try
    {
      output.close();
      for (;;)
      {
        output = null;
        return this;
        output.close();
      }
    }
    catch (IOException localIOException)
    {
      for (;;) {}
    }
  }
  
  protected HttpRequest closeOutputQuietly()
    throws HttpRequest.HttpRequestException
  {
    try
    {
      HttpRequest localHttpRequest = closeOutput();
      return localHttpRequest;
    }
    catch (IOException localIOException)
    {
      throw new HttpRequestException(localIOException);
    }
  }
  
  public int code()
    throws HttpRequest.HttpRequestException
  {
    try
    {
      closeOutput();
      int i = getConnection().getResponseCode();
      return i;
    }
    catch (IOException localIOException)
    {
      throw new HttpRequestException(localIOException);
    }
  }
  
  public HttpRequest connectTimeout(int paramInt)
  {
    getConnection().setConnectTimeout(paramInt);
    return this;
  }
  
  public String contentEncoding()
  {
    return header("Content-Encoding");
  }
  
  public int contentLength()
  {
    return intHeader("Content-Length");
  }
  
  public HttpRequest contentType(String paramString)
  {
    return contentType(paramString, null);
  }
  
  public HttpRequest contentType(String paramString1, String paramString2)
  {
    if ((paramString2 != null) && (paramString2.length() > 0)) {
      return header("Content-Type", paramString1 + "; charset=" + paramString2);
    }
    return header("Content-Type", paramString1);
  }
  
  protected HttpRequest copy(final InputStream paramInputStream, final OutputStream paramOutputStream)
    throws IOException
  {
    (HttpRequest)new CloseOperation(paramInputStream, ignoreCloseExceptions)
    {
      public HttpRequest run()
        throws IOException
      {
        byte[] arrayOfByte = new byte[bufferSize];
        for (;;)
        {
          int i = paramInputStream.read(arrayOfByte);
          if (i == -1) {
            break;
          }
          paramOutputStream.write(arrayOfByte, 0, i);
        }
        return HttpRequest.this;
      }
    }.call();
  }
  
  public HttpURLConnection getConnection()
  {
    if (connection == null) {
      connection = createConnection();
    }
    return connection;
  }
  
  protected String getParam(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString1.length() == 0))
    {
      paramString1 = null;
      return paramString1;
    }
    int j = paramString1.length();
    int m = paramString1.indexOf(';') + 1;
    if ((m == 0) || (m == j)) {
      return null;
    }
    int n = paramString1.indexOf(';', m);
    int i = n;
    int k = m;
    if (n == -1)
    {
      i = j;
      k = m;
    }
    for (;;)
    {
      if (k >= i) {
        break label236;
      }
      m = paramString1.indexOf('=', k);
      if ((m != -1) && (m < i) && (paramString2.equals(paramString1.substring(k, m).trim())))
      {
        String str = paramString1.substring(m + 1, i).trim();
        k = str.length();
        if (k != 0)
        {
          paramString1 = str;
          if (k <= 2) {
            break;
          }
          paramString1 = str;
          if ('"' != str.charAt(0)) {
            break;
          }
          paramString1 = str;
          if ('"' != str.charAt(k - 1)) {
            break;
          }
          return str.substring(1, k - 1);
        }
      }
      m = i + 1;
      n = paramString1.indexOf(';', m);
      i = n;
      k = m;
      if (n == -1)
      {
        i = j;
        k = m;
      }
    }
    label236:
    return null;
  }
  
  public HttpRequest header(String paramString1, String paramString2)
  {
    getConnection().setRequestProperty(paramString1, paramString2);
    return this;
  }
  
  public HttpRequest header(Map.Entry<String, String> paramEntry)
  {
    return header((String)paramEntry.getKey(), (String)paramEntry.getValue());
  }
  
  public String header(String paramString)
    throws HttpRequest.HttpRequestException
  {
    closeOutputQuietly();
    return getConnection().getHeaderField(paramString);
  }
  
  public int intHeader(String paramString)
    throws HttpRequest.HttpRequestException
  {
    return intHeader(paramString, -1);
  }
  
  public int intHeader(String paramString, int paramInt)
    throws HttpRequest.HttpRequestException
  {
    closeOutputQuietly();
    return getConnection().getHeaderFieldInt(paramString, paramInt);
  }
  
  public String method()
  {
    return getConnection().getRequestMethod();
  }
  
  public boolean ok()
    throws HttpRequest.HttpRequestException
  {
    return 200 == code();
  }
  
  protected HttpRequest openOutput()
    throws IOException
  {
    if (output != null) {
      return this;
    }
    getConnection().setDoOutput(true);
    String str = getParam(getConnection().getRequestProperty("Content-Type"), "charset");
    output = new RequestOutputStream(getConnection().getOutputStream(), str, bufferSize);
    return this;
  }
  
  public String parameter(String paramString1, String paramString2)
  {
    return getParam(header(paramString1), paramString2);
  }
  
  public HttpRequest part(String paramString, Number paramNumber)
    throws HttpRequest.HttpRequestException
  {
    return part(paramString, null, paramNumber);
  }
  
  public HttpRequest part(String paramString1, String paramString2)
  {
    return part(paramString1, null, paramString2);
  }
  
  public HttpRequest part(String paramString1, String paramString2, Number paramNumber)
    throws HttpRequest.HttpRequestException
  {
    if (paramNumber != null) {}
    for (paramNumber = paramNumber.toString();; paramNumber = null) {
      return part(paramString1, paramString2, paramNumber);
    }
  }
  
  public HttpRequest part(String paramString1, String paramString2, String paramString3)
    throws HttpRequest.HttpRequestException
  {
    return part(paramString1, paramString2, null, paramString3);
  }
  
  /* Error */
  public HttpRequest part(String paramString1, String paramString2, String paramString3, java.io.File paramFile)
    throws HttpRequest.HttpRequestException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 6
    //   6: new 314	java/io/BufferedInputStream
    //   9: dup
    //   10: new 460	java/io/FileInputStream
    //   13: dup
    //   14: aload 4
    //   16: invokespecial 463	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   19: invokespecial 466	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   22: astore 4
    //   24: aload_0
    //   25: aload_1
    //   26: aload_2
    //   27: aload_3
    //   28: aload 4
    //   30: invokevirtual 469	io/fabric/sdk/android/services/network/HttpRequest:part	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/io/InputStream;)Lio/fabric/sdk/android/services/network/HttpRequest;
    //   33: astore_1
    //   34: aload 4
    //   36: ifnull +8 -> 44
    //   39: aload 4
    //   41: invokevirtual 472	java/io/InputStream:close	()V
    //   44: aload_1
    //   45: areturn
    //   46: astore_1
    //   47: aload 6
    //   49: astore 5
    //   51: new 16	io/fabric/sdk/android/services/network/HttpRequest$HttpRequestException
    //   54: dup
    //   55: aload_1
    //   56: invokespecial 87	io/fabric/sdk/android/services/network/HttpRequest$HttpRequestException:<init>	(Ljava/io/IOException;)V
    //   59: athrow
    //   60: astore_1
    //   61: aload 5
    //   63: ifnull +8 -> 71
    //   66: aload 5
    //   68: invokevirtual 472	java/io/InputStream:close	()V
    //   71: aload_1
    //   72: athrow
    //   73: astore_2
    //   74: aload_1
    //   75: areturn
    //   76: astore_2
    //   77: goto -6 -> 71
    //   80: astore_1
    //   81: aload 4
    //   83: astore 5
    //   85: goto -24 -> 61
    //   88: astore_1
    //   89: aload 4
    //   91: astore 5
    //   93: goto -42 -> 51
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	this	HttpRequest
    //   0	96	1	paramString1	String
    //   0	96	2	paramString2	String
    //   0	96	3	paramString3	String
    //   0	96	4	paramFile	java.io.File
    //   1	91	5	localObject1	Object
    //   4	44	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   6	24	46	java/io/IOException
    //   6	24	60	finally
    //   51	60	60	finally
    //   39	44	73	java/io/IOException
    //   66	71	76	java/io/IOException
    //   24	34	80	finally
    //   24	34	88	java/io/IOException
  }
  
  public HttpRequest part(String paramString1, String paramString2, String paramString3, InputStream paramInputStream)
    throws HttpRequest.HttpRequestException
  {
    try
    {
      startPart();
      writePartHeader(paramString1, paramString2, paramString3);
      copy(paramInputStream, output);
      return this;
    }
    catch (IOException paramString1)
    {
      throw new HttpRequestException(paramString1);
    }
  }
  
  public HttpRequest part(String paramString1, String paramString2, String paramString3, String paramString4)
    throws HttpRequest.HttpRequestException
  {
    try
    {
      startPart();
      writePartHeader(paramString1, paramString2, paramString3);
      output.write(paramString4);
      return this;
    }
    catch (IOException paramString1)
    {
      throw new HttpRequestException(paramString1);
    }
  }
  
  public HttpRequest partHeader(String paramString1, String paramString2)
    throws HttpRequest.HttpRequestException
  {
    return send(paramString1).send(": ").send(paramString2).send("\r\n");
  }
  
  public HttpRequest send(CharSequence paramCharSequence)
    throws HttpRequest.HttpRequestException
  {
    try
    {
      openOutput();
      output.write(paramCharSequence.toString());
      return this;
    }
    catch (IOException paramCharSequence)
    {
      throw new HttpRequestException(paramCharSequence);
    }
  }
  
  protected HttpRequest startPart()
    throws IOException
  {
    if (!multipart)
    {
      multipart = true;
      contentType("multipart/form-data; boundary=00content0boundary00").openOutput();
      output.write("--00content0boundary00\r\n");
      return this;
    }
    output.write("\r\n--00content0boundary00\r\n");
    return this;
  }
  
  public InputStream stream()
    throws HttpRequest.HttpRequestException
  {
    if (code() < 400) {}
    for (;;)
    {
      try
      {
        InputStream localInputStream1 = getConnection().getInputStream();
        if ((uncompress) && ("gzip".equals(contentEncoding()))) {
          break;
        }
        return localInputStream1;
      }
      catch (IOException localIOException1)
      {
        throw new HttpRequestException(localIOException1);
      }
      InputStream localInputStream2 = getConnection().getErrorStream();
      Object localObject = localInputStream2;
      if (localInputStream2 == null) {
        try
        {
          localObject = getConnection().getInputStream();
        }
        catch (IOException localIOException2)
        {
          throw new HttpRequestException(localIOException2);
        }
      }
    }
    try
    {
      GZIPInputStream localGZIPInputStream = new GZIPInputStream(localIOException2);
      return localGZIPInputStream;
    }
    catch (IOException localIOException3)
    {
      throw new HttpRequestException(localIOException3);
    }
  }
  
  public String toString()
  {
    return method() + ' ' + url();
  }
  
  public URL url()
  {
    return getConnection().getURL();
  }
  
  public HttpRequest useCaches(boolean paramBoolean)
  {
    getConnection().setUseCaches(paramBoolean);
    return this;
  }
  
  protected HttpRequest writePartHeader(String paramString1, String paramString2, String paramString3)
    throws IOException
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("form-data; name=\"").append(paramString1);
    if (paramString2 != null) {
      localStringBuilder.append("\"; filename=\"").append(paramString2);
    }
    localStringBuilder.append('"');
    partHeader("Content-Disposition", localStringBuilder.toString());
    if (paramString3 != null) {
      partHeader("Content-Type", paramString3);
    }
    return send("\r\n");
  }
  
  protected static abstract class CloseOperation<V>
    extends HttpRequest.Operation<V>
  {
    private final Closeable closeable;
    private final boolean ignoreCloseExceptions;
    
    protected CloseOperation(Closeable paramCloseable, boolean paramBoolean)
    {
      closeable = paramCloseable;
      ignoreCloseExceptions = paramBoolean;
    }
    
    protected void done()
      throws IOException
    {
      if ((closeable instanceof Flushable)) {
        ((Flushable)closeable).flush();
      }
      if (ignoreCloseExceptions) {}
      try
      {
        closeable.close();
        return;
      }
      catch (IOException localIOException) {}
      closeable.close();
      return;
    }
  }
  
  public static abstract interface ConnectionFactory
  {
    public static final ConnectionFactory DEFAULT = new ConnectionFactory()
    {
      public HttpURLConnection create(URL paramAnonymousURL)
        throws IOException
      {
        return (HttpURLConnection)paramAnonymousURL.openConnection();
      }
      
      public HttpURLConnection create(URL paramAnonymousURL, Proxy paramAnonymousProxy)
        throws IOException
      {
        return (HttpURLConnection)paramAnonymousURL.openConnection(paramAnonymousProxy);
      }
    };
    
    public abstract HttpURLConnection create(URL paramURL)
      throws IOException;
    
    public abstract HttpURLConnection create(URL paramURL, Proxy paramProxy)
      throws IOException;
  }
  
  public static class HttpRequestException
    extends RuntimeException
  {
    private static final long serialVersionUID = -1170466989781746231L;
    
    protected HttpRequestException(IOException paramIOException)
    {
      super();
    }
    
    public IOException getCause()
    {
      return (IOException)super.getCause();
    }
  }
  
  protected static abstract class Operation<V>
    implements Callable<V>
  {
    /* Error */
    public V call()
      throws HttpRequest.HttpRequestException
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore_1
      //   2: aload_0
      //   3: invokevirtual 24	io/fabric/sdk/android/services/network/HttpRequest$Operation:run	()Ljava/lang/Object;
      //   6: astore_2
      //   7: aload_0
      //   8: invokevirtual 27	io/fabric/sdk/android/services/network/HttpRequest$Operation:done	()V
      //   11: aload_2
      //   12: areturn
      //   13: astore_3
      //   14: iconst_0
      //   15: ifne -4 -> 11
      //   18: new 19	io/fabric/sdk/android/services/network/HttpRequest$HttpRequestException
      //   21: dup
      //   22: aload_3
      //   23: invokespecial 30	io/fabric/sdk/android/services/network/HttpRequest$HttpRequestException:<init>	(Ljava/io/IOException;)V
      //   26: athrow
      //   27: astore_2
      //   28: iconst_1
      //   29: istore_1
      //   30: aload_2
      //   31: athrow
      //   32: astore_2
      //   33: aload_0
      //   34: invokevirtual 27	io/fabric/sdk/android/services/network/HttpRequest$Operation:done	()V
      //   37: aload_2
      //   38: athrow
      //   39: astore_2
      //   40: iconst_1
      //   41: istore_1
      //   42: new 19	io/fabric/sdk/android/services/network/HttpRequest$HttpRequestException
      //   45: dup
      //   46: aload_2
      //   47: invokespecial 30	io/fabric/sdk/android/services/network/HttpRequest$HttpRequestException:<init>	(Ljava/io/IOException;)V
      //   50: athrow
      //   51: astore_3
      //   52: iload_1
      //   53: ifne -16 -> 37
      //   56: new 19	io/fabric/sdk/android/services/network/HttpRequest$HttpRequestException
      //   59: dup
      //   60: aload_3
      //   61: invokespecial 30	io/fabric/sdk/android/services/network/HttpRequest$HttpRequestException:<init>	(Ljava/io/IOException;)V
      //   64: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	65	0	this	Operation
      //   1	52	1	i	int
      //   6	6	2	localObject1	Object
      //   27	4	2	localHttpRequestException	HttpRequest.HttpRequestException
      //   32	6	2	localObject2	Object
      //   39	8	2	localIOException1	IOException
      //   13	10	3	localIOException2	IOException
      //   51	10	3	localIOException3	IOException
      // Exception table:
      //   from	to	target	type
      //   7	11	13	java/io/IOException
      //   2	7	27	io/fabric/sdk/android/services/network/HttpRequest$HttpRequestException
      //   2	7	32	finally
      //   30	32	32	finally
      //   42	51	32	finally
      //   2	7	39	java/io/IOException
      //   33	37	51	java/io/IOException
    }
    
    protected abstract void done()
      throws IOException;
    
    protected abstract V run()
      throws HttpRequest.HttpRequestException, IOException;
  }
  
  public static class RequestOutputStream
    extends BufferedOutputStream
  {
    private final CharsetEncoder encoder;
    
    public RequestOutputStream(OutputStream paramOutputStream, String paramString, int paramInt)
    {
      super(paramInt);
      encoder = Charset.forName(HttpRequest.getValidCharset(paramString)).newEncoder();
    }
    
    public RequestOutputStream write(String paramString)
      throws IOException
    {
      paramString = encoder.encode(CharBuffer.wrap(paramString));
      super.write(paramString.array(), 0, paramString.limit());
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     io.fabric.sdk.android.services.network.HttpRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */