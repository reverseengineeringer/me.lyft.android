package me.lyft.android.infrastructure.device;

import java.util.concurrent.TimeUnit;

public class BatteryStatus
{
  private static final long UPDATE_INTERVAL_MILLIS = TimeUnit.MINUTES.toMillis(1L);
  private float batteryLevel;
  private boolean isCharging;
  private long timestamp;
  
  public BatteryStatus(float paramFloat, boolean paramBoolean, long paramLong)
  {
    batteryLevel = paramFloat;
    isCharging = paramBoolean;
    timestamp = paramLong;
  }
  
  public float getBatteryLevel()
  {
    return batteryLevel;
  }
  
  public boolean isCharging()
  {
    return isCharging;
  }
  
  public boolean needsRefresh()
  {
    return System.currentTimeMillis() - timestamp > UPDATE_INTERVAL_MILLIS;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.device.BatteryStatus
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */