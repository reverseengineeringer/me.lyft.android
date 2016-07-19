package com.google.android.gms.internal;

import java.util.Map;

class zzfw$1$3
  implements zzet
{
  zzfw$1$3(zzfw.1 param1, zzft paramzzft, zzkw paramzzkw) {}
  
  public void zza(zzll arg1, Map<String, String> paramMap)
  {
    synchronized (zzfw.zzc(zzbme.zzbmc))
    {
      zzkh.zzcx("JS Engine is requesting an update");
      if (zzfw.zze(zzbme.zzbmc) == 0)
      {
        zzkh.zzcx("Starting reload.");
        zzfw.zza(zzbme.zzbmc, 2);
        zzbme.zzbmc.zzb(zzbme.zzbma);
      }
      zzbmd.zzb("/requestReload", (zzet)zzbmh.get());
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzfw.1.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */