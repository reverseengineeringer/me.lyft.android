package me.lyft.android.services;

import com.firebase.jobdispatcher.JobParameters;
import rx.Scheduler.Worker;
import rx.functions.Action0;

class DeferredCallSyncService$1
  implements Action0
{
  DeferredCallSyncService$1(DeferredCallSyncService paramDeferredCallSyncService, Scheduler.Worker paramWorker, JobParameters paramJobParameters) {}
  
  public void call()
  {
    if (val$worker.isUnsubscribed()) {
      return;
    }
    DeferredCallSyncService.access$000(this$0, val$jobParameters);
    val$worker.unsubscribe();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.services.DeferredCallSyncService.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */