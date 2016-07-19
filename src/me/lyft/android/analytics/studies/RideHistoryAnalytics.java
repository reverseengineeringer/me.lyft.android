package me.lyft.android.analytics.studies;

import me.lyft.android.analytics.core.UxAnalytics;
import me.lyft.android.analytics.definitions.Category;
import me.lyft.android.analytics.definitions.UiElement;

public class RideHistoryAnalytics
{
  public static void trackAddTipTap(String paramString)
  {
    UxAnalytics.tapped(UiElement.RIDE_DETAILS_ADD_TIP).setParameter(paramString).setTag(Category.RIDE_HISTORY.toString()).track();
  }
  
  public static void trackIndividualItemTap(String paramString)
  {
    UxAnalytics.tapped(UiElement.RIDE_HISTORY).setParameter(paramString).setTag(Category.RIDE_HISTORY.toString()).track();
  }
  
  public static void trackLostAndFoundTap(String paramString)
  {
    UxAnalytics.tapped(UiElement.RIDE_DETAILS_LOST_AND_FOUND).setParameter(paramString).setTag(Category.RIDE_HISTORY.toString()).track();
  }
  
  public static void trackPriceReviewTap(String paramString)
  {
    UxAnalytics.tapped(UiElement.RIDE_DETAILS_PRICE_REVIEW).setParameter(paramString).setTag(Category.RIDE_HISTORY.toString()).track();
  }
  
  public static void trackRideHistorySidebarTap()
  {
    UxAnalytics.tapped(UiElement.RIDE_HISTORY_SIDEBAR).setTag(Category.RIDE_HISTORY.toString()).track();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.analytics.studies.RideHistoryAnalytics
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */