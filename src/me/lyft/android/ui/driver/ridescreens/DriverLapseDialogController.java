package me.lyft.android.ui.driver.ridescreens;

import android.content.res.Resources;
import android.view.View;
import com.lyft.scoop.HandleBack;
import javax.inject.Inject;
import me.lyft.android.analytics.core.ActionAnalytics;
import me.lyft.android.analytics.core.events.ActionEvent.Action;
import me.lyft.android.application.ride.IUserDispatchService;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.rx.RxUIBinder;
import me.lyft.android.ui.IProgressController;
import me.lyft.android.ui.dialogs.StandardDialogController;

public class DriverLapseDialogController
  extends StandardDialogController
  implements HandleBack
{
  private final ActionAnalytics analytics = new ActionAnalytics(ActionEvent.Action.DRIVER_LAPSE_SIGN_OUT_ALERT);
  private final IProgressController progressController;
  private final IUserDispatchService userModeService;
  
  @Inject
  public DriverLapseDialogController(IUserDispatchService paramIUserDispatchService, IProgressController paramIProgressController, DialogFlow paramDialogFlow)
  {
    super(paramDialogFlow);
    userModeService = paramIUserDispatchService;
    progressController = paramIProgressController;
  }
  
  private void goBackOnlineButtonClick()
  {
    progressController.showProgress();
    binder.bindAsyncCall(userModeService.switchToDispatchable(true), new DriverLapseDialogController.3(this));
  }
  
  public void onAttach()
  {
    super.onAttach();
    analytics.trackInitiation();
    getView().setOnClickListener(null);
    setHeaderGraphic(2130838378);
    setHeaderText(getResources().getString(2131165610), 2131493111);
    setContentMessage(getResources().getString(2131165609));
    showCloseButton().setOnClickListener(new DriverLapseDialogController.1(this));
    addPositiveButton(2130903156, getResources().getString(2131165611).toUpperCase(), new DriverLapseDialogController.2(this));
  }
  
  public boolean onBack()
  {
    analytics.trackFailure();
    return false;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.driver.ridescreens.DriverLapseDialogController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */