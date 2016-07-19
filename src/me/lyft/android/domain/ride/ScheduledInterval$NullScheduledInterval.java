package me.lyft.android.domain.ride;

import me.lyft.android.domain.time.Time;

public class ScheduledInterval$NullScheduledInterval
  extends ScheduledInterval
{
  private static final ScheduledInterval INSTANCE = new NullScheduledInterval();
  
  public ScheduledInterval$NullScheduledInterval()
  {
    super(Time.empty(), Time.empty());
  }
  
  public boolean isNull()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.ride.ScheduledInterval.NullScheduledInterval
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */