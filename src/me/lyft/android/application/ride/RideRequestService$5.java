package me.lyft.android.application.ride;

import me.lyft.android.application.checkout.ICheckoutSession;
import me.lyft.android.common.Unit;
import rx.functions.Action1;

class RideRequestService$5
  implements Action1<Unit>
{
  RideRequestService$5(RideRequestService paramRideRequestService) {}
  
  public void call(Unit paramUnit)
  {
    RideRequestService.access$000(this$0).clearConfirmations();
    RideRequestService.access$100(this$0).reset();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ride.RideRequestService.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */