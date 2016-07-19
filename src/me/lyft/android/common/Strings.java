package me.lyft.android.common;

import java.util.List;
import java.util.Locale;

public class Strings
{
  public static String capitalizeWord(String paramString)
  {
    if (isNullOrEmpty(paramString)) {
      return "";
    }
    return paramString.substring(0, 1).toUpperCase() + paramString.substring(1).toLowerCase();
  }
  
  public static String emptyToNull(String paramString)
  {
    String str = paramString;
    if (isNullOrEmpty(paramString)) {
      str = null;
    }
    return str;
  }
  
  public static boolean equalsIgnoreCase(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return paramString2 == null;
    }
    return paramString1.equalsIgnoreCase(paramString2);
  }
  
  public static String firstNonEmpty(String... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      String str = paramVarArgs[i];
      if (!isNullOrEmpty(str)) {
        return str;
      }
      i += 1;
    }
    return null;
  }
  
  public static String formatString(String paramString, Object... paramVarArgs)
  {
    if (paramVarArgs.length == 0) {
      return paramString;
    }
    return String.format(paramString, paramVarArgs);
  }
  
  public static String formatUS(String paramString, Object... paramVarArgs)
  {
    return String.format(Locale.US, paramString, paramVarArgs);
  }
  
  public static boolean hasAnyPrefix(String paramString, String... paramVarArgs)
  {
    if (paramString == null) {}
    for (;;)
    {
      return false;
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        if (paramString.startsWith(paramVarArgs[i])) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public static boolean isNullOrBlank(String paramString)
  {
    return (paramString == null) || (paramString.trim().length() == 0);
  }
  
  public static boolean isNullOrEmpty(String paramString)
  {
    return (paramString == null) || (paramString.length() == 0);
  }
  
  public static String joinWithDelimiter(String paramString, List<String> paramList)
  {
    return joinWithDelimiter(paramString, (String[])paramList.toArray(new String[paramList.size()]));
  }
  
  public static String joinWithDelimiter(String paramString, String... paramVarArgs)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject1 = "";
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      String str = paramVarArgs[i];
      Object localObject2 = localObject1;
      if (!isNullOrEmpty(str))
      {
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append(str);
        localObject2 = paramString;
      }
      i += 1;
      localObject1 = localObject2;
    }
    return localStringBuilder.toString();
  }
  
  public static String nullOrEmptyToDefault(String paramString1, String paramString2)
  {
    if (isNullOrEmpty(paramString1)) {
      return paramString2;
    }
    return paramString1;
  }
  
  public static String nullToEmpty(String paramString)
  {
    return nullOrEmptyToDefault(paramString, "");
  }
  
  public static String replaceAllWhitespaces(String paramString)
  {
    return paramString.replaceAll("\\s+", "");
  }
  
  public static String toLowerCaseEnglish(String paramString)
  {
    return paramString.toLowerCase(Locale.ENGLISH);
  }
  
  public static String toUpperCaseEnglish(String paramString)
  {
    return paramString.toUpperCase(Locale.ENGLISH);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.common.Strings
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */