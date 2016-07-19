package com.google.android.gms.ads.internal.request;

import android.os.Handler;
import com.google.android.gms.internal.zzkl;
import com.google.android.gms.internal.zzle;

class zzb$2
  implements Runnable
{
  zzb$2(zzb paramzzb, zzle paramzzle) {}
  
  public void run()
  {
    synchronized (zzb.zza(zzcal))
    {
      zzcal.zzcak = zzcal.zza(zzbzzcal).zzaou, zzcam);
      if (zzcal.zzcak == null)
      {
        zzb.zza(zzcal, 0, "Could not start the ad request service.");
        zzkl.zzclg.removeCallbacks(zzb.zzc(zzcal));
      }
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.request.zzb.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */