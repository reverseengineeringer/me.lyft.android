package me.lyft.android.ui.driver.carpool.screens;

import javax.inject.Inject;
import me.lyft.android.application.ride.IDriverRideProvider;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.common.RxViewController;
import me.lyft.android.controls.Toolbar;
import me.lyft.android.domain.driver.ride.DriverRide;
import me.lyft.android.domain.driver.ride.DriverStop;
import me.lyft.android.navigation.Navigator;
import me.lyft.android.rx.RxUIBinder;
import me.lyft.android.ui.HeightObservableLayout;
import me.lyft.android.ui.driver.carpool.CarpoolDriverMapController;
import me.lyft.android.ui.driver.carpool.CarpoolPassengerView;

public class DriverRideDropoffController
  extends RxViewController
{
  HeightObservableLayout bottomLayout;
  CarpoolPassengerView carpoolPassengerView;
  private final DialogFlow dialogFlow;
  private final CarpoolDriverMapController mapController;
  private final Navigator navigator;
  private final IDriverRideProvider rideProvider;
  Toolbar toolbar;
  HeightObservableLayout topLayout;
  
  @Inject
  public DriverRideDropoffController(Navigator paramNavigator, IDriverRideProvider paramIDriverRideProvider, DialogFlow paramDialogFlow, CarpoolDriverMapController paramCarpoolDriverMapController)
  {
    navigator = paramNavigator;
    rideProvider = paramIDriverRideProvider;
    dialogFlow = paramDialogFlow;
    mapController = paramCarpoolDriverMapController;
  }
  
  protected int layoutId()
  {
    return 2130903168;
  }
  
  public void onAttach()
  {
    super.onAttach();
    binder.bindAction(mapController.observeMapLoaded(topLayout.observeHeightChange(), bottomLayout.observeHeightChange()), new DriverRideDropoffController.1(this));
    toolbar.hideHomeIcon().showLogo().addItem(2131558403, 2130838160);
    toolbar.setOnItemClickAction(new DriverRideDropoffController.2(this));
    carpoolPassengerView.showContactButtons();
    carpoolPassengerView.showDropoffMessage();
  }
  
  public void onNavigateClicked()
  {
    navigator.navigate(rideProvider.getDriverRide().getCurrentStop().getLocation());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.driver.carpool.screens.DriverRideDropoffController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */