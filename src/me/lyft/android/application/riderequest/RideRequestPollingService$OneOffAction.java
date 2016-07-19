package me.lyft.android.application.riderequest;

import java.util.concurrent.TimeUnit;
import rx.Scheduler.Worker;
import rx.functions.Action0;

abstract class RideRequestPollingService$OneOffAction
  extends RideRequestPollingService.SynchronousAction
{
  final void reschedule(Action0 paramAction0, Scheduler.Worker paramWorker, long paramLong, TimeUnit paramTimeUnit)
  {
    paramWorker.unsubscribe();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.riderequest.RideRequestPollingService.OneOffAction
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */