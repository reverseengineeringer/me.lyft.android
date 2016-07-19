package me.lyft.android.application.ride;

import me.lyft.android.application.checkout.ICheckoutSession;
import me.lyft.android.domain.ride.ScheduledRide;
import rx.functions.Action1;

class RideRequestService$1
  implements Action1<ScheduledRide>
{
  RideRequestService$1(RideRequestService paramRideRequestService) {}
  
  public void call(ScheduledRide paramScheduledRide)
  {
    RideRequestService.access$000(this$0).clearConfirmations();
    RideRequestService.access$100(this$0).reset();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ride.RideRequestService.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */