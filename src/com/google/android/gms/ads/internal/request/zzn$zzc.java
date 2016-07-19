package com.google.android.gms.ads.internal.request;

import com.google.android.gms.internal.zzet;
import com.google.android.gms.internal.zzey;
import com.google.android.gms.internal.zzkh;
import com.google.android.gms.internal.zzll;
import java.util.Map;

public class zzn$zzc
  implements zzet
{
  public void zza(zzll paramzzll, Map<String, String> paramMap)
  {
    String str = (String)paramMap.get("request_id");
    paramzzll = String.valueOf((String)paramMap.get("errors"));
    if (paramzzll.length() != 0) {}
    for (paramzzll = "Invalid request: ".concat(paramzzll);; paramzzll = new String("Invalid request: "))
    {
      zzkh.zzcy(paramzzll);
      zzn.zzrd().zzay(str);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.request.zzn.zzc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */