package com.stripe.net;

import com.google.gson.Gson;
import com.stripe.Stripe;
import com.stripe.exception.APIConnectionException;
import com.stripe.exception.APIException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLStreamHandler;
import java.security.Security;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class LiveStripeResponseGetter
  implements StripeResponseGetter
{
  private static final String CUSTOM_URL_STREAM_HANDLER_PROPERTY_NAME = "com.stripe.net.customURLStreamHandler";
  private static final String DNS_CACHE_TTL_PROPERTY_NAME = "networkaddress.cache.ttl";
  
  private static <T> T _request(APIResource.RequestMethod paramRequestMethod, String paramString, Map<String, Object> paramMap, Class<T> paramClass, APIResource.RequestType paramRequestType, RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    RequestOptions localRequestOptions = paramRequestOptions;
    if (paramRequestOptions == null) {
      localRequestOptions = RequestOptions.getDefault();
    }
    paramRequestOptions = null;
    Object localObject2 = Boolean.valueOf(true);
    try
    {
      Object localObject1 = Security.getProperty("networkaddress.cache.ttl");
      paramRequestOptions = (RequestOptions)localObject1;
      Security.setProperty("networkaddress.cache.ttl", "0");
      paramRequestOptions = (RequestOptions)localObject1;
      localObject1 = localObject2;
    }
    catch (SecurityException localSecurityException)
    {
      for (;;)
      {
        localBoolean = Boolean.valueOf(false);
      }
    }
    localObject2 = localRequestOptions.getApiKey();
    if ((localObject2 == null) || (((String)localObject2).trim().isEmpty())) {
      throw new AuthenticationException("No API key provided. (HINT: set your API key using 'Stripe.apiKey = <API-KEY>'. You can generate API keys from the Stripe web interface. See https://stripe.com/api for details or email support@stripe.com if you have questions.");
    }
    try
    {
      switch (paramRequestType)
      {
      case ???: 
        throw new RuntimeException("Invalid APIResource request type. This indicates a bug in the Stripe bindings. Please contact support@stripe.com for assistance.");
      }
    }
    finally
    {
      Boolean localBoolean;
      if (localBoolean.booleanValue())
      {
        if (paramRequestOptions == null) {
          Security.setProperty("networkaddress.cache.ttl", "-1");
        }
      }
      else
      {
        throw paramRequestMethod;
        for (paramRequestMethod = getStripeResponse(paramRequestMethod, paramString, paramMap, localRequestOptions);; paramRequestMethod = getMultipartStripeResponse(paramRequestMethod, paramString, paramMap, localRequestOptions))
        {
          int i = responseCode;
          paramRequestMethod = responseBody;
          if ((i < 200) || (i >= 300)) {
            handleAPIError(paramRequestMethod, i);
          }
          paramRequestMethod = APIResource.GSON.fromJson(paramRequestMethod, paramClass);
          if (localBoolean.booleanValue())
          {
            if (paramRequestOptions != null) {
              break;
            }
            Security.setProperty("networkaddress.cache.ttl", "-1");
          }
          return paramRequestMethod;
        }
        Security.setProperty("networkaddress.cache.ttl", paramRequestOptions);
        return paramRequestMethod;
      }
      Security.setProperty("networkaddress.cache.ttl", paramRequestOptions);
    }
  }
  
  private static HttpURLConnection createDeleteConnection(String paramString1, String paramString2, RequestOptions paramRequestOptions)
    throws IOException
  {
    paramString1 = createStripeConnection(formatURL(paramString1, paramString2), paramRequestOptions);
    paramString1.setRequestMethod("DELETE");
    return paramString1;
  }
  
  private static HttpURLConnection createGetConnection(String paramString1, String paramString2, RequestOptions paramRequestOptions)
    throws IOException
  {
    paramString1 = createStripeConnection(formatURL(paramString1, paramString2), paramRequestOptions);
    paramString1.setRequestMethod("GET");
    return paramString1;
  }
  
  private static HttpURLConnection createPostConnection(String paramString1, String paramString2, RequestOptions paramRequestOptions)
    throws IOException
  {
    HttpURLConnection localHttpURLConnection = createStripeConnection(paramString1, paramRequestOptions);
    localHttpURLConnection.setDoOutput(true);
    localHttpURLConnection.setRequestMethod("POST");
    localHttpURLConnection.setRequestProperty("Content-Type", String.format("application/x-www-form-urlencoded;charset=%s", new Object[] { "UTF-8" }));
    paramString1 = null;
    try
    {
      paramRequestOptions = localHttpURLConnection.getOutputStream();
      paramString1 = paramRequestOptions;
      paramRequestOptions.write(paramString2.getBytes("UTF-8"));
      return localHttpURLConnection;
    }
    finally
    {
      if (paramString1 != null) {
        paramString1.close();
      }
    }
  }
  
  static String createQuery(Map<String, Object> paramMap)
    throws UnsupportedEncodingException, InvalidRequestException
  {
    Object localObject = flattenParams(paramMap);
    paramMap = new StringBuilder();
    localObject = ((Map)localObject).entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      if (paramMap.length() > 0) {
        paramMap.append("&");
      }
      paramMap.append(urlEncodePair((String)localEntry.getKey(), (String)localEntry.getValue()));
    }
    return paramMap.toString();
  }
  
  private static HttpURLConnection createStripeConnection(String paramString, RequestOptions paramRequestOptions)
    throws IOException
  {
    Object localObject = System.getProperty("com.stripe.net.customURLStreamHandler", null);
    if (localObject != null) {}
    for (;;)
    {
      try
      {
        paramString = new URL(null, paramString, (URLStreamHandler)Class.forName((String)localObject).getConstructor(new Class[0]).newInstance(new Object[0]));
        paramString = (HttpURLConnection)paramString.openConnection();
        paramString.setConnectTimeout(30000);
        paramString.setReadTimeout(80000);
        paramString.setUseCaches(false);
        paramRequestOptions = getHeaders(paramRequestOptions).entrySet().iterator();
        if (!paramRequestOptions.hasNext()) {
          break;
        }
        localObject = (Map.Entry)paramRequestOptions.next();
        paramString.setRequestProperty((String)((Map.Entry)localObject).getKey(), (String)((Map.Entry)localObject).getValue());
        continue;
        paramString = new URL(paramString);
      }
      catch (ClassNotFoundException paramString)
      {
        throw new IOException(paramString);
      }
      catch (SecurityException paramString)
      {
        throw new IOException(paramString);
      }
      catch (NoSuchMethodException paramString)
      {
        throw new IOException(paramString);
      }
      catch (IllegalArgumentException paramString)
      {
        throw new IOException(paramString);
      }
      catch (InstantiationException paramString)
      {
        throw new IOException(paramString);
      }
      catch (IllegalAccessException paramString)
      {
        throw new IOException(paramString);
      }
      catch (InvocationTargetException paramString)
      {
        throw new IOException(paramString);
      }
    }
    return paramString;
  }
  
  private static Map<String, String> flattenParams(Map<String, Object> paramMap)
    throws InvalidRequestException
  {
    if (paramMap == null)
    {
      paramMap = new HashMap();
      return paramMap;
    }
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    Iterator localIterator = paramMap.entrySet().iterator();
    for (;;)
    {
      paramMap = localLinkedHashMap;
      if (!localIterator.hasNext()) {
        break;
      }
      Object localObject1 = (Map.Entry)localIterator.next();
      paramMap = (String)((Map.Entry)localObject1).getKey();
      Object localObject2 = ((Map.Entry)localObject1).getValue();
      if ((localObject2 instanceof Map))
      {
        localObject1 = new LinkedHashMap();
        localObject2 = ((Map)localObject2).entrySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
          ((Map)localObject1).put(String.format("%s[%s]", new Object[] { paramMap, localEntry.getKey() }), localEntry.getValue());
        }
        localLinkedHashMap.putAll(flattenParams((Map)localObject1));
      }
      else if ((localObject2 instanceof List))
      {
        localObject1 = new LinkedHashMap();
        localObject2 = ((List)localObject2).iterator();
        int i = 0;
        while (((Iterator)localObject2).hasNext())
        {
          ((Map)localObject1).put(String.format("%s[%s]", new Object[] { paramMap, Integer.valueOf(i) }), ((Iterator)localObject2).next());
          i += 1;
        }
        localLinkedHashMap.putAll(flattenParams((Map)localObject1));
      }
      else
      {
        if ("".equals(localObject2)) {
          throw new InvalidRequestException("You cannot set '" + paramMap + "' to an empty string. " + "We interpret empty strings as null in requests. " + "You may set '" + paramMap + "' to null to delete the property.", paramMap, null);
        }
        if (localObject2 == null) {
          localLinkedHashMap.put(paramMap, "");
        } else {
          localLinkedHashMap.put(paramMap, localObject2.toString());
        }
      }
    }
  }
  
  private static String formatURL(String paramString1, String paramString2)
  {
    if ((paramString2 == null) || (paramString2.isEmpty())) {
      return paramString1;
    }
    if (paramString1.contains("?")) {}
    for (String str = "&";; str = "?") {
      return String.format("%s%s%s", new Object[] { paramString1, str, paramString2 });
    }
  }
  
  static Map<String, String> getHeaders(RequestOptions paramRequestOptions)
  {
    HashMap localHashMap1 = new HashMap();
    String str1 = paramRequestOptions.getStripeVersion();
    localHashMap1.put("Accept-Charset", "UTF-8");
    localHashMap1.put("Accept", "application/json");
    localHashMap1.put("User-Agent", String.format("Stripe/v1 JavaBindings/%s", new Object[] { "1.31.0" }));
    localHashMap1.put("Authorization", String.format("Bearer %s", new Object[] { paramRequestOptions.getApiKey() }));
    String[] arrayOfString = new String[7];
    arrayOfString[0] = "os.name";
    arrayOfString[1] = "os.version";
    arrayOfString[2] = "os.arch";
    arrayOfString[3] = "java.version";
    arrayOfString[4] = "java.vendor";
    arrayOfString[5] = "java.vm.version";
    arrayOfString[6] = "java.vm.vendor";
    HashMap localHashMap2 = new HashMap();
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str2 = arrayOfString[i];
      localHashMap2.put(str2, System.getProperty(str2));
      i += 1;
    }
    localHashMap2.put("bindings.version", "1.31.0");
    localHashMap2.put("lang", "Java");
    localHashMap2.put("publisher", "Stripe");
    localHashMap1.put("X-Stripe-Client-User-Agent", APIResource.GSON.toJson(localHashMap2));
    if (str1 != null) {
      localHashMap1.put("Stripe-Version", str1);
    }
    if (paramRequestOptions.getIdempotencyKey() != null) {
      localHashMap1.put("Idempotency-Key", paramRequestOptions.getIdempotencyKey());
    }
    if (paramRequestOptions.getStripeAccount() != null) {
      localHashMap1.put("Stripe-Account", paramRequestOptions.getStripeAccount());
    }
    return localHashMap1;
  }
  
  /* Error */
  private static StripeResponse getMultipartStripeResponse(APIResource.RequestMethod paramRequestMethod, String paramString, Map<String, Object> paramMap, RequestOptions paramRequestOptions)
    throws InvalidRequestException, APIConnectionException, APIException
  {
    // Byte code:
    //   0: aload_0
    //   1: getstatic 435	com/stripe/net/APIResource$RequestMethod:POST	Lcom/stripe/net/APIResource$RequestMethod;
    //   4: if_acmpeq +16 -> 20
    //   7: new 32	com/stripe/exception/InvalidRequestException
    //   10: dup
    //   11: ldc_w 437
    //   14: aconst_null
    //   15: aconst_null
    //   16: invokespecial 357	com/stripe/exception/InvalidRequestException:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   19: athrow
    //   20: aconst_null
    //   21: astore 5
    //   23: aconst_null
    //   24: astore_0
    //   25: aload_1
    //   26: aload_3
    //   27: invokestatic 149	com/stripe/net/LiveStripeResponseGetter:createStripeConnection	(Ljava/lang/String;Lcom/stripe/net/RequestOptions;)Ljava/net/HttpURLConnection;
    //   30: astore_1
    //   31: aload_1
    //   32: astore_0
    //   33: aload_1
    //   34: astore 5
    //   36: invokestatic 442	com/stripe/net/MultipartProcessor:getBoundary	()Ljava/lang/String;
    //   39: astore_3
    //   40: aload_1
    //   41: astore_0
    //   42: aload_1
    //   43: astore 5
    //   45: aload_1
    //   46: iconst_1
    //   47: invokevirtual 164	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   50: aload_1
    //   51: astore_0
    //   52: aload_1
    //   53: astore 5
    //   55: aload_1
    //   56: ldc -90
    //   58: invokevirtual 156	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   61: aload_1
    //   62: astore_0
    //   63: aload_1
    //   64: astore 5
    //   66: aload_1
    //   67: ldc -88
    //   69: ldc_w 444
    //   72: iconst_1
    //   73: anewarray 4	java/lang/Object
    //   76: dup
    //   77: iconst_0
    //   78: aload_3
    //   79: aastore
    //   80: invokestatic 176	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   83: invokevirtual 179	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   86: aconst_null
    //   87: astore_0
    //   88: new 439	com/stripe/net/MultipartProcessor
    //   91: dup
    //   92: aload_1
    //   93: aload_3
    //   94: ldc -84
    //   96: invokespecial 447	com/stripe/net/MultipartProcessor:<init>	(Ljava/net/HttpURLConnection;Ljava/lang/String;Ljava/lang/String;)V
    //   99: astore_3
    //   100: aload_2
    //   101: invokeinterface 213 1 0
    //   106: invokeinterface 219 1 0
    //   111: astore_0
    //   112: aload_0
    //   113: invokeinterface 224 1 0
    //   118: ifeq +278 -> 396
    //   121: aload_0
    //   122: invokeinterface 228 1 0
    //   127: checkcast 230	java/util/Map$Entry
    //   130: astore 5
    //   132: aload 5
    //   134: invokeinterface 242 1 0
    //   139: checkcast 70	java/lang/String
    //   142: astore_2
    //   143: aload 5
    //   145: invokeinterface 245 1 0
    //   150: astore 5
    //   152: aload 5
    //   154: instanceof 449
    //   157: ifeq +226 -> 383
    //   160: aload 5
    //   162: checkcast 449	java/io/File
    //   165: astore 5
    //   167: aload 5
    //   169: invokevirtual 452	java/io/File:exists	()Z
    //   172: ifne +113 -> 285
    //   175: new 32	com/stripe/exception/InvalidRequestException
    //   178: dup
    //   179: new 206	java/lang/StringBuilder
    //   182: dup
    //   183: invokespecial 207	java/lang/StringBuilder:<init>	()V
    //   186: ldc_w 454
    //   189: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: aload_2
    //   193: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: ldc_w 456
    //   199: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   205: aconst_null
    //   206: aconst_null
    //   207: invokespecial 357	com/stripe/exception/InvalidRequestException:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   210: athrow
    //   211: astore_0
    //   212: aload_3
    //   213: astore_2
    //   214: aload_0
    //   215: astore_3
    //   216: aload_2
    //   217: ifnull +12 -> 229
    //   220: aload_1
    //   221: astore_0
    //   222: aload_1
    //   223: astore 5
    //   225: aload_2
    //   226: invokevirtual 459	com/stripe/net/MultipartProcessor:finish	()V
    //   229: aload_1
    //   230: astore_0
    //   231: aload_1
    //   232: astore 5
    //   234: aload_3
    //   235: athrow
    //   236: astore_1
    //   237: aload_0
    //   238: astore 5
    //   240: new 34	com/stripe/exception/APIConnectionException
    //   243: dup
    //   244: ldc_w 461
    //   247: iconst_2
    //   248: anewarray 4	java/lang/Object
    //   251: dup
    //   252: iconst_0
    //   253: invokestatic 466	com/stripe/Stripe:getApiBase	()Ljava/lang/String;
    //   256: aastore
    //   257: dup
    //   258: iconst_1
    //   259: aload_1
    //   260: invokevirtual 469	java/io/IOException:getMessage	()Ljava/lang/String;
    //   263: aastore
    //   264: invokestatic 176	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   267: aload_1
    //   268: invokespecial 472	com/stripe/exception/APIConnectionException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   271: athrow
    //   272: astore_0
    //   273: aload 5
    //   275: ifnull +8 -> 283
    //   278: aload 5
    //   280: invokevirtual 475	java/net/HttpURLConnection:disconnect	()V
    //   283: aload_0
    //   284: athrow
    //   285: aload 5
    //   287: invokevirtual 478	java/io/File:isFile	()Z
    //   290: ifne +39 -> 329
    //   293: new 32	com/stripe/exception/InvalidRequestException
    //   296: dup
    //   297: new 206	java/lang/StringBuilder
    //   300: dup
    //   301: invokespecial 207	java/lang/StringBuilder:<init>	()V
    //   304: ldc_w 454
    //   307: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: aload_2
    //   311: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: ldc_w 480
    //   317: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   323: aconst_null
    //   324: aconst_null
    //   325: invokespecial 357	com/stripe/exception/InvalidRequestException:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   328: athrow
    //   329: aload 5
    //   331: invokevirtual 483	java/io/File:canRead	()Z
    //   334: ifne +39 -> 373
    //   337: new 32	com/stripe/exception/InvalidRequestException
    //   340: dup
    //   341: new 206	java/lang/StringBuilder
    //   344: dup
    //   345: invokespecial 207	java/lang/StringBuilder:<init>	()V
    //   348: ldc_w 485
    //   351: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   354: aload_2
    //   355: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: ldc_w 487
    //   361: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   364: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   367: aconst_null
    //   368: aconst_null
    //   369: invokespecial 357	com/stripe/exception/InvalidRequestException:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   372: athrow
    //   373: aload_3
    //   374: aload_2
    //   375: aload 5
    //   377: invokevirtual 491	com/stripe/net/MultipartProcessor:addFileField	(Ljava/lang/String;Ljava/io/File;)V
    //   380: goto -268 -> 112
    //   383: aload_3
    //   384: aload_2
    //   385: aload 5
    //   387: checkcast 70	java/lang/String
    //   390: invokevirtual 494	com/stripe/net/MultipartProcessor:addFormField	(Ljava/lang/String;Ljava/lang/String;)V
    //   393: goto -281 -> 112
    //   396: aload_3
    //   397: ifnull +12 -> 409
    //   400: aload_1
    //   401: astore_0
    //   402: aload_1
    //   403: astore 5
    //   405: aload_3
    //   406: invokevirtual 459	com/stripe/net/MultipartProcessor:finish	()V
    //   409: aload_1
    //   410: astore_0
    //   411: aload_1
    //   412: astore 5
    //   414: aload_1
    //   415: invokevirtual 497	java/net/HttpURLConnection:getResponseCode	()I
    //   418: istore 4
    //   420: iload 4
    //   422: sipush 200
    //   425: if_icmplt +54 -> 479
    //   428: iload 4
    //   430: sipush 300
    //   433: if_icmpge +46 -> 479
    //   436: aload_1
    //   437: astore_0
    //   438: aload_1
    //   439: astore 5
    //   441: aload_1
    //   442: invokevirtual 501	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   445: invokestatic 505	com/stripe/net/LiveStripeResponseGetter:getResponseBody	(Ljava/io/InputStream;)Ljava/lang/String;
    //   448: astore_2
    //   449: aload_1
    //   450: astore_0
    //   451: aload_1
    //   452: astore 5
    //   454: new 108	com/stripe/net/StripeResponse
    //   457: dup
    //   458: iload 4
    //   460: aload_2
    //   461: aload_1
    //   462: invokevirtual 509	java/net/HttpURLConnection:getHeaderFields	()Ljava/util/Map;
    //   465: invokespecial 512	com/stripe/net/StripeResponse:<init>	(ILjava/lang/String;Ljava/util/Map;)V
    //   468: astore_2
    //   469: aload_1
    //   470: ifnull +7 -> 477
    //   473: aload_1
    //   474: invokevirtual 475	java/net/HttpURLConnection:disconnect	()V
    //   477: aload_2
    //   478: areturn
    //   479: aload_1
    //   480: astore_0
    //   481: aload_1
    //   482: astore 5
    //   484: aload_1
    //   485: invokevirtual 515	java/net/HttpURLConnection:getErrorStream	()Ljava/io/InputStream;
    //   488: invokestatic 505	com/stripe/net/LiveStripeResponseGetter:getResponseBody	(Ljava/io/InputStream;)Ljava/lang/String;
    //   491: astore_2
    //   492: goto -43 -> 449
    //   495: astore_3
    //   496: aload_0
    //   497: astore_2
    //   498: goto -282 -> 216
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	501	0	paramRequestMethod	APIResource.RequestMethod
    //   0	501	1	paramString	String
    //   0	501	2	paramMap	Map<String, Object>
    //   0	501	3	paramRequestOptions	RequestOptions
    //   418	41	4	i	int
    //   21	462	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   100	112	211	finally
    //   112	211	211	finally
    //   285	329	211	finally
    //   329	373	211	finally
    //   373	380	211	finally
    //   383	393	211	finally
    //   25	31	236	java/io/IOException
    //   36	40	236	java/io/IOException
    //   45	50	236	java/io/IOException
    //   55	61	236	java/io/IOException
    //   66	86	236	java/io/IOException
    //   225	229	236	java/io/IOException
    //   234	236	236	java/io/IOException
    //   405	409	236	java/io/IOException
    //   414	420	236	java/io/IOException
    //   441	449	236	java/io/IOException
    //   454	469	236	java/io/IOException
    //   484	492	236	java/io/IOException
    //   25	31	272	finally
    //   36	40	272	finally
    //   45	50	272	finally
    //   55	61	272	finally
    //   66	86	272	finally
    //   225	229	272	finally
    //   234	236	272	finally
    //   240	272	272	finally
    //   405	409	272	finally
    //   414	420	272	finally
    //   441	449	272	finally
    //   454	469	272	finally
    //   484	492	272	finally
    //   88	100	495	finally
  }
  
  private static String getResponseBody(InputStream paramInputStream)
    throws IOException
  {
    String str = new Scanner(paramInputStream, "UTF-8").useDelimiter("\\A").next();
    paramInputStream.close();
    return str;
  }
  
  /* Error */
  private static StripeResponse getStripeResponse(APIResource.RequestMethod paramRequestMethod, String paramString, Map<String, Object> paramMap, RequestOptions paramRequestOptions)
    throws InvalidRequestException, APIConnectionException, APIException
  {
    // Byte code:
    //   0: aload_2
    //   1: invokestatic 536	com/stripe/net/LiveStripeResponseGetter:createQuery	(Ljava/util/Map;)Ljava/lang/String;
    //   4: astore_2
    //   5: aload_0
    //   6: aload_1
    //   7: aload_2
    //   8: aload_3
    //   9: invokestatic 540	com/stripe/net/LiveStripeResponseGetter:makeURLConnectionRequest	(Lcom/stripe/net/APIResource$RequestMethod;Ljava/lang/String;Ljava/lang/String;Lcom/stripe/net/RequestOptions;)Lcom/stripe/net/StripeResponse;
    //   12: astore 4
    //   14: aload 4
    //   16: areturn
    //   17: astore_0
    //   18: new 32	com/stripe/exception/InvalidRequestException
    //   21: dup
    //   22: ldc_w 542
    //   25: aconst_null
    //   26: aload_0
    //   27: invokespecial 357	com/stripe/exception/InvalidRequestException:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   30: athrow
    //   31: astore 4
    //   33: ldc_w 544
    //   36: aconst_null
    //   37: invokestatic 268	java/lang/System:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   40: ifnull +11 -> 51
    //   43: aload_0
    //   44: aload_1
    //   45: aload_2
    //   46: aload_3
    //   47: invokestatic 547	com/stripe/net/LiveStripeResponseGetter:makeAppEngineRequest	(Lcom/stripe/net/APIResource$RequestMethod;Ljava/lang/String;Ljava/lang/String;Lcom/stripe/net/RequestOptions;)Lcom/stripe/net/StripeResponse;
    //   50: areturn
    //   51: aload 4
    //   53: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	paramRequestMethod	APIResource.RequestMethod
    //   0	54	1	paramString	String
    //   0	54	2	paramMap	Map<String, Object>
    //   0	54	3	paramRequestOptions	RequestOptions
    //   12	3	4	localStripeResponse	StripeResponse
    //   31	21	4	localClassCastException	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   0	5	17	java/io/UnsupportedEncodingException
    //   5	14	31	java/lang/ClassCastException
  }
  
  private static void handleAPIError(String paramString, int paramInt)
    throws InvalidRequestException, AuthenticationException, CardException, APIException
  {
    paramString = GSONfromJsonerror;
    switch (paramInt)
    {
    case 403: 
    default: 
      throw new APIException(message, null);
    case 400: 
      throw new InvalidRequestException(message, param, null);
    case 404: 
      throw new InvalidRequestException(message, param, null);
    case 401: 
      throw new AuthenticationException(message);
    }
    throw new CardException(message, code, param, decline_code, charge, null);
  }
  
  /* Error */
  private static StripeResponse makeAppEngineRequest(APIResource.RequestMethod paramRequestMethod, String paramString1, String paramString2, RequestOptions paramRequestOptions)
    throws APIException
  {
    // Byte code:
    //   0: aload_0
    //   1: getstatic 576	com/stripe/net/APIResource$RequestMethod:GET	Lcom/stripe/net/APIResource$RequestMethod;
    //   4: if_acmpeq +13 -> 17
    //   7: aload_1
    //   8: astore 4
    //   10: aload_0
    //   11: getstatic 578	com/stripe/net/APIResource$RequestMethod:DELETE	Lcom/stripe/net/APIResource$RequestMethod;
    //   14: if_acmpne +23 -> 37
    //   17: ldc_w 580
    //   20: iconst_2
    //   21: anewarray 4	java/lang/Object
    //   24: dup
    //   25: iconst_0
    //   26: aload_1
    //   27: aastore
    //   28: dup
    //   29: iconst_1
    //   30: aload_2
    //   31: aastore
    //   32: invokestatic 176	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   35: astore 4
    //   37: new 270	java/net/URL
    //   40: dup
    //   41: aload 4
    //   43: invokespecial 314	java/net/URL:<init>	(Ljava/lang/String;)V
    //   46: astore 5
    //   48: ldc_w 582
    //   51: invokestatic 276	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   54: astore 6
    //   56: aload 6
    //   58: aload_0
    //   59: invokevirtual 585	com/stripe/net/APIResource$RequestMethod:name	()Ljava/lang/String;
    //   62: invokevirtual 589	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   65: aconst_null
    //   66: invokevirtual 595	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   69: astore 7
    //   71: ldc_w 597
    //   74: invokestatic 276	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   77: astore 4
    //   79: aload 4
    //   81: ldc_w 599
    //   84: iconst_0
    //   85: anewarray 272	java/lang/Class
    //   88: invokevirtual 603	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   91: aconst_null
    //   92: iconst_0
    //   93: anewarray 4	java/lang/Object
    //   96: invokevirtual 609	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   99: astore_1
    //   100: ldc_w 611
    //   103: invokestatic 276	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   106: astore 8
    //   108: aload 8
    //   110: ldc_w 613
    //   113: iconst_1
    //   114: anewarray 272	java/lang/Class
    //   117: dup
    //   118: iconst_0
    //   119: ldc_w 615
    //   122: aastore
    //   123: invokevirtual 603	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   126: aload_1
    //   127: iconst_1
    //   128: anewarray 4	java/lang/Object
    //   131: dup
    //   132: iconst_0
    //   133: new 615	java/lang/Double
    //   136: dup
    //   137: ldc2_w 616
    //   140: invokespecial 620	java/lang/Double:<init>	(D)V
    //   143: aastore
    //   144: invokevirtual 609	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   147: pop
    //   148: ldc_w 622
    //   151: invokestatic 276	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   154: astore 4
    //   156: aload 4
    //   158: iconst_3
    //   159: anewarray 272	java/lang/Class
    //   162: dup
    //   163: iconst_0
    //   164: ldc_w 270
    //   167: aastore
    //   168: dup
    //   169: iconst_1
    //   170: aload 6
    //   172: aastore
    //   173: dup
    //   174: iconst_2
    //   175: aload 8
    //   177: aastore
    //   178: invokevirtual 625	java/lang/Class:getDeclaredConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   181: iconst_3
    //   182: anewarray 4	java/lang/Object
    //   185: dup
    //   186: iconst_0
    //   187: aload 5
    //   189: aastore
    //   190: dup
    //   191: iconst_1
    //   192: aload 7
    //   194: aastore
    //   195: dup
    //   196: iconst_2
    //   197: aload_1
    //   198: aastore
    //   199: invokevirtual 286	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   202: astore_1
    //   203: aload_0
    //   204: getstatic 435	com/stripe/net/APIResource$RequestMethod:POST	Lcom/stripe/net/APIResource$RequestMethod;
    //   207: if_acmpne +37 -> 244
    //   210: aload 4
    //   212: ldc_w 627
    //   215: iconst_1
    //   216: anewarray 272	java/lang/Class
    //   219: dup
    //   220: iconst_0
    //   221: ldc_w 629
    //   224: aastore
    //   225: invokevirtual 603	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   228: aload_1
    //   229: iconst_1
    //   230: anewarray 4	java/lang/Object
    //   233: dup
    //   234: iconst_0
    //   235: aload_2
    //   236: invokevirtual 632	java/lang/String:getBytes	()[B
    //   239: aastore
    //   240: invokevirtual 609	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   243: pop
    //   244: aload_3
    //   245: invokestatic 310	com/stripe/net/LiveStripeResponseGetter:getHeaders	(Lcom/stripe/net/RequestOptions;)Ljava/util/Map;
    //   248: invokeinterface 213 1 0
    //   253: invokeinterface 219 1 0
    //   258: astore_0
    //   259: aload_0
    //   260: invokeinterface 224 1 0
    //   265: ifeq +143 -> 408
    //   268: aload_0
    //   269: invokeinterface 228 1 0
    //   274: checkcast 230	java/util/Map$Entry
    //   277: astore_3
    //   278: ldc_w 634
    //   281: invokestatic 276	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   284: astore_2
    //   285: aload_2
    //   286: iconst_2
    //   287: anewarray 272	java/lang/Class
    //   290: dup
    //   291: iconst_0
    //   292: ldc 70
    //   294: aastore
    //   295: dup
    //   296: iconst_1
    //   297: ldc 70
    //   299: aastore
    //   300: invokevirtual 625	java/lang/Class:getDeclaredConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   303: iconst_2
    //   304: anewarray 4	java/lang/Object
    //   307: dup
    //   308: iconst_0
    //   309: aload_3
    //   310: invokeinterface 242 1 0
    //   315: aastore
    //   316: dup
    //   317: iconst_1
    //   318: aload_3
    //   319: invokeinterface 245 1 0
    //   324: aastore
    //   325: invokevirtual 286	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   328: astore_3
    //   329: aload 4
    //   331: ldc_w 636
    //   334: iconst_1
    //   335: anewarray 272	java/lang/Class
    //   338: dup
    //   339: iconst_0
    //   340: aload_2
    //   341: aastore
    //   342: invokevirtual 603	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   345: aload_1
    //   346: iconst_1
    //   347: anewarray 4	java/lang/Object
    //   350: dup
    //   351: iconst_0
    //   352: aload_3
    //   353: aastore
    //   354: invokevirtual 609	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   357: pop
    //   358: goto -99 -> 259
    //   361: astore_0
    //   362: new 38	com/stripe/exception/APIException
    //   365: dup
    //   366: ldc_w 638
    //   369: aload_0
    //   370: invokespecial 555	com/stripe/exception/APIException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   373: athrow
    //   374: astore_1
    //   375: getstatic 642	java/lang/System:err	Ljava/io/PrintStream;
    //   378: ldc_w 644
    //   381: invokevirtual 649	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   384: aload 4
    //   386: ldc_w 651
    //   389: iconst_0
    //   390: anewarray 272	java/lang/Class
    //   393: invokevirtual 603	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   396: aconst_null
    //   397: iconst_0
    //   398: anewarray 4	java/lang/Object
    //   401: invokevirtual 609	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   404: astore_1
    //   405: goto -305 -> 100
    //   408: ldc_w 653
    //   411: invokestatic 276	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   414: ldc_w 655
    //   417: iconst_0
    //   418: anewarray 272	java/lang/Class
    //   421: invokevirtual 603	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   424: aconst_null
    //   425: iconst_0
    //   426: anewarray 4	java/lang/Object
    //   429: invokevirtual 609	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   432: astore_0
    //   433: aload_0
    //   434: invokevirtual 659	java/lang/Object:getClass	()Ljava/lang/Class;
    //   437: ldc_w 661
    //   440: iconst_1
    //   441: anewarray 272	java/lang/Class
    //   444: dup
    //   445: iconst_0
    //   446: aload 4
    //   448: aastore
    //   449: invokevirtual 603	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   452: astore_2
    //   453: aload_2
    //   454: iconst_1
    //   455: invokevirtual 664	java/lang/reflect/Method:setAccessible	(Z)V
    //   458: aload_2
    //   459: aload_0
    //   460: iconst_1
    //   461: anewarray 4	java/lang/Object
    //   464: dup
    //   465: iconst_0
    //   466: aload_1
    //   467: aastore
    //   468: invokevirtual 609	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   471: astore_0
    //   472: new 108	com/stripe/net/StripeResponse
    //   475: dup
    //   476: aload_0
    //   477: invokevirtual 659	java/lang/Object:getClass	()Ljava/lang/Class;
    //   480: ldc_w 665
    //   483: iconst_0
    //   484: anewarray 272	java/lang/Class
    //   487: invokevirtual 603	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   490: aload_0
    //   491: iconst_0
    //   492: anewarray 4	java/lang/Object
    //   495: invokevirtual 609	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   498: checkcast 335	java/lang/Integer
    //   501: invokevirtual 668	java/lang/Integer:intValue	()I
    //   504: new 70	java/lang/String
    //   507: dup
    //   508: aload_0
    //   509: invokevirtual 659	java/lang/Object:getClass	()Ljava/lang/Class;
    //   512: ldc_w 670
    //   515: iconst_0
    //   516: anewarray 272	java/lang/Class
    //   519: invokevirtual 603	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   522: aload_0
    //   523: iconst_0
    //   524: anewarray 4	java/lang/Object
    //   527: invokevirtual 609	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   530: checkcast 629	[B
    //   533: checkcast 629	[B
    //   536: ldc -84
    //   538: invokespecial 673	java/lang/String:<init>	([BLjava/lang/String;)V
    //   541: invokespecial 676	com/stripe/net/StripeResponse:<init>	(ILjava/lang/String;)V
    //   544: astore_0
    //   545: aload_0
    //   546: areturn
    //   547: astore_0
    //   548: new 38	com/stripe/exception/APIException
    //   551: dup
    //   552: ldc_w 638
    //   555: aload_0
    //   556: invokespecial 555	com/stripe/exception/APIException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   559: athrow
    //   560: astore_0
    //   561: new 38	com/stripe/exception/APIException
    //   564: dup
    //   565: ldc_w 638
    //   568: aload_0
    //   569: invokespecial 555	com/stripe/exception/APIException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   572: athrow
    //   573: astore_0
    //   574: new 38	com/stripe/exception/APIException
    //   577: dup
    //   578: ldc_w 638
    //   581: aload_0
    //   582: invokespecial 555	com/stripe/exception/APIException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   585: athrow
    //   586: astore_0
    //   587: new 38	com/stripe/exception/APIException
    //   590: dup
    //   591: ldc_w 638
    //   594: aload_0
    //   595: invokespecial 555	com/stripe/exception/APIException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   598: athrow
    //   599: astore_0
    //   600: new 38	com/stripe/exception/APIException
    //   603: dup
    //   604: ldc_w 638
    //   607: aload_0
    //   608: invokespecial 555	com/stripe/exception/APIException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   611: athrow
    //   612: astore_0
    //   613: new 38	com/stripe/exception/APIException
    //   616: dup
    //   617: ldc_w 638
    //   620: aload_0
    //   621: invokespecial 555	com/stripe/exception/APIException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   624: athrow
    //   625: astore_0
    //   626: new 38	com/stripe/exception/APIException
    //   629: dup
    //   630: ldc_w 638
    //   633: aload_0
    //   634: invokespecial 555	com/stripe/exception/APIException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   637: athrow
    //   638: astore_0
    //   639: new 38	com/stripe/exception/APIException
    //   642: dup
    //   643: ldc_w 638
    //   646: aload_0
    //   647: invokespecial 555	com/stripe/exception/APIException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   650: athrow
    //   651: astore_0
    //   652: new 38	com/stripe/exception/APIException
    //   655: dup
    //   656: ldc_w 638
    //   659: aload_0
    //   660: invokespecial 555	com/stripe/exception/APIException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   663: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	664	0	paramRequestMethod	APIResource.RequestMethod
    //   0	664	1	paramString1	String
    //   0	664	2	paramString2	String
    //   0	664	3	paramRequestOptions	RequestOptions
    //   8	439	4	localObject1	Object
    //   46	142	5	localURL	URL
    //   54	117	6	localClass1	Class
    //   69	124	7	localObject2	Object
    //   106	70	8	localClass2	Class
    // Exception table:
    //   from	to	target	type
    //   0	7	361	java/lang/reflect/InvocationTargetException
    //   10	17	361	java/lang/reflect/InvocationTargetException
    //   17	37	361	java/lang/reflect/InvocationTargetException
    //   37	79	361	java/lang/reflect/InvocationTargetException
    //   79	100	361	java/lang/reflect/InvocationTargetException
    //   100	244	361	java/lang/reflect/InvocationTargetException
    //   244	259	361	java/lang/reflect/InvocationTargetException
    //   259	358	361	java/lang/reflect/InvocationTargetException
    //   375	405	361	java/lang/reflect/InvocationTargetException
    //   408	545	361	java/lang/reflect/InvocationTargetException
    //   79	100	374	java/lang/NoSuchMethodException
    //   0	7	547	java/net/MalformedURLException
    //   10	17	547	java/net/MalformedURLException
    //   17	37	547	java/net/MalformedURLException
    //   37	79	547	java/net/MalformedURLException
    //   79	100	547	java/net/MalformedURLException
    //   100	244	547	java/net/MalformedURLException
    //   244	259	547	java/net/MalformedURLException
    //   259	358	547	java/net/MalformedURLException
    //   375	405	547	java/net/MalformedURLException
    //   408	545	547	java/net/MalformedURLException
    //   0	7	560	java/lang/NoSuchFieldException
    //   10	17	560	java/lang/NoSuchFieldException
    //   17	37	560	java/lang/NoSuchFieldException
    //   37	79	560	java/lang/NoSuchFieldException
    //   79	100	560	java/lang/NoSuchFieldException
    //   100	244	560	java/lang/NoSuchFieldException
    //   244	259	560	java/lang/NoSuchFieldException
    //   259	358	560	java/lang/NoSuchFieldException
    //   375	405	560	java/lang/NoSuchFieldException
    //   408	545	560	java/lang/NoSuchFieldException
    //   0	7	573	java/lang/SecurityException
    //   10	17	573	java/lang/SecurityException
    //   17	37	573	java/lang/SecurityException
    //   37	79	573	java/lang/SecurityException
    //   79	100	573	java/lang/SecurityException
    //   100	244	573	java/lang/SecurityException
    //   244	259	573	java/lang/SecurityException
    //   259	358	573	java/lang/SecurityException
    //   375	405	573	java/lang/SecurityException
    //   408	545	573	java/lang/SecurityException
    //   0	7	586	java/lang/NoSuchMethodException
    //   10	17	586	java/lang/NoSuchMethodException
    //   17	37	586	java/lang/NoSuchMethodException
    //   37	79	586	java/lang/NoSuchMethodException
    //   100	244	586	java/lang/NoSuchMethodException
    //   244	259	586	java/lang/NoSuchMethodException
    //   259	358	586	java/lang/NoSuchMethodException
    //   375	405	586	java/lang/NoSuchMethodException
    //   408	545	586	java/lang/NoSuchMethodException
    //   0	7	599	java/lang/ClassNotFoundException
    //   10	17	599	java/lang/ClassNotFoundException
    //   17	37	599	java/lang/ClassNotFoundException
    //   37	79	599	java/lang/ClassNotFoundException
    //   79	100	599	java/lang/ClassNotFoundException
    //   100	244	599	java/lang/ClassNotFoundException
    //   244	259	599	java/lang/ClassNotFoundException
    //   259	358	599	java/lang/ClassNotFoundException
    //   375	405	599	java/lang/ClassNotFoundException
    //   408	545	599	java/lang/ClassNotFoundException
    //   0	7	612	java/lang/IllegalArgumentException
    //   10	17	612	java/lang/IllegalArgumentException
    //   17	37	612	java/lang/IllegalArgumentException
    //   37	79	612	java/lang/IllegalArgumentException
    //   79	100	612	java/lang/IllegalArgumentException
    //   100	244	612	java/lang/IllegalArgumentException
    //   244	259	612	java/lang/IllegalArgumentException
    //   259	358	612	java/lang/IllegalArgumentException
    //   375	405	612	java/lang/IllegalArgumentException
    //   408	545	612	java/lang/IllegalArgumentException
    //   0	7	625	java/lang/IllegalAccessException
    //   10	17	625	java/lang/IllegalAccessException
    //   17	37	625	java/lang/IllegalAccessException
    //   37	79	625	java/lang/IllegalAccessException
    //   79	100	625	java/lang/IllegalAccessException
    //   100	244	625	java/lang/IllegalAccessException
    //   244	259	625	java/lang/IllegalAccessException
    //   259	358	625	java/lang/IllegalAccessException
    //   375	405	625	java/lang/IllegalAccessException
    //   408	545	625	java/lang/IllegalAccessException
    //   0	7	638	java/lang/InstantiationException
    //   10	17	638	java/lang/InstantiationException
    //   17	37	638	java/lang/InstantiationException
    //   37	79	638	java/lang/InstantiationException
    //   79	100	638	java/lang/InstantiationException
    //   100	244	638	java/lang/InstantiationException
    //   244	259	638	java/lang/InstantiationException
    //   259	358	638	java/lang/InstantiationException
    //   375	405	638	java/lang/InstantiationException
    //   408	545	638	java/lang/InstantiationException
    //   0	7	651	java/io/UnsupportedEncodingException
    //   10	17	651	java/io/UnsupportedEncodingException
    //   17	37	651	java/io/UnsupportedEncodingException
    //   37	79	651	java/io/UnsupportedEncodingException
    //   79	100	651	java/io/UnsupportedEncodingException
    //   100	244	651	java/io/UnsupportedEncodingException
    //   244	259	651	java/io/UnsupportedEncodingException
    //   259	358	651	java/io/UnsupportedEncodingException
    //   375	405	651	java/io/UnsupportedEncodingException
    //   408	545	651	java/io/UnsupportedEncodingException
  }
  
  private static StripeResponse makeURLConnectionRequest(APIResource.RequestMethod paramRequestMethod, String paramString1, String paramString2, RequestOptions paramRequestOptions)
    throws APIConnectionException
  {
    Object localObject4 = null;
    Object localObject3 = null;
    Object localObject2 = localObject3;
    Object localObject1 = localObject4;
    for (;;)
    {
      try
      {
        switch (1.$SwitchMap$com$stripe$net$APIResource$RequestMethod[paramRequestMethod.ordinal()])
        {
        case 1: 
          localObject2 = localObject3;
          localObject1 = localObject4;
          throw new APIConnectionException(String.format("Unrecognized HTTP method %s. This indicates a bug in the Stripe bindings. Please contact support@stripe.com for assistance.", new Object[] { paramRequestMethod }));
        }
      }
      catch (IOException paramRequestMethod)
      {
        localObject1 = localObject2;
        throw new APIConnectionException(String.format("IOException during API request to Stripe (%s): %s Please check your internet connection and try again. If this problem persists,you should check Stripe's service status at https://twitter.com/stripestatus, or let us know at support@stripe.com.", new Object[] { Stripe.getApiBase(), paramRequestMethod.getMessage() }), paramRequestMethod);
      }
      finally
      {
        if (localObject1 != null) {
          ((HttpURLConnection)localObject1).disconnect();
        }
      }
      localObject2 = localObject3;
      localObject1 = localObject4;
      paramRequestMethod = createGetConnection(paramString1, paramString2, paramRequestOptions);
      localObject2 = paramRequestMethod;
      localObject1 = paramRequestMethod;
      int i = paramRequestMethod.getResponseCode();
      if ((i >= 200) && (i < 300))
      {
        localObject2 = paramRequestMethod;
        localObject1 = paramRequestMethod;
      }
      for (paramString1 = getResponseBody(paramRequestMethod.getInputStream());; paramString1 = getResponseBody(paramRequestMethod.getErrorStream()))
      {
        localObject2 = paramRequestMethod;
        localObject1 = paramRequestMethod;
        paramString1 = new StripeResponse(i, paramString1, paramRequestMethod.getHeaderFields());
        if (paramRequestMethod != null) {
          paramRequestMethod.disconnect();
        }
        return paramString1;
        localObject2 = localObject3;
        localObject1 = localObject4;
        paramRequestMethod = createPostConnection(paramString1, paramString2, paramRequestOptions);
        break;
        localObject2 = localObject3;
        localObject1 = localObject4;
        paramRequestMethod = createDeleteConnection(paramString1, paramString2, paramRequestOptions);
        break;
        localObject2 = paramRequestMethod;
        localObject1 = paramRequestMethod;
      }
    }
  }
  
  private static String urlEncodePair(String paramString1, String paramString2)
    throws UnsupportedEncodingException
  {
    return String.format("%s=%s", new Object[] { APIResource.urlEncode(paramString1), APIResource.urlEncode(paramString2) });
  }
  
  public <T> T request(APIResource.RequestMethod paramRequestMethod, String paramString, Map<String, Object> paramMap, Class<T> paramClass, APIResource.RequestType paramRequestType, RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return (T)_request(paramRequestMethod, paramString, paramMap, paramClass, paramRequestType, paramRequestOptions);
  }
  
  private static class Error
  {
    String charge;
    String code;
    String decline_code;
    String message;
    String param;
    String type;
  }
  
  private static class ErrorContainer
  {
    private LiveStripeResponseGetter.Error error;
  }
}

/* Location:
 * Qualified Name:     com.stripe.net.LiveStripeResponseGetter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */