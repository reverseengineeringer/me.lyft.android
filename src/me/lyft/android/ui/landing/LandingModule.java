package me.lyft.android.ui.landing;

import android.content.res.Resources;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import me.lyft.android.application.landing.ILoginChallengeService;
import me.lyft.android.application.landing.LoginChallengeService;
import me.lyft.android.common.AppFlow;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.controls.PhoneInputView;
import me.lyft.android.ui.IViewErrorHandler;

@Module(complete=false, injects={StarterViewController.class, IntroductionViewController.class, SignupViewController.class, SignupPhoneController.class, SignupVerifyPhoneController.class, VerifyPhoneNumberView.class, LoginViewController.class, LoginEnterInfoController.class, LoginPhoneController.class, LoginVerifyPhoneController.class, TermsOfServiceView.class, SignupPromoBannerController.class, SignupEnterInfoController.class, EnterPhoneView.class, EnterInfoView.class, PhoneInputView.class, LoginDriverLicenseChallengeController.class, LoginCreditCardChallengeController.class, LoginChallengeDialogController.class})
public class LandingModule
{
  @Provides
  public ILoginChallengeErrorHandler provideLoginChallengeErrorHandler(IViewErrorHandler paramIViewErrorHandler, Resources paramResources)
  {
    return new LoginChallengeErrorHandler(paramIViewErrorHandler, paramResources);
  }
  
  @Provides
  @Singleton
  ILoginChallengeService provideLoginChallengeService()
  {
    return new LoginChallengeService();
  }
  
  @Provides
  public ILoginErrorHandler provideLoginErrorHandler(IViewErrorHandler paramIViewErrorHandler, Resources paramResources, DialogFlow paramDialogFlow, AppFlow paramAppFlow, ILoginChallengeService paramILoginChallengeService)
  {
    return new LoginErrorHandler(paramIViewErrorHandler, paramResources, paramDialogFlow, paramAppFlow, paramILoginChallengeService);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.landing.LandingModule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */