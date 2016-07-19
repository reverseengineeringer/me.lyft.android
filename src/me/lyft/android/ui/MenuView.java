package me.lyft.android.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.lyft.rx.ReactiveUI;
import com.lyft.scoop.RouteChange;
import com.lyft.scoop.Screen;
import com.lyft.scoop.dagger.DaggerInjector;
import java.util.Arrays;
import javax.inject.Inject;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.analytics.core.ExperimentAnalytics;
import me.lyft.android.analytics.core.definitions.Experiment;
import me.lyft.android.analytics.studies.DriverConsoleAnalytics;
import me.lyft.android.analytics.studies.InviteFriendsAnalytics;
import me.lyft.android.analytics.studies.RideHistoryAnalytics;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.application.features.Features;
import me.lyft.android.application.features.IFeaturesProvider;
import me.lyft.android.application.passenger.IPassengerRideProvider;
import me.lyft.android.application.ride.IUserDispatchService;
import me.lyft.android.application.ride.IUserUiService;
import me.lyft.android.application.settings.ISignUrlService;
import me.lyft.android.common.AppFlow;
import me.lyft.android.common.Unit;
import me.lyft.android.development.IDeveloperTools;
import me.lyft.android.domain.User;
import me.lyft.android.domain.User.CarpoolDriverStatus;
import me.lyft.android.domain.driver.UiState;
import me.lyft.android.domain.passenger.ride.PassengerRide;
import me.lyft.android.domain.ride.RideStatus;
import me.lyft.android.flows.ProfileFlow;
import me.lyft.android.managers.ImageLoader;
import me.lyft.android.rx.IRxBinder;
import me.lyft.android.rx.RxUIBinder;
import me.lyft.android.ui.development.DevelopmentScreens.DevelopmentScreen;
import me.lyft.android.ui.help.HelpScreens.HelpScreen;
import me.lyft.android.ui.invites.InvitesScreens.InviteFriendsScreen;
import me.lyft.android.ui.invites.InvitesScreens.InviteScreen;
import me.lyft.android.ui.invites.InvitesScreens.InviteSource;
import me.lyft.android.ui.onboarding.OnboardingScreens.WebApplicationStatusScreen;
import me.lyft.android.ui.payment.PaymentScreens.DebtScreen;
import me.lyft.android.ui.payment.PaymentScreens.PaymentScreen;
import me.lyft.android.ui.ride.IUserModeErrorHandler;
import me.lyft.android.ui.ridehistory.RideHistoryScreens.PassengerRideHistoryListScreen;
import me.lyft.android.ui.ridehistory.RideHistoryScreens.PassengerRideHistoryScreen;
import me.lyft.android.ui.settings.SettingsScreens.DriverVehiclesViewScreen;
import me.lyft.android.ui.settings.SettingsScreens.SettingsScreen;
import me.lyft.android.utils.DrawableUtils;
import me.lyft.android.utils.Keyboard;
import me.lyft.android.utils.WebBrowser;
import rx.functions.Action1;
import rx.subjects.BehaviorSubject;

public class MenuView
  extends LinearLayout
{
  private static final String MODE_SWITCH_BUTTON_COLOR = "#728099";
  private static final String MODE_SWITCH_BUTTON_COLOR_PRESSED = "#606B80";
  @Inject
  AppFlow appFlow;
  private IRxBinder binder = new RxUIBinder();
  Button dashboardNavigationItem;
  @Inject
  IDeveloperTools developerTools;
  RadioButton developmentNavigationItem;
  @Inject
  DriverConsoleAnalytics driverConsoleAnalytics;
  Button driverModeSwitcherView;
  @Inject
  IFeaturesProvider featuresProvider;
  TextView fullNameTextView;
  RadioButton helpNavigationItem;
  RadioButton homeNavigationItem;
  @Inject
  ImageLoader imageLoader;
  RadioButton inviteNavigationItem;
  @Inject
  ILyftPreferences lyftPreferences;
  @Inject
  MainScreensRouter mainScreensRouter;
  RadioGroup menuSelectorRadioGroup;
  private final Action1<Unit> onHomeMenuChanged = new MenuView.4(this);
  private Action1<String> onProfileSubjectChanged = new MenuView.6(this);
  private Action1<RouteChange> onScreenChanged = new MenuView.5(this);
  private final Action1<User> onUserUpdated = new MenuView.3(this);
  @Inject
  IPassengerRideProvider passengerRideProvider;
  RadioButton paymentNavigationItem;
  ImageView photoImageView;
  @Inject
  ProfileFlow profileFlow;
  BehaviorSubject<String> profilePhotoSubject = BehaviorSubject.create();
  @Inject
  IProgressController progressController;
  RadioButton rideHistoryNavigationItem;
  RadioButton settingsNavigationItem;
  @Inject
  ISignUrlService signUrlService;
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
  RadioButton vehicleNavigationItem;
  @Inject
  WebBrowser webBrowser;
  
  public MenuView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
  }
  
  private void openDriverDashboard()
  {
    String str = lyftPreferences.getLyftWebRoot() + "/drive";
    binder.bindAsyncCall(signUrlService.getSignedUrl(str), new MenuView.1(this, str));
  }
  
  private void setDriverModeSwitchDrawable(int paramInt)
  {
    Drawable localDrawable = getContext().getResources().getDrawable(paramInt);
    driverModeSwitcherView.setCompoundDrawablesWithIntrinsicBounds(localDrawable, null, null, null);
  }
  
  private void setDriverModeSwitchText()
  {
    if (!userProvider.getUser().submittedDriverApplication())
    {
      driverModeSwitcherView.setText(getResources().getString(2131165653));
      setDriverModeSwitchDrawable(2130838365);
      return;
    }
    if (userService.getUiState().isDriverUi())
    {
      driverModeSwitcherView.setText(getResources().getString(2131165655));
      setDriverModeSwitchDrawable(2130838368);
      return;
    }
    driverModeSwitcherView.setText(getResources().getString(2131165654));
    setDriverModeSwitchDrawable(2130838368);
  }
  
  private void setDriverModeSwitcherBackground()
  {
    Drawable localDrawable = DrawableUtils.getButtonDrawableForHexColors(getContext(), "#728099", "#606B80", 0.0F);
    driverModeSwitcherView.setBackgroundDrawable(localDrawable);
  }
  
  private boolean shouldHideDriveToggle()
  {
    boolean bool1 = false;
    boolean bool2 = passengerRideProvider.getPassengerRide().getStatus().isActive();
    User localUser = userProvider.getUser();
    int i;
    if (localUser.getCarpoolDriverStatus() != User.CarpoolDriverStatus.NONE)
    {
      i = 1;
      if ((!localUser.isApprovedDriver()) && (!localUser.isDriverDocumentsEnabled())) {
        break label91;
      }
    }
    label91:
    for (int j = 1;; j = 0)
    {
      if ((bool2) || ((j == 0) && (i != 0)) || (localUser.isDispatchable())) {
        bool1 = true;
      }
      return bool1;
      i = 0;
      break;
    }
  }
  
  private boolean shouldShowDriverMenu()
  {
    return userService.getUiState().isDriverUi();
  }
  
  private void switchToDriverMode()
  {
    progressController.showProgress();
    binder.bindAsyncCall(userModeService.validateDriverStatusAndSwitchToDispatch(), new MenuView.2(this));
  }
  
  private void switchUserMode()
  {
    if (!userProvider.getUser().submittedDriverApplication())
    {
      appFlow.goTo(new OnboardingScreens.WebApplicationStatusScreen());
      return;
    }
    if (userService.getUiState().isDriverUi())
    {
      driverConsoleAnalytics.trackGoPaxUiFromSideMenuDriverUi();
      appFlow.goTo(new ModeSwitchLoadingScreen());
      return;
    }
    ExperimentAnalytics.trackExposure(Experiment.DX_MODE_TOGGLE);
    if (featuresProvider.isEnabled(Features.DX_MODE_TOGGLE))
    {
      driverConsoleAnalytics.trackGoOnlineFromMenuPaxUi();
      switchToDriverMode();
      return;
    }
    driverConsoleAnalytics.trackGoOfflineFromMainSideMenuPaxUi();
    appFlow.goTo(new ModeSwitchLoadingScreen());
  }
  
  private void updateHomeMenuTitle(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (String str1 = getContext().getString(2131165773); developerTools.isDeveloperMode(); str1 = getContext().getString(2131165772))
    {
      String str2 = lyftPreferences.getEnvironmentName();
      homeNavigationItem.setText(str1 + " — " + str2.toUpperCase());
      developmentNavigationItem.setVisibility(0);
      return;
    }
    homeNavigationItem.setText(str1);
    developmentNavigationItem.setVisibility(8);
  }
  
  private void updateMenuItems()
  {
    int j = 0;
    Object localObject = driverModeSwitcherView;
    if (shouldHideDriveToggle())
    {
      i = 8;
      ((Button)localObject).setVisibility(i);
      localObject = rideHistoryNavigationItem;
      if (!shouldShowDriverMenu()) {
        break label126;
      }
      i = 8;
      label37:
      ((RadioButton)localObject).setVisibility(i);
      localObject = inviteNavigationItem;
      if (!shouldShowDriverMenu()) {
        break label131;
      }
      i = 8;
      label57:
      ((RadioButton)localObject).setVisibility(i);
      localObject = paymentNavigationItem;
      if (!shouldShowDriverMenu()) {
        break label136;
      }
      i = 8;
      label77:
      ((RadioButton)localObject).setVisibility(i);
      localObject = vehicleNavigationItem;
      if (!shouldShowDriverMenu()) {
        break label141;
      }
      i = 0;
      label96:
      ((RadioButton)localObject).setVisibility(i);
      localObject = dashboardNavigationItem;
      if (!shouldShowDriverMenu()) {
        break label147;
      }
    }
    label126:
    label131:
    label136:
    label141:
    label147:
    for (int i = j;; i = 8)
    {
      ((Button)localObject).setVisibility(i);
      return;
      i = 0;
      break;
      i = 0;
      break label37;
      i = 0;
      break label57;
      i = 0;
      break label77;
      i = 8;
      break label96;
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (isInEditMode()) {
      return;
    }
    binder.attach();
    binder.bindAction(userProvider.observeUserUpdates(), onUserUpdated);
    binder.bindAction(ReactiveUI.any(passengerRideProvider.observeRideUpdateEvent(), developerTools.observeDeveloperMode(), userService.observeUiState()), onHomeMenuChanged);
    binder.bindAction(appFlow.observeRouteChange(), onScreenChanged);
    binder.bindAction(profilePhotoSubject.distinctUntilChanged(), onProfileSubjectChanged);
    setDriverModeSwitcherBackground();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    binder.detach();
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    if (isInEditMode()) {
      return;
    }
    ButterKnife.bind(this);
  }
  
  void onMenuItemSelected(View paramView)
  {
    slideMenuController.close();
    Keyboard.hideKeyboard(paramView);
    int i = paramView.getId();
    paramView = mainScreensRouter.getHomeScreen();
    switch (i)
    {
    case 2131559304: 
    case 2131559305: 
    case 2131559306: 
    case 2131559307: 
    default: 
      return;
    case 2131559317: 
      switchUserMode();
      return;
    case 2131559303: 
      profileFlow.openMyProfile();
      menuSelectorRadioGroup.check(0);
      return;
    case 2131559308: 
      appFlow.resetTo(paramView);
      return;
    case 2131559311: 
      if (userProvider.getUser().isApprovedDriver())
      {
        InviteFriendsAnalytics.tapReferFriendsSidebar();
        appFlow.goTo(new InvitesScreens.InviteFriendsScreen(InvitesScreens.InviteSource.SIDE_MENU));
        return;
      }
      appFlow.goTo(new InvitesScreens.InviteScreen(InvitesScreens.InviteSource.SIDE_MENU));
      return;
    case 2131559312: 
      RideHistoryAnalytics.trackRideHistorySidebarTap();
      ExperimentAnalytics.trackExposure(Experiment.EN_SHOW_BUSINESS_RIDE_HISTORY);
      if (featuresProvider.isEnabled(Features.SHOW_BUSINESS_RIDE_HISTORY))
      {
        appFlow.goTo(new RideHistoryScreens.PassengerRideHistoryScreen());
        return;
      }
      appFlow.goTo(new RideHistoryScreens.PassengerRideHistoryListScreen());
      return;
    case 2131559313: 
      if (userProvider.getUser().hasDebt())
      {
        appFlow.replaceAllWith(Arrays.asList(new Screen[] { paramView, new PaymentScreens.DebtScreen() }));
        return;
      }
      appFlow.replaceAllWith(Arrays.asList(new Screen[] { paramView, new PaymentScreens.PaymentScreen() }));
      return;
    case 2131559314: 
      appFlow.replaceAllWith(Arrays.asList(new Screen[] { paramView, new HelpScreens.HelpScreen() }));
      return;
    case 2131559315: 
      appFlow.replaceAllWith(Arrays.asList(new Screen[] { paramView, new SettingsScreens.SettingsScreen() }));
      return;
    case 2131559316: 
      appFlow.goTo(new DevelopmentScreens.DevelopmentScreen());
      return;
    case 2131559309: 
      openDriverDashboard();
      return;
    }
    appFlow.goTo(new SettingsScreens.DriverVehiclesViewScreen());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.MenuView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */