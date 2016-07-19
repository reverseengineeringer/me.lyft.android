package com.mobileapptracker;

import android.net.Uri;
import android.net.Uri.Builder;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class MATUrlRequester
{
  private static void logResponse(JSONObject paramJSONObject)
  {
    if (paramJSONObject.length() > 0)
    {
      try
      {
        if ((paramJSONObject.has("errors")) && (paramJSONObject.getJSONArray("errors").length() != 0))
        {
          paramJSONObject = paramJSONObject.getJSONArray("errors").getString(0);
          Log.d("MobileAppTracker", "Event was rejected by server with error: " + paramJSONObject);
          return;
        }
        if ((!paramJSONObject.has("log_action")) || (paramJSONObject.getString("log_action").equals("null")) || (paramJSONObject.getString("log_action").equals("false")) || (paramJSONObject.getString("log_action").equals("true"))) {
          break label218;
        }
        paramJSONObject = paramJSONObject.getJSONObject("log_action");
        if (!paramJSONObject.has("conversion")) {
          return;
        }
        paramJSONObject = paramJSONObject.getJSONObject("conversion");
        if (!paramJSONObject.has("status")) {
          return;
        }
        if (paramJSONObject.getString("status").equals("rejected"))
        {
          paramJSONObject = paramJSONObject.getString("status_code");
          Log.d("MobileAppTracker", "Event was rejected by server: status code " + paramJSONObject);
          return;
        }
      }
      catch (JSONException paramJSONObject)
      {
        Log.d("MobileAppTracker", "Server response status could not be parsed");
        paramJSONObject.printStackTrace();
        return;
      }
      Log.d("MobileAppTracker", "Event was accepted by server");
      return;
      label218:
      if (paramJSONObject.has("options"))
      {
        paramJSONObject = paramJSONObject.getJSONObject("options");
        if (paramJSONObject.has("conversion_status"))
        {
          paramJSONObject = paramJSONObject.getString("conversion_status");
          Log.d("MobileAppTracker", "Event was " + paramJSONObject + " by server");
        }
      }
    }
  }
  
  /* Error */
  protected static JSONObject requestUrl(String paramString, JSONObject paramJSONObject, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 6
    //   6: aload 6
    //   8: astore 5
    //   10: aload 7
    //   12: astore 4
    //   14: new 111	java/net/URL
    //   17: dup
    //   18: aload_0
    //   19: invokespecial 114	java/net/URL:<init>	(Ljava/lang/String;)V
    //   22: invokevirtual 118	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   25: checkcast 120	java/net/HttpURLConnection
    //   28: astore 8
    //   30: aload 6
    //   32: astore 5
    //   34: aload 7
    //   36: astore 4
    //   38: aload 8
    //   40: ldc 121
    //   42: invokevirtual 125	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   45: aload 6
    //   47: astore 5
    //   49: aload 7
    //   51: astore 4
    //   53: aload 8
    //   55: ldc 121
    //   57: invokevirtual 128	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   60: aload 6
    //   62: astore 5
    //   64: aload 7
    //   66: astore 4
    //   68: aload 8
    //   70: iconst_1
    //   71: invokevirtual 132	java/net/HttpURLConnection:setDoInput	(Z)V
    //   74: aload_1
    //   75: ifnull +18 -> 93
    //   78: aload 6
    //   80: astore 5
    //   82: aload 7
    //   84: astore 4
    //   86: aload_1
    //   87: invokevirtual 19	org/json/JSONObject:length	()I
    //   90: ifne +248 -> 338
    //   93: aload 6
    //   95: astore 5
    //   97: aload 7
    //   99: astore 4
    //   101: aload 8
    //   103: ldc -122
    //   105: invokevirtual 137	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   108: aload 6
    //   110: astore 5
    //   112: aload 7
    //   114: astore 4
    //   116: aload 8
    //   118: invokevirtual 140	java/net/HttpURLConnection:connect	()V
    //   121: aload 6
    //   123: astore 5
    //   125: aload 7
    //   127: astore 4
    //   129: aload 8
    //   131: invokevirtual 143	java/net/HttpURLConnection:getResponseCode	()I
    //   134: istore_3
    //   135: iload_2
    //   136: ifeq +36 -> 172
    //   139: aload 6
    //   141: astore 5
    //   143: aload 7
    //   145: astore 4
    //   147: ldc 38
    //   149: new 40	java/lang/StringBuilder
    //   152: dup
    //   153: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   156: ldc -111
    //   158: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: iload_3
    //   162: invokevirtual 148	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   165: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   168: invokestatic 57	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   171: pop
    //   172: iload_3
    //   173: sipush 200
    //   176: if_icmpne +338 -> 514
    //   179: aload 6
    //   181: astore 5
    //   183: aload 7
    //   185: astore 4
    //   187: aload 8
    //   189: invokevirtual 152	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   192: astore_1
    //   193: aload_1
    //   194: astore 5
    //   196: aload_1
    //   197: astore 4
    //   199: aload_1
    //   200: invokestatic 158	com/mobileapptracker/MATUtils:readStream	(Ljava/io/InputStream;)Ljava/lang/String;
    //   203: astore 7
    //   205: iload_2
    //   206: ifeq +35 -> 241
    //   209: aload_1
    //   210: astore 5
    //   212: aload_1
    //   213: astore 4
    //   215: ldc 38
    //   217: new 40	java/lang/StringBuilder
    //   220: dup
    //   221: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   224: ldc -96
    //   226: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: aload 7
    //   231: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   237: invokestatic 57	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   240: pop
    //   241: aload_1
    //   242: astore 5
    //   244: aload_1
    //   245: astore 4
    //   247: new 15	org/json/JSONObject
    //   250: dup
    //   251: invokespecial 161	org/json/JSONObject:<init>	()V
    //   254: astore 6
    //   256: aload_1
    //   257: astore 4
    //   259: new 15	org/json/JSONObject
    //   262: dup
    //   263: new 163	org/json/JSONTokener
    //   266: dup
    //   267: aload 7
    //   269: invokespecial 164	org/json/JSONTokener:<init>	(Ljava/lang/String;)V
    //   272: invokespecial 167	org/json/JSONObject:<init>	(Lorg/json/JSONTokener;)V
    //   275: astore 5
    //   277: iload_2
    //   278: ifeq +11 -> 289
    //   281: aload_1
    //   282: astore 4
    //   284: aload 5
    //   286: invokestatic 169	com/mobileapptracker/MATUrlRequester:logResponse	(Lorg/json/JSONObject;)V
    //   289: aload 5
    //   291: astore 6
    //   293: aload_1
    //   294: astore 5
    //   296: aload_1
    //   297: astore 4
    //   299: aload 8
    //   301: ldc -85
    //   303: invokevirtual 174	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   306: astore 7
    //   308: iload_3
    //   309: sipush 200
    //   312: if_icmplt +254 -> 566
    //   315: iload_3
    //   316: sipush 300
    //   319: if_icmpge +247 -> 566
    //   322: aload 6
    //   324: astore_0
    //   325: aload_1
    //   326: ifnull +10 -> 336
    //   329: aload_1
    //   330: invokevirtual 179	java/io/InputStream:close	()V
    //   333: aload 6
    //   335: astore_0
    //   336: aload_0
    //   337: areturn
    //   338: aload 6
    //   340: astore 5
    //   342: aload 7
    //   344: astore 4
    //   346: aload 8
    //   348: iconst_1
    //   349: invokevirtual 182	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   352: aload 6
    //   354: astore 5
    //   356: aload 7
    //   358: astore 4
    //   360: aload 8
    //   362: ldc -72
    //   364: ldc -70
    //   366: invokevirtual 190	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   369: aload 6
    //   371: astore 5
    //   373: aload 7
    //   375: astore 4
    //   377: aload 8
    //   379: ldc -64
    //   381: ldc -70
    //   383: invokevirtual 190	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   386: aload 6
    //   388: astore 5
    //   390: aload 7
    //   392: astore 4
    //   394: aload 8
    //   396: ldc -62
    //   398: invokevirtual 137	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   401: aload 6
    //   403: astore 5
    //   405: aload 7
    //   407: astore 4
    //   409: aload 8
    //   411: invokevirtual 198	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   414: astore 9
    //   416: aload 6
    //   418: astore 5
    //   420: aload 7
    //   422: astore 4
    //   424: aload 9
    //   426: aload_1
    //   427: invokevirtual 199	org/json/JSONObject:toString	()Ljava/lang/String;
    //   430: ldc -55
    //   432: invokevirtual 205	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   435: invokevirtual 211	java/io/OutputStream:write	([B)V
    //   438: aload 6
    //   440: astore 5
    //   442: aload 7
    //   444: astore 4
    //   446: aload 9
    //   448: invokevirtual 212	java/io/OutputStream:close	()V
    //   451: goto -343 -> 108
    //   454: astore_1
    //   455: iload_2
    //   456: ifeq +32 -> 488
    //   459: aload 5
    //   461: astore 4
    //   463: ldc 38
    //   465: new 40	java/lang/StringBuilder
    //   468: dup
    //   469: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   472: ldc -42
    //   474: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   477: aload_0
    //   478: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   481: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   484: invokestatic 57	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   487: pop
    //   488: aload 5
    //   490: astore 4
    //   492: aload_1
    //   493: invokevirtual 215	java/lang/Exception:printStackTrace	()V
    //   496: aload 5
    //   498: ifnull +8 -> 506
    //   501: aload 5
    //   503: invokevirtual 179	java/io/InputStream:close	()V
    //   506: new 15	org/json/JSONObject
    //   509: dup
    //   510: invokespecial 161	org/json/JSONObject:<init>	()V
    //   513: areturn
    //   514: aload 6
    //   516: astore 5
    //   518: aload 7
    //   520: astore 4
    //   522: aload 8
    //   524: invokevirtual 218	java/net/HttpURLConnection:getErrorStream	()Ljava/io/InputStream;
    //   527: astore_1
    //   528: goto -335 -> 193
    //   531: aload_1
    //   532: astore 5
    //   534: aload_1
    //   535: astore 4
    //   537: aload 7
    //   539: invokevirtual 215	java/lang/Exception:printStackTrace	()V
    //   542: goto -249 -> 293
    //   545: astore_0
    //   546: aload 4
    //   548: ifnull +8 -> 556
    //   551: aload 4
    //   553: invokevirtual 179	java/io/InputStream:close	()V
    //   556: aload_0
    //   557: athrow
    //   558: astore_0
    //   559: aload_0
    //   560: invokevirtual 219	java/io/IOException:printStackTrace	()V
    //   563: aload 6
    //   565: areturn
    //   566: iload_3
    //   567: sipush 400
    //   570: if_icmpne +45 -> 615
    //   573: aload 7
    //   575: ifnull +40 -> 615
    //   578: iload_2
    //   579: ifeq +17 -> 596
    //   582: aload_1
    //   583: astore 5
    //   585: aload_1
    //   586: astore 4
    //   588: ldc 38
    //   590: ldc -35
    //   592: invokestatic 57	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   595: pop
    //   596: aconst_null
    //   597: astore_0
    //   598: aload_1
    //   599: ifnull -263 -> 336
    //   602: aload_1
    //   603: invokevirtual 179	java/io/InputStream:close	()V
    //   606: aconst_null
    //   607: areturn
    //   608: astore_0
    //   609: aload_0
    //   610: invokevirtual 219	java/io/IOException:printStackTrace	()V
    //   613: aconst_null
    //   614: areturn
    //   615: aload_1
    //   616: ifnull -110 -> 506
    //   619: aload_1
    //   620: invokevirtual 179	java/io/InputStream:close	()V
    //   623: goto -117 -> 506
    //   626: astore_0
    //   627: aload_0
    //   628: invokevirtual 219	java/io/IOException:printStackTrace	()V
    //   631: goto -125 -> 506
    //   634: astore_0
    //   635: aload_0
    //   636: invokevirtual 219	java/io/IOException:printStackTrace	()V
    //   639: goto -133 -> 506
    //   642: astore_1
    //   643: aload_1
    //   644: invokevirtual 219	java/io/IOException:printStackTrace	()V
    //   647: goto -91 -> 556
    //   650: astore 7
    //   652: aload 5
    //   654: astore 6
    //   656: goto -125 -> 531
    //   659: astore 7
    //   661: goto -130 -> 531
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	664	0	paramString	String
    //   0	664	1	paramJSONObject	JSONObject
    //   0	664	2	paramBoolean	boolean
    //   134	437	3	i	int
    //   12	575	4	localObject1	Object
    //   8	645	5	localObject2	Object
    //   4	651	6	localObject3	Object
    //   1	573	7	str	String
    //   650	1	7	localException1	Exception
    //   659	1	7	localException2	Exception
    //   28	495	8	localHttpURLConnection	HttpURLConnection
    //   414	33	9	localOutputStream	java.io.OutputStream
    // Exception table:
    //   from	to	target	type
    //   14	30	454	java/lang/Exception
    //   38	45	454	java/lang/Exception
    //   53	60	454	java/lang/Exception
    //   68	74	454	java/lang/Exception
    //   86	93	454	java/lang/Exception
    //   101	108	454	java/lang/Exception
    //   116	121	454	java/lang/Exception
    //   129	135	454	java/lang/Exception
    //   147	172	454	java/lang/Exception
    //   187	193	454	java/lang/Exception
    //   199	205	454	java/lang/Exception
    //   215	241	454	java/lang/Exception
    //   247	256	454	java/lang/Exception
    //   299	308	454	java/lang/Exception
    //   346	352	454	java/lang/Exception
    //   360	369	454	java/lang/Exception
    //   377	386	454	java/lang/Exception
    //   394	401	454	java/lang/Exception
    //   409	416	454	java/lang/Exception
    //   424	438	454	java/lang/Exception
    //   446	451	454	java/lang/Exception
    //   522	528	454	java/lang/Exception
    //   537	542	454	java/lang/Exception
    //   588	596	454	java/lang/Exception
    //   14	30	545	finally
    //   38	45	545	finally
    //   53	60	545	finally
    //   68	74	545	finally
    //   86	93	545	finally
    //   101	108	545	finally
    //   116	121	545	finally
    //   129	135	545	finally
    //   147	172	545	finally
    //   187	193	545	finally
    //   199	205	545	finally
    //   215	241	545	finally
    //   247	256	545	finally
    //   259	277	545	finally
    //   284	289	545	finally
    //   299	308	545	finally
    //   346	352	545	finally
    //   360	369	545	finally
    //   377	386	545	finally
    //   394	401	545	finally
    //   409	416	545	finally
    //   424	438	545	finally
    //   446	451	545	finally
    //   463	488	545	finally
    //   492	496	545	finally
    //   522	528	545	finally
    //   537	542	545	finally
    //   588	596	545	finally
    //   329	333	558	java/io/IOException
    //   602	606	608	java/io/IOException
    //   619	623	626	java/io/IOException
    //   501	506	634	java/io/IOException
    //   551	556	642	java/io/IOException
    //   284	289	650	java/lang/Exception
    //   259	277	659	java/lang/Exception
  }
  
  public void requestDeeplink(MATDeferredDplinkr paramMATDeferredDplinkr)
  {
    Object localObject4 = null;
    String str = null;
    Uri.Builder localBuilder = new Uri.Builder();
    Object localObject2 = localBuilder.scheme("https").authority(paramMATDeferredDplinkr.getAdvertiserId() + "." + "deeplink.mobileapptracking.com").appendPath("v1").appendPath("link.txt").appendQueryParameter("platform", "android").appendQueryParameter("advertiser_id", paramMATDeferredDplinkr.getAdvertiserId()).appendQueryParameter("ver", "3.10.1").appendQueryParameter("package_name", paramMATDeferredDplinkr.getPackageName());
    Object localObject1;
    Object localObject3;
    if (paramMATDeferredDplinkr.getGoogleAdvertisingId() != null)
    {
      localObject1 = paramMATDeferredDplinkr.getGoogleAdvertisingId();
      ((Uri.Builder)localObject2).appendQueryParameter("ad_id", (String)localObject1).appendQueryParameter("user_agent", paramMATDeferredDplinkr.getUserAgent());
      if (paramMATDeferredDplinkr.getGoogleAdvertisingId() != null) {
        localBuilder.appendQueryParameter("google_ad_tracking_disabled", Integer.toString(paramMATDeferredDplinkr.getGoogleAdTrackingLimited()));
      }
      localObject3 = str;
      localObject2 = localObject4;
    }
    for (;;)
    {
      try
      {
        localObject1 = (HttpURLConnection)new URL(localBuilder.build().toString()).openConnection();
        localObject3 = str;
        localObject2 = localObject4;
        ((HttpURLConnection)localObject1).setRequestProperty("X-MAT-Key", paramMATDeferredDplinkr.getConversionKey());
        localObject3 = str;
        localObject2 = localObject4;
        ((HttpURLConnection)localObject1).setRequestMethod("GET");
        localObject3 = str;
        localObject2 = localObject4;
        ((HttpURLConnection)localObject1).setDoInput(true);
        localObject3 = str;
        localObject2 = localObject4;
        ((HttpURLConnection)localObject1).connect();
        i = 0;
        localObject3 = str;
        localObject2 = localObject4;
        if (((HttpURLConnection)localObject1).getResponseCode() == 200)
        {
          localObject3 = str;
          localObject2 = localObject4;
          localObject1 = ((HttpURLConnection)localObject1).getInputStream();
          localObject3 = localObject1;
          localObject2 = localObject1;
          str = MATUtils.readStream((InputStream)localObject1);
          localObject3 = localObject1;
          localObject2 = localObject1;
          paramMATDeferredDplinkr = paramMATDeferredDplinkr.getListener();
          if (paramMATDeferredDplinkr != null)
          {
            if (i == 0) {
              continue;
            }
            localObject3 = localObject1;
            localObject2 = localObject1;
            paramMATDeferredDplinkr.didFailDeeplink(str);
          }
        }
      }
      catch (Exception paramMATDeferredDplinkr)
      {
        int i;
        paramMATDeferredDplinkr = paramMATDeferredDplinkr;
        localObject2 = localObject3;
        paramMATDeferredDplinkr.printStackTrace();
        try
        {
          ((InputStream)localObject3).close();
          return;
        }
        catch (IOException paramMATDeferredDplinkr)
        {
          paramMATDeferredDplinkr.printStackTrace();
          return;
        }
      }
      finally {}
      try
      {
        ((InputStream)localObject1).close();
        return;
      }
      catch (IOException paramMATDeferredDplinkr)
      {
        paramMATDeferredDplinkr.printStackTrace();
        return;
      }
      localObject1 = paramMATDeferredDplinkr.getAndroidId();
      break;
      i = 1;
      localObject3 = str;
      localObject2 = localObject4;
      localObject1 = ((HttpURLConnection)localObject1).getErrorStream();
      continue;
      localObject3 = localObject1;
      localObject2 = localObject1;
      paramMATDeferredDplinkr.didReceiveDeeplink(str);
    }
    try
    {
      ((InputStream)localObject2).close();
      throw paramMATDeferredDplinkr;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException.printStackTrace();
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.mobileapptracker.MATUrlRequester
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */