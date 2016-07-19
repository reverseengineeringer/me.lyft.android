package com.google.android.gms.internal;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.google.android.gms.common.internal.zzab;

@zzir
public class zzks
{
  private Handler mHandler = null;
  private final Object zzail = new Object();
  private HandlerThread zzcmq = null;
  private int zzcmr = 0;
  
  public Looper zztr()
  {
    for (;;)
    {
      synchronized (zzail)
      {
        if (zzcmr == 0)
        {
          if (zzcmq == null)
          {
            zzkh.v("Starting the looper thread.");
            zzcmq = new HandlerThread("LooperProvider");
            zzcmq.start();
            mHandler = new Handler(zzcmq.getLooper());
            zzkh.v("Looper thread started.");
            zzcmr += 1;
            Looper localLooper = zzcmq.getLooper();
            return localLooper;
          }
          zzkh.v("Resuming the looper thread");
          zzail.notifyAll();
        }
      }
      zzab.zzb(zzcmq, "Invalid state: mHandlerThread should already been initialized.");
    }
  }
  
  public void zzts()
  {
    for (;;)
    {
      synchronized (zzail)
      {
        if (zzcmr > 0)
        {
          bool = true;
          zzab.zzb(bool, "Invalid state: release() called more times than expected.");
          int i = zzcmr - 1;
          zzcmr = i;
          if (i == 0) {
            mHandler.post(new Runnable()
            {
              public void run()
              {
                synchronized (zzks.zza(zzks.this))
                {
                  zzkh.v("Suspending the looper thread");
                  for (;;)
                  {
                    int i = zzks.zzb(zzks.this);
                    if (i == 0) {
                      try
                      {
                        zzks.zza(zzks.this).wait();
                        zzkh.v("Looper thread resumed");
                      }
                      catch (InterruptedException localInterruptedException)
                      {
                        zzkh.v("Looper thread interrupted.");
                      }
                    }
                  }
                }
              }
            });
          }
          return;
        }
      }
      boolean bool = false;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzks
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */