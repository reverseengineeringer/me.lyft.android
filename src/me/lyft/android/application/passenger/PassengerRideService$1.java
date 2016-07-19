package me.lyft.android.application.passenger;

import me.lyft.android.analytics.core.ActionAnalytics;
import rx.functions.Action1;

class PassengerRideService$1
  implements Action1<Throwable>
{
  PassengerRideService$1(PassengerRideService paramPassengerRideService, ActionAnalytics paramActionAnalytics) {}
  
  public void call(Throwable paramThrowable)
  {
    val$analytics.trackFailure(paramThrowable);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.passenger.PassengerRideService.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */