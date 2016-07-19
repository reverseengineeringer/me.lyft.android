package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.util.zze;

@zzir
public class zzkv
{
  private Object zzail = new Object();
  private long zzcmw;
  private long zzcmx = Long.MIN_VALUE;
  
  public zzkv(long paramLong)
  {
    zzcmw = paramLong;
  }
  
  public boolean tryAcquire()
  {
    synchronized (zzail)
    {
      long l = zzu.zzfu().elapsedRealtime();
      if (zzcmx + zzcmw > l) {
        return false;
      }
      zzcmx = l;
      return true;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzkv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */