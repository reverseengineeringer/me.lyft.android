package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.zzet;
import com.google.android.gms.internal.zzkb;
import com.google.android.gms.internal.zzll;
import java.util.Map;

class zzg$1
  implements zzet
{
  zzg$1(zzg paramzzg) {}
  
  public void zza(zzll paramzzll, Map<String, String> paramMap)
  {
    paramzzll.zzb("/appSettingsFetched", this);
    paramzzll = zzg.zza(zzakt);
    if (paramMap != null) {}
    try
    {
      if ("true".equalsIgnoreCase((String)paramMap.get("isSuccessful")))
      {
        paramMap = (String)paramMap.get("appSettingsJson");
        zzu.zzft().zze(zzg.zzb(zzakt), paramMap);
      }
      return;
    }
    finally {}
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.zzg.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */