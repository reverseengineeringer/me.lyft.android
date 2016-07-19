package me.lyft.android.domain.time;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import me.lyft.android.common.DeviceClock;
import me.lyft.android.common.INullable;
import me.lyft.android.common.Objects;
import me.lyft.android.common.Strings;

public class Time
  implements INullable
{
  protected static final String DATE_FORMAT = "MMM d";
  protected static final String DAY_OF_WEEK_FORMAT = "EEEE";
  protected static final Locale LOCALE = Locale.US;
  public static final long NULL_TIME = Long.MIN_VALUE;
  protected static final String TIME_LABEL_FORMAT = "a";
  protected static final String TIME_NO_LABEL_FORMAT = "h:mm";
  protected static final String TIME_WITH_LABEL_FORMAT = "h:mma";
  final long timestamp;
  final String timezone;
  
  public Time(long paramLong, String paramString)
  {
    timestamp = paramLong;
    timezone = paramString;
  }
  
  public static Time empty()
  {
    return NullTime.INSTANCE;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof Time)) {
        return false;
      }
      paramObject = (Time)paramObject;
    } while ((timestamp == timestamp) && (Objects.equals(timezone, timezone)));
    return false;
  }
  
  String format(String paramString, long paramLong)
  {
    paramString = new SimpleDateFormat(paramString, LOCALE);
    paramString.setTimeZone(getTimezone());
    return paramString.format(new Date(paramLong));
  }
  
  public String formatDate()
  {
    if (isToday()) {
      return "";
    }
    return format("MMM d", timestamp);
  }
  
  public String formatDateWithToday()
  {
    if (isToday()) {
      return "Today";
    }
    return format("MMM d", timestamp);
  }
  
  public String formatDay()
  {
    if (isToday()) {
      return "today";
    }
    if (isTomorrow()) {
      return "tomorrow";
    }
    return formatDayOfWeek();
  }
  
  public String formatDayOfWeek()
  {
    return format("EEEE", timestamp);
  }
  
  public String formatTime()
  {
    return format("h:mma", timestamp);
  }
  
  public long getTimestamp()
  {
    return timestamp;
  }
  
  public TimeZone getTimezone()
  {
    if (Strings.isNullOrEmpty(timezone)) {
      return TimeZone.getDefault();
    }
    return TimeZone.getTimeZone(timezone);
  }
  
  public boolean isNull()
  {
    return false;
  }
  
  public boolean isToday()
  {
    GregorianCalendar localGregorianCalendar1 = new GregorianCalendar();
    localGregorianCalendar1.setTimeInMillis(DeviceClock.getCurrentTimeMs());
    GregorianCalendar localGregorianCalendar2 = new GregorianCalendar(getTimezone());
    localGregorianCalendar2.setTimeInMillis(timestamp);
    return localGregorianCalendar1.get(6) == localGregorianCalendar2.get(6);
  }
  
  public boolean isTomorrow()
  {
    GregorianCalendar localGregorianCalendar1 = new GregorianCalendar();
    localGregorianCalendar1.setTimeInMillis(DeviceClock.getCurrentTimeMs());
    localGregorianCalendar1.add(5, 1);
    GregorianCalendar localGregorianCalendar2 = new GregorianCalendar(getTimezone());
    localGregorianCalendar2.setTimeInMillis(timestamp);
    return localGregorianCalendar1.get(6) == localGregorianCalendar2.get(6);
  }
  
  public Time startTime()
  {
    return new Time(timestamp, timezone);
  }
  
  private static class NullTime
    extends Time
  {
    static final Time INSTANCE = new NullTime(Long.MIN_VALUE, "");
    
    NullTime(long paramLong, String paramString)
    {
      super(paramString);
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
 * Qualified Name:     me.lyft.android.domain.time.Time
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */