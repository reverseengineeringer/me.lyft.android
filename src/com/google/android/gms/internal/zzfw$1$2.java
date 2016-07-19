package com.google.android.gms.internal;

import java.util.Map;

class zzfw$1$2
  implements zzet
{
  zzfw$1$2(zzfw.1 param1, zzft paramzzft) {}
  
  public void zza(zzll arg1, Map<String, String> paramMap)
  {
    synchronized (zzfw.zzc(zzbme.zzbmc))
    {
      if ((zzbme.zzbmb.getStatus() == -1) || (zzbme.zzbmb.getStatus() == 1)) {
        return;
      }
      zzfw.zza(zzbme.zzbmc, 0);
      zzfw.zzd(zzbme.zzbmc).zzd(zzbmd);
      zzbme.zzbmb.zzg(zzbmd);
      zzfw.zza(zzbme.zzbmc, zzbme.zzbmb);
      zzkh.v("Successfully loaded JS Engine.");
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzfw.1.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */