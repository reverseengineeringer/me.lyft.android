package me.lyft.android.infrastructure.leanplum;

import java.util.concurrent.TimeUnit;
import me.lyft.android.application.constants.Constants;
import me.lyft.android.application.constants.IConstantsProvider;
import rx.Scheduler.Worker;
import rx.functions.Action0;

class LeanplumService$4
  implements Action0
{
  LeanplumService$4(LeanplumService paramLeanplumService, Scheduler.Worker paramWorker) {}
  
  public void call()
  {
    LeanplumService.access$800(false, LeanplumService.access$700(this$0), LeanplumService.access$100(this$0));
    long l = Math.round(((Double)LeanplumService.access$100(this$0).get(Constants.LEANPLUM_POLLING_INTERVAL)).doubleValue() * 1000.0D);
    val$worker.schedule(this, l, TimeUnit.MILLISECONDS);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.leanplum.LeanplumService.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */