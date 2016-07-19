package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.util.zze;

abstract class zzf
{
  private static volatile Handler zzczj;
  private boolean ajR;
  private final zzx aja;
  private volatile long zzczk;
  private final Runnable zzw;
  
  zzf(zzx paramzzx)
  {
    zzab.zzaa(paramzzx);
    aja = paramzzx;
    ajR = true;
    zzw = new Runnable()
    {
      public void run()
      {
        if (Looper.myLooper() == Looper.getMainLooper()) {
          zzf.zza(zzf.this).zzbsy().zzl(this);
        }
        boolean bool;
        do
        {
          return;
          bool = zzfc();
          zzf.zza(zzf.this, 0L);
        } while ((!bool) || (!zzf.zzb(zzf.this)));
        zzf.this.run();
      }
    };
  }
  
  private Handler getHandler()
  {
    if (zzczj != null) {
      return zzczj;
    }
    try
    {
      if (zzczj == null) {
        zzczj = new Handler(aja.getContext().getMainLooper());
      }
      Handler localHandler = zzczj;
      return localHandler;
    }
    finally {}
  }
  
  public void cancel()
  {
    zzczk = 0L;
    getHandler().removeCallbacks(zzw);
  }
  
  public abstract void run();
  
  public boolean zzfc()
  {
    return zzczk != 0L;
  }
  
  public void zzv(long paramLong)
  {
    cancel();
    if (paramLong >= 0L)
    {
      zzczk = aja.zzyw().currentTimeMillis();
      if (!getHandler().postDelayed(zzw, paramLong)) {
        aja.zzbsz().zzbtr().zzj("Failed to schedule delayed post. time", Long.valueOf(paramLong));
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.measurement.internal.zzf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */