package com.crashlytics.android.core;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;

class CrashlyticsUncaughtExceptionHandler$6
  implements Callable<Void>
{
  CrashlyticsUncaughtExceptionHandler$6(CrashlyticsUncaughtExceptionHandler paramCrashlyticsUncaughtExceptionHandler, long paramLong, String paramString) {}
  
  public Void call()
    throws Exception
  {
    if (!CrashlyticsUncaughtExceptionHandler.access$200(this$0).get()) {
      CrashlyticsUncaughtExceptionHandler.access$300(this$0).writeToLog(val$timestamp, val$msg);
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.core.CrashlyticsUncaughtExceptionHandler.6
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */