package me.lyft.android.analytics.studies;

import me.lyft.android.analytics.core.UxAnalytics;
import me.lyft.android.analytics.definitions.Category;
import me.lyft.android.analytics.definitions.UiElement;

@Deprecated
public final class RegistrationAnalytics
{
  public static void trackCloseTermsOfService()
  {
    UxAnalytics.tapped(UiElement.CLOSE_TOS).setTag(Category.REGISTRATION.toString()).track();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.analytics.studies.RegistrationAnalytics
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */