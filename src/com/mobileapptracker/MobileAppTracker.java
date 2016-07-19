package com.mobileapptracker;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.util.Log;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;
import org.json.JSONObject;

public class MobileAppTracker
{
  private static volatile MobileAppTracker tune = null;
  private final String IV = "heF9BATUfWuISyO8";
  private boolean debugMode;
  private MATDeferredDplinkr dplinkr;
  private MATEncryption encryption;
  protected MATEventQueue eventQueue;
  private boolean fbLogging;
  private boolean firstSession;
  boolean gotGaid;
  boolean gotReferrer;
  private long initTime;
  protected boolean initialized;
  protected boolean isRegistered;
  protected Context mContext;
  private MATPreloadData mPreloadData;
  protected BroadcastReceiver networkStateReceiver;
  boolean notifiedPool;
  protected MATParameters params;
  ExecutorService pool;
  protected ExecutorService pubQueue;
  private long referrerTime;
  private MATResponse tuneListener;
  protected MATTestRequest tuneRequest;
  private MATUrlRequester urlRequester;
  
  public static MobileAppTracker getInstance()
  {
    try
    {
      MobileAppTracker localMobileAppTracker = tune;
      return localMobileAppTracker;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static MobileAppTracker init(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      if (tune == null)
      {
        tune = new MobileAppTracker();
        tunemContext = paramContext.getApplicationContext();
        tunepubQueue = Executors.newSingleThreadExecutor();
        tune.initAll(paramString1, paramString2);
      }
      paramContext = tune;
      return paramContext;
    }
    finally {}
  }
  
  private void initLocalVariables(String paramString)
  {
    pool = Executors.newSingleThreadExecutor();
    urlRequester = new MATUrlRequester();
    encryption = new MATEncryption(paramString.trim(), "heF9BATUfWuISyO8");
    initTime = System.currentTimeMillis();
    if (!mContext.getSharedPreferences("com.mobileapptracking", 0).getString("mat_referrer", "").equals("")) {}
    for (boolean bool = true;; bool = false)
    {
      gotReferrer = bool;
      firstSession = true;
      initialized = false;
      isRegistered = false;
      debugMode = false;
      fbLogging = false;
      return;
    }
  }
  
  public static boolean isOnline(Context paramContext)
  {
    paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    return (paramContext != null) && (paramContext.isConnected());
  }
  
  /* Error */
  private void measure(MATEvent paramMATEvent)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 153	com/mobileapptracker/MobileAppTracker:initialized	Z
    //   6: istore_3
    //   7: iload_3
    //   8: ifne +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: invokevirtual 182	com/mobileapptracker/MobileAppTracker:dumpQueue	()V
    //   18: aload_0
    //   19: getfield 184	com/mobileapptracker/MobileAppTracker:params	Lcom/mobileapptracker/MATParameters;
    //   22: ldc -70
    //   24: invokevirtual 191	com/mobileapptracker/MATParameters:setAction	(Ljava/lang/String;)V
    //   27: new 193	java/util/Date
    //   30: dup
    //   31: invokespecial 194	java/util/Date:<init>	()V
    //   34: astore 4
    //   36: aload_1
    //   37: invokevirtual 199	com/mobileapptracker/MATEvent:getEventName	()Ljava/lang/String;
    //   40: ifnull +96 -> 136
    //   43: aload_1
    //   44: invokevirtual 199	com/mobileapptracker/MATEvent:getEventName	()Ljava/lang/String;
    //   47: astore 5
    //   49: aload_0
    //   50: getfield 159	com/mobileapptracker/MobileAppTracker:fbLogging	Z
    //   53: ifeq +7 -> 60
    //   56: aload_1
    //   57: invokestatic 204	com/mobileapptracker/MATFBBridge:logEvent	(Lcom/mobileapptracker/MATEvent;)V
    //   60: aload 5
    //   62: ldc -50
    //   64: invokevirtual 147	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   67: ifne -56 -> 11
    //   70: aload 5
    //   72: ldc -48
    //   74: invokevirtual 147	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   77: ifne +33 -> 110
    //   80: aload 5
    //   82: ldc -46
    //   84: invokevirtual 147	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   87: ifne +23 -> 110
    //   90: aload 5
    //   92: ldc -44
    //   94: invokevirtual 147	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   97: ifne +13 -> 110
    //   100: aload 5
    //   102: ldc -42
    //   104: invokevirtual 147	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   107: ifeq +29 -> 136
    //   110: aload_0
    //   111: getfield 184	com/mobileapptracker/MobileAppTracker:params	Lcom/mobileapptracker/MATParameters;
    //   114: ldc -42
    //   116: invokevirtual 191	com/mobileapptracker/MATParameters:setAction	(Ljava/lang/String;)V
    //   119: new 193	java/util/Date
    //   122: dup
    //   123: aload 4
    //   125: invokevirtual 217	java/util/Date:getTime	()J
    //   128: ldc2_w 218
    //   131: ladd
    //   132: invokespecial 222	java/util/Date:<init>	(J)V
    //   135: pop
    //   136: aload_1
    //   137: invokevirtual 226	com/mobileapptracker/MATEvent:getRevenue	()D
    //   140: dconst_0
    //   141: dcmpl
    //   142: ifle +12 -> 154
    //   145: aload_0
    //   146: getfield 184	com/mobileapptracker/MobileAppTracker:params	Lcom/mobileapptracker/MATParameters;
    //   149: ldc -28
    //   151: invokevirtual 231	com/mobileapptracker/MATParameters:setIsPayingUser	(Ljava/lang/String;)V
    //   154: aload_1
    //   155: aload_0
    //   156: getfield 233	com/mobileapptracker/MobileAppTracker:mPreloadData	Lcom/mobileapptracker/MATPreloadData;
    //   159: aload_0
    //   160: getfield 157	com/mobileapptracker/MobileAppTracker:debugMode	Z
    //   163: invokestatic 239	com/mobileapptracker/MATUrlBuilder:buildLink	(Lcom/mobileapptracker/MATEvent;Lcom/mobileapptracker/MATPreloadData;Z)Ljava/lang/String;
    //   166: astore 4
    //   168: aload_1
    //   169: invokestatic 243	com/mobileapptracker/MATUrlBuilder:buildDataUnencrypted	(Lcom/mobileapptracker/MATEvent;)Ljava/lang/String;
    //   172: astore 5
    //   174: new 245	org/json/JSONArray
    //   177: dup
    //   178: invokespecial 246	org/json/JSONArray:<init>	()V
    //   181: astore 6
    //   183: aload_1
    //   184: invokevirtual 250	com/mobileapptracker/MATEvent:getEventItems	()Ljava/util/List;
    //   187: ifnull +47 -> 234
    //   190: iconst_0
    //   191: istore_2
    //   192: iload_2
    //   193: aload_1
    //   194: invokevirtual 250	com/mobileapptracker/MATEvent:getEventItems	()Ljava/util/List;
    //   197: invokeinterface 256 1 0
    //   202: if_icmpge +32 -> 234
    //   205: aload 6
    //   207: aload_1
    //   208: invokevirtual 250	com/mobileapptracker/MATEvent:getEventItems	()Ljava/util/List;
    //   211: iload_2
    //   212: invokeinterface 260 2 0
    //   217: checkcast 262	com/mobileapptracker/MATEventItem
    //   220: invokevirtual 266	com/mobileapptracker/MATEventItem:toJSON	()Lorg/json/JSONObject;
    //   223: invokevirtual 270	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   226: pop
    //   227: iload_2
    //   228: iconst_1
    //   229: iadd
    //   230: istore_2
    //   231: goto -39 -> 192
    //   234: aload 6
    //   236: aload_1
    //   237: invokevirtual 273	com/mobileapptracker/MATEvent:getReceiptData	()Ljava/lang/String;
    //   240: aload_1
    //   241: invokevirtual 276	com/mobileapptracker/MATEvent:getReceiptSignature	()Ljava/lang/String;
    //   244: aload_0
    //   245: getfield 184	com/mobileapptracker/MobileAppTracker:params	Lcom/mobileapptracker/MATParameters;
    //   248: invokevirtual 280	com/mobileapptracker/MATParameters:getUserEmails	()Lorg/json/JSONArray;
    //   251: invokestatic 284	com/mobileapptracker/MATUrlBuilder:buildBody	(Lorg/json/JSONArray;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONArray;)Lorg/json/JSONObject;
    //   254: astore 6
    //   256: aload_0
    //   257: getfield 286	com/mobileapptracker/MobileAppTracker:tuneRequest	Lcom/mobileapptracker/MATTestRequest;
    //   260: ifnull +18 -> 278
    //   263: aload_0
    //   264: getfield 286	com/mobileapptracker/MobileAppTracker:tuneRequest	Lcom/mobileapptracker/MATTestRequest;
    //   267: aload 4
    //   269: aload 5
    //   271: aload 6
    //   273: invokeinterface 292 4 0
    //   278: aload_0
    //   279: aload 4
    //   281: aload 5
    //   283: aload 6
    //   285: aload_0
    //   286: getfield 151	com/mobileapptracker/MobileAppTracker:firstSession	Z
    //   289: invokevirtual 296	com/mobileapptracker/MobileAppTracker:addEventToQueue	(Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;Z)V
    //   292: aload_0
    //   293: iconst_0
    //   294: putfield 151	com/mobileapptracker/MobileAppTracker:firstSession	Z
    //   297: aload_0
    //   298: invokevirtual 182	com/mobileapptracker/MobileAppTracker:dumpQueue	()V
    //   301: aload_0
    //   302: getfield 298	com/mobileapptracker/MobileAppTracker:tuneListener	Lcom/mobileapptracker/MATResponse;
    //   305: ifnull -294 -> 11
    //   308: aload_0
    //   309: getfield 298	com/mobileapptracker/MobileAppTracker:tuneListener	Lcom/mobileapptracker/MATResponse;
    //   312: aload_1
    //   313: invokevirtual 301	com/mobileapptracker/MATEvent:getRefId	()Ljava/lang/String;
    //   316: invokeinterface 306 2 0
    //   321: goto -310 -> 11
    //   324: astore_1
    //   325: aload_0
    //   326: monitorexit
    //   327: aload_1
    //   328: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	329	0	this	MobileAppTracker
    //   0	329	1	paramMATEvent	MATEvent
    //   191	40	2	i	int
    //   6	2	3	bool	boolean
    //   34	246	4	localObject1	Object
    //   47	235	5	str	String
    //   181	103	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	324	finally
    //   14	60	324	finally
    //   60	110	324	finally
    //   110	136	324	finally
    //   136	154	324	finally
    //   154	190	324	finally
    //   192	227	324	finally
    //   234	278	324	finally
    //   278	321	324	finally
  }
  
  private void requestDeeplink()
  {
    if (dplinkr.isEnabled())
    {
      dplinkr.setUserAgent(params.getUserAgent());
      dplinkr.checkForDeferredDeeplink(mContext, urlRequester);
    }
  }
  
  protected void addEventToQueue(String paramString1, String paramString2, JSONObject paramJSONObject, boolean paramBoolean)
  {
    ExecutorService localExecutorService = pool;
    MATEventQueue localMATEventQueue = eventQueue;
    localMATEventQueue.getClass();
    localExecutorService.execute(new MATEventQueue.Add(localMATEventQueue, paramString1, paramString2, paramJSONObject, paramBoolean));
  }
  
  protected void dumpQueue()
  {
    if (!isOnline(mContext)) {
      return;
    }
    ExecutorService localExecutorService = pool;
    MATEventQueue localMATEventQueue = eventQueue;
    localMATEventQueue.getClass();
    localExecutorService.execute(new MATEventQueue.Dump(localMATEventQueue));
  }
  
  public String getMatId()
  {
    return params.getMatId();
  }
  
  public String getOpenLogId()
  {
    return params.getOpenLogId();
  }
  
  protected void initAll(String paramString1, String paramString2)
  {
    dplinkr = MATDeferredDplinkr.initialize(paramString1, paramString2, mContext.getPackageName());
    params = MATParameters.init(this, mContext, paramString1, paramString2);
    initLocalVariables(paramString2);
    eventQueue = new MATEventQueue(mContext, this);
    dumpQueue();
    networkStateReceiver = new BroadcastReceiver()
    {
      public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        if (isRegistered) {
          dumpQueue();
        }
      }
    };
    if (isRegistered) {}
    try
    {
      mContext.unregisterReceiver(networkStateReceiver);
      isRegistered = false;
      paramString1 = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
      mContext.registerReceiver(networkStateReceiver, paramString1);
      isRegistered = true;
      initialized = true;
      return;
    }
    catch (IllegalArgumentException paramString1)
    {
      for (;;) {}
    }
  }
  
  protected boolean makeRequest(String paramString1, String paramString2, JSONObject paramJSONObject)
  {
    if (debugMode) {
      Log.d("MobileAppTracker", "Sending event to server...");
    }
    paramString2 = MATUrlBuilder.updateAndEncryptData(paramString2, encryption);
    paramString1 = MATUrlRequester.requestUrl(paramString1 + "&data=" + paramString2, paramJSONObject, debugMode);
    if (paramString1 == null)
    {
      if (tuneListener != null) {
        tuneListener.didFailWithError(paramString1);
      }
      return true;
    }
    if (!paramString1.has("success"))
    {
      if (debugMode) {
        Log.d("MobileAppTracker", "Request failed, event will remain in queue");
      }
      return false;
    }
    int i;
    if (tuneListener != null) {
      i = 0;
    }
    for (;;)
    {
      try
      {
        boolean bool = paramString1.getString("success").equals("true");
        if (bool) {
          i = 1;
        }
        if (i != 0)
        {
          tuneListener.didSucceedWithData(paramString1);
          try
          {
            if (!paramString1.getString("site_event_type").equals("open")) {
              break;
            }
            paramString1 = paramString1.getString("log_id");
            if (getOpenLogId().equals("")) {
              params.setOpenLogId(paramString1);
            }
            params.setLastOpenLogId(paramString1);
            return true;
          }
          catch (JSONException paramString1)
          {
            return true;
          }
        }
        tuneListener.didFailWithError(paramString1);
      }
      catch (JSONException paramString1)
      {
        paramString1.printStackTrace();
        return false;
      }
    }
  }
  
  public void measureEvent(final MATEvent paramMATEvent)
  {
    pubQueue.execute(new Runnable()
    {
      public void run()
      {
        MobileAppTracker.this.measure(paramMATEvent);
      }
    });
  }
  
  public void measureSession()
  {
    notifiedPool = false;
    measureEvent(new MATEvent("session"));
  }
  
  public void setAndroidId(String paramString)
  {
    if (dplinkr != null)
    {
      dplinkr.setAndroidId(paramString);
      requestDeeplink();
    }
    if (params != null) {
      params.setAndroidId(paramString);
    }
  }
  
  public void setGoogleAdvertisingId(String arg1, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      if (dplinkr != null)
      {
        dplinkr.setGoogleAdvertisingId(???, i);
        requestDeeplink();
      }
      if (params != null)
      {
        params.setGoogleAdvertisingId(???);
        params.setGoogleAdTrackingLimited(Integer.toString(i));
      }
      gotGaid = true;
      if ((gotReferrer) && (!notifiedPool)) {
        synchronized (pool)
        {
          pool.notifyAll();
          notifiedPool = true;
          return;
        }
      }
      return;
    }
  }
  
  public void setInstallReferrer(final String paramString)
  {
    gotReferrer = true;
    referrerTime = System.currentTimeMillis();
    if (params != null) {
      params.setReferrerDelay(referrerTime - initTime);
    }
    pubQueue.execute(new Runnable()
    {
      public void run()
      {
        params.setInstallReferrer(paramString);
      }
    });
  }
  
  public void setPackageName(final String paramString)
  {
    dplinkr.setPackageName(paramString);
    pubQueue.execute(new Runnable()
    {
      public void run()
      {
        if ((paramString == null) || (paramString.equals("")))
        {
          params.setPackageName(mContext.getPackageName());
          return;
        }
        params.setPackageName(paramString);
      }
    });
  }
  
  public void setReferralSources(final Activity paramActivity)
  {
    pubQueue.execute(new Runnable()
    {
      public void run()
      {
        params.setReferralSource(paramActivity.getCallingPackage());
        Object localObject = paramActivity.getIntent();
        if (localObject != null)
        {
          localObject = ((Intent)localObject).getData();
          if (localObject != null) {
            params.setReferralUrl(((Uri)localObject).toString());
          }
        }
      }
    });
  }
  
  public void setUserId(final String paramString)
  {
    pubQueue.execute(new Runnable()
    {
      public void run()
      {
        params.setUserId(paramString);
      }
    });
  }
}

/* Location:
 * Qualified Name:     com.mobileapptracker.MobileAppTracker
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */