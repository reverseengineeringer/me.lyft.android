package me.lyft.android.application.ride;

import com.lyft.android.api.dto.RideRequestDetailsDTO;
import me.lyft.android.application.checkout.ICheckoutSession;
import rx.functions.Action1;

class WearRideRequestService$1
  implements Action1<RideRequestDetailsDTO>
{
  WearRideRequestService$1(WearRideRequestService paramWearRideRequestService) {}
  
  public void call(RideRequestDetailsDTO paramRideRequestDetailsDTO)
  {
    WearRideRequestService.access$000(this$0).reset();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ride.WearRideRequestService.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */