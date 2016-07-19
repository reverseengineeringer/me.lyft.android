package com.google.android.gms.internal;

import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.util.zze;

class zzpg$1
  implements Runnable
{
  zzpg$1(zzpg paramzzpg) {}
  
  public void run()
  {
    synchronized (zzpg.zza(qE))
    {
      if ((zzpg.zzb(qE) <= zzpg.zzc(qE).elapsedRealtime()) && (zzpg.zzd(qE) != null))
      {
        Log.i("ClearcutLoggerApiImpl", "disconnect managed GoogleApiClient");
        zzpg.zzd(qE).disconnect();
        zzpg.zza(qE, null);
      }
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzpg.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */