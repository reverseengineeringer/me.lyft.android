package me.lyft.android.application.riderequest;

import java.util.concurrent.TimeUnit;
import me.lyft.android.ILyftPreferences;
import rx.Scheduler.Worker;
import rx.functions.Action0;

class RideRequestPollingService$7
  implements Action0
{
  RideRequestPollingService$7(RideRequestPollingService paramRideRequestPollingService, Scheduler.Worker paramWorker, RideRequestPollingService.SynchronousAction paramSynchronousAction) {}
  
  public void call()
  {
    if (val$worker.isUnsubscribed()) {
      return;
    }
    val$action.callSafely();
    val$action.reschedule(this, val$worker, RideRequestPollingService.access$900(this$0).getPollingRate(), TimeUnit.MILLISECONDS);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.riderequest.RideRequestPollingService.7
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */