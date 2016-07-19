package me.lyft.android.application.ride;

import me.lyft.android.analytics.core.ActionAnalytics;
import rx.functions.Action1;

class DriverRouteService$1
  implements Action1<Throwable>
{
  DriverRouteService$1(DriverRouteService paramDriverRouteService, ActionAnalytics paramActionAnalytics) {}
  
  public void call(Throwable paramThrowable)
  {
    val$analytics.trackFailure(paramThrowable);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ride.DriverRouteService.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */