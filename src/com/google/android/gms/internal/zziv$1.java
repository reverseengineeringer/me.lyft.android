package com.google.android.gms.internal;

import java.util.Map;

class zziv$1
  implements zzet
{
  zziv$1(zziv paramzziv) {}
  
  public void zza(zzll arg1, Map<String, String> paramMap)
  {
    synchronized (zziv.zza(zzcew))
    {
      if (zziv.zzb(zzcew).isDone()) {
        return;
      }
      if (!zziv.zzc(zzcew).equals(paramMap.get("request_id"))) {
        return;
      }
    }
    paramMap = new zziy(1, paramMap);
    String str1 = String.valueOf(paramMap.getType());
    String str2 = String.valueOf(paramMap.zzrk());
    zzkh.zzcy(String.valueOf(str1).length() + 24 + String.valueOf(str2).length() + "Invalid " + str1 + " request error: " + str2);
    zziv.zzb(zzcew).zzi(paramMap);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zziv.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */