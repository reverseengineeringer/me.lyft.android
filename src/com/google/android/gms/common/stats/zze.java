package com.google.android.gms.common.stats;

import android.os.SystemClock;
import android.support.v4.util.SimpleArrayMap;
import android.util.Log;

public class zze
{
  private final long Av;
  private final int Aw;
  private final SimpleArrayMap<String, Long> Ax;
  
  public zze()
  {
    Av = 60000L;
    Aw = 10;
    Ax = new SimpleArrayMap(10);
  }
  
  public zze(int paramInt, long paramLong)
  {
    Av = paramLong;
    Aw = paramInt;
    Ax = new SimpleArrayMap();
  }
  
  private void zze(long paramLong1, long paramLong2)
  {
    int i = Ax.size() - 1;
    while (i >= 0)
    {
      if (paramLong2 - ((Long)Ax.valueAt(i)).longValue() > paramLong1) {
        Ax.removeAt(i);
      }
      i -= 1;
    }
  }
  
  public Long zzhy(String paramString)
  {
    long l2 = SystemClock.elapsedRealtime();
    long l1 = Av;
    try
    {
      while (Ax.size() >= Aw)
      {
        zze(l1, l2);
        l1 /= 2L;
        int i = Aw;
        Log.w("ConnectionTracker", 94 + "The max capacity " + i + " is not enough. Current durationThreshold is: " + l1);
      }
      paramString = (Long)Ax.put(paramString, Long.valueOf(l2));
    }
    finally {}
    return paramString;
  }
  
  public boolean zzhz(String paramString)
  {
    for (;;)
    {
      try
      {
        if (Ax.remove(paramString) != null)
        {
          bool = true;
          return bool;
        }
      }
      finally {}
      boolean bool = false;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.stats.zze
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */