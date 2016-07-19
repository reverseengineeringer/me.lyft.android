package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.util.zze;

class zzah
{
  private final zze zzaoa;
  private long zzboy;
  
  public zzah(zze paramzze)
  {
    zzab.zzaa(paramzze);
    zzaoa = paramzze;
  }
  
  public void clear()
  {
    zzboy = 0L;
  }
  
  public void start()
  {
    zzboy = zzaoa.elapsedRealtime();
  }
  
  public boolean zzx(long paramLong)
  {
    if (zzboy == 0L) {}
    while (zzaoa.elapsedRealtime() - zzboy >= paramLong) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.measurement.internal.zzah
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */