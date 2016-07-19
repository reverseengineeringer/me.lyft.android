package me.lyft.android.analytics.studies;

import me.lyft.android.analytics.core.UxAnalytics;
import me.lyft.android.analytics.definitions.Category;
import me.lyft.android.analytics.definitions.UiElement;

public class EndRideConfirmationAnalytics
{
  public static void trackCancelRide()
  {
    UxAnalytics.tapped(UiElement.CANCEL_RIDE).setTag(Category.END_RIDE_CONFIRMATION.toString()).track();
  }
  
  public static void trackDontEndOrCancel()
  {
    UxAnalytics.tapped(UiElement.DONT_END_OR_CANCEL).setTag(Category.END_RIDE_CONFIRMATION.toString()).track();
  }
  
  public static void trackEndRide()
  {
    UxAnalytics.tapped(UiElement.END_RIDE).setTag(Category.END_RIDE_CONFIRMATION.toString()).track();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.analytics.studies.EndRideConfirmationAnalytics
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */