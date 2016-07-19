package com.google.android.gms.common.stats;

import com.google.android.gms.internal.zzre;

public final class zzc
{
  public static zzre<Integer> Af = zzre.zza("gms:common:stats:max_num_of_events", Integer.valueOf(100));
  public static zzre<Integer> Ag = zzre.zza("gms:common:stats:max_chunk_size", Integer.valueOf(100));
  
  public static final class zza
  {
    public static zzre<Integer> Ah = zzre.zza("gms:common:stats:connections:level", Integer.valueOf(zzd.LOG_LEVEL_OFF));
    public static zzre<String> Ai = zzre.zzab("gms:common:stats:connections:ignored_calling_processes", "");
    public static zzre<String> Aj = zzre.zzab("gms:common:stats:connections:ignored_calling_services", "");
    public static zzre<String> Ak = zzre.zzab("gms:common:stats:connections:ignored_target_processes", "");
    public static zzre<String> Al = zzre.zzab("gms:common:stats:connections:ignored_target_services", "com.google.android.gms.auth.GetToken");
    public static zzre<Long> Am = zzre.zza("gms:common:stats:connections:time_out_duration", Long.valueOf(600000L));
  }
  
  public static final class zzb
  {
    public static zzre<Integer> Ah = zzre.zza("gms:common:stats:wakeLocks:level", Integer.valueOf(zzd.LOG_LEVEL_OFF));
    public static zzre<Long> Am = zzre.zza("gms:common:stats:wakelocks:time_out_duration", Long.valueOf(600000L));
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.stats.zzc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */