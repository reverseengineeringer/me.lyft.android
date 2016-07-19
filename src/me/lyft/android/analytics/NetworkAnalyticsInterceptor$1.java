package me.lyft.android.analytics;

import me.lyft.android.infrastructure.device.IDevice;

class NetworkAnalyticsInterceptor$1
  extends ThreadLocal<NetworkAnalyticsInterceptor.NetworkAnalytics>
{
  NetworkAnalyticsInterceptor$1(NetworkAnalyticsInterceptor paramNetworkAnalyticsInterceptor, IDevice paramIDevice) {}
  
  public NetworkAnalyticsInterceptor.NetworkAnalytics initialValue()
  {
    return new NetworkAnalyticsInterceptor.NetworkAnalytics(val$device);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.analytics.NetworkAnalyticsInterceptor.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */