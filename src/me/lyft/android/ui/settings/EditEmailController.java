package me.lyft.android.ui.settings;

import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import com.lyft.widgets.AdvancedEditText;
import com.lyft.widgets.EditTextUtils;
import com.lyft.widgets.LowerCaseTextWatcher;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.application.settings.ISettingsService;
import me.lyft.android.common.AppFlow;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.common.RxViewController;
import me.lyft.android.common.Strings;
import me.lyft.android.controls.Toolbar;
import me.lyft.android.controls.Validation;
import me.lyft.android.domain.User;
import me.lyft.android.domain.lyft.LyftValidationError;
import me.lyft.android.errorhandling.IDefaultErrorHandler;
import me.lyft.android.infrastructure.lyft.LyftApiException;
import me.lyft.android.rx.RxUIBinder;
import me.lyft.android.ui.IProgressController;
import rx.functions.Action1;

public class EditEmailController
  extends RxViewController
{
  @Inject
  AppFlow appFlow;
  @Inject
  IDefaultErrorHandler defaultErrorHandler;
  @Inject
  DialogFlow dialogFlow;
  AdvancedEditText emailEditText;
  TextView inlineErrorTxt;
  private final Action1<Integer> onToolbarItemClicked = new EditEmailController.1(this);
  @Inject
  IProgressController progressController;
  @Inject
  ISettingsService settingsService;
  Toolbar toolbar;
  @Inject
  IUserProvider userProvider;
  
  private void goToNextStep()
  {
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
        while (paramThrowable.hasNext()) {
          if (((LyftValidationError)paramThrowable.next()).getField().equalsIgnoreCase("email"))
          {
            emailEditText.setValidationErrorId(Integer.valueOf(2131165786));
            i = 1;
          }
        }
        if (i != 0) {
          inlineErrorTxt.setVisibility(0);
        }
        Validation.focusErrorField(new View[] { emailEditText });
        return true;
      }
    }
    return false;
  }
  
  private boolean isEmailChanged()
  {
    String str1 = userProvider.getUser().getEmail();
    String str2 = emailEditText.getText().toString();
    return (!Strings.isNullOrEmpty(str2)) && (!str2.equalsIgnoreCase(str1));
  }
  
  private void onSaveClicked()
  {
    if (isEmailChanged())
    {
      saveProfile();
      return;
    }
    goToNextStep();
  }
  
  private void saveProfile()
  {
    progressController.showProgress();
    binder.bindAsyncCall(settingsService.updateEmail(emailEditText.getText().toString()), new EditEmailController.2(this));
  }
  
  protected int layoutId()
  {
    return 2130903203;
  }
  
  public void onAttach()
  {
    super.onAttach();
    emailEditText.addTextChangedListener(new LowerCaseTextWatcher());
    emailEditText.setValidationMessageView(inlineErrorTxt);
    toolbar.setTitle(getResources().getString(2131166314)).addItem(2131558453, getResources().getString(2131166289), 2130837509);
    User localUser = userProvider.getUser();
    EditTextUtils.setTextAndMoveCursor(emailEditText, localUser.getEmail());
    binder.bindAction(toolbar.observeItemClick(), onToolbarItemClicked);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.settings.EditEmailController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */