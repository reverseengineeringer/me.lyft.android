package com.crashlytics.android.core;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class CrashlyticsUncaughtExceptionHandler$AnySessionPartFileFilter
  implements FilenameFilter
{
  public boolean accept(File paramFile, String paramString)
  {
    return (!CrashlyticsUncaughtExceptionHandler.SESSION_FILE_FILTER.accept(paramFile, paramString)) && (CrashlyticsUncaughtExceptionHandler.access$000().matcher(paramString).matches());
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.core.CrashlyticsUncaughtExceptionHandler.AnySessionPartFileFilter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */