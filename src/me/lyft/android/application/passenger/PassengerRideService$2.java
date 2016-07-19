package me.lyft.android.application.passenger;

import com.lyft.android.api.dto.UniversalDTO;
import me.lyft.android.analytics.core.ActionAnalytics;
import me.lyft.android.application.checkout.ICheckoutSession;
import me.lyft.android.application.ride.IExpenseNoteSession;
import me.lyft.android.application.ride.IRatingSession;
import me.lyft.android.application.ride.IRideRequestSession;
import rx.functions.Action1;

class PassengerRideService$2
  implements Action1<UniversalDTO>
{
  PassengerRideService$2(PassengerRideService paramPassengerRideService, ActionAnalytics paramActionAnalytics) {}
  
  public void call(UniversalDTO paramUniversalDTO)
  {
    PassengerRideService.access$000(this$0).clearRideRequest();
    PassengerRideService.access$100(this$0).reset();
    PassengerRideService.access$200(this$0).reset();
    PassengerRideService.access$300(this$0).resetChargeAccountAndCoupon();
    val$analytics.trackSuccess();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.passenger.PassengerRideService.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */