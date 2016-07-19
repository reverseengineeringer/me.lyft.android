package com.google.android.gms.internal;

import android.os.Handler;
import com.google.android.gms.ads.internal.zzu;
import java.util.Map;

class zzfw$1
  implements Runnable
{
  zzfw$1(zzfw paramzzfw, zzas paramzzas, zzfw.zzd paramzzd) {}
  
  public void run()
  {
    final zzft localzzft = zzbmc.zza(zzfw.zza(zzbmc), zzfw.zzb(zzbmc), zzbma);
    localzzft.zza(new zzft.zza()
    {
      public void zzmb()
      {
        zzkl.zzclg.postDelayed(new Runnable()
        {
          public void run()
          {
            synchronized (zzfw.zzc(zzbmc))
            {
              if ((zzbmb.getStatus() == -1) || (zzbmb.getStatus() == 1)) {
                return;
              }
              zzbmb.reject();
              zzu.zzfq().runOnUiThread(new Runnable()
              {
                public void run()
                {
                  zzbmd.destroy();
                }
              });
              zzkh.v("Could not receive loaded message in a timely manner. Rejecting.");
              return;
            }
          }
        }, zzfw.zza.zzbml);
      }
    });
    localzzft.zza("/jsLoaded", new zzet()
    {
      public void zza(zzll arg1, Map<String, String> paramAnonymousMap)
      {
        synchronized (zzfw.zzc(zzbmc))
        {
          if ((zzbmb.getStatus() == -1) || (zzbmb.getStatus() == 1)) {
            return;
          }
          zzfw.zza(zzbmc, 0);
          zzfw.zzd(zzbmc).zzd(localzzft);
          zzbmb.zzg(localzzft);
          zzfw.zza(zzbmc, zzbmb);
          zzkh.v("Successfully loaded JS Engine.");
          return;
        }
      }
    });
    final zzkw localzzkw = new zzkw();
    zzet local3 = new zzet()
    {
      public void zza(zzll arg1, Map<String, String> paramAnonymousMap)
      {
        synchronized (zzfw.zzc(zzbmc))
        {
          zzkh.zzcx("JS Engine is requesting an update");
          if (zzfw.zze(zzbmc) == 0)
          {
            zzkh.zzcx("Starting reload.");
            zzfw.zza(zzbmc, 2);
            zzbmc.zzb(zzbma);
          }
          localzzft.zzb("/requestReload", (zzet)localzzkw.get());
          return;
        }
      }
    };
    localzzkw.set(local3);
    localzzft.zza("/requestReload", local3);
    if (zzfw.zzf(zzbmc).endsWith(".js")) {
      localzzft.zzbh(zzfw.zzf(zzbmc));
    }
    for (;;)
    {
      zzkl.zzclg.postDelayed(new Runnable()
      {
        public void run()
        {
          synchronized (zzfw.zzc(zzbmc))
          {
            if ((zzbmb.getStatus() == -1) || (zzbmb.getStatus() == 1)) {
              return;
            }
            zzbmb.reject();
            zzu.zzfq().runOnUiThread(new Runnable()
            {
              public void run()
              {
                zzbmd.destroy();
              }
            });
            zzkh.v("Could not receive loaded message in a timely manner. Rejecting.");
            return;
          }
        }
      }, zzfw.zza.zzbmk);
      return;
      if (zzfw.zzf(zzbmc).startsWith("<html>")) {
        localzzft.zzbj(zzfw.zzf(zzbmc));
      } else {
        localzzft.zzbi(zzfw.zzf(zzbmc));
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzfw.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */