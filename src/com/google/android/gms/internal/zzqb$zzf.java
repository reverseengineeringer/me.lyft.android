package com.google.android.gms.internal;

import java.util.concurrent.locks.Lock;

abstract class zzqb$zzf
  implements Runnable
{
  private zzqb$zzf(zzqb paramzzqb) {}
  
  public void run()
  {
    zzqb.zzc(tG).lock();
    try
    {
      boolean bool = Thread.interrupted();
      if (bool) {
        return;
      }
      zzapi();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      zzqb.zzd(tG).zza(localRuntimeException);
      return;
    }
    finally
    {
      zzqb.zzc(tG).unlock();
    }
  }
  
  protected abstract void zzapi();
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzqb.zzf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */