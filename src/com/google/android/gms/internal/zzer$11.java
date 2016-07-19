package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.Map;
import java.util.concurrent.Future;

final class zzer$11
  implements zzet
{
  public void zza(zzll paramzzll, Map<String, String> paramMap)
  {
    paramMap = (String)paramMap.get("u");
    if (paramMap == null)
    {
      zzkh.zzcy("URL missing from httpTrack GMSG.");
      return;
    }
    paramzzll = (Future)new zzku(paramzzll.getContext(), zzunzzcs, paramMap).zzpz();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzer.11
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */