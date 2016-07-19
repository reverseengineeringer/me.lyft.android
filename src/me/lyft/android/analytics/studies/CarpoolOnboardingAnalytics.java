package me.lyft.android.analytics.studies;

import me.lyft.android.analytics.core.ActionAnalytics;
import me.lyft.android.analytics.core.SpanningAnalytics;
import me.lyft.android.analytics.core.UxAnalytics;
import me.lyft.android.analytics.core.events.ActionEvent.Action;
import me.lyft.android.analytics.definitions.UiElement;

public class CarpoolOnboardingAnalytics
{
  public static void trackCarouselSwipe(int paramInt)
  {
    UxAnalytics.displayed(UiElement.CARPOOL_DRIVER_ONBOARDING_PAGE).setValue(paramInt).track();
  }
  
  public static void trackCarpoolInviteTapped()
  {
    new ActionAnalytics(ActionEvent.Action.SHARE_CARPOOL_INVITE).trackInitiation().trackSuccess();
  }
  
  public static void trackLearnAboutDrivingTapped()
  {
    new ActionAnalytics(ActionEvent.Action.LEARN_ABOUT_CARPOOL_DRIVING).trackInitiation().trackSuccess();
  }
  
  public static void trackPassengerToSAccept()
  {
    new ActionAnalytics(ActionEvent.Action.ACCEPT_CARPOOL_TERMS).trackInitiation().trackSuccess();
  }
  
  public static void trackPassengerToSDismissed()
  {
    new ActionAnalytics(ActionEvent.Action.ACCEPT_CARPOOL_TERMS).trackInitiation().trackCanceled();
    RideAnalytics.trackRequestRideAction().trackFailure("carpool_terms");
  }
  
  public static void trackResumeButtonShown()
  {
    UxAnalytics.displayed(UiElement.CARPOOL_DRIVER_RESUME_SIGNUP_VIEW).track();
  }
  
  public static void trackResumeButtonTapped()
  {
    new ActionAnalytics(ActionEvent.Action.RESUME_CARPOOL_DRIVER_SIGNUP).trackInitiation().trackSuccess();
  }
  
  public static void trackSignupButtonTapped()
  {
    new ActionAnalytics(ActionEvent.Action.INITIATE_CARPOOL_DRIVER_SIGNUP).trackInitiation().trackSuccess();
  }
  
  public static void trackSignupTappedFromSettings()
  {
    UxAnalytics.tapped(UiElement.SETTINGS_CARPOOL_DRIVER_SIGNUP).track();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.analytics.studies.CarpoolOnboardingAnalytics
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */