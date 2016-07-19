package com.google.android.gms.internal;

final class zzit$2
  implements Runnable
{
  zzit$2(zzfw paramzzfw, zziv paramzziv, zzdk paramzzdk, zzdi paramzzdi, String paramString) {}
  
  public void run()
  {
    zzfw.zzc localzzc = zzaku.zzmc();
    zzcei.zzb(localzzc);
    zzakg.zza(zzcej, new String[] { "rwc" });
    localzzc.zza(new zzle.zzc()new zzle.zza
    {
      public void zzb(zzfx paramAnonymouszzfx)
      {
        zzakg.zza(zzcel, new String[] { "jsf" });
        zzakg.zzkh();
        paramAnonymouszzfx.zza("/invalidRequest", zzcei.zzcet);
        paramAnonymouszzfx.zza("/loadAdURL", zzcei.zzceu);
        paramAnonymouszzfx.zza("/loadAd", zzcei.zzcev);
        try
        {
          paramAnonymouszzfx.zzj("AFMA_getAd", zzcek);
          return;
        }
        catch (Exception paramAnonymouszzfx)
        {
          zzkh.zzb("Error requesting an ad url", paramAnonymouszzfx);
        }
      }
    }, new zzle.zza()
    {
      public void run() {}
    });
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzit.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */