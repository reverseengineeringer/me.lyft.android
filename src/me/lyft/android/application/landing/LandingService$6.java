package me.lyft.android.application.landing;

import me.lyft.android.analytics.core.ActionAnalytics;
import me.lyft.android.analytics.utils.AnalyticsUtils;
import me.lyft.android.common.Unit;
import rx.Notification;
import rx.functions.Action1;

class LandingService$6
  implements Action1<Notification<? super Unit>>
{
  LandingService$6(LandingService paramLandingService, ActionAnalytics paramActionAnalytics) {}
  
  public void call(Notification<? super Unit> paramNotification)
  {
    AnalyticsUtils.trackResult(val$analytics, paramNotification);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.landing.LandingService.6
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */