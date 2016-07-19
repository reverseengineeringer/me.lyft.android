package me.lyft.android.analytics.trackers;

import me.lyft.android.domain.User;
import rx.functions.Action1;

class AnalyticsService$1
  implements Action1<User>
{
  AnalyticsService$1(AnalyticsService paramAnalyticsService) {}
  
  public void call(User paramUser)
  {
    AnalyticsService.access$000(this$0).updateUserInfo(paramUser);
    AnalyticsService.access$100(this$0, paramUser);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.analytics.trackers.AnalyticsService.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */