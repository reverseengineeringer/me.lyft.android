package com.google.android.gms.internal;

import android.os.Bundle;

class zzra$1
  implements Runnable
{
  zzra$1(zzra paramzzra, zzqo paramzzqo, String paramString) {}
  
  public void run()
  {
    zzqo localzzqo;
    if (zzra.zza(vj) >= 1)
    {
      localzzqo = ve;
      if (zzra.zzb(vj) == null) {
        break label83;
      }
    }
    label83:
    for (Bundle localBundle = zzra.zzb(vj).getBundle(zzap);; localBundle = null)
    {
      localzzqo.onCreate(localBundle);
      if (zzra.zza(vj) >= 2) {
        ve.onStart();
      }
      if (zzra.zza(vj) >= 3) {
        ve.onStop();
      }
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzra.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */