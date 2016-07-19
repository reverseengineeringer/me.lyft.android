package me.lyft.android.analytics.studies;

import me.lyft.android.analytics.core.UxAnalytics;
import me.lyft.android.analytics.definitions.UiElement;

public class CarpoolRideAnalytics
{
  public static void trackRideRequestViewed(int paramInt)
  {
    UxAnalytics.displayed(UiElement.CARPOOL_DRIVER_REQUEST_VIEW).setValue(paramInt).track();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.analytics.studies.CarpoolRideAnalytics
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */