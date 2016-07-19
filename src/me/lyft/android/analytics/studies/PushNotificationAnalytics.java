package me.lyft.android.analytics.studies;

import me.lyft.android.analytics.core.UxAnalytics;
import me.lyft.android.analytics.core.events.IEvent.Priority;
import me.lyft.android.analytics.definitions.Category;
import me.lyft.android.analytics.definitions.UiElement;

public class PushNotificationAnalytics
{
  public static void trackAppboyPushDisplayed()
  {
    UxAnalytics.displayed(UiElement.PUSH_NOTIFICATION).setPriority(IEvent.Priority.CRITICAL).setTag(Category.APPBOY.toString()).track();
  }
  
  public static void trackAppboyPushTapped(String paramString)
  {
    UxAnalytics.tapped(UiElement.PUSH_NOTIFICATION).setPriority(IEvent.Priority.CRITICAL).setTag(Category.APPBOY.toString()).setParameter(paramString).track();
  }
  
  public static void trackAppboyUninstallTrackingPush()
  {
    UxAnalytics.dismissed(UiElement.PUSH_NOTIFICATION).setPriority(IEvent.Priority.CRITICAL).setTag(Category.APPBOY.toString()).setParameter("uninstall_tracking").track();
  }
  
  public static void trackPushDisplayed(String paramString1, String paramString2)
  {
    UxAnalytics.displayed(UiElement.PUSH_NOTIFICATION).setPriority(IEvent.Priority.CRITICAL).setTag(Category.NOTIFICATION.toString()).setParameter(paramString1).setParent(paramString2).track();
  }
  
  public static void trackPushTapped(String paramString1, String paramString2)
  {
    UxAnalytics.tapped(UiElement.PUSH_NOTIFICATION).setPriority(IEvent.Priority.CRITICAL).setTag(Category.NOTIFICATION.toString()).setParameter(paramString1).setParent(paramString2).track();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.analytics.studies.PushNotificationAnalytics
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */