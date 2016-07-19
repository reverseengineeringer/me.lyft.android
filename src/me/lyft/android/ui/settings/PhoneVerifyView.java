package me.lyft.android.ui.settings;

import android.content.Context;
import android.content.res.Resources;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.lyft.scoop.dagger.DaggerInjector;
import javax.inject.Inject;
import me.lyft.android.analytics.core.ActionAnalytics;
import me.lyft.android.analytics.studies.OnBoardingAnalytics;
import me.lyft.android.application.settings.ISettingsService;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.common.Unit;
import me.lyft.android.controls.KeyboardlessEditText;
import me.lyft.android.controls.NumericKeyboard;
import me.lyft.android.infrastructure.sms.IVerificationAutoFillService;
import me.lyft.android.rx.AsyncCall;
import me.lyft.android.rx.RxUIBinder;
import me.lyft.android.ui.IProgressController;
import me.lyft.android.ui.IViewErrorHandler;
import me.lyft.android.ui.dialogs.Toast;
import rx.Observable;
import rx.functions.Action1;
import rx.subjects.PublishSubject;

public class PhoneVerifyView
  extends LinearLayout
{
  private static final int MIN_CODE_LENGTH = 4;
  private static final String REASON_DUPLICATE_PHONE = "duplicatePhoneNumber";
  private static final String REASON_INVALID_PHONE = "invalidPhone";
  private static final String REASON_SUSPENDED = "suspended";
  RxUIBinder binder = new RxUIBinder();
  KeyboardlessEditText codeEditText;
  @Inject
  DialogFlow dialogFlow;
  NumericKeyboard keyboard;
  private Action1<String> onVerificationCodeReceived = new PhoneVerifyView.3(this);
  private String phoneNumber;
  TextView phoneTextView;
  @Inject
  ISettingsService phoneVerificationService;
  @Inject
  IProgressController progressController;
  View resendCodeView;
  @Inject
  IVerificationAutoFillService verificationAutoFillService;
  final PublishSubject<Unit> verificationCompletedSubject = PublishSubject.create();
  Button verifyButton;
  TextView verifyCodeNote;
  @Inject
  IViewErrorHandler viewErrorHandler;
  
  public PhoneVerifyView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
  }
  
  private void requestResendVerificationCode()
  {
    showResendConfirmation(phoneNumber);
    codeEditText.setText("");
    binder.bindAsyncCall(phoneVerificationService.requestVerificationCode(phoneNumber), new AsyncCall());
  }
  
  private void showResendConfirmation(String paramString)
  {
    dialogFlow.show(new Toast(getContext().getString(2131166251, new Object[] { paramString })));
  }
  
  private void verifyPhoneNumber()
  {
    ActionAnalytics localActionAnalytics = OnBoardingAnalytics.trackVerifyPhone();
    if (codeEditText.getText().length() != 4)
    {
      codeEditText.setValidationErrorId(Integer.valueOf(2131165793));
      localActionAnalytics.setValue(codeEditText.getText().length());
      localActionAnalytics.trackFailure("code_is_wrong_length");
      return;
    }
    progressController.disableUI();
    binder.bindAsyncCall(phoneVerificationService.verifyPhone(phoneNumber, codeEditText.getText().toString()), new PhoneVerifyView.4(this, localActionAnalytics));
  }
  
  public Observable<Unit> observeVerificationCompleted()
  {
    return verificationCompletedSubject.asObservable();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    codeEditText.requestFocus();
    binder.attach();
    binder.bindAction(verificationAutoFillService.observeCode(getContext()), onVerificationCodeReceived);
    verifyButton.setOnClickListener(new PhoneVerifyView.2(this));
    keyboard.setKeyPressListener(codeEditText);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    binder.detach();
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    ButterKnife.bind(this);
    codeEditText.setValidationMessageView(verifyCodeNote);
    resendCodeView.setOnClickListener(new PhoneVerifyView.1(this));
  }
  
  public void setPhoneNumberForVerification(String paramString)
  {
    phoneNumber = paramString;
    phoneTextView.setText(getResources().getString(2131166253, new Object[] { paramString }));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.settings.PhoneVerifyView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */