package me.lyft.android.domain.time;

public class TimeRange
  extends Time
{
  private final long range;
  
  public TimeRange(long paramLong1, long paramLong2, String paramString)
  {
    super(paramLong1, paramString);
    range = paramLong2;
  }
  
  public static TimeRange empty()
  {
    return NullTimeRange.INSTANCE;
  }
  
  public Time endTime()
  {
    return new Time(timestamp + range, timezone);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof TimeRange)) {
        return false;
      }
      paramObject = (TimeRange)paramObject;
    } while ((super.equals(paramObject)) && (range == range));
    return false;
  }
  
  public String formatTime()
  {
    if (isNull()) {
      return "";
    }
    long l1 = timestamp;
    long l2 = timestamp + range;
    if (format("a", l1).equals(format("a", l2))) {}
    for (String str = "h:mm";; str = "h:mma") {
      return format(str, l1) + " - " + format("h:mma", l2);
    }
  }
  
  public long getRange()
  {
    return range;
  }
  
  public boolean isNull()
  {
    return false;
  }
  
  public Time startTime()
  {
    return super.startTime();
  }
  
  private static class NullTimeRange
    extends TimeRange
  {
    static final TimeRange INSTANCE = new NullTimeRange(Long.MIN_VALUE, 0L, "");
    
    NullTimeRange(long paramLong1, long paramLong2, String paramString)
    {
      super(paramLong2, paramString);
    }
    
    public String formatDate()
    {
      return "";
    }
    
    public String formatDay()
    {
      return "";
    }
    
    public String formatDayOfWeek()
    {
      return "";
    }
    
    public String formatTime()
    {
      return "";
    }
    
    public boolean isNull()
    {
      return true;
    }
    
    public boolean isToday()
    {
      return false;
    }
    
    public boolean isTomorrow()
    {
      return false;
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.time.TimeRange
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */