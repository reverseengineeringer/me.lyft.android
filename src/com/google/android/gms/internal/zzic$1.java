package com.google.android.gms.internal;

import java.util.concurrent.atomic.AtomicBoolean;

class zzic$1
  implements Runnable
{
  zzic$1(zzic paramzzic) {}
  
  public void run()
  {
    if (!zzic.zza(zzbya).get()) {
      return;
    }
    zzkh.e("Timed out waiting for WebView to finish loading.");
    zzbya.cancel();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzic.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */