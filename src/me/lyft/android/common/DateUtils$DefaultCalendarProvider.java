package me.lyft.android.common;

import java.util.Calendar;

final class DateUtils$DefaultCalendarProvider
  implements DateUtils.CalendarProvider
{
  public static final DateUtils.CalendarProvider INSTANCE = new DefaultCalendarProvider();
  
  public Calendar getInstance()
  {
    return Calendar.getInstance();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.common.DateUtils.DefaultCalendarProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */