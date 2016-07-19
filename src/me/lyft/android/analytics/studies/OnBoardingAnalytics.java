package me.lyft.android.analytics.studies;

import me.lyft.android.analytics.core.ActionAnalytics;
import me.lyft.android.analytics.core.IntentAnalytics;
import me.lyft.android.analytics.core.SpanningAnalytics;
import me.lyft.android.analytics.core.UxAnalytics;
import me.lyft.android.analytics.core.events.ActionEvent.Action;
import me.lyft.android.analytics.core.events.IntentEvent.Intent;
import me.lyft.android.analytics.definitions.UiElement;

public class OnBoardingAnalytics
{
  private static final IntentAnalytics ONBOARDING_INTENT = new IntentAnalytics(IntentEvent.Intent.ONBOARD);
  private static final String TAG = "onboarding";
  
  public static ActionAnalytics trackAddFacebook()
  {
    return (ActionAnalytics)new ActionAnalytics(ActionEvent.Action.ADD_FACEBOOK).setIntentId(ONBOARDING_INTENT.getId()).setTag("onboarding").trackInitiation();
  }
  
  public static ActionAnalytics trackAddPhone(String paramString, int paramInt)
  {
    return (ActionAnalytics)new ActionAnalytics(ActionEvent.Action.ADD_PHONE).setIntentId(ONBOARDING_INTENT.getId()).setParameter(paramString).setValue(paramInt).setTag("onboarding").trackInitiation();
  }
  
  public static ActionAnalytics trackAddProfileInfo()
  {
    return (ActionAnalytics)new ActionAnalytics(ActionEvent.Action.ADD_PROFILE_INFO).setIntentId(ONBOARDING_INTENT.getId()).setTag("onboarding").trackInitiation();
  }
  
  public static void trackCompleteOnboarding()
  {
    ONBOARDING_INTENT.trackSuccess();
  }
  
  public static ActionAnalytics trackForceNewAccount(String paramString)
  {
    return (ActionAnalytics)new ActionAnalytics(ActionEvent.Action.FORCE_NEW_ACCOUNT).setParameter(paramString).setTag("onboarding").trackInitiation();
  }
  
  public static void trackInitiateLogin(String paramString)
  {
    new ActionAnalytics(ActionEvent.Action.INITIATE_LOGIN).setIntentId(ONBOARDING_INTENT.getId()).setParameter(paramString).setTag("onboarding").trackInitiation().trackSuccess();
  }
  
  public static void trackInitiateOnboarding()
  {
    ONBOARDING_INTENT.setTag("onboarding").trackInitiation();
  }
  
  public static void trackInitiateSignup(String paramString)
  {
    new ActionAnalytics(ActionEvent.Action.INITIATE_SIGNUP).setIntentId(ONBOARDING_INTENT.getId()).setParameter(paramString).setTag("onboarding").trackInitiation().trackSuccess();
  }
  
  public static ActionAnalytics trackLoginChallenge(String paramString)
  {
    return (ActionAnalytics)new ActionAnalytics(ActionEvent.Action.LOGIN_CHALLENGE).setParameter(paramString).setTag("onboarding").trackInitiation();
  }
  
  public static ActionAnalytics trackLogoutUser(String paramString)
  {
    return (ActionAnalytics)new ActionAnalytics(ActionEvent.Action.LOGOUT_USER).setIntentId(ONBOARDING_INTENT.getId()).setTag("onboarding").setParameter(paramString).trackInitiation();
  }
  
  public static void trackReceiveReferral(String paramString)
  {
    new ActionAnalytics(ActionEvent.Action.RECEIVE_REFERRAL).setTag("onboarding").setParameter(paramString).trackInitiation().trackSuccess();
  }
  
  public static ActionAnalytics trackReferralImage()
  {
    return (ActionAnalytics)new ActionAnalytics(ActionEvent.Action.LOAD_REFERRAL_WELCOME_IMAGE).setTag("onboarding").trackInitiation();
  }
  
  public static ActionAnalytics trackResendPhoneCode()
  {
    return (ActionAnalytics)new ActionAnalytics(ActionEvent.Action.RESEND_PHONE_CODE).setIntentId(ONBOARDING_INTENT.getId()).setTag("onboarding").trackInitiation();
  }
  
  public static ActionAnalytics trackSelectCountry()
  {
    return (ActionAnalytics)new ActionAnalytics(ActionEvent.Action.SELECT_COUNTRY).setIntentId(ONBOARDING_INTENT.getId()).setTag("onboarding").trackInitiation();
  }
  
  public static void trackShowCCChallengeView()
  {
    UxAnalytics.displayed(UiElement.LOGIN_CHALLENGE_VIEW).setTag("onboarding").setParameter("ccLast4").track();
  }
  
  public static void trackShowChallengePopup()
  {
    UxAnalytics.displayed(UiElement.LOGIN_CHALLENGE_POPUP).setTag("onboarding").setParameter("ccLast4").track();
  }
  
  public static void trackShowLicenseChallengeView()
  {
    UxAnalytics.displayed(UiElement.LOGIN_CHALLENGE_VIEW).setTag("onboarding").setParameter("driversLicenseNumber").track();
  }
  
  public static ActionAnalytics trackVerifyPhone()
  {
    return (ActionAnalytics)new ActionAnalytics(ActionEvent.Action.VERIFY_PHONE).setIntentId(ONBOARDING_INTENT.getId()).setTag("onboarding").trackInitiation();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.analytics.studies.OnBoardingAnalytics
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */