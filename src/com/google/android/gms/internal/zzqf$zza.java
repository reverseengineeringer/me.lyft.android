package com.google.android.gms.internal;

import java.util.concurrent.locks.Lock;

abstract class zzqf$zza
{
  private final zzqe us;
  
  protected zzqf$zza(zzqe paramzzqe)
  {
    us = paramzzqe;
  }
  
  protected abstract void zzapi();
  
  public final void zzd(zzqf paramzzqf)
  {
    zzqf.zzb(paramzzqf).lock();
    try
    {
      zzqe localzzqe1 = zzqf.zzc(paramzzqf);
      zzqe localzzqe2 = us;
      if (localzzqe1 != localzzqe2) {
        return;
      }
      zzapi();
      return;
    }
    finally
    {
      zzqf.zzb(paramzzqf).unlock();
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzqf.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */