package me.lyft.android.analytics.studies;

import me.lyft.android.analytics.core.UxAnalytics;
import me.lyft.android.analytics.definitions.Category;
import me.lyft.android.analytics.definitions.UiElement;

public class DriverAnalytics
{
  public static void trackDriverDefenseButtonTap()
  {
    UxAnalytics.tapped(UiElement.DRIVER_DEFENSE_BUTTON).setTag(Category.DRIVER.toString()).track();
  }
  
  public static void trackDriverDefenseDragToDismiss()
  {
    UxAnalytics.dismissed(UiElement.DRIVER_DEFENSE_BUTTON).setTag(Category.DRIVER.toString()).setParameter("dragged").track();
  }
  
  public static void trackDriverDefenseShown()
  {
    UxAnalytics.displayed(UiElement.DRIVER_DEFENSE_BUTTON).setTag(Category.DRIVER.toString()).track();
  }
  
  public static void trackDriverReroute()
  {
    UxAnalytics.displayed(UiElement.DRIVER_REROUTE).setTag(Category.DRIVER.toString()).track();
  }
  
  public static void trackDriverStatsDismiss()
  {
    UxAnalytics.dismissed(UiElement.DRIVER_STATS).setTag(Category.DRIVER.toString()).track();
  }
  
  public static void trackDriverStatsShown()
  {
    UxAnalytics.displayed(UiElement.DRIVER_STATS).setTag(Category.DRIVER.toString()).track();
  }
  
  public static void trackIncomingRequest()
  {
    UxAnalytics.displayed(UiElement.RIDE_REQUEST).setTag(Category.DRIVER.toString()).track();
  }
  
  public static void trackPrimeTimeShown(int paramInt)
  {
    UxAnalytics localUxAnalytics = UxAnalytics.displayed(UiElement.DRIVER_PRIME_TIME_BANNER).setTag(Category.DRIVER.toString());
    if (paramInt == 0) {}
    for (String str = null;; str = String.valueOf(paramInt))
    {
      localUxAnalytics.setParameter(str).track();
      return;
    }
  }
  
  public static void trackRequestMissed()
  {
    UxAnalytics.displayed(UiElement.RIDE_REQUEST_MISSED).setTag(Category.DRIVER.toString()).track();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.analytics.studies.DriverAnalytics
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */