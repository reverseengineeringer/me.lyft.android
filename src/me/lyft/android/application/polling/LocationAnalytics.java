package me.lyft.android.application.polling;

import me.lyft.android.analytics.core.CallAnalytics;
import me.lyft.android.analytics.core.events.CallEvent.Call;

public class LocationAnalytics
{
  private CallAnalytics fusedLocationAnalytics = null;
  private CallAnalytics uluRequestAnalytics = null;
  
  public void initializeUluRequest()
  {
    uluRequestAnalytics = new CallAnalytics(CallEvent.Call.LOCATION_UPDATE);
    uluRequestAnalytics.trackInitiation();
  }
  
  public void trackFusedLocationError(String paramString, int paramInt)
  {
    if (fusedLocationAnalytics != null)
    {
      fusedLocationAnalytics.setValue(paramInt);
      fusedLocationAnalytics.trackFailure(paramString);
      fusedLocationAnalytics = null;
    }
  }
  
  public void trackFusedLocationInitialization()
  {
    CallAnalytics localCallAnalytics = new CallAnalytics(CallEvent.Call.FUSED_LOCATION);
    localCallAnalytics.trackInitiation();
    fusedLocationAnalytics = localCallAnalytics;
  }
  
  public void trackFusedLocationSuccess()
  {
    if (fusedLocationAnalytics != null)
    {
      fusedLocationAnalytics.trackSuccess();
      fusedLocationAnalytics = null;
    }
  }
  
  public void trackUluFailure(int paramInt)
  {
    if (uluRequestAnalytics != null)
    {
      uluRequestAnalytics.setValue(paramInt);
      uluRequestAnalytics.trackFailure();
    }
  }
  
  public void trackUluSuccess(int paramInt)
  {
    if (uluRequestAnalytics != null)
    {
      uluRequestAnalytics.setValue(paramInt);
      uluRequestAnalytics.trackSuccess();
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.polling.LocationAnalytics
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */