package me.lyft.android.application.ride.flow;

import me.lyft.android.application.ride.IRideRequestSession;
import me.lyft.android.application.venue.IVenuePickupService;

public class RequestFlowProvider
  implements IRequestFlowProvider
{
  private final RequestFlow featuresRequestFlow;
  
  public RequestFlowProvider(IRideRequestSession paramIRideRequestSession, IVenuePickupService paramIVenuePickupService)
  {
    featuresRequestFlow = new FeaturesRequestFlow(paramIRideRequestSession, paramIVenuePickupService);
  }
  
  public RequestFlow getRequestFlow()
  {
    return featuresRequestFlow;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ride.flow.RequestFlowProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */