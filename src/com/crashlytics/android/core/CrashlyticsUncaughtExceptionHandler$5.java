package com.crashlytics.android.core;

import java.util.Date;
import java.util.concurrent.Callable;

class CrashlyticsUncaughtExceptionHandler$5
  implements Callable<Void>
{
  CrashlyticsUncaughtExceptionHandler$5(CrashlyticsUncaughtExceptionHandler paramCrashlyticsUncaughtExceptionHandler, Date paramDate, Thread paramThread, Throwable paramThrowable) {}
  
  public Void call()
    throws Exception
  {
    CrashlyticsUncaughtExceptionHandler.access$100(this$0, val$now, val$thread, val$ex);
    return null;
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.core.CrashlyticsUncaughtExceptionHandler.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */