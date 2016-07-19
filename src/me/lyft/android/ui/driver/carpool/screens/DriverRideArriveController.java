package me.lyft.android.ui.driver.carpool.screens;

import android.content.res.Resources;
import javax.inject.Inject;
import me.lyft.android.application.ride.IDriverRideProvider;
import me.lyft.android.application.ride.IDriverRouteService;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.common.RxViewController;
import me.lyft.android.controls.Toolbar;
import me.lyft.android.domain.driver.ride.DriverRide;
import me.lyft.android.domain.driver.ride.DriverRidePassenger;
import me.lyft.android.rx.RxUIBinder;
import me.lyft.android.ui.HeightObservableLayout;
import me.lyft.android.ui.IProgressController;
import me.lyft.android.ui.IViewErrorHandler;
import me.lyft.android.ui.dialogs.Toast;
import me.lyft.android.ui.driver.carpool.CarpoolDriverMapController;
import me.lyft.android.ui.driver.carpool.CarpoolPassengerView;

public class DriverRideArriveController
  extends RxViewController
{
  HeightObservableLayout bottomLayout;
  CarpoolPassengerView carpoolPassengerView;
  private final DialogFlow dialogFlow;
  private final CarpoolDriverMapController mapController;
  private final IProgressController progressController;
  private final IDriverRideProvider rideProvider;
  private final IDriverRouteService routeService;
  Toolbar toolbar;
  HeightObservableLayout topLayout;
  private final IViewErrorHandler viewErrorHandler;
  
  @Inject
  public DriverRideArriveController(IProgressController paramIProgressController, IViewErrorHandler paramIViewErrorHandler, DialogFlow paramDialogFlow, IDriverRouteService paramIDriverRouteService, IDriverRideProvider paramIDriverRideProvider, CarpoolDriverMapController paramCarpoolDriverMapController)
  {
    progressController = paramIProgressController;
    viewErrorHandler = paramIViewErrorHandler;
    dialogFlow = paramDialogFlow;
    routeService = paramIDriverRouteService;
    rideProvider = paramIDriverRideProvider;
    mapController = paramCarpoolDriverMapController;
  }
  
  protected int layoutId()
  {
    return 2130903187;
  }
  
  public void onArrivedClicked()
  {
    String str = rideProvider.getDriverRide().getCurrentPassenger().getFirstName();
    progressController.showProgress();
    binder.bindAsyncCall(routeService.arrive(rideProvider.getDriverRide().getCurrentStop(), null), new DriverRideArriveController.3(this, str));
  }
  
  public void onAttach()
  {
    super.onAttach();
    binder.bindAction(mapController.observeMapLoaded(topLayout.observeHeightChange(), bottomLayout.observeHeightChange()), new DriverRideArriveController.1(this));
    toolbar.hideHomeIcon().showLogo().addItem(2131558403, 2130838160);
    toolbar.setOnItemClickAction(new DriverRideArriveController.2(this));
    carpoolPassengerView.showContactButtons();
    carpoolPassengerView.showPickupMessage();
  }
  
  public void showArriveSent(String paramString)
  {
    dialogFlow.show(new Toast(getResources().getString(2131165965, new Object[] { paramString })));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.driver.carpool.screens.DriverRideArriveController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */