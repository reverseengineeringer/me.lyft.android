package me.lyft.android.analytics.studies;

import me.lyft.android.analytics.core.ActionAnalytics;
import me.lyft.android.analytics.core.SpanningAnalytics;
import me.lyft.android.analytics.core.UxAnalytics;
import me.lyft.android.analytics.core.events.ActionEvent.Action;
import me.lyft.android.analytics.definitions.Category;
import me.lyft.android.analytics.definitions.UiElement;

public class DriverAcceptAnalytics
{
  public static ActionAnalytics initiateRideAcceptedAction()
  {
    return (ActionAnalytics)new ActionAnalytics(ActionEvent.Action.RIDE_ACCEPTED).setTag(Category.DRIVER.toString()).trackInitiation();
  }
  
  public static void trackDriverRideAcceptDisplayed()
  {
    UxAnalytics.displayed(UiElement.DRIVER_RIDE_ACCEPT).setTag(Category.DRIVER.toString()).track();
  }
  
  public static void trackDriverRideAcceptV2Displayed()
  {
    UxAnalytics.displayed(UiElement.DRIVER_RIDE_ACCEPT_V2).setTag(Category.DRIVER.toString()).track();
  }
  
  public static void trackLowAcceptRateBannerDisplayed()
  {
    UxAnalytics.displayed(UiElement.LOW_ACCEPT_RATE_BANNER).setTag(Category.DRIVER.toString()).track();
  }
  
  public static void trackMissedRequestModalDisplayed()
  {
    UxAnalytics.displayed(UiElement.MISSED_REQUEST_MODAL).setTag(Category.DRIVER.toString()).track();
  }
  
  public static void trackMissedRequestModalTapped()
  {
    UxAnalytics.tapped(UiElement.MISSED_REQUEST_MODAL).setTag(Category.DRIVER.toString()).track();
  }
  
  public static void trackTapHintDisplayed()
  {
    UxAnalytics.displayed(UiElement.ACCEPT_TAP_HINT).setTag(Category.DRIVER.toString()).track();
  }
  
  public static void trackTapToArriveViewDisplayed()
  {
    UxAnalytics.displayed(UiElement.TAP_TO_ARRIVE_VIEW).setTag(Category.DRIVER.toString()).track();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.analytics.studies.DriverAcceptAnalytics
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */