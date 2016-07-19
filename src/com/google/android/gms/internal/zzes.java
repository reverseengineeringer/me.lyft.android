package com.google.android.gms.internal;

import java.util.HashMap;
import java.util.Map;

@zzir
public final class zzes
  implements zzet
{
  public static void zzd(zzll paramzzll)
  {
    paramzzll.zza("/install", new zzes());
  }
  
  public void zza(zzll paramzzll, Map<String, String> paramMap)
  {
    Object localObject = (String)paramMap.get("action");
    if ("is_updated".equals(localObject))
    {
      paramMap = zzdt.zzkq().zzb(paramzzll.zzuf(), paramMap);
      localObject = new HashMap();
      ((Map)localObject).put("status", paramMap);
      paramzzll.zza("installStatus", (Map)localObject);
    }
    while (!"install_apk".equals(localObject)) {
      return;
    }
    zzdt.zzkq().zza(paramzzll.zzuf(), paramMap);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzes
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */