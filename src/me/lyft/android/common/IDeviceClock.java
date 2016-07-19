package me.lyft.android.common;

public abstract interface IDeviceClock
{
  public abstract long getCurrentTimeMs();
  
  public abstract long getElapsedTimeMs();
}

/* Location:
 * Qualified Name:     me.lyft.android.common.IDeviceClock
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */