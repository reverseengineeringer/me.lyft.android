package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.util.zze;

class zzja$zza
{
  public final long zzchf = zzu.zzfu().currentTimeMillis();
  public final zziz zzchg;
  
  public zzja$zza(zzja paramzzja, zziz paramzziz)
  {
    zzchg = paramzziz;
  }
  
  public boolean hasExpired()
  {
    long l = zzchf;
    return ((Long)zzdc.zzbar.get()).longValue() + l < zzu.zzfu().currentTimeMillis();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzja.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */