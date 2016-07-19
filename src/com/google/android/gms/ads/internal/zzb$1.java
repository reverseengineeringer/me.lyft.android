package com.google.android.gms.ads.internal;

import android.content.Intent;
import com.google.android.gms.ads.internal.overlay.zzd;
import com.google.android.gms.ads.internal.purchase.zzi;
import com.google.android.gms.internal.zzjy;
import com.google.android.gms.internal.zzll;

class zzb$1
  implements Runnable
{
  zzb$1(zzb paramzzb, Intent paramIntent) {}
  
  public void run()
  {
    int i = zzu.zzga().zzd(zzakb);
    zzu.zzga();
    if ((i == 0) && (zzakc.zzajs.zzaoz != null) && (zzakc.zzajs.zzaoz.zzbtq != null) && (zzakc.zzajs.zzaoz.zzbtq.zzui() != null)) {
      zzakc.zzajs.zzaoz.zzbtq.zzui().close();
    }
    zzakc.zzajs.zzapv = false;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.zzb.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */