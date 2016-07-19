package me.lyft.android.application.riderequest;

import java.io.IOException;
import me.lyft.android.application.drivers.INearbyDriversService;
import me.lyft.android.application.ride.IRideRequestSession;

class RideRequestPollingService$4
  extends RideRequestPollingService.PollingAction
{
  RideRequestPollingService$4(RideRequestPollingService paramRideRequestPollingService) {}
  
  public void call()
    throws IOException
  {
    RideRequestPollingService.access$600(this$0).updateNearbyDrivers(RideRequestPollingService.access$400(this$0).getPickupLocation());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.riderequest.RideRequestPollingService.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */