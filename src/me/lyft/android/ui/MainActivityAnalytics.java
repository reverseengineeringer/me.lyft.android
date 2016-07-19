package me.lyft.android.ui;

import me.lyft.android.analytics.core.ActionAnalytics;
import me.lyft.android.analytics.core.events.ActionEvent.Action;

public class MainActivityAnalytics
{
  public void trackUnavailableGooglePlayServices()
  {
    ActionAnalytics localActionAnalytics = new ActionAnalytics(ActionEvent.Action.GOOGLE_PLAY_SERVICES_INSTALLED);
    localActionAnalytics.trackInitiation();
    localActionAnalytics.trackFailure();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.MainActivityAnalytics
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */