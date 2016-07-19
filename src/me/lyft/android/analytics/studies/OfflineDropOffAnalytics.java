package me.lyft.android.analytics.studies;

import me.lyft.android.analytics.core.ActionAnalytics;
import me.lyft.android.analytics.core.events.ActionEvent.Action;

public class OfflineDropOffAnalytics
{
  private static final String TAG = "offline_drop_off";
  
  public static ActionAnalytics initiateDropOffAction()
  {
    ActionAnalytics localActionAnalytics = (ActionAnalytics)new ActionAnalytics(ActionEvent.Action.DROP_OFF).setTag("offline_drop_off");
    localActionAnalytics.trackInitiation();
    return localActionAnalytics;
  }
  
  public static ActionAnalytics initiateRateAction()
  {
    ActionAnalytics localActionAnalytics = (ActionAnalytics)new ActionAnalytics(ActionEvent.Action.RATE).setTag("offline_drop_off");
    localActionAnalytics.trackInitiation();
    return localActionAnalytics;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.analytics.studies.OfflineDropOffAnalytics
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */