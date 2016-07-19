package com.google.android.gms.internal;

import android.content.Context;

class zzkl$2
  implements Runnable
{
  zzkl$2(zzkl paramzzkl, Context paramContext) {}
  
  public void run()
  {
    synchronized (zzkl.zza(zzcll))
    {
      zzkl.zza(zzcll, zzcll.zzae(zzaky));
      zzkl.zza(zzcll).notifyAll();
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzkl.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */