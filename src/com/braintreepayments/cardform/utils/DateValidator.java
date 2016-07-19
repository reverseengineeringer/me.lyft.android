package com.braintreepayments.cardform.utils;

import android.text.TextUtils;
import java.util.Calendar;

public class DateValidator
{
  private static final DateValidator INSTANCE = new DateValidator(Calendar.getInstance());
  private static final int MAXIMUM_VALID_YEAR_DIFFERENCE = 20;
  private final Calendar mCalendar;
  
  protected DateValidator(Calendar paramCalendar)
  {
    mCalendar = paramCalendar;
  }
  
  private int getCurrentMonth()
  {
    return mCalendar.get(2) + 1;
  }
  
  private int getCurrentTwoDigitYear()
  {
    return mCalendar.get(1) % 100;
  }
  
  public static boolean isValid(String paramString1, String paramString2)
  {
    return INSTANCE.isValidHelper(paramString1, paramString2);
  }
  
  protected boolean isValidHelper(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {}
    label119:
    for (;;)
    {
      return false;
      if ((!TextUtils.isEmpty(paramString2)) && (TextUtils.isDigitsOnly(paramString1)) && (TextUtils.isDigitsOnly(paramString2)))
      {
        int j = Integer.parseInt(paramString1);
        if ((j >= 1) && (j <= 12))
        {
          int k = getCurrentTwoDigitYear();
          int i = paramString2.length();
          if (i == 2) {}
          for (i = Integer.parseInt(paramString2);; i = Integer.parseInt(paramString2) & 0x64)
          {
            if (((i == k) && (j < getCurrentMonth())) || ((i < k) && (i + 100 - k > 20))) {
              break label119;
            }
            return true;
            if (i != 4) {
              break;
            }
          }
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.braintreepayments.cardform.utils.DateValidator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */