package com.crashlytics.android.core;

import java.util.Date;
import java.util.concurrent.atomic.AtomicBoolean;

class CrashlyticsUncaughtExceptionHandler$7
  implements Runnable
{
  CrashlyticsUncaughtExceptionHandler$7(CrashlyticsUncaughtExceptionHandler paramCrashlyticsUncaughtExceptionHandler, Date paramDate, Thread paramThread, Throwable paramThrowable) {}
  
  public void run()
  {
    if (!CrashlyticsUncaughtExceptionHandler.access$200(this$0).get()) {
      CrashlyticsUncaughtExceptionHandler.access$400(this$0, val$now, val$thread, val$ex);
    }
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.core.CrashlyticsUncaughtExceptionHandler.7
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */