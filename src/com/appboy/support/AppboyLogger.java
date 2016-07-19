package com.appboy.support;

import android.util.Log;

public class AppboyLogger
{
  public static int LogLevel = 2;
  public static final int SUPPRESS = Integer.MAX_VALUE;
  
  public static int d(String paramString1, String paramString2)
  {
    if (LogLevel <= 3) {
      return Log.d(paramString1, paramString2);
    }
    return 0;
  }
  
  public static int d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (LogLevel <= 3) {
      return Log.d(paramString1, paramString2, paramThrowable);
    }
    return 0;
  }
  
  public static int e(String paramString1, String paramString2)
  {
    if (LogLevel <= 6) {
      return Log.e(paramString1, paramString2);
    }
    return 0;
  }
  
  public static int e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (LogLevel <= 6) {
      return Log.e(paramString1, paramString2, paramThrowable);
    }
    return 0;
  }
  
  public static int i(String paramString1, String paramString2)
  {
    if (LogLevel <= 4) {
      return Log.i(paramString1, paramString2);
    }
    return 0;
  }
  
  public static int i(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (LogLevel <= 4) {
      return Log.i(paramString1, paramString2, paramThrowable);
    }
    return 0;
  }
  
  public static int v(String paramString1, String paramString2)
  {
    if (LogLevel <= 2) {
      return Log.v(paramString1, paramString2);
    }
    return 0;
  }
  
  public static int v(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (LogLevel <= 2) {
      return Log.v(paramString1, paramString2, paramThrowable);
    }
    return 0;
  }
  
  public static int w(String paramString1, String paramString2)
  {
    if (LogLevel <= 5) {
      return Log.w(paramString1, paramString2);
    }
    return 0;
  }
  
  public static int w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (LogLevel <= 5) {
      return Log.w(paramString1, paramString2, paramThrowable);
    }
    return 0;
  }
  
  public static int w(String paramString, Throwable paramThrowable)
  {
    if (LogLevel <= 5) {
      return Log.w(paramString, paramThrowable);
    }
    return 0;
  }
}

/* Location:
 * Qualified Name:     com.appboy.support.AppboyLogger
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */