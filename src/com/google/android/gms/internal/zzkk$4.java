package com.google.android.gms.internal;

import java.util.concurrent.Future;

final class zzkk$4
  implements Runnable
{
  zzkk$4(zzkz paramzzkz, Future paramFuture) {}
  
  public void run()
  {
    if (zzclb.isCancelled()) {
      zzcld.cancel(true);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzkk.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */