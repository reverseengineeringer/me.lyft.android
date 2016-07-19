package me.lyft.android.analytics.studies;

import me.lyft.android.analytics.core.UxAnalytics;
import me.lyft.android.analytics.definitions.Category;
import me.lyft.android.analytics.definitions.UiElement;

public class DriverDocumentsAnalytics
{
  public static void driverInsuranceDialogNotNow()
  {
    UxAnalytics.tapped(UiElement.DRIVER_INSURANCE_PROMPT_NOT_NOW).setTag(Category.DRIVER_DOCUMENTS.toString()).track();
  }
  
  public static void driverInsuranceDialogUpdate()
  {
    UxAnalytics.tapped(UiElement.DRIVER_INSURANCE_PROMPT_UPDATE).setTag(Category.DRIVER_DOCUMENTS.toString()).track();
  }
  
  public static void driverInsuranceUpdate()
  {
    UxAnalytics.tapped(UiElement.DRIVER_INSURANCE_UPDATE).setTag(Category.DRIVER_DOCUMENTS.toString()).track();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.analytics.studies.DriverDocumentsAnalytics
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */