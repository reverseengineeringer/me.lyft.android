package com.google.android.gms.internal;

import android.os.Process;
import com.google.android.gms.ads.internal.zzu;
import java.util.concurrent.Callable;

final class zzkk$3
  implements Runnable
{
  zzkk$3(zzkz paramzzkz, Callable paramCallable) {}
  
  public void run()
  {
    try
    {
      Process.setThreadPriority(10);
      zzclb.zzi(zzclc.call());
      return;
    }
    catch (Exception localException)
    {
      zzu.zzft().zzb(localException, true);
      zzclb.cancel(true);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzkk.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */