package me.lyft.android.ui.landing;

import android.content.res.Resources;
import android.widget.TextView;
import com.lyft.widgets.ProgressButton;
import javax.inject.Inject;
import me.lyft.android.analytics.core.ActionAnalytics;
import me.lyft.android.analytics.studies.OnBoardingAnalytics;
import me.lyft.android.application.ILogoutService;
import me.lyft.android.application.landing.ILandingService;
import me.lyft.android.common.RxViewController;
import me.lyft.android.common.Strings;
import me.lyft.android.controls.NumericKeyboard;
import me.lyft.android.controls.PhoneInputView;
import me.lyft.android.controls.Toolbar;
import me.lyft.android.infrastructure.device.IDevice;
import me.lyft.android.infrastructure.facebook.FacebookLoginResult;
import me.lyft.android.infrastructure.facebook.IFacebookLoginService;
import me.lyft.android.persistence.landing.ISignUpUserRepository;
import me.lyft.android.persistence.landing.SignupUser;
import me.lyft.android.persistence.landing.SignupUser.Builder;
import me.lyft.android.rx.RxUIBinder;
import me.lyft.android.ui.IViewErrorHandler;
import me.lyft.android.ui.SelectiveProgressController;

public class LoginViewController
  extends RxViewController
{
  private final IDevice device;
  private IFacebookLoginService facebookService;
  TextView inlinePhoneTextView;
  NumericKeyboard keyboard;
  private final LandingFlow landingFlow;
  private final ILandingService landingService;
  private final ILogoutService logoutService;
  ProgressButton nextButton;
  PhoneInputView phoneInputView;
  private SelectiveProgressController progressController;
  private final ISignUpUserRepository signUpUserRepository;
  Toolbar toolbar;
  private final IViewErrorHandler viewErrorHandler;
  
  @Inject
  public LoginViewController(IFacebookLoginService paramIFacebookLoginService, ILandingService paramILandingService, ILogoutService paramILogoutService, LandingFlow paramLandingFlow, IViewErrorHandler paramIViewErrorHandler, ISignUpUserRepository paramISignUpUserRepository, IDevice paramIDevice)
  {
    facebookService = paramIFacebookLoginService;
    landingService = paramILandingService;
    logoutService = paramILogoutService;
    landingFlow = paramLandingFlow;
    viewErrorHandler = paramIViewErrorHandler;
    signUpUserRepository = paramISignUpUserRepository;
    device = paramIDevice;
  }
  
  private void cachePhoneNumber(String paramString1, String paramString2)
  {
    paramString1 = signUpUserRepository.get().buildUpon().phone(paramString1).isoCountryCode(paramString2).build();
    signUpUserRepository.update(paramString1);
  }
  
  private String getCountryCode()
  {
    return phoneInputView.getCurrentCountryCode();
  }
  
  private String getPhoneString()
  {
    return phoneInputView.getPhoneNumber();
  }
  
  private void loadFacebookUser(FacebookLoginResult paramFacebookLoginResult)
  {
    progressController.showProgress();
    binder.bindAsyncCall(landingService.createFacebookUser(paramFacebookLoginResult), new LoginViewController.3(this));
  }
  
  private void requestPhoneAuth()
  {
    String str1 = getPhoneString();
    String str2 = getCountryCode();
    ActionAnalytics localActionAnalytics = OnBoardingAnalytics.trackAddPhone(str2, str1.length());
    progressController.showProgress();
    binder.bindAsyncCall(landingService.requestVerificationCode(str1), new LoginViewController.2(this, str1, str2, localActionAnalytics));
  }
  
  private void showInvalidPhoneNumber()
  {
    phoneInputView.setValidationErrorId(Integer.valueOf(2131165791));
    phoneInputView.showValidationMessage();
  }
  
  protected int layoutId()
  {
    return 2130903266;
  }
  
  void loginWithFacebook()
  {
    facebookService.openFacebookSession();
  }
  
  public void onAttach()
  {
    super.onAttach();
    toolbar.showTitle().setTitle(getResources().getString(2131165852));
    progressController = new SelectiveProgressController();
    progressController.addProgressView(nextButton);
    progressController.addDisableView(keyboard);
    logoutService.resetSignUp();
    phoneInputView.setValidationMessageView(inlinePhoneTextView);
    keyboard.setKeyPressListener(phoneInputView);
    phoneInputView.requestEditTextFocus();
    String str1 = device.getPhoneNumber();
    String str2 = signUpUserRepository.get().getPhoneString();
    String str3 = signUpUserRepository.get().getIsoCountryCode();
    if (!Strings.isNullOrEmpty(str3))
    {
      phoneInputView.selectCountry(str3);
      if (Strings.isNullOrEmpty(str2)) {
        break label218;
      }
      phoneInputView.setPhoneNumber(str2);
    }
    for (;;)
    {
      facebookService.start();
      binder.bindAction(facebookService.observeLogin(), new LoginViewController.1(this));
      return;
      phoneInputView.selectCountry(device.getLocaleCountryIso().toUpperCase());
      break;
      label218:
      if (!Strings.isNullOrEmpty(str1)) {
        phoneInputView.setPhoneNumber(str1);
      }
    }
  }
  
  void onClickNext()
  {
    requestPhoneAuth();
  }
  
  public void onDetach()
  {
    super.onDetach();
    facebookService.stop();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.landing.LoginViewController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */