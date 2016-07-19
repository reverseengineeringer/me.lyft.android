package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.SystemClock;

@zzir
final class zzjz$zza
{
  private long zzcje = -1L;
  private long zzcjf = -1L;
  
  public Bundle toBundle()
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong("topen", zzcje);
    localBundle.putLong("tclose", zzcjf);
    return localBundle;
  }
  
  public long zzsc()
  {
    return zzcjf;
  }
  
  public void zzsd()
  {
    zzcjf = SystemClock.elapsedRealtime();
  }
  
  public void zzse()
  {
    zzcje = SystemClock.elapsedRealtime();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzjz.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */