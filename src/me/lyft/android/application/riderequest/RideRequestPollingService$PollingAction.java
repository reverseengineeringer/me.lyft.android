package me.lyft.android.application.riderequest;

import java.util.concurrent.TimeUnit;
import rx.Scheduler.Worker;
import rx.functions.Action0;

abstract class RideRequestPollingService$PollingAction
  extends RideRequestPollingService.SynchronousAction
{
  final void reschedule(Action0 paramAction0, Scheduler.Worker paramWorker, long paramLong, TimeUnit paramTimeUnit)
  {
    paramWorker.schedule(paramAction0, paramLong, paramTimeUnit);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.riderequest.RideRequestPollingService.PollingAction
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */