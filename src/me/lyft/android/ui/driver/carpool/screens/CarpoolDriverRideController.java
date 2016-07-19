package me.lyft.android.ui.driver.carpool.screens;

import android.widget.FrameLayout;
import com.lyft.scoop.RouteChange;
import com.lyft.scoop.Screen;
import javax.inject.Inject;
import me.lyft.android.application.ride.IDriverRideProvider;
import me.lyft.android.common.AppFlow;
import me.lyft.android.common.DriverFlow;
import me.lyft.android.common.RxViewController;
import me.lyft.android.domain.driver.ride.DriverRide;
import me.lyft.android.domain.ride.RideStatus;
import me.lyft.android.rx.RxUIBinder;
import me.lyft.android.ui.MainScreens.PassengerRideScreen;
import me.lyft.android.ui.ScreensContainer;
import me.lyft.android.ui.driver.ridescreens.DriverRideCompletedScreen;
import me.lyft.android.ui.ride.RideMap;
import rx.functions.Action1;

public class CarpoolDriverRideController
  extends RxViewController
{
  @Inject
  AppFlow appFlow;
  @Inject
  DriverFlow driverFlow;
  @Inject
  IDriverRideProvider driverRideProvider;
  ScreensContainer driverScreenContainer;
  FrameLayout mapPlaceholder;
  private Action1<DriverRide> onDriverRideChanged = new CarpoolDriverRideController.2(this);
  private Action1<RouteChange> onDriverScreenChanged = new CarpoolDriverRideController.1(this);
  @Inject
  RideMap rideMap;
  
  private void updateRideView()
  {
    Object localObject = null;
    RideStatus localRideStatus = driverRideProvider.getDriverRide().getStatus();
    if (localRideStatus.isPending()) {
      localObject = new CarpoolScreens.DriverRequestsPendingScreen();
    }
    while (localObject != null)
    {
      driverFlow.show((Screen)localObject);
      return;
      if (localRideStatus.isApproaching()) {
        localObject = new CarpoolScreens.DriverRideArriveScreen();
      } else if ((localRideStatus.isAccepted()) || (localRideStatus.isAcknowledged())) {
        localObject = new CarpoolScreens.DriverRideCountdownScreen();
      } else if ((localRideStatus.isArrived()) || (localRideStatus.isPickedUp())) {
        localObject = new CarpoolScreens.DriverRideDropoffScreen();
      } else if (localRideStatus.isDroppedOff()) {
        localObject = new DriverRideCompletedScreen();
      }
    }
    appFlow.resetTo(new MainScreens.PassengerRideScreen());
  }
  
  protected int layoutId()
  {
    return 2130903089;
  }
  
  public void onAttach()
  {
    super.onAttach();
    driverFlow.dismiss();
    rideMap.attach(mapPlaceholder);
    updateRideView();
    binder.bindAction(driverFlow.observeDriverScreenChange(), onDriverScreenChanged);
    binder.bindAction(driverRideProvider.observeRide(), onDriverRideChanged);
  }
  
  public void onDetach()
  {
    super.onDetach();
    mapPlaceholder.removeAllViews();
    rideMap.detach();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.driver.carpool.screens.CarpoolDriverRideController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */