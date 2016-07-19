package com.google.android.gms.common.util;

import android.os.SystemClock;

public final class zzh
  implements zze
{
  private static zzh AK;
  
  public static zze zzavi()
  {
    try
    {
      if (AK == null) {
        AK = new zzh();
      }
      zzh localzzh = AK;
      return localzzh;
    }
    finally {}
  }
  
  public long currentTimeMillis()
  {
    return System.currentTimeMillis();
  }
  
  public long elapsedRealtime()
  {
    return SystemClock.elapsedRealtime();
  }
  
  public long nanoTime()
  {
    return System.nanoTime();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.util.zzh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */