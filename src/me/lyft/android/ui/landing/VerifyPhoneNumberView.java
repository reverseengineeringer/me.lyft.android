package me.lyft.android.ui.landing;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.lyft.scoop.Scoop;
import com.lyft.scoop.dagger.DaggerInjector;
import com.lyft.widgets.ProgressButton;
import javax.inject.Inject;
import me.lyft.android.analytics.core.ActionAnalytics;
import me.lyft.android.analytics.studies.OnBoardingAnalytics;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.application.landing.ILandingService;
import me.lyft.android.application.landing.ILoginChallengeService;
import me.lyft.android.application.ride.IUserUiService;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.common.Unit;
import me.lyft.android.controls.FourDigitsInput;
import me.lyft.android.controls.NumericKeyboard;
import me.lyft.android.infrastructure.sms.IVerificationAutoFillService;
import me.lyft.android.rx.Binder;
import me.lyft.android.ui.SelectiveProgressController;
import me.lyft.android.ui.dialogs.Toast;
import rx.Observable;
import rx.functions.Action1;
import rx.subjects.PublishSubject;

public class VerifyPhoneNumberView
  extends LinearLayout
{
  private Binder binder;
  @Inject
  DialogFlow dialogFlow;
  private TextWatcher fourDigitTextWatcher = new VerifyPhoneNumberView.1(this);
  FourDigitsInput fourDigitsInput;
  TextView inlinePhoneTextView;
  NumericKeyboard keyboard;
  @Inject
  ILandingService landingService;
  @Inject
  ILoginChallengeService loginChallengeService;
  @Inject
  ILoginErrorHandler loginErrorHandler;
  private Action1<Unit> onRetryVerifyPhone = new VerifyPhoneNumberView.3(this);
  private Action1<String> onVerificationCodeReceived = new VerifyPhoneNumberView.2(this);
  private String phoneNumber;
  private SelectiveProgressController progressController;
  View resendCodeView;
  @Inject
  IUserProvider userProvider;
  @Inject
  IUserUiService userUIService;
  @Inject
  IVerificationAutoFillService verificationAutoFillService;
  private final PublishSubject<Unit> verificationCompletedSubject = PublishSubject.create();
  ProgressButton verifyButton;
  
  public VerifyPhoneNumberView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    if (isInEditMode()) {}
    do
    {
      return;
      DaggerInjector.fromView(this).inject(this);
      setOrientation(1);
      Scoop.fromView(this).inflater(getContext()).inflate(2130903274, this, true);
    } while (isInEditMode());
    ButterKnife.bind(this);
  }
  
  private void requestResendVerificationCode()
  {
    ActionAnalytics localActionAnalytics = OnBoardingAnalytics.trackResendPhoneCode();
    showResendConfirmation(phoneNumber);
    fourDigitsInput.setText("");
    binder.bind(landingService.requestVerificationCode(phoneNumber), new VerifyPhoneNumberView.7(this, localActionAnalytics));
  }
  
  private void showResendConfirmation(String paramString)
  {
    dialogFlow.show(new Toast(getContext().getString(2131166251, new Object[] { paramString })));
  }
  
  public Observable<Unit> observeVerificationCompleted()
  {
    return verificationCompletedSubject.asObservable();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (isInEditMode()) {
      return;
    }
    resendCodeView.setOnClickListener(new VerifyPhoneNumberView.4(this));
    fourDigitsInput.requestInputFocus();
    fourDigitsInput.setValidationMessageView(inlinePhoneTextView);
    fourDigitsInput.setOnTextChangeListener(fourDigitTextWatcher);
    binder = Binder.attach(this);
    binder.bind(verificationAutoFillService.observeCode(getContext()), onVerificationCodeReceived);
    binder.bind(loginChallengeService.observeRetryVerifyPhoneSubject(), onRetryVerifyPhone);
    verifyButton.setOnClickListener(new VerifyPhoneNumberView.5(this));
    keyboard.setKeyPressListener(fourDigitsInput.getKeyPressedListener());
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    fourDigitsInput.removeOnTextChangeListener(fourDigitTextWatcher);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    progressController = new SelectiveProgressController();
    progressController.addProgressView(verifyButton);
    progressController.addDisableView(keyboard);
  }
  
  public void setPhoneNumberForVerification(String paramString)
  {
    phoneNumber = paramString;
    verificationAutoFillService.setPhoneNumber(paramString);
    inlinePhoneTextView.setText(getResources().getString(2131166254, new Object[] { paramString }));
  }
  
  public void verifyPhoneNumber()
  {
    ActionAnalytics localActionAnalytics2 = OnBoardingAnalytics.trackVerifyPhone();
    String str = fourDigitsInput.getText().toString();
    boolean bool = loginChallengeService.isForceNewAccount();
    if (bool) {}
    for (ActionAnalytics localActionAnalytics1 = OnBoardingAnalytics.trackForceNewAccount("additionalAuthRequired");; localActionAnalytics1 = null)
    {
      progressController.showProgress();
      binder.bind(landingService.verifyPhone(phoneNumber, str, bool), new VerifyPhoneNumberView.6(this, localActionAnalytics2, localActionAnalytics1, str));
      return;
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.landing.VerifyPhoneNumberView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */