package me.lyft.android.domain.time;

class Time$NullTime
  extends Time
{
  static final Time INSTANCE = new NullTime(Long.MIN_VALUE, "");
  
  Time$NullTime(long paramLong, String paramString)
  {
    super(paramLong, paramString);
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
 * Qualified Name:     me.lyft.android.domain.time.Time.NullTime
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */