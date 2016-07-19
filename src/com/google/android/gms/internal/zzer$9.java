package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.overlay.zzm;
import java.util.Map;
import org.json.JSONObject;

final class zzer$9
  implements zzet
{
  private void zzc(zzll paramzzll)
  {
    zzkh.zzcx("Received support message, responding.");
    boolean bool2 = false;
    Object localObject = paramzzll.zzuh();
    boolean bool1 = bool2;
    if (localObject != null)
    {
      localObject = zzakl;
      bool1 = bool2;
      if (localObject != null) {
        bool1 = ((zzm)localObject).zzr(paramzzll.getContext());
      }
    }
    localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("event", "checkSupport");
      ((JSONObject)localObject).put("supports", bool1);
      paramzzll.zzb("appStreaming", (JSONObject)localObject);
      return;
    }
    catch (Throwable paramzzll) {}
  }
  
  public void zza(zzll paramzzll, Map<String, String> paramMap)
  {
    if ("checkSupport".equals(paramMap.get("action"))) {
      zzc(paramzzll);
    }
    com.google.android.gms.ads.internal.overlay.zzd localzzd;
    do
    {
      return;
      localzzd = paramzzll.zzui();
    } while (localzzd == null);
    localzzd.zzf(paramzzll, paramMap);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzer.9
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */