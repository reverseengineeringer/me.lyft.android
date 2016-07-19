package me.lyft.android.application.business;

import me.lyft.android.analytics.core.ActionAnalytics;
import me.lyft.android.analytics.core.SpanningAnalytics;
import me.lyft.android.analytics.core.events.ActionEvent.Action;

public class BusinessOnboardingAnalytics
{
  private ActionAnalytics addWorkEmailNext = new ActionAnalytics(ActionEvent.Action.BUSINESS_PROFILE_ADD_WORK_EMAIL);
  private ActionAnalytics getStarted = new ActionAnalytics(ActionEvent.Action.BUSINESS_PROFILE_GET_STARTED);
  private ActionAnalytics setPaymentNext = new ActionAnalytics(ActionEvent.Action.BUSINESS_PROFILE_SET_DEFAULT_PAYMENT);
  private ActionAnalytics showOnBoarding = new ActionAnalytics(ActionEvent.Action.BUSINESS_PROFILE_SHOW);
  
  public void initializeAddWorkEmail()
  {
    addWorkEmailNext.trackInitiation();
  }
  
  public void initializeGetStarted()
  {
    getStarted.trackInitiation();
  }
  
  public void initializeShowOnBoarding()
  {
    showOnBoarding.trackInitiation();
  }
  
  public void showOnboardingSuccess(boolean paramBoolean)
  {
    showOnBoarding.setParameter(String.valueOf(paramBoolean)).trackSuccess();
  }
  
  public void trackAddWorkEmailFailure()
  {
    addWorkEmailNext.trackFailure();
  }
  
  public void trackAddWorkEmailFailure(Throwable paramThrowable)
  {
    addWorkEmailNext.trackFailure(paramThrowable);
  }
  
  public void trackAddWorkEmailSuccess()
  {
    addWorkEmailNext.trackSuccess();
  }
  
  public void trackGetStartedFailure(Throwable paramThrowable)
  {
    getStarted.trackFailure(paramThrowable);
  }
  
  public void trackGetStartedSuccess()
  {
    getStarted.trackSuccess();
  }
  
  public void trackPaymentSuccess()
  {
    setPaymentNext.trackInitiation().trackSuccess();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.business.BusinessOnboardingAnalytics
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */