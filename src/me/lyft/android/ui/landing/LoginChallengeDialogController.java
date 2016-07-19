package me.lyft.android.ui.landing;

import android.content.res.Resources;
import com.lyft.scoop.Screen;
import javax.inject.Inject;
import me.lyft.android.analytics.studies.OnBoardingAnalytics;
import me.lyft.android.application.landing.ILoginChallengeService;
import me.lyft.android.common.AppFlow;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.domain.Phone;
import me.lyft.android.ui.dialogs.StandardDialogController;

public class LoginChallengeDialogController
  extends StandardDialogController
{
  private final AppFlow appFlow;
  private final ILoginChallengeService loginChallengeService;
  
  @Inject
  public LoginChallengeDialogController(DialogFlow paramDialogFlow, AppFlow paramAppFlow, ILoginChallengeService paramILoginChallengeService)
  {
    super(paramDialogFlow);
    appFlow = paramAppFlow;
    loginChallengeService = paramILoginChallengeService;
  }
  
  private void accessMyAccount()
  {
    dismissDialog();
    appFlow.replaceAllWith(new Screen[] { new LandingScreens.IntroductionScreen(), new LandingScreens.LoginScreen(), new LandingScreens.LoginVerifyPhoneScreen(loginChallengeService.getPhone().getNumber()), new LandingScreens.LoginCreditCardChallengeScreen() });
  }
  
  private void createNewAccount()
  {
    dismissDialog();
    loginChallengeService.setForceNewAccount(true);
    loginChallengeService.retryVerifyPhone();
  }
  
  public void onAttach()
  {
    super.onAttach();
    OnBoardingAnalytics.trackShowChallengePopup();
    setContentTitle(getResources().getString(2131165898));
    setContentMessage(String.format(getResources().getString(2131165897), new Object[] { loginChallengeService.getAccountOwnerFirstName() }));
    String str = getResources().getString(2131165896);
    addPositiveButton(2130903157, str, new LoginChallengeDialogController.1(this, str));
    str = getResources().getString(2131165895);
    addPositiveButton(2130903157, str, new LoginChallengeDialogController.2(this, str));
    str = getResources().getString(2131165513);
    addNegativeButton(2130903152, str, new LoginChallengeDialogController.3(this, str));
  }
  
  public boolean onBack()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.landing.LoginChallengeDialogController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */