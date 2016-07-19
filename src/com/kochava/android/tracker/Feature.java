package com.kochava.android.tracker;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.ComponentCallbacks2;
import android.content.ComponentName;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings.Secure;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.kochava.android.util.Logging;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Constructor;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Feature
{
  private static final Uri ATTRIBUTION_ID_CONTENT_URI;
  private static String adid;
  private static String advertisingID;
  protected static Context appContext;
  private static Handler attributionDataHandler;
  private static SharedPreferences attributionDataPrefs;
  private static boolean badInit;
  private static String bssid;
  private static boolean canSendSession;
  private static String carrier;
  private static boolean device_limit_tracking;
  private static boolean doGatherLocation;
  private static boolean event_flush_triggered;
  private static JSONArray eventnameBlacklist;
  private static final ExecutorService executor;
  private static boolean flushTimerSetByInitializer;
  private static boolean flushTimerSetByKVinitResponse;
  private static int flush_rate;
  private static int get_attribution_wait;
  private static String hostControl = "";
  private static Map<String, String> identityLinkMap;
  private static JSONObject identityLinkMapJSON;
  private static List<ApplicationInfoHolder> installedApps;
  private static boolean is_in_background;
  private static DbAdapter kDbAdapter;
  private static final HashMap<Integer, Integer> kvinitRetrySteps;
  private static long lastCallTime;
  private static long lastEventTimestamp;
  protected static Handler locationHandler = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      if (Feature.badInit) {
        Logging.LogError("The library was not initialized properly or we cannot connect to our servers. Cannot send location udpate");
      }
      do
      {
        for (;;)
        {
          return;
          Logging.Log("Location Handler got message, queueing location update.");
          try
          {
            paramAnonymousMessage = new JSONObject();
            JSONObject localJSONObject1 = new JSONObject();
            JSONObject localJSONObject2 = new JSONObject();
            localJSONObject2.put("lat", Feature.prefs.getString("kochava_lat", ""));
            localJSONObject2.put("lon", Feature.prefs.getString("kochava_lon", ""));
            localJSONObject2.put("acc", Feature.prefs.getString("kochava_accuracy", ""));
            localJSONObject1.put("location", localJSONObject2);
            paramAnonymousMessage.put("action", "update");
            paramAnonymousMessage.put("kochava_device_id", Feature.access$2800());
            paramAnonymousMessage.put("kochava_app_id", Feature.mAppId);
            paramAnonymousMessage.put("sdk_version", "Android20160222" + Feature.versionExtension);
            paramAnonymousMessage.put("sdk_protocol", "4");
            paramAnonymousMessage.put("data", localJSONObject1);
            Logging.Log("Location update: " + paramAnonymousMessage);
            int i = Feature.kDbAdapter.addEvent(paramAnonymousMessage, false, true);
            Feature.access$4902(System.currentTimeMillis());
            long l = Feature.prefs.getLong("kochava_loc_timestamp", 0L);
            Feature.prefs.edit().putLong("kochava_old_loc_timestamp", l).apply();
            if (i >= 50)
            {
              Feature.flush();
              return;
            }
          }
          catch (JSONException paramAnonymousMessage) {}
        }
      } while (!Global.DEBUGERROR);
      paramAnonymousMessage.printStackTrace();
    }
  };
  private static String mAppId;
  private static String mKochDevIDStrategy;
  private static Map<String, String> mSuperProperties;
  private static Timer mTimer;
  protected static boolean overrideAutomaticSessions;
  private static HashMap<String, Boolean> paramRestrictions;
  private static SharedPreferences prefs;
  private static int referrerDelayFromInit;
  private static boolean requestAttributionData;
  private static boolean sendEmails;
  private static Runnable sendKVQuery;
  private static boolean sendOnStart;
  private static boolean send_id_updates;
  private static boolean should_flush_in_background;
  private static long startTime;
  private static boolean suppress_adid;
  protected static String versionExtension = "";
  private static final ScheduledExecutorService worker;
  private final String LOCATION_ACCURACY = "location_accuracy";
  private final String LOCATION_STALENESS = "location_staleness";
  private final String LOCATION_TIMEOUT = "location_timeout";
  private boolean app_limit_tracking = false;
  private String clickData;
  private Timer eventFlushTimer;
  private Runnable getKVinit = new Runnable()
  {
    /* Error */
    @SuppressLint({"NewApi"})
    public void run()
    {
      // Byte code:
      //   0: ldc 32
      //   2: invokestatic 38	com/kochava/android/util/Logging:Log	(Ljava/lang/String;)V
      //   5: invokestatic 43	android/os/Looper:prepare	()V
      //   8: lconst_0
      //   9: lstore 6
      //   11: iconst_0
      //   12: istore_3
      //   13: iconst_0
      //   14: istore_2
      //   15: invokestatic 49	java/lang/System:currentTimeMillis	()J
      //   18: lstore 8
      //   20: invokestatic 53	com/kochava/android/tracker/Feature:access$400	()Landroid/content/SharedPreferences;
      //   23: ldc 55
      //   25: invokestatic 49	java/lang/System:currentTimeMillis	()J
      //   28: invokeinterface 61 4 0
      //   33: lstore 10
      //   35: lload 8
      //   37: lload 10
      //   39: lsub
      //   40: lstore 6
      //   42: iload_3
      //   43: istore_1
      //   44: invokestatic 53	com/kochava/android/tracker/Feature:access$400	()Landroid/content/SharedPreferences;
      //   47: ldc 63
      //   49: invokeinterface 67 2 0
      //   54: ifeq +65 -> 119
      //   57: iload_3
      //   58: istore_1
      //   59: invokestatic 53	com/kochava/android/tracker/Feature:access$400	()Landroid/content/SharedPreferences;
      //   62: ldc 63
      //   64: ldc 69
      //   66: invokeinterface 73 3 0
      //   71: aload_0
      //   72: getfield 14	com/kochava/android/tracker/Feature$6:this$0	Lcom/kochava/android/tracker/Feature;
      //   75: invokestatic 77	com/kochava/android/tracker/Feature:access$500	(Lcom/kochava/android/tracker/Feature;)Ljava/lang/String;
      //   78: invokevirtual 83	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   81: ifne +38 -> 119
      //   84: new 85	java/lang/StringBuilder
      //   87: dup
      //   88: invokespecial 86	java/lang/StringBuilder:<init>	()V
      //   91: ldc 88
      //   93: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   96: aload_0
      //   97: getfield 14	com/kochava/android/tracker/Feature$6:this$0	Lcom/kochava/android/tracker/Feature;
      //   100: invokestatic 77	com/kochava/android/tracker/Feature:access$500	(Lcom/kochava/android/tracker/Feature;)Ljava/lang/String;
      //   103: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   106: ldc 94
      //   108: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   111: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   114: invokestatic 38	com/kochava/android/util/Logging:Log	(Ljava/lang/String;)V
      //   117: iconst_1
      //   118: istore_1
      //   119: iload_1
      //   120: ifne +29 -> 149
      //   123: lload 6
      //   125: lconst_0
      //   126: lcmp
      //   127: ifle +22 -> 149
      //   130: lload 6
      //   132: invokestatic 53	com/kochava/android/tracker/Feature:access$400	()Landroid/content/SharedPreferences;
      //   135: ldc 100
      //   137: ldc2_w 101
      //   140: invokeinterface 61 4 0
      //   145: lcmp
      //   146: ifle +3227 -> 3373
      //   149: aconst_null
      //   150: astore 13
      //   152: iload_2
      //   153: istore_1
      //   154: new 85	java/lang/StringBuilder
      //   157: dup
      //   158: invokespecial 86	java/lang/StringBuilder:<init>	()V
      //   161: ldc 104
      //   163: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   166: aload_0
      //   167: getfield 14	com/kochava/android/tracker/Feature$6:this$0	Lcom/kochava/android/tracker/Feature;
      //   170: getfield 108	com/kochava/android/tracker/Feature:kvinitdataholder	Lorg/json/JSONObject;
      //   173: invokevirtual 111	org/json/JSONObject:toString	()Ljava/lang/String;
      //   176: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   179: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   182: invokestatic 38	com/kochava/android/util/Logging:Log	(Ljava/lang/String;)V
      //   185: invokestatic 114	com/kochava/android/tracker/Feature:access$600	()Ljava/lang/String;
      //   188: ifnull +15 -> 203
      //   191: invokestatic 114	com/kochava/android/tracker/Feature:access$600	()Ljava/lang/String;
      //   194: invokevirtual 117	java/lang/String:trim	()Ljava/lang/String;
      //   197: invokevirtual 121	java/lang/String:isEmpty	()Z
      //   200: ifeq +14 -> 214
      //   203: ldc 123
      //   205: invokestatic 38	com/kochava/android/util/Logging:Log	(Ljava/lang/String;)V
      //   208: ldc 125
      //   210: invokestatic 129	com/kochava/android/tracker/Feature:access$602	(Ljava/lang/String;)Ljava/lang/String;
      //   213: pop
      //   214: new 85	java/lang/StringBuilder
      //   217: dup
      //   218: invokespecial 86	java/lang/StringBuilder:<init>	()V
      //   221: ldc -125
      //   223: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   226: ldc -123
      //   228: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   231: invokestatic 114	com/kochava/android/tracker/Feature:access$600	()Ljava/lang/String;
      //   234: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   237: ldc -121
      //   239: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   242: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   245: invokestatic 38	com/kochava/android/util/Logging:Log	(Ljava/lang/String;)V
      //   248: new 137	java/net/URL
      //   251: dup
      //   252: new 85	java/lang/StringBuilder
      //   255: dup
      //   256: invokespecial 86	java/lang/StringBuilder:<init>	()V
      //   259: ldc -123
      //   261: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   264: invokestatic 114	com/kochava/android/tracker/Feature:access$600	()Ljava/lang/String;
      //   267: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   270: ldc -121
      //   272: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   275: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   278: invokespecial 139	java/net/URL:<init>	(Ljava/lang/String;)V
      //   281: invokevirtual 143	java/net/URL:openConnection	()Ljava/net/URLConnection;
      //   284: checkcast 145	javax/net/ssl/HttpsURLConnection
      //   287: astore 14
      //   289: aload 14
      //   291: ldc -109
      //   293: invokestatic 53	com/kochava/android/tracker/Feature:access$400	()Landroid/content/SharedPreferences;
      //   296: ldc -107
      //   298: ldc 69
      //   300: invokeinterface 73 3 0
      //   305: invokevirtual 153	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
      //   308: aload 14
      //   310: ldc -101
      //   312: ldc -99
      //   314: invokevirtual 153	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
      //   317: aload 14
      //   319: ldc -97
      //   321: invokevirtual 162	javax/net/ssl/HttpsURLConnection:setRequestMethod	(Ljava/lang/String;)V
      //   324: aload 14
      //   326: sipush 30000
      //   329: invokevirtual 166	javax/net/ssl/HttpsURLConnection:setConnectTimeout	(I)V
      //   332: aload 14
      //   334: sipush 30000
      //   337: invokevirtual 169	javax/net/ssl/HttpsURLConnection:setReadTimeout	(I)V
      //   340: aload 14
      //   342: iconst_1
      //   343: invokevirtual 173	javax/net/ssl/HttpsURLConnection:setDoInput	(Z)V
      //   346: aload 14
      //   348: iconst_1
      //   349: invokevirtual 176	javax/net/ssl/HttpsURLConnection:setDoOutput	(Z)V
      //   352: aload 14
      //   354: invokevirtual 179	javax/net/ssl/HttpsURLConnection:connect	()V
      //   357: aload_0
      //   358: getfield 14	com/kochava/android/tracker/Feature$6:this$0	Lcom/kochava/android/tracker/Feature;
      //   361: getfield 108	com/kochava/android/tracker/Feature:kvinitdataholder	Lorg/json/JSONObject;
      //   364: invokevirtual 111	org/json/JSONObject:toString	()Ljava/lang/String;
      //   367: astore 15
      //   369: new 85	java/lang/StringBuilder
      //   372: dup
      //   373: invokespecial 86	java/lang/StringBuilder:<init>	()V
      //   376: ldc -75
      //   378: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   381: aload 15
      //   383: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   386: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   389: invokestatic 38	com/kochava/android/util/Logging:Log	(Ljava/lang/String;)V
      //   392: ldc -73
      //   394: invokestatic 38	com/kochava/android/util/Logging:Log	(Ljava/lang/String;)V
      //   397: new 185	java/io/OutputStreamWriter
      //   400: dup
      //   401: aload 14
      //   403: invokevirtual 189	javax/net/ssl/HttpsURLConnection:getOutputStream	()Ljava/io/OutputStream;
      //   406: invokespecial 192	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;)V
      //   409: astore 16
      //   411: aload 16
      //   413: aload 15
      //   415: invokevirtual 195	java/io/OutputStreamWriter:write	(Ljava/lang/String;)V
      //   418: aload 16
      //   420: invokevirtual 198	java/io/OutputStreamWriter:close	()V
      //   423: ldc -56
      //   425: invokestatic 38	com/kochava/android/util/Logging:Log	(Ljava/lang/String;)V
      //   428: new 202	java/lang/StringBuffer
      //   431: dup
      //   432: ldc 69
      //   434: invokespecial 203	java/lang/StringBuffer:<init>	(Ljava/lang/String;)V
      //   437: astore 15
      //   439: new 205	java/io/BufferedReader
      //   442: dup
      //   443: new 207	java/io/InputStreamReader
      //   446: dup
      //   447: aload 14
      //   449: invokevirtual 211	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
      //   452: invokespecial 214	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
      //   455: invokespecial 217	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
      //   458: astore 14
      //   460: aload 14
      //   462: invokevirtual 220	java/io/BufferedReader:readLine	()Ljava/lang/String;
      //   465: astore 16
      //   467: aload 16
      //   469: ifnull +89 -> 558
      //   472: aload 15
      //   474: aload 16
      //   476: invokevirtual 223	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
      //   479: pop
      //   480: goto -20 -> 460
      //   483: astore 13
      //   485: ldc -31
      //   487: aload 13
      //   489: invokevirtual 229	java/lang/Object:getClass	()Ljava/lang/Class;
      //   492: invokevirtual 235	java/lang/Class:isAssignableFrom	(Ljava/lang/Class;)Z
      //   495: ifeq +2853 -> 3348
      //   498: new 85	java/lang/StringBuilder
      //   501: dup
      //   502: invokespecial 86	java/lang/StringBuilder:<init>	()V
      //   505: ldc -19
      //   507: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   510: aload 13
      //   512: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   515: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   518: invokestatic 243	com/kochava/android/util/Logging:LogError	(Ljava/lang/String;)V
      //   521: aload 13
      //   523: invokestatic 247	com/kochava/android/tracker/Feature:access$2400	(Ljava/lang/Exception;)V
      //   526: return
      //   527: astore 13
      //   529: new 85	java/lang/StringBuilder
      //   532: dup
      //   533: invokespecial 86	java/lang/StringBuilder:<init>	()V
      //   536: ldc -7
      //   538: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   541: aload 13
      //   543: invokevirtual 250	java/lang/Exception:toString	()Ljava/lang/String;
      //   546: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   549: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   552: invokestatic 38	com/kochava/android/util/Logging:Log	(Ljava/lang/String;)V
      //   555: goto -513 -> 42
      //   558: aload 15
      //   560: invokevirtual 251	java/lang/StringBuffer:toString	()Ljava/lang/String;
      //   563: astore 14
      //   565: new 85	java/lang/StringBuilder
      //   568: dup
      //   569: invokespecial 86	java/lang/StringBuilder:<init>	()V
      //   572: ldc -3
      //   574: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   577: aload 14
      //   579: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   582: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   585: invokestatic 38	com/kochava/android/util/Logging:Log	(Ljava/lang/String;)V
      //   588: new 110	org/json/JSONObject
      //   591: dup
      //   592: aload 14
      //   594: invokespecial 254	org/json/JSONObject:<init>	(Ljava/lang/String;)V
      //   597: astore 14
      //   599: aload 14
      //   601: astore 13
      //   603: invokestatic 53	com/kochava/android/tracker/Feature:access$400	()Landroid/content/SharedPreferences;
      //   606: ldc_w 256
      //   609: ldc 69
      //   611: invokeinterface 73 3 0
      //   616: ldc_w 258
      //   619: invokevirtual 83	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   622: istore 12
      //   624: iload_1
      //   625: istore_2
      //   626: iload 12
      //   628: ifne +134 -> 762
      //   631: iload_1
      //   632: istore_2
      //   633: aload 13
      //   635: ifnull +127 -> 762
      //   638: aload 13
      //   640: ldc_w 260
      //   643: invokevirtual 264	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
      //   646: astore 14
      //   648: iconst_0
      //   649: istore 5
      //   651: iconst_0
      //   652: istore 4
      //   654: iload_1
      //   655: istore_2
      //   656: iload 5
      //   658: istore_3
      //   659: iload 4
      //   661: aload 14
      //   663: invokevirtual 270	org/json/JSONArray:length	()I
      //   666: if_icmpge +90 -> 756
      //   669: ldc_w 272
      //   672: aload 14
      //   674: iload 4
      //   676: invokevirtual 275	org/json/JSONArray:getString	(I)Ljava/lang/String;
      //   679: invokevirtual 83	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   682: ifeq +1044 -> 1726
      //   685: iconst_1
      //   686: istore_3
      //   687: iload_1
      //   688: istore_2
      //   689: iload_1
      //   690: iconst_4
      //   691: if_icmpge +7 -> 698
      //   694: iload_1
      //   695: iconst_1
      //   696: iadd
      //   697: istore_2
      //   698: new 85	java/lang/StringBuilder
      //   701: dup
      //   702: invokespecial 86	java/lang/StringBuilder:<init>	()V
      //   705: ldc_w 277
      //   708: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   711: invokestatic 281	com/kochava/android/tracker/Feature:access$700	()Ljava/util/HashMap;
      //   714: iload_2
      //   715: invokestatic 287	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   718: invokevirtual 293	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
      //   721: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   724: ldc_w 295
      //   727: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   730: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   733: invokestatic 38	com/kochava/android/util/Logging:Log	(Ljava/lang/String;)V
      //   736: invokestatic 281	com/kochava/android/tracker/Feature:access$700	()Ljava/util/HashMap;
      //   739: iload_2
      //   740: invokestatic 287	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   743: invokevirtual 293	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
      //   746: checkcast 283	java/lang/Integer
      //   749: invokevirtual 298	java/lang/Integer:intValue	()I
      //   752: i2l
      //   753: invokestatic 304	java/lang/Thread:sleep	(J)V
      //   756: iload_3
      //   757: ifne +5 -> 762
      //   760: iconst_0
      //   761: istore_2
      //   762: iload_2
      //   763: ifne +2868 -> 3631
      //   766: aload 13
      //   768: ifnull +2211 -> 2979
      //   771: new 85	java/lang/StringBuilder
      //   774: dup
      //   775: invokespecial 86	java/lang/StringBuilder:<init>	()V
      //   778: ldc_w 306
      //   781: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   784: aload 13
      //   786: invokevirtual 111	org/json/JSONObject:toString	()Ljava/lang/String;
      //   789: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   792: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   795: invokestatic 38	com/kochava/android/util/Logging:Log	(Ljava/lang/String;)V
      //   798: aconst_null
      //   799: astore 14
      //   801: aload 13
      //   803: ldc_w 308
      //   806: invokevirtual 312	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
      //   809: astore 15
      //   811: aload 15
      //   813: astore 14
      //   815: new 85	java/lang/StringBuilder
      //   818: dup
      //   819: invokespecial 86	java/lang/StringBuilder:<init>	()V
      //   822: ldc_w 314
      //   825: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   828: aload 15
      //   830: invokevirtual 111	org/json/JSONObject:toString	()Ljava/lang/String;
      //   833: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   836: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   839: invokestatic 38	com/kochava/android/util/Logging:Log	(Ljava/lang/String;)V
      //   842: aload 15
      //   844: astore 14
      //   846: aload 14
      //   848: ifnull +750 -> 1598
      //   851: aload 14
      //   853: ldc_w 316
      //   856: invokevirtual 318	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
      //   859: astore 15
      //   861: new 85	java/lang/StringBuilder
      //   864: dup
      //   865: invokespecial 86	java/lang/StringBuilder:<init>	()V
      //   868: ldc_w 320
      //   871: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   874: aload 15
      //   876: invokevirtual 321	java/lang/String:toString	()Ljava/lang/String;
      //   879: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   882: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   885: invokestatic 38	com/kochava/android/util/Logging:Log	(Ljava/lang/String;)V
      //   888: aload 15
      //   890: invokestatic 324	com/kochava/android/tracker/Feature:access$802	(Ljava/lang/String;)Ljava/lang/String;
      //   893: pop
      //   894: aload 14
      //   896: ldc_w 326
      //   899: invokevirtual 329	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
      //   902: ldc_w 331
      //   905: invokevirtual 332	java/lang/Object:equals	(Ljava/lang/Object;)Z
      //   908: ifeq +8 -> 916
      //   911: iconst_0
      //   912: invokestatic 336	com/kochava/android/tracker/Feature:access$902	(Z)Z
      //   915: pop
      //   916: aload 14
      //   918: ldc_w 338
      //   921: invokevirtual 329	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
      //   924: checkcast 79	java/lang/String
      //   927: invokevirtual 341	java/lang/String:toUpperCase	()Ljava/lang/String;
      //   930: astore 15
      //   932: new 85	java/lang/StringBuilder
      //   935: dup
      //   936: invokespecial 86	java/lang/StringBuilder:<init>	()V
      //   939: ldc_w 343
      //   942: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   945: aload 15
      //   947: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   950: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   953: invokestatic 38	com/kochava/android/util/Logging:Log	(Ljava/lang/String;)V
      //   956: aload_0
      //   957: getfield 14	com/kochava/android/tracker/Feature$6:this$0	Lcom/kochava/android/tracker/Feature;
      //   960: aload 15
      //   962: invokestatic 347	com/kochava/android/tracker/Feature:access$1000	(Lcom/kochava/android/tracker/Feature;Ljava/lang/String;)V
      //   965: aload 14
      //   967: ldc_w 349
      //   970: invokevirtual 329	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
      //   973: ldc_w 258
      //   976: invokevirtual 332	java/lang/Object:equals	(Ljava/lang/Object;)Z
      //   979: ifeq +47 -> 1026
      //   982: ldc_w 351
      //   985: invokestatic 38	com/kochava/android/util/Logging:Log	(Ljava/lang/String;)V
      //   988: getstatic 355	com/kochava/android/tracker/Feature:appContext	Landroid/content/Context;
      //   991: ldc_w 357
      //   994: iconst_0
      //   995: invokevirtual 363	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
      //   998: invokestatic 367	com/kochava/android/tracker/Feature:access$402	(Landroid/content/SharedPreferences;)Landroid/content/SharedPreferences;
      //   1001: pop
      //   1002: invokestatic 53	com/kochava/android/tracker/Feature:access$400	()Landroid/content/SharedPreferences;
      //   1005: invokeinterface 371 1 0
      //   1010: ldc_w 256
      //   1013: ldc_w 373
      //   1016: invokeinterface 379 3 0
      //   1021: invokeinterface 382 1 0
      //   1026: aload 14
      //   1028: ldc_w 384
      //   1031: invokevirtual 329	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
      //   1034: checkcast 283	java/lang/Integer
      //   1037: invokevirtual 298	java/lang/Integer:intValue	()I
      //   1040: invokestatic 388	com/kochava/android/tracker/Feature:access$1102	(I)I
      //   1043: pop
      //   1044: invokestatic 391	com/kochava/android/tracker/Feature:access$1100	()I
      //   1047: ifge +777 -> 1824
      //   1050: new 85	java/lang/StringBuilder
      //   1053: dup
      //   1054: invokespecial 86	java/lang/StringBuilder:<init>	()V
      //   1057: ldc_w 393
      //   1060: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1063: invokestatic 391	com/kochava/android/tracker/Feature:access$1100	()I
      //   1066: invokevirtual 396	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   1069: ldc_w 398
      //   1072: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1075: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1078: invokestatic 38	com/kochava/android/util/Logging:Log	(Ljava/lang/String;)V
      //   1081: iconst_0
      //   1082: invokestatic 388	com/kochava/android/tracker/Feature:access$1102	(I)I
      //   1085: pop
      //   1086: invokestatic 401	com/kochava/android/tracker/Feature:access$1200	()Z
      //   1089: ifne +89 -> 1178
      //   1092: aload 14
      //   1094: ldc_w 403
      //   1097: invokevirtual 329	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
      //   1100: ifnull +78 -> 1178
      //   1103: aload 14
      //   1105: ldc_w 403
      //   1108: invokevirtual 329	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
      //   1111: invokevirtual 229	java/lang/Object:getClass	()Ljava/lang/Class;
      //   1114: ldc_w 283
      //   1117: invokevirtual 332	java/lang/Object:equals	(Ljava/lang/Object;)Z
      //   1120: ifeq +58 -> 1178
      //   1123: aload 14
      //   1125: ldc_w 403
      //   1128: invokevirtual 329	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
      //   1131: checkcast 283	java/lang/Integer
      //   1134: invokevirtual 298	java/lang/Integer:intValue	()I
      //   1137: istore_1
      //   1138: iload_1
      //   1139: bipush 60
      //   1141: if_icmpge +759 -> 1900
      //   1144: new 85	java/lang/StringBuilder
      //   1147: dup
      //   1148: invokespecial 86	java/lang/StringBuilder:<init>	()V
      //   1151: ldc_w 405
      //   1154: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1157: iload_1
      //   1158: invokevirtual 396	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   1161: ldc_w 407
      //   1164: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1167: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1170: invokestatic 38	com/kochava/android/util/Logging:Log	(Ljava/lang/String;)V
      //   1173: iconst_1
      //   1174: invokestatic 410	com/kochava/android/tracker/Feature:access$1402	(Z)Z
      //   1177: pop
      //   1178: aload 14
      //   1180: ldc 100
      //   1182: invokevirtual 329	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
      //   1185: ifnull +92 -> 1277
      //   1188: aload 14
      //   1190: ldc 100
      //   1192: invokevirtual 329	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
      //   1195: invokevirtual 229	java/lang/Object:getClass	()Ljava/lang/Class;
      //   1198: ldc_w 283
      //   1201: invokevirtual 332	java/lang/Object:equals	(Ljava/lang/Object;)Z
      //   1204: ifeq +73 -> 1277
      //   1207: aload 14
      //   1209: ldc 100
      //   1211: invokevirtual 329	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
      //   1214: checkcast 283	java/lang/Integer
      //   1217: invokevirtual 298	java/lang/Integer:intValue	()I
      //   1220: istore_1
      //   1221: iload_1
      //   1222: ifge +765 -> 1987
      //   1225: new 85	java/lang/StringBuilder
      //   1228: dup
      //   1229: invokespecial 86	java/lang/StringBuilder:<init>	()V
      //   1232: ldc_w 412
      //   1235: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1238: iload_1
      //   1239: invokevirtual 396	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   1242: ldc_w 414
      //   1245: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1248: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1251: invokestatic 38	com/kochava/android/util/Logging:Log	(Ljava/lang/String;)V
      //   1254: invokestatic 53	com/kochava/android/tracker/Feature:access$400	()Landroid/content/SharedPreferences;
      //   1257: invokeinterface 371 1 0
      //   1262: ldc 100
      //   1264: ldc2_w 101
      //   1267: invokeinterface 418 4 0
      //   1272: invokeinterface 382 1 0
      //   1277: aload 14
      //   1279: ldc_w 420
      //   1282: invokevirtual 329	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
      //   1285: ifnull +77 -> 1362
      //   1288: aload 14
      //   1290: ldc_w 420
      //   1293: invokevirtual 329	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
      //   1296: invokevirtual 229	java/lang/Object:getClass	()Ljava/lang/Class;
      //   1299: ldc_w 283
      //   1302: invokevirtual 332	java/lang/Object:equals	(Ljava/lang/Object;)Z
      //   1305: ifeq +57 -> 1362
      //   1308: aload 14
      //   1310: ldc_w 420
      //   1313: invokevirtual 329	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
      //   1316: checkcast 283	java/lang/Integer
      //   1319: invokevirtual 298	java/lang/Integer:intValue	()I
      //   1322: istore_1
      //   1323: iload_1
      //   1324: iconst_1
      //   1325: if_icmpge +782 -> 2107
      //   1328: new 85	java/lang/StringBuilder
      //   1331: dup
      //   1332: invokespecial 86	java/lang/StringBuilder:<init>	()V
      //   1335: ldc_w 422
      //   1338: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1341: iload_1
      //   1342: invokevirtual 396	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   1345: ldc_w 424
      //   1348: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1351: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1354: invokestatic 38	com/kochava/android/util/Logging:Log	(Ljava/lang/String;)V
      //   1357: iconst_1
      //   1358: invokestatic 427	com/kochava/android/tracker/Feature:access$1502	(I)I
      //   1361: pop
      //   1362: aload 14
      //   1364: ldc_w 429
      //   1367: invokevirtual 329	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
      //   1370: checkcast 283	java/lang/Integer
      //   1373: invokevirtual 298	java/lang/Integer:intValue	()I
      //   1376: istore_2
      //   1377: iload_2
      //   1378: bipush 10
      //   1380: if_icmpge +808 -> 2188
      //   1383: new 85	java/lang/StringBuilder
      //   1386: dup
      //   1387: invokespecial 86	java/lang/StringBuilder:<init>	()V
      //   1390: ldc_w 431
      //   1393: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1396: iload_2
      //   1397: invokevirtual 396	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   1400: ldc_w 433
      //   1403: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1406: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1409: invokestatic 38	com/kochava/android/util/Logging:Log	(Ljava/lang/String;)V
      //   1412: bipush 10
      //   1414: istore_1
      //   1415: new 85	java/lang/StringBuilder
      //   1418: dup
      //   1419: invokespecial 86	java/lang/StringBuilder:<init>	()V
      //   1422: ldc_w 435
      //   1425: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1428: iload_1
      //   1429: invokevirtual 396	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   1432: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1435: invokestatic 38	com/kochava/android/util/Logging:Log	(Ljava/lang/String;)V
      //   1438: iload_1
      //   1439: putstatic 441	com/kochava/android/tracker/LocationDirector:desiredAccuracy	I
      //   1442: aload 14
      //   1444: ldc_w 443
      //   1447: invokevirtual 329	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
      //   1450: checkcast 283	java/lang/Integer
      //   1453: invokevirtual 298	java/lang/Integer:intValue	()I
      //   1456: istore_2
      //   1457: iload_2
      //   1458: iconst_3
      //   1459: if_icmpge +774 -> 2233
      //   1462: new 85	java/lang/StringBuilder
      //   1465: dup
      //   1466: invokespecial 86	java/lang/StringBuilder:<init>	()V
      //   1469: ldc_w 445
      //   1472: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1475: iload_2
      //   1476: invokevirtual 396	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   1479: ldc_w 447
      //   1482: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1485: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1488: invokestatic 38	com/kochava/android/util/Logging:Log	(Ljava/lang/String;)V
      //   1491: iconst_3
      //   1492: istore_1
      //   1493: new 85	java/lang/StringBuilder
      //   1496: dup
      //   1497: invokespecial 86	java/lang/StringBuilder:<init>	()V
      //   1500: ldc_w 449
      //   1503: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1506: iload_1
      //   1507: invokevirtual 396	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   1510: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1513: invokestatic 38	com/kochava/android/util/Logging:Log	(Ljava/lang/String;)V
      //   1516: iload_1
      //   1517: putstatic 452	com/kochava/android/tracker/LocationDirector:timeout	I
      //   1520: aload 14
      //   1522: ldc_w 454
      //   1525: invokevirtual 329	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
      //   1528: checkcast 283	java/lang/Integer
      //   1531: invokevirtual 298	java/lang/Integer:intValue	()I
      //   1534: istore_2
      //   1535: iload_2
      //   1536: iconst_1
      //   1537: if_icmpge +739 -> 2276
      //   1540: new 85	java/lang/StringBuilder
      //   1543: dup
      //   1544: invokespecial 86	java/lang/StringBuilder:<init>	()V
      //   1547: ldc_w 456
      //   1550: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1553: iload_2
      //   1554: invokevirtual 396	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   1557: ldc_w 458
      //   1560: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1563: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1566: invokestatic 38	com/kochava/android/util/Logging:Log	(Ljava/lang/String;)V
      //   1569: iconst_1
      //   1570: istore_1
      //   1571: new 85	java/lang/StringBuilder
      //   1574: dup
      //   1575: invokespecial 86	java/lang/StringBuilder:<init>	()V
      //   1578: ldc_w 460
      //   1581: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1584: iload_1
      //   1585: invokevirtual 396	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   1588: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1591: invokestatic 38	com/kochava/android/util/Logging:Log	(Ljava/lang/String;)V
      //   1594: iload_1
      //   1595: putstatic 463	com/kochava/android/tracker/LocationDirector:staleness	I
      //   1598: aload 13
      //   1600: ldc_w 465
      //   1603: invokevirtual 264	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
      //   1606: astore 15
      //   1608: new 85	java/lang/StringBuilder
      //   1611: dup
      //   1612: invokespecial 86	java/lang/StringBuilder:<init>	()V
      //   1615: ldc_w 467
      //   1618: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1621: aload 15
      //   1623: invokevirtual 468	org/json/JSONArray:toString	()Ljava/lang/String;
      //   1626: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1629: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1632: invokestatic 38	com/kochava/android/util/Logging:Log	(Ljava/lang/String;)V
      //   1635: iconst_0
      //   1636: istore_1
      //   1637: iload_1
      //   1638: aload 15
      //   1640: invokevirtual 270	org/json/JSONArray:length	()I
      //   1643: if_icmpge +741 -> 2384
      //   1646: aload 15
      //   1648: iload_1
      //   1649: invokevirtual 471	org/json/JSONArray:get	(I)Ljava/lang/Object;
      //   1652: invokevirtual 472	java/lang/Object:toString	()Ljava/lang/String;
      //   1655: invokevirtual 475	java/lang/String:toLowerCase	()Ljava/lang/String;
      //   1658: ldc_w 477
      //   1661: invokevirtual 83	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   1664: ifeq +657 -> 2321
      //   1667: ldc_w 479
      //   1670: invokestatic 38	com/kochava/android/util/Logging:Log	(Ljava/lang/String;)V
      //   1673: invokestatic 482	com/kochava/android/tracker/Feature:access$1600	()Ljava/util/HashMap;
      //   1676: ldc_w 477
      //   1679: iconst_0
      //   1680: invokestatic 487	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
      //   1683: invokevirtual 491	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   1686: pop
      //   1687: iload_1
      //   1688: iconst_1
      //   1689: iadd
      //   1690: istore_1
      //   1691: goto -54 -> 1637
      //   1694: astore 14
      //   1696: new 85	java/lang/StringBuilder
      //   1699: dup
      //   1700: invokespecial 86	java/lang/StringBuilder:<init>	()V
      //   1703: ldc_w 493
      //   1706: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1709: aload 14
      //   1711: invokevirtual 494	org/json/JSONException:toString	()Ljava/lang/String;
      //   1714: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1717: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1720: invokestatic 38	com/kochava/android/util/Logging:Log	(Ljava/lang/String;)V
      //   1723: goto -1120 -> 603
      //   1726: iload 4
      //   1728: iconst_1
      //   1729: iadd
      //   1730: istore 4
      //   1732: goto -1078 -> 654
      //   1735: astore 14
      //   1737: iconst_0
      //   1738: istore_2
      //   1739: goto -977 -> 762
      //   1742: astore 15
      //   1744: ldc_w 496
      //   1747: invokestatic 38	com/kochava/android/util/Logging:Log	(Ljava/lang/String;)V
      //   1750: goto -904 -> 846
      //   1753: astore 13
      //   1755: aload 13
      //   1757: invokevirtual 229	java/lang/Object:getClass	()Ljava/lang/Class;
      //   1760: ldc -31
      //   1762: invokevirtual 332	java/lang/Object:equals	(Ljava/lang/Object;)Z
      //   1765: ifeq +1529 -> 3294
      //   1768: new 85	java/lang/StringBuilder
      //   1771: dup
      //   1772: invokespecial 86	java/lang/StringBuilder:<init>	()V
      //   1775: ldc -19
      //   1777: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1780: aload 13
      //   1782: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   1785: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1788: invokestatic 243	com/kochava/android/util/Logging:LogError	(Ljava/lang/String;)V
      //   1791: aload 13
      //   1793: invokestatic 247	com/kochava/android/tracker/Feature:access$2400	(Ljava/lang/Exception;)V
      //   1796: return
      //   1797: astore 13
      //   1799: goto -1314 -> 485
      //   1802: astore 15
      //   1804: ldc_w 498
      //   1807: invokestatic 243	com/kochava/android/util/Logging:LogError	(Ljava/lang/String;)V
      //   1810: goto -916 -> 894
      //   1813: astore 15
      //   1815: ldc_w 496
      //   1818: invokestatic 243	com/kochava/android/util/Logging:LogError	(Ljava/lang/String;)V
      //   1821: goto -905 -> 916
      //   1824: invokestatic 391	com/kochava/android/tracker/Feature:access$1100	()I
      //   1827: bipush 120
      //   1829: if_icmple +43 -> 1872
      //   1832: new 85	java/lang/StringBuilder
      //   1835: dup
      //   1836: invokespecial 86	java/lang/StringBuilder:<init>	()V
      //   1839: ldc_w 500
      //   1842: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1845: invokestatic 391	com/kochava/android/tracker/Feature:access$1100	()I
      //   1848: invokevirtual 396	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   1851: ldc_w 502
      //   1854: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1857: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1860: invokestatic 38	com/kochava/android/util/Logging:Log	(Ljava/lang/String;)V
      //   1863: bipush 120
      //   1865: invokestatic 388	com/kochava/android/tracker/Feature:access$1102	(I)I
      //   1868: pop
      //   1869: goto -783 -> 1086
      //   1872: new 85	java/lang/StringBuilder
      //   1875: dup
      //   1876: invokespecial 86	java/lang/StringBuilder:<init>	()V
      //   1879: ldc_w 504
      //   1882: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1885: invokestatic 391	com/kochava/android/tracker/Feature:access$1100	()I
      //   1888: invokevirtual 396	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   1891: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1894: invokestatic 38	com/kochava/android/util/Logging:Log	(Ljava/lang/String;)V
      //   1897: goto -811 -> 1086
      //   1900: iload_1
      //   1901: ldc_w 505
      //   1904: if_icmple +42 -> 1946
      //   1907: new 85	java/lang/StringBuilder
      //   1910: dup
      //   1911: invokespecial 86	java/lang/StringBuilder:<init>	()V
      //   1914: ldc_w 507
      //   1917: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1920: iload_1
      //   1921: invokevirtual 396	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   1924: ldc_w 509
      //   1927: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1930: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1933: invokestatic 38	com/kochava/android/util/Logging:Log	(Ljava/lang/String;)V
      //   1936: ldc_w 510
      //   1939: invokestatic 513	com/kochava/android/tracker/Feature:access$1302	(I)I
      //   1942: pop
      //   1943: goto -770 -> 1173
      //   1946: iload_1
      //   1947: sipush 1000
      //   1950: imul
      //   1951: invokestatic 513	com/kochava/android/tracker/Feature:access$1302	(I)I
      //   1954: pop
      //   1955: new 85	java/lang/StringBuilder
      //   1958: dup
      //   1959: invokespecial 86	java/lang/StringBuilder:<init>	()V
      //   1962: ldc_w 515
      //   1965: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1968: iload_1
      //   1969: invokevirtual 396	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   1972: ldc_w 517
      //   1975: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1978: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1981: invokestatic 38	com/kochava/android/util/Logging:Log	(Ljava/lang/String;)V
      //   1984: goto -811 -> 1173
      //   1987: iload_1
      //   1988: ldc_w 505
      //   1991: if_icmple +58 -> 2049
      //   1994: new 85	java/lang/StringBuilder
      //   1997: dup
      //   1998: invokespecial 86	java/lang/StringBuilder:<init>	()V
      //   2001: ldc_w 412
      //   2004: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2007: iload_1
      //   2008: invokevirtual 396	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   2011: ldc_w 519
      //   2014: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2017: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   2020: invokestatic 38	com/kochava/android/util/Logging:Log	(Ljava/lang/String;)V
      //   2023: invokestatic 53	com/kochava/android/tracker/Feature:access$400	()Landroid/content/SharedPreferences;
      //   2026: invokeinterface 371 1 0
      //   2031: ldc 100
      //   2033: ldc2_w 520
      //   2036: invokeinterface 418 4 0
      //   2041: invokeinterface 382 1 0
      //   2046: goto -769 -> 1277
      //   2049: invokestatic 53	com/kochava/android/tracker/Feature:access$400	()Landroid/content/SharedPreferences;
      //   2052: invokeinterface 371 1 0
      //   2057: ldc 100
      //   2059: iload_1
      //   2060: sipush 1000
      //   2063: imul
      //   2064: i2l
      //   2065: invokeinterface 418 4 0
      //   2070: invokeinterface 382 1 0
      //   2075: new 85	java/lang/StringBuilder
      //   2078: dup
      //   2079: invokespecial 86	java/lang/StringBuilder:<init>	()V
      //   2082: ldc_w 523
      //   2085: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2088: iload_1
      //   2089: invokevirtual 396	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   2092: ldc_w 517
      //   2095: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2098: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   2101: invokestatic 38	com/kochava/android/util/Logging:Log	(Ljava/lang/String;)V
      //   2104: goto -827 -> 1277
      //   2107: iload_1
      //   2108: bipush 30
      //   2110: if_icmple +41 -> 2151
      //   2113: new 85	java/lang/StringBuilder
      //   2116: dup
      //   2117: invokespecial 86	java/lang/StringBuilder:<init>	()V
      //   2120: ldc_w 422
      //   2123: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2126: iload_1
      //   2127: invokevirtual 396	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   2130: ldc_w 525
      //   2133: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2136: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   2139: invokestatic 38	com/kochava/android/util/Logging:Log	(Ljava/lang/String;)V
      //   2142: bipush 30
      //   2144: invokestatic 427	com/kochava/android/tracker/Feature:access$1502	(I)I
      //   2147: pop
      //   2148: goto -786 -> 1362
      //   2151: new 85	java/lang/StringBuilder
      //   2154: dup
      //   2155: invokespecial 86	java/lang/StringBuilder:<init>	()V
      //   2158: ldc_w 527
      //   2161: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2164: iload_1
      //   2165: invokevirtual 396	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   2168: ldc_w 517
      //   2171: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2174: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   2177: invokestatic 38	com/kochava/android/util/Logging:Log	(Ljava/lang/String;)V
      //   2180: iload_1
      //   2181: invokestatic 427	com/kochava/android/tracker/Feature:access$1502	(I)I
      //   2184: pop
      //   2185: goto -823 -> 1362
      //   2188: iload_2
      //   2189: istore_1
      //   2190: iload_2
      //   2191: sipush 5000
      //   2194: if_icmple -779 -> 1415
      //   2197: new 85	java/lang/StringBuilder
      //   2200: dup
      //   2201: invokespecial 86	java/lang/StringBuilder:<init>	()V
      //   2204: ldc_w 431
      //   2207: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2210: iload_2
      //   2211: invokevirtual 396	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   2214: ldc_w 433
      //   2217: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2220: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   2223: invokestatic 38	com/kochava/android/util/Logging:Log	(Ljava/lang/String;)V
      //   2226: sipush 5000
      //   2229: istore_1
      //   2230: goto -815 -> 1415
      //   2233: iload_2
      //   2234: istore_1
      //   2235: iload_2
      //   2236: bipush 60
      //   2238: if_icmple -745 -> 1493
      //   2241: new 85	java/lang/StringBuilder
      //   2244: dup
      //   2245: invokespecial 86	java/lang/StringBuilder:<init>	()V
      //   2248: ldc_w 445
      //   2251: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2254: iload_2
      //   2255: invokevirtual 396	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   2258: ldc_w 447
      //   2261: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2264: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   2267: invokestatic 38	com/kochava/android/util/Logging:Log	(Ljava/lang/String;)V
      //   2270: bipush 60
      //   2272: istore_1
      //   2273: goto -780 -> 1493
      //   2276: iload_2
      //   2277: istore_1
      //   2278: iload_2
      //   2279: sipush 10080
      //   2282: if_icmple -711 -> 1571
      //   2285: new 85	java/lang/StringBuilder
      //   2288: dup
      //   2289: invokespecial 86	java/lang/StringBuilder:<init>	()V
      //   2292: ldc_w 456
      //   2295: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2298: iload_2
      //   2299: invokevirtual 396	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   2302: ldc_w 458
      //   2305: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2308: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   2311: invokestatic 38	com/kochava/android/util/Logging:Log	(Ljava/lang/String;)V
      //   2314: sipush 10080
      //   2317: istore_1
      //   2318: goto -747 -> 1571
      //   2321: aload 15
      //   2323: iload_1
      //   2324: invokevirtual 471	org/json/JSONArray:get	(I)Ljava/lang/Object;
      //   2327: invokevirtual 472	java/lang/Object:toString	()Ljava/lang/String;
      //   2330: invokevirtual 475	java/lang/String:toLowerCase	()Ljava/lang/String;
      //   2333: ldc_w 529
      //   2336: invokevirtual 83	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   2339: ifeq +132 -> 2471
      //   2342: ldc_w 531
      //   2345: invokestatic 38	com/kochava/android/util/Logging:Log	(Ljava/lang/String;)V
      //   2348: invokestatic 482	com/kochava/android/tracker/Feature:access$1600	()Ljava/util/HashMap;
      //   2351: ldc_w 529
      //   2354: iconst_0
      //   2355: invokestatic 487	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
      //   2358: invokevirtual 491	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   2361: pop
      //   2362: goto -675 -> 1687
      //   2365: astore 15
      //   2367: ldc_w 533
      //   2370: invokestatic 38	com/kochava/android/util/Logging:Log	(Ljava/lang/String;)V
      //   2373: getstatic 539	com/kochava/android/tracker/Global:DEBUGERROR	Z
      //   2376: ifeq +8 -> 2384
      //   2379: aload 15
      //   2381: invokevirtual 542	java/lang/Exception:printStackTrace	()V
      //   2384: aload 13
      //   2386: ldc_w 544
      //   2389: invokevirtual 264	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
      //   2392: astore 15
      //   2394: new 85	java/lang/StringBuilder
      //   2397: dup
      //   2398: invokespecial 86	java/lang/StringBuilder:<init>	()V
      //   2401: ldc_w 546
      //   2404: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2407: aload 15
      //   2409: invokevirtual 468	org/json/JSONArray:toString	()Ljava/lang/String;
      //   2412: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2415: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   2418: invokestatic 38	com/kochava/android/util/Logging:Log	(Ljava/lang/String;)V
      //   2421: iconst_0
      //   2422: istore_1
      //   2423: iload_1
      //   2424: aload 15
      //   2426: invokevirtual 270	org/json/JSONArray:length	()I
      //   2429: if_icmpge +282 -> 2711
      //   2432: aload 15
      //   2434: iload_1
      //   2435: invokevirtual 471	org/json/JSONArray:get	(I)Ljava/lang/Object;
      //   2438: invokevirtual 472	java/lang/Object:toString	()Ljava/lang/String;
      //   2441: invokevirtual 475	java/lang/String:toLowerCase	()Ljava/lang/String;
      //   2444: ldc_w 548
      //   2447: invokevirtual 83	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   2450: ifeq +197 -> 2647
      //   2453: ldc_w 550
      //   2456: invokestatic 38	com/kochava/android/util/Logging:Log	(Ljava/lang/String;)V
      //   2459: iconst_1
      //   2460: invokestatic 553	com/kochava/android/tracker/Feature:access$1702	(Z)Z
      //   2463: pop
      //   2464: iload_1
      //   2465: iconst_1
      //   2466: iadd
      //   2467: istore_1
      //   2468: goto -45 -> 2423
      //   2471: aload 15
      //   2473: iload_1
      //   2474: invokevirtual 471	org/json/JSONArray:get	(I)Ljava/lang/Object;
      //   2477: invokevirtual 472	java/lang/Object:toString	()Ljava/lang/String;
      //   2480: invokevirtual 475	java/lang/String:toLowerCase	()Ljava/lang/String;
      //   2483: ldc_w 555
      //   2486: invokevirtual 83	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   2489: ifeq +26 -> 2515
      //   2492: ldc_w 557
      //   2495: invokestatic 38	com/kochava/android/util/Logging:Log	(Ljava/lang/String;)V
      //   2498: invokestatic 482	com/kochava/android/tracker/Feature:access$1600	()Ljava/util/HashMap;
      //   2501: ldc_w 555
      //   2504: iconst_0
      //   2505: invokestatic 487	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
      //   2508: invokevirtual 491	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   2511: pop
      //   2512: goto -825 -> 1687
      //   2515: aload 15
      //   2517: iload_1
      //   2518: invokevirtual 471	org/json/JSONArray:get	(I)Ljava/lang/Object;
      //   2521: invokevirtual 472	java/lang/Object:toString	()Ljava/lang/String;
      //   2524: invokevirtual 475	java/lang/String:toLowerCase	()Ljava/lang/String;
      //   2527: ldc_w 559
      //   2530: invokevirtual 83	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   2533: ifeq +26 -> 2559
      //   2536: ldc_w 561
      //   2539: invokestatic 38	com/kochava/android/util/Logging:Log	(Ljava/lang/String;)V
      //   2542: invokestatic 482	com/kochava/android/tracker/Feature:access$1600	()Ljava/util/HashMap;
      //   2545: ldc_w 559
      //   2548: iconst_0
      //   2549: invokestatic 487	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
      //   2552: invokevirtual 491	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   2555: pop
      //   2556: goto -869 -> 1687
      //   2559: aload 15
      //   2561: iload_1
      //   2562: invokevirtual 471	org/json/JSONArray:get	(I)Ljava/lang/Object;
      //   2565: invokevirtual 472	java/lang/Object:toString	()Ljava/lang/String;
      //   2568: invokevirtual 475	java/lang/String:toLowerCase	()Ljava/lang/String;
      //   2571: ldc_w 563
      //   2574: invokevirtual 83	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   2577: ifeq +26 -> 2603
      //   2580: ldc_w 565
      //   2583: invokestatic 38	com/kochava/android/util/Logging:Log	(Ljava/lang/String;)V
      //   2586: invokestatic 482	com/kochava/android/tracker/Feature:access$1600	()Ljava/util/HashMap;
      //   2589: ldc_w 563
      //   2592: iconst_0
      //   2593: invokestatic 487	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
      //   2596: invokevirtual 491	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   2599: pop
      //   2600: goto -913 -> 1687
      //   2603: aload 15
      //   2605: iload_1
      //   2606: invokevirtual 471	org/json/JSONArray:get	(I)Ljava/lang/Object;
      //   2609: invokevirtual 472	java/lang/Object:toString	()Ljava/lang/String;
      //   2612: invokevirtual 475	java/lang/String:toLowerCase	()Ljava/lang/String;
      //   2615: ldc_w 567
      //   2618: invokevirtual 83	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   2621: ifeq -934 -> 1687
      //   2624: ldc_w 569
      //   2627: invokestatic 38	com/kochava/android/util/Logging:Log	(Ljava/lang/String;)V
      //   2630: invokestatic 482	com/kochava/android/tracker/Feature:access$1600	()Ljava/util/HashMap;
      //   2633: ldc_w 567
      //   2636: iconst_0
      //   2637: invokestatic 487	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
      //   2640: invokevirtual 491	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   2643: pop
      //   2644: goto -957 -> 1687
      //   2647: aload 15
      //   2649: iload_1
      //   2650: invokevirtual 471	org/json/JSONArray:get	(I)Ljava/lang/Object;
      //   2653: invokevirtual 472	java/lang/Object:toString	()Ljava/lang/String;
      //   2656: invokevirtual 475	java/lang/String:toLowerCase	()Ljava/lang/String;
      //   2659: ldc_w 571
      //   2662: invokevirtual 83	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   2665: ifeq -201 -> 2464
      //   2668: ldc_w 573
      //   2671: invokestatic 38	com/kochava/android/util/Logging:Log	(Ljava/lang/String;)V
      //   2674: iconst_1
      //   2675: invokestatic 576	com/kochava/android/tracker/Feature:access$1802	(Z)Z
      //   2678: pop
      //   2679: goto -215 -> 2464
      //   2682: astore 15
      //   2684: new 85	java/lang/StringBuilder
      //   2687: dup
      //   2688: invokespecial 86	java/lang/StringBuilder:<init>	()V
      //   2691: ldc_w 578
      //   2694: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2697: aload 15
      //   2699: invokevirtual 250	java/lang/Exception:toString	()Ljava/lang/String;
      //   2702: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2705: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   2708: invokestatic 243	com/kochava/android/util/Logging:LogError	(Ljava/lang/String;)V
      //   2711: aload 13
      //   2713: ldc_w 580
      //   2716: invokevirtual 312	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
      //   2719: ldc_w 582
      //   2722: invokevirtual 312	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
      //   2725: astore 15
      //   2727: aload_0
      //   2728: getfield 14	com/kochava/android/tracker/Feature$6:this$0	Lcom/kochava/android/tracker/Feature;
      //   2731: aload 15
      //   2733: invokestatic 586	com/kochava/android/tracker/Feature:access$1900	(Lcom/kochava/android/tracker/Feature;Lorg/json/JSONObject;)V
      //   2736: invokestatic 589	com/kochava/android/tracker/Feature:access$1800	()Z
      //   2739: ifeq +18 -> 2757
      //   2742: invokestatic 592	com/kochava/android/tracker/Feature:access$2000	()Z
      //   2745: ifeq +12 -> 2757
      //   2748: getstatic 355	com/kochava/android/tracker/Feature:appContext	Landroid/content/Context;
      //   2751: invokestatic 596	com/kochava/android/tracker/LocationDirector:getInstance	(Landroid/content/Context;)Lcom/kochava/android/tracker/LocationDirector;
      //   2754: invokevirtual 599	com/kochava/android/tracker/LocationDirector:getLocation	()V
      //   2757: aload 13
      //   2759: ldc_w 601
      //   2762: invokevirtual 264	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
      //   2765: invokestatic 605	com/kochava/android/tracker/Feature:access$2102	(Lorg/json/JSONArray;)Lorg/json/JSONArray;
      //   2768: pop
      //   2769: new 85	java/lang/StringBuilder
      //   2772: dup
      //   2773: invokespecial 86	java/lang/StringBuilder:<init>	()V
      //   2776: ldc_w 607
      //   2779: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2782: invokestatic 611	com/kochava/android/tracker/Feature:access$2100	()Lorg/json/JSONArray;
      //   2785: invokevirtual 468	org/json/JSONArray:toString	()Ljava/lang/String;
      //   2788: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2791: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   2794: invokestatic 38	com/kochava/android/util/Logging:Log	(Ljava/lang/String;)V
      //   2797: invokestatic 53	com/kochava/android/tracker/Feature:access$400	()Landroid/content/SharedPreferences;
      //   2800: invokeinterface 371 1 0
      //   2805: ldc_w 613
      //   2808: invokestatic 611	com/kochava/android/tracker/Feature:access$2100	()Lorg/json/JSONArray;
      //   2811: invokevirtual 468	org/json/JSONArray:toString	()Ljava/lang/String;
      //   2814: invokeinterface 379 3 0
      //   2819: invokeinterface 382 1 0
      //   2824: aload 14
      //   2826: ldc_w 615
      //   2829: invokevirtual 329	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
      //   2832: ifnull +88 -> 2920
      //   2835: aload 14
      //   2837: ldc_w 615
      //   2840: invokevirtual 329	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
      //   2843: invokevirtual 229	java/lang/Object:getClass	()Ljava/lang/Class;
      //   2846: ldc_w 484
      //   2849: invokevirtual 332	java/lang/Object:equals	(Ljava/lang/Object;)Z
      //   2852: ifeq +432 -> 3284
      //   2855: aload 14
      //   2857: ldc_w 615
      //   2860: invokevirtual 329	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
      //   2863: checkcast 484	java/lang/Boolean
      //   2866: invokevirtual 618	java/lang/Boolean:booleanValue	()Z
      //   2869: ifeq +415 -> 3284
      //   2872: iconst_1
      //   2873: istore_1
      //   2874: aload 14
      //   2876: ldc_w 615
      //   2879: invokevirtual 329	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
      //   2882: invokevirtual 229	java/lang/Object:getClass	()Ljava/lang/Class;
      //   2885: ldc 79
      //   2887: invokevirtual 332	java/lang/Object:equals	(Ljava/lang/Object;)Z
      //   2890: ifeq +399 -> 3289
      //   2893: ldc_w 258
      //   2896: aload 14
      //   2898: ldc_w 615
      //   2901: invokevirtual 329	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
      //   2904: invokevirtual 83	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   2907: ifeq +382 -> 3289
      //   2910: iconst_1
      //   2911: istore_2
      //   2912: goto +744 -> 3656
      //   2915: iconst_1
      //   2916: invokestatic 621	com/kochava/android/tracker/Feature:access$2202	(Z)Z
      //   2919: pop
      //   2920: aload 13
      //   2922: ldc_w 623
      //   2925: invokevirtual 318	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
      //   2928: astore 13
      //   2930: new 85	java/lang/StringBuilder
      //   2933: dup
      //   2934: invokespecial 86	java/lang/StringBuilder:<init>	()V
      //   2937: ldc_w 625
      //   2940: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2943: aload 13
      //   2945: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2948: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   2951: invokestatic 243	com/kochava/android/util/Logging:LogError	(Ljava/lang/String;)V
      //   2954: aload 13
      //   2956: ldc_w 627
      //   2959: invokevirtual 83	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   2962: ifeq +17 -> 2979
      //   2965: iconst_1
      //   2966: invokestatic 630	com/kochava/android/tracker/Feature:access$2302	(Z)Z
      //   2969: pop
      //   2970: return
      //   2971: astore 13
      //   2973: ldc_w 632
      //   2976: invokestatic 38	com/kochava/android/util/Logging:Log	(Ljava/lang/String;)V
      //   2979: invokestatic 53	com/kochava/android/tracker/Feature:access$400	()Landroid/content/SharedPreferences;
      //   2982: invokeinterface 371 1 0
      //   2987: ldc 55
      //   2989: invokestatic 49	java/lang/System:currentTimeMillis	()J
      //   2992: invokeinterface 418 4 0
      //   2997: invokeinterface 382 1 0
      //   3002: ldc_w 634
      //   3005: invokestatic 38	com/kochava/android/util/Logging:Log	(Ljava/lang/String;)V
      //   3008: iconst_0
      //   3009: istore_1
      //   3010: invokestatic 53	com/kochava/android/tracker/Feature:access$400	()Landroid/content/SharedPreferences;
      //   3013: ldc_w 256
      //   3016: ldc 69
      //   3018: invokeinterface 73 3 0
      //   3023: ldc_w 258
      //   3026: invokevirtual 83	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   3029: ifne +548 -> 3577
      //   3032: invokestatic 482	com/kochava/android/tracker/Feature:access$1600	()Ljava/util/HashMap;
      //   3035: ldc_w 555
      //   3038: invokevirtual 293	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
      //   3041: checkcast 484	java/lang/Boolean
      //   3044: invokevirtual 618	java/lang/Boolean:booleanValue	()Z
      //   3047: ifne +363 -> 3410
      //   3050: iconst_1
      //   3051: istore_2
      //   3052: invokestatic 637	com/kochava/android/tracker/Feature:access$2500	()Z
      //   3055: istore 12
      //   3057: iload_1
      //   3058: invokestatic 391	com/kochava/android/tracker/Feature:access$1100	()I
      //   3061: if_icmpge +50 -> 3111
      //   3064: invokestatic 53	com/kochava/android/tracker/Feature:access$400	()Landroid/content/SharedPreferences;
      //   3067: ldc_w 639
      //   3070: ldc_w 641
      //   3073: invokeinterface 73 3 0
      //   3078: ldc_w 641
      //   3081: invokevirtual 83	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   3084: ifne +331 -> 3415
      //   3087: iconst_1
      //   3088: istore_3
      //   3089: invokestatic 644	com/kochava/android/tracker/Feature:access$100	()Ljava/lang/String;
      //   3092: ifnull +328 -> 3420
      //   3095: iconst_1
      //   3096: istore 4
      //   3098: iload_3
      //   3099: ifeq +327 -> 3426
      //   3102: iload_2
      //   3103: ifne +8 -> 3111
      //   3106: iload 12
      //   3108: ifeq +318 -> 3426
      //   3111: new 85	java/lang/StringBuilder
      //   3114: dup
      //   3115: invokespecial 86	java/lang/StringBuilder:<init>	()V
      //   3118: ldc_w 646
      //   3121: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   3124: iload_1
      //   3125: invokevirtual 396	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   3128: ldc_w 517
      //   3131: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   3134: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   3137: invokestatic 38	com/kochava/android/util/Logging:Log	(Ljava/lang/String;)V
      //   3140: iload_1
      //   3141: istore_2
      //   3142: iload_1
      //   3143: iconst_2
      //   3144: if_icmpge +46 -> 3190
      //   3147: aload_0
      //   3148: getfield 14	com/kochava/android/tracker/Feature$6:this$0	Lcom/kochava/android/tracker/Feature;
      //   3151: invokestatic 649	com/kochava/android/tracker/Feature:access$000	(Lcom/kochava/android/tracker/Feature;)Ljava/lang/String;
      //   3154: ifnull +323 -> 3477
      //   3157: iconst_1
      //   3158: istore_3
      //   3159: invokestatic 644	com/kochava/android/tracker/Feature:access$100	()Ljava/lang/String;
      //   3162: ifnull +320 -> 3482
      //   3165: invokestatic 644	com/kochava/android/tracker/Feature:access$100	()Ljava/lang/String;
      //   3168: invokevirtual 121	java/lang/String:isEmpty	()Z
      //   3171: ifne +311 -> 3482
      //   3174: iconst_1
      //   3175: istore 4
      //   3177: iload_1
      //   3178: istore_2
      //   3179: iload 4
      //   3181: ifne +9 -> 3190
      //   3184: iload_3
      //   3185: ifeq +303 -> 3488
      //   3188: iload_1
      //   3189: istore_2
      //   3190: iload_2
      //   3191: iconst_2
      //   3192: if_icmpge +19 -> 3211
      //   3195: aload_0
      //   3196: getfield 14	com/kochava/android/tracker/Feature$6:this$0	Lcom/kochava/android/tracker/Feature;
      //   3199: invokestatic 652	com/kochava/android/tracker/Feature:access$300	(Lcom/kochava/android/tracker/Feature;)Ljava/lang/String;
      //   3202: ifnull +328 -> 3530
      //   3205: iconst_1
      //   3206: istore_1
      //   3207: iload_1
      //   3208: ifeq +327 -> 3535
      //   3211: invokestatic 658	android/os/Message:obtain	()Landroid/os/Message;
      //   3214: astore 13
      //   3216: new 660	android/os/Bundle
      //   3219: dup
      //   3220: invokespecial 661	android/os/Bundle:<init>	()V
      //   3223: astore 14
      //   3225: aload 14
      //   3227: ldc_w 663
      //   3230: invokestatic 666	com/kochava/android/tracker/Feature:access$2600	()Z
      //   3233: invokevirtual 670	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
      //   3236: aload 13
      //   3238: aload 14
      //   3240: invokevirtual 674	android/os/Message:setData	(Landroid/os/Bundle;)V
      //   3243: aload_0
      //   3244: getfield 14	com/kochava/android/tracker/Feature$6:this$0	Lcom/kochava/android/tracker/Feature;
      //   3247: invokestatic 678	com/kochava/android/tracker/Feature:access$2700	(Lcom/kochava/android/tracker/Feature;)Landroid/os/Handler;
      //   3250: ifnull -2724 -> 526
      //   3253: ldc_w 680
      //   3256: invokestatic 38	com/kochava/android/util/Logging:Log	(Ljava/lang/String;)V
      //   3259: aload_0
      //   3260: getfield 14	com/kochava/android/tracker/Feature$6:this$0	Lcom/kochava/android/tracker/Feature;
      //   3263: invokestatic 678	com/kochava/android/tracker/Feature:access$2700	(Lcom/kochava/android/tracker/Feature;)Landroid/os/Handler;
      //   3266: aload 13
      //   3268: invokevirtual 686	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
      //   3271: pop
      //   3272: return
      //   3273: astore 15
      //   3275: ldc_w 688
      //   3278: invokestatic 38	com/kochava/android/util/Logging:Log	(Ljava/lang/String;)V
      //   3281: goto -457 -> 2824
      //   3284: iconst_0
      //   3285: istore_1
      //   3286: goto -412 -> 2874
      //   3289: iconst_0
      //   3290: istore_2
      //   3291: goto +365 -> 3656
      //   3294: new 85	java/lang/StringBuilder
      //   3297: dup
      //   3298: invokespecial 86	java/lang/StringBuilder:<init>	()V
      //   3301: ldc_w 690
      //   3304: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   3307: aload 13
      //   3309: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   3312: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   3315: invokestatic 243	com/kochava/android/util/Logging:LogError	(Ljava/lang/String;)V
      //   3318: return
      //   3319: astore 13
      //   3321: new 85	java/lang/StringBuilder
      //   3324: dup
      //   3325: invokespecial 86	java/lang/StringBuilder:<init>	()V
      //   3328: ldc_w 692
      //   3331: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   3334: aload 13
      //   3336: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   3339: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   3342: invokestatic 243	com/kochava/android/util/Logging:LogError	(Ljava/lang/String;)V
      //   3345: goto -366 -> 2979
      //   3348: new 85	java/lang/StringBuilder
      //   3351: dup
      //   3352: invokespecial 86	java/lang/StringBuilder:<init>	()V
      //   3355: ldc_w 690
      //   3358: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   3361: aload 13
      //   3363: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   3366: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   3369: invokestatic 243	com/kochava/android/util/Logging:LogError	(Ljava/lang/String;)V
      //   3372: return
      //   3373: new 85	java/lang/StringBuilder
      //   3376: dup
      //   3377: invokespecial 86	java/lang/StringBuilder:<init>	()V
      //   3380: ldc_w 694
      //   3383: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   3386: lload 6
      //   3388: ldc2_w 695
      //   3391: ldiv
      //   3392: invokevirtual 699	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   3395: ldc_w 701
      //   3398: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   3401: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   3404: invokestatic 38	com/kochava/android/util/Logging:Log	(Ljava/lang/String;)V
      //   3407: goto -405 -> 3002
      //   3410: iconst_0
      //   3411: istore_2
      //   3412: goto -360 -> 3052
      //   3415: iconst_0
      //   3416: istore_3
      //   3417: goto -328 -> 3089
      //   3420: iconst_0
      //   3421: istore 4
      //   3423: goto -325 -> 3098
      //   3426: iload_3
      //   3427: ifeq +8 -> 3435
      //   3430: iload 4
      //   3432: ifne -321 -> 3111
      //   3435: ldc2_w 695
      //   3438: invokestatic 304	java/lang/Thread:sleep	(J)V
      //   3441: iload_1
      //   3442: iconst_1
      //   3443: iadd
      //   3444: istore_1
      //   3445: goto -388 -> 3057
      //   3448: astore 13
      //   3450: new 85	java/lang/StringBuilder
      //   3453: dup
      //   3454: invokespecial 86	java/lang/StringBuilder:<init>	()V
      //   3457: ldc_w 703
      //   3460: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   3463: aload 13
      //   3465: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   3468: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   3471: invokestatic 243	com/kochava/android/util/Logging:LogError	(Ljava/lang/String;)V
      //   3474: goto -33 -> 3441
      //   3477: iconst_0
      //   3478: istore_3
      //   3479: goto -320 -> 3159
      //   3482: iconst_0
      //   3483: istore 4
      //   3485: goto -308 -> 3177
      //   3488: ldc2_w 695
      //   3491: invokestatic 304	java/lang/Thread:sleep	(J)V
      //   3494: iload_1
      //   3495: iconst_1
      //   3496: iadd
      //   3497: istore_1
      //   3498: goto -358 -> 3140
      //   3501: astore 13
      //   3503: new 85	java/lang/StringBuilder
      //   3506: dup
      //   3507: invokespecial 86	java/lang/StringBuilder:<init>	()V
      //   3510: ldc_w 703
      //   3513: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   3516: aload 13
      //   3518: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   3521: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   3524: invokestatic 243	com/kochava/android/util/Logging:LogError	(Ljava/lang/String;)V
      //   3527: goto -33 -> 3494
      //   3530: iconst_0
      //   3531: istore_1
      //   3532: goto -325 -> 3207
      //   3535: ldc2_w 695
      //   3538: invokestatic 304	java/lang/Thread:sleep	(J)V
      //   3541: iload_2
      //   3542: iconst_1
      //   3543: iadd
      //   3544: istore_2
      //   3545: goto -355 -> 3190
      //   3548: astore 13
      //   3550: new 85	java/lang/StringBuilder
      //   3553: dup
      //   3554: invokespecial 86	java/lang/StringBuilder:<init>	()V
      //   3557: ldc_w 703
      //   3560: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   3563: aload 13
      //   3565: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   3568: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   3571: invokestatic 243	com/kochava/android/util/Logging:LogError	(Ljava/lang/String;)V
      //   3574: goto -33 -> 3541
      //   3577: ldc_w 705
      //   3580: invokestatic 38	com/kochava/android/util/Logging:Log	(Ljava/lang/String;)V
      //   3583: goto -372 -> 3211
      //   3586: astore 13
      //   3588: goto -267 -> 3321
      //   3591: astore 14
      //   3593: goto -673 -> 2920
      //   3596: astore 15
      //   3598: goto -774 -> 2824
      //   3601: astore 15
      //   3603: goto -867 -> 2736
      //   3606: astore 15
      //   3608: goto -2010 -> 1598
      //   3611: astore 15
      //   3613: goto -2093 -> 1520
      //   3616: astore 15
      //   3618: goto -2176 -> 1442
      //   3621: astore 15
      //   3623: goto -2597 -> 1026
      //   3626: astore 15
      //   3628: goto -2663 -> 965
      //   3631: iload_2
      //   3632: istore_1
      //   3633: goto -3479 -> 154
      //   3636: astore 15
      //   3638: goto -2552 -> 1086
      //   3641: astore 15
      //   3643: goto -2465 -> 1178
      //   3646: astore 15
      //   3648: goto -2371 -> 1277
      //   3651: astore 15
      //   3653: goto -2291 -> 1362
      //   3656: iload_1
      //   3657: ifne -742 -> 2915
      //   3660: iload_2
      //   3661: ifeq -741 -> 2920
      //   3664: goto -749 -> 2915
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	3667	0	this	6
      //   43	3614	1	i	int
      //   14	3647	2	j	int
      //   12	3467	3	k	int
      //   652	2832	4	m	int
      //   649	8	5	n	int
      //   9	3378	6	l1	long
      //   18	18	8	l2	long
      //   33	5	10	l3	long
      //   622	2485	12	bool	boolean
      //   150	1	13	localObject1	Object
      //   483	39	13	localIOException1	IOException
      //   527	15	13	localException1	Exception
      //   601	998	13	localObject2	Object
      //   1753	39	13	localException2	Exception
      //   1797	1124	13	localIOException2	IOException
      //   2928	27	13	str	String
      //   2971	1	13	localException3	Exception
      //   3214	94	13	localMessage	Message
      //   3319	43	13	localException4	Exception
      //   3448	16	13	localInterruptedException1	InterruptedException
      //   3501	16	13	localInterruptedException2	InterruptedException
      //   3548	16	13	localInterruptedException3	InterruptedException
      //   3586	1	13	localException5	Exception
      //   287	1234	14	localObject3	Object
      //   1694	16	14	localJSONException1	JSONException
      //   1735	1162	14	localJSONException2	JSONException
      //   3223	16	14	localBundle	Bundle
      //   3591	1	14	localException6	Exception
      //   367	1280	15	localObject4	Object
      //   1742	1	15	localJSONException3	JSONException
      //   1802	1	15	localJSONException4	JSONException
      //   1813	509	15	localJSONException5	JSONException
      //   2365	15	15	localException7	Exception
      //   2392	256	15	localJSONArray	JSONArray
      //   2682	16	15	localException8	Exception
      //   2725	7	15	localJSONObject	JSONObject
      //   3273	1	15	localException9	Exception
      //   3596	1	15	localJSONException6	JSONException
      //   3601	1	15	localException10	Exception
      //   3606	1	15	localException11	Exception
      //   3611	1	15	localException12	Exception
      //   3616	1	15	localException13	Exception
      //   3621	1	15	localException14	Exception
      //   3626	1	15	localException15	Exception
      //   3636	1	15	localException16	Exception
      //   3641	1	15	localException17	Exception
      //   3646	1	15	localException18	Exception
      //   3651	1	15	localException19	Exception
      //   409	66	16	localObject5	Object
      // Exception table:
      //   from	to	target	type
      //   154	203	483	java/io/IOException
      //   203	214	483	java/io/IOException
      //   214	460	483	java/io/IOException
      //   460	467	483	java/io/IOException
      //   472	480	483	java/io/IOException
      //   558	588	483	java/io/IOException
      //   588	599	483	java/io/IOException
      //   1696	1723	483	java/io/IOException
      //   15	35	527	java/lang/Exception
      //   588	599	1694	org/json/JSONException
      //   638	648	1735	org/json/JSONException
      //   659	685	1735	org/json/JSONException
      //   698	756	1735	org/json/JSONException
      //   801	811	1742	org/json/JSONException
      //   815	842	1742	org/json/JSONException
      //   771	798	1753	java/lang/Exception
      //   801	811	1753	java/lang/Exception
      //   815	842	1753	java/lang/Exception
      //   851	894	1753	java/lang/Exception
      //   894	916	1753	java/lang/Exception
      //   1744	1750	1753	java/lang/Exception
      //   1804	1810	1753	java/lang/Exception
      //   1815	1821	1753	java/lang/Exception
      //   2367	2384	1753	java/lang/Exception
      //   2684	2711	1753	java/lang/Exception
      //   2736	2757	1753	java/lang/Exception
      //   2973	2979	1753	java/lang/Exception
      //   3275	3281	1753	java/lang/Exception
      //   603	624	1797	java/io/IOException
      //   638	648	1797	java/io/IOException
      //   659	685	1797	java/io/IOException
      //   698	756	1797	java/io/IOException
      //   771	798	1797	java/io/IOException
      //   801	811	1797	java/io/IOException
      //   815	842	1797	java/io/IOException
      //   851	894	1797	java/io/IOException
      //   894	916	1797	java/io/IOException
      //   916	965	1797	java/io/IOException
      //   965	1026	1797	java/io/IOException
      //   1026	1086	1797	java/io/IOException
      //   1086	1138	1797	java/io/IOException
      //   1144	1173	1797	java/io/IOException
      //   1173	1178	1797	java/io/IOException
      //   1178	1221	1797	java/io/IOException
      //   1225	1277	1797	java/io/IOException
      //   1277	1323	1797	java/io/IOException
      //   1328	1362	1797	java/io/IOException
      //   1362	1377	1797	java/io/IOException
      //   1383	1412	1797	java/io/IOException
      //   1415	1442	1797	java/io/IOException
      //   1442	1457	1797	java/io/IOException
      //   1462	1491	1797	java/io/IOException
      //   1493	1520	1797	java/io/IOException
      //   1520	1535	1797	java/io/IOException
      //   1540	1569	1797	java/io/IOException
      //   1571	1598	1797	java/io/IOException
      //   1598	1635	1797	java/io/IOException
      //   1637	1687	1797	java/io/IOException
      //   1744	1750	1797	java/io/IOException
      //   1755	1796	1797	java/io/IOException
      //   1804	1810	1797	java/io/IOException
      //   1815	1821	1797	java/io/IOException
      //   1824	1869	1797	java/io/IOException
      //   1872	1897	1797	java/io/IOException
      //   1907	1943	1797	java/io/IOException
      //   1946	1984	1797	java/io/IOException
      //   1994	2046	1797	java/io/IOException
      //   2049	2104	1797	java/io/IOException
      //   2113	2148	1797	java/io/IOException
      //   2151	2185	1797	java/io/IOException
      //   2197	2226	1797	java/io/IOException
      //   2241	2270	1797	java/io/IOException
      //   2285	2314	1797	java/io/IOException
      //   2321	2362	1797	java/io/IOException
      //   2367	2384	1797	java/io/IOException
      //   2384	2421	1797	java/io/IOException
      //   2423	2464	1797	java/io/IOException
      //   2471	2512	1797	java/io/IOException
      //   2515	2556	1797	java/io/IOException
      //   2559	2600	1797	java/io/IOException
      //   2603	2644	1797	java/io/IOException
      //   2647	2679	1797	java/io/IOException
      //   2684	2711	1797	java/io/IOException
      //   2711	2736	1797	java/io/IOException
      //   2736	2757	1797	java/io/IOException
      //   2757	2824	1797	java/io/IOException
      //   2824	2872	1797	java/io/IOException
      //   2874	2910	1797	java/io/IOException
      //   2915	2920	1797	java/io/IOException
      //   2920	2970	1797	java/io/IOException
      //   2973	2979	1797	java/io/IOException
      //   3275	3281	1797	java/io/IOException
      //   3294	3318	1797	java/io/IOException
      //   851	894	1802	org/json/JSONException
      //   894	916	1813	org/json/JSONException
      //   1598	1635	2365	java/lang/Exception
      //   1637	1687	2365	java/lang/Exception
      //   2321	2362	2365	java/lang/Exception
      //   2471	2512	2365	java/lang/Exception
      //   2515	2556	2365	java/lang/Exception
      //   2559	2600	2365	java/lang/Exception
      //   2603	2644	2365	java/lang/Exception
      //   2384	2421	2682	java/lang/Exception
      //   2423	2464	2682	java/lang/Exception
      //   2647	2679	2682	java/lang/Exception
      //   2920	2970	2971	java/lang/Exception
      //   2757	2824	3273	java/lang/Exception
      //   603	624	3319	java/lang/Exception
      //   638	648	3319	java/lang/Exception
      //   659	685	3319	java/lang/Exception
      //   698	756	3319	java/lang/Exception
      //   1755	1796	3319	java/lang/Exception
      //   3294	3318	3319	java/lang/Exception
      //   3435	3441	3448	java/lang/InterruptedException
      //   3488	3494	3501	java/lang/InterruptedException
      //   3535	3541	3548	java/lang/InterruptedException
      //   154	203	3586	java/lang/Exception
      //   203	214	3586	java/lang/Exception
      //   214	460	3586	java/lang/Exception
      //   460	467	3586	java/lang/Exception
      //   472	480	3586	java/lang/Exception
      //   558	588	3586	java/lang/Exception
      //   588	599	3586	java/lang/Exception
      //   1696	1723	3586	java/lang/Exception
      //   2824	2872	3591	java/lang/Exception
      //   2874	2910	3591	java/lang/Exception
      //   2915	2920	3591	java/lang/Exception
      //   2757	2824	3596	org/json/JSONException
      //   2711	2736	3601	java/lang/Exception
      //   1520	1535	3606	java/lang/Exception
      //   1540	1569	3606	java/lang/Exception
      //   1571	1598	3606	java/lang/Exception
      //   2285	2314	3606	java/lang/Exception
      //   1442	1457	3611	java/lang/Exception
      //   1462	1491	3611	java/lang/Exception
      //   1493	1520	3611	java/lang/Exception
      //   2241	2270	3611	java/lang/Exception
      //   1362	1377	3616	java/lang/Exception
      //   1383	1412	3616	java/lang/Exception
      //   1415	1442	3616	java/lang/Exception
      //   2197	2226	3616	java/lang/Exception
      //   965	1026	3621	java/lang/Exception
      //   916	965	3626	java/lang/Exception
      //   1026	1086	3636	java/lang/Exception
      //   1824	1869	3636	java/lang/Exception
      //   1872	1897	3636	java/lang/Exception
      //   1086	1138	3641	java/lang/Exception
      //   1144	1173	3641	java/lang/Exception
      //   1173	1178	3641	java/lang/Exception
      //   1907	1943	3641	java/lang/Exception
      //   1946	1984	3641	java/lang/Exception
      //   1178	1221	3646	java/lang/Exception
      //   1225	1277	3646	java/lang/Exception
      //   1994	2046	3646	java/lang/Exception
      //   2049	2104	3646	java/lang/Exception
      //   1277	1323	3651	java/lang/Exception
      //   1328	1362	3651	java/lang/Exception
      //   2113	2148	3651	java/lang/Exception
      //   2151	2185	3651	java/lang/Exception
    }
  };
  private Handler initHandler = null;
  private Timer initTimer;
  private JSONObject initialObject;
  private JSONObject initialPropertiesObject;
  protected JSONObject kvinitdata;
  protected JSONObject kvinitdataholder;
  protected JSONObject kvinitorigdata;
  private String mAndroidID;
  private String mAppName;
  private String mAppPackageName;
  private String mAppVersionCode;
  private String mAppVersionName;
  private String mCarrier;
  private String mDeviceId;
  private int mDisplayHeight;
  private int mDisplayWidth;
  private String mFbId;
  private boolean mIsStartOfLife = true;
  private String mModel;
  private Timer mTimerSendOnBegin;
  
  static
  {
    overrideAutomaticSessions = false;
    flush_rate = 60000;
    flushTimerSetByInitializer = false;
    flushTimerSetByKVinitResponse = false;
    kvinitRetrySteps = new HashMap() {};
    get_attribution_wait = 7;
    referrerDelayFromInit = 60;
    device_limit_tracking = false;
    send_id_updates = false;
    suppress_adid = false;
    sendOnStart = true;
    doGatherLocation = false;
    lastCallTime = 0L;
    startTime = 0L;
    adid = "";
    installedApps = new ArrayList();
    should_flush_in_background = true;
    event_flush_triggered = false;
    is_in_background = false;
    lastEventTimestamp = 0L;
    badInit = false;
    canSendSession = true;
    sendEmails = false;
    requestAttributionData = false;
    executor = Executors.newFixedThreadPool(1);
    worker = Executors.newSingleThreadScheduledExecutor();
    ATTRIBUTION_ID_CONTENT_URI = Uri.parse("content://com.facebook.katana.provider.AttributionIdProvider");
    paramRestrictions = new HashMap() {};
    eventnameBlacklist = new JSONArray();
    sendKVQuery = new Runnable()
    {
      /* Error */
      public void run()
      {
        // Byte code:
        //   0: bipush 60
        //   2: istore_2
        //   3: iload_2
        //   4: istore_1
        //   5: invokestatic 26	com/kochava/android/tracker/Feature:access$600	()Ljava/lang/String;
        //   8: ifnull +17 -> 25
        //   11: iload_2
        //   12: istore_1
        //   13: invokestatic 26	com/kochava/android/tracker/Feature:access$600	()Ljava/lang/String;
        //   16: invokevirtual 31	java/lang/String:trim	()Ljava/lang/String;
        //   19: invokevirtual 35	java/lang/String:isEmpty	()Z
        //   22: ifeq +18 -> 40
        //   25: iload_2
        //   26: istore_1
        //   27: ldc 37
        //   29: invokestatic 43	com/kochava/android/util/Logging:Log	(Ljava/lang/String;)V
        //   32: iload_2
        //   33: istore_1
        //   34: ldc 45
        //   36: invokestatic 49	com/kochava/android/tracker/Feature:access$602	(Ljava/lang/String;)Ljava/lang/String;
        //   39: pop
        //   40: iload_2
        //   41: istore_1
        //   42: new 51	java/lang/StringBuilder
        //   45: dup
        //   46: invokespecial 52	java/lang/StringBuilder:<init>	()V
        //   49: ldc 54
        //   51: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   54: ldc 60
        //   56: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   59: invokestatic 26	com/kochava/android/tracker/Feature:access$600	()Ljava/lang/String;
        //   62: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   65: ldc 62
        //   67: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   70: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   73: invokestatic 43	com/kochava/android/util/Logging:Log	(Ljava/lang/String;)V
        //   76: iload_2
        //   77: istore_1
        //   78: new 67	java/net/URL
        //   81: dup
        //   82: new 51	java/lang/StringBuilder
        //   85: dup
        //   86: invokespecial 52	java/lang/StringBuilder:<init>	()V
        //   89: ldc 60
        //   91: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   94: invokestatic 26	com/kochava/android/tracker/Feature:access$600	()Ljava/lang/String;
        //   97: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   100: ldc 62
        //   102: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   105: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   108: invokespecial 69	java/net/URL:<init>	(Ljava/lang/String;)V
        //   111: invokevirtual 73	java/net/URL:openConnection	()Ljava/net/URLConnection;
        //   114: checkcast 75	javax/net/ssl/HttpsURLConnection
        //   117: astore 7
        //   119: iload_2
        //   120: istore_1
        //   121: aload 7
        //   123: ldc 77
        //   125: invokestatic 81	com/kochava/android/tracker/Feature:access$400	()Landroid/content/SharedPreferences;
        //   128: ldc 83
        //   130: ldc 85
        //   132: invokeinterface 91 3 0
        //   137: invokevirtual 95	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
        //   140: iload_2
        //   141: istore_1
        //   142: aload 7
        //   144: ldc 97
        //   146: ldc 99
        //   148: invokevirtual 95	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
        //   151: iload_2
        //   152: istore_1
        //   153: aload 7
        //   155: ldc 101
        //   157: invokevirtual 104	javax/net/ssl/HttpsURLConnection:setRequestMethod	(Ljava/lang/String;)V
        //   160: iload_2
        //   161: istore_1
        //   162: aload 7
        //   164: sipush 30000
        //   167: invokevirtual 108	javax/net/ssl/HttpsURLConnection:setConnectTimeout	(I)V
        //   170: iload_2
        //   171: istore_1
        //   172: aload 7
        //   174: sipush 30000
        //   177: invokevirtual 111	javax/net/ssl/HttpsURLConnection:setReadTimeout	(I)V
        //   180: iload_2
        //   181: istore_1
        //   182: aload 7
        //   184: iconst_1
        //   185: invokevirtual 115	javax/net/ssl/HttpsURLConnection:setDoInput	(Z)V
        //   188: iload_2
        //   189: istore_1
        //   190: aload 7
        //   192: iconst_1
        //   193: invokevirtual 118	javax/net/ssl/HttpsURLConnection:setDoOutput	(Z)V
        //   196: iload_2
        //   197: istore_1
        //   198: aload 7
        //   200: invokevirtual 121	javax/net/ssl/HttpsURLConnection:connect	()V
        //   203: iload_2
        //   204: istore_1
        //   205: new 123	org/json/JSONObject
        //   208: dup
        //   209: invokespecial 124	org/json/JSONObject:<init>	()V
        //   212: astore 8
        //   214: iload_2
        //   215: istore_1
        //   216: aload 8
        //   218: ldc 126
        //   220: ldc -128
        //   222: invokevirtual 132	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
        //   225: pop
        //   226: iload_2
        //   227: istore_1
        //   228: aload 8
        //   230: ldc -122
        //   232: invokestatic 137	com/kochava/android/tracker/Feature:access$800	()Ljava/lang/String;
        //   235: invokevirtual 132	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
        //   238: pop
        //   239: iload_2
        //   240: istore_1
        //   241: aload 8
        //   243: ldc -117
        //   245: invokestatic 142	com/kochava/android/tracker/Feature:access$2800	()Ljava/lang/String;
        //   248: invokevirtual 132	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
        //   251: pop
        //   252: iload_2
        //   253: istore_1
        //   254: aload 8
        //   256: ldc -112
        //   258: new 51	java/lang/StringBuilder
        //   261: dup
        //   262: invokespecial 52	java/lang/StringBuilder:<init>	()V
        //   265: ldc -110
        //   267: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   270: getstatic 150	com/kochava/android/tracker/Feature:versionExtension	Ljava/lang/String;
        //   273: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   276: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   279: invokevirtual 132	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
        //   282: pop
        //   283: iload_2
        //   284: istore_1
        //   285: aload 8
        //   287: ldc -104
        //   289: ldc -102
        //   291: invokevirtual 132	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
        //   294: pop
        //   295: iload_2
        //   296: istore_1
        //   297: aload 8
        //   299: invokevirtual 155	org/json/JSONObject:toString	()Ljava/lang/String;
        //   302: astore 8
        //   304: iload_2
        //   305: istore_1
        //   306: new 51	java/lang/StringBuilder
        //   309: dup
        //   310: invokespecial 52	java/lang/StringBuilder:<init>	()V
        //   313: ldc -99
        //   315: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   318: aload 8
        //   320: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   323: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   326: invokestatic 43	com/kochava/android/util/Logging:Log	(Ljava/lang/String;)V
        //   329: iload_2
        //   330: istore_1
        //   331: ldc -97
        //   333: invokestatic 43	com/kochava/android/util/Logging:Log	(Ljava/lang/String;)V
        //   336: iload_2
        //   337: istore_1
        //   338: new 161	java/io/OutputStreamWriter
        //   341: dup
        //   342: aload 7
        //   344: invokevirtual 165	javax/net/ssl/HttpsURLConnection:getOutputStream	()Ljava/io/OutputStream;
        //   347: invokespecial 168	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;)V
        //   350: astore 9
        //   352: iload_2
        //   353: istore_1
        //   354: aload 9
        //   356: aload 8
        //   358: invokevirtual 171	java/io/OutputStreamWriter:write	(Ljava/lang/String;)V
        //   361: iload_2
        //   362: istore_1
        //   363: aload 9
        //   365: invokevirtual 174	java/io/OutputStreamWriter:close	()V
        //   368: iload_2
        //   369: istore 4
        //   371: iload_2
        //   372: istore 6
        //   374: iload_2
        //   375: istore_1
        //   376: ldc -80
        //   378: invokestatic 43	com/kochava/android/util/Logging:Log	(Ljava/lang/String;)V
        //   381: iload_2
        //   382: istore 4
        //   384: iload_2
        //   385: istore 6
        //   387: iload_2
        //   388: istore_1
        //   389: new 178	java/lang/StringBuffer
        //   392: dup
        //   393: ldc 85
        //   395: invokespecial 179	java/lang/StringBuffer:<init>	(Ljava/lang/String;)V
        //   398: astore 8
        //   400: iload_2
        //   401: istore 4
        //   403: iload_2
        //   404: istore 6
        //   406: iload_2
        //   407: istore_1
        //   408: new 181	java/io/BufferedReader
        //   411: dup
        //   412: new 183	java/io/InputStreamReader
        //   415: dup
        //   416: aload 7
        //   418: invokevirtual 187	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
        //   421: invokespecial 190	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
        //   424: invokespecial 193	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
        //   427: astore 7
        //   429: iload_2
        //   430: istore 4
        //   432: iload_2
        //   433: istore 6
        //   435: iload_2
        //   436: istore_1
        //   437: aload 7
        //   439: invokevirtual 196	java/io/BufferedReader:readLine	()Ljava/lang/String;
        //   442: astore 9
        //   444: aload 9
        //   446: ifnull +75 -> 521
        //   449: iload_2
        //   450: istore 4
        //   452: iload_2
        //   453: istore 6
        //   455: iload_2
        //   456: istore_1
        //   457: aload 8
        //   459: aload 9
        //   461: invokevirtual 199	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
        //   464: pop
        //   465: goto -36 -> 429
        //   468: astore 7
        //   470: iload 4
        //   472: istore_1
        //   473: aload 7
        //   475: invokevirtual 203	java/lang/Object:getClass	()Ljava/lang/Class;
        //   478: ldc -51
        //   480: invokevirtual 209	java/lang/Object:equals	(Ljava/lang/Object;)Z
        //   483: ifeq +633 -> 1116
        //   486: iload 4
        //   488: istore_1
        //   489: new 51	java/lang/StringBuilder
        //   492: dup
        //   493: invokespecial 52	java/lang/StringBuilder:<init>	()V
        //   496: ldc -45
        //   498: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   501: aload 7
        //   503: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   506: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   509: invokestatic 217	com/kochava/android/util/Logging:LogError	(Ljava/lang/String;)V
        //   512: iload 4
        //   514: istore_1
        //   515: aload 7
        //   517: invokestatic 221	com/kochava/android/tracker/Feature:access$2400	(Ljava/lang/Exception;)V
        //   520: return
        //   521: iload_2
        //   522: istore 4
        //   524: iload_2
        //   525: istore 6
        //   527: iload_2
        //   528: istore_1
        //   529: aload 8
        //   531: invokevirtual 222	java/lang/StringBuffer:toString	()Ljava/lang/String;
        //   534: astore 7
        //   536: iload_2
        //   537: istore 4
        //   539: iload_2
        //   540: istore 6
        //   542: iload_2
        //   543: istore_1
        //   544: new 51	java/lang/StringBuilder
        //   547: dup
        //   548: invokespecial 52	java/lang/StringBuilder:<init>	()V
        //   551: ldc -32
        //   553: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   556: aload 7
        //   558: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   561: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   564: invokestatic 43	com/kochava/android/util/Logging:Log	(Ljava/lang/String;)V
        //   567: aconst_null
        //   568: astore 8
        //   570: iload_2
        //   571: istore 4
        //   573: iload_2
        //   574: istore 6
        //   576: iload_2
        //   577: istore_1
        //   578: new 123	org/json/JSONObject
        //   581: dup
        //   582: aload 7
        //   584: invokespecial 225	org/json/JSONObject:<init>	(Ljava/lang/String;)V
        //   587: astore 7
        //   589: aload 7
        //   591: astore 8
        //   593: iload_2
        //   594: istore 5
        //   596: aload 8
        //   598: ifnull +301 -> 899
        //   601: iload_2
        //   602: istore 4
        //   604: iload_2
        //   605: istore 6
        //   607: iload_2
        //   608: istore_1
        //   609: new 51	java/lang/StringBuilder
        //   612: dup
        //   613: invokespecial 52	java/lang/StringBuilder:<init>	()V
        //   616: ldc -29
        //   618: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   621: aload 8
        //   623: invokevirtual 155	org/json/JSONObject:toString	()Ljava/lang/String;
        //   626: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   629: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   632: invokestatic 43	com/kochava/android/util/Logging:Log	(Ljava/lang/String;)V
        //   635: aconst_null
        //   636: astore 7
        //   638: iload_2
        //   639: istore 4
        //   641: iload_2
        //   642: istore 6
        //   644: iload_2
        //   645: istore_1
        //   646: aload 8
        //   648: ldc -27
        //   650: invokevirtual 233	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
        //   653: astore 8
        //   655: iload_2
        //   656: istore 4
        //   658: iload_2
        //   659: istore 6
        //   661: aload 8
        //   663: astore 7
        //   665: iload_2
        //   666: istore_1
        //   667: new 51	java/lang/StringBuilder
        //   670: dup
        //   671: invokespecial 52	java/lang/StringBuilder:<init>	()V
        //   674: ldc -21
        //   676: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   679: aload 8
        //   681: invokevirtual 155	org/json/JSONObject:toString	()Ljava/lang/String;
        //   684: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   687: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   690: invokestatic 43	com/kochava/android/util/Logging:Log	(Ljava/lang/String;)V
        //   693: aload 8
        //   695: astore 7
        //   697: iload_2
        //   698: istore 5
        //   700: aload 7
        //   702: ifnull +197 -> 899
        //   705: ldc 85
        //   707: astore 8
        //   709: iload_2
        //   710: istore 4
        //   712: iload_2
        //   713: istore 6
        //   715: iload_2
        //   716: istore_1
        //   717: aload 7
        //   719: ldc -19
        //   721: invokevirtual 239	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
        //   724: astore 9
        //   726: aload 9
        //   728: astore 8
        //   730: iload_2
        //   731: istore 4
        //   733: iload_2
        //   734: istore 6
        //   736: iload_2
        //   737: istore_1
        //   738: aload 7
        //   740: ldc -15
        //   742: invokevirtual 245	org/json/JSONObject:getInt	(Ljava/lang/String;)I
        //   745: istore_3
        //   746: iload_3
        //   747: istore 5
        //   749: iload_3
        //   750: ifge +149 -> 899
        //   753: iload_3
        //   754: istore 4
        //   756: iload_3
        //   757: istore 6
        //   759: iload_3
        //   760: istore_1
        //   761: iload_3
        //   762: istore_2
        //   763: invokestatic 248	com/kochava/android/tracker/Feature:access$2900	()Landroid/content/SharedPreferences;
        //   766: invokeinterface 252 1 0
        //   771: ldc -2
        //   773: aload 8
        //   775: invokeinterface 260 3 0
        //   780: invokeinterface 263 1 0
        //   785: iload_3
        //   786: istore 4
        //   788: iload_3
        //   789: istore 5
        //   791: iload_3
        //   792: istore 6
        //   794: iload_3
        //   795: istore_1
        //   796: iload_3
        //   797: istore_2
        //   798: invokestatic 267	com/kochava/android/tracker/Feature:access$3000	()Landroid/os/Handler;
        //   801: ifnull +98 -> 899
        //   804: iload_3
        //   805: istore 4
        //   807: iload_3
        //   808: istore 6
        //   810: iload_3
        //   811: istore_1
        //   812: iload_3
        //   813: istore_2
        //   814: invokestatic 273	android/os/Message:obtain	()Landroid/os/Message;
        //   817: astore 7
        //   819: iload_3
        //   820: istore 4
        //   822: iload_3
        //   823: istore 6
        //   825: iload_3
        //   826: istore_1
        //   827: iload_3
        //   828: istore_2
        //   829: new 275	android/os/Bundle
        //   832: dup
        //   833: invokespecial 276	android/os/Bundle:<init>	()V
        //   836: astore 9
        //   838: iload_3
        //   839: istore 4
        //   841: iload_3
        //   842: istore 6
        //   844: iload_3
        //   845: istore_1
        //   846: iload_3
        //   847: istore_2
        //   848: aload 9
        //   850: ldc -2
        //   852: aload 8
        //   854: invokevirtual 277	java/lang/String:toString	()Ljava/lang/String;
        //   857: invokevirtual 279	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
        //   860: iload_3
        //   861: istore 4
        //   863: iload_3
        //   864: istore 6
        //   866: iload_3
        //   867: istore_1
        //   868: iload_3
        //   869: istore_2
        //   870: aload 7
        //   872: aload 9
        //   874: invokevirtual 283	android/os/Message:setData	(Landroid/os/Bundle;)V
        //   877: iload_3
        //   878: istore 4
        //   880: iload_3
        //   881: istore 6
        //   883: iload_3
        //   884: istore_1
        //   885: iload_3
        //   886: istore_2
        //   887: invokestatic 267	com/kochava/android/tracker/Feature:access$3000	()Landroid/os/Handler;
        //   890: aload 7
        //   892: invokevirtual 289	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
        //   895: pop
        //   896: iload_3
        //   897: istore 5
        //   899: iload 5
        //   901: ifle -381 -> 520
        //   904: iload 5
        //   906: invokestatic 292	com/kochava/android/tracker/Feature:sendKVQuery	(I)V
        //   909: return
        //   910: astore 7
        //   912: iload_2
        //   913: istore 4
        //   915: iload_2
        //   916: istore 6
        //   918: iload_2
        //   919: istore_1
        //   920: new 51	java/lang/StringBuilder
        //   923: dup
        //   924: invokespecial 52	java/lang/StringBuilder:<init>	()V
        //   927: ldc_w 294
        //   930: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   933: aload 7
        //   935: invokevirtual 295	org/json/JSONException:toString	()Ljava/lang/String;
        //   938: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   941: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   944: invokestatic 217	com/kochava/android/util/Logging:LogError	(Ljava/lang/String;)V
        //   947: goto -354 -> 593
        //   950: astore 7
        //   952: iload 6
        //   954: istore_1
        //   955: new 51	java/lang/StringBuilder
        //   958: dup
        //   959: invokespecial 52	java/lang/StringBuilder:<init>	()V
        //   962: ldc_w 297
        //   965: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   968: aload 7
        //   970: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   973: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   976: invokestatic 217	com/kochava/android/util/Logging:LogError	(Ljava/lang/String;)V
        //   979: return
        //   980: astore 7
        //   982: aload 7
        //   984: invokevirtual 203	java/lang/Object:getClass	()Ljava/lang/Class;
        //   987: ldc -51
        //   989: invokevirtual 209	java/lang/Object:equals	(Ljava/lang/Object;)Z
        //   992: ifeq +152 -> 1144
        //   995: new 51	java/lang/StringBuilder
        //   998: dup
        //   999: invokespecial 52	java/lang/StringBuilder:<init>	()V
        //   1002: ldc -45
        //   1004: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1007: aload 7
        //   1009: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   1012: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   1015: invokestatic 217	com/kochava/android/util/Logging:LogError	(Ljava/lang/String;)V
        //   1018: aload 7
        //   1020: invokestatic 221	com/kochava/android/tracker/Feature:access$2400	(Ljava/lang/Exception;)V
        //   1023: return
        //   1024: astore 8
        //   1026: iload_2
        //   1027: istore 4
        //   1029: iload_2
        //   1030: istore 6
        //   1032: iload_2
        //   1033: istore_1
        //   1034: ldc_w 299
        //   1037: invokestatic 43	com/kochava/android/util/Logging:Log	(Ljava/lang/String;)V
        //   1040: goto -343 -> 697
        //   1043: astore 7
        //   1045: new 51	java/lang/StringBuilder
        //   1048: dup
        //   1049: invokespecial 52	java/lang/StringBuilder:<init>	()V
        //   1052: ldc_w 301
        //   1055: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1058: aload 7
        //   1060: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   1063: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   1066: invokestatic 217	com/kochava/android/util/Logging:LogError	(Ljava/lang/String;)V
        //   1069: iload_1
        //   1070: istore 5
        //   1072: goto -173 -> 899
        //   1075: astore 9
        //   1077: iload_2
        //   1078: istore 4
        //   1080: iload_2
        //   1081: istore 6
        //   1083: iload_2
        //   1084: istore_1
        //   1085: ldc_w 303
        //   1088: invokestatic 217	com/kochava/android/util/Logging:LogError	(Ljava/lang/String;)V
        //   1091: goto -361 -> 730
        //   1094: astore 7
        //   1096: iload_2
        //   1097: istore 4
        //   1099: iload_2
        //   1100: istore 6
        //   1102: iload_2
        //   1103: istore_1
        //   1104: ldc_w 305
        //   1107: invokestatic 217	com/kochava/android/util/Logging:LogError	(Ljava/lang/String;)V
        //   1110: iload_2
        //   1111: istore 5
        //   1113: goto -214 -> 899
        //   1116: iload 4
        //   1118: istore_1
        //   1119: new 51	java/lang/StringBuilder
        //   1122: dup
        //   1123: invokespecial 52	java/lang/StringBuilder:<init>	()V
        //   1126: ldc_w 307
        //   1129: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1132: aload 7
        //   1134: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   1137: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   1140: invokestatic 217	com/kochava/android/util/Logging:LogError	(Ljava/lang/String;)V
        //   1143: return
        //   1144: new 51	java/lang/StringBuilder
        //   1147: dup
        //   1148: invokespecial 52	java/lang/StringBuilder:<init>	()V
        //   1151: ldc_w 307
        //   1154: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1157: aload 7
        //   1159: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   1162: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   1165: invokestatic 217	com/kochava/android/util/Logging:LogError	(Ljava/lang/String;)V
        //   1168: return
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	1169	0	this	7
        //   4	1115	1	i	int
        //   2	1109	2	j	int
        //   745	152	3	k	int
        //   369	748	4	m	int
        //   594	518	5	n	int
        //   372	729	6	i1	int
        //   117	321	7	localObject1	Object
        //   468	48	7	localIOException1	IOException
        //   534	357	7	localObject2	Object
        //   910	24	7	localJSONException1	JSONException
        //   950	19	7	localOutOfMemoryError	OutOfMemoryError
        //   980	39	7	localIOException2	IOException
        //   1043	16	7	localException	Exception
        //   1094	64	7	localJSONException2	JSONException
        //   212	641	8	localObject3	Object
        //   1024	1	8	localJSONException3	JSONException
        //   350	523	9	localObject4	Object
        //   1075	1	9	localJSONException4	JSONException
        // Exception table:
        //   from	to	target	type
        //   376	381	468	java/io/IOException
        //   389	400	468	java/io/IOException
        //   408	429	468	java/io/IOException
        //   437	444	468	java/io/IOException
        //   457	465	468	java/io/IOException
        //   529	536	468	java/io/IOException
        //   544	567	468	java/io/IOException
        //   578	589	468	java/io/IOException
        //   609	635	468	java/io/IOException
        //   646	655	468	java/io/IOException
        //   667	693	468	java/io/IOException
        //   717	726	468	java/io/IOException
        //   738	746	468	java/io/IOException
        //   763	785	468	java/io/IOException
        //   798	804	468	java/io/IOException
        //   814	819	468	java/io/IOException
        //   829	838	468	java/io/IOException
        //   848	860	468	java/io/IOException
        //   870	877	468	java/io/IOException
        //   887	896	468	java/io/IOException
        //   920	947	468	java/io/IOException
        //   1034	1040	468	java/io/IOException
        //   1085	1091	468	java/io/IOException
        //   1104	1110	468	java/io/IOException
        //   578	589	910	org/json/JSONException
        //   376	381	950	java/lang/OutOfMemoryError
        //   389	400	950	java/lang/OutOfMemoryError
        //   408	429	950	java/lang/OutOfMemoryError
        //   437	444	950	java/lang/OutOfMemoryError
        //   457	465	950	java/lang/OutOfMemoryError
        //   529	536	950	java/lang/OutOfMemoryError
        //   544	567	950	java/lang/OutOfMemoryError
        //   578	589	950	java/lang/OutOfMemoryError
        //   609	635	950	java/lang/OutOfMemoryError
        //   646	655	950	java/lang/OutOfMemoryError
        //   667	693	950	java/lang/OutOfMemoryError
        //   717	726	950	java/lang/OutOfMemoryError
        //   738	746	950	java/lang/OutOfMemoryError
        //   763	785	950	java/lang/OutOfMemoryError
        //   798	804	950	java/lang/OutOfMemoryError
        //   814	819	950	java/lang/OutOfMemoryError
        //   829	838	950	java/lang/OutOfMemoryError
        //   848	860	950	java/lang/OutOfMemoryError
        //   870	877	950	java/lang/OutOfMemoryError
        //   887	896	950	java/lang/OutOfMemoryError
        //   920	947	950	java/lang/OutOfMemoryError
        //   1034	1040	950	java/lang/OutOfMemoryError
        //   1085	1091	950	java/lang/OutOfMemoryError
        //   1104	1110	950	java/lang/OutOfMemoryError
        //   5	11	980	java/io/IOException
        //   13	25	980	java/io/IOException
        //   27	32	980	java/io/IOException
        //   34	40	980	java/io/IOException
        //   42	76	980	java/io/IOException
        //   78	119	980	java/io/IOException
        //   121	140	980	java/io/IOException
        //   142	151	980	java/io/IOException
        //   153	160	980	java/io/IOException
        //   162	170	980	java/io/IOException
        //   172	180	980	java/io/IOException
        //   182	188	980	java/io/IOException
        //   190	196	980	java/io/IOException
        //   198	203	980	java/io/IOException
        //   205	214	980	java/io/IOException
        //   216	226	980	java/io/IOException
        //   228	239	980	java/io/IOException
        //   241	252	980	java/io/IOException
        //   254	283	980	java/io/IOException
        //   285	295	980	java/io/IOException
        //   297	304	980	java/io/IOException
        //   306	329	980	java/io/IOException
        //   331	336	980	java/io/IOException
        //   338	352	980	java/io/IOException
        //   354	361	980	java/io/IOException
        //   363	368	980	java/io/IOException
        //   473	486	980	java/io/IOException
        //   489	512	980	java/io/IOException
        //   515	520	980	java/io/IOException
        //   955	979	980	java/io/IOException
        //   1119	1143	980	java/io/IOException
        //   646	655	1024	org/json/JSONException
        //   667	693	1024	org/json/JSONException
        //   5	11	1043	java/lang/Exception
        //   13	25	1043	java/lang/Exception
        //   27	32	1043	java/lang/Exception
        //   34	40	1043	java/lang/Exception
        //   42	76	1043	java/lang/Exception
        //   78	119	1043	java/lang/Exception
        //   121	140	1043	java/lang/Exception
        //   142	151	1043	java/lang/Exception
        //   153	160	1043	java/lang/Exception
        //   162	170	1043	java/lang/Exception
        //   172	180	1043	java/lang/Exception
        //   182	188	1043	java/lang/Exception
        //   190	196	1043	java/lang/Exception
        //   198	203	1043	java/lang/Exception
        //   205	214	1043	java/lang/Exception
        //   216	226	1043	java/lang/Exception
        //   228	239	1043	java/lang/Exception
        //   241	252	1043	java/lang/Exception
        //   254	283	1043	java/lang/Exception
        //   285	295	1043	java/lang/Exception
        //   297	304	1043	java/lang/Exception
        //   306	329	1043	java/lang/Exception
        //   331	336	1043	java/lang/Exception
        //   338	352	1043	java/lang/Exception
        //   354	361	1043	java/lang/Exception
        //   363	368	1043	java/lang/Exception
        //   376	381	1043	java/lang/Exception
        //   389	400	1043	java/lang/Exception
        //   408	429	1043	java/lang/Exception
        //   437	444	1043	java/lang/Exception
        //   457	465	1043	java/lang/Exception
        //   473	486	1043	java/lang/Exception
        //   489	512	1043	java/lang/Exception
        //   515	520	1043	java/lang/Exception
        //   529	536	1043	java/lang/Exception
        //   544	567	1043	java/lang/Exception
        //   578	589	1043	java/lang/Exception
        //   609	635	1043	java/lang/Exception
        //   646	655	1043	java/lang/Exception
        //   667	693	1043	java/lang/Exception
        //   717	726	1043	java/lang/Exception
        //   738	746	1043	java/lang/Exception
        //   763	785	1043	java/lang/Exception
        //   798	804	1043	java/lang/Exception
        //   814	819	1043	java/lang/Exception
        //   829	838	1043	java/lang/Exception
        //   848	860	1043	java/lang/Exception
        //   870	877	1043	java/lang/Exception
        //   887	896	1043	java/lang/Exception
        //   920	947	1043	java/lang/Exception
        //   955	979	1043	java/lang/Exception
        //   1034	1040	1043	java/lang/Exception
        //   1085	1091	1043	java/lang/Exception
        //   1104	1110	1043	java/lang/Exception
        //   1119	1143	1043	java/lang/Exception
        //   717	726	1075	org/json/JSONException
        //   738	746	1094	org/json/JSONException
        //   763	785	1094	org/json/JSONException
        //   798	804	1094	org/json/JSONException
        //   814	819	1094	org/json/JSONException
        //   829	838	1094	org/json/JSONException
        //   848	860	1094	org/json/JSONException
        //   870	877	1094	org/json/JSONException
        //   887	896	1094	org/json/JSONException
      }
    };
  }
  
  public Feature(Context paramContext, String paramString)
  {
    HashMap localHashMap = new HashMap();
    if ((paramString != null) && (paramString.trim().length() != 0)) {
      localHashMap.put("kochava_app_id", paramString);
    }
    init(paramContext, true, localHashMap);
  }
  
  private static JSONObject addGlobalProperties(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {
      try
      {
        paramJSONObject.put("usertime", System.currentTimeMillis() / 1000L + "");
        paramJSONObject.put("uptime", System.currentTimeMillis() / 1000L - startTime + "");
        if (lastCallTime != 0L) {
          paramJSONObject.put("updelta", System.currentTimeMillis() / 1000L - lastCallTime + "");
        }
        for (;;)
        {
          lastCallTime = System.currentTimeMillis() / 1000L;
          prefs = appContext.getSharedPreferences("initPrefs", 0);
          if (prefs.getString("mylat", "").equals("")) {
            break;
          }
          paramJSONObject.put("geo_lat", prefs.getString("mylat", ""));
          paramJSONObject.put("geo_lon", prefs.getString("mylong", ""));
          return paramJSONObject;
          paramJSONObject.put("updelta", "0");
        }
        return paramJSONObject;
      }
      catch (Exception localException)
      {
        Logging.LogError("Error adding time properties to a JSON object " + localException);
      }
    }
  }
  
  private void checkOutsideServices(JSONObject paramJSONObject)
  {
    JSONArray localJSONArray1 = new JSONArray();
    try
    {
      Iterator localIterator = paramJSONObject.keys();
      if (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        JSONArray localJSONArray2 = paramJSONObject.getJSONArray(str);
        int i = 0;
        for (;;)
        {
          int j = localJSONArray2.length();
          if (i >= j) {
            break;
          }
          try
          {
            new ComponentName(appContext, Class.forName(localJSONArray2.getString(i)));
            localJSONArray1.put(str);
          }
          catch (Exception localException)
          {
            i += 1;
          }
        }
      }
      return;
    }
    catch (Exception paramJSONObject)
    {
      if (localJSONArray1.length() > 0) {
        sendOutsideServicesUpdate(localJSONArray1);
      }
    }
  }
  
  private String createAppData()
  {
    String str = "" + getMyDeviceId() + ":::";
    str = str + getModel() + ":::";
    str = str + getBrand() + ":::";
    str = str + getAppVersion() + ":::";
    return str + getOSVersion();
  }
  
  public static void enableDebug(boolean paramBoolean)
  {
    Global.DEBUG = paramBoolean;
    Logging.Log("enableDebug to " + paramBoolean);
  }
  
  private static void endAppSession()
  {
    for (;;)
    {
      try
      {
        if ((Build.VERSION.SDK_INT < 14) || (overrideAutomaticSessions)) {
          return;
        }
        if (badInit)
        {
          Logging.LogError("The library was not initialized properly or we cannot connect to our servers. Until this is fixed, this method cannot be used.");
          return;
        }
        Logging.Log("Automatic Session End");
        if (!should_flush_in_background)
        {
          if (mTimer != null)
          {
            Logging.Log("Session end, flush timer was on, canceling timer and flushing current events.");
            flush();
            mTimer.cancel();
            mTimer = null;
          }
        }
        else
        {
          if (!canSendSession) {
            break;
          }
          eventSession("exit");
          return;
        }
      }
      catch (Exception localException)
      {
        Logging.LogError("(Automatic Session End) Exception occured during session tracking.\n" + localException);
        return;
      }
      Logging.Log("Session end, flush timer was already off.");
    }
    Logging.Log("Session events disabled by server.");
  }
  
  private static void eventSession(String paramString)
  {
    new Thread()
    {
      public void run()
      {
        Logging.Log("Got event " + val$state);
        Object localObject1 = new HashMap();
        ((HashMap)localObject1).put("state", val$state);
        Logging.Log("FIRE EVENT*** action:" + "session");
        Logging.Log("FIRE EVENT*** properties:" + localObject1);
        JSONObject localJSONObject1 = new JSONObject();
        label308:
        do
        {
          JSONObject localJSONObject2;
          Object localObject2;
          try
          {
            localJSONObject1.put("kochava_app_id", Feature.mAppId);
            localJSONObject1.put("kochava_device_id", Feature.access$2800());
            localJSONObject1.put("action", "session");
            localJSONObject1.put("dev_id_strategy", Feature.mKochDevIDStrategy);
            localJSONObject2 = Feature.addGlobalProperties(new JSONObject());
            if (Feature.mSuperProperties != null)
            {
              localObject2 = Feature.mSuperProperties.entrySet().iterator();
              while (((Iterator)localObject2).hasNext())
              {
                Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
                localJSONObject2.put((String)localEntry.getKey(), localEntry.getValue());
              }
            }
            if (localObject1 == null) {
              break label308;
            }
          }
          catch (JSONException localJSONException)
          {
            if (Global.DEBUGERROR) {
              localJSONException.printStackTrace();
            }
            Logging.LogError("event " + localJSONException);
            return;
          }
          localObject1 = ((HashMap)localObject1).entrySet().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (Map.Entry)((Iterator)localObject1).next();
            localJSONObject2.put((String)((Map.Entry)localObject2).getKey(), ((Map.Entry)localObject2).getValue());
          }
          localJSONException.put("data", localJSONObject2);
          Logging.Log("fireEvent with properties: " + localJSONException);
        } while (Feature.kDbAdapter.addEvent(localJSONException, false, false) < 50);
        Feature.flush();
      }
    }.start();
  }
  
  private void fireEvent(String paramString, Map<String, String> paramMap)
  {
    if ((!paramString.equals("initial")) && (!should_flush_in_background) && (is_in_background) && (!event_flush_triggered))
    {
      event_flush_triggered = true;
      eventFlushTimer.schedule(new TimerTask()
      {
        public void run()
        {
          if (Feature.is_in_background) {
            Feature.flush();
          }
          Feature.access$4302(false);
        }
      }, 60000L);
    }
    Logging.Log("FIRE EVENT*** action:" + paramString);
    Logging.Log("FIRE EVENT*** properties:" + paramMap);
    JSONObject localJSONObject1 = new JSONObject();
    label1083:
    int i;
    do
    {
      JSONObject localJSONObject2;
      for (;;)
      {
        try
        {
          localJSONObject1.put("kochava_app_id", mAppId);
          localJSONObject1.put("kochava_device_id", getMyDeviceId());
          localJSONObject1.put("action", paramString);
          localJSONObject1.put("dev_id_strategy", mKochDevIDStrategy);
          localJSONObject1.put("last_post_time", 0);
          prefs = appContext.getSharedPreferences("initPrefs", 0);
          localJSONObject1.put("currency", prefs.getString("currency", "USD"));
          localJSONObject2 = addGlobalProperties(new JSONObject());
          if (paramString.equals("initial"))
          {
            Logging.Log("Event is initial, or initial did not get que'd on first load");
            try
            {
              if (((Boolean)paramRestrictions.get("affinity_group")).booleanValue())
              {
                paramString = new JSONArray();
                localObject = installedApps.iterator();
                if (((Iterator)localObject).hasNext())
                {
                  ApplicationInfoHolder localApplicationInfoHolder = (ApplicationInfoHolder)((Iterator)localObject).next();
                  JSONObject localJSONObject3 = new JSONObject();
                  localJSONObject3.put("app_name", appPackage);
                  localJSONObject3.put("mtime", appInstallTime);
                  localJSONObject3.put("utime", appUpdateTime);
                  paramString.put(localJSONObject3);
                  continue;
                }
              }
              if (mSuperProperties == null) {
                break;
              }
            }
            catch (JSONException paramString)
            {
              if (Global.DEBUGERROR) {
                paramString.printStackTrace();
              }
              Logging.LogError("event " + paramString);
              return;
              localJSONObject2.put("affinity_group", paramString);
              localJSONObject1.put("sdk_version", "Android20160222" + versionExtension);
              if (((Boolean)paramRestrictions.get("volume")).booleanValue()) {
                localJSONObject1.put("volume", getVolume());
              }
              if (((Boolean)paramRestrictions.get("bssid")).booleanValue()) {
                localJSONObject2.put("bssid", bssid);
              }
              if (((Boolean)paramRestrictions.get("carrier_name")).booleanValue()) {
                localJSONObject2.put("carrier_name", carrier);
              }
              if (((Boolean)paramRestrictions.get("adid")).booleanValue()) {
                localJSONObject2.put("adid", advertisingID);
              }
              localJSONObject2.put("device", getModel() + "-" + getBrand());
              if (((Boolean)paramRestrictions.get("screen_size")).booleanValue()) {
                localJSONObject2.put("disp_h", mDisplayHeight);
              }
              if (((Boolean)paramRestrictions.get("screen_size")).booleanValue()) {
                localJSONObject2.put("disp_w", mDisplayWidth);
              }
              localJSONObject2.put("package_name", getAppPackageName());
              localJSONObject2.put("app_version", getAppVersion());
              if (!mAppVersionName.equals("")) {
                localJSONObject2.put("app_short_string", mAppVersionName);
              }
              if (((Boolean)paramRestrictions.get("android_id")).booleanValue()) {
                localJSONObject2.put("android_id", mAndroidID);
              }
              localJSONObject2.put("os_version", getOSVersion());
              localJSONObject2.put("app_limit_tracking", app_limit_tracking);
              localJSONObject2.put("device_limit_tracking", device_limit_tracking);
              paramString = new JSONObject();
              if (sendEmails)
              {
                localObject = getEmailAccounts();
                if (!((String)localObject).equals("[]")) {
                  paramString.put("email", localObject);
                }
              }
              if (paramString.length() > 0) {
                localJSONObject2.put("ids", paramString);
              }
              if (identityLinkMapJSON != null) {
                localJSONObject2.put("identity_link", identityLinkMapJSON);
              }
              if ((clickData != null) && (!clickData.isEmpty())) {
                localJSONObject2.put("clickData", clickData);
              }
              if (((Boolean)paramRestrictions.get("fb_attribution_id")).booleanValue())
              {
                mFbId = getAttributionId(appContext.getContentResolver());
                if (mFbId != null) {
                  break label1083;
                }
                localJSONObject2.put("fb_attribution_id", "");
              }
              paramString = (WindowManager)appContext.getSystemService("window");
              localObject = new DisplayMetrics();
              paramString.getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
              initialPropertiesObject = localJSONObject2;
              initialObject = localJSONObject1;
              Logging.Log("Initial Event, saving until next event. ");
              return;
            }
            catch (Exception paramString)
            {
              Logging.LogError("Error during fireEvent - Please review stack trace");
              if (Global.DEBUGERROR) {
                paramString.printStackTrace();
              }
            }
          }
          paramString = mSuperProperties.entrySet().iterator();
          if (!paramString.hasNext()) {
            break;
          }
          Object localObject = (Map.Entry)paramString.next();
          localJSONObject2.put((String)((Map.Entry)localObject).getKey(), ((Map.Entry)localObject).getValue());
          continue;
          localJSONObject2.put("fb_attribution_id", mFbId);
        }
        catch (JSONException paramString)
        {
          if (Global.DEBUGERROR) {
            paramString.printStackTrace();
          }
          Logging.LogError("event " + paramString);
          return;
        }
      }
      if (paramMap != null)
      {
        paramString = paramMap.entrySet().iterator();
        while (paramString.hasNext())
        {
          paramMap = (Map.Entry)paramString.next();
          localJSONObject2.put((String)paramMap.getKey(), paramMap.getValue());
        }
      }
      localJSONObject1.put("data", localJSONObject2);
      Logging.Log("fireEvent with properties: " + localJSONObject1);
      queInitial(true);
      i = kDbAdapter.addEvent(localJSONObject1, false, false);
      lastEventTimestamp = System.currentTimeMillis();
    } while (i < 50);
    flush();
  }
  
  private void fireEventBlacklist(String paramString, Map<String, String> paramMap)
  {
    String str = (String)paramMap.get("event_name");
    if (str != null)
    {
      int k = 0;
      int i = 0;
      for (;;)
      {
        int j = k;
        if (i < eventnameBlacklist.length()) {}
        try
        {
          boolean bool = eventnameBlacklist.get(i).equals(paramMap.get("event_name"));
          if (bool)
          {
            j = 1;
            if (j == 0) {
              break;
            }
            Logging.Log("fireEvent - Events under the key \"" + str + "\" are blocked!");
            return;
          }
        }
        catch (JSONException localJSONException)
        {
          i += 1;
        }
      }
      fireEvent(paramString, paramMap);
      return;
    }
    fireEvent(paramString, paramMap);
  }
  
  public static void flush()
  {
    if (badInit)
    {
      Logging.LogError("The library was not initialized properly or we cannot connect to our servers. Until this is fixed, this method cannot be used.");
      return;
    }
    Logging.Log("flush");
    executor.submit(new TrackTask(null));
  }
  
  private String getAdvertisingId()
  {
    for (;;)
    {
      int i;
      try
      {
        i = GooglePlayServicesUtil.isGooglePlayServicesAvailable(appContext);
        if (i != 0) {}
        switch (i)
        {
        case 4: 
        case 5: 
        case 6: 
        case 7: 
        case 8: 
          Logging.Log("Google Play Services check returned unknown error code (" + i + ").");
          Logging.LogError("Problem getting Advertising ID " + GooglePlayServicesUtil.getErrorString(i));
          AdvertisingIdClient.Info localInfo = AdvertisingIdClient.getAdvertisingIdInfo(appContext);
          String str = localInfo.getId();
          device_limit_tracking = localInfo.isLimitAdTrackingEnabled();
          return str;
        }
      }
      catch (Exception localException)
      {
        Logging.LogError("Problem getting Advertising ID (catch): " + localException.toString());
        return "";
      }
      Logging.Log("Google Play Services check returned ConnectionResult.SUCCESS (" + i + ").");
      continue;
      Logging.Log("Google Play Services check returned ConnectionResult.SERVICE_MISSING (" + i + ").");
      continue;
      Logging.Log("Google Play Services check returned ConnectionResult.SERVICE_VERSION_UPDATE_REQUIRED (" + i + ").");
      continue;
      Logging.Log("Google Play Services check returned ConnectionResult.SERVICE_DISABLED (" + i + ").");
      continue;
      Logging.Log("Google Play Services check returned ConnectionResult.SERVICE_INVALID (" + i + ").");
    }
  }
  
  private String getAppPackageName()
  {
    if (mAppPackageName != null) {
      return mAppPackageName;
    }
    return "Unknown";
  }
  
  private String getAppVersion()
  {
    return mAppName + " " + mAppVersionCode;
  }
  
  /* Error */
  protected static String getAttributionId(android.content.ContentResolver paramContentResolver)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: aconst_null
    //   6: astore_2
    //   7: aload_0
    //   8: getstatic 246	com/kochava/android/tracker/Feature:ATTRIBUTION_ID_CONTENT_URI	Landroid/net/Uri;
    //   11: iconst_1
    //   12: anewarray 291	java/lang/String
    //   15: dup
    //   16: iconst_0
    //   17: ldc_w 949
    //   20: aastore
    //   21: aconst_null
    //   22: aconst_null
    //   23: aconst_null
    //   24: invokevirtual 955	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   27: astore_0
    //   28: aload_0
    //   29: ifnull +18 -> 47
    //   32: aload_0
    //   33: astore_2
    //   34: aload_0
    //   35: astore_3
    //   36: aload_0
    //   37: invokeinterface 960 1 0
    //   42: istore_1
    //   43: iload_1
    //   44: ifne +24 -> 68
    //   47: aload_0
    //   48: ifnull +18 -> 66
    //   51: aload_0
    //   52: invokeinterface 963 1 0
    //   57: ifne +9 -> 66
    //   60: aload_0
    //   61: invokeinterface 966 1 0
    //   66: aconst_null
    //   67: areturn
    //   68: aload_0
    //   69: astore_2
    //   70: aload_0
    //   71: astore_3
    //   72: aload_0
    //   73: aload_0
    //   74: ldc_w 949
    //   77: invokeinterface 970 2 0
    //   82: invokeinterface 971 2 0
    //   87: astore 5
    //   89: aload 5
    //   91: astore_2
    //   92: aload_2
    //   93: astore_3
    //   94: aload_0
    //   95: ifnull +22 -> 117
    //   98: aload_2
    //   99: astore_3
    //   100: aload_0
    //   101: invokeinterface 963 1 0
    //   106: ifne +11 -> 117
    //   109: aload_0
    //   110: invokeinterface 966 1 0
    //   115: aload_2
    //   116: astore_3
    //   117: aload_3
    //   118: areturn
    //   119: astore_0
    //   120: aload_2
    //   121: astore_3
    //   122: new 494	java/lang/StringBuilder
    //   125: dup
    //   126: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   129: ldc_w 973
    //   132: invokevirtual 509	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: aload_0
    //   136: invokevirtual 929	java/lang/Exception:toString	()Ljava/lang/String;
    //   139: invokevirtual 509	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: invokevirtual 512	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   145: invokestatic 617	com/kochava/android/util/Logging:Log	(Ljava/lang/String;)V
    //   148: aload 4
    //   150: astore_3
    //   151: aload_2
    //   152: ifnull -35 -> 117
    //   155: aload 4
    //   157: astore_3
    //   158: aload_2
    //   159: invokeinterface 963 1 0
    //   164: ifne -47 -> 117
    //   167: aload_2
    //   168: invokeinterface 966 1 0
    //   173: aload 4
    //   175: astore_3
    //   176: goto -59 -> 117
    //   179: astore_0
    //   180: aload 4
    //   182: astore_3
    //   183: goto -66 -> 117
    //   186: astore_0
    //   187: aload_3
    //   188: ifnull +18 -> 206
    //   191: aload_3
    //   192: invokeinterface 963 1 0
    //   197: ifne +9 -> 206
    //   200: aload_3
    //   201: invokeinterface 966 1 0
    //   206: aload_0
    //   207: athrow
    //   208: astore_2
    //   209: goto -3 -> 206
    //   212: astore_0
    //   213: aload_2
    //   214: astore_3
    //   215: goto -98 -> 117
    //   218: astore_0
    //   219: goto -153 -> 66
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	222	0	paramContentResolver	android.content.ContentResolver
    //   42	2	1	bool	boolean
    //   6	162	2	localObject1	Object
    //   208	6	2	localException	Exception
    //   4	211	3	localObject2	Object
    //   1	180	4	localObject3	Object
    //   87	3	5	str	String
    // Exception table:
    //   from	to	target	type
    //   7	28	119	java/lang/Exception
    //   36	43	119	java/lang/Exception
    //   72	89	119	java/lang/Exception
    //   158	173	179	java/lang/Exception
    //   7	28	186	finally
    //   36	43	186	finally
    //   72	89	186	finally
    //   122	148	186	finally
    //   191	206	208	java/lang/Exception
    //   100	115	212	java/lang/Exception
    //   51	66	218	java/lang/Exception
  }
  
  private static String getBrand()
  {
    return Build.BRAND;
  }
  
  private String getEmailAccounts()
  {
    Object localObject1 = "";
    if (appContext.checkCallingOrSelfPermission("android.permission.GET_ACCOUNTS") == 0)
    {
      Account[] arrayOfAccount = AccountManager.get(appContext).getAccounts();
      int j = arrayOfAccount.length;
      int i = 0;
      while (i < j)
      {
        Account localAccount = arrayOfAccount[i];
        Object localObject2 = localObject1;
        if (isEmailValid(name))
        {
          localObject2 = name.toLowerCase();
          localObject2 = (String)localObject1 + (String)localObject2 + ",";
        }
        i += 1;
        localObject1 = localObject2;
      }
      if (((String)localObject1).length() > 0) {
        localObject1 = ((String)localObject1).substring(0, ((String)localObject1).length() - 1);
      }
    }
    for (;;)
    {
      return "[" + (String)localObject1 + "]";
      localObject1 = "";
      continue;
      localObject1 = "";
      Logging.Log("****NOTICE**** Gathering of emails was whitelisted, but android.permission.GET_ACCOUNTS declaration was missing from manifest.");
    }
  }
  
  private static String getModel()
  {
    return Build.MODEL;
  }
  
  private static String getMyDeviceId()
  {
    if ((prefs.contains("kochava_app_id_generated")) && (!prefs.getString("kochava_app_id_generated", "").equals(""))) {
      return prefs.getString("kochava_app_id_generated", "");
    }
    String str = UUID.randomUUID().toString().replaceAll("-", "");
    str = "KA" + str;
    prefs.edit().putString("kochava_app_id_generated", str).apply();
    return str;
  }
  
  private static String getOSVersion()
  {
    return "Android " + Build.VERSION.RELEASE;
  }
  
  private String getUserAgent()
  {
    Object localObject5 = "";
    localObject1 = "";
    int i = 1;
    int j = 1;
    try
    {
      localObject6 = "" + "\nTrying user agent method 1";
      localObject1 = localObject6;
      localObject3 = System.getProperty("http.agent");
      localObject5 = localObject3;
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        Object localObject3;
        localObject6 = new StringWriter();
        localException2.printStackTrace(new PrintWriter((Writer)localObject6));
        Logging.LogError(((StringWriter)localObject6).toString());
        localObject6 = (String)localObject1 + "\nError with user agent first method: " + localException2.toString() + "\n" + ((StringWriter)localObject6).toString();
      }
    }
    if (((String)localObject5).trim().isEmpty()) {
      i = 0;
    }
    localObject1 = localObject5;
    localObject3 = localObject6;
    if (i == 0)
    {
      localObject1 = localObject5;
      localObject3 = localObject6;
    }
    try
    {
      localObject6 = (String)localObject6 + "\nTrying user agent method 2";
      localObject1 = localObject5;
      localObject3 = localObject6;
      localObject5 = new WebView(appContext).getSettings().getUserAgentString();
      localObject1 = localObject5;
      localObject3 = localObject6;
      localObject6 = (String)localObject6 + "\nMethod 2 successful";
      localObject3 = localObject6;
      localObject1 = localObject5;
    }
    catch (Exception localException3)
    {
      for (;;)
      {
        Object localObject10;
        Object localObject9;
        localObject6 = new StringWriter();
        localException3.printStackTrace(new PrintWriter((Writer)localObject6));
        Logging.LogError(((StringWriter)localObject6).toString());
        localObject4 = localException2 + "\nError with user agent second method: " + localException3.toString() + "\n" + ((StringWriter)localObject6).toString() + "\n userAgent = error.";
      }
    }
    i = j;
    if (((String)localObject1).trim().isEmpty()) {
      i = 0;
    }
    localObject7 = localObject1;
    localObject8 = localObject3;
    if (i == 0)
    {
      localObject10 = null;
      localObject9 = null;
      localObject5 = localObject9;
      localObject6 = localObject1;
      localObject8 = localObject3;
      localObject7 = localObject10;
    }
    try
    {
      String str2 = (String)localObject3 + "\nTrying user agent method 3";
      localObject5 = localObject9;
      localObject6 = localObject1;
      localObject8 = str2;
      localObject7 = localObject10;
      localObject3 = WebSettings.class.getDeclaredConstructor(new Class[] { Context.class, WebView.class });
      localObject5 = localObject3;
      localObject6 = localObject1;
      localObject8 = str2;
      localObject7 = localObject3;
      ((Constructor)localObject3).setAccessible(true);
      localObject5 = localObject3;
      localObject6 = localObject1;
      localObject8 = str2;
      localObject7 = localObject3;
      localObject1 = ((WebSettings)((Constructor)localObject3).newInstance(new Object[] { appContext, null })).getUserAgentString();
      localObject5 = localObject3;
      localObject6 = localObject1;
      localObject8 = str2;
      localObject7 = localObject3;
      str2 = str2 + "\nMethod 3 successful.";
      localObject5 = str2;
      localObject7 = localObject1;
      localObject8 = localObject5;
      if (localObject3 != null)
      {
        ((Constructor)localObject3).setAccessible(false);
        localObject8 = localObject5;
        localObject7 = localObject1;
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        localObject7 = localException3;
        Object localObject4 = new StringWriter();
        localObject7 = localException3;
        localException1.printStackTrace(new PrintWriter((Writer)localObject4));
        localObject7 = localException3;
        Logging.LogError(((StringWriter)localObject4).toString());
        localObject7 = localException3;
        String str1 = (String)localObject8 + "\nError with user agent third method: " + localException1.toString() + "\n" + ((StringWriter)localObject4).toString() + "\n userAgent = error.";
        localObject7 = localObject6;
        localObject8 = str1;
        if (localException3 != null)
        {
          localException3.setAccessible(false);
          localObject7 = localObject6;
          localObject8 = str1;
        }
      }
    }
    finally
    {
      if (localObject7 == null) {
        break label732;
      }
      ((Constructor)localObject7).setAccessible(false);
    }
    Logging.Log("user agent result: " + (String)localObject8);
    return (String)localObject7;
  }
  
  private static String getVolume()
  {
    try
    {
      Object localObject = (AudioManager)appContext.getSystemService("audio");
      localObject = ((AudioManager)localObject).getStreamVolume(3) + "";
      return (String)localObject;
    }
    catch (Exception localException) {}
    return "";
  }
  
  private static boolean haveAttributionData()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (attributionDataPrefs != null)
    {
      bool1 = bool2;
      if (!attributionDataPrefs.getAll().isEmpty()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private static void httpsError(Exception paramException)
  {
    new Thread()
    {
      public void run()
      {
        try
        {
          Feature.access$2302(true);
          Object localObject2 = val$e.getMessage();
          Object localObject1 = new JSONObject();
          ((JSONObject)localObject1).put("message", localObject2);
          ((JSONObject)localObject1).put("os_version", Feature.access$3400());
          ((JSONObject)localObject1).put("device", Feature.access$5300() + "-" + Feature.access$5400());
          localObject2 = new JSONObject();
          ((JSONObject)localObject2).put("kochava_device_id", Feature.access$2800());
          ((JSONObject)localObject2).put("action", "error");
          ((JSONObject)localObject2).put("data", localObject1);
          ((JSONObject)localObject2).put("kochava_app_id", Feature.mAppId);
          ((JSONObject)localObject2).put("sdk_version", "Android20160222" + Feature.versionExtension);
          ((JSONObject)localObject2).put("sdk_protocol", "4");
          Logging.Log("https log - posting to " + "http://" + Feature.hostControl + "/track/kvTracker.php");
          Object localObject3 = new URL("http://" + Feature.hostControl + "/track/kvTracker.php");
          localObject1 = ((JSONObject)localObject2).toString();
          Logging.Log("https failure data:" + (String)localObject1);
          localObject2 = (HttpURLConnection)((URL)localObject3).openConnection();
          ((HttpURLConnection)localObject2).setRequestProperty("User-Agent", Feature.prefs.getString("useragent", ""));
          ((HttpURLConnection)localObject2).setRequestProperty("Content-Type", "application/json; charset=UTF-8");
          ((HttpURLConnection)localObject2).setRequestMethod("POST");
          ((HttpURLConnection)localObject2).setConnectTimeout(30000);
          ((HttpURLConnection)localObject2).setReadTimeout(30000);
          ((HttpURLConnection)localObject2).setDoInput(true);
          ((HttpURLConnection)localObject2).setDoOutput(true);
          ((HttpURLConnection)localObject2).connect();
          localObject3 = new OutputStreamWriter(((HttpURLConnection)localObject2).getOutputStream());
          ((OutputStreamWriter)localObject3).write((String)localObject1);
          ((OutputStreamWriter)localObject3).close();
          Logging.Log("Grabbing Result...");
          localObject1 = new StringBuffer("");
          localObject2 = new BufferedReader(new InputStreamReader(((HttpURLConnection)localObject2).getInputStream()));
          for (;;)
          {
            localObject3 = ((BufferedReader)localObject2).readLine();
            if (localObject3 == null) {
              break;
            }
            ((StringBuffer)localObject1).append((String)localObject3);
          }
          str = localException.toString();
        }
        catch (Exception localException)
        {
          Logging.LogError("httpsFail " + localException);
          return;
        }
        String str;
        Logging.Log("Result: " + str);
      }
    }.start();
  }
  
  /* Error */
  @TargetApi(14)
  private void init(Context paramContext, boolean paramBoolean, HashMap<String, Object> paramHashMap)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +2423 -> 2424
    //   4: aload_1
    //   5: invokevirtual 1143	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   8: putstatic 523	com/kochava/android/tracker/Feature:appContext	Landroid/content/Context;
    //   11: iload_2
    //   12: putstatic 193	com/kochava/android/tracker/Feature:sendOnStart	Z
    //   15: ldc_w 1145
    //   18: new 494	java/lang/StringBuilder
    //   21: dup
    //   22: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   25: ldc_w 1147
    //   28: invokevirtual 509	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: getstatic 167	com/kochava/android/tracker/Feature:versionExtension	Ljava/lang/String;
    //   34: invokevirtual 509	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: invokevirtual 512	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: invokestatic 1153	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   43: pop
    //   44: aload_0
    //   45: new 635	java/util/Timer
    //   48: dup
    //   49: invokespecial 1154	java/util/Timer:<init>	()V
    //   52: putfield 663	com/kochava/android/tracker/Feature:eventFlushTimer	Ljava/util/Timer;
    //   55: getstatic 523	com/kochava/android/tracker/Feature:appContext	Landroid/content/Context;
    //   58: ldc_w 525
    //   61: iconst_0
    //   62: invokevirtual 531	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   65: putstatic 419	com/kochava/android/tracker/Feature:prefs	Landroid/content/SharedPreferences;
    //   68: new 863	com/kochava/android/tracker/DbAdapter
    //   71: dup
    //   72: getstatic 523	com/kochava/android/tracker/Feature:appContext	Landroid/content/Context;
    //   75: invokespecial 1155	com/kochava/android/tracker/DbAdapter:<init>	(Landroid/content/Context;)V
    //   78: putstatic 413	com/kochava/android/tracker/Feature:kDbAdapter	Lcom/kochava/android/tracker/DbAdapter;
    //   81: aload_3
    //   82: ifnull +231 -> 313
    //   85: aload_3
    //   86: ldc_w 1157
    //   89: invokevirtual 698	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   92: ifnull +44 -> 136
    //   95: aload_3
    //   96: ldc_w 1157
    //   99: invokevirtual 698	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   102: invokevirtual 1161	java/lang/Object:getClass	()Ljava/lang/Class;
    //   105: ldc_w 700
    //   108: invokevirtual 876	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   111: ifeq +25 -> 136
    //   114: aload_3
    //   115: ldc_w 1157
    //   118: invokevirtual 698	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   121: checkcast 700	java/lang/Boolean
    //   124: invokevirtual 703	java/lang/Boolean:booleanValue	()Z
    //   127: istore_2
    //   128: iload_2
    //   129: invokestatic 1163	com/kochava/android/tracker/Feature:enableDebug	(Z)V
    //   132: iload_2
    //   133: invokestatic 1166	com/kochava/android/tracker/Feature:setErrorDebug	(Z)V
    //   136: aload_3
    //   137: ldc_w 1168
    //   140: invokevirtual 698	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   143: ifnull +35 -> 178
    //   146: aload_3
    //   147: ldc_w 1168
    //   150: invokevirtual 698	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   153: invokevirtual 1161	java/lang/Object:getClass	()Ljava/lang/Class;
    //   156: ldc_w 291
    //   159: invokevirtual 876	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   162: ifeq +16 -> 178
    //   165: aload_3
    //   166: ldc_w 1168
    //   169: invokevirtual 698	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   172: checkcast 291	java/lang/String
    //   175: putstatic 167	com/kochava/android/tracker/Feature:versionExtension	Ljava/lang/String;
    //   178: aload_3
    //   179: ldc_w 1170
    //   182: invokevirtual 698	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   185: ifnull +38 -> 223
    //   188: aload_3
    //   189: ldc_w 1170
    //   192: invokevirtual 698	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   195: invokevirtual 1161	java/lang/Object:getClass	()Ljava/lang/Class;
    //   198: ldc_w 700
    //   201: invokevirtual 876	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   204: ifeq +19 -> 223
    //   207: aload_3
    //   208: ldc_w 1170
    //   211: invokevirtual 698	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   214: checkcast 700	java/lang/Boolean
    //   217: invokevirtual 703	java/lang/Boolean:booleanValue	()Z
    //   220: putstatic 169	com/kochava/android/tracker/Feature:overrideAutomaticSessions	Z
    //   223: aload_3
    //   224: ldc_w 1172
    //   227: invokevirtual 698	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   230: ifnull +38 -> 268
    //   233: aload_3
    //   234: ldc_w 1172
    //   237: invokevirtual 698	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   240: invokevirtual 1161	java/lang/Object:getClass	()Ljava/lang/Class;
    //   243: ldc_w 700
    //   246: invokevirtual 876	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   249: ifeq +19 -> 268
    //   252: aload_3
    //   253: ldc_w 1172
    //   256: invokevirtual 698	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   259: checkcast 700	java/lang/Boolean
    //   262: invokevirtual 703	java/lang/Boolean:booleanValue	()Z
    //   265: putstatic 191	com/kochava/android/tracker/Feature:suppress_adid	Z
    //   268: aload_3
    //   269: ldc_w 1174
    //   272: invokevirtual 698	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   275: ifnull +38 -> 313
    //   278: aload_3
    //   279: ldc_w 1174
    //   282: invokevirtual 698	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   285: invokevirtual 1161	java/lang/Object:getClass	()Ljava/lang/Class;
    //   288: ldc_w 700
    //   291: invokevirtual 876	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   294: ifeq +19 -> 313
    //   297: aload_3
    //   298: ldc_w 1174
    //   301: invokevirtual 698	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   304: checkcast 700	java/lang/Boolean
    //   307: invokevirtual 703	java/lang/Boolean:booleanValue	()Z
    //   310: putstatic 208	com/kochava/android/tracker/Feature:should_flush_in_background	Z
    //   313: aload_0
    //   314: invokespecial 1176	com/kochava/android/tracker/Feature:initHandler	()V
    //   317: new 494	java/lang/StringBuilder
    //   320: dup
    //   321: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   324: ldc_w 1178
    //   327: invokevirtual 509	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: getstatic 419	com/kochava/android/tracker/Feature:prefs	Landroid/content/SharedPreferences;
    //   333: ldc_w 1180
    //   336: ldc -93
    //   338: invokeinterface 539 3 0
    //   343: invokevirtual 509	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: invokevirtual 512	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   349: invokestatic 617	com/kochava/android/util/Logging:Log	(Ljava/lang/String;)V
    //   352: getstatic 419	com/kochava/android/tracker/Feature:prefs	Landroid/content/SharedPreferences;
    //   355: ldc_w 1180
    //   358: ldc -93
    //   360: invokeinterface 539 3 0
    //   365: ldc -93
    //   367: invokevirtual 543	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   370: ifne +26 -> 396
    //   373: new 251	org/json/JSONArray
    //   376: dup
    //   377: getstatic 419	com/kochava/android/tracker/Feature:prefs	Landroid/content/SharedPreferences;
    //   380: ldc_w 1180
    //   383: ldc -93
    //   385: invokeinterface 539 3 0
    //   390: invokespecial 1181	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   393: putstatic 254	com/kochava/android/tracker/Feature:eventnameBlacklist	Lorg/json/JSONArray;
    //   396: getstatic 622	android/os/Build$VERSION:SDK_INT	I
    //   399: bipush 14
    //   401: if_icmplt +2064 -> 2465
    //   404: getstatic 169	com/kochava/android/tracker/Feature:overrideAutomaticSessions	Z
    //   407: ifne +2058 -> 2465
    //   410: new 494	java/lang/StringBuilder
    //   413: dup
    //   414: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   417: ldc_w 1183
    //   420: invokevirtual 509	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: getstatic 169	com/kochava/android/tracker/Feature:overrideAutomaticSessions	Z
    //   426: invokevirtual 614	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   429: invokevirtual 512	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   432: invokestatic 617	com/kochava/android/util/Logging:Log	(Ljava/lang/String;)V
    //   435: getstatic 523	com/kochava/android/tracker/Feature:appContext	Landroid/content/Context;
    //   438: checkcast 1185	android/app/Application
    //   441: new 56	com/kochava/android/tracker/Feature$LifeCycleTracker
    //   444: dup
    //   445: aload_0
    //   446: invokespecial 1186	com/kochava/android/tracker/Feature$LifeCycleTracker:<init>	(Lcom/kochava/android/tracker/Feature;)V
    //   449: invokevirtual 1190	android/app/Application:registerActivityLifecycleCallbacks	(Landroid/app/Application$ActivityLifecycleCallbacks;)V
    //   452: getstatic 523	com/kochava/android/tracker/Feature:appContext	Landroid/content/Context;
    //   455: new 59	com/kochava/android/tracker/Feature$MemoryBoss
    //   458: dup
    //   459: aload_0
    //   460: invokespecial 1191	com/kochava/android/tracker/Feature$MemoryBoss:<init>	(Lcom/kochava/android/tracker/Feature;)V
    //   463: invokevirtual 1195	android/content/Context:registerComponentCallbacks	(Landroid/content/ComponentCallbacks;)V
    //   466: iconst_1
    //   467: putstatic 1198	com/kochava/android/tracker/Feature$AppLifeCycleStatusManager:active	Z
    //   470: iconst_1
    //   471: putstatic 1201	com/kochava/android/tracker/Feature$AppLifeCycleStatusManager:resumed	Z
    //   474: new 36	com/kochava/android/tracker/Feature$3
    //   477: dup
    //   478: aload_0
    //   479: invokespecial 1202	com/kochava/android/tracker/Feature$3:<init>	(Lcom/kochava/android/tracker/Feature;)V
    //   482: invokevirtual 656	java/lang/Thread:start	()V
    //   485: getstatic 191	com/kochava/android/tracker/Feature:suppress_adid	Z
    //   488: ifne +14 -> 502
    //   491: new 38	com/kochava/android/tracker/Feature$4
    //   494: dup
    //   495: aload_0
    //   496: invokespecial 1203	com/kochava/android/tracker/Feature$4:<init>	(Lcom/kochava/android/tracker/Feature;)V
    //   499: invokevirtual 656	java/lang/Thread:start	()V
    //   502: aload_0
    //   503: getstatic 523	com/kochava/android/tracker/Feature:appContext	Landroid/content/Context;
    //   506: invokevirtual 1207	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   509: getstatic 523	com/kochava/android/tracker/Feature:appContext	Landroid/content/Context;
    //   512: invokevirtual 1210	android/content/Context:getPackageName	()Ljava/lang/String;
    //   515: iconst_0
    //   516: invokevirtual 1216	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   519: getfield 1221	android/content/pm/PackageInfo:packageName	Ljava/lang/String;
    //   522: putfield 939	com/kochava/android/tracker/Feature:mAppPackageName	Ljava/lang/String;
    //   525: aload_0
    //   526: new 514	org/json/JSONObject
    //   529: dup
    //   530: invokespecial 675	org/json/JSONObject:<init>	()V
    //   533: putfield 1223	com/kochava/android/tracker/Feature:kvinitdata	Lorg/json/JSONObject;
    //   536: aload_0
    //   537: new 514	org/json/JSONObject
    //   540: dup
    //   541: invokespecial 675	org/json/JSONObject:<init>	()V
    //   544: putfield 1225	com/kochava/android/tracker/Feature:kvinitdataholder	Lorg/json/JSONObject;
    //   547: aload_0
    //   548: new 514	org/json/JSONObject
    //   551: dup
    //   552: invokespecial 675	org/json/JSONObject:<init>	()V
    //   555: putfield 1227	com/kochava/android/tracker/Feature:kvinitorigdata	Lorg/json/JSONObject;
    //   558: aconst_null
    //   559: astore 13
    //   561: aconst_null
    //   562: astore 6
    //   564: aconst_null
    //   565: astore 9
    //   567: aconst_null
    //   568: astore 7
    //   570: ldc_w 690
    //   573: astore_1
    //   574: aconst_null
    //   575: astore 10
    //   577: aconst_null
    //   578: astore 8
    //   580: aconst_null
    //   581: astore 11
    //   583: aconst_null
    //   584: astore 14
    //   586: aload_1
    //   587: astore 12
    //   589: aload_3
    //   590: ifnull +633 -> 1223
    //   593: aload 6
    //   595: astore 5
    //   597: aload_3
    //   598: ldc_w 1229
    //   601: invokevirtual 698	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   604: ifnull +38 -> 642
    //   607: aload 6
    //   609: astore 5
    //   611: aload_3
    //   612: ldc_w 1229
    //   615: invokevirtual 698	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   618: invokevirtual 1161	java/lang/Object:getClass	()Ljava/lang/Class;
    //   621: ldc_w 291
    //   624: invokevirtual 876	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   627: ifeq +15 -> 642
    //   630: aload_3
    //   631: ldc_w 1229
    //   634: invokevirtual 698	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   637: checkcast 291	java/lang/String
    //   640: astore 5
    //   642: aload 7
    //   644: astore 6
    //   646: aload_3
    //   647: ldc_w 301
    //   650: invokevirtual 698	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   653: ifnull +38 -> 691
    //   656: aload 7
    //   658: astore 6
    //   660: aload_3
    //   661: ldc_w 301
    //   664: invokevirtual 698	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   667: invokevirtual 1161	java/lang/Object:getClass	()Ljava/lang/Class;
    //   670: ldc_w 291
    //   673: invokevirtual 876	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   676: ifeq +15 -> 691
    //   679: aload_3
    //   680: ldc_w 301
    //   683: invokevirtual 698	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   686: checkcast 291	java/lang/String
    //   689: astore 6
    //   691: aload_1
    //   692: astore 7
    //   694: aload_3
    //   695: ldc_w 688
    //   698: invokevirtual 698	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   701: ifnull +37 -> 738
    //   704: aload_1
    //   705: astore 7
    //   707: aload_3
    //   708: ldc_w 688
    //   711: invokevirtual 698	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   714: invokevirtual 1161	java/lang/Object:getClass	()Ljava/lang/Class;
    //   717: ldc_w 291
    //   720: invokevirtual 876	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   723: ifeq +15 -> 738
    //   726: aload_3
    //   727: ldc_w 688
    //   730: invokevirtual 698	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   733: checkcast 291	java/lang/String
    //   736: astore 7
    //   738: aload 8
    //   740: astore_1
    //   741: aload_3
    //   742: ldc_w 1231
    //   745: invokevirtual 698	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   748: ifnull +33 -> 781
    //   751: aload_3
    //   752: ldc_w 1231
    //   755: invokevirtual 698	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   758: invokevirtual 1161	java/lang/Object:getClass	()Ljava/lang/Class;
    //   761: ldc_w 291
    //   764: invokevirtual 876	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   767: ifeq +1726 -> 2493
    //   770: aload_3
    //   771: ldc_w 1231
    //   774: invokevirtual 698	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   777: checkcast 291	java/lang/String
    //   780: astore_1
    //   781: aload_3
    //   782: ldc_w 1233
    //   785: invokevirtual 698	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   788: ifnull +34 -> 822
    //   791: aload_3
    //   792: ldc_w 1233
    //   795: invokevirtual 698	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   798: invokevirtual 1161	java/lang/Object:getClass	()Ljava/lang/Class;
    //   801: ldc_w 291
    //   804: invokevirtual 876	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   807: ifeq +15 -> 822
    //   810: aload_3
    //   811: ldc_w 1233
    //   814: invokevirtual 698	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   817: checkcast 291	java/lang/String
    //   820: astore 8
    //   822: aload 14
    //   824: astore 8
    //   826: aload_3
    //   827: ldc_w 1235
    //   830: invokevirtual 698	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   833: ifnull +38 -> 871
    //   836: aload 14
    //   838: astore 8
    //   840: aload_3
    //   841: ldc_w 1235
    //   844: invokevirtual 698	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   847: invokevirtual 1161	java/lang/Object:getClass	()Ljava/lang/Class;
    //   850: ldc_w 291
    //   853: invokevirtual 876	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   856: ifeq +15 -> 871
    //   859: aload_3
    //   860: ldc_w 1235
    //   863: invokevirtual 698	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   866: checkcast 291	java/lang/String
    //   869: astore 8
    //   871: aload_3
    //   872: ldc_w 776
    //   875: invokevirtual 698	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   878: ifnull +39 -> 917
    //   881: aload_3
    //   882: ldc_w 776
    //   885: invokevirtual 698	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   888: invokevirtual 1161	java/lang/Object:getClass	()Ljava/lang/Class;
    //   891: ldc_w 700
    //   894: invokevirtual 876	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   897: ifeq +20 -> 917
    //   900: aload_0
    //   901: aload_3
    //   902: ldc_w 776
    //   905: invokevirtual 698	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   908: checkcast 700	java/lang/Boolean
    //   911: invokevirtual 703	java/lang/Boolean:booleanValue	()Z
    //   914: putfield 265	com/kochava/android/tracker/Feature:app_limit_tracking	Z
    //   917: aload_3
    //   918: ldc_w 794
    //   921: invokevirtual 698	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   924: ifnull +115 -> 1039
    //   927: aload_3
    //   928: ldc_w 794
    //   931: invokevirtual 698	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   934: instanceof 288
    //   937: ifeq +102 -> 1039
    //   940: aload_3
    //   941: ldc_w 794
    //   944: invokevirtual 698	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   947: checkcast 288	java/util/HashMap
    //   950: putstatic 1237	com/kochava/android/tracker/Feature:identityLinkMap	Ljava/util/Map;
    //   953: new 514	org/json/JSONObject
    //   956: dup
    //   957: invokespecial 675	org/json/JSONObject:<init>	()V
    //   960: putstatic 792	com/kochava/android/tracker/Feature:identityLinkMapJSON	Lorg/json/JSONObject;
    //   963: getstatic 1237	com/kochava/android/tracker/Feature:identityLinkMap	Ljava/util/Map;
    //   966: invokeinterface 846 1 0
    //   971: invokeinterface 849 1 0
    //   976: astore 9
    //   978: aload 9
    //   980: invokeinterface 570 1 0
    //   985: ifeq +54 -> 1039
    //   988: aload 9
    //   990: invokeinterface 574 1 0
    //   995: checkcast 851	java/util/Map$Entry
    //   998: astore 10
    //   1000: getstatic 792	com/kochava/android/tracker/Feature:identityLinkMapJSON	Lorg/json/JSONObject;
    //   1003: aload 10
    //   1005: invokeinterface 854 1 0
    //   1010: checkcast 291	java/lang/String
    //   1013: aload 10
    //   1015: invokeinterface 857 1 0
    //   1020: checkcast 291	java/lang/String
    //   1023: invokevirtual 517	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1026: pop
    //   1027: aload 9
    //   1029: invokeinterface 1240 1 0
    //   1034: goto -56 -> 978
    //   1037: astore 9
    //   1039: aload_3
    //   1040: ldc_w 800
    //   1043: invokevirtual 698	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1046: ifnull +36 -> 1082
    //   1049: aload_3
    //   1050: ldc_w 800
    //   1053: invokevirtual 698	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1056: invokevirtual 1161	java/lang/Object:getClass	()Ljava/lang/Class;
    //   1059: ldc_w 291
    //   1062: invokevirtual 876	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   1065: ifeq +17 -> 1082
    //   1068: aload_0
    //   1069: aload_3
    //   1070: ldc_w 800
    //   1073: invokevirtual 698	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1076: checkcast 291	java/lang/String
    //   1079: putfield 796	com/kochava/android/tracker/Feature:clickData	Ljava/lang/String;
    //   1082: aload 6
    //   1084: astore 9
    //   1086: aload_1
    //   1087: astore 10
    //   1089: aload 8
    //   1091: astore 11
    //   1093: aload 7
    //   1095: astore 12
    //   1097: aload 5
    //   1099: astore 13
    //   1101: aload_3
    //   1102: ldc_w 1241
    //   1105: invokevirtual 698	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1108: ifnull +115 -> 1223
    //   1111: aload 6
    //   1113: astore 9
    //   1115: aload_1
    //   1116: astore 10
    //   1118: aload 8
    //   1120: astore 11
    //   1122: aload 7
    //   1124: astore 12
    //   1126: aload 5
    //   1128: astore 13
    //   1130: aload_3
    //   1131: ldc_w 1241
    //   1134: invokevirtual 698	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1137: invokevirtual 1161	java/lang/Object:getClass	()Ljava/lang/Class;
    //   1140: ldc_w 1243
    //   1143: invokevirtual 876	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   1146: ifeq +77 -> 1223
    //   1149: aload_3
    //   1150: ldc_w 1241
    //   1153: invokevirtual 698	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1156: checkcast 1243	java/lang/Integer
    //   1159: invokevirtual 1246	java/lang/Integer:intValue	()I
    //   1162: istore 4
    //   1164: iload 4
    //   1166: iconst_1
    //   1167: if_icmpge +1374 -> 2541
    //   1170: new 494	java/lang/StringBuilder
    //   1173: dup
    //   1174: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   1177: ldc_w 1248
    //   1180: invokevirtual 509	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1183: iload 4
    //   1185: invokevirtual 903	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1188: ldc_w 1250
    //   1191: invokevirtual 509	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1194: invokevirtual 512	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1197: invokestatic 617	com/kochava/android/util/Logging:Log	(Ljava/lang/String;)V
    //   1200: iconst_1
    //   1201: putstatic 174	com/kochava/android/tracker/Feature:flushTimerSetByInitializer	Z
    //   1204: aload 5
    //   1206: astore 13
    //   1208: aload 7
    //   1210: astore 12
    //   1212: aload 8
    //   1214: astore 11
    //   1216: aload_1
    //   1217: astore 10
    //   1219: aload 6
    //   1221: astore 9
    //   1223: aload 11
    //   1225: ifnull +19 -> 1244
    //   1228: aload 11
    //   1230: invokevirtual 295	java/lang/String:trim	()Ljava/lang/String;
    //   1233: invokevirtual 299	java/lang/String:length	()I
    //   1236: ifeq +8 -> 1244
    //   1239: aload 11
    //   1241: putstatic 165	com/kochava/android/tracker/Feature:hostControl	Ljava/lang/String;
    //   1244: aload 10
    //   1246: ifnull +18 -> 1264
    //   1249: aload 10
    //   1251: ldc_w 1252
    //   1254: invokevirtual 1255	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1257: ifeq +7 -> 1264
    //   1260: iconst_1
    //   1261: putstatic 222	com/kochava/android/tracker/Feature:requestAttributionData	Z
    //   1264: getstatic 523	com/kochava/android/tracker/Feature:appContext	Landroid/content/Context;
    //   1267: ldc_w 1257
    //   1270: iconst_0
    //   1271: invokevirtual 531	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   1274: putstatic 381	com/kochava/android/tracker/Feature:attributionDataPrefs	Landroid/content/SharedPreferences;
    //   1277: aload 9
    //   1279: ifnull +1354 -> 2633
    //   1282: aload 9
    //   1284: invokevirtual 295	java/lang/String:trim	()Ljava/lang/String;
    //   1287: invokevirtual 299	java/lang/String:length	()I
    //   1290: ifeq +1343 -> 2633
    //   1293: aload 9
    //   1295: putstatic 486	com/kochava/android/tracker/Feature:mAppId	Ljava/lang/String;
    //   1298: aload_0
    //   1299: getfield 1225	com/kochava/android/tracker/Feature:kvinitdataholder	Lorg/json/JSONObject;
    //   1302: ldc_w 301
    //   1305: aload 9
    //   1307: invokevirtual 517	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1310: pop
    //   1311: aload_0
    //   1312: getfield 1227	com/kochava/android/tracker/Feature:kvinitorigdata	Lorg/json/JSONObject;
    //   1315: ldc_w 301
    //   1318: aload 9
    //   1320: invokevirtual 517	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1323: pop
    //   1324: getstatic 419	com/kochava/android/tracker/Feature:prefs	Landroid/content/SharedPreferences;
    //   1327: ldc_w 1259
    //   1330: ldc -93
    //   1332: invokeinterface 539 3 0
    //   1337: ldc -93
    //   1339: invokevirtual 543	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1342: ifeq +26 -> 1368
    //   1345: getstatic 419	com/kochava/android/tracker/Feature:prefs	Landroid/content/SharedPreferences;
    //   1348: invokeinterface 1040 1 0
    //   1353: ldc_w 1259
    //   1356: aload 9
    //   1358: invokeinterface 1046 3 0
    //   1363: invokeinterface 1049 1 0
    //   1368: aload_0
    //   1369: aload 12
    //   1371: invokespecial 324	com/kochava/android/tracker/Feature:setCurrency	(Ljava/lang/String;)V
    //   1374: aload_0
    //   1375: getfield 1223	com/kochava/android/tracker/Feature:kvinitdata	Lorg/json/JSONObject;
    //   1378: ldc_w 1261
    //   1381: aload_0
    //   1382: invokespecial 767	com/kochava/android/tracker/Feature:getAppPackageName	()Ljava/lang/String;
    //   1385: invokevirtual 517	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1388: pop
    //   1389: aload_0
    //   1390: getfield 1223	com/kochava/android/tracker/Feature:kvinitdata	Lorg/json/JSONObject;
    //   1393: ldc_w 1263
    //   1396: ldc_w 1265
    //   1399: invokevirtual 517	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1402: pop
    //   1403: aload_0
    //   1404: getfield 1223	com/kochava/android/tracker/Feature:kvinitdata	Lorg/json/JSONObject;
    //   1407: ldc_w 1267
    //   1410: ldc_w 1269
    //   1413: invokevirtual 517	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1416: pop
    //   1417: aload_0
    //   1418: getfield 1223	com/kochava/android/tracker/Feature:kvinitdata	Lorg/json/JSONObject;
    //   1421: ldc_w 688
    //   1424: getstatic 419	com/kochava/android/tracker/Feature:prefs	Landroid/content/SharedPreferences;
    //   1427: ldc_w 688
    //   1430: ldc_w 690
    //   1433: invokeinterface 539 3 0
    //   1438: invokevirtual 517	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1441: pop
    //   1442: aload_0
    //   1443: getfield 1227	com/kochava/android/tracker/Feature:kvinitorigdata	Lorg/json/JSONObject;
    //   1446: ldc_w 688
    //   1449: getstatic 419	com/kochava/android/tracker/Feature:prefs	Landroid/content/SharedPreferences;
    //   1452: ldc_w 688
    //   1455: ldc_w 690
    //   1458: invokeinterface 539 3 0
    //   1463: invokevirtual 517	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1466: pop
    //   1467: aload_0
    //   1468: getfield 1227	com/kochava/android/tracker/Feature:kvinitorigdata	Lorg/json/JSONObject;
    //   1471: ldc_w 1267
    //   1474: ldc_w 1269
    //   1477: invokevirtual 517	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1480: pop
    //   1481: aload_0
    //   1482: getfield 1227	com/kochava/android/tracker/Feature:kvinitorigdata	Lorg/json/JSONObject;
    //   1485: ldc_w 688
    //   1488: getstatic 419	com/kochava/android/tracker/Feature:prefs	Landroid/content/SharedPreferences;
    //   1491: ldc_w 688
    //   1494: ldc_w 690
    //   1497: invokeinterface 539 3 0
    //   1502: invokevirtual 517	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1505: pop
    //   1506: aload_0
    //   1507: getfield 1225	com/kochava/android/tracker/Feature:kvinitdataholder	Lorg/json/JSONObject;
    //   1510: ldc_w 733
    //   1513: new 494	java/lang/StringBuilder
    //   1516: dup
    //   1517: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   1520: ldc_w 735
    //   1523: invokevirtual 509	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1526: getstatic 167	com/kochava/android/tracker/Feature:versionExtension	Ljava/lang/String;
    //   1529: invokevirtual 509	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1532: invokevirtual 512	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1535: invokevirtual 517	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1538: pop
    //   1539: aload_0
    //   1540: getfield 1225	com/kochava/android/tracker/Feature:kvinitdataholder	Lorg/json/JSONObject;
    //   1543: ldc_w 1271
    //   1546: ldc_w 1273
    //   1549: invokevirtual 517	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1552: pop
    //   1553: aload_0
    //   1554: getfield 1225	com/kochava/android/tracker/Feature:kvinitdataholder	Lorg/json/JSONObject;
    //   1557: ldc_w 859
    //   1560: aload_0
    //   1561: getfield 1223	com/kochava/android/tracker/Feature:kvinitdata	Lorg/json/JSONObject;
    //   1564: invokevirtual 517	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1567: pop
    //   1568: aload_0
    //   1569: getfield 1225	com/kochava/android/tracker/Feature:kvinitdataholder	Lorg/json/JSONObject;
    //   1572: ldc_w 1275
    //   1575: aload_0
    //   1576: getfield 1227	com/kochava/android/tracker/Feature:kvinitorigdata	Lorg/json/JSONObject;
    //   1579: invokevirtual 517	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1582: pop
    //   1583: aload_0
    //   1584: getfield 1225	com/kochava/android/tracker/Feature:kvinitdataholder	Lorg/json/JSONObject;
    //   1587: ldc_w 679
    //   1590: ldc_w 1276
    //   1593: invokevirtual 517	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1596: pop
    //   1597: invokestatic 500	java/lang/System:currentTimeMillis	()J
    //   1600: ldc2_w 501
    //   1603: ldiv
    //   1604: putstatic 199	com/kochava/android/tracker/Feature:startTime	J
    //   1607: iconst_0
    //   1608: istore 4
    //   1610: ldc -93
    //   1612: astore_3
    //   1613: new 581	android/content/ComponentName
    //   1616: dup
    //   1617: getstatic 523	com/kochava/android/tracker/Feature:appContext	Landroid/content/Context;
    //   1620: ldc_w 1278
    //   1623: invokespecial 593	android/content/ComponentName:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   1626: astore_1
    //   1627: getstatic 523	com/kochava/android/tracker/Feature:appContext	Landroid/content/Context;
    //   1630: invokevirtual 1207	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   1633: aload_1
    //   1634: iconst_0
    //   1635: invokevirtual 1282	android/content/pm/PackageManager:getReceiverInfo	(Landroid/content/ComponentName;I)Landroid/content/pm/ActivityInfo;
    //   1638: pop
    //   1639: ldc_w 1284
    //   1642: invokestatic 617	com/kochava/android/util/Logging:Log	(Ljava/lang/String;)V
    //   1645: aload_3
    //   1646: astore_1
    //   1647: getstatic 523	com/kochava/android/tracker/Feature:appContext	Landroid/content/Context;
    //   1650: invokevirtual 1207	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   1653: ldc_w 1286
    //   1656: getstatic 523	com/kochava/android/tracker/Feature:appContext	Landroid/content/Context;
    //   1659: invokevirtual 1210	android/content/Context:getPackageName	()Ljava/lang/String;
    //   1662: invokevirtual 1289	android/content/pm/PackageManager:checkPermission	(Ljava/lang/String;Ljava/lang/String;)I
    //   1665: ifge +27 -> 1692
    //   1668: iconst_1
    //   1669: istore 4
    //   1671: new 494	java/lang/StringBuilder
    //   1674: dup
    //   1675: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   1678: aload_3
    //   1679: invokevirtual 509	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1682: ldc_w 1291
    //   1685: invokevirtual 509	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1688: invokevirtual 512	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1691: astore_1
    //   1692: aload_1
    //   1693: astore_3
    //   1694: getstatic 523	com/kochava/android/tracker/Feature:appContext	Landroid/content/Context;
    //   1697: invokevirtual 1207	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   1700: ldc_w 1293
    //   1703: getstatic 523	com/kochava/android/tracker/Feature:appContext	Landroid/content/Context;
    //   1706: invokevirtual 1210	android/content/Context:getPackageName	()Ljava/lang/String;
    //   1709: invokevirtual 1289	android/content/pm/PackageManager:checkPermission	(Ljava/lang/String;Ljava/lang/String;)I
    //   1712: ifge +27 -> 1739
    //   1715: iconst_1
    //   1716: istore 4
    //   1718: new 494	java/lang/StringBuilder
    //   1721: dup
    //   1722: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   1725: aload_1
    //   1726: invokevirtual 509	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1729: ldc_w 1295
    //   1732: invokevirtual 509	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1735: invokevirtual 512	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1738: astore_3
    //   1739: aload_3
    //   1740: astore_1
    //   1741: getstatic 523	com/kochava/android/tracker/Feature:appContext	Landroid/content/Context;
    //   1744: invokevirtual 1207	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   1747: ldc_w 1297
    //   1750: getstatic 523	com/kochava/android/tracker/Feature:appContext	Landroid/content/Context;
    //   1753: invokevirtual 1210	android/content/Context:getPackageName	()Ljava/lang/String;
    //   1756: invokevirtual 1289	android/content/pm/PackageManager:checkPermission	(Ljava/lang/String;Ljava/lang/String;)I
    //   1759: ifge +27 -> 1786
    //   1762: iconst_1
    //   1763: istore 4
    //   1765: new 494	java/lang/StringBuilder
    //   1768: dup
    //   1769: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   1772: aload_3
    //   1773: invokevirtual 509	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1776: ldc_w 1299
    //   1779: invokevirtual 509	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1782: invokevirtual 512	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1785: astore_1
    //   1786: iload 4
    //   1788: ifeq +13 -> 1801
    //   1791: ldc_w 1301
    //   1794: invokestatic 1304	com/kochava/android/util/Logging:LogRequirementsError	(Ljava/lang/String;)V
    //   1797: aload_1
    //   1798: invokestatic 1304	com/kochava/android/util/Logging:LogRequirementsError	(Ljava/lang/String;)V
    //   1801: getstatic 523	com/kochava/android/tracker/Feature:appContext	Landroid/content/Context;
    //   1804: ldc_w 1306
    //   1807: invokevirtual 816	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   1810: checkcast 1308	android/telephony/TelephonyManager
    //   1813: invokevirtual 1311	android/telephony/TelephonyManager:getNetworkOperatorName	()Ljava/lang/String;
    //   1816: putstatic 747	com/kochava/android/tracker/Feature:carrier	Ljava/lang/String;
    //   1819: getstatic 523	com/kochava/android/tracker/Feature:appContext	Landroid/content/Context;
    //   1822: ldc_w 1313
    //   1825: invokevirtual 816	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   1828: checkcast 1315	android/net/wifi/WifiManager
    //   1831: invokevirtual 1319	android/net/wifi/WifiManager:getConnectionInfo	()Landroid/net/wifi/WifiInfo;
    //   1834: invokevirtual 1324	android/net/wifi/WifiInfo:getBSSID	()Ljava/lang/String;
    //   1837: putstatic 743	com/kochava/android/tracker/Feature:bssid	Ljava/lang/String;
    //   1840: getstatic 419	com/kochava/android/tracker/Feature:prefs	Landroid/content/SharedPreferences;
    //   1843: ldc_w 1326
    //   1846: ldc -93
    //   1848: invokeinterface 539 3 0
    //   1853: ldc -93
    //   1855: invokevirtual 543	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1858: ifeq +28 -> 1886
    //   1861: getstatic 419	com/kochava/android/tracker/Feature:prefs	Landroid/content/SharedPreferences;
    //   1864: invokeinterface 1040 1 0
    //   1869: ldc_w 1326
    //   1872: aload_0
    //   1873: invokespecial 403	com/kochava/android/tracker/Feature:getUserAgent	()Ljava/lang/String;
    //   1876: invokeinterface 1046 3 0
    //   1881: invokeinterface 1049 1 0
    //   1886: aload_0
    //   1887: invokestatic 480	com/kochava/android/tracker/Feature:getBrand	()Ljava/lang/String;
    //   1890: putfield 1328	com/kochava/android/tracker/Feature:mCarrier	Ljava/lang/String;
    //   1893: aload_0
    //   1894: invokestatic 476	com/kochava/android/tracker/Feature:getModel	()Ljava/lang/String;
    //   1897: putfield 1330	com/kochava/android/tracker/Feature:mModel	Ljava/lang/String;
    //   1900: aload_0
    //   1901: ldc_w 1332
    //   1904: putfield 943	com/kochava/android/tracker/Feature:mAppName	Ljava/lang/String;
    //   1907: aload_0
    //   1908: ldc_w 1334
    //   1911: putfield 947	com/kochava/android/tracker/Feature:mAppVersionCode	Ljava/lang/String;
    //   1914: aload_0
    //   1915: ldc -93
    //   1917: putfield 392	com/kochava/android/tracker/Feature:mAppVersionName	Ljava/lang/String;
    //   1920: getstatic 523	com/kochava/android/tracker/Feature:appContext	Landroid/content/Context;
    //   1923: invokevirtual 1143	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   1926: invokevirtual 1207	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   1929: astore_3
    //   1930: aload_3
    //   1931: getstatic 523	com/kochava/android/tracker/Feature:appContext	Landroid/content/Context;
    //   1934: invokevirtual 1210	android/content/Context:getPackageName	()Ljava/lang/String;
    //   1937: iconst_0
    //   1938: invokevirtual 1338	android/content/pm/PackageManager:getApplicationInfo	(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    //   1941: astore_1
    //   1942: aload_1
    //   1943: ifnull +1034 -> 2977
    //   1946: aload_3
    //   1947: aload_1
    //   1948: invokevirtual 1342	android/content/pm/PackageManager:getApplicationLabel	(Landroid/content/pm/ApplicationInfo;)Ljava/lang/CharSequence;
    //   1951: astore_1
    //   1952: aload_0
    //   1953: aload_1
    //   1954: checkcast 291	java/lang/String
    //   1957: checkcast 291	java/lang/String
    //   1960: putfield 943	com/kochava/android/tracker/Feature:mAppName	Ljava/lang/String;
    //   1963: new 494	java/lang/StringBuilder
    //   1966: dup
    //   1967: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   1970: ldc_w 1344
    //   1973: invokevirtual 509	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1976: aload_0
    //   1977: getfield 943	com/kochava/android/tracker/Feature:mAppName	Ljava/lang/String;
    //   1980: invokevirtual 509	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1983: invokevirtual 512	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1986: invokestatic 617	com/kochava/android/util/Logging:Log	(Ljava/lang/String;)V
    //   1989: aload_0
    //   1990: new 494	java/lang/StringBuilder
    //   1993: dup
    //   1994: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   1997: getstatic 523	com/kochava/android/tracker/Feature:appContext	Landroid/content/Context;
    //   2000: invokevirtual 1207	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   2003: getstatic 523	com/kochava/android/tracker/Feature:appContext	Landroid/content/Context;
    //   2006: invokevirtual 1210	android/content/Context:getPackageName	()Ljava/lang/String;
    //   2009: iconst_0
    //   2010: invokevirtual 1216	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   2013: getfield 1347	android/content/pm/PackageInfo:versionCode	I
    //   2016: invokevirtual 903	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2019: ldc -93
    //   2021: invokevirtual 509	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2024: invokevirtual 512	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2027: putfield 947	com/kochava/android/tracker/Feature:mAppVersionCode	Ljava/lang/String;
    //   2030: new 494	java/lang/StringBuilder
    //   2033: dup
    //   2034: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   2037: ldc_w 1349
    //   2040: invokevirtual 509	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2043: aload_0
    //   2044: getfield 947	com/kochava/android/tracker/Feature:mAppVersionCode	Ljava/lang/String;
    //   2047: invokevirtual 509	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2050: invokevirtual 512	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2053: invokestatic 617	com/kochava/android/util/Logging:Log	(Ljava/lang/String;)V
    //   2056: aload_0
    //   2057: getstatic 523	com/kochava/android/tracker/Feature:appContext	Landroid/content/Context;
    //   2060: invokevirtual 1207	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   2063: getstatic 523	com/kochava/android/tracker/Feature:appContext	Landroid/content/Context;
    //   2066: invokevirtual 1210	android/content/Context:getPackageName	()Ljava/lang/String;
    //   2069: iconst_0
    //   2070: invokevirtual 1216	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   2073: getfield 1352	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   2076: putfield 392	com/kochava/android/tracker/Feature:mAppVersionName	Ljava/lang/String;
    //   2079: new 494	java/lang/StringBuilder
    //   2082: dup
    //   2083: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   2086: ldc_w 1354
    //   2089: invokevirtual 509	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2092: aload_0
    //   2093: getfield 392	com/kochava/android/tracker/Feature:mAppVersionName	Ljava/lang/String;
    //   2096: invokevirtual 509	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2099: invokevirtual 512	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2102: invokestatic 617	com/kochava/android/util/Logging:Log	(Ljava/lang/String;)V
    //   2105: getstatic 523	com/kochava/android/tracker/Feature:appContext	Landroid/content/Context;
    //   2108: ldc_w 812
    //   2111: invokevirtual 816	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   2114: checkcast 818	android/view/WindowManager
    //   2117: astore_1
    //   2118: aload_0
    //   2119: aload_1
    //   2120: invokeinterface 825 1 0
    //   2125: invokevirtual 1357	android/view/Display:getHeight	()I
    //   2128: putfield 758	com/kochava/android/tracker/Feature:mDisplayHeight	I
    //   2131: aload_0
    //   2132: aload_1
    //   2133: invokeinterface 825 1 0
    //   2138: invokevirtual 1360	android/view/Display:getWidth	()I
    //   2141: putfield 762	com/kochava/android/tracker/Feature:mDisplayWidth	I
    //   2144: new 494	java/lang/StringBuilder
    //   2147: dup
    //   2148: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   2151: ldc_w 1362
    //   2154: invokevirtual 509	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2157: aload_0
    //   2158: getfield 758	com/kochava/android/tracker/Feature:mDisplayHeight	I
    //   2161: invokevirtual 903	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2164: ldc_w 1364
    //   2167: invokevirtual 509	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2170: aload_0
    //   2171: getfield 762	com/kochava/android/tracker/Feature:mDisplayWidth	I
    //   2174: invokevirtual 903	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2177: invokevirtual 512	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2180: invokestatic 617	com/kochava/android/util/Logging:Log	(Ljava/lang/String;)V
    //   2183: new 40	com/kochava/android/tracker/Feature$5
    //   2186: dup
    //   2187: aload_0
    //   2188: invokespecial 1365	com/kochava/android/tracker/Feature$5:<init>	(Lcom/kochava/android/tracker/Feature;)V
    //   2191: invokevirtual 656	java/lang/Thread:start	()V
    //   2194: aload_0
    //   2195: invokestatic 377	com/kochava/android/tracker/Feature:getMyDeviceId	()Ljava/lang/String;
    //   2198: putfield 1367	com/kochava/android/tracker/Feature:mDeviceId	Ljava/lang/String;
    //   2201: aload_0
    //   2202: getfield 1225	com/kochava/android/tracker/Feature:kvinitdataholder	Lorg/json/JSONObject;
    //   2205: ldc_w 677
    //   2208: invokestatic 377	com/kochava/android/tracker/Feature:getMyDeviceId	()Ljava/lang/String;
    //   2211: invokevirtual 517	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2214: pop
    //   2215: getstatic 419	com/kochava/android/tracker/Feature:prefs	Landroid/content/SharedPreferences;
    //   2218: ldc_w 1369
    //   2221: ldc -93
    //   2223: invokeinterface 539 3 0
    //   2228: ldc_w 1252
    //   2231: invokevirtual 543	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2234: ifne +147 -> 2381
    //   2237: getstatic 523	com/kochava/android/tracker/Feature:appContext	Landroid/content/Context;
    //   2240: invokevirtual 1207	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   2243: astore 5
    //   2245: aload 5
    //   2247: sipush 128
    //   2250: invokevirtual 1373	android/content/pm/PackageManager:getInstalledApplications	(I)Ljava/util/List;
    //   2253: invokeinterface 708 1 0
    //   2258: astore 6
    //   2260: aload 6
    //   2262: invokeinterface 570 1 0
    //   2267: ifeq +114 -> 2381
    //   2270: aload 6
    //   2272: invokeinterface 574 1 0
    //   2277: checkcast 1375	android/content/pm/ApplicationInfo
    //   2280: astore 7
    //   2282: aload 7
    //   2284: invokestatic 1379	com/kochava/android/tracker/Feature:isSystemPackage	(Landroid/content/pm/ApplicationInfo;)Z
    //   2287: istore_2
    //   2288: iload_2
    //   2289: ifne -29 -> 2260
    //   2292: aconst_null
    //   2293: astore_1
    //   2294: aload 5
    //   2296: aload 7
    //   2298: getfield 1380	android/content/pm/ApplicationInfo:packageName	Ljava/lang/String;
    //   2301: iconst_0
    //   2302: invokevirtual 1216	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   2305: astore_3
    //   2306: aload_3
    //   2307: astore_1
    //   2308: aload_1
    //   2309: ifnull -49 -> 2260
    //   2312: getstatic 206	com/kochava/android/tracker/Feature:installedApps	Ljava/util/List;
    //   2315: new 53	com/kochava/android/tracker/Feature$ApplicationInfoHolder
    //   2318: dup
    //   2319: aload_0
    //   2320: aload_1
    //   2321: getfield 1221	android/content/pm/PackageInfo:packageName	Ljava/lang/String;
    //   2324: new 494	java/lang/StringBuilder
    //   2327: dup
    //   2328: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   2331: aload_1
    //   2332: getfield 1383	android/content/pm/PackageInfo:firstInstallTime	J
    //   2335: invokevirtual 506	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2338: ldc -93
    //   2340: invokevirtual 509	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2343: invokevirtual 512	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2346: new 494	java/lang/StringBuilder
    //   2349: dup
    //   2350: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   2353: aload_1
    //   2354: getfield 1386	android/content/pm/PackageInfo:lastUpdateTime	J
    //   2357: invokevirtual 506	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2360: ldc -93
    //   2362: invokevirtual 509	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2365: invokevirtual 512	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2368: invokespecial 1389	com/kochava/android/tracker/Feature$ApplicationInfoHolder:<init>	(Lcom/kochava/android/tracker/Feature;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2371: invokeinterface 1392 2 0
    //   2376: pop
    //   2377: goto -117 -> 2260
    //   2380: astore_1
    //   2381: getstatic 236	com/kochava/android/tracker/Feature:worker	Ljava/util/concurrent/ScheduledExecutorService;
    //   2384: aload_0
    //   2385: getfield 272	com/kochava/android/tracker/Feature:getKVinit	Ljava/lang/Runnable;
    //   2388: ldc2_w 1393
    //   2391: getstatic 1400	java/util/concurrent/TimeUnit:SECONDS	Ljava/util/concurrent/TimeUnit;
    //   2394: invokeinterface 1405 5 0
    //   2399: pop
    //   2400: aload_0
    //   2401: ldc_w 1276
    //   2404: invokevirtual 1408	com/kochava/android/tracker/Feature:tryUpdate	(Ljava/lang/String;)V
    //   2407: return
    //   2408: astore_1
    //   2409: ldc_w 1410
    //   2412: invokestatic 561	com/kochava/android/util/Logging:LogError	(Ljava/lang/String;)V
    //   2415: aload_1
    //   2416: invokevirtual 840	java/lang/Exception:printStackTrace	()V
    //   2419: iconst_1
    //   2420: putstatic 216	com/kochava/android/tracker/Feature:badInit	Z
    //   2423: return
    //   2424: ldc_w 1412
    //   2427: invokestatic 561	com/kochava/android/util/Logging:LogError	(Ljava/lang/String;)V
    //   2430: iconst_1
    //   2431: putstatic 216	com/kochava/android/tracker/Feature:badInit	Z
    //   2434: return
    //   2435: astore_1
    //   2436: new 494	java/lang/StringBuilder
    //   2439: dup
    //   2440: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   2443: ldc_w 1414
    //   2446: invokevirtual 509	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2449: aload_1
    //   2450: invokevirtual 929	java/lang/Exception:toString	()Ljava/lang/String;
    //   2453: invokevirtual 509	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2456: invokevirtual 512	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2459: invokestatic 617	com/kochava/android/util/Logging:Log	(Ljava/lang/String;)V
    //   2462: goto -2066 -> 396
    //   2465: new 494	java/lang/StringBuilder
    //   2468: dup
    //   2469: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   2472: ldc_w 1416
    //   2475: invokevirtual 509	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2478: getstatic 169	com/kochava/android/tracker/Feature:overrideAutomaticSessions	Z
    //   2481: invokevirtual 614	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2484: invokevirtual 512	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2487: invokestatic 617	com/kochava/android/util/Logging:Log	(Ljava/lang/String;)V
    //   2490: goto -2016 -> 474
    //   2493: aload 8
    //   2495: astore_1
    //   2496: aload_3
    //   2497: ldc_w 1231
    //   2500: invokevirtual 698	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2503: invokevirtual 1161	java/lang/Object:getClass	()Ljava/lang/Class;
    //   2506: ldc_w 700
    //   2509: invokevirtual 876	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   2512: ifeq -1731 -> 781
    //   2515: aload 8
    //   2517: astore_1
    //   2518: aload_3
    //   2519: ldc_w 1231
    //   2522: invokevirtual 698	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2525: checkcast 700	java/lang/Boolean
    //   2528: invokevirtual 703	java/lang/Boolean:booleanValue	()Z
    //   2531: ifeq -1750 -> 781
    //   2534: ldc_w 1252
    //   2537: astore_1
    //   2538: goto -1757 -> 781
    //   2541: iload 4
    //   2543: sipush 360
    //   2546: if_icmple +42 -> 2588
    //   2549: new 494	java/lang/StringBuilder
    //   2552: dup
    //   2553: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   2556: ldc_w 1248
    //   2559: invokevirtual 509	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2562: iload 4
    //   2564: invokevirtual 903	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2567: ldc_w 1418
    //   2570: invokevirtual 509	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2573: invokevirtual 512	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2576: invokestatic 617	com/kochava/android/util/Logging:Log	(Ljava/lang/String;)V
    //   2579: ldc_w 1419
    //   2582: putstatic 172	com/kochava/android/tracker/Feature:flush_rate	I
    //   2585: goto -1385 -> 1200
    //   2588: iload 4
    //   2590: bipush 60
    //   2592: imul
    //   2593: sipush 1000
    //   2596: imul
    //   2597: putstatic 172	com/kochava/android/tracker/Feature:flush_rate	I
    //   2600: new 494	java/lang/StringBuilder
    //   2603: dup
    //   2604: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   2607: ldc_w 1421
    //   2610: invokevirtual 509	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2613: iload 4
    //   2615: invokevirtual 903	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2618: ldc_w 1423
    //   2621: invokevirtual 509	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2624: invokevirtual 512	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2627: invokestatic 617	com/kochava/android/util/Logging:Log	(Ljava/lang/String;)V
    //   2630: goto -1430 -> 1200
    //   2633: aload 13
    //   2635: ifnull +178 -> 2813
    //   2638: aload 13
    //   2640: invokevirtual 295	java/lang/String:trim	()Ljava/lang/String;
    //   2643: invokevirtual 299	java/lang/String:length	()I
    //   2646: ifeq +167 -> 2813
    //   2649: aload_0
    //   2650: getfield 1223	com/kochava/android/tracker/Feature:kvinitdata	Lorg/json/JSONObject;
    //   2653: ldc_w 1229
    //   2656: aload 13
    //   2658: invokevirtual 517	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2661: pop
    //   2662: getstatic 419	com/kochava/android/tracker/Feature:prefs	Landroid/content/SharedPreferences;
    //   2665: ldc_w 1259
    //   2668: ldc -93
    //   2670: invokeinterface 539 3 0
    //   2675: ldc -93
    //   2677: invokevirtual 543	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2680: ifeq +26 -> 2706
    //   2683: getstatic 419	com/kochava/android/tracker/Feature:prefs	Landroid/content/SharedPreferences;
    //   2686: invokeinterface 1040 1 0
    //   2691: ldc_w 1259
    //   2694: aload 13
    //   2696: invokeinterface 1046 3 0
    //   2701: invokeinterface 1049 1 0
    //   2706: aload 9
    //   2708: ifnull +78 -> 2786
    //   2711: aload 9
    //   2713: invokevirtual 295	java/lang/String:trim	()Ljava/lang/String;
    //   2716: invokevirtual 299	java/lang/String:length	()I
    //   2719: ifeq +67 -> 2786
    //   2722: aload 9
    //   2724: putstatic 486	com/kochava/android/tracker/Feature:mAppId	Ljava/lang/String;
    //   2727: aload_0
    //   2728: getfield 1225	com/kochava/android/tracker/Feature:kvinitdataholder	Lorg/json/JSONObject;
    //   2731: ldc_w 301
    //   2734: aload 9
    //   2736: invokevirtual 517	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2739: pop
    //   2740: aload_0
    //   2741: getfield 1227	com/kochava/android/tracker/Feature:kvinitorigdata	Lorg/json/JSONObject;
    //   2744: ldc_w 301
    //   2747: aload 9
    //   2749: invokevirtual 517	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2752: pop
    //   2753: goto -1385 -> 1368
    //   2756: astore_1
    //   2757: new 494	java/lang/StringBuilder
    //   2760: dup
    //   2761: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   2764: ldc_w 1425
    //   2767: invokevirtual 509	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2770: aload_1
    //   2771: invokevirtual 1426	org/json/JSONException:toString	()Ljava/lang/String;
    //   2774: invokevirtual 509	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2777: invokevirtual 512	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2780: invokestatic 561	com/kochava/android/util/Logging:LogError	(Ljava/lang/String;)V
    //   2783: goto -1186 -> 1597
    //   2786: new 494	java/lang/StringBuilder
    //   2789: dup
    //   2790: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   2793: ldc_w 1428
    //   2796: invokevirtual 509	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2799: aload 13
    //   2801: invokevirtual 509	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2804: invokevirtual 512	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2807: putstatic 486	com/kochava/android/tracker/Feature:mAppId	Ljava/lang/String;
    //   2810: goto -1442 -> 1368
    //   2813: ldc_w 1430
    //   2816: invokestatic 561	com/kochava/android/util/Logging:LogError	(Ljava/lang/String;)V
    //   2819: iconst_1
    //   2820: putstatic 216	com/kochava/android/tracker/Feature:badInit	Z
    //   2823: return
    //   2824: astore_1
    //   2825: iconst_1
    //   2826: istore 4
    //   2828: new 494	java/lang/StringBuilder
    //   2831: dup
    //   2832: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   2835: ldc -93
    //   2837: invokevirtual 509	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2840: ldc_w 1432
    //   2843: invokevirtual 509	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2846: invokevirtual 512	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2849: astore_3
    //   2850: goto -1205 -> 1645
    //   2853: astore_1
    //   2854: new 494	java/lang/StringBuilder
    //   2857: dup
    //   2858: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   2861: ldc_w 1434
    //   2864: invokevirtual 509	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2867: aload_1
    //   2868: invokevirtual 929	java/lang/Exception:toString	()Ljava/lang/String;
    //   2871: invokevirtual 509	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2874: invokevirtual 512	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2877: invokestatic 561	com/kochava/android/util/Logging:LogError	(Ljava/lang/String;)V
    //   2880: goto -1061 -> 1819
    //   2883: astore_1
    //   2884: new 494	java/lang/StringBuilder
    //   2887: dup
    //   2888: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   2891: ldc_w 1436
    //   2894: invokevirtual 509	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2897: aload_1
    //   2898: invokevirtual 929	java/lang/Exception:toString	()Ljava/lang/String;
    //   2901: invokevirtual 509	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2904: invokevirtual 512	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2907: invokestatic 617	com/kochava/android/util/Logging:Log	(Ljava/lang/String;)V
    //   2910: goto -1070 -> 1840
    //   2913: astore 5
    //   2915: aconst_null
    //   2916: astore_1
    //   2917: new 494	java/lang/StringBuilder
    //   2920: dup
    //   2921: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   2924: ldc_w 1438
    //   2927: invokevirtual 509	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2930: aload 5
    //   2932: invokevirtual 1439	android/content/pm/PackageManager$NameNotFoundException:toString	()Ljava/lang/String;
    //   2935: invokevirtual 509	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2938: invokevirtual 512	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2941: invokestatic 561	com/kochava/android/util/Logging:LogError	(Ljava/lang/String;)V
    //   2944: goto -1002 -> 1942
    //   2947: astore_1
    //   2948: new 494	java/lang/StringBuilder
    //   2951: dup
    //   2952: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   2955: ldc_w 1438
    //   2958: invokevirtual 509	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2961: aload_1
    //   2962: invokevirtual 929	java/lang/Exception:toString	()Ljava/lang/String;
    //   2965: invokevirtual 509	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2968: invokevirtual 512	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2971: invokestatic 561	com/kochava/android/util/Logging:LogError	(Ljava/lang/String;)V
    //   2974: goto -985 -> 1989
    //   2977: ldc_w 1441
    //   2980: astore_1
    //   2981: goto -1029 -> 1952
    //   2984: astore_1
    //   2985: new 494	java/lang/StringBuilder
    //   2988: dup
    //   2989: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   2992: ldc_w 1443
    //   2995: invokevirtual 509	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2998: aload_1
    //   2999: invokevirtual 929	java/lang/Exception:toString	()Ljava/lang/String;
    //   3002: invokevirtual 509	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3005: invokevirtual 512	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3008: invokestatic 561	com/kochava/android/util/Logging:LogError	(Ljava/lang/String;)V
    //   3011: goto -955 -> 2056
    //   3014: astore_1
    //   3015: new 494	java/lang/StringBuilder
    //   3018: dup
    //   3019: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   3022: ldc_w 1445
    //   3025: invokevirtual 509	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3028: aload_1
    //   3029: invokevirtual 929	java/lang/Exception:toString	()Ljava/lang/String;
    //   3032: invokevirtual 509	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3035: invokevirtual 512	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3038: invokestatic 561	com/kochava/android/util/Logging:LogError	(Ljava/lang/String;)V
    //   3041: goto -936 -> 2105
    //   3044: astore_1
    //   3045: new 494	java/lang/StringBuilder
    //   3048: dup
    //   3049: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   3052: ldc_w 1447
    //   3055: invokevirtual 509	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3058: aload_1
    //   3059: invokevirtual 929	java/lang/Exception:toString	()Ljava/lang/String;
    //   3062: invokevirtual 509	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3065: invokevirtual 512	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3068: invokestatic 561	com/kochava/android/util/Logging:LogError	(Ljava/lang/String;)V
    //   3071: goto -888 -> 2183
    //   3074: astore_1
    //   3075: getstatic 726	com/kochava/android/tracker/Global:DEBUGERROR	Z
    //   3078: ifeq -863 -> 2215
    //   3081: aload_1
    //   3082: invokevirtual 729	org/json/JSONException:printStackTrace	()V
    //   3085: goto -870 -> 2215
    //   3088: astore_3
    //   3089: new 494	java/lang/StringBuilder
    //   3092: dup
    //   3093: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   3096: ldc_w 1449
    //   3099: invokevirtual 509	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3102: aload 7
    //   3104: getfield 1380	android/content/pm/ApplicationInfo:packageName	Ljava/lang/String;
    //   3107: invokevirtual 509	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3110: ldc_w 1451
    //   3113: invokevirtual 509	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3116: aload_3
    //   3117: invokevirtual 1439	android/content/pm/PackageManager$NameNotFoundException:toString	()Ljava/lang/String;
    //   3120: invokevirtual 509	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3123: invokevirtual 512	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3126: invokestatic 561	com/kochava/android/util/Logging:LogError	(Ljava/lang/String;)V
    //   3129: goto -821 -> 2308
    //   3132: astore_1
    //   3133: goto -2608 -> 525
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3136	0	this	Feature
    //   0	3136	1	paramContext	Context
    //   0	3136	2	paramBoolean	boolean
    //   0	3136	3	paramHashMap	HashMap<String, Object>
    //   1162	1665	4	i	int
    //   595	1700	5	localObject1	Object
    //   2913	18	5	localNameNotFoundException	android.content.pm.PackageManager.NameNotFoundException
    //   562	1709	6	localObject2	Object
    //   568	2535	7	localObject3	Object
    //   578	1938	8	localObject4	Object
    //   565	463	9	localIterator	Iterator
    //   1037	1	9	localException	Exception
    //   1084	1664	9	localObject5	Object
    //   575	675	10	localObject6	Object
    //   581	659	11	localObject7	Object
    //   587	783	12	localObject8	Object
    //   559	2241	13	localObject9	Object
    //   584	253	14	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   940	978	1037	java/lang/Exception
    //   978	1034	1037	java/lang/Exception
    //   2215	2260	2380	java/lang/Exception
    //   2260	2288	2380	java/lang/Exception
    //   2294	2306	2380	java/lang/Exception
    //   2312	2377	2380	java/lang/Exception
    //   3089	3129	2380	java/lang/Exception
    //   4	11	2408	java/lang/Exception
    //   373	396	2435	java/lang/Exception
    //   1282	1368	2756	org/json/JSONException
    //   1368	1597	2756	org/json/JSONException
    //   2638	2706	2756	org/json/JSONException
    //   2711	2753	2756	org/json/JSONException
    //   2786	2810	2756	org/json/JSONException
    //   2813	2823	2756	org/json/JSONException
    //   1627	1645	2824	android/content/pm/PackageManager$NameNotFoundException
    //   1801	1819	2853	java/lang/Exception
    //   1819	1840	2883	java/lang/Exception
    //   1930	1942	2913	android/content/pm/PackageManager$NameNotFoundException
    //   1920	1930	2947	java/lang/Exception
    //   1930	1942	2947	java/lang/Exception
    //   1946	1952	2947	java/lang/Exception
    //   1952	1989	2947	java/lang/Exception
    //   2917	2944	2947	java/lang/Exception
    //   1989	2056	2984	java/lang/Exception
    //   2056	2105	3014	java/lang/Exception
    //   2105	2183	3044	java/lang/Exception
    //   2201	2215	3074	org/json/JSONException
    //   2294	2306	3088	android/content/pm/PackageManager$NameNotFoundException
    //   502	525	3132	java/lang/Exception
  }
  
  private void initHandler()
  {
    if (initHandler == null) {
      initHandler = new Handler()
      {
        public void handleMessage(Message paramAnonymousMessage)
        {
          boolean bool = paramAnonymousMessage.getData().getBoolean("sendonstart");
          Feature.this.initialHandlerActions();
          if (!bool)
          {
            initTimer.schedule(new TimerTask()
            {
              public void run()
              {
                Logging.Log("Reached 10 min mark w/o sending initial, sending now.");
                Feature.this.queInitial(false);
              }
            }, 600000L);
            return;
          }
          initTimer.schedule(new TimerTask()
          {
            public void run()
            {
              Logging.Log("Scheduling timer to que initial event if needed.");
              Feature.this.queInitial(false);
            }
          }, 2000L);
          Feature.access$4802(Feature.this, new Timer());
          mTimerSendOnBegin.schedule(new TimerTask()
          {
            public void run() {}
          }, 4000L);
        }
      };
    }
  }
  
  private void initialHandlerActions()
  {
    int j = 0;
    prefs = appContext.getSharedPreferences("initPrefs", 0);
    if (prefs.getString("initBool", "").equals("")) {
      prefs.edit().putString("initBool", "false").apply();
    }
    String str1;
    String str2;
    if (prefs.getString("kochavaappdata", null) != null)
    {
      str1 = kDbAdapter.getApplicationData(prefs.getString("kochavaappdata", null));
      str2 = createAppData();
      Logging.Log("Stored Data: " + str1);
      Logging.Log("Created Data: " + str2);
      if (str1 == null) {
        kDbAdapter.insertApplicationData(prefs.getString("kochavaappdata", null), str2);
      }
    }
    for (;;)
    {
      if ((mIsStartOfLife) || ((!prefs.getString("initBool", "").equals("")) && (prefs.getString("initBool", "").equals("false"))))
      {
        Logging.Log("Initial event has not yet been qued in the database, making initial call");
        fireEvent("initial", null);
      }
      int i;
      if (!should_flush_in_background)
      {
        i = j;
        if (!should_flush_in_background)
        {
          i = j;
          if (is_in_background) {}
        }
      }
      else
      {
        i = 1;
      }
      if ((i != 0) && (mTimer == null))
      {
        mTimer = new Timer();
        mTimer.schedule(new TimerTask()
        {
          public void run()
          {
            if ((Feature.flushTimerSetByKVinitResponse) && (System.currentTimeMillis() - Feature.lastEventTimestamp < Feature.flush_rate))
            {
              Logging.Log("Too soon since last event, flush timer waiting for next flush attempt.");
              return;
            }
            Feature.flush();
          }
        }, 0L, flush_rate);
      }
      initTimer = new Timer();
      return;
      if (!str1.equals(str2))
      {
        kDbAdapter.updateApplicationData(prefs.getString("kochavaappdata", null), str2);
      }
      else
      {
        Logging.Log("Set start of life to false");
        mIsStartOfLife = false;
        continue;
        mIsStartOfLife = false;
      }
    }
  }
  
  private static boolean isEmailValid(String paramString)
  {
    boolean bool = false;
    if (Pattern.compile("^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$", 2).matcher(paramString).matches()) {
      bool = true;
    }
    return bool;
  }
  
  private static boolean isSystemPackage(ApplicationInfo paramApplicationInfo)
  {
    return (flags & 0x1) != 0;
  }
  
  private static boolean oldLocationTooStale()
  {
    long l3 = LocationDirector.staleness * 60 * 1000;
    long l2 = 0L;
    long l1 = l2;
    if (prefs != null)
    {
      l1 = l2;
      if (prefs.getLong("kochava_old_loc_timestamp", 0L) != 0L) {
        l1 = prefs.getLong("kochava_old_loc_timestamp", 0L);
      }
    }
    if (l1 == 0L) {}
    while (System.currentTimeMillis() - l1 >= l3) {
      return true;
    }
    return false;
  }
  
  private static String postEvent()
  {
    Object localObject1;
    if (!prefs.getString("initBool", "").equals("true"))
    {
      Logging.Log("PREF_INIT not true, waiting for initial to be queued");
      localObject1 = "";
    }
    Object localObject3;
    long l;
    for (;;)
    {
      return (String)localObject1;
      localObject1 = kDbAdapter.generateDataString();
      if (localObject1 == null) {
        return "";
      }
      localObject3 = new String[2];
      localObject1 = ((String)localObject1).split("=", 2);
      l = Long.parseLong(localObject1[0]);
      localObject3 = localObject1[1];
      Logging.Log("Post The Data 3>>>>>>" + (String)localObject3);
      int i = 0;
      if (((String)localObject3).contains("\"action\":\"initial\""))
      {
        Logging.LogError("Post Data: Event is initial, look at response");
        i = 1;
      }
      if ((hostControl == null) || (hostControl.trim().isEmpty()))
      {
        Logging.Log("postEvent - hostControl was empty, using default");
        hostControl = "control.kochava.com";
      }
      for (;;)
      {
        try
        {
          Logging.Log("postEvent - posting to " + "https://" + hostControl + "/track/kvTracker.php");
          localObject1 = (HttpsURLConnection)new URL("https://" + hostControl + "/track/kvTracker.php").openConnection();
          ((HttpsURLConnection)localObject1).setRequestProperty("User-Agent", prefs.getString("useragent", ""));
          ((HttpsURLConnection)localObject1).setRequestProperty("Content-Type", "application/json; charset=UTF-8");
          ((HttpsURLConnection)localObject1).setRequestMethod("POST");
          ((HttpsURLConnection)localObject1).setConnectTimeout(30000);
          ((HttpsURLConnection)localObject1).setReadTimeout(30000);
          ((HttpsURLConnection)localObject1).setDoInput(true);
          ((HttpsURLConnection)localObject1).setDoOutput(true);
          ((HttpsURLConnection)localObject1).connect();
          localObject4 = new OutputStreamWriter(((HttpsURLConnection)localObject1).getOutputStream());
          ((OutputStreamWriter)localObject4).write((String)localObject3);
          ((OutputStreamWriter)localObject4).close();
        }
        catch (Exception localException)
        {
          Object localObject4;
          Logging.LogError("TrackTask " + localException);
          return "";
          Logging.LogError("TrackTask " + localException);
          continue;
        }
        catch (IOException localIOException2)
        {
          if (!localIOException2.getClass().equals(SSLException.class)) {
            break label671;
          }
        }
        try
        {
          Logging.Log("Grabbing Result...");
          localObject3 = new StringBuffer("");
          localObject1 = new BufferedReader(new InputStreamReader(((HttpsURLConnection)localObject1).getInputStream()));
          localObject4 = ((BufferedReader)localObject1).readLine();
          if (localObject4 != null) {
            ((StringBuffer)localObject3).append((String)localObject4);
          }
        }
        catch (IOException localIOException1)
        {
          if (!localIOException1.getClass().equals(SSLException.class)) {
            continue;
          }
          Logging.LogError("SSLException! Shutting down SDK and sending report." + localIOException1);
          httpsError(localIOException1);
          return "";
          localObject3 = ((StringBuffer)localObject3).toString();
          Logging.Log("Result: " + (String)localObject3);
          if (i != 0)
          {
            if (((String)localObject3).contains("\"success\":\"1\""))
            {
              Logging.Log("Got success response, cleaning database.");
              kDbAdapter.cleanupEvents(l);
            }
            Object localObject2 = localObject3;
            if (haveAttributionData()) {
              break;
            }
            localObject2 = localObject3;
            if (!requestAttributionData) {
              break;
            }
            Logging.Log("Requesting attribution data in " + get_attribution_wait + " seconds...");
            sendKVQuery(get_attribution_wait);
            return (String)localObject3;
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          Logging.LogError("TrackTask " + localOutOfMemoryError);
          return "";
        }
      }
    }
    kDbAdapter.cleanupEvents(l);
    return (String)localObject3;
    Logging.LogError("SSLException! Shutting down SDK and sending report." + localIOException2);
    httpsError(localIOException2);
    for (;;)
    {
      return "";
      label671:
      Logging.LogError("TrackTask " + localIOException2);
    }
  }
  
  private void queInitial(boolean paramBoolean)
  {
    if ((prefs.getString("initBool", "").equals("false")) && (initialPropertiesObject != null) && (initialObject != null)) {
      try
      {
        Logging.Log("Initial properties: " + initialPropertiesObject);
        Logging.Log("Initital Oject: " + initialObject);
        if (!prefs.getString("initData", "noData").equals("noData"))
        {
          initialPropertiesObject.put("conversion_type", "gplay");
          initialPropertiesObject.put("conversion_data", prefs.getString("initData", ""));
          Logging.Log("Got referral, attaching: " + prefs.getString("initData", ""));
        }
        for (;;)
        {
          initialObject.put("data", initialPropertiesObject);
          kDbAdapter.addEvent(initialObject, true, false);
          Logging.Log("Sending Initial");
          prefs.edit().putString("initBool", "true").apply();
          if (!paramBoolean) {
            break;
          }
          initTimer.cancel();
          return;
          Logging.LogError("Did not get referral data.");
        }
        return;
      }
      catch (JSONException localJSONException)
      {
        Logging.LogError("An error occured during que initial. " + localJSONException);
        if (Global.DEBUGERROR) {
          localJSONException.printStackTrace();
        }
      }
    }
  }
  
  private static void registerRemoveToken(JSONObject paramJSONObject)
    throws JSONException
  {
    new Thread()
    {
      @SuppressLint({"NewApi"})
      public void run()
      {
        try
        {
          Object localObject1 = new JSONObject();
          Object localObject3 = new JSONObject();
          Feature.addGlobalProperties((JSONObject)localObject3);
          if (val$pushCommand.has("register"))
          {
            ((JSONObject)localObject3).put("token", val$pushCommand.get("register").toString());
            ((JSONObject)localObject1).put("push_action", "register_token");
          }
          if (val$pushCommand.has("remove")) {
            ((JSONObject)localObject1).put("push_action", "remove_token");
          }
          ((JSONObject)localObject1).put("action", "push");
          ((JSONObject)localObject1).put("data", localObject3);
          ((JSONObject)localObject1).put("kochava_app_id", Feature.mAppId);
          ((JSONObject)localObject1).put("kochava_device_id", Feature.access$2800());
          ((JSONObject)localObject1).put("sdk_version", "Android20160222" + Feature.versionExtension);
          ((JSONObject)localObject1).put("sdk_protocol", "4");
          if ((Feature.hostControl == null) || (Feature.hostControl.trim().isEmpty()))
          {
            Logging.Log("Push token - hostControl was empty, using default");
            Feature.access$602("control.kochava.com");
          }
          Logging.Log("kvPush - posting to " + "https://" + Feature.hostControl + "/track/kvTracker.php");
          localObject3 = new URL("https://" + Feature.hostControl + "/track/kvTracker.php");
          localObject1 = ((JSONObject)localObject1).toString();
          Logging.Log("kvPush data:" + (String)localObject1);
          localObject3 = (HttpsURLConnection)((URL)localObject3).openConnection();
          ((HttpsURLConnection)localObject3).setRequestProperty("User-Agent", Feature.prefs.getString("useragent", ""));
          ((HttpsURLConnection)localObject3).setRequestProperty("Content-Type", "application/json; charset=UTF-8");
          ((HttpsURLConnection)localObject3).setRequestMethod("POST");
          ((HttpsURLConnection)localObject3).setConnectTimeout(30000);
          ((HttpsURLConnection)localObject3).setReadTimeout(30000);
          ((HttpsURLConnection)localObject3).setDoInput(true);
          ((HttpsURLConnection)localObject3).setDoOutput(true);
          ((HttpsURLConnection)localObject3).connect();
          Object localObject4 = new OutputStreamWriter(((HttpsURLConnection)localObject3).getOutputStream());
          ((OutputStreamWriter)localObject4).write((String)localObject1);
          ((OutputStreamWriter)localObject4).close();
          Logging.Log("Grabbing Result...");
          localObject1 = new StringBuffer("");
          localObject3 = new BufferedReader(new InputStreamReader(((HttpsURLConnection)localObject3).getInputStream()));
          for (;;)
          {
            localObject4 = ((BufferedReader)localObject3).readLine();
            if (localObject4 == null) {
              break;
            }
            ((StringBuffer)localObject1).append((String)localObject4);
          }
          localObject2 = localException.toString();
        }
        catch (Exception localException)
        {
          Logging.LogError("Problem sending register/remove token, saving push command: " + val$pushCommand.toString());
          Feature.prefs.edit().putString("register_remove_token", val$pushCommand.toString()).apply();
          if (Global.DEBUGERROR) {
            localException.printStackTrace();
          }
          return;
        }
        Logging.Log("Result: " + (String)localObject2);
        Object localObject2 = new JSONObject((String)localObject2);
        if ((localObject2 != null) && (((JSONObject)localObject2).get("success").toString().equals("1")))
        {
          Feature.prefs.edit().remove("register_remove_token").apply();
          return;
        }
        Logging.LogError("Did not get a good response, saving push command: " + val$pushCommand.toString());
        Feature.prefs.edit().putString("register_remove_token", val$pushCommand.toString()).apply();
      }
    }.start();
  }
  
  protected static void sendKVQuery(int paramInt)
  {
    worker.schedule(sendKVQuery, paramInt, TimeUnit.SECONDS);
  }
  
  private static void sendOutsideServicesUpdate(JSONArray paramJSONArray)
  {
    new Thread()
    {
      public void run()
      {
        try
        {
          Object localObject2 = new JSONObject();
          ((JSONObject)localObject2).put("action", "update");
          ((JSONObject)localObject2).put("kochava_device_id", Feature.access$2800());
          ((JSONObject)localObject2).put("kochava_app_id", Feature.mAppId);
          ((JSONObject)localObject2).put("sdk_version", "Android20160222" + Feature.versionExtension);
          ((JSONObject)localObject2).put("sdk_protocol", "4");
          Object localObject1 = new JSONObject();
          ((JSONObject)localObject1).put("outside_services", val$services_found);
          ((JSONObject)localObject2).put("data", localObject1);
          if ((Feature.hostControl == null) || (Feature.hostControl.trim().isEmpty())) {
            Feature.access$602("control.kochava.com");
          }
          Logging.Log("posting update to " + "https://" + Feature.hostControl + "/track/kvTracker.php");
          localObject1 = (HttpsURLConnection)new URL("https://" + Feature.hostControl + "/track/kvTracker.php").openConnection();
          ((HttpsURLConnection)localObject1).setRequestProperty("User-Agent", Feature.prefs.getString("useragent", ""));
          ((HttpsURLConnection)localObject1).setRequestProperty("Content-Type", "application/json; charset=UTF-8");
          ((HttpsURLConnection)localObject1).setRequestMethod("POST");
          ((HttpsURLConnection)localObject1).setConnectTimeout(30000);
          ((HttpsURLConnection)localObject1).setReadTimeout(30000);
          ((HttpsURLConnection)localObject1).setDoInput(true);
          ((HttpsURLConnection)localObject1).setDoOutput(true);
          ((HttpsURLConnection)localObject1).connect();
          String str2 = ((JSONObject)localObject2).toString();
          Logging.Log("Trying to post an update: " + ((JSONObject)localObject2).toString());
          localObject2 = new OutputStreamWriter(((HttpsURLConnection)localObject1).getOutputStream());
          ((OutputStreamWriter)localObject2).write(str2);
          ((OutputStreamWriter)localObject2).close();
          Logging.Log("(Update) Grabbing Result...");
          localObject2 = new StringBuffer("");
          localObject1 = new BufferedReader(new InputStreamReader(((HttpsURLConnection)localObject1).getInputStream()));
          for (;;)
          {
            str2 = ((BufferedReader)localObject1).readLine();
            if (str2 == null) {
              break;
            }
            ((StringBuffer)localObject2).append(str2);
          }
          str1 = ((StringBuffer)localObject2).toString();
        }
        catch (Exception localException)
        {
          Logging.LogError("Update error: " + localException.toString());
          return;
        }
        String str1;
        Logging.Log("Update Result: " + str1);
      }
    }.start();
  }
  
  private void setCurrency(String paramString)
  {
    if ((paramString != null) && (paramString.length() != 0))
    {
      prefs = appContext.getSharedPreferences("initPrefs", 0);
      prefs.edit().putString("currency", paramString).apply();
    }
  }
  
  public static void setErrorDebug(boolean paramBoolean)
  {
    Logging.Log("setErrorDebug to " + paramBoolean);
    Global.DEBUGERROR = paramBoolean;
  }
  
  /* Error */
  private static void startAppSession()
  {
    // Byte code:
    //   0: getstatic 622	android/os/Build$VERSION:SDK_INT	I
    //   3: bipush 14
    //   5: if_icmplt +261 -> 266
    //   8: getstatic 169	com/kochava/android/tracker/Feature:overrideAutomaticSessions	Z
    //   11: ifne +255 -> 266
    //   14: getstatic 216	com/kochava/android/tracker/Feature:badInit	Z
    //   17: ifeq +10 -> 27
    //   20: ldc_w 624
    //   23: invokestatic 561	com/kochava/android/util/Logging:LogError	(Ljava/lang/String;)V
    //   26: return
    //   27: ldc_w 1685
    //   30: invokestatic 617	com/kochava/android/util/Logging:Log	(Ljava/lang/String;)V
    //   33: getstatic 208	com/kochava/android/tracker/Feature:should_flush_in_background	Z
    //   36: ifne +46 -> 82
    //   39: getstatic 628	com/kochava/android/tracker/Feature:mTimer	Ljava/util/Timer;
    //   42: ifnonnull +189 -> 231
    //   45: ldc_w 1687
    //   48: invokestatic 617	com/kochava/android/util/Logging:Log	(Ljava/lang/String;)V
    //   51: new 635	java/util/Timer
    //   54: dup
    //   55: invokespecial 1154	java/util/Timer:<init>	()V
    //   58: putstatic 628	com/kochava/android/tracker/Feature:mTimer	Ljava/util/Timer;
    //   61: getstatic 628	com/kochava/android/tracker/Feature:mTimer	Ljava/util/Timer;
    //   64: new 8	com/kochava/android/tracker/Feature$10
    //   67: dup
    //   68: invokespecial 1688	com/kochava/android/tracker/Feature$10:<init>	()V
    //   71: getstatic 172	com/kochava/android/tracker/Feature:flush_rate	I
    //   74: i2l
    //   75: getstatic 172	com/kochava/android/tracker/Feature:flush_rate	I
    //   78: i2l
    //   79: invokevirtual 1475	java/util/Timer:schedule	(Ljava/util/TimerTask;JJ)V
    //   82: invokestatic 500	java/lang/System:currentTimeMillis	()J
    //   85: ldc2_w 501
    //   88: ldiv
    //   89: putstatic 199	com/kochava/android/tracker/Feature:startTime	J
    //   92: getstatic 195	com/kochava/android/tracker/Feature:doGatherLocation	Z
    //   95: ifeq +18 -> 113
    //   98: invokestatic 356	com/kochava/android/tracker/Feature:oldLocationTooStale	()Z
    //   101: ifeq +12 -> 113
    //   104: getstatic 523	com/kochava/android/tracker/Feature:appContext	Landroid/content/Context;
    //   107: invokestatic 1692	com/kochava/android/tracker/LocationDirector:getInstance	(Landroid/content/Context;)Lcom/kochava/android/tracker/LocationDirector;
    //   110: invokevirtual 1695	com/kochava/android/tracker/LocationDirector:getLocation	()V
    //   113: getstatic 419	com/kochava/android/tracker/Feature:prefs	Landroid/content/SharedPreferences;
    //   116: ifnull +49 -> 165
    //   119: getstatic 419	com/kochava/android/tracker/Feature:prefs	Landroid/content/SharedPreferences;
    //   122: ldc_w 1697
    //   125: ldc -93
    //   127: invokeinterface 539 3 0
    //   132: ldc -93
    //   134: invokevirtual 543	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   137: istore_0
    //   138: iload_0
    //   139: ifne +26 -> 165
    //   142: new 514	org/json/JSONObject
    //   145: dup
    //   146: getstatic 419	com/kochava/android/tracker/Feature:prefs	Landroid/content/SharedPreferences;
    //   149: ldc_w 1697
    //   152: ldc -93
    //   154: invokeinterface 539 3 0
    //   159: invokespecial 1698	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   162: invokestatic 1700	com/kochava/android/tracker/Feature:registerRemoveToken	(Lorg/json/JSONObject;)V
    //   165: getstatic 419	com/kochava/android/tracker/Feature:prefs	Landroid/content/SharedPreferences;
    //   168: ifnull +98 -> 266
    //   171: getstatic 419	com/kochava/android/tracker/Feature:prefs	Landroid/content/SharedPreferences;
    //   174: ldc_w 1369
    //   177: ldc -93
    //   179: invokeinterface 539 3 0
    //   184: ldc_w 1252
    //   187: invokevirtual 543	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   190: ifeq +76 -> 266
    //   193: getstatic 218	com/kochava/android/tracker/Feature:canSendSession	Z
    //   196: ifeq +64 -> 260
    //   199: ldc_w 1702
    //   202: invokestatic 643	com/kochava/android/tracker/Feature:eventSession	(Ljava/lang/String;)V
    //   205: return
    //   206: astore_1
    //   207: new 494	java/lang/StringBuilder
    //   210: dup
    //   211: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   214: ldc_w 1704
    //   217: invokevirtual 509	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: aload_1
    //   221: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   224: invokevirtual 512	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   227: invokestatic 561	com/kochava/android/util/Logging:LogError	(Ljava/lang/String;)V
    //   230: return
    //   231: ldc_w 1706
    //   234: invokestatic 617	com/kochava/android/util/Logging:Log	(Ljava/lang/String;)V
    //   237: goto -155 -> 82
    //   240: astore_1
    //   241: ldc_w 1708
    //   244: invokestatic 561	com/kochava/android/util/Logging:LogError	(Ljava/lang/String;)V
    //   247: getstatic 726	com/kochava/android/tracker/Global:DEBUGERROR	Z
    //   250: ifeq -85 -> 165
    //   253: aload_1
    //   254: invokevirtual 729	org/json/JSONException:printStackTrace	()V
    //   257: goto -92 -> 165
    //   260: ldc_w 649
    //   263: invokestatic 617	com/kochava/android/util/Logging:Log	(Ljava/lang/String;)V
    //   266: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   137	2	0	bool	boolean
    //   206	15	1	localException	Exception
    //   240	14	1	localJSONException	JSONException
    // Exception table:
    //   from	to	target	type
    //   0	26	206	java/lang/Exception
    //   27	82	206	java/lang/Exception
    //   82	113	206	java/lang/Exception
    //   113	138	206	java/lang/Exception
    //   142	165	206	java/lang/Exception
    //   165	205	206	java/lang/Exception
    //   231	237	206	java/lang/Exception
    //   241	257	206	java/lang/Exception
    //   260	266	206	java/lang/Exception
    //   142	165	240	org/json/JSONException
  }
  
  public void event(final String paramString1, final String paramString2)
  {
    if (badInit)
    {
      Logging.LogError("The library was not initialized properly or we cannot connect to our servers. Until this is fixed, this method cannot be used.");
      return;
    }
    try
    {
      new Thread()
      {
        public void run()
        {
          Logging.Log("Got event " + paramString1);
          HashMap localHashMap = new HashMap();
          localHashMap.put("event_name", paramString1);
          localHashMap.put("event_data", paramString2);
          Feature.this.fireEventBlacklist("event", localHashMap);
        }
      }.start();
      return;
    }
    catch (Exception paramString1)
    {
      Logging.LogError("Error in event call: " + paramString1);
    }
  }
  
  protected void tryUpdate(final String paramString)
  {
    paramString = new Runnable()
    {
      @SuppressLint({"NewApi"})
      public void run()
      {
        Logging.Log("Checking watchlist from " + paramString + "...");
        Object localObject2 = new HashMap();
        if (!Feature.prefs.contains("app_short_string"))
        {
          Logging.Log("No previous app_short_string in watchlist, adding " + mAppVersionName);
          Feature.prefs.edit().putString("app_short_string", mAppVersionName).apply();
          if (Feature.prefs.contains("app_limit_tracking")) {
            break label723;
          }
          Logging.Log("No previous app_limit_tracking in watchlist, adding " + app_limit_tracking);
          Feature.prefs.edit().putBoolean("app_limit_tracking", app_limit_tracking).apply();
          label174:
          if (Feature.prefs.contains("app_version")) {
            break label834;
          }
          Logging.Log("No previous app_version in watchlist, adding " + Feature.this.getAppVersion());
          Feature.prefs.edit().putString("app_version", Feature.this.getAppVersion()).apply();
          label242:
          if (Feature.prefs.contains("device_limit_tracking")) {
            break label949;
          }
          Logging.Log("No previous device_limit_tracking in watchlist, adding " + Feature.device_limit_tracking);
          Feature.prefs.edit().putBoolean("device_limit_tracking", Feature.device_limit_tracking).apply();
          label302:
          if (Feature.send_id_updates)
          {
            if (Feature.prefs.contains("adid")) {
              break label1044;
            }
            Logging.Log("No previous adid in watchlist, adding " + Feature.advertisingID);
            Feature.prefs.edit().putString("adid", Feature.advertisingID).apply();
            ((HashMap)localObject2).put("adid", Feature.advertisingID);
          }
          label378:
          if (Feature.prefs.contains("os_version")) {
            break label1125;
          }
          Logging.Log("No previous os_version in watchlist, adding " + Feature.access$3400());
          Feature.prefs.edit().putString("os_version", Feature.access$3400()).apply();
        }
        for (;;)
        {
          if (!((HashMap)localObject2).keySet().isEmpty()) {
            try
            {
              JSONObject localJSONObject = new JSONObject();
              localJSONObject.put("action", "update");
              localJSONObject.put("kochava_device_id", Feature.access$2800());
              localJSONObject.put("kochava_app_id", Feature.mAppId);
              localJSONObject.put("sdk_version", "Android20160222" + Feature.versionExtension);
              localJSONObject.put("sdk_protocol", "4");
              localObject3 = new JSONObject();
              Iterator localIterator = ((HashMap)localObject2).keySet().iterator();
              while (localIterator.hasNext())
              {
                String str = (String)localIterator.next();
                ((JSONObject)localObject3).put(str, ((HashMap)localObject2).get(str));
              }
              return;
            }
            catch (Exception localException)
            {
              Logging.LogError("Update error: " + localException.toString());
            }
          }
          if (Feature.prefs.getString("app_short_string", "").equals(mAppVersionName)) {
            break;
          }
          Logging.Log("app_short_string changed! Is now " + mAppVersionName);
          ((HashMap)localObject2).put("app_short_string", mAppVersionName + "");
          Feature.prefs.edit().putString("app_short_string", mAppVersionName).apply();
          break;
          label723:
          if (Feature.prefs.getBoolean("app_limit_tracking", false) == app_limit_tracking) {
            break label174;
          }
          Logging.Log("app_limit_tracking changed! Is now " + app_limit_tracking);
          ((HashMap)localObject2).put("app_limit_tracking", app_limit_tracking + "");
          Feature.prefs.edit().putBoolean("app_limit_tracking", app_limit_tracking).apply();
          break label174;
          label834:
          if (Feature.prefs.getString("app_version", "").equals(Feature.this.getAppVersion())) {
            break label242;
          }
          Logging.Log("app_version changed! Is now " + Feature.this.getAppVersion());
          ((HashMap)localObject2).put("app_version", Feature.this.getAppVersion() + "");
          Feature.prefs.edit().putString("app_version", Feature.this.getAppVersion()).apply();
          break label242;
          label949:
          if (Feature.prefs.getBoolean("device_limit_tracking", false) == Feature.device_limit_tracking) {
            break label302;
          }
          Logging.Log("device_limit_tracking changed! Is now " + Feature.device_limit_tracking);
          ((HashMap)localObject2).put("device_limit_tracking", Feature.device_limit_tracking + "");
          Feature.prefs.edit().putBoolean("device_limit_tracking", Feature.device_limit_tracking).apply();
          break label302;
          label1044:
          if (Feature.prefs.getString("adid", "").equals(Feature.advertisingID)) {
            break label378;
          }
          Logging.Log("adid changed! Is now " + Feature.advertisingID);
          ((HashMap)localObject2).put("adid", Feature.advertisingID);
          Feature.prefs.edit().putString("adid", Feature.advertisingID).apply();
          break label378;
          label1125:
          if (!Feature.prefs.getString("os_version", "").equals(Feature.access$3400()))
          {
            Logging.Log("os_version changed! Is now " + Feature.access$3400());
            ((HashMap)localObject2).put("os_version", Feature.access$3400());
            Feature.prefs.edit().putString("os_version", Feature.access$3400()).apply();
            Feature.prefs.edit().putString("useragent", Feature.this.getUserAgent()).apply();
          }
        }
        localException.put("data", localObject3);
        if ((Feature.hostControl == null) || (Feature.hostControl.trim().isEmpty())) {
          Feature.access$602("control.kochava.com");
        }
        Logging.Log("posting update to " + "https://" + Feature.hostControl + "/track/kvTracker.php");
        localObject2 = (HttpsURLConnection)new URL("https://" + Feature.hostControl + "/track/kvTracker.php").openConnection();
        ((HttpsURLConnection)localObject2).setRequestProperty("User-Agent", Feature.prefs.getString("useragent", ""));
        ((HttpsURLConnection)localObject2).setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        ((HttpsURLConnection)localObject2).setRequestMethod("POST");
        ((HttpsURLConnection)localObject2).setConnectTimeout(30000);
        ((HttpsURLConnection)localObject2).setReadTimeout(30000);
        ((HttpsURLConnection)localObject2).setDoInput(true);
        ((HttpsURLConnection)localObject2).setDoOutput(true);
        ((HttpsURLConnection)localObject2).connect();
        Object localObject3 = localException.toString();
        Logging.Log("Trying to post an update: " + localException.toString());
        Object localObject1 = new OutputStreamWriter(((HttpsURLConnection)localObject2).getOutputStream());
        ((OutputStreamWriter)localObject1).write((String)localObject3);
        ((OutputStreamWriter)localObject1).close();
        Logging.Log("(Update) Grabbing Result...");
        localObject1 = new StringBuffer("");
        localObject2 = new BufferedReader(new InputStreamReader(((HttpsURLConnection)localObject2).getInputStream()));
        for (;;)
        {
          localObject3 = ((BufferedReader)localObject2).readLine();
          if (localObject3 == null) {
            break;
          }
          ((StringBuffer)localObject1).append((String)localObject3);
        }
        localObject1 = ((StringBuffer)localObject1).toString();
        Logging.Log("Update Result: " + (String)localObject1);
      }
    };
    worker.schedule(paramString, 10L, TimeUnit.SECONDS);
  }
  
  protected static class AppLifeCycleStatusManager
  {
    protected static boolean active = false;
    protected static boolean resumed = false;
    
    protected static void changeStatus(String paramString)
    {
      new Thread()
      {
        public void run()
        {
          if (!Feature.AppLifeCycleStatusManager.active) {
            Logging.Log("AppLifeCycleStatusManager - not active");
          }
          do
          {
            return;
            if (val$status.equals("is_focused"))
            {
              if (!Feature.AppLifeCycleStatusManager.resumed)
              {
                Logging.Log("AppLifeCycleStatusManager - not already resumed, starting session...");
                Feature.access$5100();
                Feature.AppLifeCycleStatusManager.resumed = true;
                return;
              }
              Logging.Log("AppLifeCycleStatusManager - IS_FOCUSED received, App is already in focused state.");
              return;
            }
          } while (!val$status.equals("is_in_background"));
          if (Feature.AppLifeCycleStatusManager.resumed)
          {
            Logging.Log("AppLifeCycleStatusManager - going to background from app, ending session");
            Feature.access$5200();
            Feature.AppLifeCycleStatusManager.resumed = false;
            return;
          }
          Logging.Log("AppLifeCycleStatusManager - IS_IN_BACKGROUND received, App is already in background state.");
        }
      }.start();
    }
  }
  
  protected class ApplicationInfoHolder
  {
    public String appInstallTime = "";
    public String appPackage = "";
    public String appUpdateTime = "";
    
    public ApplicationInfoHolder(String paramString1, String paramString2, String paramString3)
    {
      appPackage = paramString1;
      appInstallTime = paramString2;
      appUpdateTime = paramString3;
    }
  }
  
  @TargetApi(14)
  protected class LifeCycleTracker
    implements Application.ActivityLifecycleCallbacks
  {
    protected LifeCycleTracker() {}
    
    public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
    
    public void onActivityDestroyed(Activity paramActivity) {}
    
    public void onActivityPaused(Activity paramActivity)
    {
      Logging.Log("LifeCycleTracker - Tracking Activity lost focus");
      Feature.AppLifeCycleStatusManager.changeStatus("is_in_background");
      Feature.access$4202(true);
    }
    
    public void onActivityResumed(Activity paramActivity)
    {
      Logging.Log("LifeCycleTracker - Tracking Activity Resumed");
      Feature.AppLifeCycleStatusManager.changeStatus("is_focused");
      Feature.access$4202(false);
    }
    
    public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
    
    public void onActivityStarted(Activity paramActivity) {}
    
    public void onActivityStopped(Activity paramActivity) {}
  }
  
  @TargetApi(14)
  protected class MemoryBoss
    implements ComponentCallbacks2
  {
    protected MemoryBoss() {}
    
    public void onConfigurationChanged(Configuration paramConfiguration) {}
    
    public void onLowMemory() {}
    
    public void onTrimMemory(int paramInt)
    {
      if (paramInt == 20)
      {
        Logging.Log("MemoryBoss - Tracking Activity lost focus");
        Feature.AppLifeCycleStatusManager.changeStatus("is_in_background");
        Feature.access$4202(true);
      }
    }
  }
  
  private static class TrackTask
    implements Runnable
  {
    public void run()
    {
      Feature.access$5000();
    }
  }
}

/* Location:
 * Qualified Name:     com.kochava.android.tracker.Feature
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */