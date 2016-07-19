package me.lyft.android.analytics.trackers;

import me.lyft.android.common.Unit;
import rx.Subscription;
import rx.functions.Action1;

class AnalyticsService$2
  implements Action1<Unit>
{
  AnalyticsService$2(AnalyticsService paramAnalyticsService) {}
  
  public void call(Unit paramUnit)
  {
    AnalyticsService.access$200(this$0);
    AnalyticsService.access$300(this$0).unsubscribe();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.analytics.trackers.AnalyticsService.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */