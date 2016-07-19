package me.lyft.android.application.ride.flow;

import me.lyft.android.application.ride.IRideRequestSession;
import me.lyft.android.domain.passenger.ridetypes.RequestRideType;
import me.lyft.android.domain.passenger.ridetypes.RequestRideType.Feature;
import me.lyft.android.ui.routing.automaton.ConditionPredicate;

class FeaturesRequestFlow$9
  implements ConditionPredicate
{
  FeaturesRequestFlow$9(FeaturesRequestFlow paramFeaturesRequestFlow) {}
  
  public boolean evaluate()
  {
    return this$0.session.getCurrentRideType().hasFeature(RequestRideType.Feature.SCHEDULE_REQUIRED);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ride.flow.FeaturesRequestFlow.9
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */