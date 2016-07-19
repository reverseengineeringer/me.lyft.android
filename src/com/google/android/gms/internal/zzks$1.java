package com.google.android.gms.internal;

class zzks$1
  implements Runnable
{
  zzks$1(zzks paramzzks) {}
  
  public void run()
  {
    synchronized (zzks.zza(zzcms))
    {
      zzkh.v("Suspending the looper thread");
      for (;;)
      {
        int i = zzks.zzb(zzcms);
        if (i == 0) {
          try
          {
            zzks.zza(zzcms).wait();
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
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzks.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */