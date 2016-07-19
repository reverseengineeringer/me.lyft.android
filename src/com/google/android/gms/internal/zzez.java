package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zze;
import com.google.android.gms.common.util.zzf;
import java.util.Map;

@zzir
public class zzez
  implements zzet
{
  static final Map<String, Integer> zzbiz = zzf.zza("resize", Integer.valueOf(1), "playVideo", Integer.valueOf(2), "storePicture", Integer.valueOf(3), "createCalendarEvent", Integer.valueOf(4), "setOrientationProperties", Integer.valueOf(5), "closeResizedAd", Integer.valueOf(6));
  private final zze zzbix;
  private final zzhe zzbiy;
  
  public zzez(zze paramzze, zzhe paramzzhe)
  {
    zzbix = paramzze;
    zzbiy = paramzzhe;
  }
  
  public void zza(zzll paramzzll, Map<String, String> paramMap)
  {
    String str = (String)paramMap.get("a");
    int i = ((Integer)zzbiz.get(str)).intValue();
    if ((i != 5) && (zzbix != null) && (!zzbix.zzem()))
    {
      zzbix.zzt(null);
      return;
    }
    switch (i)
    {
    case 2: 
    default: 
      zzkh.zzcx("Unknown MRAID command called.");
      return;
    case 1: 
      zzbiy.execute(paramMap);
      return;
    case 4: 
      new zzhd(paramzzll, paramMap).execute();
      return;
    case 3: 
      new zzhg(paramzzll, paramMap).execute();
      return;
    case 5: 
      new zzhf(paramzzll, paramMap).execute();
      return;
    }
    zzbiy.zzs(true);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzez
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */