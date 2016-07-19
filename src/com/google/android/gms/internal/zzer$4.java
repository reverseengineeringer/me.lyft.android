package com.google.android.gms.internal;

import java.util.Map;

final class zzer$4
  implements zzet
{
  public void zza(zzll paramzzll, Map<String, String> paramMap)
  {
    paramMap = (String)paramMap.get("action");
    if ("pause".equals(paramMap)) {
      paramzzll.zzeg();
    }
    while (!"resume".equals(paramMap)) {
      return;
    }
    paramzzll.zzeh();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzer.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */