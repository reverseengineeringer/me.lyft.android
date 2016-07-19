package com.google.android.gms.internal;

import android.os.Handler;
import com.google.android.gms.ads.internal.zzu;

class zzfw$1$1
  implements zzft.zza
{
  zzfw$1$1(zzfw.1 param1, zzft paramzzft) {}
  
  public void zzmb()
  {
    zzkl.zzclg.postDelayed(new Runnable()
    {
      public void run()
      {
        synchronized (zzfw.zzc(zzbme.zzbmc))
        {
          if ((zzbme.zzbmb.getStatus() == -1) || (zzbme.zzbmb.getStatus() == 1)) {
            return;
          }
          zzbme.zzbmb.reject();
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
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzfw.1.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */