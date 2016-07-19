package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzu;

class zzfw$1$1$1
  implements Runnable
{
  zzfw$1$1$1(zzfw.1.1 param1) {}
  
  public void run()
  {
    synchronized (zzfw.zzc(zzbmf.zzbme.zzbmc))
    {
      if ((zzbmf.zzbme.zzbmb.getStatus() == -1) || (zzbmf.zzbme.zzbmb.getStatus() == 1)) {
        return;
      }
      zzbmf.zzbme.zzbmb.reject();
      zzu.zzfq().runOnUiThread(new Runnable()
      {
        public void run()
        {
          zzbmf.zzbmd.destroy();
        }
      });
      zzkh.v("Could not receive loaded message in a timely manner. Rejecting.");
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzfw.1.1.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */