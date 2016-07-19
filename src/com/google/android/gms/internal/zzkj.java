package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import java.util.concurrent.Future;

@zzir
public final class zzkj
{
  public static Future zza(Context paramContext, final zzb paramzzb)
  {
    (Future)new zza(paramContext)
    {
      public void zzew()
      {
        SharedPreferences localSharedPreferences = zzkj.zzn(zzkj.this);
        Bundle localBundle = new Bundle();
        localBundle.putBoolean("use_https", localSharedPreferences.getBoolean("use_https", true));
        if (paramzzb != null) {
          paramzzb.zzg(localBundle);
        }
      }
    }.zzpz();
  }
  
  public static Future zza(Context paramContext, final String paramString, final long paramLong)
  {
    (Future)new zza(paramContext)
    {
      public void zzew()
      {
        SharedPreferences.Editor localEditor = zzkj.zzn(zzkj.this).edit();
        localEditor.putString("app_settings_json", paramString);
        localEditor.putLong("app_settings_last_update_ms", paramLong);
        localEditor.apply();
      }
    }.zzpz();
  }
  
  public static Future zzb(Context paramContext, final zzb paramzzb)
  {
    (Future)new zza(paramContext)
    {
      public void zzew()
      {
        SharedPreferences localSharedPreferences = zzkj.zzn(zzkj.this);
        Bundle localBundle = new Bundle();
        localBundle.putInt("webview_cache_version", localSharedPreferences.getInt("webview_cache_version", 0));
        if (paramzzb != null) {
          paramzzb.zzg(localBundle);
        }
      }
    }.zzpz();
  }
  
  public static Future zzc(Context paramContext, final zzb paramzzb)
  {
    (Future)new zza(paramContext)
    {
      public void zzew()
      {
        SharedPreferences localSharedPreferences = zzkj.zzn(zzkj.this);
        Bundle localBundle = new Bundle();
        localBundle.putBoolean("content_url_opted_out", localSharedPreferences.getBoolean("content_url_opted_out", true));
        if (paramzzb != null) {
          paramzzb.zzg(localBundle);
        }
      }
    }.zzpz();
  }
  
  public static Future zzc(Context paramContext, final boolean paramBoolean)
  {
    (Future)new zza(paramContext)
    {
      public void zzew()
      {
        SharedPreferences.Editor localEditor = zzkj.zzn(zzkj.this).edit();
        localEditor.putBoolean("use_https", paramBoolean);
        localEditor.apply();
      }
    }.zzpz();
  }
  
  public static Future zzd(Context paramContext, final zzb paramzzb)
  {
    (Future)new zza(paramContext)
    {
      public void zzew()
      {
        SharedPreferences localSharedPreferences = zzkj.zzn(zzkj.this);
        Bundle localBundle = new Bundle();
        localBundle.putString("content_url_hashes", localSharedPreferences.getString("content_url_hashes", ""));
        if (paramzzb != null) {
          paramzzb.zzg(localBundle);
        }
      }
    }.zzpz();
  }
  
  public static Future zze(Context paramContext, final zzb paramzzb)
  {
    (Future)new zza(paramContext)
    {
      public void zzew()
      {
        SharedPreferences localSharedPreferences = zzkj.zzn(zzkj.this);
        Bundle localBundle = new Bundle();
        localBundle.putBoolean("auto_collect_location", localSharedPreferences.getBoolean("auto_collect_location", false));
        if (paramzzb != null) {
          paramzzb.zzg(localBundle);
        }
      }
    }.zzpz();
  }
  
  public static Future zze(Context paramContext, final boolean paramBoolean)
  {
    (Future)new zza(paramContext)
    {
      public void zzew()
      {
        SharedPreferences.Editor localEditor = zzkj.zzn(zzkj.this).edit();
        localEditor.putBoolean("content_url_opted_out", paramBoolean);
        localEditor.apply();
      }
    }.zzpz();
  }
  
  public static Future zzf(Context paramContext, final zzb paramzzb)
  {
    (Future)new zza(paramContext)
    {
      public void zzew()
      {
        SharedPreferences localSharedPreferences = zzkj.zzn(zzkj.this);
        Bundle localBundle = new Bundle();
        localBundle.putString("app_settings_json", localSharedPreferences.getString("app_settings_json", ""));
        localBundle.putLong("app_settings_last_update_ms", localSharedPreferences.getLong("app_settings_last_update_ms", 0L));
        if (paramzzb != null) {
          paramzzb.zzg(localBundle);
        }
      }
    }.zzpz();
  }
  
  public static Future zzf(Context paramContext, final boolean paramBoolean)
  {
    (Future)new zza(paramContext)
    {
      public void zzew()
      {
        SharedPreferences.Editor localEditor = zzkj.zzn(zzkj.this).edit();
        localEditor.putBoolean("auto_collect_location", paramBoolean);
        localEditor.apply();
      }
    }.zzpz();
  }
  
  public static Future zzg(Context paramContext, final String paramString)
  {
    (Future)new zza(paramContext)
    {
      public void zzew()
      {
        SharedPreferences.Editor localEditor = zzkj.zzn(zzkj.this).edit();
        localEditor.putString("content_url_hashes", paramString);
        localEditor.apply();
      }
    }.zzpz();
  }
  
  public static SharedPreferences zzn(Context paramContext)
  {
    return paramContext.getSharedPreferences("admob", 0);
  }
  
  private static abstract class zza
    extends zzkg
  {
    public void onStop() {}
  }
  
  public static abstract interface zzb
  {
    public abstract void zzg(Bundle paramBundle);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzkj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */