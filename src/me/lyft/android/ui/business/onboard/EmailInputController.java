package me.lyft.android.ui.business.onboard;

import android.content.res.Resources;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import com.lyft.googlemaps.core.util.Strings;
import javax.inject.Inject;
import me.lyft.android.application.business.BusinessOnboardingAnalytics;
import me.lyft.android.application.enterprise.IEnterpriseService;
import me.lyft.android.application.payment.IPaymentService;
import me.lyft.android.common.AppFlow;
import me.lyft.android.common.EmailUtils;
import me.lyft.android.common.RxViewController;
import me.lyft.android.controls.Toolbar;
import me.lyft.android.rx.AsyncCall;
import me.lyft.android.rx.RxUIBinder;
import me.lyft.android.ui.IProgressController;
import me.lyft.android.ui.IViewErrorHandler;
import me.lyft.android.utils.Keyboard;

public class EmailInputController
  extends RxViewController
{
  private final AppFlow appFlow;
  private final BusinessOnboardingAnalytics businessOnboardingAnalytics;
  EditText emailEditTextView;
  private final IEnterpriseService enterpriseService;
  private final IViewErrorHandler errorHandler;
  TextView inlineErrorTextView;
  private final IPaymentService paymentService;
  private final IProgressController progressController;
  private TextWatcher textChangedListener = new EmailInputController.2(this);
  Toolbar toolbar;
  
  @Inject
  public EmailInputController(IProgressController paramIProgressController, IEnterpriseService paramIEnterpriseService, IPaymentService paramIPaymentService, AppFlow paramAppFlow, IViewErrorHandler paramIViewErrorHandler, BusinessOnboardingAnalytics paramBusinessOnboardingAnalytics)
  {
    progressController = paramIProgressController;
    enterpriseService = paramIEnterpriseService;
    paymentService = paramIPaymentService;
    appFlow = paramAppFlow;
    errorHandler = paramIViewErrorHandler;
    businessOnboardingAnalytics = paramBusinessOnboardingAnalytics;
  }
  
  private void clearErrorMessage()
  {
    emailEditTextView.setTextColor(getResources().getColor(2131492898));
    inlineErrorTextView.setVisibility(8);
  }
  
  private void showErrorMessage(String paramString)
  {
    inlineErrorTextView.setText(paramString);
    inlineErrorTextView.setVisibility(0);
    emailEditTextView.setTextColor(getResources().getColor(2131493054));
  }
  
  protected int layoutId()
  {
    return 2130903073;
  }
  
  public void onAttach()
  {
    super.onAttach();
    binder.bindAsyncCall(paymentService.defaultBusinessProfileChargeAccount(), new AsyncCall());
    toolbar.setTitle(getResources().getString(2131165345));
    emailEditTextView.addTextChangedListener(textChangedListener);
    String str = enterpriseService.getEmail();
    if (Strings.isNullOrEmpty(str))
    {
      Keyboard.showKeyboard(emailEditTextView);
      return;
    }
    emailEditTextView.setText(str);
  }
  
  public void onDetach()
  {
    super.onDetach();
    emailEditTextView.removeTextChangedListener(textChangedListener);
    enterpriseService.setEmail(emailEditTextView.getEditableText().toString());
  }
  
  void verifyEmail()
  {
    businessOnboardingAnalytics.initializeAddWorkEmail();
    String str = emailEditTextView.getEditableText().toString();
    if (!EmailUtils.validateEmail(str))
    {
      businessOnboardingAnalytics.trackAddWorkEmailFailure();
      showErrorMessage(getResources().getString(2131165351));
      return;
    }
    progressController.disableUI();
    progressController.showProgress();
    binder.bindAsyncCall(enterpriseService.updateUserOrganization(str), new EmailInputController.1(this));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.business.onboard.EmailInputController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */