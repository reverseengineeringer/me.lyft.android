package me.lyft.android.ui.driver;

import android.content.res.Resources;
import android.widget.Button;
import android.widget.LinearLayout;
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
import rx.functions.Action1;

public class DriverCancellationConfirmationDialogViewController
  extends StandardDialogController
{
  LinearLayout cancellationOptionsContainer;
  private final ICancellationOptionsProvider cancellationOptionsProvider;
  private final DialogFlow dialogFlow;
  private final IDriverRouteService driverRouteService;
  private Action1<DriverRide> onRouteUpdated = new DriverCancellationConfirmationDialogViewController.3(this);
  private final IProgressController progressController;
  private final IDriverRideProvider routeProvider;
  private final IViewErrorHandler viewErrorHandler;
  
  @Inject
  public DriverCancellationConfirmationDialogViewController(DialogFlow paramDialogFlow, IDriverRideProvider paramIDriverRideProvider, ICancellationOptionsProvider paramICancellationOptionsProvider, IProgressController paramIProgressController, IDriverRouteService paramIDriverRouteService, IViewErrorHandler paramIViewErrorHandler)
  {
    super(paramDialogFlow);
    dialogFlow = paramDialogFlow;
    routeProvider = paramIDriverRideProvider;
    cancellationOptionsProvider = paramICancellationOptionsProvider;
    progressController = paramIProgressController;
    driverRouteService = paramIDriverRouteService;
    viewErrorHandler = paramIViewErrorHandler;
  }
  
  private void cancelRide(CancellationOption paramCancellationOption)
  {
    progressController.disableUI();
    binder.bindAsyncCall(driverRouteService.cancelRoute(paramCancellationOption), new DriverCancellationConfirmationDialogViewController.4(this));
  }
  
  private void createCancellationButtons(boolean paramBoolean)
  {
    cancellationOptionsContainer.removeAllViews();
    Iterator localIterator = cancellationOptionsProvider.getCancellationOptions().iterator();
    if (localIterator.hasNext())
    {
      Object localObject = (CancellationOption)localIterator.next();
      localObject = addPositiveButton(2130903161, ((CancellationOption)localObject).getString(), new DriverCancellationConfirmationDialogViewController.1(this, (CancellationOption)localObject));
      if (paramBoolean) {}
      for (int i = getResources().getColor(2131492898);; i = getResources().getColor(2131493054))
      {
        ((Button)localObject).setTextColor(i);
        break;
      }
    }
    addNegativeButton(2130903152, getResources().getString(2131165562), new DriverCancellationConfirmationDialogViewController.2(this));
  }
  
  private void updateHeaderView(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      setContentMessage(getResources().getString(2131165579));
      setHeaderGraphic(2130838282);
      setHeaderBackgroundColor(2131492878);
      setHeaderText(getResources().getString(2131165582), 2131492898);
      return;
    }
    setContentMessage(getResources().getString(2131165578));
    setHeaderGraphic(2130838379);
    setHeaderBackgroundColor(2131493054);
    setHeaderText(getResources().getString(2131165582), 2131493083);
  }
  
  private void updateView(DriverRide paramDriverRide)
  {
    if ((paramDriverRide.getCurrentPassenger().driverCanPenalize()) && (!paramDriverRide.isCourier())) {}
    for (boolean bool = true;; bool = false)
    {
      updateHeaderView(bool);
      createCancellationButtons(bool);
      return;
    }
  }
  
  public void onAttach()
  {
    super.onAttach();
    binder.bindAction(routeProvider.observeRide(), onRouteUpdated);
    updateView(routeProvider.getDriverRide());
  }
  
  protected int viewId()
  {
    return 2131558421;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.driver.DriverCancellationConfirmationDialogViewController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */