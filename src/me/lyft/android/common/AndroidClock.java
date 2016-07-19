package me.lyft.android.common;

import android.os.SystemClock;

public class AndroidClock
  implements IDeviceClock
{
  public long getCurrentTimeMs()
  {
    return System.currentTimeMillis();
  }
  
  public long getElapsedTimeMs()
  {
    return SystemClock.elapsedRealtime();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.common.AndroidClock
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */