package me.lyft.android.application.ride.flow;

import me.lyft.android.application.ride.IRideRequestSession;
import me.lyft.android.domain.location.Location;
import me.lyft.android.ui.routing.automaton.ConditionPredicate;

class FeaturesRequestFlow$1
  implements ConditionPredicate
{
  FeaturesRequestFlow$1(FeaturesRequestFlow paramFeaturesRequestFlow) {}
  
  public boolean evaluate()
  {
    return !this$0.session.getPickupLocation().isNull();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ride.flow.FeaturesRequestFlow.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */