package me.lyft.android.ui.settings;

import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.application.settings.ISettingsService;
import me.lyft.android.common.AppFlow;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.common.PhoneUtils;
import me.lyft.android.common.RxViewController;
import me.lyft.android.common.Strings;
import me.lyft.android.controls.NumericKeyboard;
import me.lyft.android.controls.PhoneInputView;
import me.lyft.android.controls.Toolbar;
import me.lyft.android.controls.Validation;
import me.lyft.android.domain.Phone;
import me.lyft.android.domain.User;
import me.lyft.android.domain.lyft.LyftValidationError;
import me.lyft.android.errorhandling.IDefaultErrorHandler;
import me.lyft.android.infrastructure.lyft.LyftApiException;
import me.lyft.android.rx.RxUIBinder;
import me.lyft.android.ui.IProgressController;
import rx.functions.Action1;

public class EditPhoneController
  extends RxViewController
{
  @Inject
  AppFlow appFlow;
  @Inject
  IDefaultErrorHandler defaultErrorHandler;
  @Inject
  DialogFlow dialogFlow;
  TextView inlineErrorTxt;
  NumericKeyboard keyboard;
  private final Action1<Integer> onToolbarItemClicked = new EditPhoneController.1(this);
  PhoneInputView phoneInputView;
  @Inject
  ISettingsService phoneVerificationService;
  @Inject
  IProgressController progressController;
  Toolbar toolbar;
  @Inject
  IUserProvider userProvider;
  
  private void goToNextStep()
  {
    if (userProvider.getUser().getPhone().isVerificationNeeded())
    {
      appFlow.goTo(new SettingsScreens.EditPhoneVerifyNumberScreen());
      return;
    }
    appFlow.goBack();
  }
  
  private boolean handleUpdateError(Throwable paramThrowable)
  {
    if ((paramThrowable instanceof LyftApiException))
    {
      paramThrowable = (LyftApiException)paramThrowable;
      int i = 0;
      if (paramThrowable.getStatusCode() == 422)
      {
        paramThrowable = paramThrowable.getValidationErrors().iterator();
        while (paramThrowable.hasNext())
        {
          Object localObject = (LyftValidationError)paramThrowable.next();
          String str = ((LyftValidationError)localObject).getField();
          localObject = ((LyftValidationError)localObject).getReason();
          if (str.equalsIgnoreCase("number"))
          {
            if (((String)localObject).equalsIgnoreCase("invalidAreaCode")) {
              phoneInputView.setValidationErrorId(Integer.valueOf(2131165789));
            }
            for (;;)
            {
              i = 1;
              break;
              if (((String)localObject).equalsIgnoreCase("invalidCountry")) {
                phoneInputView.setValidationErrorId(Integer.valueOf(2131165790));
              } else {
                phoneInputView.setValidationErrorId(Integer.valueOf(2131165791));
              }
            }
          }
        }
        if (i != 0) {
          inlineErrorTxt.setVisibility(0);
        }
        Validation.focusErrorField(new View[] { phoneInputView });
        return true;
      }
    }
    return false;
  }
  
  private boolean isPhoneNumberChanged()
  {
    String str1 = userProvider.getUser().getPhone().getNumber();
    String str2 = phoneInputView.getPhoneNumber();
    return (!Strings.isNullOrEmpty(str2)) && (!str2.equalsIgnoreCase(str1));
  }
  
  private void onSaveClicked()
  {
    if (isPhoneNumberChanged())
    {
      saveProfile();
      return;
    }
    goToNextStep();
  }
  
  private void saveProfile()
  {
    progressController.showProgress();
    binder.bindAsyncCall(phoneVerificationService.requestVerificationCode(phoneInputView.getPhoneNumber()), new EditPhoneController.2(this));
  }
  
  protected int layoutId()
  {
    return 2130903207;
  }
  
  public void onAttach()
  {
    super.onAttach();
    phoneInputView.setValidationMessageView(inlineErrorTxt);
    toolbar.setTitle(getResources().getString(2131166315)).addItem(2131558453, getResources().getString(2131166289), 2130837509);
    String str1 = userProvider.getUser().getPhone().getNumber();
    String str2 = PhoneUtils.getCountryCodeForPhone(str1);
    phoneInputView.selectCountry(str2);
    phoneInputView.setPhoneNumber(PhoneUtils.formatPhoneNumberToNational(str1, str2));
    phoneInputView.requestEditTextFocus();
    keyboard.setKeyPressListener(phoneInputView);
    binder.bindAction(toolbar.observeItemClick(), onToolbarItemClicked);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.settings.EditPhoneController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */