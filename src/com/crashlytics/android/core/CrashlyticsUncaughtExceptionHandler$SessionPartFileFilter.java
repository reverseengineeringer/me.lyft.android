package com.crashlytics.android.core;

import java.io.File;
import java.io.FilenameFilter;

class CrashlyticsUncaughtExceptionHandler$SessionPartFileFilter
  implements FilenameFilter
{
  private final String sessionId;
  
  public CrashlyticsUncaughtExceptionHandler$SessionPartFileFilter(String paramString)
  {
    sessionId = paramString;
  }
  
  public boolean accept(File paramFile, String paramString)
  {
    if (paramString.equals(sessionId + ".cls")) {}
    while ((!paramString.contains(sessionId)) || (paramString.endsWith(".cls_temp"))) {
      return false;
    }
    return true;
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.core.CrashlyticsUncaughtExceptionHandler.SessionPartFileFilter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */