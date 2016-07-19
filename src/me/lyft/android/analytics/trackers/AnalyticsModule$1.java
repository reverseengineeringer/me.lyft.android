package me.lyft.android.analytics.trackers;

import me.lyft.android.ILyftPreferences;
import me.lyft.android.analytics.IAnalyticsSessionInfoRepository;
import me.lyft.android.analytics.session.AnalyticsSessionInfo;

class AnalyticsModule$1
  implements IAnalyticsSessionInfoRepository
{
  AnalyticsModule$1(AnalyticsModule paramAnalyticsModule, ILyftPreferences paramILyftPreferences) {}
  
  public AnalyticsSessionInfo getAnalyticsSessionInfo()
  {
    return val$lyftPreferences.getAnalyticsSession();
  }
  
  public void setAnalyticsSessionInfo(AnalyticsSessionInfo paramAnalyticsSessionInfo)
  {
    val$lyftPreferences.setAnalyticsSession(paramAnalyticsSessionInfo);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.analytics.trackers.AnalyticsModule.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */