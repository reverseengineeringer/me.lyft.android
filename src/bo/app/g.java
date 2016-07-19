package bo.app;

import com.appboy.Constants;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public final class g
  implements h
{
  private static final String a = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, g.class.getName() });
  private final int b = 5000;
  
  private static String a(BufferedReader paramBufferedReader)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    for (;;)
    {
      String str = paramBufferedReader.readLine();
      if (str == null) {
        break;
      }
      localStringBuilder.append(str);
    }
    return localStringBuilder.toString();
  }
  
  private JSONObject a(URI paramURI, JSONObject paramJSONObject, Map<String, String> paramMap, af paramaf)
  {
    Object localObject = null;
    URL localURL = fi.a(paramURI);
    paramURI = (URI)localObject;
    if (localURL != null) {}
    try
    {
      paramURI = a(localURL, paramJSONObject, paramMap, paramaf);
      return paramURI;
    }
    catch (IOException paramURI)
    {
      try
      {
        paramURI = a(localURL, paramJSONObject, paramMap, paramaf);
        return paramURI;
      }
      catch (IOException paramURI)
      {
        throw new bq(String.format("Experienced IOException twice during request to [%s], failing: [%s]", new Object[] { localURL.toString(), paramURI.getMessage() }), paramURI);
      }
    }
  }
  
  /* Error */
  private JSONObject a(URL paramURL, JSONObject paramJSONObject, Map<String, String> paramMap, af paramaf)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_1
    //   4: ifnull +321 -> 325
    //   7: aload_0
    //   8: aload_1
    //   9: aload_2
    //   10: aload_3
    //   11: aload 4
    //   13: invokespecial 88	bo/app/g:b	(Ljava/net/URL;Lorg/json/JSONObject;Ljava/util/Map;Lbo/app/af;)Ljava/net/HttpURLConnection;
    //   16: astore_2
    //   17: aload_2
    //   18: ifnull +302 -> 320
    //   21: aload_2
    //   22: invokevirtual 93	java/net/HttpURLConnection:connect	()V
    //   25: aload_2
    //   26: invokevirtual 97	java/net/HttpURLConnection:getResponseCode	()I
    //   29: bipush 100
    //   31: idiv
    //   32: iconst_2
    //   33: if_icmpne +112 -> 145
    //   36: ldc 99
    //   38: aload_2
    //   39: invokevirtual 102	java/net/HttpURLConnection:getContentEncoding	()Ljava/lang/String;
    //   42: invokevirtual 106	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   45: ifeq +63 -> 108
    //   48: new 108	java/util/zip/GZIPInputStream
    //   51: dup
    //   52: aload_2
    //   53: invokevirtual 112	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   56: invokespecial 115	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   59: astore_3
    //   60: new 45	java/io/BufferedReader
    //   63: dup
    //   64: new 117	java/io/InputStreamReader
    //   67: dup
    //   68: aload_3
    //   69: ldc 119
    //   71: invokespecial 122	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   74: invokespecial 125	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   77: astore 4
    //   79: new 127	org/json/JSONObject
    //   82: dup
    //   83: aload 4
    //   85: invokestatic 129	bo/app/g:a	(Ljava/io/BufferedReader;)Ljava/lang/String;
    //   88: invokespecial 132	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   91: astore 4
    //   93: aload_2
    //   94: ifnull +7 -> 101
    //   97: aload_2
    //   98: invokevirtual 135	java/net/HttpURLConnection:disconnect	()V
    //   101: aload_3
    //   102: invokevirtual 140	java/io/InputStream:close	()V
    //   105: aload 4
    //   107: areturn
    //   108: new 142	java/io/BufferedInputStream
    //   111: dup
    //   112: aload_2
    //   113: invokevirtual 112	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   116: invokespecial 143	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   119: astore_3
    //   120: goto -60 -> 60
    //   123: astore_1
    //   124: aload 5
    //   126: astore_3
    //   127: aload_2
    //   128: ifnull +7 -> 135
    //   131: aload_2
    //   132: invokevirtual 135	java/net/HttpURLConnection:disconnect	()V
    //   135: aload_3
    //   136: ifnull +7 -> 143
    //   139: aload_3
    //   140: invokevirtual 140	java/io/InputStream:close	()V
    //   143: aload_1
    //   144: athrow
    //   145: new 68	bo/app/bq
    //   148: dup
    //   149: ldc -111
    //   151: iconst_1
    //   152: anewarray 4	java/lang/Object
    //   155: dup
    //   156: iconst_0
    //   157: aload_2
    //   158: invokevirtual 97	java/net/HttpURLConnection:getResponseCode	()I
    //   161: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   164: aastore
    //   165: invokestatic 31	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   168: invokespecial 152	bo/app/bq:<init>	(Ljava/lang/String;)V
    //   171: athrow
    //   172: astore_1
    //   173: getstatic 33	bo/app/g:a	Ljava/lang/String;
    //   176: ldc -102
    //   178: aload_1
    //   179: invokestatic 160	com/appboy/support/AppboyLogger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   182: pop
    //   183: aload 4
    //   185: areturn
    //   186: astore 4
    //   188: getstatic 33	bo/app/g:a	Ljava/lang/String;
    //   191: ldc -94
    //   193: iconst_1
    //   194: anewarray 4	java/lang/Object
    //   197: dup
    //   198: iconst_0
    //   199: aload 4
    //   201: invokevirtual 76	java/io/IOException:getMessage	()Ljava/lang/String;
    //   204: aastore
    //   205: invokestatic 31	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   208: invokestatic 165	com/appboy/support/AppboyLogger:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   211: pop
    //   212: aload_2
    //   213: ifnull +7 -> 220
    //   216: aload_2
    //   217: invokevirtual 135	java/net/HttpURLConnection:disconnect	()V
    //   220: aload_3
    //   221: ifnull +7 -> 228
    //   224: aload_3
    //   225: invokevirtual 140	java/io/InputStream:close	()V
    //   228: getstatic 33	bo/app/g:a	Ljava/lang/String;
    //   231: ldc -89
    //   233: iconst_1
    //   234: anewarray 4	java/lang/Object
    //   237: dup
    //   238: iconst_0
    //   239: aload_1
    //   240: invokestatic 170	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   243: aastore
    //   244: invokestatic 31	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   247: invokestatic 173	com/appboy/support/AppboyLogger:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   250: pop
    //   251: aconst_null
    //   252: areturn
    //   253: astore 4
    //   255: getstatic 33	bo/app/g:a	Ljava/lang/String;
    //   258: ldc -81
    //   260: iconst_1
    //   261: anewarray 4	java/lang/Object
    //   264: dup
    //   265: iconst_0
    //   266: aload 4
    //   268: aastore
    //   269: invokestatic 31	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   272: invokestatic 165	com/appboy/support/AppboyLogger:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   275: pop
    //   276: goto -64 -> 212
    //   279: astore_1
    //   280: goto -153 -> 127
    //   283: astore_2
    //   284: getstatic 33	bo/app/g:a	Ljava/lang/String;
    //   287: ldc -102
    //   289: aload_2
    //   290: invokestatic 160	com/appboy/support/AppboyLogger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   293: pop
    //   294: goto -66 -> 228
    //   297: astore_2
    //   298: getstatic 33	bo/app/g:a	Ljava/lang/String;
    //   301: ldc -102
    //   303: aload_2
    //   304: invokestatic 160	com/appboy/support/AppboyLogger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   307: pop
    //   308: goto -165 -> 143
    //   311: astore_1
    //   312: aconst_null
    //   313: astore_2
    //   314: aload 5
    //   316: astore_3
    //   317: goto -190 -> 127
    //   320: aconst_null
    //   321: astore_3
    //   322: goto -110 -> 212
    //   325: aconst_null
    //   326: astore_2
    //   327: goto -310 -> 17
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	330	0	this	g
    //   0	330	1	paramURL	URL
    //   0	330	2	paramJSONObject	JSONObject
    //   0	330	3	paramMap	Map<String, String>
    //   0	330	4	paramaf	af
    //   1	314	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   21	60	123	finally
    //   108	120	123	finally
    //   145	172	123	finally
    //   101	105	172	java/lang/Exception
    //   79	93	186	java/io/IOException
    //   79	93	253	org/json/JSONException
    //   60	79	279	finally
    //   79	93	279	finally
    //   188	212	279	finally
    //   255	276	279	finally
    //   224	228	283	java/lang/Exception
    //   139	143	297	java/lang/Exception
    //   7	17	311	finally
  }
  
  private HttpURLConnection b(URL paramURL, JSONObject paramJSONObject, Map<String, String> paramMap, af paramaf)
  {
    HttpURLConnection localHttpURLConnection;
    try
    {
      localHttpURLConnection = (HttpURLConnection)paramURL.openConnection();
      localHttpURLConnection.setConnectTimeout(5000);
      localHttpURLConnection.setReadTimeout(b);
      localHttpURLConnection.setInstanceFollowRedirects(false);
      localHttpURLConnection.setRequestMethod(paramaf.toString());
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        localHttpURLConnection.setRequestProperty((String)localEntry.getKey(), (String)localEntry.getValue());
      }
      if (paramaf != af.b) {
        break label183;
      }
    }
    catch (IOException paramJSONObject)
    {
      throw new bq(String.format("Could not setup connection [%s] [%s].  Appboy will try to reconnect periodically.", new Object[] { paramURL.toString(), paramJSONObject.getMessage() }), paramJSONObject);
    }
    localHttpURLConnection.setDoOutput(true);
    paramMap = new BufferedOutputStream(localHttpURLConnection.getOutputStream());
    paramMap.write(paramJSONObject.toString().getBytes("UTF-8"));
    paramMap.flush();
    paramMap.close();
    label183:
    return localHttpURLConnection;
  }
  
  public final JSONObject a(URI paramURI, Map<String, String> paramMap)
  {
    return a(paramURI, null, paramMap, af.a);
  }
  
  public final JSONObject a(URI paramURI, Map<String, String> paramMap, JSONObject paramJSONObject)
  {
    return a(paramURI, paramJSONObject, paramMap, af.b);
  }
}

/* Location:
 * Qualified Name:     bo.app.g
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */