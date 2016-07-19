package com.google.android.gms.ads.internal;

import android.view.View;
import com.google.android.gms.internal.zzet;
import com.google.android.gms.internal.zzll;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

final class zzn$3
  implements zzet
{
  zzn$3(CountDownLatch paramCountDownLatch) {}
  
  public void zza(zzll paramzzll, Map<String, String> paramMap)
  {
    zzajw.countDown();
    paramzzll = paramzzll.getView();
    if (paramzzll == null) {
      return;
    }
    paramzzll.setVisibility(0);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.zzn.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */