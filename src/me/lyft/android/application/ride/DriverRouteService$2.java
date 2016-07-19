package me.lyft.android.application.ride;

import me.lyft.android.analytics.core.ActionAnalytics;
import me.lyft.android.common.Unit;
import rx.functions.Action1;

class DriverRouteService$2
  implements Action1<Unit>
{
  DriverRouteService$2(DriverRouteService paramDriverRouteService, ActionAnalytics paramActionAnalytics) {}
  
  public void call(Unit paramUnit)
  {
    val$analytics.trackSuccess();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ride.DriverRouteService.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */