package me.lyft.android.analytics.studies;

import me.lyft.android.analytics.core.ActionAnalytics;
import me.lyft.android.analytics.core.ExperimentAnalytics;
import me.lyft.android.analytics.core.SpanningAnalytics;
import me.lyft.android.analytics.core.UxAnalytics;
import me.lyft.android.analytics.core.definitions.Experiment;
import me.lyft.android.analytics.core.events.ActionEvent.Action;
import me.lyft.android.analytics.definitions.UiElement;

public class DriverStatsAnalytics
{
  private static final String PARENT = "driver_stats";
  private static final String SHARE_METHOD_EMAIL = "email";
  private static final String SHARE_METHOD_SMS = "sms";
  private static final String TAG = "driver_stats";
  
  public static void displayDriverInvitesButton()
  {
    UxAnalytics.displayed(UiElement.DRIVER_INVITES_BUTTON).setParent("driver_stats").track();
  }
  
  public static void displayDriverReferralsView(int paramInt)
  {
    UxAnalytics.displayed(UiElement.DRIVER_REFERRALS_VIEW).setParent("driver_stats").setValue(paramInt).track();
  }
  
  public static void displayDriverStatsView()
  {
    UxAnalytics.displayed(UiElement.DRIVER_STATS_VIEW).setParent("driver_stats").track();
  }
  
  public static void displayRefereeCard()
  {
    UxAnalytics.displayed(UiElement.REFEREE_BONUS_CARD_VIEW).setParent("driver_stats").track();
  }
  
  public static void displaySignonCard()
  {
    UxAnalytics.displayed(UiElement.SIGNON_BONUS_CARD_VIEW).setParent("driver_stats").track();
  }
  
  public static void displayViewAllReferralsButton()
  {
    UxAnalytics.displayed(UiElement.VIEW_ALL_REFERRALS_BUTTON).setParent("driver_stats").track();
  }
  
  public static void tapDriverInvitesButton()
  {
    UxAnalytics.tapped(UiElement.DRIVER_INVITES_BUTTON).setParent("driver_stats").track();
  }
  
  public static void tapViewAllReferralsButton()
  {
    UxAnalytics.tapped(UiElement.VIEW_ALL_REFERRALS_BUTTON).setParent("driver_stats").track();
  }
  
  public static void trackBonusExperiments()
  {
    ExperimentAnalytics.trackExposure(Experiment.SL_SIGNON_BONUS_DRIVERSTAT_CARD);
    ExperimentAnalytics.trackExposure(Experiment.SL_REFEREE_BONUS_DRIVERSTAT_CARD);
  }
  
  private static void trackInviteDrivers(String paramString)
  {
    new ActionAnalytics(ActionEvent.Action.SEND_DRIVER_INVITE).setTag("driver_stats").setParameter(paramString).trackInitiation().trackSuccess();
  }
  
  public static void trackInviteDriversViaEmail()
  {
    trackInviteDrivers("email");
  }
  
  public static void trackInviteDriversViaSMS()
  {
    trackInviteDrivers("sms");
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.analytics.studies.DriverStatsAnalytics
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */