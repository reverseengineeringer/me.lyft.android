package me.lyft.android.services;

import com.google.firebase.messaging.RemoteMessage;
import rx.Scheduler.Worker;
import rx.functions.Action0;

class GcmService$1
  implements Action0
{
  GcmService$1(GcmService paramGcmService, RemoteMessage paramRemoteMessage, Scheduler.Worker paramWorker) {}
  
  public void call()
  {
    GcmService.access$000(this$0, val$remoteMessage.getFrom(), val$remoteMessage.getData());
    val$worker.unsubscribe();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.services.GcmService.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */