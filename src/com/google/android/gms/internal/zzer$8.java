package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.overlay.zzd;
import java.util.Map;

final class zzer$8
  implements zzet
{
  public void zza(zzll paramzzll, Map<String, String> paramMap)
  {
    paramMap = paramzzll.zzui();
    if (paramMap != null)
    {
      paramMap.close();
      return;
    }
    paramzzll = paramzzll.zzuj();
    if (paramzzll != null)
    {
      paramzzll.close();
      return;
    }
    zzkh.zzcy("A GMSG tried to close something that wasn't an overlay.");
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzer.8
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */