package me.lyft.android.domain.ride;

import me.lyft.android.common.INullable;
import me.lyft.android.common.Objects;
import me.lyft.android.domain.time.Time;
import me.lyft.android.domain.time.TimeRange;

public class ScheduledInterval
  implements INullable
{
  private final Time dropoffTime;
  private final Time pickupTime;
  
  public ScheduledInterval(Time paramTime1, Time paramTime2)
  {
    pickupTime = paramTime1;
    dropoffTime = paramTime2;
  }
  
  public static ScheduledInterval empty()
  {
    return NullScheduledInterval.INSTANCE;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof ScheduledInterval)) {
        return false;
      }
      paramObject = (ScheduledInterval)paramObject;
    } while ((Objects.equals(dropoffTime, dropoffTime)) && (Objects.equals(pickupTime, pickupTime)));
    return false;
  }
  
  public Time getDropoffTime()
  {
    return (Time)Objects.firstNonNull(dropoffTime, TimeRange.empty());
  }
  
  public Time getPickupTime()
  {
    return (Time)Objects.firstNonNull(pickupTime, TimeRange.empty());
  }
  
  public TimeRange getPickupTimeRange()
  {
    if ((pickupTime instanceof TimeRange)) {
      return (TimeRange)pickupTime;
    }
    return TimeRange.empty();
  }
  
  public boolean isNull()
  {
    return false;
  }
  
  public static class NullScheduledInterval
    extends ScheduledInterval
  {
    private static final ScheduledInterval INSTANCE = new NullScheduledInterval();
    
    public NullScheduledInterval()
    {
      super(Time.empty());
    }
    
    public boolean isNull()
    {
      return true;
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.ride.ScheduledInterval
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */