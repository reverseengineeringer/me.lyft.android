package me.lyft.android.infrastructure.servertimestamp;

import java.util.concurrent.atomic.AtomicLong;

public class ServerTimestampService
  implements IServerTimestampService
{
  private AtomicLong currentTimestamp = new AtomicLong(-1L);
  
  public long getLastKnownServerTimestampMs()
  {
    return currentTimestamp.get();
  }
  
  public void setLastKnownServerTimestampMs(long paramLong)
  {
    currentTimestamp.set(paramLong);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.servertimestamp.ServerTimestampService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */