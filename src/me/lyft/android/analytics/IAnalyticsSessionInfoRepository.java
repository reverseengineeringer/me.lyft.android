package me.lyft.android.analytics;

import me.lyft.android.analytics.session.AnalyticsSessionInfo;

public abstract interface IAnalyticsSessionInfoRepository
{
  public abstract AnalyticsSessionInfo getAnalyticsSessionInfo();
  
  public abstract void setAnalyticsSessionInfo(AnalyticsSessionInfo paramAnalyticsSessionInfo);
}

/* Location:
 * Qualified Name:     me.lyft.android.analytics.IAnalyticsSessionInfoRepository
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */