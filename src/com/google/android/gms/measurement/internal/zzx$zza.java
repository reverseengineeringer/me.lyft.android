package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zzup.zzb;
import com.google.android.gms.internal.zzup.zze;
import java.util.ArrayList;
import java.util.List;

class zzx$zza
  implements zze.zzb
{
  zzup.zze amN;
  List<Long> amO;
  long amP;
  List<zzup.zzb> zzala;
  
  private zzx$zza(zzx paramzzx) {}
  
  private long zza(zzup.zzb paramzzb)
  {
    return aoL.longValue() / 1000L / 60L / 60L;
  }
  
  boolean isEmpty()
  {
    return (zzala == null) || (zzala.isEmpty());
  }
  
  public boolean zza(long paramLong, zzup.zzb paramzzb)
  {
    zzab.zzaa(paramzzb);
    if (zzala == null) {
      zzala = new ArrayList();
    }
    if (amO == null) {
      amO = new ArrayList();
    }
    if ((zzala.size() > 0) && (zza((zzup.zzb)zzala.get(0)) != zza(paramzzb))) {
      return false;
    }
    long l = amP + paramzzb.ao();
    if (l >= amM.zzbtb().zzbse()) {
      return false;
    }
    amP = l;
    zzala.add(paramzzb);
    amO.add(Long.valueOf(paramLong));
    return zzala.size() < amM.zzbtb().zzbsf();
  }
  
  public void zzc(zzup.zze paramzze)
  {
    zzab.zzaa(paramzze);
    amN = paramzze;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.measurement.internal.zzx.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */