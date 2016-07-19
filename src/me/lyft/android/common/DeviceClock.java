package me.lyft.android.common;

public class DeviceClock
{
  private static IDeviceClock deviceClock = DefaultClock.INSTANCE;
  
  public static long getCurrentTimeMs()
  {
    return deviceClock.getCurrentTimeMs();
  }
  
  static IDeviceClock getDeviceClock()
  {
    return deviceClock;
  }
  
  public static long getElapsedTimeMs()
  {
    return deviceClock.getElapsedTimeMs();
  }
  
  public static void setDeviceClock(IDeviceClock paramIDeviceClock)
  {
    Preconditions.checkNotNull(paramIDeviceClock);
    deviceClock = paramIDeviceClock;
  }
  
  private static class DefaultClock
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
}

/* Location:
 * Qualified Name:     me.lyft.android.common.DeviceClock
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */