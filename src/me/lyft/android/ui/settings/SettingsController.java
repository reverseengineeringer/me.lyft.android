package me.lyft.android.ui.settings;

import android.content.res.Resources;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.lyft.rx.MessageBus;
import com.lyft.scoop.Screen;
import com.lyft.widgets.Toggle;
import com.squareup.picasso.RequestCreator;
import javax.inject.Inject;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.analytics.studies.CarpoolOnboardingAnalytics;
import me.lyft.android.application.ILogoutService;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.application.business.BusinessOnboardingAnalytics;
import me.lyft.android.application.enterprise.IEnterpriseService;
import me.lyft.android.application.features.Features;
import me.lyft.android.application.features.IFeaturesProvider;
import me.lyft.android.application.passenger.IPassengerRideProvider;
import me.lyft.android.application.profile.IProfileService;
import me.lyft.android.application.ride.IUserUiService;
import me.lyft.android.application.settings.ISettingsService;
import me.lyft.android.common.AppFlow;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.common.RxViewController;
import me.lyft.android.common.Strings;
import me.lyft.android.controls.InternationalTextFormatter;
import me.lyft.android.controls.MenuButtonToolbar;
import me.lyft.android.controls.Toolbar;
import me.lyft.android.domain.Phone;
import me.lyft.android.domain.User;
import me.lyft.android.domain.driver.UiState;
import me.lyft.android.domain.passenger.ride.PassengerRide;
import me.lyft.android.domain.profile.Profile;
import me.lyft.android.domain.ride.RideStatus;
import me.lyft.android.managers.ImageLoader;
import me.lyft.android.navigation.NavigationSettings;
import me.lyft.android.rx.RxUIBinder;
import me.lyft.android.ui.Dialogs.AlertDialog;
import me.lyft.android.ui.IProgressController;
import me.lyft.android.ui.IViewErrorHandler;
import me.lyft.android.ui.SlideMenuController;
import me.lyft.android.ui.business.BusinessProfileScreens.BusinessOnboardNewUserScreen;
import me.lyft.android.ui.business.BusinessProfileScreens.BusinessOnboardWorkEmailInputScreen;
import me.lyft.android.ui.business.BusinessProfileScreens.BusinessProfileScreen;
import me.lyft.android.ui.dialogs.DialogResult;
import me.lyft.android.ui.onboarding.CarpoolDriverOnboardingRouter;
import me.lyft.android.ui.onboarding.OnboardingScreens.WebApplicationStatusScreen;
import me.lyft.android.ui.profile.ProfileScreens.EditProfileScreen;
import me.lyft.android.utils.WebBrowser;
import rx.functions.Action1;

public class SettingsController
  extends RxViewController
{
  private static final String LOGOUT_DIALOG_TAG = "logout_confirmation_dialog";
  @Inject
  AppFlow appFlow;
  View becomeCarpoolDriverButton;
  View becomeCarpoolDriverSplitter;
  Button becomeDriverButton;
  View becomeDriverSplitter;
  @Inject
  MessageBus bus;
  @Inject
  BusinessOnboardingAnalytics businessOnboardingAnalytics;
  LinearLayout businessProfileButton;
  View businessProfileOnboardSubTextView;
  Button carpoolDriverDashboardButton;
  @Inject
  CarpoolDriverOnboardingRouter carpoolDriverOnboardingRouter;
  Toggle carpoolDriverSwitch;
  View carpoolDriverSwitchLayout;
  @Inject
  DialogFlow dialogFlow;
  View driverShortcutSwitcherView;
  Toggle driverShortcutToggle;
  TextView emailTxt;
  @Inject
  IEnterpriseService enterpriseService;
  @Inject
  IFeaturesProvider featuresProvider;
  @Inject
  ImageLoader imageLoader;
  View logoutButton;
  @Inject
  ILogoutService logoutService;
  View logoutSplitter;
  @Inject
  ILyftPreferences lyftPreferences;
  @Inject
  NavigationSettings navigationSettings;
  View navigationSettingsView;
  private Action1<Boolean> onCarpoolDriverToggled = new SettingsController.3(this);
  private Action1<Boolean> onDriverShortcutSettingChanged = new SettingsController.1(this);
  private Action1<DialogResult> onLogoutDialogResult = new SettingsController.2(this);
  private SettingsScreens.SettingsScreen params;
  @Inject
  IPassengerRideProvider passengerRideProvider;
  TextView phoneText;
  ImageView profileImageView;
  @Inject
  IProfileService profileService;
  @Inject
  IProgressController progressController;
  TextView selectedNavigationTxt;
  TextView serviceIndicatorTextView;
  View servicesSettingsView;
  View servicesSplitter;
  @Inject
  ISettingsService settingsService;
  @Inject
  SlideMenuController slideMenuController;
  MenuButtonToolbar toolbar;
  TextView userJoinDateTextView;
  TextView userNameTextView;
  @Inject
  IUserProvider userProvider;
  @Inject
  IUserUiService userUiService;
  @Inject
  IViewErrorHandler viewErrorHandler;
  @Inject
  WebBrowser webBrowser;
  
  private void initData()
  {
    int j = 8;
    User localUser = userProvider.getUser();
    label51:
    label164:
    boolean bool;
    Object localObject;
    if (localUser.isWheelchairNeeded())
    {
      serviceIndicatorTextView.setText(2131166186);
      if (!Strings.isNullOrEmpty(localUser.getEmail())) {
        break label296;
      }
      emailTxt.setVisibility(8);
      if (!Strings.isNullOrEmpty(localUser.getPhone().getNumber())) {
        break label319;
      }
      phoneText.setVisibility(8);
      if (Strings.isNullOrEmpty(localUser.getFacebookUid()))
      {
        phoneText.setEnabled(false);
        phoneText.setTextColor(getResources().getColor(2131492984));
      }
      if (!localUser.isApprovedDriver()) {
        break label392;
      }
      becomeDriverButton.setVisibility(8);
      becomeCarpoolDriverButton.setVisibility(8);
      navigationSettingsView.setVisibility(0);
      driverShortcutToggle.setChecked(lyftPreferences.isDriverShortcutEnabled(), false);
      setDefaultNavigationLabel();
      bool = passengerRideProvider.getPassengerRide().getStatus().isActive();
      localObject = logoutSplitter;
      if (!bool) {
        break label634;
      }
      i = 8;
      label193:
      ((View)localObject).setVisibility(i);
      localObject = logoutButton;
      if (!bool) {
        break label639;
      }
      i = 8;
      label212:
      ((View)localObject).setVisibility(i);
      if (userUiService.getUiState().isDriverUi())
      {
        businessProfileButton.setVisibility(8);
        servicesSettingsView.setVisibility(8);
        servicesSplitter.setVisibility(8);
      }
      localObject = businessProfileOnboardSubTextView;
      if (!localUser.hasBusinessProfile()) {
        break label644;
      }
    }
    label296:
    label319:
    label392:
    label571:
    label628:
    label634:
    label639:
    label644:
    for (int i = j;; i = 0)
    {
      ((View)localObject).setVisibility(i);
      return;
      serviceIndicatorTextView.setText("");
      break;
      emailTxt.setText(localUser.getEmail());
      emailTxt.setVisibility(0);
      break label51;
      localObject = phoneText;
      if (!Strings.isNullOrEmpty(localUser.getPhone().getNumber())) {}
      for (bool = true;; bool = false)
      {
        ((TextView)localObject).setEnabled(bool);
        phoneText.addTextChangedListener(new InternationalTextFormatter());
        phoneText.setText(localUser.getPhone().getNumber());
        phoneText.setVisibility(0);
        break;
      }
      if (localUser.isApprovedCarpoolDriver())
      {
        becomeDriverButton.setVisibility(8);
        navigationSettingsView.setVisibility(0);
        becomeCarpoolDriverButton.setVisibility(8);
        driverShortcutSwitcherView.setVisibility(8);
        carpoolDriverSwitchLayout.setVisibility(0);
        carpoolDriverSwitch.setChecked(localUser.isCarpoolDriverDispatchEnabled(), false);
        carpoolDriverDashboardButton.setVisibility(0);
        setDefaultNavigationLabel();
        break label164;
      }
      if (passengerRideProvider.getPassengerRide().getStatus().isActive())
      {
        becomeDriverSplitter.setVisibility(8);
        becomeDriverButton.setVisibility(8);
        becomeCarpoolDriverButton.setVisibility(8);
        servicesSettingsView.setVisibility(8);
        navigationSettingsView.setVisibility(8);
        driverShortcutSwitcherView.setVisibility(8);
        break label164;
      }
      bool = featuresProvider.isEnabled(Features.CARPOOL_DRIVER_SIGNUP_ENABLED);
      localObject = becomeCarpoolDriverButton;
      if (bool)
      {
        i = 0;
        ((View)localObject).setVisibility(i);
        localObject = becomeCarpoolDriverSplitter;
        if (!bool) {
          break label628;
        }
      }
      for (i = 0;; i = 8)
      {
        ((View)localObject).setVisibility(i);
        becomeDriverSplitter.setVisibility(0);
        becomeDriverButton.setVisibility(0);
        servicesSettingsView.setVisibility(0);
        break;
        i = 8;
        break label571;
      }
      i = 0;
      break label193;
      i = 0;
      break label212;
    }
  }
  
  private void setDefaultNavigationLabel()
  {
    int i = navigationSettings.getDefaultNavigation();
    TextView localTextView = selectedNavigationTxt;
    if (i == 1) {}
    for (i = 2131165924;; i = 2131165923)
    {
      localTextView.setText(i);
      return;
    }
  }
  
  protected int layoutId()
  {
    return 2130903448;
  }
  
  public void onAttach()
  {
    super.onAttach();
    params = ((SettingsScreens.SettingsScreen)Screen.fromController(this));
    toolbar.showTitle().setTitle(getResources().getString(2131166304));
    Profile localProfile = profileService.getMyProfile();
    imageLoader.load(localProfile.getPhotoUrl()).fit().centerCrop().placeholder(2130838447).into(profileImageView);
    userJoinDateTextView.setText(localProfile.getJoinDate());
    userNameTextView.setText(localProfile.getFirstName());
    initData();
    binder.bindAction(driverShortcutToggle.observeChange(), onDriverShortcutSettingChanged);
    binder.bindAction(bus.observe(SettingsController.LogoutDialogResultEvent.class), onLogoutDialogResult);
    binder.bindAction(carpoolDriverSwitch.observeChange(), onCarpoolDriverToggled);
    slideMenuController.enableMenu();
  }
  
  public void onBecomeCarpoolDriverClicked()
  {
    CarpoolOnboardingAnalytics.trackSignupTappedFromSettings();
    carpoolDriverOnboardingRouter.goToNextOnboardingScreen();
  }
  
  public void onBecomeDriverClicked()
  {
    appFlow.goTo(new OnboardingScreens.WebApplicationStatusScreen());
  }
  
  public void onBusinessProfileOnboardClicked()
  {
    businessOnboardingAnalytics.initializeShowOnBoarding();
    boolean bool = userProvider.getUser().hasBusinessProfile();
    businessOnboardingAnalytics.showOnboardingSuccess(bool);
    if (bool)
    {
      appFlow.goTo(new BusinessProfileScreens.BusinessProfileScreen());
      return;
    }
    if (!enterpriseService.isNewUserDescriptionShown())
    {
      appFlow.goTo(new BusinessProfileScreens.BusinessOnboardNewUserScreen());
      return;
    }
    appFlow.goTo(new BusinessProfileScreens.BusinessOnboardWorkEmailInputScreen());
  }
  
  public void onCarpoolDriverDashboardClicked()
  {
    carpoolDriverDashboardButton.setEnabled(false);
    String str = lyftPreferences.getLyftWebRoot() + "/drive";
    webBrowser.signAndOpenUrl(str);
  }
  
  public void onDetach()
  {
    super.onDetach();
    slideMenuController.disableMenu();
  }
  
  public void onEditProfileClicked()
  {
    appFlow.goTo(new ProfileScreens.EditProfileScreen());
  }
  
  public void onEmailClicked()
  {
    appFlow.goTo(new SettingsScreens.EditEmailScreen());
  }
  
  public void onLogoutClicked()
  {
    Dialogs.AlertDialog localAlertDialog = new Dialogs.AlertDialog("logout_confirmation_dialog");
    localAlertDialog.setDialogEventClass(SettingsController.LogoutDialogResultEvent.class).setTitle(getResources().getString(2131166179)).addNegativeButton(getResources().getString(2131165935)).addPositiveButton(getResources().getString(2131166433));
    dialogFlow.show(localAlertDialog);
  }
  
  public void onNavigationSettingsClicked()
  {
    appFlow.goTo(new SettingsScreens.NavigationSettingsScreen());
  }
  
  public void onPhoneClicked()
  {
    appFlow.goTo(new SettingsScreens.EditPhoneScreen());
  }
  
  public void onServiceSettingsClicked()
  {
    appFlow.goTo(new SettingsScreens.AccessibilitySettingsScreen());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.settings.SettingsController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */