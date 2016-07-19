package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzd;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.internal.zzb;
import java.util.Map;
import java.util.concurrent.Future;

@zzir
public class zzfi
  implements zzet
{
  public void zza(zzll paramzzll, Map<String, String> paramMap)
  {
    zzfg localzzfg = zzu.zzgj();
    if (paramMap.containsKey("abort"))
    {
      if (!localzzfg.zze(paramzzll)) {
        zzkh.zzcy("Precache abort but no preload task running.");
      }
      return;
    }
    String str = (String)paramMap.get("src");
    if (str == null)
    {
      zzkh.zzcy("Precache video action is missing the src parameter.");
      return;
    }
    try
    {
      i = Integer.parseInt((String)paramMap.get("player"));
      if (paramMap.containsKey("mimetype"))
      {
        paramMap = (String)paramMap.get("mimetype");
        if (!localzzfg.zzf(paramzzll)) {
          break label121;
        }
        zzkh.zzcy("Precache task already running.");
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      int i;
      for (;;)
      {
        i = 0;
        continue;
        paramMap = "";
      }
      label121:
      zzb.zzw(paramzzll.zzuh());
      paramzzll = (Future)new zzff(paramzzll, zzuhzzakj.zza(paramzzll, i, paramMap), str).zzpz();
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzfi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */