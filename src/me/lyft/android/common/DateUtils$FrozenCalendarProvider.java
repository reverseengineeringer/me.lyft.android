package me.lyft.android.common;

import java.util.Calendar;

class DateUtils$FrozenCalendarProvider
  implements DateUtils.CalendarProvider
{
  private final Calendar calendar;
  
  public DateUtils$FrozenCalendarProvider(Calendar paramCalendar)
  {
    calendar = paramCalendar;
  }
  
  public Calendar getInstance()
  {
    return calendar;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.common.DateUtils.FrozenCalendarProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */