package me.lyft.android.application.riderequest;

import java.io.IOException;
import me.lyft.android.application.requestridetypes.IRequestRideTypeService;
import me.lyft.android.application.ride.IRideRequestSession;

class RideRequestPollingService$3
  extends RideRequestPollingService.PollingAction
{
  RideRequestPollingService$3(RideRequestPollingService paramRideRequestPollingService) {}
  
  public void call()
    throws IOException
  {
    RideRequestPollingService.access$500(this$0).updateRideTypes(RideRequestPollingService.access$400(this$0).getPickupLocation());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.riderequest.RideRequestPollingService.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */