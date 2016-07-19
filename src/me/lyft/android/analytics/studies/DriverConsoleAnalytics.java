package me.lyft.android.analytics.studies;

import me.lyft.android.analytics.core.ActionAnalytics;
import me.lyft.android.analytics.core.SpanningAnalytics;
import me.lyft.android.analytics.core.UxAnalytics;
import me.lyft.android.analytics.core.events.ActionEvent.Action;
import me.lyft.android.analytics.definitions.Category;
import me.lyft.android.analytics.definitions.UiElement;

public class DriverConsoleAnalytics
{
  private static final String DRIVER_CONSOLE = "driver_console";
  private static final String DRIVER_HOME_VIEW = "driver_home_view";
  private static final String GO_OFFLINE = "go_offline";
  private static final String GO_ONLINE_TOOLBAR_DRIVER_UI = "go_online_toolbar_driver_ui";
  private static final String GO_ONLINE_TOOLBAR_PAX_UI = "go_online_toolbar_pax_ui";
  private static final String MAIN_SIDE_MENU = "main_side_menu";
  private static final String PASSENGER_MAP_IDLE = "passenger_map_idle";
  private final ActionAnalytics tapNewsFeedButton = new ActionAnalytics(ActionEvent.Action.NEWS_FEED_MESSAGE_BUTTON);
  private final ActionAnalytics trackModeToggleTapOffline = new ActionAnalytics(ActionEvent.Action.MODE_TOGGLE);
  private final ActionAnalytics trackModeToggleTapOnline = new ActionAnalytics(ActionEvent.Action.MODE_TOGGLE);
  private final ActionAnalytics trackUiToggle = new ActionAnalytics(ActionEvent.Action.OFFLINE_MODE_TOGGLE);
  
  public void displayApplicantModal()
  {
    UxAnalytics.displayed(UiElement.APPLICANT_MODAL_VIEW).setParent("driver_console").track();
  }
  
  public void displayNewsFeedMessage(String paramString, int paramInt)
  {
    UxAnalytics.displayed(UiElement.NEWS_FEED_MESSAGE).setParent("driver_home_view").setParameter(paramString).setValue(paramInt).track();
  }
  
  public void displayPrimeTime(String paramString)
  {
    UxAnalytics.displayed(UiElement.PRIME_TIME_VIEW).setParent("driver_console").setParameter(paramString).track();
  }
  
  public void tapApplicantModal()
  {
    UxAnalytics.tapped(UiElement.APPLICANT_MODAL_VIEW).setParent("driver_console").track();
  }
  
  public void tapNewsFeedMessageButton(String paramString, int paramInt)
  {
    tapNewsFeedButton.setTag("driver_home_view").setParameter(paramString).setValue(paramInt).trackInitiation();
  }
  
  public void tapNewsFeedMessageButtonFailure()
  {
    if (!tapNewsFeedButton.isComplete()) {
      tapNewsFeedButton.trackFailure();
    }
  }
  
  public void tapNewsFeedMessageButtonSuccess()
  {
    if (!tapNewsFeedButton.isComplete()) {
      tapNewsFeedButton.trackSuccess();
    }
  }
  
  public void trackDriverHomeView(String paramString)
  {
    UxAnalytics.displayed(UiElement.DRIVER_HOME_VIEW).setParent("driver_console").setParameter(paramString).track();
  }
  
  public void trackGoOfflineFromMainSideMenuPaxUi()
  {
    trackUiToggle.setTag("main_side_menu").setParameter(Category.DRIVER.toString()).trackInitiation();
  }
  
  public void trackGoOfflineFromOnline()
  {
    trackModeToggleTapOffline.setTag(Category.DRIVER.toString()).setParameter("go_offline").trackInitiation();
  }
  
  public void trackGoOfflineFromToolbarPaxUi()
  {
    trackUiToggle.setTag("passenger_map_idle").setParameter(Category.DRIVER.toString()).trackInitiation();
  }
  
  public void trackGoOnlineFromMenuPaxUi()
  {
    trackModeToggleTapOnline.setTag(Category.DRIVER.toString()).setParameter("main_side_menu").trackInitiation();
  }
  
  public void trackGoOnlineFromToolbarDriverUi()
  {
    trackModeToggleTapOnline.setTag(Category.DRIVER.toString()).setParameter("go_online_toolbar_driver_ui").trackInitiation();
  }
  
  public void trackGoOnlineFromToolbarPaxUi()
  {
    trackModeToggleTapOnline.setTag(Category.DRIVER.toString()).setParameter("go_online_toolbar_pax_ui").trackInitiation();
  }
  
  public void trackGoOnlineSuccess()
  {
    if (!trackModeToggleTapOnline.isComplete()) {
      trackModeToggleTapOnline.trackSuccess();
    }
  }
  
  public void trackGoPaxUiFromSideMenuDriverUi()
  {
    trackUiToggle.setTag("main_side_menu").setParameter(Category.PASSENGER.toString()).trackInitiation();
  }
  
  public void trackModeToggleTapOfflineFailure(String paramString)
  {
    if (!trackModeToggleTapOffline.isComplete()) {
      trackModeToggleTapOffline.trackFailure(paramString);
    }
  }
  
  public void trackModeToggleTapOfflineSuccess()
  {
    if (!trackModeToggleTapOffline.isComplete()) {
      trackModeToggleTapOffline.trackSuccess();
    }
  }
  
  public void trackModeToggleTapOnlineFailure(String paramString)
  {
    if (!trackModeToggleTapOnline.isComplete()) {
      trackModeToggleTapOnline.trackFailure(paramString);
    }
  }
  
  public void trackUiToggleSuccess()
  {
    if (!trackUiToggle.isComplete()) {
      trackUiToggle.trackSuccess();
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.analytics.studies.DriverConsoleAnalytics
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */