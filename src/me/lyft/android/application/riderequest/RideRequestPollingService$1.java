package me.lyft.android.application.riderequest;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.functions.Action1;

class RideRequestPollingService$1
  implements Action1<Boolean>
{
  RideRequestPollingService$1(RideRequestPollingService paramRideRequestPollingService) {}
  
  public void call(Boolean paramBoolean)
  {
    if (paramBoolean.booleanValue()) {
      if (!RideRequestPollingService.access$000(this$0).getAndSet(true)) {
        RideRequestPollingService.access$100(this$0);
      }
    }
    while (!RideRequestPollingService.access$000(this$0).getAndSet(false)) {
      return;
    }
    RideRequestPollingService.access$200(this$0);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.riderequest.RideRequestPollingService.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */