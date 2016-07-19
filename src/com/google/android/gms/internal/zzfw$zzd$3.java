package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzu;

class zzfw$zzd$3
  implements zzle.zzc<zzft>
{
  zzfw$zzd$3(zzfw.zzd paramzzd) {}
  
  public void zza(final zzft paramzzft)
  {
    zzu.zzfq().runOnUiThread(new Runnable()
    {
      public void run()
      {
        zzfw.zzd.zza(zzbms).zzd(paramzzft);
        paramzzft.destroy();
      }
    });
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzfw.zzd.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */