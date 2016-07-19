package com.google.android.gms.internal;

import java.util.Map;

class zziv$3
  implements zzet
{
  zziv$3(zziv paramzziv) {}
  
  public void zza(zzll arg1, Map<String, String> paramMap)
  {
    synchronized (zziv.zza(zzcew))
    {
      if (zziv.zzb(zzcew).isDone()) {
        return;
      }
      paramMap = new zziy(-2, paramMap);
      if (!zziv.zzc(zzcew).equals(paramMap.getRequestId())) {
        return;
      }
    }
    paramMap.zzrn();
    zziv.zzb(zzcew).zzi(paramMap);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zziv.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */