package com.google.android.gms.wearable.internal;

import com.google.android.gms.internal.zzpr.zzb;

abstract class zzbo$zzb<T>
  extends zza
{
  private zzpr.zzb<T> bF;
  
  public zzbo$zzb(zzpr.zzb<T> paramzzb)
  {
    bF = paramzzb;
  }
  
  public void zzba(T paramT)
  {
    zzpr.zzb localzzb = bF;
    if (localzzb != null)
    {
      localzzb.setResult(paramT);
      bF = null;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wearable.internal.zzbo.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */