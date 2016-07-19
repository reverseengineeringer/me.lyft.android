package com.google.android.gms.internal;

import com.google.android.gms.common.api.zzd;
import java.util.Set;

class zzrd$1
  implements zzrd.zzb
{
  zzrd$1(zzrd paramzzrd) {}
  
  public void zzh(zzpr.zza<?, ?> paramzza)
  {
    vw.vu.remove(paramzza);
    if ((paramzza.zzaog() != null) && (zzrd.zza(vw) != null)) {
      zzrd.zza(vw).remove(paramzza.zzaog().intValue());
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzrd.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */