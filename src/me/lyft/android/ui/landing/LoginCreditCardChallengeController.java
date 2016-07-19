package me.lyft.android.ui.landing;

import android.content.res.Resources;
import android.widget.Button;
import android.widget.TextView;
import javax.inject.Inject;
import me.lyft.android.analytics.core.ActionAnalytics;
import me.lyft.android.analytics.studies.OnBoardingAnalytics;
import me.lyft.android.application.landing.ILandingService;
import me.lyft.android.application.landing.ILoginChallengeService;
import me.lyft.android.common.RxViewController;
import me.lyft.android.controls.BackButtonToolbar;
import me.lyft.android.controls.KeyboardlessEditText;
import me.lyft.android.controls.NumericKeyboard;
import me.lyft.android.domain.Phone;
import me.lyft.android.rx.RxUIBinder;
import me.lyft.android.ui.IProgressController;
import me.lyft.android.utils.WebBrowser;

public class LoginCreditCardChallengeController
  extends RxViewController
{
  KeyboardlessEditText challengeInput;
  TextView inlineErrorTextView;
  NumericKeyboard keyboard;
  private final LandingFlow landingFlow;
  private final ILandingService landingService;
  private final ILoginChallengeErrorHandler loginChallengeErrorHandler;
  private final ILoginChallengeService loginChallengeService;
  Button nextButton;
  private final IProgressController progressController;
  BackButtonToolbar toolbar;
  private final WebBrowser webBrowser;
  
  @Inject
  public LoginCreditCardChallengeController(ILandingService paramILandingService, LandingFlow paramLandingFlow, ILoginChallengeService paramILoginChallengeService, WebBrowser paramWebBrowser, ILoginChallengeErrorHandler paramILoginChallengeErrorHandler, IProgressController paramIProgressController)
  {
    progressController = paramIProgressController;
    landingFlow = paramLandingFlow;
    landingService = paramILandingService;
    loginChallengeService = paramILoginChallengeService;
    webBrowser = paramWebBrowser;
    loginChallengeErrorHandler = paramILoginChallengeErrorHandler;
  }
  
  private void createNewAccount()
  {
    ActionAnalytics localActionAnalytics = OnBoardingAnalytics.trackForceNewAccount("ccLast4");
    progressController.showProgress();
    progressController.disableUI();
    binder.bindAsyncCall(landingService.verifyPhone(loginChallengeService.getPhone().getNumber(), loginChallengeService.getPhone().getVerificationCode().toString(), true), new LoginCreditCardChallengeController.4(this, localActionAnalytics));
  }
  
  private void verifyCreditCard()
  {
    ActionAnalytics localActionAnalytics = OnBoardingAnalytics.trackLoginChallenge("ccLast4");
    progressController.showProgress();
    progressController.disableUI();
    binder.bindAsyncCall(landingService.verifyCreditCard(loginChallengeService.getPhone(), challengeInput.getText().toString()), new LoginCreditCardChallengeController.5(this, localActionAnalytics));
  }
  
  protected int layoutId()
  {
    return 2130903278;
  }
  
  public void onAttach()
  {
    super.onAttach();
    OnBoardingAnalytics.trackShowCCChallengeView();
    toolbar.setTitle(getResources().getString(2131165903));
    challengeInput.requestFocusAndMoveCursor();
    challengeInput.addTextChangedListener(new LoginCreditCardChallengeController.1(this));
    inlineErrorTextView.setOnClickListener(new LoginCreditCardChallengeController.2(this));
    nextButton.setOnClickListener(new LoginCreditCardChallengeController.3(this));
    keyboard.setKeyPressListener(challengeInput);
    loginChallengeErrorHandler.attach(challengeInput, inlineErrorTextView);
  }
  
  void onTextChanged(CharSequence paramCharSequence)
  {
    if (paramCharSequence.length() == 4) {
      verifyCreditCard();
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.landing.LoginCreditCardChallengeController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */