package com.google.android.gms.ads.internal.request;

import com.google.android.gms.internal.zzey;
import com.google.android.gms.internal.zzfx;
import com.google.android.gms.internal.zzkh;
import com.google.android.gms.internal.zzle.zzc;

class zzn$2$1
  implements zzle.zzc<zzfx>
{
  zzn$2$1(zzn.2 param2) {}
  
  public void zzb(zzfx paramzzfx)
  {
    try
    {
      paramzzfx.zza("AFMA_getAdapterLessMediationAd", zzcds.zzcdq);
      return;
    }
    catch (Exception paramzzfx)
    {
      zzkh.zzb("Error requesting an ad url", paramzzfx);
      zzn.zzrd().zzay(zzcds.zzcdr);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.request.zzn.2.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */