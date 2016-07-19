package com.facebook.appevents;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.util.Log;
import bolts.AppLinks;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.internal.ActivityLifecycleTracker;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

public class AppEventsLogger
{
  public static final String ACTION_APP_EVENTS_FLUSHED = "com.facebook.sdk.APP_EVENTS_FLUSHED";
  public static final String APP_EVENTS_EXTRA_FLUSH_RESULT = "com.facebook.sdk.APP_EVENTS_FLUSH_RESULT";
  public static final String APP_EVENTS_EXTRA_NUM_EVENTS_FLUSHED = "com.facebook.sdk.APP_EVENTS_NUM_EVENTS_FLUSHED";
  private static final String APP_EVENT_NAME_PUSH_OPENED = "fb_mobile_push_opened";
  public static final String APP_EVENT_PREFERENCES = "com.facebook.sdk.appEventPreferences";
  private static final String APP_EVENT_PUSH_PARAMETER_ACTION = "fb_push_action";
  private static final String APP_EVENT_PUSH_PARAMETER_CAMPAIGN = "fb_push_campaign";
  private static final int APP_SUPPORTS_ATTRIBUTION_ID_RECHECK_PERIOD_IN_SECONDS = 86400;
  private static final int FLUSH_APP_SESSION_INFO_IN_SECONDS = 30;
  private static final String PUSH_PAYLOAD_CAMPAIGN_KEY = "campaign";
  private static final String PUSH_PAYLOAD_KEY = "fb_push_payload";
  private static final String SOURCE_APPLICATION_HAS_BEEN_SET_BY_THIS_INTENT = "_fbSourceApplicationHasBeenSet";
  private static final String TAG = AppEventsLogger.class.getCanonicalName();
  private static String anonymousAppDeviceGUID;
  private static ScheduledThreadPoolExecutor backgroundExecutor;
  private static FlushBehavior flushBehavior = FlushBehavior.AUTO;
  private static boolean isActivateAppEventRequested;
  private static boolean isOpenedByApplink;
  private static String pushNotificationsRegistrationId;
  private static String sourceApplication;
  private static Object staticLock = new Object();
  private final AccessTokenAppIdPair accessTokenAppId;
  private final String contextName;
  
  private AppEventsLogger(Context paramContext, String paramString, AccessToken paramAccessToken)
  {
    this(Utility.getActivityName(paramContext), paramString, paramAccessToken);
  }
  
  protected AppEventsLogger(String paramString1, String paramString2, AccessToken paramAccessToken)
  {
    Validate.sdkInitialized();
    contextName = paramString1;
    paramString1 = paramAccessToken;
    if (paramAccessToken == null) {
      paramString1 = AccessToken.getCurrentAccessToken();
    }
    if ((paramString1 != null) && ((paramString2 == null) || (paramString2.equals(paramString1.getApplicationId())))) {}
    for (accessTokenAppId = new AccessTokenAppIdPair(paramString1);; accessTokenAppId = new AccessTokenAppIdPair(null, paramString1))
    {
      initializeTimersIfNeeded();
      return;
      paramString1 = paramString2;
      if (paramString2 == null) {
        paramString1 = Utility.getMetadataApplicationId(FacebookSdk.getApplicationContext());
      }
    }
  }
  
  public static void activateApp(Application paramApplication)
  {
    activateApp(paramApplication, null);
  }
  
  public static void activateApp(Application paramApplication, String paramString)
  {
    if (!FacebookSdk.isInitialized()) {
      throw new FacebookException("The Facebook sdk must be initialized before calling activateApp");
    }
    String str = paramString;
    if (paramString == null) {
      str = FacebookSdk.getApplicationId();
    }
    FacebookSdk.publishInstallAsync(paramApplication, str);
    ActivityLifecycleTracker.startTracking(paramApplication, str);
  }
  
  @Deprecated
  public static void activateApp(Context paramContext)
  {
    if (ActivityLifecycleTracker.isTracking())
    {
      Log.w(TAG, "activateApp events are being logged automatically. There's no need to call activateApp explicitly, this is safe to remove.");
      return;
    }
    FacebookSdk.sdkInitialize(paramContext);
    activateApp(paramContext, Utility.getMetadataApplicationId(paramContext));
  }
  
  @Deprecated
  public static void activateApp(Context paramContext, String paramString)
  {
    if (ActivityLifecycleTracker.isTracking())
    {
      Log.w(TAG, "activateApp events are being logged automatically. There's no need to call activateApp explicitly, this is safe to remove.");
      return;
    }
    if ((paramContext == null) || (paramString == null)) {
      throw new IllegalArgumentException("Both context and applicationId must be non-null");
    }
    if ((paramContext instanceof Activity)) {
      setSourceApplication((Activity)paramContext);
    }
    for (;;)
    {
      FacebookSdk.publishInstallAsync(paramContext, paramString);
      paramContext = new AppEventsLogger(paramContext, paramString, null);
      final long l = System.currentTimeMillis();
      paramString = getSourceApplication();
      backgroundExecutor.execute(new Runnable()
      {
        public void run()
        {
          val$logger.logAppSessionResumeEvent(l, val$sourceApplicationInfo);
        }
      });
      return;
      resetSourceApplication();
      Log.d(AppEventsLogger.class.getName(), "To set source application the context of activateApp must be an instance of Activity");
    }
  }
  
  @Deprecated
  public static void deactivateApp(Context paramContext)
  {
    if (ActivityLifecycleTracker.isTracking())
    {
      Log.w(TAG, "deactivateApp events are being logged automatically. There's no need to call deactivateApp, this is safe to remove.");
      return;
    }
    deactivateApp(paramContext, Utility.getMetadataApplicationId(paramContext));
  }
  
  @Deprecated
  public static void deactivateApp(Context paramContext, String paramString)
  {
    if (ActivityLifecycleTracker.isTracking())
    {
      Log.w(TAG, "deactivateApp events are being logged automatically. There's no need to call deactivateApp, this is safe to remove.");
      return;
    }
    if ((paramContext == null) || (paramString == null)) {
      throw new IllegalArgumentException("Both context and applicationId must be non-null");
    }
    resetSourceApplication();
    paramContext = new AppEventsLogger(paramContext, paramString, null);
    final long l = System.currentTimeMillis();
    backgroundExecutor.execute(new Runnable()
    {
      public void run()
      {
        val$logger.logAppSessionSuspendEvent(l);
      }
    });
  }
  
  static void eagerFlush()
  {
    if (getFlushBehavior() != FlushBehavior.EXPLICIT_ONLY) {
      AppEventQueue.flush(FlushReason.EAGER_FLUSHING_EVENT);
    }
  }
  
  public static String getAnonymousAppDeviceGUID(Context paramContext)
  {
    if (anonymousAppDeviceGUID == null) {}
    synchronized (staticLock)
    {
      if (anonymousAppDeviceGUID == null)
      {
        anonymousAppDeviceGUID = paramContext.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).getString("anonymousAppDeviceGUID", null);
        if (anonymousAppDeviceGUID == null)
        {
          anonymousAppDeviceGUID = "XZ" + UUID.randomUUID().toString();
          paramContext.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).edit().putString("anonymousAppDeviceGUID", anonymousAppDeviceGUID).apply();
        }
      }
      return anonymousAppDeviceGUID;
    }
  }
  
  public static FlushBehavior getFlushBehavior()
  {
    synchronized (staticLock)
    {
      FlushBehavior localFlushBehavior = flushBehavior;
      return localFlushBehavior;
    }
  }
  
  static String getPushNotificationsRegistrationId()
  {
    synchronized (staticLock)
    {
      String str = pushNotificationsRegistrationId;
      return str;
    }
  }
  
  static String getSourceApplication()
  {
    String str1 = "Unclassified";
    if (isOpenedByApplink) {
      str1 = "Applink";
    }
    String str2 = str1;
    if (sourceApplication != null) {
      str2 = str1 + "(" + sourceApplication + ")";
    }
    return str2;
  }
  
  private static void initializeTimersIfNeeded()
  {
    synchronized (staticLock)
    {
      if (backgroundExecutor != null) {
        return;
      }
      backgroundExecutor = new ScheduledThreadPoolExecutor(1);
      ??? = new Runnable()
      {
        public void run()
        {
          Object localObject = new HashSet();
          Iterator localIterator = AppEventQueue.getKeySet().iterator();
          while (localIterator.hasNext()) {
            ((Set)localObject).add(((AccessTokenAppIdPair)localIterator.next()).getApplicationId());
          }
          localObject = ((Set)localObject).iterator();
          while (((Iterator)localObject).hasNext()) {
            Utility.queryAppSettings((String)((Iterator)localObject).next(), true);
          }
        }
      };
      backgroundExecutor.scheduleAtFixedRate((Runnable)???, 0L, 86400L, TimeUnit.SECONDS);
      return;
    }
  }
  
  private void logAppSessionResumeEvent(long paramLong, String paramString)
  {
    PersistedAppSessionInfo.onResume(FacebookSdk.getApplicationContext(), accessTokenAppId, this, paramLong, paramString);
  }
  
  private void logAppSessionSuspendEvent(long paramLong)
  {
    PersistedAppSessionInfo.onSuspend(FacebookSdk.getApplicationContext(), accessTokenAppId, this, paramLong);
  }
  
  private static void logEvent(Context paramContext, AppEvent paramAppEvent, AccessTokenAppIdPair paramAccessTokenAppIdPair)
  {
    AppEventQueue.add(paramAccessTokenAppIdPair, paramAppEvent);
    if ((!paramAppEvent.getIsImplicit()) && (!isActivateAppEventRequested))
    {
      if (paramAppEvent.getName() == "fb_mobile_activate_app") {
        isActivateAppEventRequested = true;
      }
    }
    else {
      return;
    }
    Logger.log(LoggingBehavior.APP_EVENTS, "AppEvents", "Warning: Please call AppEventsLogger.activateApp(...)from the long-lived activity's onResume() methodbefore logging other app events.");
  }
  
  private void logEvent(String paramString, Double paramDouble, Bundle paramBundle, boolean paramBoolean, UUID paramUUID)
  {
    paramString = new AppEvent(contextName, paramString, paramDouble, paramBundle, paramBoolean, paramUUID);
    logEvent(FacebookSdk.getApplicationContext(), paramString, accessTokenAppId);
  }
  
  public static AppEventsLogger newLogger(Context paramContext)
  {
    return new AppEventsLogger(paramContext, null, null);
  }
  
  public static AppEventsLogger newLogger(Context paramContext, AccessToken paramAccessToken)
  {
    return new AppEventsLogger(paramContext, null, paramAccessToken);
  }
  
  public static AppEventsLogger newLogger(Context paramContext, String paramString)
  {
    return new AppEventsLogger(paramContext, paramString, null);
  }
  
  public static AppEventsLogger newLogger(Context paramContext, String paramString, AccessToken paramAccessToken)
  {
    return new AppEventsLogger(paramContext, paramString, paramAccessToken);
  }
  
  private static void notifyDeveloperError(String paramString)
  {
    Logger.log(LoggingBehavior.DEVELOPER_ERRORS, "AppEvents", paramString);
  }
  
  public static void onContextStop() {}
  
  static void resetSourceApplication()
  {
    sourceApplication = null;
    isOpenedByApplink = false;
  }
  
  public static void setFlushBehavior(FlushBehavior paramFlushBehavior)
  {
    synchronized (staticLock)
    {
      flushBehavior = paramFlushBehavior;
      return;
    }
  }
  
  public static void setPushNotificationsRegistrationId(String paramString)
  {
    synchronized (staticLock)
    {
      pushNotificationsRegistrationId = paramString;
      return;
    }
  }
  
  private static void setSourceApplication(Activity paramActivity)
  {
    Object localObject = paramActivity.getCallingActivity();
    if (localObject != null)
    {
      localObject = ((ComponentName)localObject).getPackageName();
      if (((String)localObject).equals(paramActivity.getPackageName()))
      {
        resetSourceApplication();
        return;
      }
      sourceApplication = (String)localObject;
    }
    paramActivity = paramActivity.getIntent();
    if ((paramActivity == null) || (paramActivity.getBooleanExtra("_fbSourceApplicationHasBeenSet", false)))
    {
      resetSourceApplication();
      return;
    }
    localObject = AppLinks.getAppLinkData(paramActivity);
    if (localObject == null)
    {
      resetSourceApplication();
      return;
    }
    isOpenedByApplink = true;
    localObject = ((Bundle)localObject).getBundle("referer_app_link");
    if (localObject == null)
    {
      sourceApplication = null;
      return;
    }
    sourceApplication = ((Bundle)localObject).getString("package");
    paramActivity.putExtra("_fbSourceApplicationHasBeenSet", true);
  }
  
  static void setSourceApplication(String paramString, boolean paramBoolean)
  {
    sourceApplication = paramString;
    isOpenedByApplink = paramBoolean;
  }
  
  public void flush()
  {
    AppEventQueue.flush(FlushReason.EXPLICIT);
  }
  
  public String getApplicationId()
  {
    return accessTokenAppId.getApplicationId();
  }
  
  public boolean isValidForAccessToken(AccessToken paramAccessToken)
  {
    paramAccessToken = new AccessTokenAppIdPair(paramAccessToken);
    return accessTokenAppId.equals(paramAccessToken);
  }
  
  public void logEvent(String paramString)
  {
    logEvent(paramString, null);
  }
  
  public void logEvent(String paramString, double paramDouble)
  {
    logEvent(paramString, paramDouble, null);
  }
  
  public void logEvent(String paramString, double paramDouble, Bundle paramBundle)
  {
    logEvent(paramString, Double.valueOf(paramDouble), paramBundle, false, ActivityLifecycleTracker.getCurrentSessionGuid());
  }
  
  public void logEvent(String paramString, Bundle paramBundle)
  {
    logEvent(paramString, null, paramBundle, false, ActivityLifecycleTracker.getCurrentSessionGuid());
  }
  
  public void logPurchase(BigDecimal paramBigDecimal, Currency paramCurrency)
  {
    logPurchase(paramBigDecimal, paramCurrency, null);
  }
  
  public void logPurchase(BigDecimal paramBigDecimal, Currency paramCurrency, Bundle paramBundle)
  {
    if (paramBigDecimal == null)
    {
      notifyDeveloperError("purchaseAmount cannot be null");
      return;
    }
    if (paramCurrency == null)
    {
      notifyDeveloperError("currency cannot be null");
      return;
    }
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putString("fb_currency", paramCurrency.getCurrencyCode());
    logEvent("fb_mobile_purchase", paramBigDecimal.doubleValue(), localBundle);
    eagerFlush();
  }
  
  public void logPushNotificationOpen(Bundle paramBundle)
  {
    logPushNotificationOpen(paramBundle, null);
  }
  
  public void logPushNotificationOpen(Bundle paramBundle, String paramString)
  {
    localBundle = null;
    try
    {
      paramBundle = paramBundle.getString("fb_push_payload");
      if (Utility.isNullOrEmpty(paramBundle)) {
        return;
      }
      paramBundle = new JSONObject(paramBundle).getString("campaign");
    }
    catch (JSONException paramBundle)
    {
      for (;;)
      {
        paramBundle = localBundle;
      }
    }
    if (paramBundle == null)
    {
      Logger.log(LoggingBehavior.DEVELOPER_ERRORS, TAG, "Malformed payload specified for logging a push notification open.");
      return;
    }
    localBundle = new Bundle();
    localBundle.putString("fb_push_campaign", paramBundle);
    if (paramString != null) {
      localBundle.putString("fb_push_action", paramString);
    }
    logEvent("fb_mobile_push_opened", localBundle);
  }
  
  public void logSdkEvent(String paramString, Double paramDouble, Bundle paramBundle)
  {
    logEvent(paramString, paramDouble, paramBundle, true, ActivityLifecycleTracker.getCurrentSessionGuid());
  }
  
  public static enum FlushBehavior
  {
    AUTO,  EXPLICIT_ONLY;
    
    private FlushBehavior() {}
  }
  
  static class PersistedAppSessionInfo
  {
    private static final String PERSISTED_SESSION_INFO_FILENAME = "AppEventsLogger.persistedsessioninfo";
    private static final Runnable appSessionInfoFlushRunnable = new Runnable()
    {
      public void run()
      {
        AppEventsLogger.PersistedAppSessionInfo.saveAppSessionInformation(FacebookSdk.getApplicationContext());
      }
    };
    private static Map<AccessTokenAppIdPair, FacebookTimeSpentData> appSessionInfoMap;
    private static boolean hasChanges;
    private static boolean isLoaded;
    private static final Object staticLock = new Object();
    
    static
    {
      hasChanges = false;
      isLoaded = false;
    }
    
    private static FacebookTimeSpentData getTimeSpentData(Context paramContext, AccessTokenAppIdPair paramAccessTokenAppIdPair)
    {
      restoreAppSessionInformation(paramContext);
      FacebookTimeSpentData localFacebookTimeSpentData = (FacebookTimeSpentData)appSessionInfoMap.get(paramAccessTokenAppIdPair);
      paramContext = localFacebookTimeSpentData;
      if (localFacebookTimeSpentData == null)
      {
        paramContext = new FacebookTimeSpentData();
        appSessionInfoMap.put(paramAccessTokenAppIdPair, paramContext);
      }
      return paramContext;
    }
    
    static void onResume(Context paramContext, AccessTokenAppIdPair paramAccessTokenAppIdPair, AppEventsLogger paramAppEventsLogger, long paramLong, String paramString)
    {
      synchronized (staticLock)
      {
        getTimeSpentData(paramContext, paramAccessTokenAppIdPair).onResume(paramAppEventsLogger, paramLong, paramString);
        onTimeSpentDataUpdate();
        return;
      }
    }
    
    static void onSuspend(Context paramContext, AccessTokenAppIdPair paramAccessTokenAppIdPair, AppEventsLogger paramAppEventsLogger, long paramLong)
    {
      synchronized (staticLock)
      {
        getTimeSpentData(paramContext, paramAccessTokenAppIdPair).onSuspend(paramAppEventsLogger, paramLong);
        onTimeSpentDataUpdate();
        return;
      }
    }
    
    private static void onTimeSpentDataUpdate()
    {
      if (!hasChanges)
      {
        hasChanges = true;
        AppEventsLogger.backgroundExecutor.schedule(appSessionInfoFlushRunnable, 30L, TimeUnit.SECONDS);
      }
    }
    
    /* Error */
    private static void restoreAppSessionInformation(Context paramContext)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore 5
      //   3: aconst_null
      //   4: astore_3
      //   5: aconst_null
      //   6: astore 4
      //   8: getstatic 30	com/facebook/appevents/AppEventsLogger$PersistedAppSessionInfo:staticLock	Ljava/lang/Object;
      //   11: astore 6
      //   13: aload 6
      //   15: monitorenter
      //   16: getstatic 34	com/facebook/appevents/AppEventsLogger$PersistedAppSessionInfo:isLoaded	Z
      //   19: istore_1
      //   20: iload_1
      //   21: ifne +72 -> 93
      //   24: new 98	java/io/ObjectInputStream
      //   27: dup
      //   28: aload_0
      //   29: ldc 13
      //   31: invokevirtual 104	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
      //   34: invokespecial 107	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
      //   37: astore_2
      //   38: aload_2
      //   39: invokevirtual 111	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
      //   42: checkcast 113	java/util/HashMap
      //   45: putstatic 46	com/facebook/appevents/AppEventsLogger$PersistedAppSessionInfo:appSessionInfoMap	Ljava/util/Map;
      //   48: getstatic 119	com/facebook/LoggingBehavior:APP_EVENTS	Lcom/facebook/LoggingBehavior;
      //   51: ldc 121
      //   53: ldc 123
      //   55: invokestatic 129	com/facebook/internal/Logger:log	(Lcom/facebook/LoggingBehavior;Ljava/lang/String;Ljava/lang/String;)V
      //   58: aload_2
      //   59: invokestatic 135	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
      //   62: aload_0
      //   63: ldc 13
      //   65: invokevirtual 139	android/content/Context:deleteFile	(Ljava/lang/String;)Z
      //   68: pop
      //   69: getstatic 46	com/facebook/appevents/AppEventsLogger$PersistedAppSessionInfo:appSessionInfoMap	Ljava/util/Map;
      //   72: ifnonnull +13 -> 85
      //   75: new 113	java/util/HashMap
      //   78: dup
      //   79: invokespecial 140	java/util/HashMap:<init>	()V
      //   82: putstatic 46	com/facebook/appevents/AppEventsLogger$PersistedAppSessionInfo:appSessionInfoMap	Ljava/util/Map;
      //   85: iconst_1
      //   86: putstatic 34	com/facebook/appevents/AppEventsLogger$PersistedAppSessionInfo:isLoaded	Z
      //   89: iconst_0
      //   90: putstatic 32	com/facebook/appevents/AppEventsLogger$PersistedAppSessionInfo:hasChanges	Z
      //   93: aload 6
      //   95: monitorexit
      //   96: return
      //   97: aload_2
      //   98: invokestatic 135	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
      //   101: aload_0
      //   102: ldc 13
      //   104: invokevirtual 139	android/content/Context:deleteFile	(Ljava/lang/String;)Z
      //   107: pop
      //   108: getstatic 46	com/facebook/appevents/AppEventsLogger$PersistedAppSessionInfo:appSessionInfoMap	Ljava/util/Map;
      //   111: ifnonnull +13 -> 124
      //   114: new 113	java/util/HashMap
      //   117: dup
      //   118: invokespecial 140	java/util/HashMap:<init>	()V
      //   121: putstatic 46	com/facebook/appevents/AppEventsLogger$PersistedAppSessionInfo:appSessionInfoMap	Ljava/util/Map;
      //   124: iconst_1
      //   125: putstatic 34	com/facebook/appevents/AppEventsLogger$PersistedAppSessionInfo:isLoaded	Z
      //   128: iconst_0
      //   129: putstatic 32	com/facebook/appevents/AppEventsLogger$PersistedAppSessionInfo:hasChanges	Z
      //   132: goto -39 -> 93
      //   135: aload 6
      //   137: monitorexit
      //   138: aload_0
      //   139: athrow
      //   140: astore 4
      //   142: aload 5
      //   144: astore_2
      //   145: aload_2
      //   146: astore_3
      //   147: invokestatic 144	com/facebook/appevents/AppEventsLogger:access$200	()Ljava/lang/String;
      //   150: new 146	java/lang/StringBuilder
      //   153: dup
      //   154: invokespecial 147	java/lang/StringBuilder:<init>	()V
      //   157: ldc -107
      //   159: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   162: aload 4
      //   164: invokevirtual 156	java/lang/Exception:toString	()Ljava/lang/String;
      //   167: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   170: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   173: invokestatic 163	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
      //   176: pop
      //   177: aload_2
      //   178: invokestatic 135	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
      //   181: aload_0
      //   182: ldc 13
      //   184: invokevirtual 139	android/content/Context:deleteFile	(Ljava/lang/String;)Z
      //   187: pop
      //   188: getstatic 46	com/facebook/appevents/AppEventsLogger$PersistedAppSessionInfo:appSessionInfoMap	Ljava/util/Map;
      //   191: ifnonnull +13 -> 204
      //   194: new 113	java/util/HashMap
      //   197: dup
      //   198: invokespecial 140	java/util/HashMap:<init>	()V
      //   201: putstatic 46	com/facebook/appevents/AppEventsLogger$PersistedAppSessionInfo:appSessionInfoMap	Ljava/util/Map;
      //   204: iconst_1
      //   205: putstatic 34	com/facebook/appevents/AppEventsLogger$PersistedAppSessionInfo:isLoaded	Z
      //   208: iconst_0
      //   209: putstatic 32	com/facebook/appevents/AppEventsLogger$PersistedAppSessionInfo:hasChanges	Z
      //   212: goto -119 -> 93
      //   215: aload_3
      //   216: invokestatic 135	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
      //   219: aload_0
      //   220: ldc 13
      //   222: invokevirtual 139	android/content/Context:deleteFile	(Ljava/lang/String;)Z
      //   225: pop
      //   226: getstatic 46	com/facebook/appevents/AppEventsLogger$PersistedAppSessionInfo:appSessionInfoMap	Ljava/util/Map;
      //   229: ifnonnull +13 -> 242
      //   232: new 113	java/util/HashMap
      //   235: dup
      //   236: invokespecial 140	java/util/HashMap:<init>	()V
      //   239: putstatic 46	com/facebook/appevents/AppEventsLogger$PersistedAppSessionInfo:appSessionInfoMap	Ljava/util/Map;
      //   242: iconst_1
      //   243: putstatic 34	com/facebook/appevents/AppEventsLogger$PersistedAppSessionInfo:isLoaded	Z
      //   246: iconst_0
      //   247: putstatic 32	com/facebook/appevents/AppEventsLogger$PersistedAppSessionInfo:hasChanges	Z
      //   250: aload_2
      //   251: athrow
      //   252: astore_0
      //   253: goto -118 -> 135
      //   256: astore 4
      //   258: aload_2
      //   259: astore_3
      //   260: aload 4
      //   262: astore_2
      //   263: goto -48 -> 215
      //   266: astore 4
      //   268: goto -123 -> 145
      //   271: astore_3
      //   272: goto -175 -> 97
      //   275: astore_2
      //   276: aload 4
      //   278: astore_2
      //   279: goto -182 -> 97
      //   282: astore_0
      //   283: goto -148 -> 135
      //   286: astore_2
      //   287: goto -72 -> 215
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	290	0	paramContext	Context
      //   19	2	1	bool	boolean
      //   37	226	2	localObject1	Object
      //   275	1	2	localFileNotFoundException1	java.io.FileNotFoundException
      //   278	1	2	localException1	Exception
      //   286	1	2	localObject2	Object
      //   4	256	3	localObject3	Object
      //   271	1	3	localFileNotFoundException2	java.io.FileNotFoundException
      //   6	1	4	localObject4	Object
      //   140	23	4	localException2	Exception
      //   256	5	4	localObject5	Object
      //   266	11	4	localException3	Exception
      //   1	142	5	localObject6	Object
      //   11	125	6	localObject7	Object
      // Exception table:
      //   from	to	target	type
      //   24	38	140	java/lang/Exception
      //   58	85	252	finally
      //   85	93	252	finally
      //   38	58	256	finally
      //   38	58	266	java/lang/Exception
      //   38	58	271	java/io/FileNotFoundException
      //   24	38	275	java/io/FileNotFoundException
      //   16	20	282	finally
      //   93	96	282	finally
      //   97	124	282	finally
      //   124	132	282	finally
      //   135	138	282	finally
      //   177	204	282	finally
      //   204	212	282	finally
      //   215	242	282	finally
      //   242	252	282	finally
      //   24	38	286	finally
      //   147	177	286	finally
    }
    
    /* Error */
    static void saveAppSessionInformation(Context paramContext)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore_2
      //   2: aconst_null
      //   3: astore_3
      //   4: getstatic 30	com/facebook/appevents/AppEventsLogger$PersistedAppSessionInfo:staticLock	Ljava/lang/Object;
      //   7: astore 4
      //   9: aload 4
      //   11: monitorenter
      //   12: getstatic 32	com/facebook/appevents/AppEventsLogger$PersistedAppSessionInfo:hasChanges	Z
      //   15: istore_1
      //   16: iload_1
      //   17: ifeq +50 -> 67
      //   20: new 166	java/io/ObjectOutputStream
      //   23: dup
      //   24: new 168	java/io/BufferedOutputStream
      //   27: dup
      //   28: aload_0
      //   29: ldc 13
      //   31: iconst_0
      //   32: invokevirtual 172	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
      //   35: invokespecial 175	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
      //   38: invokespecial 176	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
      //   41: astore_0
      //   42: aload_0
      //   43: getstatic 46	com/facebook/appevents/AppEventsLogger$PersistedAppSessionInfo:appSessionInfoMap	Ljava/util/Map;
      //   46: invokevirtual 180	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
      //   49: iconst_0
      //   50: putstatic 32	com/facebook/appevents/AppEventsLogger$PersistedAppSessionInfo:hasChanges	Z
      //   53: getstatic 119	com/facebook/LoggingBehavior:APP_EVENTS	Lcom/facebook/LoggingBehavior;
      //   56: ldc 121
      //   58: ldc -74
      //   60: invokestatic 129	com/facebook/internal/Logger:log	(Lcom/facebook/LoggingBehavior;Ljava/lang/String;Ljava/lang/String;)V
      //   63: aload_0
      //   64: invokestatic 135	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
      //   67: aload 4
      //   69: monitorexit
      //   70: return
      //   71: astore_2
      //   72: aload_3
      //   73: astore_0
      //   74: aload_2
      //   75: astore_3
      //   76: aload_0
      //   77: astore_2
      //   78: invokestatic 144	com/facebook/appevents/AppEventsLogger:access$200	()Ljava/lang/String;
      //   81: new 146	java/lang/StringBuilder
      //   84: dup
      //   85: invokespecial 147	java/lang/StringBuilder:<init>	()V
      //   88: ldc -72
      //   90: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   93: aload_3
      //   94: invokevirtual 156	java/lang/Exception:toString	()Ljava/lang/String;
      //   97: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   100: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   103: invokestatic 163	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
      //   106: pop
      //   107: aload_0
      //   108: invokestatic 135	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
      //   111: goto -44 -> 67
      //   114: aload 4
      //   116: monitorexit
      //   117: aload_0
      //   118: athrow
      //   119: astore_0
      //   120: aload_2
      //   121: invokestatic 135	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
      //   124: aload_0
      //   125: athrow
      //   126: astore_0
      //   127: goto -13 -> 114
      //   130: astore_3
      //   131: aload_0
      //   132: astore_2
      //   133: aload_3
      //   134: astore_0
      //   135: goto -15 -> 120
      //   138: astore_3
      //   139: goto -63 -> 76
      //   142: astore_0
      //   143: goto -29 -> 114
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	146	0	paramContext	Context
      //   15	2	1	bool	boolean
      //   1	1	2	localObject1	Object
      //   71	4	2	localException1	Exception
      //   77	56	2	localContext	Context
      //   3	91	3	localException2	Exception
      //   130	4	3	localObject2	Object
      //   138	1	3	localException3	Exception
      //   7	108	4	localObject3	Object
      // Exception table:
      //   from	to	target	type
      //   20	42	71	java/lang/Exception
      //   20	42	119	finally
      //   78	107	119	finally
      //   63	67	126	finally
      //   42	63	130	finally
      //   42	63	138	java/lang/Exception
      //   12	16	142	finally
      //   67	70	142	finally
      //   107	111	142	finally
      //   114	117	142	finally
      //   120	126	142	finally
    }
  }
}

/* Location:
 * Qualified Name:     com.facebook.appevents.AppEventsLogger
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */