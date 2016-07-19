package me.lyft.android.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailUtils
{
  private static final String EMAIL_PATTERN = "^[\\w\\.+-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
  private static final Pattern PATTERN = Pattern.compile("^[\\w\\.+-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$", 2);
  
  public static boolean validateEmail(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString != null)
    {
      Matcher localMatcher = PATTERN.matcher(paramString);
      bool1 = bool2;
      if (!Strings.isNullOrBlank(paramString))
      {
        bool1 = bool2;
        if (localMatcher.matches()) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.common.EmailUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */