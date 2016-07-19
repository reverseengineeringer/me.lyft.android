package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.zzet;
import com.google.android.gms.internal.zzkh;
import com.google.android.gms.internal.zzll;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

final class zzn$4
  implements zzet
{
  zzn$4(CountDownLatch paramCountDownLatch) {}
  
  public void zza(zzll paramzzll, Map<String, String> paramMap)
  {
    zzkh.zzcy("Adapter returned an ad, but assets substitution failed");
    zzajw.countDown();
    paramzzll.destroy();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.zzn.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */