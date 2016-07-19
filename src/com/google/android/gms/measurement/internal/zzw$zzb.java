package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.zzab;

final class zzw$zzb
  implements Thread.UncaughtExceptionHandler
{
  private final String amg;
  
  public zzw$zzb(zzw paramzzw, String paramString)
  {
    zzab.zzaa(paramString);
    amg = paramString;
  }
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    try
    {
      amh.zzbsz().zzbtr().zzj(amg, paramThrowable);
      return;
    }
    finally
    {
      paramThread = finally;
      throw paramThread;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.measurement.internal.zzw.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */