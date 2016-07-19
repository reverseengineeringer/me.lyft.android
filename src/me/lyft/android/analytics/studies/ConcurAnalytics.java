package me.lyft.android.analytics.studies;

import me.lyft.android.analytics.core.UxAnalytics;
import me.lyft.android.analytics.definitions.Category;
import me.lyft.android.analytics.definitions.UiElement;

public class ConcurAnalytics
{
  public static void sendReceiptsDisabled()
  {
    UxAnalytics.tapped(UiElement.T_AND_E_SEND_RECEIPTS_DISABLED).setTag(Category.CONCUR.toString()).track();
  }
  
  public static void sendReceiptsDisabledDuringRide()
  {
    UxAnalytics.tapped(UiElement.T_AND_E_SEND_RECEIPTS_DISABLED_DURING_RIDE).setTag(Category.CONCUR.toString()).track();
  }
  
  public static void sendReceiptsEnabled()
  {
    UxAnalytics.tapped(UiElement.T_AND_E_SEND_RECEIPTS_ENABLED).setTag(Category.CONCUR.toString()).track();
  }
  
  public static void sendReceiptsEnabledDuringRide()
  {
    UxAnalytics.tapped(UiElement.T_AND_E_SEND_RECEIPTS_ENABLED_DURING_RIDE).setTag(Category.CONCUR.toString()).track();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.analytics.studies.ConcurAnalytics
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */