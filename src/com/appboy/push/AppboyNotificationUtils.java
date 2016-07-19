package com.appboy.push;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat.Builder;
import com.appboy.Appboy;
import com.appboy.AppboyAdmReceiver;
import com.appboy.AppboyGcmReceiver;
import com.appboy.Constants;
import com.appboy.IAppboyNotificationFactory;
import com.appboy.configuration.XmlAppConfigurationProvider;
import com.appboy.support.AppboyImageUtils;
import com.appboy.support.AppboyLogger;
import com.appboy.support.IntentUtils;
import com.appboy.support.PackageUtils;
import com.appboy.support.PermissionUtils;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class AppboyNotificationUtils
{
  public static final String APPBOY_NOTIFICATION_OPENED_SUFFIX = ".intent.APPBOY_NOTIFICATION_OPENED";
  public static final String APPBOY_NOTIFICATION_RECEIVED_SUFFIX = ".intent.APPBOY_PUSH_RECEIVED";
  private static final String SOURCE_KEY = "source";
  private static final String TAG = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, AppboyNotificationUtils.class.getName() });
  
  @TargetApi(12)
  public static String bundleOptString(Bundle paramBundle, String paramString1, String paramString2)
  {
    if (Build.VERSION.SDK_INT >= 12) {
      paramBundle = paramBundle.getString(paramString1, paramString2);
    }
    do
    {
      return paramBundle;
      paramString1 = paramBundle.getString(paramString1);
      paramBundle = paramString1;
    } while (paramString1 != null);
    return paramString2;
  }
  
  public static void cancelNotification(Context paramContext, int paramInt)
  {
    try
    {
      Intent localIntent = new Intent("com.appboy.action.CANCEL_NOTIFICATION").setClass(paramContext, getNotificationReceiverClass());
      localIntent.putExtra("nid", paramInt);
      paramContext.sendBroadcast(localIntent);
      return;
    }
    catch (Exception paramContext)
    {
      AppboyLogger.e(TAG, "Exception occurred attempting to cancel notification.", paramContext);
    }
  }
  
  public static IAppboyNotificationFactory getActiveNotificationFactory()
  {
    IAppboyNotificationFactory localIAppboyNotificationFactory = Appboy.getCustomAppboyNotificationFactory();
    Object localObject = localIAppboyNotificationFactory;
    if (localIAppboyNotificationFactory == null) {
      localObject = AppboyNotificationFactory.getInstance();
    }
    return (IAppboyNotificationFactory)localObject;
  }
  
  @Deprecated
  public static Bundle getAppboyExtras(Bundle paramBundle)
  {
    Bundle localBundle;
    if (paramBundle == null) {
      localBundle = null;
    }
    do
    {
      return localBundle;
      localBundle = paramBundle;
    } while (Constants.IS_AMAZON.booleanValue());
    return paramBundle.getBundle("extra");
  }
  
  public static Bundle getAppboyExtrasWithoutPreprocessing(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return null;
    }
    if (!Constants.IS_AMAZON.booleanValue()) {
      return parseJSONStringDictionaryIntoBundle(bundleOptString(paramBundle, "extra", "{}"));
    }
    return new Bundle(paramBundle);
  }
  
  public static int getNotificationId(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      if (paramBundle.containsKey("n")) {
        try
        {
          i = Integer.parseInt(paramBundle.getString("n"));
          AppboyLogger.d(TAG, String.format("Using notification id provided in the message's extras bundle: " + i, new Object[0]));
          return i;
        }
        catch (NumberFormatException paramBundle)
        {
          AppboyLogger.e(TAG, String.format("Unable to parse notification id provided in the message's extras bundle. Using default notification id instead: -1", new Object[0]), paramBundle);
          return -1;
        }
      }
      int i = (bundleOptString(paramBundle, "t", "") + bundleOptString(paramBundle, "a", "")).hashCode();
      AppboyLogger.d(TAG, String.format("Message without notification id provided in the extras bundle received.  Using a hash of the message: " + i, new Object[0]));
      return i;
    }
    AppboyLogger.d(TAG, String.format("Message without extras bundle received.  Using default notification id: -1", new Object[0]));
    return -1;
  }
  
  @TargetApi(16)
  public static int getNotificationPriority(Bundle paramBundle)
  {
    if ((paramBundle != null) && (paramBundle.containsKey("p"))) {}
    try
    {
      int i = Integer.parseInt(paramBundle.getString("p"));
      if (isValidNotificationPriority(i)) {
        return i;
      }
      AppboyLogger.e(TAG, String.format("Received invalid notification priority %d", new Object[] { Integer.valueOf(i) }));
    }
    catch (NumberFormatException paramBundle)
    {
      for (;;)
      {
        AppboyLogger.e(TAG, String.format("Unable to parse custom priority. Returning default priority of 0", new Object[0]), paramBundle);
      }
    }
    return 0;
  }
  
  public static Class<?> getNotificationReceiverClass()
  {
    if (Constants.IS_AMAZON.booleanValue()) {
      return AppboyAdmReceiver.class;
    }
    return AppboyGcmReceiver.class;
  }
  
  static String getOptionalStringResource(Resources paramResources, int paramInt, String paramString)
  {
    try
    {
      paramResources = paramResources.getString(paramInt);
      return paramResources;
    }
    catch (Resources.NotFoundException paramResources) {}
    return paramString;
  }
  
  public static void handleCancelNotificationAction(Context paramContext, Intent paramIntent)
  {
    try
    {
      if (paramIntent.hasExtra("nid"))
      {
        int i = paramIntent.getIntExtra("nid", -1);
        ((NotificationManager)paramContext.getSystemService("notification")).cancel("appboy_notification", i);
      }
      return;
    }
    catch (Exception paramContext)
    {
      AppboyLogger.e(TAG, "Exception occurred handling cancel notification intent.", paramContext);
    }
  }
  
  public static void handleNotificationOpened(Context paramContext, Intent paramIntent)
  {
    try
    {
      logNotificationOpened(paramContext, paramIntent);
      sendNotificationOpenedBroadcast(paramContext, paramIntent);
      return;
    }
    catch (Exception paramContext)
    {
      AppboyLogger.e(TAG, "Exception occurred attempting to handle notification.", paramContext);
    }
  }
  
  public static boolean isAppboyPushMessage(Intent paramIntent)
  {
    paramIntent = paramIntent.getExtras();
    return (paramIntent != null) && ("true".equals(paramIntent.getString("_ab")));
  }
  
  public static boolean isNotificationMessage(Intent paramIntent)
  {
    paramIntent = paramIntent.getExtras();
    return (paramIntent != null) && (paramIntent.containsKey("t")) && (paramIntent.containsKey("a"));
  }
  
  public static boolean isUninstallTrackingPush(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      if (paramBundle.containsKey("appboy_uninstall_tracking")) {
        return true;
      }
      paramBundle = paramBundle.getBundle("extra");
      if (paramBundle != null) {
        return paramBundle.containsKey("appboy_uninstall_tracking");
      }
    }
    return false;
  }
  
  @TargetApi(16)
  public static boolean isValidNotificationPriority(int paramInt)
  {
    return (paramInt >= -2) && (paramInt <= 2);
  }
  
  @TargetApi(21)
  public static boolean isValidNotificationVisibility(int paramInt)
  {
    return (paramInt == -1) || (paramInt == 0) || (paramInt == 1);
  }
  
  public static void logBaiduNotificationClick(Context paramContext, String paramString)
  {
    if (paramString == null) {
      AppboyLogger.w(TAG, "customContentString was null. Doing nothing.");
    }
    for (;;)
    {
      return;
      try
      {
        Object localObject = new JSONObject(paramString);
        String str = ((JSONObject)localObject).optString("source", null);
        localObject = ((JSONObject)localObject).optString("cid", null);
        if ((str != null) && ("Appboy".equals(str)) && (localObject != null))
        {
          Appboy.getInstance(paramContext).logPushNotificationOpened((String)localObject);
          return;
        }
      }
      catch (Exception paramContext)
      {
        AppboyLogger.e(TAG, String.format("Caught an exception processing customContentString: %s", new Object[] { paramString }), paramContext);
      }
    }
  }
  
  private static void logNotificationOpened(Context paramContext, Intent paramIntent)
  {
    Appboy.getInstance(paramContext).logPushNotificationOpened(paramIntent);
  }
  
  public static Bundle parseJSONStringDictionaryIntoBundle(String paramString)
  {
    try
    {
      Bundle localBundle = new Bundle();
      JSONObject localJSONObject = new JSONObject(paramString);
      Iterator localIterator = localJSONObject.keys();
      for (;;)
      {
        paramString = localBundle;
        if (!localIterator.hasNext()) {
          break;
        }
        paramString = (String)localIterator.next();
        localBundle.putString(paramString, localJSONObject.getString(paramString));
      }
      return paramString;
    }
    catch (JSONException paramString)
    {
      AppboyLogger.e(TAG, String.format("Unable parse JSON into a bundle.", new Object[0]), paramString);
      paramString = null;
    }
  }
  
  static void sendNotificationOpenedBroadcast(Context paramContext, Intent paramIntent)
  {
    Intent localIntent = new Intent(PackageUtils.getResourcePackageName(paramContext) + ".intent.APPBOY_NOTIFICATION_OPENED");
    if (paramIntent.getExtras() != null) {
      localIntent.putExtras(paramIntent.getExtras());
    }
    paramContext.sendBroadcast(localIntent);
  }
  
  public static void sendPushMessageReceivedBroadcast(Context paramContext, Bundle paramBundle)
  {
    Intent localIntent = new Intent(paramContext.getPackageName() + ".intent.APPBOY_PUSH_RECEIVED");
    if (paramBundle != null) {
      localIntent.putExtras(paramBundle);
    }
    paramContext.sendBroadcast(localIntent);
  }
  
  public static void setAccentColorIfPresentAndSupported(XmlAppConfigurationProvider paramXmlAppConfigurationProvider, NotificationCompat.Builder paramBuilder, Bundle paramBundle)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      if ((paramBundle != null) && (paramBundle.containsKey("ac"))) {
        paramBuilder.setColor((int)Long.parseLong(paramBundle.getString("ac")));
      }
    }
    else {
      return;
    }
    paramBuilder.setColor(paramXmlAppConfigurationProvider.getDefaultNotificationAccentColor());
  }
  
  public static void setCategoryIfPresentAndSupported(NotificationCompat.Builder paramBuilder, Bundle paramBundle)
  {
    if ((Build.VERSION.SDK_INT >= 21) && (paramBundle != null) && (paramBundle.containsKey("ab_ct"))) {
      paramBuilder.setCategory(paramBundle.getString("ab_ct"));
    }
  }
  
  public static void setContentIfPresent(NotificationCompat.Builder paramBuilder, Bundle paramBundle)
  {
    if (paramBundle != null) {
      paramBuilder.setContentText(paramBundle.getString("a"));
    }
  }
  
  public static void setContentIntentIfPresent(Context paramContext, NotificationCompat.Builder paramBuilder, Bundle paramBundle)
  {
    try
    {
      Intent localIntent = new Intent("com.appboy.action.APPBOY_PUSH_CLICKED").setClass(paramContext, getNotificationReceiverClass());
      if (paramBundle != null) {
        localIntent.putExtras(paramBundle);
      }
      paramBuilder.setContentIntent(PendingIntent.getBroadcast(paramContext, IntentUtils.getRequestCode(), localIntent, 1073741824));
      return;
    }
    catch (Exception paramContext)
    {
      AppboyLogger.e(TAG, "Error setting content.", paramContext);
    }
  }
  
  @Deprecated
  public static boolean setLargeIconIfPresentAndSupported(Context paramContext, XmlAppConfigurationProvider paramXmlAppConfigurationProvider, NotificationCompat.Builder paramBuilder)
  {
    return setLargeIconIfPresentAndSupported(paramContext, paramXmlAppConfigurationProvider, paramBuilder, null);
  }
  
  public static boolean setLargeIconIfPresentAndSupported(Context paramContext, XmlAppConfigurationProvider paramXmlAppConfigurationProvider, NotificationCompat.Builder paramBuilder, Bundle paramBundle)
  {
    if (Build.VERSION.SDK_INT < 11) {}
    for (;;)
    {
      return false;
      if (paramBundle != null) {}
      try
      {
        if (paramBundle.containsKey("ab_li"))
        {
          paramBuilder.setLargeIcon(AppboyImageUtils.getBitmap(Uri.parse(paramBundle.getString("ab_li"))));
          return true;
        }
        int i = paramXmlAppConfigurationProvider.getLargeNotificationIconResourceId();
        if (i != 0)
        {
          paramBuilder.setLargeIcon(BitmapFactory.decodeResource(paramContext.getResources(), i));
          return true;
        }
      }
      catch (Exception paramContext)
      {
        AppboyLogger.e(TAG, "Error setting large notification icon", paramContext);
      }
    }
    return false;
  }
  
  public static void setNotificationDurationAlarm(Context paramContext, Class<?> paramClass, int paramInt1, int paramInt2)
  {
    paramClass = new Intent(paramContext, paramClass);
    paramClass.setAction("com.appboy.action.CANCEL_NOTIFICATION");
    paramClass.putExtra("nid", paramInt1);
    paramClass = PendingIntent.getBroadcast(paramContext, 0, paramClass, 134217728);
    paramContext = (AlarmManager)paramContext.getSystemService("alarm");
    if (paramInt2 >= 1000) {
      paramContext.set(3, SystemClock.elapsedRealtime() + paramInt2, paramClass);
    }
  }
  
  public static void setPriorityIfPresentAndSupported(NotificationCompat.Builder paramBuilder, Bundle paramBundle)
  {
    if ((Build.VERSION.SDK_INT >= 16) && (paramBundle != null)) {
      paramBuilder.setPriority(getNotificationPriority(paramBundle));
    }
  }
  
  public static void setPublicVersionIfPresentAndSupported(Context paramContext, XmlAppConfigurationProvider paramXmlAppConfigurationProvider, NotificationCompat.Builder paramBuilder, Bundle paramBundle)
  {
    if ((Build.VERSION.SDK_INT >= 21) && (paramBundle != null) && (paramBundle.containsKey("ab_pn")))
    {
      paramBundle = parseJSONStringDictionaryIntoBundle(paramBundle.getString("ab_pn"));
      paramContext = new NotificationCompat.Builder(paramContext);
      setContentIfPresent(paramContext, paramBundle);
      setTitleIfPresent(paramContext, paramBundle);
      setSummaryTextIfPresentAndSupported(paramContext, paramBundle);
      setSmallIcon(paramXmlAppConfigurationProvider, paramContext);
      setAccentColorIfPresentAndSupported(paramXmlAppConfigurationProvider, paramContext, paramBundle);
      paramBuilder.setPublicVersion(paramContext.build());
    }
  }
  
  public static int setSmallIcon(XmlAppConfigurationProvider paramXmlAppConfigurationProvider, NotificationCompat.Builder paramBuilder)
  {
    int j = paramXmlAppConfigurationProvider.getSmallNotificationIconResourceId();
    int i = j;
    if (j == 0)
    {
      AppboyLogger.d(TAG, "Small notification icon resource was not found. Will use the app icon when displaying notifications.");
      i = paramXmlAppConfigurationProvider.getApplicationIconResourceId();
    }
    paramBuilder.setSmallIcon(i);
    return i;
  }
  
  public static void setSoundIfPresentAndSupported(NotificationCompat.Builder paramBuilder, Bundle paramBundle)
  {
    if ((Build.VERSION.SDK_INT >= 11) && (paramBundle != null) && (paramBundle.containsKey("sd")))
    {
      paramBundle = paramBundle.getString("sd");
      if (paramBundle != null)
      {
        if (!paramBundle.equals("d")) {
          break label51;
        }
        paramBuilder.setDefaults(1);
      }
    }
    return;
    label51:
    paramBuilder.setSound(Uri.parse(paramBundle));
  }
  
  public static void setStyleIfSupported(Context paramContext, NotificationCompat.Builder paramBuilder, Bundle paramBundle1, Bundle paramBundle2)
  {
    if ((Build.VERSION.SDK_INT >= 16) && (paramBundle1 != null)) {
      paramBuilder.setStyle(AppboyNotificationStyleFactory.getBigNotificationStyle(paramContext, paramBundle1, paramBundle2));
    }
  }
  
  public static void setSummaryTextIfPresentAndSupported(NotificationCompat.Builder paramBuilder, Bundle paramBundle)
  {
    if ((Build.VERSION.SDK_INT >= 16) && (paramBundle != null) && (paramBundle.containsKey("s")))
    {
      paramBundle = paramBundle.getString("s");
      if (paramBundle != null) {
        paramBuilder.setSubText(paramBundle);
      }
    }
  }
  
  public static void setTickerIfPresent(NotificationCompat.Builder paramBuilder, Bundle paramBundle)
  {
    if (paramBundle != null) {
      paramBuilder.setTicker(paramBundle.getString("t"));
    }
  }
  
  public static void setTitleIfPresent(NotificationCompat.Builder paramBuilder, Bundle paramBundle)
  {
    if (paramBundle != null) {
      paramBuilder.setContentTitle(paramBundle.getString("t"));
    }
  }
  
  public static void setVisibilityIfPresentAndSupported(NotificationCompat.Builder paramBuilder, Bundle paramBundle)
  {
    if ((Build.VERSION.SDK_INT >= 21) && (paramBundle != null) && (paramBundle.containsKey("ab_vs"))) {
      try
      {
        int i = Integer.parseInt(paramBundle.getString("ab_vs"));
        if (isValidNotificationVisibility(i))
        {
          paramBuilder.setVisibility(i);
          return;
        }
        AppboyLogger.e(TAG, String.format("Received invalid notification visibility %d", new Object[] { Integer.valueOf(i) }));
        return;
      }
      catch (Exception paramBuilder)
      {
        AppboyLogger.e(TAG, "Failed to parse visibility from notificationExtras", paramBuilder);
      }
    }
  }
  
  public static boolean wakeScreenIfHasPermission(Context paramContext, Bundle paramBundle)
  {
    if (!PermissionUtils.hasPermission(paramContext, "android.permission.WAKE_LOCK")) {}
    while ((Build.VERSION.SDK_INT >= 16) && (getNotificationPriority(paramBundle) == -2)) {
      return false;
    }
    paramContext = ((PowerManager)paramContext.getSystemService("power")).newWakeLock(268435482, TAG);
    paramContext.acquire();
    paramContext.release();
    return true;
  }
}

/* Location:
 * Qualified Name:     com.appboy.push.AppboyNotificationUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */