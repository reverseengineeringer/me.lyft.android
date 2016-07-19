package me.lyft.android.application.ride;

import me.lyft.android.analytics.core.ActionAnalytics;
import me.lyft.android.analytics.utils.AnalyticsUtils;
import me.lyft.android.common.Unit;
import rx.Notification;
import rx.functions.Action1;

class DriverRouteService$8
  implements Action1<Notification<? super Unit>>
{
  DriverRouteService$8(DriverRouteService paramDriverRouteService, ActionAnalytics paramActionAnalytics) {}
  
  public void call(Notification<? super Unit> paramNotification)
  {
    AnalyticsUtils.trackResult(val$dropOffAnalytics, paramNotification);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ride.DriverRouteService.8
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */