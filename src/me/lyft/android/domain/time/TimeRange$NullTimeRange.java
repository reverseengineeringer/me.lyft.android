package me.lyft.android.domain.time;

class TimeRange$NullTimeRange
  extends TimeRange
{
  static final TimeRange INSTANCE = new NullTimeRange(Long.MIN_VALUE, 0L, "");
  
  TimeRange$NullTimeRange(long paramLong1, long paramLong2, String paramString)
  {
    super(paramLong1, paramLong2, paramString);
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

/* Location:
 * Qualified Name:     me.lyft.android.domain.time.TimeRange.NullTimeRange
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */