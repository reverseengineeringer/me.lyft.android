package me.lyft.android.common;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DateUtils
{
  static CalendarProvider CALENDAR_PROVIDER = DefaultCalendarProvider.INSTANCE;
  static final ThreadLocal<DateFormat> DATE_FORMAT = new ThreadLocal()
  {
    protected DateFormat initialValue()
    {
      DateFormat localDateFormat = DateUtils.createDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
      localDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
      return localDateFormat;
    }
  };
  static final String FORMAT_ISO_8601 = "yyyy-MM-dd'T'HH:mm:ss'Z'";
  static final String FORMAT_RFC_3339 = "yyyy-MM-dd'T'HH:mm:ssZZZZZ";
  
  public static String convertEpochToISO(long paramLong)
  {
    Date localDate = new Date(paramLong);
    return ((DateFormat)DATE_FORMAT.get()).format(localDate);
  }
  
  public static long convertISOtoEpoch(String paramString)
    throws ParseException
  {
    return ((DateFormat)DATE_FORMAT.get()).parse(paramString).getTime();
  }
  
  public static long convertISOtoEpochOrDefault(String paramString, long paramLong)
  {
    try
    {
      long l = convertISOtoEpoch(paramString);
      return l;
    }
    catch (Exception paramString) {}
    return paramLong;
  }
  
  public static Date createDate(int paramInt1, int paramInt2, int paramInt3)
  {
    Calendar localCalendar = CALENDAR_PROVIDER.getInstance();
    localCalendar.set(1, paramInt1);
    localCalendar.set(2, paramInt2);
    localCalendar.set(5, paramInt3);
    return localCalendar.getTime();
  }
  
  public static DateFormat createDateFormat(String paramString)
  {
    return new SimpleDateFormat(paramString, Locale.US);
  }
  
  public static Date decode(String paramString)
    throws Exception
  {
    if (paramString.endsWith("Z")) {}
    for (Object localObject = "yyyy-MM-dd'T'HH:mm:ss'Z'";; localObject = "yyyy-MM-dd'T'HH:mm:ssZZZZZ")
    {
      localObject = createDateFormat((String)localObject);
      ((DateFormat)localObject).setTimeZone(TimeZone.getTimeZone("UTC"));
      return ((DateFormat)localObject).parse(paramString);
    }
  }
  
  public static String encode(long paramLong)
  {
    return createDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").format(new Date(paramLong));
  }
  
  public static void freezeTime(Calendar paramCalendar)
  {
    CALENDAR_PROVIDER = new FrozenCalendarProvider(paramCalendar);
  }
  
  public static Calendar fromDate(Date paramDate)
  {
    Calendar localCalendar = CALENDAR_PROVIDER.getInstance();
    localCalendar.setTime(paramDate);
    return localCalendar;
  }
  
  public static boolean hasMonthPassed(int paramInt1, int paramInt2)
  {
    Calendar localCalendar = CALENDAR_PROVIDER.getInstance();
    return (hasYearPassed(paramInt1)) || ((normalizeYear(paramInt1) == localCalendar.get(1)) && (paramInt2 < localCalendar.get(2) + 1));
  }
  
  public static boolean hasYearPassed(int paramInt)
  {
    return normalizeYear(paramInt) < CALENDAR_PROVIDER.getInstance().get(1);
  }
  
  public static int normalizeYear(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 100)
    {
      i = paramInt;
      if (paramInt >= 0)
      {
        int k = CALENDAR_PROVIDER.getInstance().get(1);
        i = k;
        int j = i;
        if (paramInt > 50)
        {
          j = i;
          if (Math.abs(k % 100 - paramInt) > 30) {
            j = k - paramInt;
          }
        }
        String str = String.valueOf(j);
        i = Integer.parseInt(Strings.formatUS("%s%02d", new Object[] { str.substring(0, str.length() - 2), Integer.valueOf(paramInt) }));
      }
    }
    return i;
  }
  
  public static void unfreeze()
  {
    CALENDAR_PROVIDER = DefaultCalendarProvider.INSTANCE;
  }
  
  static abstract interface CalendarProvider
  {
    public abstract Calendar getInstance();
  }
  
  static final class DefaultCalendarProvider
    implements DateUtils.CalendarProvider
  {
    public static final DateUtils.CalendarProvider INSTANCE = new DefaultCalendarProvider();
    
    public Calendar getInstance()
    {
      return Calendar.getInstance();
    }
  }
  
  private static class FrozenCalendarProvider
    implements DateUtils.CalendarProvider
  {
    private final Calendar calendar;
    
    public FrozenCalendarProvider(Calendar paramCalendar)
    {
      calendar = paramCalendar;
    }
    
    public Calendar getInstance()
    {
      return calendar;
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.common.DateUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */