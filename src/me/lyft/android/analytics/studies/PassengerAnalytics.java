package me.lyft.android.analytics.studies;

import me.lyft.android.analytics.core.UxAnalytics;
import me.lyft.android.analytics.definitions.Category;
import me.lyft.android.analytics.definitions.UiElement;

public class PassengerAnalytics
{
  public static void trackCancellationDismiss()
  {
    UxAnalytics.dismissed(UiElement.PASSENGER_CANCELLATION_DIALOG).setTag(Category.PASSENGER.toString()).track();
  }
  
  public static void trackCancellationShown()
  {
    UxAnalytics.displayed(UiElement.PASSENGER_CANCELLATION_DIALOG).setTag(Category.PASSENGER.toString()).track();
  }
  
  public static void trackMapMove()
  {
    UxAnalytics.tapped(UiElement.PASSENGER_MAP_MOVE).setTag(Category.PASSENGER.toString()).track();
  }
  
  public static void trackTextDriverTap()
  {
    UxAnalytics.tapped(UiElement.TEXT_DRIVER).setTag(Category.PASSENGER.toString()).track();
  }
  
  public static void trackZoomButtonTap()
  {
    UxAnalytics.tapped(UiElement.PASSENGER_MAP_ZOOM_BUTTON).setTag(Category.PASSENGER.toString()).track();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.analytics.studies.PassengerAnalytics
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */