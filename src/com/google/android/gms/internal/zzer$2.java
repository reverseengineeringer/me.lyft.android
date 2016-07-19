package com.google.android.gms.internal;

import java.util.Map;

final class zzer$2
  implements zzet
{
  public void zza(zzll paramzzll, Map<String, String> paramMap)
  {
    String str1 = (String)paramMap.get("tx");
    String str2 = (String)paramMap.get("ty");
    paramMap = (String)paramMap.get("td");
    try
    {
      int i = Integer.parseInt(str1);
      int j = Integer.parseInt(str2);
      int k = Integer.parseInt(paramMap);
      paramzzll = paramzzll.zzum();
      if (paramzzll != null) {
        paramzzll.zzax().zza(i, j, k);
      }
      return;
    }
    catch (NumberFormatException paramzzll)
    {
      zzkh.zzcy("Could not parse touch parameters from gmsg.");
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzer.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */