package me.lyft.android.analytics;

public abstract interface IAnalyticsRideInfoProvider
{
  public abstract String getRideId();
  
  public abstract String getRideStatus();
  
  public abstract String getRideType();
  
  public abstract boolean hasRide();
}

/* Location:
 * Qualified Name:     me.lyft.android.analytics.IAnalyticsRideInfoProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */