package me.lyft.android.infrastructure.deferred;

import rx.Scheduler.Worker;
import rx.functions.Action0;

class DeferredCallService$2
  implements Action0
{
  DeferredCallService$2(DeferredCallService paramDeferredCallService, Scheduler.Worker paramWorker, IDeferredCall paramIDeferredCall) {}
  
  public void call()
  {
    if (val$worker.isUnsubscribed()) {
      return;
    }
    DeferredCallService.access$000(this$0).add(val$call);
    DeferredCallService.access$100(this$0).scheduleSync();
    this$0.sync();
    val$worker.unsubscribe();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.deferred.DeferredCallService.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */