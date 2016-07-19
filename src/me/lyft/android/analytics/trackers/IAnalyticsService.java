package me.lyft.android.analytics.trackers;

public abstract interface IAnalyticsService
{
  public abstract void onApplicationCreate();
  
  public abstract void setAnalyticsUrl(String paramString);
}

/* Location:
 * Qualified Name:     me.lyft.android.analytics.trackers.IAnalyticsService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */