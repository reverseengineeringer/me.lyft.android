package me.lyft.android.analytics.studies;

import me.lyft.android.analytics.core.UxAnalytics;
import me.lyft.android.analytics.definitions.Category;
import me.lyft.android.analytics.definitions.UiElement;

public class ProfileAnalytics
{
  public static void updatePhoto()
  {
    UxAnalytics.tapped(UiElement.UPDATE_PROFILE_PHOTO).setTag(Category.PROFILE.toString()).track();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.analytics.studies.ProfileAnalytics
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */