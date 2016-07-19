package me.lyft.android.ui.enterprise;

import android.content.Context;
import android.content.res.Resources;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.lyft.scoop.Screen;
import com.lyft.scoop.dagger.DaggerInjector;
import com.lyft.widgets.AdvancedEditText;
import com.lyft.widgets.LowerCaseTextWatcher;
import javax.inject.Inject;
import me.lyft.android.application.enterprise.IEnterpriseService;
import me.lyft.android.common.AppFlow;
import me.lyft.android.common.Strings;
import me.lyft.android.controls.Toolbar;
import me.lyft.android.rx.Binder;
import me.lyft.android.ui.IProgressController;
import me.lyft.android.utils.Keyboard;
import rx.functions.Action1;

public class EnterpriseEditEmailView
  extends LinearLayout
{
  @Inject
  AppFlow appFlow;
  Binder binder;
  AdvancedEditText emailEditText;
  private String enterpriseEmail;
  @Inject
  IEnterpriseErrorHandler enterpriseErrorHandler;
  @Inject
  IEnterpriseService enterpriseService;
  TextView inlineErrorTxt;
  private Action1<Integer> onToolbarItemClicked = new EnterpriseEditEmailView.2(this);
  private final EnterpriseScreens.EnterpriseEditEmailScreen params;
  @Inject
  IProgressController progressController;
  private TextWatcher textChangedListener = new EnterpriseEditEmailView.3(this);
  Toolbar toolbar;
  
  public EnterpriseEditEmailView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
    params = ((EnterpriseScreens.EnterpriseEditEmailScreen)Screen.fromView(this));
  }
  
  private void enableToolbarItem(Boolean paramBoolean)
  {
    toolbar.clearItems().addItem(2131558439, getResources().getString(2131166289), 2130838111);
    if (paramBoolean.booleanValue())
    {
      toolbar.enableItem(2131558439);
      ((TextView)ButterKnife.findById(toolbar.getToolbarItemView(2131558439), 2131558558)).setTypeface(null, 1);
      return;
    }
    toolbar.disableItem(2131558439);
  }
  
  private void updateToolbarItem()
  {
    if (Strings.isNullOrEmpty(emailEditText.getText().toString()))
    {
      enableToolbarItem(Boolean.valueOf(false));
      return;
    }
    enableToolbarItem(Boolean.valueOf(true));
  }
  
  private void verifyEmail()
  {
    String str = emailEditText.getText().toString();
    progressController.disableUI();
    progressController.showProgress();
    binder.bind(enterpriseService.updateUserOrganization(str), new EnterpriseEditEmailView.1(this));
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    binder = Binder.attach(this);
    if ((enterpriseEmail != null) && (Strings.isNullOrEmpty(emailEditText.getText().toString())))
    {
      emailEditText.setText(enterpriseEmail.toString());
      emailEditText.setSelection(emailEditText.getText().length());
    }
    emailEditText.addTextChangedListener(textChangedListener);
    binder.bind(toolbar.observeItemClick(), onToolbarItemClicked);
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
    emailEditText.addTextChangedListener(new LowerCaseTextWatcher());
    emailEditText.setValidationMessageView(inlineErrorTxt);
    enterpriseEmail = params.getEmail();
    toolbar.setTitle(getContext().getString(2131165683)).clearItems().addItem(2131558439, getResources().getString(2131166289), 2130838112).disableItem(2131558439);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.enterprise.EnterpriseEditEmailView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */