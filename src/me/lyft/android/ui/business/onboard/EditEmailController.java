package me.lyft.android.ui.business.onboard;

import android.content.res.Resources;
import android.widget.EditText;
import android.widget.TextView;
import javax.inject.Inject;
import me.lyft.android.application.enterprise.IEnterpriseService;
import me.lyft.android.common.AppFlow;
import me.lyft.android.common.EmailUtils;
import me.lyft.android.common.RxViewController;
import me.lyft.android.controls.Toolbar;
import me.lyft.android.errorhandling.IDefaultErrorHandler;
import me.lyft.android.rx.RxUIBinder;
import me.lyft.android.ui.IProgressController;

public class EditEmailController
  extends RxViewController
{
  private final AppFlow appFlow;
  EditText emailEditTextView;
  private final IEnterpriseService enterpriseService;
  private final IDefaultErrorHandler errorHandler;
  TextView inlineErrorTextView;
  private final IProgressController progressController;
  Toolbar toolbar;
  
  @Inject
  public EditEmailController(AppFlow paramAppFlow, IEnterpriseService paramIEnterpriseService, IProgressController paramIProgressController, IDefaultErrorHandler paramIDefaultErrorHandler)
  {
    appFlow = paramAppFlow;
    enterpriseService = paramIEnterpriseService;
    progressController = paramIProgressController;
    errorHandler = paramIDefaultErrorHandler;
  }
  
  private void clearErrorMessage()
  {
    emailEditTextView.setTextColor(getResources().getColor(2131492898));
    inlineErrorTextView.setVisibility(8);
  }
  
  private void saveEmail()
  {
    String str = emailEditTextView.getEditableText().toString();
    if (!EmailUtils.validateEmail(str))
    {
      showErrorMessage(getResources().getString(2131165351));
      return;
    }
    progressController.disableUI();
    progressController.showProgress();
    binder.bindAsyncCall(enterpriseService.updateUserOrganization(str), new EditEmailController.2(this));
  }
  
  private void showErrorMessage(String paramString)
  {
    inlineErrorTextView.setText(paramString);
    inlineErrorTextView.setVisibility(0);
    emailEditTextView.setTextColor(getResources().getColor(2131493054));
  }
  
  protected int layoutId()
  {
    return 2130903072;
  }
  
  public void onAttach()
  {
    super.onAttach();
    emailEditTextView.setText(enterpriseService.getEmail());
    toolbar.setTitle(getResources().getString(2131165672));
    toolbar.addItem(2131558453, getResources().getString(2131166289).toUpperCase());
    binder.bindAction(toolbar.observeItemClick(), new EditEmailController.1(this));
  }
  
  public void onDetach()
  {
    super.onDetach();
    binder.detach();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.business.onboard.EditEmailController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */