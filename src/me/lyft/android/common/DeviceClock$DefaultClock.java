package me.lyft.android.common;

class DeviceClock$DefaultClock
  implements IDeviceClock
{
  static final DefaultClock INSTANCE = new DefaultClock();
  
  public long getCurrentTimeMs()
  {
    return System.currentTimeMillis();
  }
  
  public long getElapsedTimeMs()
  {
    return System.currentTimeMillis();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.common.DeviceClock.DefaultClock
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */