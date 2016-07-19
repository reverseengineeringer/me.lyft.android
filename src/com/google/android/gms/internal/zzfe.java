package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzu;
import java.util.Map;

@zzir
class zzfe
  implements zzet
{
  private int zzg(Map<String, String> paramMap)
    throws NullPointerException, NumberFormatException
  {
    int j = Integer.parseInt((String)paramMap.get("playbackState"));
    int i;
    if (j >= 0)
    {
      i = j;
      if (3 >= j) {}
    }
    else
    {
      i = 0;
    }
    return i;
  }
  
  public void zza(zzll paramzzll, Map<String, String> paramMap)
  {
    if (!((Boolean)zzdc.zzbaz.get()).booleanValue()) {
      return;
    }
    zzlq localzzlq = paramzzll.zzuu();
    if (localzzlq == null) {}
    for (;;)
    {
      try
      {
        localzzlq = new zzlq(paramzzll, Float.parseFloat((String)paramMap.get("duration")));
        paramzzll.zza(localzzlq);
        paramzzll = localzzlq;
        boolean bool = "1".equals(paramMap.get("muted"));
        paramzzll.zza(Float.parseFloat((String)paramMap.get("currentTime")), zzg(paramMap), bool);
        return;
      }
      catch (NullPointerException paramzzll)
      {
        zzkh.zzb("Unable to parse videoMeta message.", paramzzll);
        zzu.zzft().zzb(paramzzll, true);
        return;
      }
      catch (NumberFormatException paramzzll)
      {
        continue;
      }
      paramzzll = localzzlq;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzfe
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */