package com.google.android.gms.internal;

class zzit$2$1
  implements zzle.zzc<zzfx>
{
  zzit$2$1(zzit.2 param2, zzdi paramzzdi) {}
  
  public void zzb(zzfx paramzzfx)
  {
    zzcem.zzakg.zza(zzcel, new String[] { "jsf" });
    zzcem.zzakg.zzkh();
    paramzzfx.zza("/invalidRequest", zzcem.zzcei.zzcet);
    paramzzfx.zza("/loadAdURL", zzcem.zzcei.zzceu);
    paramzzfx.zza("/loadAd", zzcem.zzcei.zzcev);
    try
    {
      paramzzfx.zzj("AFMA_getAd", zzcem.zzcek);
      return;
    }
    catch (Exception paramzzfx)
    {
      zzkh.zzb("Error requesting an ad url", paramzzfx);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzit.2.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */