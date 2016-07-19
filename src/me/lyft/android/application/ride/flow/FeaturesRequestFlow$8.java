package me.lyft.android.application.ride.flow;

import me.lyft.android.application.ride.IRideRequestSession;
import me.lyft.android.domain.ride.ScheduledInterval;
import me.lyft.android.ui.routing.automaton.ConditionPredicate;

class FeaturesRequestFlow$8
  implements ConditionPredicate
{
  FeaturesRequestFlow$8(FeaturesRequestFlow paramFeaturesRequestFlow) {}
  
  public boolean evaluate()
  {
    return !this$0.session.getScheduledInterval().isNull();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ride.flow.FeaturesRequestFlow.8
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */