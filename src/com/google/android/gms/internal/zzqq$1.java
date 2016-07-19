package com.google.android.gms.internal;

import android.os.Bundle;

class zzqq$1
  implements Runnable
{
  zzqq$1(zzqq paramzzqq, zzqo paramzzqo, String paramString) {}
  
  public void run()
  {
    zzqo localzzqo;
    if (zzqq.zza(vf) >= 1)
    {
      localzzqo = ve;
      if (zzqq.zzb(vf) == null) {
        break label83;
      }
    }
    label83:
    for (Bundle localBundle = zzqq.zzb(vf).getBundle(zzap);; localBundle = null)
    {
      localzzqo.onCreate(localBundle);
      if (zzqq.zza(vf) >= 2) {
        ve.onStart();
      }
      if (zzqq.zza(vf) >= 3) {
        ve.onStop();
      }
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzqq.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */