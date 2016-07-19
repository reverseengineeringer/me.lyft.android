package me.lyft.android.application.ride.flow;

import me.lyft.android.application.ride.IRideRequestSession;
import me.lyft.android.application.venue.IVenuePickupService;
import me.lyft.android.domain.location.Location;
import me.lyft.android.domain.passenger.ride.PassengerRideRequest.RequestRideStep;
import me.lyft.android.domain.passenger.ridetypes.RequestRideType;
import me.lyft.android.domain.passenger.ridetypes.RequestRideType.Feature;
import me.lyft.android.domain.ride.ScheduledInterval;
import me.lyft.android.ui.routing.automaton.Condition;
import me.lyft.android.ui.routing.automaton.ConditionPredicate;
import me.lyft.android.ui.routing.automaton.DirectionalAutomaton;
import me.lyft.android.ui.routing.automaton.DirectionalAutomaton.Builder;

public class FeaturesRequestFlow
  extends RequestFlow
{
  private final DirectionalAutomaton<PassengerRideRequest.RequestRideStep> directionalAutomaton = buildFlow();
  
  public FeaturesRequestFlow(IRideRequestSession paramIRideRequestSession, IVenuePickupService paramIVenuePickupService)
  {
    super(paramIRideRequestSession, paramIVenuePickupService);
  }
  
  private DirectionalAutomaton<PassengerRideRequest.RequestRideStep> buildFlow()
  {
    DirectionalAutomaton.Builder localBuilder = DirectionalAutomaton.startWith(PassengerRideRequest.RequestRideStep.SET_PICKUP);
    localBuilder.from(PassengerRideRequest.RequestRideStep.SET_PICKUP).completesIf(new ConditionPredicate()
    {
      public boolean evaluate()
      {
        return !session.getPickupLocation().isNull();
      }
    }).advance(Condition.IF_AVAILABLE).to(PassengerRideRequest.RequestRideStep.SET_VENUE_PICKUP).advance(Condition.IF_AVAILABLE).to(PassengerRideRequest.RequestRideStep.SET_DROPOFF).advance(Condition.OTHERWISE).to(PassengerRideRequest.RequestRideStep.CONFIRM_REQUEST_WITH_DESTINATION);
    localBuilder.from(PassengerRideRequest.RequestRideStep.SET_VENUE_PICKUP).availableIf(new ConditionPredicate()
    {
      public boolean evaluate()
      {
        return hasPickupVenue();
      }
    }).completesIf(new ConditionPredicate()
    {
      public boolean evaluate()
      {
        return session.hasVenuePickupLocation();
      }
    }).advance(Condition.IF_AVAILABLE).to(PassengerRideRequest.RequestRideStep.SET_DROPOFF).back().to(PassengerRideRequest.RequestRideStep.SET_PICKUP).advance(Condition.OTHERWISE).to(PassengerRideRequest.RequestRideStep.CONFIRM_REQUEST_WITH_DESTINATION);
    localBuilder.from(PassengerRideRequest.RequestRideStep.SET_DROPOFF).availableIf(new ConditionPredicate()
    {
      public boolean evaluate()
      {
        return session.getCurrentRideType().hasFeature(RequestRideType.Feature.DESTINATION_REQUIRED);
      }
    }).completesIf(new ConditionPredicate()
    {
      public boolean evaluate()
      {
        return !session.getDropoffLocation().isNull();
      }
    }).advance(Condition.IF_AVAILABLE).to(PassengerRideRequest.RequestRideStep.SET_REQUIRED_PICKUP_TIME).back(Condition.IF_COMPLETED).to(PassengerRideRequest.RequestRideStep.SET_VENUE_PICKUP).back().to(PassengerRideRequest.RequestRideStep.SET_PICKUP).advance(Condition.OTHERWISE).to(PassengerRideRequest.RequestRideStep.CONFIRM_REQUEST_WITH_DESTINATION);
    localBuilder.from(PassengerRideRequest.RequestRideStep.SET_ARRIVAL_TIME).availableIf(new ConditionPredicate()
    {
      public boolean evaluate()
      {
        return session.getCurrentRideType().hasFeature(RequestRideType.Feature.SUPPORTS_SCHEDULED_RIDE);
      }
    }).completesIf(new ConditionPredicate()
    {
      public boolean evaluate()
      {
        return !session.getScheduledInterval().isNull();
      }
    }).advance(Condition.IF_AVAILABLE).to(PassengerRideRequest.RequestRideStep.SET_VENUE_PICKUP).back(Condition.IF_AVAILABLE).to(PassengerRideRequest.RequestRideStep.SET_DROPOFF).back().to(PassengerRideRequest.RequestRideStep.SET_PICKUP).advance(Condition.OTHERWISE).to(PassengerRideRequest.RequestRideStep.CONFIRM_REQUEST_WITH_DESTINATION);
    localBuilder.from(PassengerRideRequest.RequestRideStep.SET_REQUIRED_PICKUP_TIME).availableIf(new ConditionPredicate()
    {
      public boolean evaluate()
      {
        return session.getCurrentRideType().hasFeature(RequestRideType.Feature.SCHEDULE_REQUIRED);
      }
    }).completesIf(new ConditionPredicate()
    {
      public boolean evaluate()
      {
        return !session.getScheduledInterval().isNull();
      }
    }).back(Condition.IF_AVAILABLE).to(PassengerRideRequest.RequestRideStep.SET_DROPOFF).back().to(PassengerRideRequest.RequestRideStep.SET_PICKUP).advance(Condition.OTHERWISE).to(PassengerRideRequest.RequestRideStep.CONFIRM_REQUEST_WITH_DESTINATION);
    localBuilder.from(PassengerRideRequest.RequestRideStep.CONFIRM_REQUEST_WITH_DESTINATION).back(Condition.IF_AVAILABLE).to(PassengerRideRequest.RequestRideStep.SET_REQUIRED_PICKUP_TIME).back(Condition.IF_AVAILABLE).to(PassengerRideRequest.RequestRideStep.SET_DROPOFF).back(Condition.IF_COMPLETED).to(PassengerRideRequest.RequestRideStep.SET_VENUE_PICKUP).back().to(PassengerRideRequest.RequestRideStep.SET_PICKUP);
    return localBuilder.finishWith(PassengerRideRequest.RequestRideStep.CONFIRM_REQUEST_WITH_DESTINATION);
  }
  
  public PassengerRideRequest.RequestRideStep determineCurrentStep()
  {
    return (PassengerRideRequest.RequestRideStep)directionalAutomaton.farthest();
  }
  
  public PassengerRideRequest.RequestRideStep getFirstStep()
  {
    return (PassengerRideRequest.RequestRideStep)directionalAutomaton.first();
  }
  
  public PassengerRideRequest.RequestRideStep getLastStep()
  {
    return (PassengerRideRequest.RequestRideStep)directionalAutomaton.last();
  }
  
  public PassengerRideRequest.RequestRideStep getNextStep(PassengerRideRequest.RequestRideStep paramRequestRideStep)
  {
    return (PassengerRideRequest.RequestRideStep)directionalAutomaton.next(paramRequestRideStep);
  }
  
  public PassengerRideRequest.RequestRideStep getPreviousStep(PassengerRideRequest.RequestRideStep paramRequestRideStep)
  {
    return (PassengerRideRequest.RequestRideStep)directionalAutomaton.previous(paramRequestRideStep);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ride.flow.FeaturesRequestFlow
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */