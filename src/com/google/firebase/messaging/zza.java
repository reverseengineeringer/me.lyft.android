package com.google.firebase.messaging;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.KeyguardManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat.Builder;
import android.text.TextUtils;
import android.util.Log;
import com.google.firebase.iid.FirebaseInstanceIdInternalReceiver;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.MissingFormatArgumentException;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;

class zza
{
  static zza baX;
  private final Context mContext;
  private final AtomicInteger zzbeu = new AtomicInteger((int)SystemClock.elapsedRealtime());
  
  private zza(Context paramContext)
  {
    mContext = paramContext.getApplicationContext();
  }
  
  private PendingIntent zza(Bundle paramBundle, PendingIntent paramPendingIntent)
  {
    Intent localIntent = new Intent("com.google.firebase.messaging.NOTIFICATION_OPEN");
    zza(localIntent, paramBundle);
    localIntent.putExtra("pending_intent", paramPendingIntent);
    paramBundle = FirebaseInstanceIdInternalReceiver.zzi(mContext, localIntent);
    return PendingIntent.getBroadcast(mContext, zzbmd(), paramBundle, 1073741824);
  }
  
  private void zza(Intent paramIntent, Bundle paramBundle)
  {
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((str.startsWith("google.c.a.")) || (str.equals("from"))) {
        paramIntent.putExtra(str, paramBundle.getString(str));
      }
    }
  }
  
  private void zza(String paramString, Notification paramNotification)
  {
    if (Log.isLoggable("FirebaseMessaging", 3)) {
      Log.d("FirebaseMessaging", "Showing notification");
    }
    NotificationManager localNotificationManager = (NotificationManager)mContext.getSystemService("notification");
    String str = paramString;
    if (TextUtils.isEmpty(paramString))
    {
      long l = SystemClock.uptimeMillis();
      str = 37 + "GCM-Notification:" + l;
    }
    localNotificationManager.notify(str, 0, paramNotification);
  }
  
  static boolean zzac(Bundle paramBundle)
  {
    return ("1".equals(zzf(paramBundle, "gcm.n.e"))) || (zzf(paramBundle, "gcm.n.icon") != null);
  }
  
  private Notification zzaf(Bundle paramBundle)
  {
    String str1 = zzg(paramBundle, "gcm.n.title");
    String str2 = zzg(paramBundle, "gcm.n.body");
    int i = zzkb(zzf(paramBundle, "gcm.n.icon"));
    String str3 = zzf(paramBundle, "gcm.n.color");
    Uri localUri = zzkc(zzat(paramBundle));
    PendingIntent localPendingIntent3 = zzag(paramBundle);
    PendingIntent localPendingIntent2 = null;
    PendingIntent localPendingIntent1 = localPendingIntent3;
    if (FirebaseMessagingService.zzav(paramBundle))
    {
      localPendingIntent1 = zza(paramBundle, localPendingIntent3);
      localPendingIntent2 = zzau(paramBundle);
    }
    paramBundle = new NotificationCompat.Builder(mContext).setAutoCancel(true).setSmallIcon(i);
    if (!TextUtils.isEmpty(str1)) {
      paramBundle.setContentTitle(str1);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(str2)) {
        paramBundle.setContentText(str2);
      }
      if (!TextUtils.isEmpty(str3)) {
        paramBundle.setColor(Color.parseColor(str3));
      }
      if (localUri != null) {
        paramBundle.setSound(localUri);
      }
      if (localPendingIntent1 != null) {
        paramBundle.setContentIntent(localPendingIntent1);
      }
      if (localPendingIntent2 != null) {
        paramBundle.setDeleteIntent(localPendingIntent2);
      }
      return paramBundle.build();
      paramBundle.setContentTitle(mContext.getApplicationInfo().loadLabel(mContext.getPackageManager()));
    }
  }
  
  private PendingIntent zzag(Bundle paramBundle)
  {
    Object localObject = zzf(paramBundle, "gcm.n.click_action");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = new Intent((String)localObject);
      ((Intent)localObject).setPackage(mContext.getPackageName());
      ((Intent)localObject).setFlags(268435456);
    }
    label168:
    for (;;)
    {
      paramBundle = new Bundle(paramBundle);
      FirebaseMessagingService.zzab(paramBundle);
      ((Intent)localObject).putExtras(paramBundle);
      paramBundle = paramBundle.keySet().iterator();
      while (paramBundle.hasNext())
      {
        String str = (String)paramBundle.next();
        if ((str.startsWith("gcm.n.")) || (str.startsWith("gcm.notification.")))
        {
          ((Intent)localObject).removeExtra(str);
          continue;
          localObject = mContext.getPackageManager().getLaunchIntentForPackage(mContext.getPackageName());
          if (localObject != null) {
            break label168;
          }
          Log.w("FirebaseMessaging", "No activity found to launch app");
          return null;
        }
      }
      return PendingIntent.getActivity(mContext, zzbmd(), (Intent)localObject, 1073741824);
    }
  }
  
  static String zzat(Bundle paramBundle)
  {
    String str2 = zzf(paramBundle, "gcm.n.sound2");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = zzf(paramBundle, "gcm.n.sound");
    }
    return str1;
  }
  
  private PendingIntent zzau(Bundle paramBundle)
  {
    Intent localIntent = new Intent("com.google.firebase.messaging.NOTIFICATION_DISMISS");
    zza(localIntent, paramBundle);
    paramBundle = FirebaseInstanceIdInternalReceiver.zzi(mContext, localIntent);
    return PendingIntent.getBroadcast(mContext, zzbmd(), paramBundle, 1073741824);
  }
  
  private int zzbmd()
  {
    return zzbeu.incrementAndGet();
  }
  
  static boolean zzdc(Context paramContext)
  {
    if (((KeyguardManager)paramContext.getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {}
    int i;
    ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo;
    do
    {
      while (!paramContext.hasNext())
      {
        do
        {
          return false;
          i = Process.myPid();
          paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
        } while (paramContext == null);
        paramContext = paramContext.iterator();
      }
      localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
    } while (pid != i);
    if (importance == 100) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  static zza zzeo(Context paramContext)
  {
    try
    {
      if (baX == null) {
        baX = new zza(paramContext);
      }
      paramContext = baX;
      return paramContext;
    }
    finally {}
  }
  
  static String zzf(Bundle paramBundle, String paramString)
  {
    String str2 = paramBundle.getString(paramString);
    String str1 = str2;
    if (str2 == null) {
      str1 = paramBundle.getString(paramString.replace("gcm.n.", "gcm.notification."));
    }
    return str1;
  }
  
  private String zzg(Bundle paramBundle, String paramString)
  {
    String str = zzf(paramBundle, paramString);
    if (!TextUtils.isEmpty(str)) {
      return str;
    }
    str = zzh(paramBundle, paramString);
    if (TextUtils.isEmpty(str)) {
      return null;
    }
    Resources localResources = mContext.getResources();
    int i = localResources.getIdentifier(str, "string", mContext.getPackageName());
    if (i == 0)
    {
      paramBundle = String.valueOf(paramString);
      paramString = String.valueOf("_loc_key");
      if (paramString.length() != 0) {}
      for (paramBundle = paramBundle.concat(paramString);; paramBundle = new String(paramBundle))
      {
        paramBundle = String.valueOf(zzka(paramBundle));
        Log.w("FirebaseMessaging", String.valueOf(paramBundle).length() + 49 + String.valueOf(str).length() + paramBundle + " resource not found: " + str + " Default value will be used.");
        return null;
      }
    }
    paramBundle = zzi(paramBundle, paramString);
    if (paramBundle == null) {
      return localResources.getString(i);
    }
    try
    {
      paramString = localResources.getString(i, paramBundle);
      return paramString;
    }
    catch (MissingFormatArgumentException paramString)
    {
      paramBundle = String.valueOf(Arrays.toString(paramBundle));
      Log.w("FirebaseMessaging", String.valueOf(str).length() + 58 + String.valueOf(paramBundle).length() + "Missing format argument for " + str + ": " + paramBundle + " Default value will be used.", paramString);
    }
    return null;
  }
  
  static String zzh(Bundle paramBundle, String paramString)
  {
    paramString = String.valueOf(paramString);
    String str = String.valueOf("_loc_key");
    if (str.length() != 0) {}
    for (paramString = paramString.concat(str);; paramString = new String(paramString)) {
      return zzf(paramBundle, paramString);
    }
  }
  
  static Object[] zzi(Bundle paramBundle, String paramString)
  {
    Object localObject = String.valueOf(paramString);
    String str = String.valueOf("_loc_args");
    if (str.length() != 0)
    {
      localObject = ((String)localObject).concat(str);
      str = zzf(paramBundle, (String)localObject);
      if (!TextUtils.isEmpty(str)) {
        break label59;
      }
      paramBundle = null;
    }
    for (;;)
    {
      return paramBundle;
      localObject = new String((String)localObject);
      break;
      try
      {
        label59:
        JSONArray localJSONArray = new JSONArray(str);
        localObject = new String[localJSONArray.length()];
        int i = 0;
        for (;;)
        {
          paramBundle = (Bundle)localObject;
          if (i >= localObject.length) {
            break;
          }
          localObject[i] = localJSONArray.opt(i);
          i += 1;
        }
        paramBundle = paramBundle.concat(paramString);
      }
      catch (JSONException paramBundle)
      {
        paramBundle = String.valueOf(paramString);
        paramString = String.valueOf("_loc_args");
        if (paramString.length() == 0) {}
      }
    }
    for (;;)
    {
      paramBundle = String.valueOf(zzka(paramBundle));
      Log.w("FirebaseMessaging", String.valueOf(paramBundle).length() + 41 + String.valueOf(str).length() + "Malformed " + paramBundle + ": " + str + "  Default value will be used.");
      return null;
      paramBundle = new String(paramBundle);
    }
  }
  
  private static String zzka(String paramString)
  {
    return paramString.substring("gcm.n.".length());
  }
  
  private int zzkb(String paramString)
  {
    Resources localResources;
    int i;
    if (!TextUtils.isEmpty(paramString))
    {
      localResources = mContext.getResources();
      i = localResources.getIdentifier(paramString, "drawable", mContext.getPackageName());
      if (i == 0) {}
    }
    int j;
    do
    {
      do
      {
        return i;
        j = localResources.getIdentifier(paramString, "mipmap", mContext.getPackageName());
        i = j;
      } while (j != 0);
      Log.w("FirebaseMessaging", String.valueOf(paramString).length() + 57 + "Icon resource " + paramString + " not found. Notification will use app icon.");
      j = mContext.getApplicationInfo().icon;
      i = j;
    } while (j != 0);
    return 17301651;
  }
  
  private Uri zzkc(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if ((!"default".equals(paramString)) && (mContext.getResources().getIdentifier(paramString, "raw", mContext.getPackageName()) != 0))
    {
      String str1 = String.valueOf("android.resource://");
      String str2 = String.valueOf(mContext.getPackageName());
      return Uri.parse(String.valueOf(str1).length() + 5 + String.valueOf(str2).length() + String.valueOf(paramString).length() + str1 + str2 + "/raw/" + paramString);
    }
    return RingtoneManager.getDefaultUri(2);
  }
  
  void zzas(Bundle paramBundle)
  {
    Notification localNotification = zzaf(paramBundle);
    zza(zzf(paramBundle, "gcm.n.tag"), localNotification);
  }
}

/* Location:
 * Qualified Name:     com.google.firebase.messaging.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */