package me.lyft.android.ui.driver.carpool.screens;

import android.content.res.Resources;
import android.widget.Button;
import android.widget.TextView;
import com.lyft.rx.MessageBus;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import me.lyft.android.application.ride.IDriverRideProvider;
import me.lyft.android.application.ride.IDriverRouteService;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.common.RxViewController;
import me.lyft.android.controls.Toolbar;
import me.lyft.android.domain.driver.carpool.CarpoolInfo;
import me.lyft.android.domain.driver.ride.DriverRide;
import me.lyft.android.domain.driver.ride.DriverStop;
import me.lyft.android.domain.location.Location;
import me.lyft.android.domain.ride.RideStatus;
import me.lyft.android.domain.time.Time;
import me.lyft.android.navigation.NavigationSettings;
import me.lyft.android.navigation.Navigator;
import me.lyft.android.rx.RxUIBinder;
import me.lyft.android.ui.HeightObservableLayout;
import me.lyft.android.ui.IProgressController;
import me.lyft.android.ui.IViewErrorHandler;
import me.lyft.android.ui.driver.DriverDialogs.NavigationSelectorDialog;
import me.lyft.android.ui.driver.carpool.CarpoolDriverMapController;
import me.lyft.android.ui.driver.carpool.CarpoolPassengerView;
import me.lyft.android.ui.driver.carpool.NavigationSelectorDialogView.StartNavigationEvent;
import rx.Observable;

public class DriverRideCountdownController
  extends RxViewController
{
  HeightObservableLayout bottomLayout;
  private final MessageBus bus;
  CarpoolPassengerView carpoolPassengerView;
  private final DateFormat countdownFormat = new SimpleDateFormat("mm:ss");
  TextView countdownTextView;
  private final DialogFlow dialogFlow;
  private final IDriverRideProvider driverRideProvider;
  private final IDriverRouteService driverRouteService;
  private final CarpoolDriverMapController mapController;
  private final NavigationSettings navigationSettings;
  private final Navigator navigator;
  private final IProgressController progressController;
  TextView startDrivingLabel;
  Button startRideButton;
  Toolbar toolbar;
  HeightObservableLayout topLayout;
  private final IViewErrorHandler viewErrorHandler;
  
  @Inject
  public DriverRideCountdownController(IDriverRideProvider paramIDriverRideProvider, IDriverRouteService paramIDriverRouteService, Navigator paramNavigator, NavigationSettings paramNavigationSettings, IProgressController paramIProgressController, IViewErrorHandler paramIViewErrorHandler, DialogFlow paramDialogFlow, MessageBus paramMessageBus, CarpoolDriverMapController paramCarpoolDriverMapController)
  {
    driverRideProvider = paramIDriverRideProvider;
    driverRouteService = paramIDriverRouteService;
    navigator = paramNavigator;
    navigationSettings = paramNavigationSettings;
    progressController = paramIProgressController;
    viewErrorHandler = paramIViewErrorHandler;
    dialogFlow = paramDialogFlow;
    bus = paramMessageBus;
    mapController = paramCarpoolDriverMapController;
  }
  
  private void navigateToPickup()
  {
    Location localLocation = driverRideProvider.getDriverRide().getCurrentStop().getLocation();
    navigator.navigate(localLocation);
  }
  
  private void showLeaveAtMessage()
  {
    Time localTime = driverRideProvider.getDriverRide().getCarpoolInfo().getLeaveByTime();
    countdownTextView.setText(localTime.formatTime());
    if (localTime.isToday())
    {
      startDrivingLabel.setText(2131165410);
      return;
    }
    if (localTime.isTomorrow())
    {
      startDrivingLabel.setText(2131165411);
      return;
    }
    startDrivingLabel.setText(getResources().getString(2131165412, new Object[] { localTime.formatDayOfWeek().toUpperCase() }));
  }
  
  private void showStartDrivingMessage(long paramLong)
  {
    startDrivingLabel.setText(2131165408);
    countdownTextView.setText(countdownFormat.format(Long.valueOf(paramLong)));
    startRideButton.setText(2131165413);
  }
  
  private void startRide()
  {
    DriverRide localDriverRide = driverRideProvider.getDriverRide();
    if ((localDriverRide.getStatus().isAcknowledged()) && (localDriverRide.getCarpoolInfo().startDriving())) {}
    for (int i = 1; i == 0; i = 0)
    {
      navigateToPickup();
      return;
    }
    progressController.showProgress();
    binder.bindAsyncCall(driverRouteService.startRoute(), new DriverRideCountdownController.5(this));
  }
  
  protected int layoutId()
  {
    return 2130903190;
  }
  
  public void onAttach()
  {
    super.onAttach();
    updateCountdownTime();
    binder.bindAction(mapController.observeMapLoaded(topLayout.observeHeightChange(), bottomLayout.observeHeightChange()), new DriverRideCountdownController.1(this));
    toolbar.hideHomeIcon().showLogo().addItem(2131558403, 2130838160);
    toolbar.setOnItemClickAction(new DriverRideCountdownController.2(this));
    carpoolPassengerView.showContactButtons();
    carpoolPassengerView.showPickupMessage();
    binder.bindAction(Observable.interval(0L, 1L, TimeUnit.SECONDS), new DriverRideCountdownController.3(this));
    binder.bindAction(bus.observe(NavigationSelectorDialogView.StartNavigationEvent.class), new DriverRideCountdownController.4(this));
  }
  
  public void onRideStartClicked()
  {
    if (!navigationSettings.isDefaultNavigationSet())
    {
      dialogFlow.show(new DriverDialogs.NavigationSelectorDialog());
      return;
    }
    startRide();
  }
  
  public void showLeaveNowWarning(long paramLong)
  {
    startDrivingLabel.setText(2131165409);
    startDrivingLabel.setTextColor(getResources().getColor(2131493066));
    countdownTextView.setTextColor(getResources().getColor(2131493066));
    countdownTextView.setText(countdownFormat.format(Long.valueOf(paramLong)));
    startRideButton.setBackgroundResource(2130837598);
    startRideButton.setText(2131165413);
  }
  
  public void showLeaveSoonWarning(long paramLong)
  {
    startDrivingLabel.setText(2131165408);
    countdownTextView.setTextColor(getResources().getColor(2131493066));
    countdownTextView.setText(countdownFormat.format(Long.valueOf(paramLong)));
    startRideButton.setBackgroundResource(2130837598);
    startRideButton.setText(2131165413);
  }
  
  public void updateCountdownTime()
  {
    CarpoolInfo localCarpoolInfo = driverRideProvider.getDriverRide().getCarpoolInfo();
    if (localCarpoolInfo.leaveNow())
    {
      showLeaveNowWarning(localCarpoolInfo.getCountdownMillis());
      return;
    }
    if (localCarpoolInfo.leaveSoon())
    {
      showLeaveSoonWarning(localCarpoolInfo.getCountdownMillis());
      return;
    }
    if (localCarpoolInfo.startDriving())
    {
      showStartDrivingMessage(localCarpoolInfo.getCountdownMillis());
      return;
    }
    showLeaveAtMessage();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.driver.carpool.screens.DriverRideCountdownController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */