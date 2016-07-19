package com.devicecollector.collectors;

public abstract interface CollectorStatusListener
{
  public abstract void onCollectorError(CollectorEnum paramCollectorEnum, SoftErrorCode paramSoftErrorCode, Exception paramException);
  
  public abstract void onCollectorStart(CollectorEnum paramCollectorEnum);
  
  public abstract void onCollectorSuccess(CollectorEnum paramCollectorEnum);
}

/* Location:
 * Qualified Name:     com.devicecollector.collectors.CollectorStatusListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */