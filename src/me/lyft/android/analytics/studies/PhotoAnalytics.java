package me.lyft.android.analytics.studies;

import me.lyft.android.analytics.core.UxAnalytics;
import me.lyft.android.analytics.definitions.Category;
import me.lyft.android.analytics.definitions.UiElement;

public class PhotoAnalytics
{
  public static void choosePhoto(Category paramCategory)
  {
    UxAnalytics.tapped(UiElement.CHOOSE_PHOTO).setTag(paramCategory.toString()).track();
  }
  
  public static void takePhoto(Category paramCategory)
  {
    UxAnalytics.tapped(UiElement.TAKE_PHOTO).setTag(paramCategory.toString()).track();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.analytics.studies.PhotoAnalytics
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */