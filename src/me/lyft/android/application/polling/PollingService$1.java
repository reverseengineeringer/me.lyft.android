package me.lyft.android.application.polling;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import me.lyft.android.ILyftPreferences;
import rx.Scheduler.Worker;
import rx.functions.Action0;
import rx.functions.Action1;

class PollingService$1
  implements Action0
{
  PollingService$1(PollingService paramPollingService, Scheduler.Worker paramWorker) {}
  
  public void call()
  {
    try
    {
      if (!val$worker.isUnsubscribed())
      {
        PollingService.access$000(this$0);
        PollingService.access$100(this$0).updateLocationSync();
      }
      if (val$worker.isUnsubscribed()) {
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      boolean bool = localThrowable instanceof InterruptedIOException;
      if (!bool) {
        break label110;
      }
      return;
      label110:
      PollingService.access$200(this$0).call(localThrowable);
      return;
    }
    finally
    {
      while (val$worker.isUnsubscribed()) {}
      val$worker.schedule(this, PollingService.access$300(this$0).getPollingRate(), TimeUnit.MILLISECONDS);
    }
    val$worker.schedule(this, PollingService.access$300(this$0).getPollingRate(), TimeUnit.MILLISECONDS);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.polling.PollingService.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */