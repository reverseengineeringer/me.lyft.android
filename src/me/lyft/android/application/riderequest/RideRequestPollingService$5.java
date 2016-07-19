package me.lyft.android.application.riderequest;

import java.io.IOException;
import me.lyft.android.application.eta.IPickupEtaService;
import me.lyft.android.application.ride.IRideRequestSession;

class RideRequestPollingService$5
  extends RideRequestPollingService.PollingAction
{
  RideRequestPollingService$5(RideRequestPollingService paramRideRequestPollingService) {}
  
  public void call()
    throws IOException
  {
    RideRequestPollingService.access$700(this$0).updateEtas(RideRequestPollingService.access$400(this$0).getPickupLocation());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.riderequest.RideRequestPollingService.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */