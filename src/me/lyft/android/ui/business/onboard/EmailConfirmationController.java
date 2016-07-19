package me.lyft.android.ui.business.onboard;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import javax.inject.Inject;
import me.lyft.android.application.enterprise.IEnterpriseService;
import me.lyft.android.common.AppFlow;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.common.RxViewController;
import me.lyft.android.controls.Toolbar;
import me.lyft.android.rx.RxUIBinder;
import me.lyft.android.ui.MainScreensRouter;
import me.lyft.android.ui.business.BusinessProfileScreens.BusinessOnboardEditEmailScreen;

public class EmailConfirmationController
  extends RxViewController
{
  private final AppFlow appFlow;
  private final DialogFlow dialogFlow;
  TextView emailTextView;
  private final IEnterpriseService enterpriseService;
  private final MainScreensRouter mainScreensRouter;
  Toolbar toolbar;
  
  @Inject
  public EmailConfirmationController(AppFlow paramAppFlow, IEnterpriseService paramIEnterpriseService, DialogFlow paramDialogFlow, MainScreensRouter paramMainScreensRouter)
  {
    appFlow = paramAppFlow;
    enterpriseService = paramIEnterpriseService;
    dialogFlow = paramDialogFlow;
    mainScreensRouter = paramMainScreensRouter;
  }
  
  protected int layoutId()
  {
    return 2130903068;
  }
  
  public void onAttach()
  {
    super.onAttach();
    toolbar.setTitle(getView().getContext().getString(2131165348));
    toolbar.hideHomeIcon();
    emailTextView.setText(enterpriseService.getEmail());
  }
  
  void onDoneButtonClick()
  {
    mainScreensRouter.resetToHomeScreen();
  }
  
  void onEditEmailButtonClick()
  {
    appFlow.goTo(new BusinessProfileScreens.BusinessOnboardEditEmailScreen());
  }
  
  void onResendEmailButtonClick()
  {
    binder.bindAsyncCall(enterpriseService.updateUserOrganization(enterpriseService.getEmail()), new EmailConfirmationController.1(this));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.business.onboard.EmailConfirmationController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */