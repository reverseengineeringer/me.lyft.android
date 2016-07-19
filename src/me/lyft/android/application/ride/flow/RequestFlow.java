package me.lyft.android.application.ride.flow;

import me.lyft.android.application.ride.IRideRequestSession;
import me.lyft.android.application.venue.IVenuePickupService;
import me.lyft.android.domain.passenger.ride.PassengerRideRequest.RequestRideStep;

public abstract class RequestFlow
{
  protected final IRideRequestSession session;
  protected final IVenuePickupService venueService;
  
  public RequestFlow(IRideRequestSession paramIRideRequestSession, IVenuePickupService paramIVenuePickupService)
  {
    session = paramIRideRequestSession;
    venueService = paramIVenuePickupService;
  }
  
  public abstract PassengerRideRequest.RequestRideStep determineCurrentStep();
  
  public abstract PassengerRideRequest.RequestRideStep getFirstStep();
  
  public abstract PassengerRideRequest.RequestRideStep getLastStep();
  
  public final PassengerRideRequest.RequestRideStep getNextStep()
  {
    return getNextStep(session.getRequestRideStep());
  }
  
  public abstract PassengerRideRequest.RequestRideStep getNextStep(PassengerRideRequest.RequestRideStep paramRequestRideStep);
  
  public final PassengerRideRequest.RequestRideStep getPreviousStep()
  {
    return getPreviousStep(session.getRequestRideStep());
  }
  
  public abstract PassengerRideRequest.RequestRideStep getPreviousStep(PassengerRideRequest.RequestRideStep paramRequestRideStep);
  
  protected boolean hasPickupVenue()
  {
    return venueService.hasVenue(session.getPickupLocation());
  }
  
  public final boolean isFirstStep()
  {
    return session.getRequestRideStep() == getFirstStep();
  }
  
  public final boolean isLastStep()
  {
    return session.getRequestRideStep() == getLastStep();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ride.flow.RequestFlow
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */