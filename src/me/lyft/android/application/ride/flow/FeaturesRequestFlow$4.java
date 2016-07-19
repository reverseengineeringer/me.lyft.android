package me.lyft.android.application.ride.flow;

import me.lyft.android.application.ride.IRideRequestSession;
import me.lyft.android.domain.location.Location;
import me.lyft.android.ui.routing.automaton.ConditionPredicate;

class FeaturesRequestFlow$4
  implements ConditionPredicate
{
  FeaturesRequestFlow$4(FeaturesRequestFlow paramFeaturesRequestFlow) {}
  
  public boolean evaluate()
  {
    return !this$0.session.getDropoffLocation().isNull();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ride.flow.FeaturesRequestFlow.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */