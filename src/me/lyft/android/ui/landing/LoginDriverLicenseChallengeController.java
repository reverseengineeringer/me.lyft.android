package me.lyft.android.ui.landing;

import android.content.res.Resources;
import android.widget.Button;
import android.widget.TextView;
import com.lyft.widgets.AdvancedEditText;
import javax.inject.Inject;
import me.lyft.android.analytics.core.ActionAnalytics;
import me.lyft.android.analytics.studies.OnBoardingAnalytics;
import me.lyft.android.application.landing.ILandingService;
import me.lyft.android.application.landing.ILoginChallengeService;
import me.lyft.android.common.RxViewController;
import me.lyft.android.controls.BackButtonToolbar;
import me.lyft.android.infrastructure.foreground.IAppForegroundDetector;
import me.lyft.android.rx.RxUIBinder;
import me.lyft.android.ui.IProgressController;
import me.lyft.android.utils.WebBrowser;

public class LoginDriverLicenseChallengeController
  extends RxViewController
{
  private final IAppForegroundDetector appForegroundDetector;
  AdvancedEditText challengeInput;
  TextView inlineErrorTextView;
  private final LandingFlow landingFlow;
  private final ILandingService landingService;
  private final ILoginChallengeErrorHandler loginChallengeErrorHandler;
  private final ILoginChallengeService loginChallengeService;
  Button nextButton;
  private final IProgressController progressController;
  BackButtonToolbar toolbar;
  private final WebBrowser webBrowser;
  
  @Inject
  public LoginDriverLicenseChallengeController(ILandingService paramILandingService, LandingFlow paramLandingFlow, ILoginChallengeService paramILoginChallengeService, IAppForegroundDetector paramIAppForegroundDetector, WebBrowser paramWebBrowser, ILoginChallengeErrorHandler paramILoginChallengeErrorHandler, IProgressController paramIProgressController)
  {
    progressController = paramIProgressController;
    landingFlow = paramLandingFlow;
    landingService = paramILandingService;
    loginChallengeService = paramILoginChallengeService;
    appForegroundDetector = paramIAppForegroundDetector;
    webBrowser = paramWebBrowser;
    loginChallengeErrorHandler = paramILoginChallengeErrorHandler;
  }
  
  private void verifyDriverLicense()
  {
    ActionAnalytics localActionAnalytics = OnBoardingAnalytics.trackLoginChallenge("driversLicenseNumber");
    progressController.showProgress();
    progressController.disableUI();
    binder.bindAsyncCall(landingService.verifyDriverLicense(loginChallengeService.getPhone(), challengeInput.getText().toString()), new LoginDriverLicenseChallengeController.5(this, localActionAnalytics));
  }
  
  protected int layoutId()
  {
    return 2130903279;
  }
  
  public void onAttach()
  {
    super.onAttach();
    OnBoardingAnalytics.trackShowLicenseChallengeView();
    toolbar.setTitle(getResources().getString(2131165903));
    challengeInput.requestFocusAndMoveCursor();
    challengeInput.addTextChangedListener(new LoginDriverLicenseChallengeController.1(this));
    inlineErrorTextView.setOnClickListener(new LoginDriverLicenseChallengeController.2(this));
    binder.bindAction(appForegroundDetector.observeAppForegrounded(), new LoginDriverLicenseChallengeController.3(this));
    nextButton.setOnClickListener(new LoginDriverLicenseChallengeController.4(this));
    loginChallengeErrorHandler.attach(challengeInput, inlineErrorTextView);
  }
  
  public void onDetach()
  {
    super.onDetach();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.landing.LoginDriverLicenseChallengeController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */