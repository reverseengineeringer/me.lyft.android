package com.google.android.gms.internal;

import java.util.Map;
import java.util.Set;

class zzlm$zzd
  implements zzet
{
  private zzlm$zzd(zzlm paramzzlm) {}
  
  public void zza(zzll paramzzll, Map<String, String> paramMap)
  {
    if (paramMap.keySet().contains("start")) {
      zzlm.zza(zzcpb);
    }
    do
    {
      return;
      if (paramMap.keySet().contains("stop"))
      {
        zzlm.zzb(zzcpb);
        return;
      }
    } while (!paramMap.keySet().contains("cancel"));
    zzlm.zzc(zzcpb);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzlm.zzd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */