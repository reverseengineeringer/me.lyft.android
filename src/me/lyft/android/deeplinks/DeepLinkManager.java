package me.lyft.android.deeplinks;

import com.lyft.scoop.Screen;
import java.util.Arrays;
import java.util.Collections;
import me.lyft.android.analytics.core.ActionAnalytics;
import me.lyft.android.analytics.studies.AppAnalytics;
import me.lyft.android.analytics.studies.InviteFriendsAnalytics;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.application.enterprise.IEnterpriseService;
import me.lyft.android.application.features.IFeaturesProvider;
import me.lyft.android.application.ride.IUserUiService;
import me.lyft.android.common.AppFlow;
import me.lyft.android.common.Objects;
import me.lyft.android.common.Strings;
import me.lyft.android.domain.User;
import me.lyft.android.domain.driver.UiState;
import me.lyft.android.domain.location.DeepLinkMapper;
import me.lyft.android.domain.location.Location;
import me.lyft.android.flows.ProfileFlow;
import me.lyft.android.jobs.ConfigureProxyJob;
import me.lyft.android.jobs.JobManager;
import me.lyft.android.jobs.LoadAppInfoJob;
import me.lyft.android.jobs.RideRequestSessionUpdateJob;
import me.lyft.android.ui.MainScreens.DriverRideScreen;
import me.lyft.android.ui.MainScreens.PassengerRideScreen;
import me.lyft.android.ui.MainScreensRouter;
import me.lyft.android.ui.business.BusinessProfileScreens.BusinessOnboardCompletionScreen;
import me.lyft.android.ui.business.BusinessProfileScreens.BusinessOnboardNewUserScreen;
import me.lyft.android.ui.business.BusinessProfileScreens.BusinessOnboardWorkEmailInputScreen;
import me.lyft.android.ui.business.BusinessProfileScreens.BusinessProfileScreen;
import me.lyft.android.ui.driver.DriverScreens.DriverStatsScreen;
import me.lyft.android.ui.driver.ridescreens.tabs.DriverEarningsScreen;
import me.lyft.android.ui.driver.ridescreens.tabs.DriverReferralScreen;
import me.lyft.android.ui.help.HelpScreens.HelpScreen;
import me.lyft.android.ui.invites.InvitesScreens.InviteFriendsScreen;
import me.lyft.android.ui.invites.InvitesScreens.InviteScreen;
import me.lyft.android.ui.invites.InvitesScreens.InviteSource;
import me.lyft.android.ui.onboarding.CarpoolDriverOnboardingRouter;
import me.lyft.android.ui.onboarding.CarpoolDriverOnboardingRouter.DeepLinkStep;
import me.lyft.android.ui.payment.PaymentScreens.ConcurSendRideReceiptsScreen;
import me.lyft.android.ui.payment.PaymentScreens.PaymentScreen;
import me.lyft.android.ui.profile.ProfileScreens.EditProfileScreen;
import me.lyft.android.ui.settings.SettingsScreens.CarScreen;
import me.lyft.android.ui.settings.SettingsScreens.SettingsScreen;
import me.lyft.android.ui.settings.SettingsScreens.TrainingRideStartScreen;
import me.lyft.android.ui.splitfare.SplitScreens.InviteToSplitScreen;

public class DeepLinkManager
{
  private final AppFlow appFlow;
  private final CarpoolDriverOnboardingRouter carpoolDriverOnboardingRouter;
  private ActionAnalytics deepLinkAnalytics;
  private final IEnterpriseService enterpriseService;
  private final IFeaturesProvider featuresProvider;
  private final JobManager jobManager;
  private final MainScreensRouter mainScreensRouter;
  private DeepLink pendingDeepLink;
  private final ProfileFlow profileFlow;
  private final IUserProvider userProvider;
  private final IUserUiService userUiService;
  
  public DeepLinkManager(AppFlow paramAppFlow, JobManager paramJobManager, ProfileFlow paramProfileFlow, MainScreensRouter paramMainScreensRouter, IFeaturesProvider paramIFeaturesProvider, IUserProvider paramIUserProvider, CarpoolDriverOnboardingRouter paramCarpoolDriverOnboardingRouter, IEnterpriseService paramIEnterpriseService, IUserUiService paramIUserUiService)
  {
    appFlow = paramAppFlow;
    jobManager = paramJobManager;
    profileFlow = paramProfileFlow;
    mainScreensRouter = paramMainScreensRouter;
    featuresProvider = paramIFeaturesProvider;
    userProvider = paramIUserProvider;
    carpoolDriverOnboardingRouter = paramCarpoolDriverOnboardingRouter;
    enterpriseService = paramIEnterpriseService;
    userUiService = paramIUserUiService;
  }
  
  private void handleRideTypesDeeplink(DeepLink paramDeepLink)
  {
    if (userProvider.getUser().isDispatchable()) {
      return;
    }
    userUiService.updateUiState(new UiState(false));
    String str = paramDeepLink.getParam("id");
    Location localLocation = DeepLinkMapper.toDomainLocation(paramDeepLink.getParam("pickup[latitude]"), paramDeepLink.getParam("pickup[longitude]"));
    paramDeepLink = DeepLinkMapper.toDomainLocation(paramDeepLink.getParam("destination[latitude]"), paramDeepLink.getParam("destination[longitude]"));
    jobManager.queueBackgroundJob(new RideRequestSessionUpdateJob(localLocation, paramDeepLink, str));
  }
  
  private static boolean isSupportedDeepLink(DeepLink paramDeepLink)
  {
    paramDeepLink = paramDeepLink.getAction();
    return (paramDeepLink != null) && ((Strings.equalsIgnoreCase(paramDeepLink, "payment")) || (Strings.equalsIgnoreCase(paramDeepLink, "concur")) || (Strings.equalsIgnoreCase(paramDeepLink, "help")) || (Strings.equalsIgnoreCase(paramDeepLink, "drivemode")) || (Strings.equalsIgnoreCase(paramDeepLink, "profile")) || (Strings.equalsIgnoreCase(paramDeepLink, "editprofile")) || (Strings.equalsIgnoreCase(paramDeepLink, "settings")) || (Strings.equalsIgnoreCase(paramDeepLink, "drive")) || (Strings.equalsIgnoreCase(paramDeepLink, "referral")) || (Strings.equalsIgnoreCase(paramDeepLink, "workperks")) || (Strings.equalsIgnoreCase(paramDeepLink, "business")) || (Strings.equalsIgnoreCase(paramDeepLink, "ridetype")) || (Strings.equalsIgnoreCase(paramDeepLink, "proxy")) || (Strings.equalsIgnoreCase(paramDeepLink, "note")) || (Strings.equalsIgnoreCase(paramDeepLink, "driver_stats")) || (paramDeepLink.startsWith("app-walkthrough")) || (Strings.equalsIgnoreCase(paramDeepLink, "ride_screen")) || (Strings.equalsIgnoreCase(paramDeepLink, "split_payment")) || (Strings.equalsIgnoreCase(paramDeepLink, "carpooldriveronboarding")));
  }
  
  private boolean route(DeepLink paramDeepLink)
  {
    String str = paramDeepLink.getAction();
    if (str == null) {
      return false;
    }
    Screen localScreen = mainScreensRouter.getHomeScreen();
    if (Strings.equalsIgnoreCase(str, "payment"))
    {
      paramDeepLink = paramDeepLink.getParam("credits");
      if (Strings.isNullOrEmpty(paramDeepLink)) {
        appFlow.replaceAllWith(Arrays.asList(new Screen[] { localScreen, new PaymentScreens.PaymentScreen() }));
      }
      for (;;)
      {
        return true;
        appFlow.replaceAllWith(Arrays.asList(new Screen[] { localScreen, new PaymentScreens.PaymentScreen(paramDeepLink) }));
      }
    }
    if (Strings.equalsIgnoreCase(str, "concur"))
    {
      str = paramDeepLink.getParam("enabled");
      AppFlow localAppFlow = appFlow;
      SettingsScreens.SettingsScreen localSettingsScreen = new SettingsScreens.SettingsScreen();
      if (userProvider.getUser().hasBusinessProfile()) {}
      for (paramDeepLink = new BusinessProfileScreens.BusinessProfileScreen();; paramDeepLink = new PaymentScreens.PaymentScreen())
      {
        localAppFlow.replaceAllWith(Arrays.asList(new Screen[] { localScreen, localSettingsScreen, paramDeepLink, new PaymentScreens.ConcurSendRideReceiptsScreen(Boolean.parseBoolean(str)) }));
        return true;
      }
    }
    if (Strings.equalsIgnoreCase(str, "help"))
    {
      appFlow.replaceAllWith(Arrays.asList(new Screen[] { localScreen, new HelpScreens.HelpScreen() }));
      return true;
    }
    if (Strings.equalsIgnoreCase(str, "profile"))
    {
      profileFlow.openMyProfile();
      return true;
    }
    if (Strings.equalsIgnoreCase(str, "editprofile"))
    {
      appFlow.replaceAllWith(Arrays.asList(new Screen[] { localScreen, new ProfileScreens.EditProfileScreen() }));
      return true;
    }
    if (Strings.equalsIgnoreCase(str, "settings"))
    {
      appFlow.replaceAllWith(Arrays.asList(new Screen[] { localScreen, new SettingsScreens.SettingsScreen() }));
      return true;
    }
    if (Strings.equalsIgnoreCase(str, "referral"))
    {
      if (userUiService.getUiState().isDriverUi()) {
        routeDriverInviteScreen(localScreen);
      }
      for (;;)
      {
        return true;
        routePassengerInviteScreen(localScreen);
      }
    }
    if ((Strings.equalsIgnoreCase(str, "workperks")) || (Strings.equalsIgnoreCase(str, "business")))
    {
      if (Boolean.valueOf(paramDeepLink.getParam("completed")).booleanValue()) {
        paramDeepLink = new BusinessProfileScreens.BusinessOnboardCompletionScreen();
      }
      for (;;)
      {
        appFlow.replaceAllWith(Arrays.asList(new Screen[] { localScreen, paramDeepLink }));
        return true;
        if (userProvider.getUser().hasBusinessProfile()) {
          paramDeepLink = new BusinessProfileScreens.BusinessProfileScreen();
        } else if (!enterpriseService.isNewUserDescriptionShown()) {
          paramDeepLink = new BusinessProfileScreens.BusinessOnboardNewUserScreen();
        } else {
          paramDeepLink = new BusinessProfileScreens.BusinessOnboardWorkEmailInputScreen();
        }
      }
    }
    if (Strings.equalsIgnoreCase(str, "ridetype"))
    {
      handleRideTypesDeeplink(paramDeepLink);
      return true;
    }
    if (Strings.equalsIgnoreCase(str, "note"))
    {
      paramDeepLink = paramDeepLink.getParam("url");
      if (userUiService.getUiState().isDriverUi()) {
        appFlow.replaceAllWith(Collections.singletonList(new MainScreens.DriverRideScreen().setWebDialogUrl(paramDeepLink)));
      }
      for (;;)
      {
        return true;
        appFlow.replaceAllWith(Collections.singletonList(new MainScreens.PassengerRideScreen().setWebDialogUrl(paramDeepLink)));
      }
    }
    if (Strings.equalsIgnoreCase(str, "proxy"))
    {
      appFlow.replaceAllWith(Collections.singletonList(localScreen));
      jobManager.queueImmediateJob(new ConfigureProxyJob(paramDeepLink.getParam("ip")));
      return false;
    }
    if ((Strings.equalsIgnoreCase(str, "drivemode")) || (Strings.equalsIgnoreCase(str, "drive")))
    {
      userUiService.updateUiState(new UiState(true));
      paramDeepLink = new MainScreens.DriverRideScreen();
      paramDeepLink.enableGoOnline();
      appFlow.replaceAllWith(Collections.singletonList(paramDeepLink));
      return true;
    }
    if ((Strings.equalsIgnoreCase(str, "offlinemode")) || (Strings.equalsIgnoreCase(str, "drive")))
    {
      if (userProvider.getUser().submittedDriverApplication())
      {
        userUiService.updateUiState(new UiState(true));
        appFlow.replaceAllWith(new Screen[] { new MainScreens.DriverRideScreen() });
        return true;
      }
      return false;
    }
    if (Strings.equalsIgnoreCase(str, "vehicles"))
    {
      if (userProvider.getUser().submittedDriverApplication())
      {
        paramDeepLink = paramDeepLink.getParam("id");
        appFlow.replaceAllWith(new Screen[] { localScreen, new SettingsScreens.CarScreen(paramDeepLink) });
        return true;
      }
      return false;
    }
    if (Strings.equalsIgnoreCase(str, "driver_stats"))
    {
      if (userProvider.getUser().isDispatchable()) {
        appFlow.replaceAllWith(Arrays.asList(new Screen[] { localScreen, new DriverScreens.DriverStatsScreen() }));
      }
      for (;;)
      {
        return true;
        if (userProvider.getUser().isApprovedDriver())
        {
          userUiService.updateUiState(new UiState(true));
          appFlow.replaceAllWith(new Screen[] { new DriverEarningsScreen() });
        }
      }
    }
    if (str.startsWith("app-walkthrough"))
    {
      appFlow.replaceAllWith(Arrays.asList(new Screen[] { localScreen, new SettingsScreens.TrainingRideStartScreen() }));
      return true;
    }
    if (Strings.equalsIgnoreCase(str, "ride_screen"))
    {
      appFlow.replaceAllWith(Collections.singletonList(localScreen));
      return true;
    }
    if (Strings.equalsIgnoreCase(str, "split_payment"))
    {
      appFlow.replaceAllWith(Arrays.asList(new Screen[] { localScreen, new SplitScreens.InviteToSplitScreen() }));
      return true;
    }
    if (Strings.equalsIgnoreCase(str, "carpooldriveronboarding"))
    {
      paramDeepLink = paramDeepLink.getParam("step");
      if (Objects.equals(paramDeepLink, "enableLocations")) {
        carpoolDriverOnboardingRouter.goToOnboardingScreen(CarpoolDriverOnboardingRouter.DeepLinkStep.ENABLE_LOCATION);
      }
      for (;;)
      {
        return true;
        if (Objects.equals(paramDeepLink, "inAppOnboarding")) {
          carpoolDriverOnboardingRouter.goToOnboardingScreen(CarpoolDriverOnboardingRouter.DeepLinkStep.IN_APP_ONBOARDING);
        } else {
          carpoolDriverOnboardingRouter.goToOnboardingScreen(CarpoolDriverOnboardingRouter.DeepLinkStep.NONE);
        }
      }
    }
    return false;
  }
  
  private void routeDriverInviteScreen(Screen paramScreen)
  {
    if (!userProvider.getUser().isDispatchable())
    {
      appFlow.replaceAllWith(new Screen[] { new DriverReferralScreen() });
      return;
    }
    if (userProvider.getUser().isApprovedDriver())
    {
      InviteFriendsAnalytics.tapReferFriendsDeepLink();
      appFlow.replaceAllWith(Arrays.asList(new Screen[] { paramScreen, new InvitesScreens.InviteFriendsScreen(InvitesScreens.InviteSource.DEEP_LINK) }));
      return;
    }
    appFlow.replaceAllWith(Arrays.asList(new Screen[] { paramScreen, new InvitesScreens.InviteScreen(InvitesScreens.InviteSource.DEEP_LINK) }));
  }
  
  private void routePassengerInviteScreen(Screen paramScreen)
  {
    if (userProvider.getUser().isApprovedDriver())
    {
      InviteFriendsAnalytics.tapReferFriendsDeepLink();
      appFlow.replaceAllWith(Arrays.asList(new Screen[] { paramScreen, new InvitesScreens.InviteFriendsScreen(InvitesScreens.InviteSource.DEEP_LINK) }));
      return;
    }
    appFlow.replaceAllWith(Arrays.asList(new Screen[] { paramScreen, new InvitesScreens.InviteScreen(InvitesScreens.InviteSource.DEEP_LINK) }));
  }
  
  public boolean isSupportedDeepLink(String paramString)
  {
    return isSupportedDeepLink(new DeepLink(paramString));
  }
  
  public boolean tryHandleDeepAfterAuthorized()
  {
    if (pendingDeepLink != null)
    {
      if ((Strings.equalsIgnoreCase(pendingDeepLink.getAction(), "payment")) && (!Strings.isNullOrEmpty(pendingDeepLink.getParam("credits")))) {
        jobManager.queueImmediateJob(new LoadAppInfoJob(pendingDeepLink.toString()));
      }
      for (boolean bool = false;; bool = route(pendingDeepLink))
      {
        pendingDeepLink = null;
        if (!bool) {
          break;
        }
        deepLinkAnalytics.trackSuccess();
        return bool;
      }
      deepLinkAnalytics.trackFailure("not_handled");
      return bool;
    }
    return false;
  }
  
  public boolean tryHandleDeepLink(DeepLink paramDeepLink)
  {
    deepLinkAnalytics = AppAnalytics.trackHandleDeepLink(paramDeepLink.toString());
    if (!userProvider.getUser().isNull())
    {
      pendingDeepLink = null;
      boolean bool = route(paramDeepLink);
      if (bool)
      {
        deepLinkAnalytics.trackSuccess();
        return bool;
      }
      deepLinkAnalytics.trackFailure("not_handled");
      return bool;
    }
    pendingDeepLink = paramDeepLink;
    return false;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.deeplinks.DeepLinkManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */