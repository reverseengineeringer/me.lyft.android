package me.lyft.android.application.riderequest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import me.lyft.android.common.ExceptionUtils;
import me.lyft.android.logging.L;
import rx.Scheduler.Worker;
import rx.functions.Action0;

abstract class RideRequestPollingService$SynchronousAction
{
  abstract void call()
    throws IOException;
  
  final void callSafely()
  {
    try
    {
      call();
      return;
    }
    catch (Throwable localThrowable)
    {
      while (ExceptionUtils.isInterruptedException(localThrowable)) {}
      L.w(localThrowable, "polling failed", new Object[0]);
    }
  }
  
  abstract void reschedule(Action0 paramAction0, Scheduler.Worker paramWorker, long paramLong, TimeUnit paramTimeUnit);
}

/* Location:
 * Qualified Name:     me.lyft.android.application.riderequest.RideRequestPollingService.SynchronousAction
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */