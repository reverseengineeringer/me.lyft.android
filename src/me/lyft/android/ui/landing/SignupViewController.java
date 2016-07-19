package me.lyft.android.ui.landing;

import android.content.res.Resources;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.lyft.widgets.AdvancedEditText;
import com.lyft.widgets.EmailAutoFillEditText;
import javax.inject.Inject;
import me.lyft.android.analytics.core.ActionAnalytics;
import me.lyft.android.analytics.studies.OnBoardingAnalytics;
import me.lyft.android.application.ILogoutService;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.application.features.Features;
import me.lyft.android.application.features.IFeaturesProvider;
import me.lyft.android.application.landing.ILandingService;
import me.lyft.android.common.RxViewController;
import me.lyft.android.common.Strings;
import me.lyft.android.controls.Toolbar;
import me.lyft.android.domain.User;
import me.lyft.android.infrastructure.device.IDevice;
import me.lyft.android.infrastructure.facebook.FacebookLoginResult;
import me.lyft.android.infrastructure.facebook.IFacebookLoginService;
import me.lyft.android.persistence.landing.ISignUpUserRepository;
import me.lyft.android.persistence.landing.SignupUser;
import me.lyft.android.persistence.landing.SignupUser.Builder;
import me.lyft.android.providers.ProfileProvider;
import me.lyft.android.providers.ProfileProvider.PhoneProfile;
import me.lyft.android.rx.RxUIBinder;
import me.lyft.android.ui.IProgressController;
import me.lyft.android.utils.Keyboard;

public class SignupViewController
  extends RxViewController
{
  private final IDevice device;
  EmailAutoFillEditText emailEdit;
  View emailSignupCopy;
  TextView errorEmailTextView;
  TextView errorFistNameTextView;
  TextView errorLastNameTextView;
  View facebookLoginButton;
  private final IFacebookLoginService facebookService;
  private final IFeaturesProvider featuresProvider;
  AdvancedEditText firstNameEdit;
  private final LandingFlow landingFlow;
  private final ILandingService landingService;
  AdvancedEditText lastNameEdit;
  private final ILogoutService logoutService;
  Button nextButton;
  private final ProfileProvider profileProvider;
  private final IProgressController progressController;
  private final ISignUpUserRepository signUpUserRepository;
  Toolbar toolbar;
  private final IUserProvider userProvider;
  
  @Inject
  public SignupViewController(IFacebookLoginService paramIFacebookLoginService, ProfileProvider paramProfileProvider, IUserProvider paramIUserProvider, IDevice paramIDevice, ILandingService paramILandingService, LandingFlow paramLandingFlow, ILogoutService paramILogoutService, ISignUpUserRepository paramISignUpUserRepository, IProgressController paramIProgressController, IFeaturesProvider paramIFeaturesProvider)
  {
    facebookService = paramIFacebookLoginService;
    profileProvider = paramProfileProvider;
    userProvider = paramIUserProvider;
    device = paramIDevice;
    landingService = paramILandingService;
    landingFlow = paramLandingFlow;
    logoutService = paramILogoutService;
    signUpUserRepository = paramISignUpUserRepository;
    progressController = paramIProgressController;
    featuresProvider = paramIFeaturesProvider;
  }
  
  private void autoFillProfile(ProfileProvider.PhoneProfile paramPhoneProfile)
  {
    SignupUser localSignupUser = signUpUserRepository.get();
    String str2 = userProvider.getUser().getEmail();
    String str1 = str2;
    if (Strings.isNullOrEmpty(str2)) {
      str1 = device.getGoogleAccountEmail();
    }
    if (!Strings.isNullOrEmpty(localSignupUser.getEmail())) {
      emailEdit.setTextAndMoveCursor(localSignupUser.getEmail());
    }
    label166:
    label203:
    do
    {
      break label166;
      str2 = userProvider.getUser().getLastName();
      str1 = str2;
      if (Strings.isNullOrEmpty(str2)) {
        str1 = paramPhoneProfile.getLastName();
      }
      if (!Strings.isNullOrEmpty(localSignupUser.getLastName())) {
        lastNameEdit.setTextAndMoveCursor(localSignupUser.getLastName());
      }
      for (;;)
      {
        str2 = userProvider.getUser().getFirstName();
        str1 = str2;
        if (Strings.isNullOrEmpty(str2)) {
          str1 = paramPhoneProfile.getFirstName();
        }
        if (Strings.isNullOrEmpty(localSignupUser.getFirstName())) {
          break label203;
        }
        firstNameEdit.setTextAndMoveCursor(localSignupUser.getFirstName());
        return;
        if (Strings.isNullOrEmpty(str1)) {
          break;
        }
        emailEdit.setTextAndMoveCursor(str1);
        break;
        if (!Strings.isNullOrEmpty(str1)) {
          lastNameEdit.setTextAndMoveCursor(str1);
        }
      }
    } while (Strings.isNullOrEmpty(str1));
    firstNameEdit.setTextAndMoveCursor(str1);
  }
  
  private void initEditText(AdvancedEditText paramAdvancedEditText, TextView paramTextView)
  {
    paramAdvancedEditText.setValidationMessageView(paramTextView);
    paramAdvancedEditText.setOnEditorActionListener(new SignupViewController.7(this, paramTextView));
  }
  
  private void loadFacebookUser(FacebookLoginResult paramFacebookLoginResult)
  {
    progressController.showProgress();
    binder.bindAsyncCall(landingService.createFacebookUser(paramFacebookLoginResult), new SignupViewController.8(this));
  }
  
  protected int layoutId()
  {
    return 2130903270;
  }
  
  void loginWithFacebook()
  {
    facebookService.openFacebookSession();
  }
  
  public void onAttach()
  {
    super.onAttach();
    toolbar.showTitle().setTitle(getResources().getString(2131165853)).addItem(2131558445, getResources().getString(2131165934), 0, getResources().getColor(2131493004), 1);
    nextButton.setOnClickListener(new SignupViewController.1(this));
    initEditText(firstNameEdit, errorFistNameTextView);
    initEditText(lastNameEdit, errorLastNameTextView);
    initEditText(emailEdit, errorEmailTextView);
    emailEdit.setOnEditorActionListener(new SignupViewController.2(this));
    if (featuresProvider.isEnabled(Features.PG_NO_FACEBOOK_SIGNUP))
    {
      facebookLoginButton.setVisibility(8);
      emailSignupCopy.setVisibility(8);
    }
    logoutService.resetSignUp();
    binder.bindAsyncCall(profileProvider.observePhoneProfile(), new SignupViewController.3(this));
    binder.bindAction(toolbar.observeItemClick(), new SignupViewController.4(this));
    facebookService.start();
    binder.bindAction(facebookService.observeLogin(), new SignupViewController.5(this));
  }
  
  public void onDetach()
  {
    super.onDetach();
    facebookService.stop();
  }
  
  boolean onEmailEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 6)
    {
      submitProfileInfo();
      return true;
    }
    return false;
  }
  
  void showKeyboardIfNeeded()
  {
    Object localObject2 = null;
    EditText[] arrayOfEditText = new EditText[3];
    arrayOfEditText[0] = firstNameEdit;
    arrayOfEditText[1] = lastNameEdit;
    arrayOfEditText[2] = emailEdit;
    int j = arrayOfEditText.length;
    int i = 0;
    for (;;)
    {
      Object localObject1 = localObject2;
      if (i < j)
      {
        localObject1 = arrayOfEditText[i];
        if (!Strings.isNullOrEmpty(((EditText)localObject1).getText().toString().trim())) {}
      }
      else
      {
        if (localObject1 != null) {
          Keyboard.showKeyboard((View)localObject1);
        }
        return;
      }
      i += 1;
    }
  }
  
  void submitProfileInfo()
  {
    ActionAnalytics localActionAnalytics = OnBoardingAnalytics.trackAddProfileInfo();
    SignupUser localSignupUser = new SignupUser.Builder().firstName(firstNameEdit.getText().toString().trim()).lastName(lastNameEdit.getText().toString().trim()).email(emailEdit.getText().toString().trim()).hasAgreedTOS(false).build();
    binder.bindAsyncCall(landingService.createUser(localSignupUser), new SignupViewController.6(this, localActionAnalytics));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.landing.SignupViewController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */