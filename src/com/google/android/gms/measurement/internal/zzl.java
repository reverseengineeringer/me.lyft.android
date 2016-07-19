package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zzre;

public final class zzl
{
  public static zza<Long> akA = zza.zzf("measurement.upload.window_interval", 3600000L);
  public static zza<Long> akB = zza.zzf("measurement.upload.interval", 3600000L);
  public static zza<Long> akC = zza.zzf("measurement.upload.stale_data_deletion_interval", 86400000L);
  public static zza<Long> akD = zza.zzf("measurement.upload.initial_upload_delay_time", 15000L);
  public static zza<Long> akE = zza.zzf("measurement.upload.retry_time", 1800000L);
  public static zza<Integer> akF = zza.zzaa("measurement.upload.retry_count", 6);
  public static zza<Long> akG = zza.zzf("measurement.upload.max_queue_time", 2419200000L);
  public static zza<Integer> akH = zza.zzaa("measurement.lifetimevalue.max_currency_tracked", 4);
  public static zza<Long> akI = zza.zzf("measurement.service_client.idle_disconnect_millis", 5000L);
  public static zza<Boolean> aki = zza.zzo("measurement.service_enabled", true);
  public static zza<Boolean> akj = zza.zzo("measurement.service_client_enabled", true);
  public static zza<String> akk = zza.zzl("measurement.log_tag", "FA", "FA-SVC");
  public static zza<Long> akl = zza.zzf("measurement.ad_id_cache_time", 10000L);
  public static zza<Long> akm = zza.zzf("measurement.monitoring.sample_period_millis", 86400000L);
  public static zza<Long> akn = zza.zzb("measurement.config.cache_time", 86400000L, 3600000L);
  public static zza<String> ako = zza.zzav("measurement.config.url_scheme", "https");
  public static zza<String> akp = zza.zzav("measurement.config.url_authority", "app-measurement.com");
  public static zza<Integer> akq = zza.zzaa("measurement.upload.max_bundles", 100);
  public static zza<Integer> akr = zza.zzaa("measurement.upload.max_batch_size", 65536);
  public static zza<Integer> aks = zza.zzaa("measurement.upload.max_bundle_size", 65536);
  public static zza<Integer> akt = zza.zzaa("measurement.upload.max_events_per_bundle", 1000);
  public static zza<Integer> aku = zza.zzaa("measurement.upload.max_events_per_day", 100000);
  public static zza<Integer> akv = zza.zzaa("measurement.upload.max_public_events_per_day", 50000);
  public static zza<Integer> akw = zza.zzaa("measurement.upload.max_conversions_per_day", 500);
  public static zza<Integer> akx = zza.zzaa("measurement.store.max_stored_events_per_app", 100000);
  public static zza<String> aky = zza.zzav("measurement.upload.url", "https://app-measurement.com/a");
  public static zza<Long> akz = zza.zzf("measurement.upload.backoff_period", 43200000L);
  
  public static final class zza<V>
  {
    private final V I;
    private final zzre<V> J;
    private final String zzaxn;
    
    private zza(String paramString, zzre<V> paramzzre, V paramV)
    {
      zzab.zzaa(paramzzre);
      J = paramzzre;
      I = paramV;
      zzaxn = paramString;
    }
    
    static zza<Integer> zzaa(String paramString, int paramInt)
    {
      return zzo(paramString, paramInt, paramInt);
    }
    
    static zza<String> zzav(String paramString1, String paramString2)
    {
      return zzl(paramString1, paramString2, paramString2);
    }
    
    static zza<Long> zzb(String paramString, long paramLong1, long paramLong2)
    {
      return new zza(paramString, zzre.zza(paramString, Long.valueOf(paramLong2)), Long.valueOf(paramLong1));
    }
    
    static zza<Boolean> zzb(String paramString, boolean paramBoolean1, boolean paramBoolean2)
    {
      return new zza(paramString, zzre.zzm(paramString, paramBoolean2), Boolean.valueOf(paramBoolean1));
    }
    
    static zza<Long> zzf(String paramString, long paramLong)
    {
      return zzb(paramString, paramLong, paramLong);
    }
    
    static zza<String> zzl(String paramString1, String paramString2, String paramString3)
    {
      return new zza(paramString1, zzre.zzab(paramString1, paramString3), paramString2);
    }
    
    static zza<Integer> zzo(String paramString, int paramInt1, int paramInt2)
    {
      return new zza(paramString, zzre.zza(paramString, Integer.valueOf(paramInt2)), Integer.valueOf(paramInt1));
    }
    
    static zza<Boolean> zzo(String paramString, boolean paramBoolean)
    {
      return zzb(paramString, paramBoolean, paramBoolean);
    }
    
    public V get()
    {
      return (V)I;
    }
    
    public V get(V paramV)
    {
      if (paramV != null) {
        return paramV;
      }
      return (V)I;
    }
    
    public String getKey()
    {
      return zzaxn;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.measurement.internal.zzl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */