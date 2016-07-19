package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzu;
import java.util.Map;

@zzir
public class zzhf
{
  private final zzll zzbgj;
  private final boolean zzbqw;
  private final String zzbqx;
  
  public zzhf(zzll paramzzll, Map<String, String> paramMap)
  {
    zzbgj = paramzzll;
    zzbqx = ((String)paramMap.get("forceOrientation"));
    if (paramMap.containsKey("allowOrientationChange"))
    {
      zzbqw = Boolean.parseBoolean((String)paramMap.get("allowOrientationChange"));
      return;
    }
    zzbqw = true;
  }
  
  public void execute()
  {
    if (zzbgj == null)
    {
      zzkh.zzcy("AdWebView is null");
      return;
    }
    int i;
    if ("portrait".equalsIgnoreCase(zzbqx)) {
      i = zzu.zzfs().zztl();
    }
    for (;;)
    {
      zzbgj.setRequestedOrientation(i);
      return;
      if ("landscape".equalsIgnoreCase(zzbqx)) {
        i = zzu.zzfs().zztk();
      } else if (zzbqw) {
        i = -1;
      } else {
        i = zzu.zzfs().zztm();
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzhf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */