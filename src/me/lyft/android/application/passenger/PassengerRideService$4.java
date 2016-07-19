package me.lyft.android.application.passenger;

import me.lyft.android.analytics.core.ActionAnalytics;
import me.lyft.android.analytics.utils.AnalyticsUtils;
import me.lyft.android.common.Unit;
import rx.Notification;
import rx.functions.Action1;

class PassengerRideService$4
  implements Action1<Notification<? super Unit>>
{
  PassengerRideService$4(PassengerRideService paramPassengerRideService, ActionAnalytics paramActionAnalytics) {}
  
  public void call(Notification<? super Unit> paramNotification)
  {
    AnalyticsUtils.trackResult(val$analytics, paramNotification);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.passenger.PassengerRideService.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */