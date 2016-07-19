package com.google.android.gms.internal;

import java.util.Map;

@zzir
public final class zzen
  implements zzet
{
  private final zzeo zzbhq;
  
  public zzen(zzeo paramzzeo)
  {
    zzbhq = paramzzeo;
  }
  
  public void zza(zzll paramzzll, Map<String, String> paramMap)
  {
    paramzzll = (String)paramMap.get("name");
    if (paramzzll == null)
    {
      zzkh.zzcy("App event with no name parameter.");
      return;
    }
    zzbhq.onAppEvent(paramzzll, (String)paramMap.get("info"));
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */