package com.crashlytics.android.core;

class CrashlyticsUncaughtExceptionHandler$12
  implements Runnable
{
  CrashlyticsUncaughtExceptionHandler$12(CrashlyticsUncaughtExceptionHandler paramCrashlyticsUncaughtExceptionHandler) {}
  
  public void run()
  {
    this$0.doCleanInvalidTempFiles(CrashlyticsUncaughtExceptionHandler.access$1200(this$0, ClsFileOutputStream.TEMP_FILENAME_FILTER));
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.core.CrashlyticsUncaughtExceptionHandler.12
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */