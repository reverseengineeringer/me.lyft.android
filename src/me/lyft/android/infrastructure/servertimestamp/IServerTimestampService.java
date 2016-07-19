package me.lyft.android.infrastructure.servertimestamp;

public abstract interface IServerTimestampService
{
  public abstract long getLastKnownServerTimestampMs();
  
  public abstract void setLastKnownServerTimestampMs(long paramLong);
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.servertimestamp.IServerTimestampService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */