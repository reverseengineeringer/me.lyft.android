package me.lyft.android.ui.driver;

import android.content.res.Resources;
import com.lyft.scoop.Screen;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import me.lyft.android.application.ride.ICancellationOptionsProvider;
import me.lyft.android.application.ride.IDriverRideProvider;
import me.lyft.android.application.ride.IDriverRouteService;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.domain.driver.ride.DriverRide;
import me.lyft.android.domain.driver.ride.DriverRidePassenger;
import me.lyft.android.domain.ride.CancellationOption;
import me.lyft.android.rx.RxUIBinder;
import me.lyft.android.ui.IProgressController;
import me.lyft.android.ui.IViewErrorHandler;
import me.lyft.android.ui.dialogs.StandardDialogController;

public class CarpoolDriverCancellationDialogController
  extends StandardDialogController
{
  private final ICancellationOptionsProvider cancellationOptionsProvider;
  private final IDriverRideProvider driverRideProvider;
  private final IDriverRouteService driverRouteService;
  private final IProgressController progressController;
  private final IViewErrorHandler viewErrorHandler;
  
  @Inject
  public CarpoolDriverCancellationDialogController(DialogFlow paramDialogFlow, IDriverRideProvider paramIDriverRideProvider, IProgressController paramIProgressController, ICancellationOptionsProvider paramICancellationOptionsProvider, IDriverRouteService paramIDriverRouteService, IViewErrorHandler paramIViewErrorHandler)
  {
    super(paramDialogFlow);
    driverRideProvider = paramIDriverRideProvider;
    progressController = paramIProgressController;
    cancellationOptionsProvider = paramICancellationOptionsProvider;
    driverRouteService = paramIDriverRouteService;
    viewErrorHandler = paramIViewErrorHandler;
  }
  
  private void addCancelReasonButton(CancellationOption paramCancellationOption)
  {
    addPositiveButton(2130903157, paramCancellationOption.getString(), new CarpoolDriverCancellationDialogController.1(this, paramCancellationOption));
  }
  
  private void cancelRide(CancellationOption paramCancellationOption)
  {
    progressController.disableUI();
    binder.bindAsyncCall(driverRouteService.cancelRoute(paramCancellationOption), new CarpoolDriverCancellationDialogController.2(this));
  }
  
  public void onAttach()
  {
    super.onAttach();
    Object localObject = (DriverDialogs.CarpoolDriverCancellationDialog)Screen.fromController(this);
    localObject = driverRideProvider.getDriverRide().getCurrentPassenger().getFirstName();
    setContentTitle(getResources().getString(2131165380, new Object[] { localObject }));
    localObject = cancellationOptionsProvider.getCancellationOptions().iterator();
    while (((Iterator)localObject).hasNext()) {
      addCancelReasonButton((CancellationOption)((Iterator)localObject).next());
    }
    addNegativeButton(2130903152, getResources().getString(2131165381), getDismissListener());
  }
  
  public int viewId()
  {
    return 2131558412;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.driver.CarpoolDriverCancellationDialogController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */