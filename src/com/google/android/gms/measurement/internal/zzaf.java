package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.util.zze;

public class zzaf
  extends zzaa
{
  private long anE;
  private final Runnable anF = new Runnable()
  {
    public void run()
    {
      zzbsy().zzl(new Runnable()
      {
        public void run()
        {
          zzbvw();
        }
      });
    }
  };
  private final zzf anG = new zzf(aja)
  {
    public void run()
    {
      zzaf.zza(zzaf.this);
    }
  };
  private final zzf anH = new zzf(aja)
  {
    public void run()
    {
      zzaf.zzb(zzaf.this);
    }
  };
  private Handler mHandler;
  
  zzaf(zzx paramzzx)
  {
    super(paramzzx);
  }
  
  private void zzbl(long paramLong)
  {
    zzwu();
    zzbvu();
    anG.cancel();
    anH.cancel();
    zzbsz().zzbty().zzj("Activity resumed, time", Long.valueOf(paramLong));
    anE = paramLong;
    if (zzyw().currentTimeMillis() - zzbtaalF.get() > zzbtaalH.get())
    {
      zzbtaalG.set(true);
      zzbtaalI.set(0L);
    }
    if (zzbtaalG.get())
    {
      anG.zzv(Math.max(0L, zzbtaalE.get() - zzbtaalI.get()));
      return;
    }
    anH.zzv(Math.max(0L, 3600000L - zzbtaalI.get()));
  }
  
  private void zzbm(long paramLong)
  {
    zzwu();
    zzbvu();
    anG.cancel();
    anH.cancel();
    zzbsz().zzbty().zzj("Activity paused, time", Long.valueOf(paramLong));
    if (anE != 0L) {
      zzbtaalI.set(zzbtaalI.get() + (paramLong - anE));
    }
    zzbtaalH.set(zzyw().currentTimeMillis());
    try
    {
      if (!zzbtaalG.get()) {
        mHandler.postDelayed(anF, 1000L);
      }
      return;
    }
    finally {}
  }
  
  private void zzbvu()
  {
    try
    {
      if (mHandler == null) {
        mHandler = new Handler(Looper.getMainLooper());
      }
      return;
    }
    finally {}
  }
  
  private void zzbvx()
  {
    zzwu();
    long l = zzyw().elapsedRealtime();
    zzbsz().zzbty().zzj("Session started, time", Long.valueOf(l));
    zzbtaalG.set(false);
    zzbsq().zze("auto", "_s", new Bundle());
  }
  
  private void zzbvy()
  {
    zzwu();
    long l1 = zzyw().elapsedRealtime();
    if (anE == 0L) {
      anE = (l1 - 3600000L);
    }
    long l2 = zzbtaalI.get() + (l1 - anE);
    zzbtaalI.set(l2);
    zzbsz().zzbty().zzj("Recording user engagement, ms", Long.valueOf(l2));
    Bundle localBundle = new Bundle();
    localBundle.putLong("_et", l2);
    zzbsq().zze("auto", "_e", localBundle);
    zzbtaalI.set(0L);
    anE = l1;
    anH.zzv(Math.max(0L, 3600000L - zzbtaalI.get()));
  }
  
  protected void zzbvt()
  {
    try
    {
      zzbvu();
      mHandler.removeCallbacks(anF);
      final long l = zzyw().elapsedRealtime();
      zzbsy().zzl(new Runnable()
      {
        public void run()
        {
          zzaf.zza(zzaf.this, l);
        }
      });
      return;
    }
    finally {}
  }
  
  protected void zzbvv()
  {
    final long l = zzyw().elapsedRealtime();
    zzbsy().zzl(new Runnable()
    {
      public void run()
      {
        zzaf.zzb(zzaf.this, l);
      }
    });
  }
  
  public void zzbvw()
  {
    zzwu();
    zzbsz().zzbtx().log("Application backgrounded. Logging engagement");
    long l = zzbtaalI.get();
    if (l > 0L)
    {
      Bundle localBundle = new Bundle();
      localBundle.putLong("_et", l);
      zzbsq().zze("auto", "_e", localBundle);
      zzbtaalI.set(0L);
      return;
    }
    zzbsz().zzbtt().zzj("Not logging non-positive engagement time", Long.valueOf(l));
  }
  
  protected void zzwv() {}
}

/* Location:
 * Qualified Name:     com.google.android.gms.measurement.internal.zzaf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */