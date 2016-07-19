package me.lyft.android.ui.landing;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ScrollView;
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
import me.lyft.android.application.terms.ITermsService;
import me.lyft.android.common.Strings;
import me.lyft.android.common.Unit;
import me.lyft.android.controls.NumericKeyboard;
import me.lyft.android.controls.PhoneInputView;
import me.lyft.android.infrastructure.device.IDevice;
import me.lyft.android.persistence.landing.ISignUpUserRepository;
import me.lyft.android.persistence.landing.SignupUser;
import me.lyft.android.persistence.landing.SignupUser.Builder;
import me.lyft.android.rx.Binder;
import me.lyft.android.ui.IViewErrorHandler;
import me.lyft.android.ui.SelectiveProgressController;
import rx.Observable;
import rx.subjects.PublishSubject;

public class EnterPhoneView
  extends ScrollView
{
  private Binder binder;
  @Inject
  IDevice device;
  NumericKeyboard keyboard;
  @Inject
  ILandingService landingService;
  ProgressButton nextButton;
  TextView phoneHintTextView;
  PhoneInputView phoneInputView;
  private SelectiveProgressController progressController;
  @Inject
  ISignUpUserRepository signUpUserRepository;
  TermsOfServiceView termsOfServiceView;
  @Inject
  ITermsService termsService;
  @Inject
  IUserProvider userProvider;
  final PublishSubject<String> verificationRequestedSubject = PublishSubject.create();
  @Inject
  IViewErrorHandler viewErrorHandler;
  
  public EnterPhoneView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
    Scoop.fromView(this).inflater(getContext()).inflate(2130903264, this, true);
    if (isInEditMode()) {
      return;
    }
    setFillViewport(true);
    ButterKnife.bind(this);
  }
  
  private Observable<Unit> acceptTermsAndRequestVerificationCode(String paramString)
  {
    return Observable.defer(new EnterPhoneView.4(this)).flatMap(new EnterPhoneView.3(this, paramString));
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
  
  private void showInvalidPhoneNumber()
  {
    phoneInputView.setValidationErrorId(Integer.valueOf(2131165791));
    phoneInputView.showValidationMessage();
  }
  
  public Observable<String> observeVerificationRequested()
  {
    return verificationRequestedSubject.asObservable();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (isInEditMode()) {
      return;
    }
    binder = Binder.attach(this);
    phoneInputView.setValidationMessageView(phoneHintTextView);
    phoneInputView.requestFocus();
    keyboard.setKeyPressListener(phoneInputView);
    String str1 = device.getPhoneNumber();
    String str2 = signUpUserRepository.get().getPhoneString();
    String str3 = signUpUserRepository.get().getIsoCountryCode();
    if (!Strings.isNullOrEmpty(str3))
    {
      phoneInputView.selectCountry(str3);
      if (Strings.isNullOrEmpty(str2)) {
        break label154;
      }
      phoneInputView.setPhoneNumber(str2);
    }
    for (;;)
    {
      nextButton.setOnClickListener(new EnterPhoneView.1(this));
      return;
      phoneInputView.selectCountry(device.getLocaleCountryIso().toUpperCase());
      break;
      label154:
      if (!Strings.isNullOrEmpty(str1)) {
        phoneInputView.setPhoneNumber(str1);
      }
    }
  }
  
  protected void onDetachedFromWindow()
  {
    cachePhoneNumber(phoneInputView.getPhoneNumber(), phoneInputView.getCurrentCountryCode());
    super.onDetachedFromWindow();
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    progressController = new SelectiveProgressController();
    progressController.addProgressView(nextButton);
    progressController.addDisableView(keyboard);
  }
  
  public void requestPhoneAuth()
  {
    String str = getPhoneString();
    ActionAnalytics localActionAnalytics = OnBoardingAnalytics.trackAddPhone(getCountryCode(), str.length());
    progressController.showProgress();
    binder.bind(acceptTermsAndRequestVerificationCode(str), new EnterPhoneView.2(this, localActionAnalytics, str));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.landing.EnterPhoneView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */