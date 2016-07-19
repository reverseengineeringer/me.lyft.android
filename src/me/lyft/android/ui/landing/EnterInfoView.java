package me.lyft.android.ui.landing;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ScrollView;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.lyft.scoop.Scoop;
import com.lyft.scoop.dagger.DaggerInjector;
import com.lyft.widgets.AdvancedEditText;
import com.lyft.widgets.EmailAutoFillEditText;
import com.lyft.widgets.ProgressButton;
import javax.inject.Inject;
import me.lyft.android.analytics.core.ActionAnalytics;
import me.lyft.android.analytics.studies.OnBoardingAnalytics;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.application.features.Features;
import me.lyft.android.application.features.IFeaturesProvider;
import me.lyft.android.application.landing.ILandingService;
import me.lyft.android.common.Strings;
import me.lyft.android.domain.User;
import me.lyft.android.infrastructure.device.IDevice;
import me.lyft.android.persistence.landing.SignupUser;
import me.lyft.android.persistence.landing.SignupUser.Builder;
import me.lyft.android.providers.ProfileProvider;
import me.lyft.android.providers.ProfileProvider.PhoneProfile;
import me.lyft.android.rx.Binder;
import me.lyft.android.ui.IViewErrorHandler;
import me.lyft.android.ui.SelectiveProgressController;
import me.lyft.android.utils.Keyboard;
import rx.Observable;
import rx.subjects.PublishSubject;

public class EnterInfoView
  extends ScrollView
{
  private Binder binder;
  @Inject
  IDevice device;
  EmailAutoFillEditText emailEdit;
  TextView errorEmailTextView;
  TextView errorFistNameTextView;
  TextView errorLastNameTextView;
  @Inject
  IFeaturesProvider featuresProvider;
  AdvancedEditText firstNameEdit;
  @Inject
  LandingFlow landingFlow;
  @Inject
  ILandingService landingService;
  AdvancedEditText lastNameEdit;
  ProgressButton nextButton;
  @Inject
  ProfileProvider profileProvider;
  private SelectiveProgressController progressController;
  final PublishSubject<SignupUser> submitProfileInfoSubject = PublishSubject.create();
  TermsOfServiceView tosCheckBox;
  @Inject
  IUserProvider userProvider;
  @Inject
  IViewErrorHandler viewErrorHandler;
  
  public EnterInfoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
    Scoop.fromView(this).inflater(getContext()).inflate(2130903263, this, true);
    setFillViewport(true);
    if (isInEditMode()) {
      return;
    }
    ButterKnife.bind(this);
  }
  
  private void autoFillProfile(ProfileProvider.PhoneProfile paramPhoneProfile)
  {
    User localUser = userProvider.getUser();
    String str2 = localUser.getEmail();
    String str1 = str2;
    if (Strings.isNullOrEmpty(str2)) {
      str1 = device.getGoogleAccountEmail();
    }
    if (!Strings.isNullOrEmpty(str1)) {
      emailEdit.setTextAndMoveCursor(str1);
    }
    str2 = localUser.getLastName();
    str1 = str2;
    if (Strings.isNullOrEmpty(str2)) {
      str1 = paramPhoneProfile.getLastName();
    }
    if (!Strings.isNullOrEmpty(str1)) {
      lastNameEdit.setTextAndMoveCursor(str1);
    }
    str2 = localUser.getFirstName();
    str1 = str2;
    if (Strings.isNullOrEmpty(str2)) {
      str1 = paramPhoneProfile.getFirstName();
    }
    if (!Strings.isNullOrEmpty(str1)) {
      firstNameEdit.setTextAndMoveCursor(str1);
    }
  }
  
  private void initEditText(AdvancedEditText paramAdvancedEditText, TextView paramTextView)
  {
    paramAdvancedEditText.setValidationMessageView(paramTextView);
    paramAdvancedEditText.setOnEditorActionListener(new EnterInfoView.5(this, paramTextView));
  }
  
  public Observable<SignupUser> observeSubmitProfile()
  {
    return submitProfileInfoSubject.asObservable();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (isInEditMode()) {}
    do
    {
      return;
      binder = Binder.attach(this);
      initEditText(firstNameEdit, errorFistNameTextView);
      initEditText(lastNameEdit, errorLastNameTextView);
      initEditText(emailEdit, errorEmailTextView);
      Keyboard.showKeyboard(firstNameEdit);
      binder.bind(profileProvider.observePhoneProfile(), new EnterInfoView.1(this));
      nextButton.setOnClickListener(new EnterInfoView.2(this));
      emailEdit.setOnEditorActionListener(new EnterInfoView.3(this));
    } while ((!featuresProvider.isEnabled(Features.PG_PHONE_FIRST_SIGNUP)) || (!tosCheckBox.isChecked()));
    tosCheckBox.setVisibility(8);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    progressController = new SelectiveProgressController();
    progressController.addProgressView(nextButton);
    progressController.addDisableView(firstNameEdit);
    progressController.addDisableView(lastNameEdit);
    progressController.addDisableView(emailEdit);
  }
  
  public void submitProfileInfo()
  {
    ActionAnalytics localActionAnalytics = OnBoardingAnalytics.trackAddProfileInfo();
    SignupUser localSignupUser = new SignupUser.Builder().firstName(firstNameEdit.getText().toString()).lastName(lastNameEdit.getText().toString()).email(emailEdit.getText().toString()).hasAgreedTOS(tosCheckBox.isChecked()).build();
    progressController.showProgress();
    binder.bind(landingService.updateExistingUser(localSignupUser), new EnterInfoView.4(this, localActionAnalytics, localSignupUser));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.landing.EnterInfoView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */