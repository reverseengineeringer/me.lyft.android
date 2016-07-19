package me.lyft.android.ui.driver.ridescreens;

import android.content.res.Resources;
import android.text.Html;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
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
import me.lyft.android.driver.service.IPreloadStaticMapService;
import me.lyft.android.flows.ProfileFlow;
import me.lyft.android.infrastructure.location.ILocationService;
import me.lyft.android.navigation.Navigator;
import me.lyft.android.rx.ReactiveProperty;
import me.lyft.android.rx.RxUIBinder;
import me.lyft.android.ui.HeightObservableLayout;
import me.lyft.android.ui.IProgressController;
import me.lyft.android.ui.IViewErrorHandler;
import me.lyft.android.ui.UserImageView;
import me.lyft.android.ui.driver.DriverActionsCallback;
import me.lyft.android.ui.driver.DriverActiveRideZoomingController;
import me.lyft.android.ui.driver.DriverAddressInfoView;
import me.lyft.android.ui.driver.DriverDialogs.NavigationDialog;
import me.lyft.android.ui.ride.RideMap;
import me.lyft.android.ui.tooltips.TooltipContainerView;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;
import rx.subscriptions.Subscriptions;

public class DriverRidePickedUpController
  extends RxViewController
{
  DriverAddressInfoView addressInfoAndEtaView;
  @Inject
  AppFlow appFlow;
  TextView bannerTextView;
  View bottomButtonContainer;
  @Inject
  MessageBus bus;
  @Inject
  IConstantsProvider constantsProvider;
  private ReactiveProperty<DriverStop> currentStopChangeSubject = ReactiveProperty.create();
  private ReactiveProperty<Location> destinationSubject = ReactiveProperty.create();
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
  private ReactiveProperty<Boolean> isCourier = ReactiveProperty.create();
  private Observable<Boolean> isDestinationNullObservable = destinationSubject.map(new DriverRidePickedUpController.1(this));
  @Inject
  ILocationService locationService;
  @Inject
  ILyftPreferences lyftPreferences;
  private Subscription mapTransitionSubscription = Subscriptions.empty();
  @Inject
  Navigator navigator;
  private Action1<Unit> onMapLoaded = new DriverRidePickedUpController.9(this);
  private Action1<Unit> onRideDropoffConfirmationResult = new DriverRidePickedUpController.11(this);
  private Action1<DriverRide> onRouteUpdated = new DriverRidePickedUpController.10(this);
  UserImageView passengerPhotoImageView;
  @Inject
  IPreloadStaticMapService preloadStaticMapService;
  @Inject
  ProfileFlow profileFlow;
  @Inject
  IProgressController progressController;
  private ReactiveProperty<String> rideIdChange = ReactiveProperty.create();
  @Inject
  RideMap rideMap;
  private ReactiveProperty<String> rideStatusChange = ReactiveProperty.create();
  @Inject
  IDriverRideProvider routeProvider;
  TooltipContainerView tooltipContainer;
  private ReactiveProperty<String> userImageChangeSubject = ReactiveProperty.create();
  @Inject
  IViewErrorHandler viewErrorHandler;
  
  private void displayDropoffAddress(DriverStop paramDriverStop)
  {
    Location localLocation = paramDriverStop.getLocation();
    DriverAddressInfoView localDriverAddressInfoView = addressInfoAndEtaView;
    if (localLocation.isNull()) {}
    for (paramDriverStop = Html.fromHtml(getResources().getString(2131166138));; paramDriverStop = "")
    {
      localDriverAddressInfoView.setHint(paramDriverStop);
      addressInfoAndEtaView.setPickupIcon(2130838456);
      binder.bindAsyncCall(geoService.reverseGeocode(localLocation), new DriverRidePickedUpController.7(this));
      return;
    }
  }
  
  private void displayDropoffNavigation(DriverStop paramDriverStop)
  {
    if ((lyftPreferences.getRideFlags().isDropoffMessageShown()) || (!paramDriverStop.isDropOff())) {
      return;
    }
    setDropoffMessageShown();
    if ((!routeProvider.getDriverRide().isCourier()) || (!lyftPreferences.isAutoNavigationEnabled()))
    {
      dialogFlow.show(new DriverDialogs.NavigationDialog());
      return;
    }
    binder.bindAsyncCall(locationService.getLastLocation(), new DriverRidePickedUpController.6(this, paramDriverStop));
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
  
  private void endRide()
  {
    progressController.disableUI();
    binder.bindAsyncCall(driverRouteService.dropOff(routeProvider.getDriverRide().getCurrentPassenger()), new DriverActionsCallback(progressController, viewErrorHandler));
  }
  
  private void setDropoffMessageShown()
  {
    RideFlags localRideFlags = lyftPreferences.getRideFlags();
    localRideFlags.setDropoffMessageShown(true);
    lyftPreferences.setRideFlags(localRideFlags);
  }
  
  private void showBanner()
  {
    String str = routeProvider.getDriverRide().getBannerText();
    TextView localTextView = bannerTextView;
    if ((!Strings.isNullOrEmpty(str)) && (routeProvider.getDriverRide().isAccepted())) {}
    for (int i = 0;; i = 8)
    {
      localTextView.setVisibility(i);
      bannerTextView.setText(str);
      return;
    }
  }
  
  private void showTooltips()
  {
    if (!routeProvider.getDriverRide().showHints()) {
      return;
    }
    tooltipContainer.hideAll();
    tooltipContainer.tryToShowAndMarkShown("dropoff_button", bottomButtonContainer, 48);
  }
  
  private void transitionMapToPassengerDropoff(DriverStop paramDriverStop)
  {
    mapTransitionSubscription.unsubscribe();
    if (!routeProvider.getDriverRide().isCourier())
    {
      DriverRidePassenger localDriverRidePassenger = routeProvider.getDriverRide().getCurrentPassenger();
      rideMap.showPickupMarker(routeProvider.getDriverRide().findPickupStopForPassenger(localDriverRidePassenger.getId()).getLocation());
      rideMap.showDestinationMarker(routeProvider.getDriverRide().findDropoffStopForPassenger(localDriverRidePassenger.getId()).getLocation());
    }
    rideMap.clearRoutes();
    mapTransitionSubscription = binder.bindAsyncCall(locationService.getLastLocation(), new DriverRidePickedUpController.8(this, paramDriverStop));
  }
  
  private void updatePassengerLocation()
  {
    if ((routeProvider.getDriverRide().isInProgress()) && (routeProvider.getDriverRide().getCurrentStop().isPickup()))
    {
      if (!routeProvider.getDriverRide().getCurrentStop().getPassenger().getLocation().isNull()) {
        rideMap.showPassengerLocation();
      }
    }
    else {
      return;
    }
    rideMap.clearPassengerLocation();
  }
  
  void displayPassengerNameAndRating()
  {
    DriverRidePassenger localDriverRidePassenger = routeProvider.getDriverRide().getCurrentPassenger();
    userImageChangeSubject.onNext(localDriverRidePassenger.getPhotoUrl());
    passengerPhotoImageView.setUserPartySize(Integer.valueOf(localDriverRidePassenger.getPartySize()));
    driverRideButtonTextView.setText(getResources().getString(2131165632, new Object[] { localDriverRidePassenger.getFirstName() }));
  }
  
  protected int layoutId()
  {
    return 2130903191;
  }
  
  public void onAttach()
  {
    super.onAttach();
    driverActiveRideZoomingController.attach(followCurrentLocationButton);
    passengerPhotoImageView.loadPhoto(routeProvider.getDriverRide().getCurrentPassenger().getPhotoUrl());
    displayPassengerNameAndRating();
    passengerPhotoImageView.setOnClickListener(new DriverRidePickedUpController.2(this));
    driverRideButtonTextView.setOnClickListener(new DriverRidePickedUpController.3(this));
    addressInfoAndEtaView.setEditAddressClickListener(new DriverRidePickedUpController.4(this));
    addressInfoAndEtaView.setNavigationClickListener(new DriverRidePickedUpController.5(this));
    binder.bindAction(rideMap.observeMapLoaded(), onMapLoaded);
    preloadStaticMapService.preloadNavigationMaps();
  }
  
  public void onDetach()
  {
    super.onDetach();
    rideMap.clearAllMarkers();
    rideMap.clearRoutes();
    rideMap.reset();
    driverActiveRideZoomingController.detach();
    setDropoffMessageShown();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.driver.ridescreens.DriverRidePickedUpController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */