package me.lyft.android.ui.business.profile;

import android.content.Context;
import android.content.res.Resources;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.lyft.scoop.Screen;
import com.lyft.scoop.dagger.DaggerInjector;
import com.lyft.widgets.AdvancedEditText;
import javax.inject.Inject;
import me.lyft.android.application.enterprise.IEnterpriseService;
import me.lyft.android.common.EmailUtils;
import me.lyft.android.common.Strings;
import me.lyft.android.controls.Toolbar;
import me.lyft.android.rx.Binder;
import me.lyft.android.ui.IProgressController;
import me.lyft.android.ui.business.BusinessProfileScreens.BusinessProfileEditEmailScreen;
import me.lyft.android.utils.Keyboard;

public class BusinessProfileEditEmailView
  extends LinearLayout
{
  Binder binder;
  AdvancedEditText emailEditText;
  @Inject
  IEnterpriseService enterpriseService;
  TextView inlineErrorTxt;
  private final BusinessProfileScreens.BusinessProfileEditEmailScreen params;
  @Inject
  IProgressController progressController;
  Button resendButton;
  private TextWatcher textChangedListener = new BusinessProfileEditEmailView.5(this);
  Toolbar toolbar;
  TextView verifyEmailText;
  
  public BusinessProfileEditEmailView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
    params = ((BusinessProfileScreens.BusinessProfileEditEmailScreen)Screen.fromView(this));
  }
  
  private void showResendButton(boolean paramBoolean)
  {
    int j = 0;
    Object localObject = resendButton;
    if (paramBoolean)
    {
      i = 0;
      ((Button)localObject).setVisibility(i);
      localObject = verifyEmailText;
      if (!paramBoolean) {
        break label45;
      }
    }
    label45:
    for (int i = j;; i = 8)
    {
      ((TextView)localObject).setVisibility(i);
      return;
      i = 8;
      break;
    }
  }
  
  private void verifyEmail()
  {
    String str = emailEditText.getEditableText().toString();
    if (!EmailUtils.validateEmail(str))
    {
      inlineErrorTxt.setVisibility(0);
      showResendButton(false);
      return;
    }
    progressController.disableUI();
    progressController.showProgress();
    binder.bind(enterpriseService.updateUserOrganization(str), new BusinessProfileEditEmailView.4(this));
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    binder = Binder.attach(this);
    binder.bind(toolbar.observeItemClick(), new BusinessProfileEditEmailView.1(this));
    resendButton.setOnClickListener(new BusinessProfileEditEmailView.2(this));
    emailEditText.setOnTouchListener(new BusinessProfileEditEmailView.3(this));
    String str = params.getEmail();
    if ((!Strings.isNullOrEmpty(str)) && (Strings.isNullOrEmpty(emailEditText.getText().toString())))
    {
      emailEditText.setText(str);
      emailEditText.setSelection(emailEditText.getText().length());
    }
    emailEditText.addTextChangedListener(textChangedListener);
    emailEditText.setValidationMessageView(inlineErrorTxt);
    Keyboard.showKeyboard(emailEditText);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    emailEditText.removeTextChangedListener(textChangedListener);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    ButterKnife.bind(this);
    toolbar.setTitle(getContext().getString(2131165347));
    toolbar.addItem(2131558453, getResources().getString(2131166289));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.business.profile.BusinessProfileEditEmailView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */