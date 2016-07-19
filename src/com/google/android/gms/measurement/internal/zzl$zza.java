package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zzre;

public final class zzl$zza<V>
{
  private final V I;
  private final zzre<V> J;
  private final String zzaxn;
  
  private zzl$zza(String paramString, zzre<V> paramzzre, V paramV)
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

/* Location:
 * Qualified Name:     com.google.android.gms.measurement.internal.zzl.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */