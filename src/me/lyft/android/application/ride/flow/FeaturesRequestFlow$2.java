package me.lyft.android.application.ride.flow;

import me.lyft.android.application.ride.IRideRequestSession;
import me.lyft.android.ui.routing.automaton.ConditionPredicate;

class FeaturesRequestFlow$2
  implements ConditionPredicate
{
  FeaturesRequestFlow$2(FeaturesRequestFlow paramFeaturesRequestFlow) {}
  
  public boolean evaluate()
  {
    return this$0.session.hasVenuePickupLocation();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ride.flow.FeaturesRequestFlow.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */