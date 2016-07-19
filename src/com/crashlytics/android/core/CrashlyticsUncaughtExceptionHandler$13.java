package com.crashlytics.android.core;

import java.io.File;
import java.io.FilenameFilter;

class CrashlyticsUncaughtExceptionHandler$13
  implements FilenameFilter
{
  CrashlyticsUncaughtExceptionHandler$13(CrashlyticsUncaughtExceptionHandler paramCrashlyticsUncaughtExceptionHandler, String paramString) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    return paramString.startsWith(val$sessionId);
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.core.CrashlyticsUncaughtExceptionHandler.13
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */