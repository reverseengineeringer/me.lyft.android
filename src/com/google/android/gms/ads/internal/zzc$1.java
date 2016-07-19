package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.zzcg;
import com.google.android.gms.internal.zzet;
import com.google.android.gms.internal.zzkh;
import com.google.android.gms.internal.zzll;
import java.util.Map;

class zzc$1
  implements zzet
{
  zzc$1(zzc paramzzc) {}
  
  public void zza(zzll paramzzll, Map<String, String> paramMap)
  {
    if (zzakd.zzajs.zzaoz != null)
    {
      zzakd.zzaju.zza(zzakd.zzajs.zzaoy, zzakd.zzajs.zzaoz, paramzzll.getView(), paramzzll);
      return;
    }
    zzkh.zzcy("Request to enable ActiveView before adState is available.");
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.zzc.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */