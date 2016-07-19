package com.google.android.gms.measurement.internal;

import android.os.Looper;

class zzf$1
  implements Runnable
{
  zzf$1(zzf paramzzf) {}
  
  public void run()
  {
    if (Looper.myLooper() == Looper.getMainLooper()) {
      zzf.zza(ajS).zzbsy().zzl(this);
    }
    boolean bool;
    do
    {
      return;
      bool = ajS.zzfc();
      zzf.zza(ajS, 0L);
    } while ((!bool) || (!zzf.zzb(ajS)));
    ajS.run();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.measurement.internal.zzf.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */