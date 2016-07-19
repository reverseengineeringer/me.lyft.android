package me.lyft.android.ui.landing;

import com.lyft.googlemaps.core.util.Strings;
import com.lyft.scoop.Screen;
import java.util.Arrays;
import javax.inject.Inject;
import me.lyft.android.analytics.core.ExperimentAnalytics;
import me.lyft.android.analytics.core.definitions.Experiment;
import me.lyft.android.analytics.studies.OnBoardingAnalytics;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.application.features.Features;
import me.lyft.android.application.features.IFeaturesProvider;
import me.lyft.android.common.AppFlow;
import me.lyft.android.deeplinks.DeepLinkManager;
import me.lyft.android.domain.User;
import me.lyft.android.ui.MainScreensRouter;
import me.lyft.android.ui.help.HelpScreens.HelpTermsScreen;

public class LandingFlow
{
  private final AppFlow appFlow;
  private final DeepLinkManager deepLinkManager;
  @Inject
  IFeaturesProvider featuresProvider;
  private final MainScreensRouter router;
  private IUserProvider userProvider;
  
  @Inject
  public LandingFlow(IUserProvider paramIUserProvider, AppFlow paramAppFlow, MainScreensRouter paramMainScreensRouter, DeepLinkManager paramDeepLinkManager)
  {
    userProvider = paramIUserProvider;
    appFlow = paramAppFlow;
    router = paramMainScreensRouter;
    deepLinkManager = paramDeepLinkManager;
  }
  
  public void goToNextScreenInLoginFlow()
  {
    User localUser = userProvider.getUser();
    if (!localUser.hasValidPhoneNumber())
    {
      appFlow.goTo(new LandingScreens.LoginPhoneScreen());
      return;
    }
    if ((!localUser.hasFirstAndLastName()) || (Strings.isNullOrEmpty(localUser.getEmail())))
    {
      appFlow.goTo(new LandingScreens.LoginEnterInfoScreen());
      return;
    }
    OnBoardingAnalytics.trackCompleteOnboarding();
    showRideScreen();
  }
  
  public void goToNextScreenInSignupFlow()
  {
    User localUser = userProvider.getUser();
    if (!localUser.hasValidPhoneNumber())
    {
      appFlow.goTo(new LandingScreens.SignupPhoneScreen());
      return;
    }
    if (!localUser.hasValidNameAndEmail())
    {
      appFlow.goTo(new LandingScreens.SignupEnterInfoScreen(false));
      return;
    }
    OnBoardingAnalytics.trackCompleteOnboarding();
    showRideScreen();
  }
  
  public void launchFirstScreen()
  {
    if (userProvider.getUser().isNull()) {
      appFlow.resetTo(new LandingScreens.IntroductionScreen());
    }
    do
    {
      return;
      if (!userProvider.getUser().profileIsComplete()) {
        break;
      }
    } while (deepLinkManager.tryHandleDeepAfterAuthorized());
    router.resetToHomeScreen();
    return;
    appFlow.resetTo(new LandingScreens.IntroductionScreen());
  }
  
  public void openLoginScreen()
  {
    appFlow.replaceAllWith(Arrays.asList(new Screen[] { new LandingScreens.IntroductionScreen(), new LandingScreens.LoginScreen() }));
  }
  
  public void openLoginVerifyPhoneScreen(String paramString)
  {
    appFlow.goTo(new LandingScreens.LoginVerifyPhoneScreen(paramString));
  }
  
  public void openSignupScreen()
  {
    ExperimentAnalytics.trackExposure(Experiment.PG_PHONE_FIRST_SIGNUP_V2);
    LandingScreens.IntroductionScreen localIntroductionScreen = new LandingScreens.IntroductionScreen();
    if (featuresProvider.isEnabled(Features.PG_PHONE_FIRST_SIGNUP))
    {
      appFlow.replaceAllWith(Arrays.asList(new Screen[] { localIntroductionScreen, new LandingScreens.SignupPhoneScreen() }));
      return;
    }
    appFlow.replaceAllWith(Arrays.asList(new Screen[] { localIntroductionScreen, new LandingScreens.SignupScreen() }));
  }
  
  public void openSingupVerifyPhoneScreen(String paramString)
  {
    appFlow.goTo(new LandingScreens.SignupVerifyPhoneScreen(paramString));
  }
  
  public void openTermsOfServiceScreen()
  {
    appFlow.goTo(new HelpScreens.HelpTermsScreen(false));
  }
  
  void showRideScreen()
  {
    if (!deepLinkManager.tryHandleDeepAfterAuthorized()) {
      router.resetToHomeScreen();
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.landing.LandingFlow
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */