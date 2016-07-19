package bo.app;

import com.appboy.Constants;
import com.appboy.support.AppboyLogger;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

public final class fg
{
  private static final String a = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, fg.class.getName() });
  private static final Locale b = Locale.US;
  private static final TimeZone c = TimeZone.getTimeZone("UTC");
  
  public static long a()
  {
    return System.currentTimeMillis() / 1000L;
  }
  
  public static String a(Date paramDate, aa paramaa)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat();
    localSimpleDateFormat.setTimeZone(c);
    switch (fh.a[paramaa.ordinal()])
    {
    default: 
      AppboyLogger.w(a, "Unsupported date format. Defaulting to " + bc);
      localSimpleDateFormat.applyPattern(bc);
    }
    for (;;)
    {
      return localSimpleDateFormat.format(paramDate);
      localSimpleDateFormat.applyPattern(ac);
      continue;
      localSimpleDateFormat.applyPattern(bc);
    }
  }
  
  public static Date a(int paramInt1, int paramInt2, int paramInt3)
  {
    GregorianCalendar localGregorianCalendar = new GregorianCalendar(paramInt1, paramInt2, paramInt3, 0, 0, 0);
    localGregorianCalendar.setTimeZone(c);
    return localGregorianCalendar.getTime();
  }
  
  public static Date a(long paramLong)
  {
    return new Date(1000L * paramLong);
  }
  
  public static double b()
  {
    return System.currentTimeMillis() / 1000.0D;
  }
  
  public static long c()
  {
    return System.currentTimeMillis();
  }
}

/* Location:
 * Qualified Name:     bo.app.fg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */