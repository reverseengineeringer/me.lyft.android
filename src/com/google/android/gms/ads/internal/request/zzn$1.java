package com.google.android.gms.ads.internal.request;

import com.google.android.gms.internal.zzfw.zzc;
import com.google.android.gms.internal.zzjy.zza;

class zzn$1
  implements Runnable
{
  zzn$1(zzn paramzzn, zzjy.zza paramzza) {}
  
  public void run()
  {
    zzn.zza(zzcdp).zza(zzake);
    if (zzn.zzb(zzcdp) != null)
    {
      zzn.zzb(zzcdp).release();
      zzn.zza(zzcdp, null);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.request.zzn.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */