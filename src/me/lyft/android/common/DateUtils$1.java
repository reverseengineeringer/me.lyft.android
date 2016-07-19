package me.lyft.android.common;

import java.text.DateFormat;
import java.util.TimeZone;

final class DateUtils$1
  extends ThreadLocal<DateFormat>
{
  protected DateFormat initialValue()
  {
    DateFormat localDateFormat = DateUtils.createDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
    localDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
    return localDateFormat;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.common.DateUtils.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */