package com.google.android.gms.ads.internal.request;

import com.google.android.gms.internal.zzfw.zzc;

class zzn$3
  implements Runnable
{
  zzn$3(zzn paramzzn) {}
  
  public void run()
  {
    if (zzn.zzb(zzcdp) != null)
    {
      zzn.zzb(zzcdp).release();
      zzn.zza(zzcdp, null);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.request.zzn.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */