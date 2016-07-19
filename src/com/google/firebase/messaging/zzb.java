package com.google.firebase.messaging;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.measurement.AppMeasurement;

class zzb
{
  static AppMeasurement aOC;
  
  private static void zzc(Context paramContext, String paramString, Intent paramIntent)
  {
    Bundle localBundle = new Bundle();
    String str = paramIntent.getStringExtra("google.c.a.c_id");
    if (str != null) {
      localBundle.putString("_nmid", str);
    }
    str = paramIntent.getStringExtra("google.c.a.c_l");
    if (str != null) {
      localBundle.putString("_nmn", str);
    }
    str = paramIntent.getStringExtra("from");
    if ((str != null) && (str.startsWith("/topics/"))) {}
    for (;;)
    {
      if (str != null) {
        localBundle.putString("_nt", str);
      }
      try
      {
        localBundle.putInt("_nmt", Integer.valueOf(paramIntent.getStringExtra("google.c.a.ts")).intValue());
        if (!paramIntent.hasExtra("google.c.a.udt")) {}
      }
      catch (NumberFormatException localNumberFormatException)
      {
        try
        {
          localBundle.putInt("_ndt", Integer.valueOf(paramIntent.getStringExtra("google.c.a.udt")).intValue());
          if (Log.isLoggable("FirebaseMessaging", 3))
          {
            paramIntent = String.valueOf(localBundle);
            Log.d("FirebaseMessaging", String.valueOf(paramString).length() + 22 + String.valueOf(paramIntent).length() + "Sending event=" + paramString + " params=" + paramIntent);
          }
          paramContext = zzep(paramContext);
          if (paramContext != null)
          {
            paramContext.zzd("fcm", paramString, localBundle);
            return;
            str = null;
            continue;
            localNumberFormatException = localNumberFormatException;
            Log.w("FirebaseMessaging", "Error while parsing timestamp in GCM event", localNumberFormatException);
          }
        }
        catch (NumberFormatException paramIntent)
        {
          for (;;)
          {
            Log.w("FirebaseMessaging", "Error while parsing use_device_time in GCM event", paramIntent);
          }
          Log.w("FirebaseMessaging", "Unable to log event, missing measurement library");
        }
      }
    }
  }
  
  private static AppMeasurement zzep(Context paramContext)
  {
    if (0 == 0) {}
    try
    {
      return AppMeasurement.getInstance(paramContext);
    }
    catch (NoClassDefFoundError paramContext) {}
    paramContext = aOC;
    return paramContext;
    return null;
  }
  
  public static void zzl(Context paramContext, Intent paramIntent)
  {
    zzc(paramContext, "_nr", paramIntent);
  }
  
  public static void zzm(Context paramContext, Intent paramIntent)
  {
    zzp(paramContext, paramIntent);
    zzc(paramContext, "_no", paramIntent);
  }
  
  public static void zzn(Context paramContext, Intent paramIntent)
  {
    zzc(paramContext, "_nd", paramIntent);
  }
  
  public static void zzo(Context paramContext, Intent paramIntent)
  {
    zzc(paramContext, "_nf", paramIntent);
  }
  
  private static void zzp(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    while (!"1".equals(paramIntent.getStringExtra("google.c.a.tc"))) {
      return;
    }
    paramContext = zzep(paramContext);
    if (paramContext != null)
    {
      paramIntent = paramIntent.getStringExtra("google.c.a.c_id");
      paramContext.zzb("fcm", "_ln", paramIntent);
      Bundle localBundle = new Bundle();
      localBundle.putString("source", "Firebase");
      localBundle.putString("medium", "notification");
      localBundle.putString("campaign", paramIntent);
      paramContext.zzd("fcm", "_cmp", localBundle);
      return;
    }
    Log.w("FirebaseMessaging", "Unable to set user property for event tracking, missing measurement library");
  }
}

/* Location:
 * Qualified Name:     com.google.firebase.messaging.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */