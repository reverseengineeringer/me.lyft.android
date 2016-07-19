package me.lyft.android.ui.driver.ridescreens;

import android.content.res.Resources;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import com.jakewharton.rxrelay.BehaviorRelay;
import com.lyft.rx.MessageBus;
import java.util.List;
import javax.inject.Inject;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.RideFlags;
import me.lyft.android.application.constants.IConstantsProvider;
import me.lyft.android.application.geo.IGeoService;
import me.lyft.android.application.ride.IDriverRideProvider;
import me.lyft.android.application.ride.IDriverRouteService;
import me.lyft.android.common.AppFlow;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.common.RxViewController;
import me.lyft.android.common.Strings;
import me.lyft.android.common.Unit;
import me.lyft.android.domain.driver.ride.DriverRide;
import me.lyft.android.domain.driver.ride.DriverRidePassenger;
import me.lyft.android.domain.driver.ride.DriverStop;
import me.lyft.android.domain.location.Location;
import me.lyft.android.domain.time.Time;
import me.lyft.android.driver.service.IPreloadStaticMapService;
import me.lyft.android.flows.ProfileFlow;
import me.lyft.android.infrastructure.location.ILocationService;
import me.lyft.android.maps.renderers.PinTextRenderer;
import me.lyft.android.navigation.Navigator;
import me.lyft.android.rx.RxUIBinder;
import me.lyft.android.ui.Dialogs.AlertDialog;
import me.lyft.android.ui.HeightObservableLayout;
import me.lyft.android.ui.IProgressController;
import me.lyft.android.ui.IViewErrorHandler;
import me.lyft.android.ui.UserImageView;
import me.lyft.android.ui.dialogs.DialogResult;
import me.lyft.android.ui.dialogs.Toast;
import me.lyft.android.ui.driver.DriverActionsCallback;
import me.lyft.android.ui.driver.DriverActiveRideZoomingController;
import me.lyft.android.ui.driver.DriverAddressInfoView;
import me.lyft.android.ui.driver.DriverDialogs.CourierDriverInfoDialog;
import me.lyft.android.ui.driver.DriverDialogs.NavigationDialog;
import me.lyft.android.ui.ride.RideMap;
import me.lyft.android.ui.tooltips.TooltipContainerView;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;
import rx.subscriptions.Subscriptions;

public class DriverRideAcceptedController
  extends RxViewController
{
  private static final String ARRIVED_REASON_OTHER = "other";
  private static final String ARRIVED_REASON_PASSENGER_IN_CAR = "passengerInCar";
  private static final String ARRIVED_REASON_WRONG_ADDRESS_SHOWN = "wrongAddressShown";
  DriverAddressInfoView addressInfoAndEtaView;
  @Inject
  AppFlow appFlow;
  TextView bannerTextView;
  View bottomButtonContainer;
  @Inject
  MessageBus bus;
  @Inject
  IConstantsProvider constantsProvider;
  private BehaviorRelay<DriverStop> currentStopChangeSubject = BehaviorRelay.create();
  @Inject
  DialogFlow dialogFlow;
  @Inject
  DriverActiveRideZoomingController driverActiveRideZoomingController;
  HeightObservableLayout driverRideBottom;
  TextView driverRideButtonTextView;
  HeightObservableLayout driverRideTop;
  @Inject
  IDriverRouteService driverRouteService;
  ImageButton followCurrentLocationButton;
  @Inject
  IGeoService geoService;
  private BehaviorRelay<Boolean> inGeoFenceChange = BehaviorRelay.create();
  private BehaviorRelay<List<DriverStop>> incompleteStopsSubject = BehaviorRelay.create();
  @Inject
  ILocationService locationService;
  @Inject
  ILyftPreferences lyftPreferences;
  private Subscription mapTransitionSubscription = Subscriptions.empty();
  @Inject
  Navigator navigator;
  private Action1<Boolean> onGeofenceChanged = new DriverRideAcceptedController.10(this);
  private Action1<DialogResult> onLocationIssueDialogResult = new DriverRideAcceptedController.11(this);
  private Action1<Unit> onMapLoaded = new DriverRideAcceptedController.8(this);
  private Action1<Unit> onRideArrivalConfirmationResult = new DriverRideAcceptedController.12(this);
  private Action1<DriverRide> onRouteUpdated = new DriverRideAcceptedController.9(this);
  UserImageView passengerPhotoImageView;
  @Inject
  PinTextRenderer pinTextRenderer;
  @Inject
  IPreloadStaticMapService preloadStaticMapService;
  @Inject
  ProfileFlow profileFlow;
  @Inject
  IProgressController progressController;
  private BehaviorRelay<String> rideIdChange = BehaviorRelay.create();
  @Inject
  RideMap rideMap;
  @Inject
  IDriverRideProvider routeProvider;
  TooltipContainerView tooltipContainer;
  private BehaviorRelay<String> userImageChangeSubject = BehaviorRelay.create();
  @Inject
  IViewErrorHandler viewErrorHandler;
  
  private void displayPickupAddress(DriverStop paramDriverStop)
  {
    Location localLocation = paramDriverStop.getLocation();
    addressInfoAndEtaView.setPickupIcon(2130838457);
    paramDriverStop = paramDriverStop.getScheduledTime();
    if (!paramDriverStop.isNull()) {
      addressInfoAndEtaView.setScheduledPickupTime(paramDriverStop.formatTime());
    }
    binder.bindAsyncCall(geoService.reverseGeocode(localLocation), new DriverRideAcceptedController.6(this));
  }
  
  private void displayPickupNavigation(DriverStop paramDriverStop)
  {
    if ((lyftPreferences.getRideFlags().isPickupMessageShown()) || (!paramDriverStop.isPickup()) || (paramDriverStop.isInGeofence())) {
      return;
    }
    setPickupMessageShown();
    if (!lyftPreferences.isAutoNavigationEnabled())
    {
      dialogFlow.show(new DriverDialogs.NavigationDialog());
      return;
    }
    binder.bindAsyncCall(locationService.getLastLocation(), new DriverRideAcceptedController.5(this, paramDriverStop));
  }
  
  private void displayPickupPin()
  {
    Location localLocation;
    if (!routeProvider.getDriverRide().isCourier())
    {
      Object localObject = routeProvider.getDriverRide().getCurrentStop();
      localLocation = ((DriverStop)localObject).getLocation();
      localObject = ((DriverStop)localObject).getScheduledTime();
      if (!((Time)localObject).isNull()) {
        pinTextRenderer.createPickupPin(localLocation, getResources().getString(2131165618), ((Time)localObject).formatTime(), getResources().getDimensionPixelSize(2131230746), false);
      }
    }
    else
    {
      return;
    }
    rideMap.showPickupMarker(localLocation);
  }
  
  private void displayRoute(Location paramLocation, int paramInt1, int paramInt2)
  {
    List localList = routeProvider.getDriverRide().createWaypoints();
    localList.add(0, paramLocation);
    if (routeProvider.getDriverRide().isCourier())
    {
      rideMap.showLineDriverRoute(localList, paramInt1, paramInt2);
      return;
    }
    rideMap.showDriverRoute(localList, paramInt1);
  }
  
  private boolean isFirstStop()
  {
    return routeProvider.getDriverRide().getStopsFromCurrentRoute().indexOf(routeProvider.getDriverRide().getCurrentStop()) == 0;
  }
  
  private void resolveButtonColor()
  {
    int i;
    if (routeProvider.getDriverRide().isCourier()) {
      i = 2130837615;
    }
    for (;;)
    {
      driverRideButtonTextView.setBackgroundDrawable(getResources().getDrawable(i));
      return;
      if (routeProvider.getDriverRide().isPlus()) {
        i = 2130837585;
      } else {
        i = 2130837588;
      }
    }
  }
  
  private void resolveButtonText()
  {
    String str = routeProvider.getDriverRide().getCurrentPassenger().getFirstName();
    driverRideButtonTextView.setText(getResources().getString(2131165626, new Object[] { str }));
  }
  
  private void setPickupMessageShown()
  {
    RideFlags localRideFlags = lyftPreferences.getRideFlags();
    localRideFlags.setPickupMessageShown(true);
    lyftPreferences.setRideFlags(localRideFlags);
  }
  
  private void showBanner()
  {
    String str = routeProvider.getDriverRide().getBannerText();
    TextView localTextView = bannerTextView;
    if (!Strings.isNullOrEmpty(str)) {}
    for (int i = 0;; i = 8)
    {
      localTextView.setVisibility(i);
      bannerTextView.setText(str);
      return;
    }
  }
  
  private void showTapToArriveConfirmation()
  {
    Dialogs.AlertDialog localAlertDialog = new Dialogs.AlertDialog("tap_to_arrive_confirmation_dialog");
    localAlertDialog.setTitle(getResources().getString(2131165571)).setTitleColorResource(2131493111).setMessage(getResources().getString(2131165570)).setMessageFontSize(getResources().getDimension(2131230749)).setDialogEventClass(DriverRideAcceptedController.DriverLocationIssueDialogResultEvent.class).setButtonsOrientation(Integer.valueOf(1));
    if (routeProvider.getDriverRide().isCourier()) {}
    for (int i = 2130903154;; i = 2130903156)
    {
      localAlertDialog.addButton(2131558442, getResources().getString(2131165568), i).addButton(2131558444, getResources().getString(2131165573), i).addButton(2131558443, getResources().getString(2131165572), i);
      localAlertDialog.addNegativeButton(getResources().getString(2131165358));
      dialogFlow.show(localAlertDialog);
      return;
    }
  }
  
  private void showTooltips()
  {
    if (!routeProvider.getDriverRide().showHints()) {
      return;
    }
    tooltipContainer.hideAll();
    if (routeProvider.getDriverRide().getCurrentStop().isInGeofence())
    {
      tooltipContainer.tryToShowAndMarkShown("arrive_button", bottomButtonContainer, 48);
      return;
    }
    addressInfoAndEtaView.showTooltip(tooltipContainer);
  }
  
  private void startRide(String paramString)
  {
    progressController.disableUI();
    if (routeProvider.getDriverRide().isCourier())
    {
      if ((!isFirstStop()) || (lyftPreferences.decrementCourierDriverOnboardView().intValue() <= 0)) {
        break label106;
      }
      dialogFlow.show(new DriverDialogs.CourierDriverInfoDialog());
    }
    for (;;)
    {
      binder.bindAsyncCall(driverRouteService.arrive(routeProvider.getDriverRide().getCurrentStop(), paramString), new DriverActionsCallback(progressController, viewErrorHandler));
      return;
      label106:
      dialogFlow.show(new Toast(getResources().getString(2131165615)));
    }
  }
  
  private void transitionMapToPassengerPickup(DriverStop paramDriverStop)
  {
    mapTransitionSubscription.unsubscribe();
    rideMap.clearPickupMarker();
    rideMap.clearDestinationMarker();
    rideMap.clearRoutes();
    displayPickupPin();
    mapTransitionSubscription = binder.bindAsyncCall(locationService.getLastLocation(), new DriverRideAcceptedController.7(this));
  }
  
  private void updatePassengerLocation()
  {
    if (!routeProvider.getDriverRide().getCurrentStop().getPassenger().getLocation().isNull())
    {
      rideMap.showPassengerLocation();
      return;
    }
    rideMap.clearPassengerLocation();
  }
  
  private Observable<Unit> updateRoutesObservable()
  {
    return incompleteStopsSubject.map(Unit.func1());
  }
  
  void displayPassengerNameAndRating()
  {
    userImageChangeSubject.call(routeProvider.getDriverRide().getCurrentPassenger().getPhotoUrl());
    passengerPhotoImageView.setUserPartySize(Integer.valueOf(routeProvider.getDriverRide().getCurrentPassenger().getPartySize()));
    resolveButtonColor();
    resolveButtonText();
  }
  
  protected int layoutId()
  {
    return 2130903185;
  }
  
  public void onAttach()
  {
    super.onAttach();
    driverActiveRideZoomingController.attach(followCurrentLocationButton);
    displayPassengerNameAndRating();
    passengerPhotoImageView.loadPhoto(routeProvider.getDriverRide().getCurrentPassenger().getPhotoUrl());
    passengerPhotoImageView.setOnClickListener(new DriverRideAcceptedController.1(this));
    driverRideButtonTextView.setOnClickListener(new DriverRideAcceptedController.2(this));
    binder.bindAction(rideMap.observeMapLoaded(), onMapLoaded);
    preloadStaticMapService.preloadNavigationMaps();
    addressInfoAndEtaView.setEditAddressClickListener(new DriverRideAcceptedController.3(this));
    addressInfoAndEtaView.setNavigationClickListener(new DriverRideAcceptedController.4(this));
  }
  
  public void onDetach()
  {
    super.onDetach();
    rideMap.clearAllMarkers();
    rideMap.clearRoutes();
    rideMap.reset();
    driverActiveRideZoomingController.detach();
    setPickupMessageShown();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.driver.ridescreens.DriverRideAcceptedController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */