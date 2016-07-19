package me.lyft.android.application.riderequest;

import java.io.IOException;
import me.lyft.android.application.cost.ICostService;
import me.lyft.android.application.ride.IRideRequestSession;

class RideRequestPollingService$6
  extends RideRequestPollingService.PollingAction
{
  RideRequestPollingService$6(RideRequestPollingService paramRideRequestPollingService) {}
  
  void call()
    throws IOException
  {
    RideRequestPollingService.access$800(this$0).updateCost(RideRequestPollingService.access$400(this$0).getPickupLocation(), RideRequestPollingService.access$400(this$0).getDropoffLocation(), RideRequestPollingService.access$400(this$0).getScheduledPickupTimeRange());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.riderequest.RideRequestPollingService.6
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */