package com.google.android.gms.ads.internal;

import android.content.Context;
import android.os.Debug;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.internal.zzcy;
import com.google.android.gms.internal.zzdc;
import com.google.android.gms.internal.zzkh;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;

class zza$1
  extends TimerTask
{
  zza$1(zza paramzza, CountDownLatch paramCountDownLatch, Timer paramTimer) {}
  
  public void run()
  {
    if (((Integer)zzdc.zzbcj.get()).intValue() != zzajw.getCount())
    {
      zzkh.zzcw("Stopping method tracing");
      Debug.stopMethodTracing();
      if (zzajw.getCount() == 0L)
      {
        zzajx.cancel();
        return;
      }
    }
    String str = String.valueOf(zzajy.zzajs.zzagf.getPackageName()).concat("_adsTrace_");
    try
    {
      zzkh.zzcw("Starting method tracing");
      zzajw.countDown();
      long l = zzu.zzfu().currentTimeMillis();
      Debug.startMethodTracing(String.valueOf(str).length() + 20 + str + l, ((Integer)zzdc.zzbck.get()).intValue());
      return;
    }
    catch (Exception localException)
    {
      zzkh.zzd("Exception occurred while starting method tracing.", localException);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.zza.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */