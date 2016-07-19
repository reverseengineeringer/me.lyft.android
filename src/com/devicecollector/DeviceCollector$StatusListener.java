package com.devicecollector;

public abstract interface DeviceCollector$StatusListener
{
  public abstract void onCollectorError(DeviceCollector.ErrorCode paramErrorCode, Exception paramException);
  
  public abstract void onCollectorStart();
  
  public abstract void onCollectorSuccess();
}

/* Location:
 * Qualified Name:     com.devicecollector.DeviceCollector.StatusListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */