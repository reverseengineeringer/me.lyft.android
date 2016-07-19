package me.lyft.android.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;
import com.lyft.scoop.dagger.DaggerInjector;
import javax.inject.Inject;
import me.lyft.android.analytics.core.ExperimentAnalytics;
import me.lyft.android.analytics.core.definitions.Experiment;
import me.lyft.android.analytics.studies.DriverConsoleAnalytics;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.application.ats.IAtsService;
import me.lyft.android.application.features.Features;
import me.lyft.android.application.features.IFeaturesProvider;
import me.lyft.android.application.ride.IDriverRideProvider;
import me.lyft.android.application.ride.IUserDispatchService;
import me.lyft.android.application.ride.IUserUiService;
import me.lyft.android.common.AppFlow;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.common.Unit;
import me.lyft.android.domain.User;
import me.lyft.android.domain.driver.UiState;
import me.lyft.android.domain.driver.ride.DriverRide;
import me.lyft.android.rx.Binder;
import me.lyft.android.ui.driver.DriverDialogs.LastRideConfirmationDialog;
import me.lyft.android.ui.driver.DriverDialogs.LastRideExitDialog;
import me.lyft.android.ui.onboarding.OnboardingScreens.WebApplicationStatusScreen;
import me.lyft.android.ui.ride.IUserModeErrorHandler;
import rx.Observable;

public class DriverModeToggleView
  extends TextView
{
  @Inject
  AppFlow appFlow;
  @Inject
  IAtsService atsService;
  private Binder binder;
  @Inject
  DialogFlow dialogFlow;
  @Inject
  DriverConsoleAnalytics driverConsoleAnalytics;
  @Inject
  IFeaturesProvider featuresProvider;
  @Inject
  IProgressController progressController;
  @Inject
  IDriverRideProvider routeProvider;
  @Inject
  SlideMenuController slideMenuController;
  @Inject
  IUserModeErrorHandler userModeErrorHandler;
  @Inject
  IUserDispatchService userModeService;
  @Inject
  IUserProvider userProvider;
  @Inject
  IUserUiService userService;
  @Inject
  IViewErrorHandler viewErrorHandler;
  
  public DriverModeToggleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
  }
  
  private void goOffline()
  {
    if (routeProvider.getDriverRide().isActive())
    {
      if (userProvider.getUser().isDriverLastRide()) {
        dialogFlow.show(new DriverDialogs.LastRideExitDialog());
      }
      for (;;)
      {
        driverConsoleAnalytics.trackModeToggleTapOfflineFailure("last_ride");
        return;
        dialogFlow.show(new DriverDialogs.LastRideConfirmationDialog());
      }
    }
    progressController.showProgress();
    binder.bind(userModeService.switchToDispatchable(false), new DriverModeToggleView.2(this));
  }
  
  private void goOnline()
  {
    progressController.showProgress();
    binder.bind(userModeService.validateDriverStatusAndSwitchToDispatch(), new DriverModeToggleView.1(this));
  }
  
  private void loadDriverApplication()
  {
    progressController.showProgress();
    binder.bind(atsService.getDriverApplication(), new DriverModeToggleView.4(this));
  }
  
  private void setToolbarUi(int paramInt1, int paramInt2, int paramInt3, Drawable paramDrawable, Typeface paramTypeface)
  {
    setText(getResources().getString(paramInt1));
    setTextColor(getResources().getColor(paramInt2));
    setBackgroundDrawable(getResources().getDrawable(paramInt3));
    setCompoundDrawablesWithIntrinsicBounds(paramDrawable, null, null, null);
    setTypeface(paramTypeface);
  }
  
  private void updateToolbarUi()
  {
    UiState localUiState = userService.getUiState();
    User localUser = userProvider.getUser();
    if ((featuresProvider.isEnabled(Features.DX_MODE_TOGGLE)) && (!localUiState.isDriverUi()))
    {
      ExperimentAnalytics.trackExposure(Experiment.DX_MODE_TOGGLE);
      setToolbarUi(2131165662, 2131493014, 2130837595, null, Typeface.DEFAULT_BOLD);
      return;
    }
    if (!localUiState.isDriverUi())
    {
      ExperimentAnalytics.trackExposure(Experiment.DX_MODE_TOGGLE);
      setToolbarUi(2131165657, 2131492898, 2130837591, getResources().getDrawable(2130838196), Typeface.DEFAULT);
      return;
    }
    if (localUser.isDriverLastRide())
    {
      setToolbarUi(2131165658, 2131493083, 2130837602, null, Typeface.DEFAULT_BOLD);
      return;
    }
    if (localUser.isDispatchable())
    {
      setToolbarUi(2131165660, 2131493083, 2130837609, null, Typeface.DEFAULT_BOLD);
      return;
    }
    setToolbarUi(2131165662, 2131493014, 2130837595, null, Typeface.DEFAULT_BOLD);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (isInEditMode()) {
      return;
    }
    binder = Binder.attach(this);
    binder.bind(Observable.combineLatest(userProvider.observeUserUpdates(), routeProvider.observeRide(), Unit.func2()), new DriverModeToggleView.3(this));
  }
  
  public void onClickControl()
  {
    User localUser = userProvider.getUser();
    UiState localUiState = userService.getUiState();
    if (localUser.isDispatchable())
    {
      driverConsoleAnalytics.trackGoOfflineFromOnline();
      goOffline();
      return;
    }
    if ((localUiState.isDriverUi()) && (localUser.submittedDriverApplication()) && (!localUser.isApprovedDriver()))
    {
      driverConsoleAnalytics.displayApplicantModal();
      loadDriverApplication();
      return;
    }
    if (!localUiState.isDriverUi())
    {
      driverConsoleAnalytics.trackGoOfflineFromToolbarPaxUi();
      appFlow.goTo(new ModeSwitchLoadingScreen());
      return;
    }
    if (!localUser.submittedDriverApplication())
    {
      appFlow.goTo(new OnboardingScreens.WebApplicationStatusScreen());
      return;
    }
    driverConsoleAnalytics.trackGoOnlineFromToolbarDriverUi();
    goOnline();
  }
  
  public void onClickExperiment()
  {
    User localUser = userProvider.getUser();
    UiState localUiState = userService.getUiState();
    if (localUser.isDispatchable())
    {
      driverConsoleAnalytics.trackGoOfflineFromOnline();
      goOffline();
      return;
    }
    if ((localUser.submittedDriverApplication()) && (!localUser.isApprovedDriver()))
    {
      driverConsoleAnalytics.displayApplicantModal();
      loadDriverApplication();
      return;
    }
    if (!localUser.submittedDriverApplication())
    {
      appFlow.goTo(new OnboardingScreens.WebApplicationStatusScreen());
      return;
    }
    if (localUiState.isDriverUi())
    {
      driverConsoleAnalytics.trackGoOnlineFromToolbarDriverUi();
      goOnline();
      return;
    }
    driverConsoleAnalytics.trackGoOnlineFromToolbarPaxUi();
    goOnline();
  }
  
  public boolean performClick()
  {
    if (featuresProvider.isEnabled(Features.DX_MODE_TOGGLE)) {
      onClickExperiment();
    }
    for (;;)
    {
      return true;
      onClickControl();
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.DriverModeToggleView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */