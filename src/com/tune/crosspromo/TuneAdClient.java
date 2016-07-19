package com.tune.crosspromo;

import android.net.Uri;
import android.net.Uri.Builder;
import com.mobileapptracker.MobileAppTracker;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;

public class TuneAdClient
{
  private static String advertiserId;
  private static String apiUrl;
  private static boolean customMode;
  private static TuneAdUtils utils;
  
  private static void checkStatusCode(int paramInt, String paramString)
    throws TuneBadRequestException, TuneServerErrorException
  {
    if ((paramInt >= 400) && (paramInt < 500)) {
      throw new TuneBadRequestException(paramString);
    }
    if (paramInt >= 500) {
      throw new TuneServerErrorException(paramString);
    }
  }
  
  public static void logClick(TuneAdView paramTuneAdView, final JSONObject paramJSONObject)
  {
    if (MobileAppTracker.isOnline(utils.getContext())) {
      utils.getLogThread().execute(new Runnable()
      {
        public void run()
        {
          if (TuneAdClient.customMode) {}
          for (Uri.Builder localBuilder = Uri.parse("http://" + TuneAdClient.apiUrl + "/api/v1/ads/click").buildUpon();; localBuilder = Uri.parse("https://" + TuneAdClient.advertiserId + ".click." + TuneAdClient.apiUrl + "/click").buildUpon())
          {
            localBuilder.appendQueryParameter("action", "click").appendQueryParameter("requestId", val$adView.requestId);
            TuneAdClient.logEvent(localBuilder.build().toString(), paramJSONObject);
            return;
          }
        }
      });
    }
  }
  
  public static void logClose(TuneAdView paramTuneAdView, final JSONObject paramJSONObject)
  {
    if (MobileAppTracker.isOnline(utils.getContext())) {
      utils.getLogThread().execute(new Runnable()
      {
        public void run()
        {
          if (TuneAdClient.customMode) {}
          for (Uri.Builder localBuilder = Uri.parse("http://" + TuneAdClient.apiUrl + "/api/v1/ads/event").buildUpon();; localBuilder = Uri.parse("https://" + TuneAdClient.advertiserId + ".event." + TuneAdClient.apiUrl + "/event").buildUpon())
          {
            localBuilder.appendQueryParameter("action", "close").appendQueryParameter("requestId", val$adView.requestId);
            TuneAdClient.logEvent(localBuilder.build().toString(), paramJSONObject);
            return;
          }
        }
      });
    }
  }
  
  private static void logEvent(String paramString, JSONObject paramJSONObject)
  {
    for (;;)
    {
      try
      {
        paramString = (HttpURLConnection)new URL(paramString).openConnection();
        paramString.setReadTimeout(60000);
        paramString.setConnectTimeout(60000);
        paramString.setDoOutput(true);
        paramString.setRequestProperty("Content-Type", "application/json");
        paramString.setRequestProperty("Accept", "application/json");
        paramString.setRequestMethod("POST");
        OutputStream localOutputStream = paramString.getOutputStream();
        localOutputStream.write(paramJSONObject.toString().getBytes("UTF-8"));
        localOutputStream.close();
        paramString.connect();
      }
      catch (IOException paramString)
      {
        paramString.printStackTrace();
        if (0 == 0) {
          continue;
        }
        try
        {
          throw new NullPointerException();
        }
        catch (IOException paramString)
        {
          paramString.printStackTrace();
          return;
        }
      }
      finally
      {
        if (0 == 0) {
          break label135;
        }
      }
      try
      {
        throw new NullPointerException();
      }
      catch (IOException paramString)
      {
        paramString.printStackTrace();
        return;
      }
    }
    return;
    try
    {
      throw new NullPointerException();
      label135:
      throw paramJSONObject;
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public static void logView(TuneAdView paramTuneAdView, final JSONObject paramJSONObject)
  {
    if (MobileAppTracker.isOnline(utils.getContext())) {
      utils.getLogThread().execute(new Runnable()
      {
        public void run()
        {
          if (TuneAdClient.customMode) {}
          for (Uri.Builder localBuilder = Uri.parse("http://" + TuneAdClient.apiUrl + "/api/v1/ads/event").buildUpon();; localBuilder = Uri.parse("https://" + TuneAdClient.advertiserId + ".event." + TuneAdClient.apiUrl + "/event").buildUpon())
          {
            localBuilder.appendQueryParameter("action", "view").appendQueryParameter("requestId", val$adView.requestId);
            TuneAdClient.logEvent(localBuilder.build().toString(), paramJSONObject);
            return;
          }
        }
      });
    }
  }
  
  /* Error */
  public static String requestAd(String paramString, JSONObject paramJSONObject)
    throws TuneBadRequestException, TuneServerErrorException, ConnectException
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
    //   20: new 80	java/net/URL
    //   23: dup
    //   24: aload_0
    //   25: invokespecial 81	java/net/URL:<init>	(Ljava/lang/String;)V
    //   28: invokevirtual 85	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   31: checkcast 87	java/net/HttpURLConnection
    //   34: astore 9
    //   36: aload 6
    //   38: astore 4
    //   40: aload 7
    //   42: astore_3
    //   43: aload 8
    //   45: astore 5
    //   47: aload 9
    //   49: ldc 88
    //   51: invokevirtual 92	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   54: aload 6
    //   56: astore 4
    //   58: aload 7
    //   60: astore_3
    //   61: aload 8
    //   63: astore 5
    //   65: aload 9
    //   67: ldc 88
    //   69: invokevirtual 95	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   72: aload 6
    //   74: astore 4
    //   76: aload 7
    //   78: astore_3
    //   79: aload 8
    //   81: astore 5
    //   83: aload 9
    //   85: iconst_1
    //   86: invokevirtual 160	java/net/HttpURLConnection:setDoInput	(Z)V
    //   89: aload 6
    //   91: astore 4
    //   93: aload 7
    //   95: astore_3
    //   96: aload 8
    //   98: astore 5
    //   100: aload 9
    //   102: iconst_1
    //   103: invokevirtual 99	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   106: aload 6
    //   108: astore 4
    //   110: aload 7
    //   112: astore_3
    //   113: aload 8
    //   115: astore 5
    //   117: aload 9
    //   119: ldc 101
    //   121: ldc 103
    //   123: invokevirtual 107	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   126: aload 6
    //   128: astore 4
    //   130: aload 7
    //   132: astore_3
    //   133: aload 8
    //   135: astore 5
    //   137: aload 9
    //   139: ldc 109
    //   141: ldc 103
    //   143: invokevirtual 107	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   146: aload 6
    //   148: astore 4
    //   150: aload 7
    //   152: astore_3
    //   153: aload 8
    //   155: astore 5
    //   157: aload 9
    //   159: ldc 111
    //   161: invokevirtual 114	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   164: aload 6
    //   166: astore 4
    //   168: aload 7
    //   170: astore_3
    //   171: aload 8
    //   173: astore 5
    //   175: aload 9
    //   177: invokevirtual 118	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   180: astore_0
    //   181: aload 6
    //   183: astore 4
    //   185: aload 7
    //   187: astore_3
    //   188: aload 8
    //   190: astore 5
    //   192: aload_0
    //   193: aload_1
    //   194: invokevirtual 123	org/json/JSONObject:toString	()Ljava/lang/String;
    //   197: ldc 125
    //   199: invokevirtual 131	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   202: invokevirtual 137	java/io/OutputStream:write	([B)V
    //   205: aload 6
    //   207: astore 4
    //   209: aload 7
    //   211: astore_3
    //   212: aload 8
    //   214: astore 5
    //   216: aload_0
    //   217: invokevirtual 141	java/io/OutputStream:close	()V
    //   220: aload 6
    //   222: astore 4
    //   224: aload 7
    //   226: astore_3
    //   227: aload 8
    //   229: astore 5
    //   231: aload 9
    //   233: invokevirtual 144	java/net/HttpURLConnection:connect	()V
    //   236: aload 6
    //   238: astore 4
    //   240: aload 7
    //   242: astore_3
    //   243: aload 8
    //   245: astore 5
    //   247: aload 9
    //   249: invokevirtual 164	java/net/HttpURLConnection:getResponseCode	()I
    //   252: istore_2
    //   253: iload_2
    //   254: sipush 200
    //   257: if_icmpne +54 -> 311
    //   260: aload 6
    //   262: astore 4
    //   264: aload 7
    //   266: astore_3
    //   267: aload 8
    //   269: astore 5
    //   271: aload 9
    //   273: invokevirtual 168	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   276: astore_0
    //   277: aload_0
    //   278: astore 4
    //   280: aload_0
    //   281: astore_3
    //   282: aload_0
    //   283: astore 5
    //   285: aload 9
    //   287: invokevirtual 168	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   290: invokestatic 174	com/mobileapptracker/MATUtils:readStream	(Ljava/io/InputStream;)Ljava/lang/String;
    //   293: astore_1
    //   294: aload_0
    //   295: ifnull +7 -> 302
    //   298: aload_0
    //   299: invokevirtual 177	java/io/InputStream:close	()V
    //   302: aload_1
    //   303: areturn
    //   304: astore_0
    //   305: aload_0
    //   306: invokevirtual 151	java/io/IOException:printStackTrace	()V
    //   309: aload_1
    //   310: areturn
    //   311: aload 6
    //   313: astore 4
    //   315: aload 7
    //   317: astore_3
    //   318: aload 8
    //   320: astore 5
    //   322: aload 9
    //   324: invokevirtual 180	java/net/HttpURLConnection:getErrorStream	()Ljava/io/InputStream;
    //   327: astore_0
    //   328: aload_0
    //   329: astore 4
    //   331: aload_0
    //   332: astore_3
    //   333: aload_0
    //   334: astore 5
    //   336: iload_2
    //   337: aload_0
    //   338: invokestatic 174	com/mobileapptracker/MATUtils:readStream	(Ljava/io/InputStream;)Ljava/lang/String;
    //   341: invokestatic 182	com/tune/crosspromo/TuneAdClient:checkStatusCode	(ILjava/lang/String;)V
    //   344: aload_0
    //   345: ifnull +7 -> 352
    //   348: aload_0
    //   349: invokevirtual 177	java/io/InputStream:close	()V
    //   352: aconst_null
    //   353: areturn
    //   354: astore_0
    //   355: aload_0
    //   356: invokevirtual 151	java/io/IOException:printStackTrace	()V
    //   359: goto -7 -> 352
    //   362: astore_0
    //   363: aload 4
    //   365: astore_3
    //   366: aload_0
    //   367: invokevirtual 183	java/net/ConnectException:printStackTrace	()V
    //   370: aload 4
    //   372: astore_3
    //   373: new 157	java/net/ConnectException
    //   376: dup
    //   377: invokespecial 184	java/net/ConnectException:<init>	()V
    //   380: athrow
    //   381: astore_0
    //   382: aload_3
    //   383: ifnull +7 -> 390
    //   386: aload_3
    //   387: invokevirtual 177	java/io/InputStream:close	()V
    //   390: aload_0
    //   391: athrow
    //   392: astore_0
    //   393: aload 5
    //   395: astore_3
    //   396: aload_0
    //   397: invokevirtual 151	java/io/IOException:printStackTrace	()V
    //   400: aload 5
    //   402: ifnull -50 -> 352
    //   405: aload 5
    //   407: invokevirtual 177	java/io/InputStream:close	()V
    //   410: goto -58 -> 352
    //   413: astore_0
    //   414: aload_0
    //   415: invokevirtual 151	java/io/IOException:printStackTrace	()V
    //   418: goto -66 -> 352
    //   421: astore_1
    //   422: aload_1
    //   423: invokevirtual 151	java/io/IOException:printStackTrace	()V
    //   426: goto -36 -> 390
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	429	0	paramString	String
    //   0	429	1	paramJSONObject	JSONObject
    //   252	85	2	i	int
    //   15	381	3	localObject1	Object
    //   11	360	4	localObject2	Object
    //   18	388	5	localObject3	Object
    //   7	305	6	localObject4	Object
    //   1	315	7	localObject5	Object
    //   4	315	8	localObject6	Object
    //   34	289	9	localHttpURLConnection	HttpURLConnection
    // Exception table:
    //   from	to	target	type
    //   298	302	304	java/io/IOException
    //   348	352	354	java/io/IOException
    //   20	36	362	java/net/ConnectException
    //   47	54	362	java/net/ConnectException
    //   65	72	362	java/net/ConnectException
    //   83	89	362	java/net/ConnectException
    //   100	106	362	java/net/ConnectException
    //   117	126	362	java/net/ConnectException
    //   137	146	362	java/net/ConnectException
    //   157	164	362	java/net/ConnectException
    //   175	181	362	java/net/ConnectException
    //   192	205	362	java/net/ConnectException
    //   216	220	362	java/net/ConnectException
    //   231	236	362	java/net/ConnectException
    //   247	253	362	java/net/ConnectException
    //   271	277	362	java/net/ConnectException
    //   285	294	362	java/net/ConnectException
    //   322	328	362	java/net/ConnectException
    //   336	344	362	java/net/ConnectException
    //   20	36	381	finally
    //   47	54	381	finally
    //   65	72	381	finally
    //   83	89	381	finally
    //   100	106	381	finally
    //   117	126	381	finally
    //   137	146	381	finally
    //   157	164	381	finally
    //   175	181	381	finally
    //   192	205	381	finally
    //   216	220	381	finally
    //   231	236	381	finally
    //   247	253	381	finally
    //   271	277	381	finally
    //   285	294	381	finally
    //   322	328	381	finally
    //   336	344	381	finally
    //   366	370	381	finally
    //   373	381	381	finally
    //   396	400	381	finally
    //   20	36	392	java/io/IOException
    //   47	54	392	java/io/IOException
    //   65	72	392	java/io/IOException
    //   83	89	392	java/io/IOException
    //   100	106	392	java/io/IOException
    //   117	126	392	java/io/IOException
    //   137	146	392	java/io/IOException
    //   157	164	392	java/io/IOException
    //   175	181	392	java/io/IOException
    //   192	205	392	java/io/IOException
    //   216	220	392	java/io/IOException
    //   231	236	392	java/io/IOException
    //   247	253	392	java/io/IOException
    //   271	277	392	java/io/IOException
    //   285	294	392	java/io/IOException
    //   322	328	392	java/io/IOException
    //   336	344	392	java/io/IOException
    //   405	410	413	java/io/IOException
    //   386	390	421	java/io/IOException
  }
  
  public static String requestAdOfType(String paramString, TuneAdParams paramTuneAdParams)
    throws TuneBadRequestException, TuneServerErrorException, ConnectException
  {
    Object localObject = null;
    if (MobileAppTracker.isOnline(utils.getContext())) {
      if (!customMode) {
        break label94;
      }
    }
    label94:
    for (localObject = Uri.parse("http://" + apiUrl + "/api/v1/ads/request").buildUpon();; localObject = Uri.parse("https://" + advertiserId + ".request." + apiUrl + "/request").buildUpon())
    {
      ((Uri.Builder)localObject).encodedQuery("context[type]=" + paramString);
      localObject = requestAd(((Uri.Builder)localObject).build().toString(), paramTuneAdParams.toJSON());
      return (String)localObject;
    }
  }
  
  public static String requestInterstitialAd(TuneAdParams paramTuneAdParams)
    throws TuneBadRequestException, TuneServerErrorException, ConnectException
  {
    return requestAdOfType("interstitial", paramTuneAdParams);
  }
}

/* Location:
 * Qualified Name:     com.tune.crosspromo.TuneAdClient
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */