package com.facebook.internal;

import android.util.Log;
import com.facebook.FacebookSdk;
import com.facebook.LoggingBehavior;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class Logger
{
  public static final String LOG_TAG_BASE = "FacebookSDK.";
  private static final HashMap<String, String> stringsToReplace = new HashMap();
  private final LoggingBehavior behavior;
  private StringBuilder contents;
  private int priority = 3;
  private final String tag;
  
  public Logger(LoggingBehavior paramLoggingBehavior, String paramString)
  {
    Validate.notNullOrEmpty(paramString, "tag");
    behavior = paramLoggingBehavior;
    tag = ("FacebookSDK." + paramString);
    contents = new StringBuilder();
  }
  
  public static void log(LoggingBehavior paramLoggingBehavior, int paramInt, String paramString1, String paramString2)
  {
    if (FacebookSdk.isLoggingBehaviorEnabled(paramLoggingBehavior))
    {
      String str = replaceStrings(paramString2);
      paramString2 = paramString1;
      if (!paramString1.startsWith("FacebookSDK.")) {
        paramString2 = "FacebookSDK." + paramString1;
      }
      Log.println(paramInt, paramString2, str);
      if (paramLoggingBehavior == LoggingBehavior.DEVELOPER_ERRORS) {
        new Exception().printStackTrace();
      }
    }
  }
  
  public static void log(LoggingBehavior paramLoggingBehavior, int paramInt, String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (FacebookSdk.isLoggingBehaviorEnabled(paramLoggingBehavior)) {
      log(paramLoggingBehavior, paramInt, paramString1, String.format(paramString2, paramVarArgs));
    }
  }
  
  public static void log(LoggingBehavior paramLoggingBehavior, String paramString1, String paramString2)
  {
    log(paramLoggingBehavior, 3, paramString1, paramString2);
  }
  
  public static void log(LoggingBehavior paramLoggingBehavior, String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (FacebookSdk.isLoggingBehaviorEnabled(paramLoggingBehavior)) {
      log(paramLoggingBehavior, 3, paramString1, String.format(paramString2, paramVarArgs));
    }
  }
  
  public static void registerAccessToken(String paramString)
  {
    try
    {
      if (!FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.INCLUDE_ACCESS_TOKENS)) {
        registerStringToReplace(paramString, "ACCESS_TOKEN_REMOVED");
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static void registerStringToReplace(String paramString1, String paramString2)
  {
    try
    {
      stringsToReplace.put(paramString1, paramString2);
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  private static String replaceStrings(String paramString)
  {
    try
    {
      Iterator localIterator = stringsToReplace.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        paramString = paramString.replace((CharSequence)localEntry.getKey(), (CharSequence)localEntry.getValue());
      }
      return paramString;
    }
    finally {}
  }
  
  private boolean shouldLog()
  {
    return FacebookSdk.isLoggingBehaviorEnabled(behavior);
  }
  
  public void append(String paramString)
  {
    if (shouldLog()) {
      contents.append(paramString);
    }
  }
  
  public void append(String paramString, Object... paramVarArgs)
  {
    if (shouldLog()) {
      contents.append(String.format(paramString, paramVarArgs));
    }
  }
  
  public void append(StringBuilder paramStringBuilder)
  {
    if (shouldLog()) {
      contents.append(paramStringBuilder);
    }
  }
  
  public void appendKeyValue(String paramString, Object paramObject)
  {
    append("  %s:\t%s\n", new Object[] { paramString, paramObject });
  }
  
  public String getContents()
  {
    return replaceStrings(contents.toString());
  }
  
  public int getPriority()
  {
    return priority;
  }
  
  public void log()
  {
    logString(contents.toString());
    contents = new StringBuilder();
  }
  
  public void logString(String paramString)
  {
    log(behavior, priority, tag, paramString);
  }
  
  public void setPriority(int paramInt)
  {
    Validate.oneOf(Integer.valueOf(paramInt), "value", new Object[] { Integer.valueOf(7), Integer.valueOf(3), Integer.valueOf(6), Integer.valueOf(4), Integer.valueOf(2), Integer.valueOf(5) });
    priority = paramInt;
  }
}

/* Location:
 * Qualified Name:     com.facebook.internal.Logger
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */