package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import java.util.Map;

@zzir
public class zzfc
  implements zzet
{
  private final zza zzbjc;
  
  public zzfc(zza paramzza)
  {
    zzbjc = paramzza;
  }
  
  public static void zza(zzll paramzzll, zza paramzza)
  {
    paramzzll.zzuk().zza("/reward", new zzfc(paramzza));
  }
  
  private void zze(Map<String, String> paramMap)
  {
    try
    {
      int i = Integer.parseInt((String)paramMap.get("amount"));
      paramMap = (String)paramMap.get("type");
      if (!TextUtils.isEmpty(paramMap))
      {
        paramMap = new RewardItemParcel(paramMap, i);
        zzbjc.zzb(paramMap);
        return;
      }
    }
    catch (NumberFormatException paramMap)
    {
      for (;;)
      {
        zzkh.zzd("Unable to parse reward amount.", paramMap);
        paramMap = null;
      }
    }
  }
  
  private void zzf(Map<String, String> paramMap)
  {
    zzbjc.zzev();
  }
  
  public void zza(zzll paramzzll, Map<String, String> paramMap)
  {
    paramzzll = (String)paramMap.get("action");
    if ("grant".equals(paramzzll)) {
      zze(paramMap);
    }
    while (!"video_start".equals(paramzzll)) {
      return;
    }
    zzf(paramMap);
  }
  
  public static abstract interface zza
  {
    public abstract void zzb(RewardItemParcel paramRewardItemParcel);
    
    public abstract void zzev();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzfc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */