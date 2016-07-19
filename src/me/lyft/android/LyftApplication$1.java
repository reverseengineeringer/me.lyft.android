package me.lyft.android;

import me.lyft.android.analytics.studies.AppAnalytics;
import me.lyft.android.application.ILogoutService;
import me.lyft.android.logging.L;

class LyftApplication$1
  implements Thread.UncaughtExceptionHandler
{
  LyftApplication$1(LyftApplication paramLyftApplication, Thread.UncaughtExceptionHandler paramUncaughtExceptionHandler) {}
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    AppAnalytics.trackAppCrash(paramThrowable);
    this$0.logoutService.resetCachedState();
    L.w(paramThrowable, "Uncaught exception on thread %s, crashing.", new Object[] { paramThread });
    val$crashlyticsErrorHandler.uncaughtException(paramThread, paramThrowable);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.LyftApplication.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */