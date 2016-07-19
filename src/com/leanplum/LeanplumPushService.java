package com.leanplum;

import android.app.Activity;
import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat.BigTextStyle;
import android.support.v4.app.NotificationCompat.Builder;
import android.util.Log;
import com.leanplum.callbacks.VariablesChangedCallback;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class LeanplumPushService
  extends IntentService
{
  public static final String LEANPLUM_SENDER_ID = "44059457771";
  private static LeanplumPushNotificationCustomizer a;
  private static String b;
  
  public LeanplumPushService()
  {
    super("LeanplumPushService");
  }
  
  private static int a(Context paramContext)
  {
    try
    {
      int i = getPackageManagergetPackageInfogetPackageName0versionCode;
      return i;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      throw new RuntimeException("Could not get package name: " + paramContext);
    }
  }
  
  static Class<? extends Activity> a()
  {
    return null;
  }
  
  static void a(Context paramContext, String paramString)
  {
    Leanplum.a(paramString);
    paramContext = paramContext.getApplicationContext();
    SharedPreferences localSharedPreferences = b(paramContext);
    int i = a(paramContext);
    if (g.m) {
      Log.i("Leanplum", "Saving GCM registration on app version " + i);
    }
    paramContext = localSharedPreferences.edit();
    paramContext.putString("registration_id", paramString);
    paramContext.putInt("appVersion", i);
    try
    {
      paramContext.apply();
      Log.i("Leanplum", "Device registered for push notifications with registrationId " + paramString);
      return;
    }
    catch (NoSuchMethodError localNoSuchMethodError)
    {
      for (;;)
      {
        paramContext.commit();
      }
    }
  }
  
  static void a(String paramString, VariablesChangedCallback paramVariablesChangedCallback)
  {
    Leanplum.addOnceVariablesChangedAndNoDownloadsPendingHandler(new Q(paramString, paramVariablesChangedCallback));
  }
  
  static boolean a(Bundle paramBundle)
  {
    return paramBundle.containsKey("_lpx");
  }
  
  private static boolean a(String paramString)
  {
    Context localContext = Leanplum.a();
    String str = GcmBroadcastReceiver.class.getName();
    Iterator localIterator = localContext.getPackageManager().queryBroadcastReceivers(new Intent(paramString), 0).iterator();
    ResolveInfo localResolveInfo;
    do
    {
      if (!localIterator.hasNext())
      {
        Log.e("Leanplum", "Push notifications requires you to add the receiver " + str + " to your AndroidManifest.xml file with the " + paramString + " intent filter. Add this code within the <application> section:\n<receiver android:name=\"" + str + "\"\n    android:permission=\"com.google.android.c2dm.permission.SEND\">\n" + "    <intent-filter>\n        <action android:name=\"" + "com.google.android.c2dm.intent.RECEIVE\" />\n" + "        <action android:name=\"com.google.android.c2dm.intent.REGISTRATION" + "\" />\n        <category android:name=\"" + localContext.getPackageName() + "\" />\n    </intent-filter>\n" + "</receiver>");
        return false;
      }
      localResolveInfo = (ResolveInfo)localIterator.next();
    } while ((!activityInfo.name.equals(str)) || (!activityInfo.packageName.equals(localContext.getPackageName())));
    return true;
  }
  
  private static boolean a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (Leanplum.a().checkCallingOrSelfPermission(paramString) != 0)
    {
      if (paramBoolean1) {}
      for (String str = "<permission android:name=\"" + paramString + "\" android:protectionLevel=\"signature\" />\n";; str = "")
      {
        if (paramBoolean2) {
          Log.e("Leanplum", "In order to use push notifications, you need to enable the " + paramString + " permission in your AndroidManifest.xml file. Add this within the <manifest> section:\n" + str + "<uses-permission android:name=\"" + paramString + "\" />");
        }
        return false;
      }
    }
    return true;
  }
  
  private static SharedPreferences b(Context paramContext)
  {
    return paramContext.getSharedPreferences("__leanplum_push__", 0);
  }
  
  static String b(Bundle paramBundle)
  {
    String str2 = paramBundle.getString("_lpm");
    String str1 = str2;
    if (str2 == null)
    {
      str2 = paramBundle.getString("_lpu");
      str1 = str2;
      if (str2 == null)
      {
        str2 = paramBundle.getString("_lpn");
        str1 = str2;
        if (str2 == null) {
          str1 = paramBundle.getString("_lpv");
        }
      }
    }
    if (str1 != null) {
      paramBundle.putString("lp_messageId", str1);
    }
    return str1;
  }
  
  static void b()
  {
    for (;;)
    {
      Context localContext;
      SharedPreferences localSharedPreferences;
      String str2;
      try
      {
        if (!Util.i()) {
          break;
        }
        Object localObject = Leanplum.a();
        if ((b == null) || (!a("com.google.android.c2dm.permission.RECEIVE", false, true)) || ((!a(((Context)localObject).getPackageName() + ".gcm.permission.C2D_MESSAGE", true, false)) && (!a(((Context)localObject).getPackageName() + ".permission.C2D_MESSAGE", true, true))) || (!a("com.google.android.c2dm.intent.RECEIVE")) || (!a("com.google.android.c2dm.intent.REGISTRATION"))) {
          return;
        }
        if (!c()) {
          return;
        }
        localContext = ((Context)localObject).getApplicationContext();
        localSharedPreferences = b(localContext);
        localObject = localSharedPreferences.getString("registration_id", "");
        str2 = localSharedPreferences.getString("sender_ids", "");
        if (((String)localObject).length() == 0)
        {
          Log.i("Leanplum", "GCM registration not found.");
          localObject = "";
          if (((String)localObject).length() != 0) {
            return;
          }
          localObject = new Intent("com.google.android.c2dm.intent.REGISTER");
          localContext = Leanplum.a();
          ((Intent)localObject).putExtra("app", PendingIntent.getBroadcast(localContext, 0, new Intent(), 0));
          ((Intent)localObject).putExtra("sender", b);
          ((Intent)localObject).setPackage("com.google.android.gms");
          localContext.startService((Intent)localObject);
          return;
        }
      }
      catch (Exception localException)
      {
        Log.e("Leanplum", "There was an error registering for push notifications.", localException);
        return;
      }
      String str1;
      if (str2.equals(b))
      {
        Log.i("Leanplum", "GCM sender IDs have changed.");
        str1 = "";
      }
      else if (localSharedPreferences.getInt("appVersion", Integer.MIN_VALUE) != a(localContext))
      {
        str1 = "";
      }
    }
    Log.i("Leanplum", "No valid Google Play Services APK found.");
  }
  
  private void c(Bundle paramBundle)
  {
    NotificationManager localNotificationManager = (NotificationManager)getSystemService("notification");
    Object localObject1 = new Intent(this, GcmBroadcastReceiver.class);
    ((Intent)localObject1).addCategory("lpAction");
    ((Intent)localObject1).putExtras(paramBundle);
    Object localObject2 = PendingIntent.getBroadcast(getApplicationContext(), new Random().nextInt(), (Intent)localObject1, 0);
    localObject1 = getApplicationContext();
    int i = getApplicationInfolabelRes;
    if (i == 0)
    {
      localObject1 = ((Context)localObject1).getApplicationInfo().loadLabel(((Context)localObject1).getPackageManager()).toString();
      if (paramBundle.getString("title") != null) {
        localObject1 = paramBundle.getString("title");
      }
      localObject1 = new NotificationCompat.Builder(this).setSmallIcon(getApplicationInfoicon).setContentTitle((CharSequence)localObject1).setStyle(new NotificationCompat.BigTextStyle().bigText(paramBundle.getString("lp_message"))).setContentText(paramBundle.getString("lp_message"));
      ((NotificationCompat.Builder)localObject1).setAutoCancel(true);
      ((NotificationCompat.Builder)localObject1).setContentIntent((PendingIntent)localObject2);
      if (a != null) {
        a.customize((NotificationCompat.Builder)localObject1, paramBundle);
      }
      localObject2 = paramBundle.get("lp_notificationId");
      if (!(localObject2 instanceof Number)) {
        break label238;
      }
      i = ((Number)localObject2).intValue();
    }
    for (;;)
    {
      localNotificationManager.notify(i, ((NotificationCompat.Builder)localObject1).build());
      return;
      localObject1 = ((Context)localObject1).getString(i);
      break;
      label238:
      if ((localObject2 instanceof String)) {}
      try
      {
        i = Integer.parseInt((String)localObject2);
      }
      catch (NumberFormatException paramBundle)
      {
        i = 1;
      }
      if (paramBundle.containsKey("lp_messageId")) {
        i = paramBundle.getString("lp_messageId").hashCode();
      }
    }
  }
  
  private static boolean c()
  {
    String str = LeanplumPushService.class.getName();
    Context localContext = Leanplum.a();
    try
    {
      localContext.getPackageManager().getServiceInfo(new ComponentName(localContext.getPackageName(), str), 0);
      return true;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      Log.e("Leanplum", "Push notifications requires you to add the following service to your AndroidManifest.xml file within the <application> section:\n<service android:name=\"" + str + "\" />");
    }
    return false;
  }
  
  public static void setCustomizer(LeanplumPushNotificationCustomizer paramLeanplumPushNotificationCustomizer)
  {
    a = paramLeanplumPushNotificationCustomizer;
  }
  
  public static void setGcmSenderId(String paramString)
  {
    b = paramString;
  }
  
  public static void setGcmSenderIds(String... paramVarArgs)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int j = paramVarArgs.length;
    int i = 0;
    for (;;)
    {
      if (i >= j)
      {
        b = localStringBuffer.toString();
        return;
      }
      String str = paramVarArgs[i];
      if (localStringBuffer.length() > 0) {
        localStringBuffer.append(',');
      }
      localStringBuffer.append(str);
      i += 1;
    }
  }
  
  public static void unregister()
  {
    Intent localIntent = new Intent("com.google.android.c2dm.intent.UNREGISTER");
    Context localContext = Leanplum.a();
    localIntent.putExtra("app", PendingIntent.getBroadcast(localContext, 0, new Intent(), 0));
    localIntent.setPackage("com.google.android.gms");
    localContext.startService(localIntent);
  }
  
  protected void onHandleIntent(Intent paramIntent)
  {
    Bundle localBundle = paramIntent.getExtras();
    Object localObject1;
    if (!"com.google.android.c2dm.intent.RECEIVE".equals(paramIntent.getAction()))
    {
      localObject1 = null;
      if ((!localBundle.isEmpty()) && ((localObject1 == null) || ("gcm".equals(localObject1)))) {
        if ((localBundle.containsKey("lp_message")) && (((!localBundle.containsKey("_lpu")) && (!localBundle.containsKey("_lpv"))) || (LeanplumActivityHelper.b == null) || (LeanplumActivityHelper.a)))
        {
          localObject1 = b(localBundle);
          if (localObject1 != null) {
            break label158;
          }
          c(localBundle);
        }
      }
    }
    for (;;)
    {
      Log.i("Leanplum", "Received: " + localBundle.toString());
      GcmBroadcastReceiver.completeWakefulIntent(paramIntent);
      return;
      Object localObject2 = paramIntent.getStringExtra("message_type");
      localObject1 = localObject2;
      if (localObject2 != null) {
        break;
      }
      localObject1 = "gcm";
      break;
      label158:
      if (!Leanplum.a)
      {
        c(localBundle);
      }
      else
      {
        localObject2 = new P(this, (String)localObject1, localBundle);
        if (localBundle.containsKey("_lpx")) {
          ((VariablesChangedCallback)localObject2).variablesChanged();
        } else {
          a((String)localObject1, (VariablesChangedCallback)localObject2);
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.leanplum.LeanplumPushService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */