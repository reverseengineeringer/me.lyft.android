package com.google.android.gms.measurement;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Keep;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.util.zzf;
import com.google.android.gms.measurement.internal.zzac;
import com.google.android.gms.measurement.internal.zzx;
import java.util.Map;

@Deprecated
public class AppMeasurement
{
  private final zzx aja;
  
  public AppMeasurement(zzx paramzzx)
  {
    zzab.zzaa(paramzzx);
    aja = paramzzx;
  }
  
  @Deprecated
  @Keep
  public static AppMeasurement getInstance(Context paramContext)
  {
    return zzx.zzdo(paramContext).zzbun();
  }
  
  private void zzc(String paramString1, String paramString2, Object paramObject)
  {
    aja.zzbsq().zzd(paramString1, paramString2, paramObject);
  }
  
  public void zzb(String paramString1, String paramString2, Object paramObject)
  {
    zzc(paramString1, paramString2, paramObject);
  }
  
  public void zzd(String paramString1, String paramString2, Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    aja.zzbsq().zze(paramString1, paramString2, localBundle);
  }
  
  public static final class zza
  {
    public static final Map<String, String> ajb = zzf.zzb(new String[] { "app_clear_data", "app_exception", "app_uninstall", "app_update", "firebase_campaign", "error", "first_open", "in_app_purchase", "notification_dismiss", "notification_foreground", "notification_open", "notification_receive", "os_update", "session_start", "user_engagement" }, new String[] { "_cd", "_ae", "_ui", "_au", "_cmp", "_err", "_f", "_iap", "_nd", "_nf", "_no", "_nr", "_ou", "_s", "_e" });
  }
  
  public static abstract interface zzb
  {
    public abstract void zzb(String paramString1, String paramString2, Bundle paramBundle, long paramLong);
  }
  
  public static abstract interface zzc
  {
    public abstract void zzc(String paramString1, String paramString2, Bundle paramBundle, long paramLong);
  }
  
  public static final class zzd
  {
    public static final Map<String, String> ajc = zzf.zzb(new String[] { "firebase_conversion", "engagement_time_msec", "firebase_error", "error_value", "firebase_event_origin", "message_device_time", "message_id", "message_name", "message_time", "previous_app_version", "previous_os_version", "topic" }, new String[] { "_c", "_et", "_err", "_ev", "_o", "_ndt", "_nmid", "_nmn", "_nmt", "_pv", "_po", "_nt" });
  }
  
  public static final class zze
  {
    public static final Map<String, String> ajd = zzf.zzb(new String[] { "firebase_last_notification", "first_open_time", "last_deep_link_referrer", "user_id" }, new String[] { "_ln", "_fot", "_ldl", "_id" });
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.measurement.AppMeasurement
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */