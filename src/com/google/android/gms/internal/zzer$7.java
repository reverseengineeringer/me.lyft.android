package com.google.android.gms.internal;

import android.net.Uri;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.Map;
import java.util.concurrent.Future;

final class zzer$7
  implements zzet
{
  public void zza(zzll paramzzll, Map<String, String> paramMap)
  {
    String str = (String)paramMap.get("u");
    if (str == null)
    {
      zzkh.zzcy("URL missing from click GMSG.");
      return;
    }
    Uri localUri = Uri.parse(str);
    try
    {
      paramMap = paramzzll.zzum();
      if ((paramMap != null) && (paramMap.zzc(localUri)))
      {
        paramMap = paramMap.zzb(localUri, paramzzll.getContext());
        paramMap = paramMap.toString();
        paramzzll = (Future)new zzku(paramzzll.getContext(), zzunzzcs, paramMap).zzpz();
        return;
      }
    }
    catch (zzat paramMap)
    {
      paramMap = String.valueOf(str);
      if (paramMap.length() == 0) {}
    }
    for (paramMap = "Unable to append parameter to URL: ".concat(paramMap);; paramMap = new String("Unable to append parameter to URL: "))
    {
      zzkh.zzcy(paramMap);
      paramMap = localUri;
      break;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzer.7
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */