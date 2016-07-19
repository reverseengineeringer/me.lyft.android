package me.lyft.android.ui.driver.ridescreens;

import android.content.res.Resources;
import android.graphics.Color;
import com.lyft.rx.MessageBus;
import javax.inject.Inject;
import me.lyft.android.analytics.studies.DriverAcceptAnalytics;
import me.lyft.android.analytics.studies.DriverAnalytics;
import me.lyft.android.application.geo.IEtaAnalyticService;
import me.lyft.android.application.geo.IGeoService;
import me.lyft.android.application.requestridetypes.IRideTypeMetaService;
import me.lyft.android.application.ride.IDriverRideProvider;
import me.lyft.android.application.ride.IDriverRouteService;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.common.Objects;
import me.lyft.android.common.RxViewController;
import me.lyft.android.common.Strings;
import me.lyft.android.common.Unit;
import me.lyft.android.domain.driver.ride.DriverRide;
import me.lyft.android.domain.driver.ride.DriverStop;
import me.lyft.android.domain.location.Location;
import me.lyft.android.domain.passenger.ridetypes.Style;
import me.lyft.android.domain.passenger.ridetypes.TypeInformation;
import me.lyft.android.domain.ride.RideType;
import me.lyft.android.errorhandling.IDefaultErrorHandler;
import me.lyft.android.infrastructure.location.ILocationService;
import me.lyft.android.maps.renderers.PinTextRenderer;
import me.lyft.android.rx.AsyncCall;
import me.lyft.android.rx.RxUIBinder;
import me.lyft.android.rx.ViewExtensions;
import me.lyft.android.services.TimerManager;
import me.lyft.android.ui.Dialogs.AlertDialog;
import me.lyft.android.ui.HeightObservableLayout;
import me.lyft.android.ui.IProgressController;
import me.lyft.android.ui.dialogs.DialogResult;
import me.lyft.android.ui.driver.DriverDialogs.DriverLapseDialog;
import me.lyft.android.ui.driver.DriverRideAcceptSlidableView;
import me.lyft.android.ui.ride.RideMap;
import me.lyft.android.utils.SoundManager;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.subscriptions.Subscriptions;

public class DriverRideAcceptController
  extends RxViewController
{
  public static final String TIMER_INCOMING_RIDE = "incoming_ride";
  @Inject
  MessageBus bus;
  @Inject
  IDefaultErrorHandler defaultErrorHandler;
  @Inject
  DialogFlow dialogFlow;
  DriverRideAcceptSlidableView driverRideAcceptSlidableView;
  HeightObservableLayout driverRideBottom;
  @Inject
  IDriverRouteService driverRouteService;
  @Inject
  IEtaAnalyticService etaAnalyticService;
  @Inject
  IGeoService geoService;
  @Inject
  ILocationService locationService;
  private Action1<Unit> onAcceptRide = new DriverRideAcceptController.2(this);
  private Action1<DialogResult> onDriverMissedDialogClick = new DriverRideAcceptController.1(this);
  private Action1<DriverRide> onRouteChanged = new DriverRideAcceptController.3(this);
  @Inject
  PinTextRenderer pinTextRenderer;
  @Inject
  IProgressController progressController;
  @Inject
  RideMap rideMap;
  @Inject
  IRideTypeMetaService rideTypeMetaService;
  @Inject
  IDriverRideProvider routeProvider;
  @Inject
  SoundManager soundManager;
  private final Action1<Long> timerCountdownCallback = new DriverRideAcceptController.4(this);
  @Inject
  TimerManager timerManager;
  private Subscription timerSubscription = Subscriptions.empty();
  private String triedToAcceptRideId;
  
  private void driverLapsed()
  {
    DriverAcceptAnalytics.trackMissedRequestModalDisplayed();
    Dialogs.AlertDialog localAlertDialog = new Dialogs.AlertDialog("driver_ride_lapsed_dialog").setTitle(getResources().getString(2131165636)).setMessage(getResources().getString(2131165635)).addPositiveButton(getResources().getString(2131165939));
    dialogFlow.show(localAlertDialog);
  }
  
  private void driverMissed()
  {
    Dialogs.AlertDialog localAlertDialog = new Dialogs.AlertDialog("driver_missed_ride_dialog").setIcon(Integer.valueOf(2130838378)).setTitle(getResources().getString(2131165638)).setMessage(getResources().getString(2131165637)).addButton(2131558866, getResources().getString(2131165939), 2130903155).setDialogEventClass(DriverRideAcceptController.DriverMissedResultEvent.class);
    dialogFlow.show(localAlertDialog);
  }
  
  private void initializeUIElements()
  {
    binder.bindAction(routeProvider.observeRide(), onRouteChanged);
    timerSubscription.unsubscribe();
    String str = routeProvider.getDriverRide().getCurrentRideId();
    long l = routeProvider.getDriverRide().getLapseTimerSeconds();
    timerSubscription = binder.bindAction(timerManager.getTimer("incoming_ride", str, Long.valueOf(l).longValue()).observeOn(AndroidSchedulers.mainThread()), timerCountdownCallback);
    updateEta();
    updateSlidableDriverAcceptViewUI();
  }
  
  private void lapseRoute()
  {
    driverRouteService.lapseRoute(triedToAcceptCurrentRoute()).observeOn(AndroidSchedulers.mainThread()).subscribe(new AsyncCall());
    onRouteLapsed();
  }
  
  private void onRouteLapsed()
  {
    
    if (routeProvider.getDriverRide().isSignOutOnLapse()) {
      dialogFlow.show(new DriverDialogs.DriverLapseDialog());
    }
    for (;;)
    {
      driverRouteService.clearRoute();
      return;
      if (triedToAcceptCurrentRoute()) {
        driverLapsed();
      } else {
        driverMissed();
      }
    }
  }
  
  private void setRideMapBottomPadding()
  {
    DriverRide localDriverRide = routeProvider.getDriverRide();
    if ((Strings.isNullOrEmpty(localDriverRide.getBannerText())) || (localDriverRide.isTrainingRide()))
    {
      rideMap.setTopAndBottomPadding(getResources().getDimensionPixelSize(2131230823), (int)(driverRideBottom.getHeight() - getResources().getDimension(2131230885) - getResources().getDimension(2131230881)));
      return;
    }
    rideMap.setTopAndBottomPadding(getResources().getDimensionPixelSize(2131230823), (int)(driverRideBottom.getHeight() - getResources().getDimension(2131230885)));
  }
  
  private void setSlidableDriverAcceptViewStyle(DriverRide paramDriverRide)
  {
    Style localStyle = rideTypeMetaService.getStyleForRideType(paramDriverRide.getType().getType());
    paramDriverRide = rideTypeMetaService.getTypeInformationForRideType(paramDriverRide.getType().getType());
    if ((!Strings.isNullOrEmpty(localStyle.getPrimaryColor())) && (!Strings.isNullOrEmpty(paramDriverRide.getTitle())))
    {
      driverRideAcceptSlidableView.setStyle(Color.parseColor(localStyle.getPrimaryColor()), paramDriverRide.getTitle(), driverRideBottom);
      return;
    }
    driverRideAcceptSlidableView.setStyle(getResources().getColor(2131493004), getResources().getString(2131166286), driverRideBottom);
  }
  
  private boolean triedToAcceptCurrentRoute()
  {
    return Objects.equals(triedToAcceptRideId, routeProvider.getDriverRide().getCurrentRideId());
  }
  
  private void updateAddress(Location paramLocation)
  {
    int i = getResources().getDimensionPixelSize(2131230746);
    if (Strings.isNullOrEmpty(paramLocation.getDisplayName())) {
      pinTextRenderer.createPickupPin(paramLocation, null, getResources().getString(2131165292), i, false);
    }
    for (;;)
    {
      binder.bindAsyncCall(geoService.reverseGeocode(paramLocation), new DriverRideAcceptController.9(this, i));
      return;
      pinTextRenderer.createPickupPin(paramLocation, null, paramLocation.getDisplayName(), i, false);
    }
  }
  
  private void updateCountdownUI(Long paramLong1, Long paramLong2)
  {
    driverRideAcceptSlidableView.animateProgress(paramLong1);
    if (paramLong1.equals(paramLong2))
    {
      soundManager.play(4);
      return;
    }
    if (paramLong1.longValue() <= 0L)
    {
      progressController.enableUI();
      lapseRoute();
      soundManager.play(3);
      return;
    }
    soundManager.play(3);
  }
  
  private void updateEta()
  {
    binder.bindAsyncCall(locationService.getLastLocation().flatMap(new DriverRideAcceptController.6(this)), new DriverRideAcceptController.7(this));
  }
  
  private void updateMap()
  {
    Location localLocation = routeProvider.getDriverRide().getCurrentStop().getLocation();
    binder.bindAsyncCall(locationService.getLastLocation(), new DriverRideAcceptController.8(this, localLocation));
    updateAddress(localLocation);
  }
  
  private void updateSlidableDriverAcceptViewUI()
  {
    showBanner();
    setSlidableDriverAcceptViewStyle(routeProvider.getDriverRide());
    driverRideAcceptSlidableView.displayPassenger(routeProvider.getDriverRide().getCurrentPassenger());
    driverRideAcceptSlidableView.setVisibility(0);
  }
  
  public void acceptRide()
  {
    triedToAcceptRideId = routeProvider.getDriverRide().getCurrentRideId();
    progressController.showProgress();
    progressController.disableUI();
    driverRouteService.acceptRoute().subscribe(new DriverRideAcceptController.10(this));
  }
  
  protected int layoutId()
  {
    return 2130903184;
  }
  
  public void onAttach()
  {
    super.onAttach();
    DriverAcceptAnalytics.trackDriverRideAcceptV2Displayed();
    DriverAnalytics.trackIncomingRequest();
    if (dialogFlow.hasActiveDialog()) {
      dialogFlow.dismiss();
    }
    etaAnalyticService.clear();
    progressController.enableUI();
    binder.bindAction(driverRideAcceptSlidableView.observeAcceptRide(), onAcceptRide);
    binder.bindAction(bus.observe(DriverRideAcceptController.DriverMissedResultEvent.class), onDriverMissedDialogClick);
    initializeUIElements();
    binder.bindAction(ViewExtensions.onLoadedObservable(driverRideBottom), new DriverRideAcceptController.5(this));
  }
  
  public void onDetach()
  {
    super.onDetach();
    rideMap.clearPickupMarker();
    rideMap.clearDestinationMarker();
    rideMap.clearRoutes();
    rideMap.reset();
    timerSubscription.unsubscribe();
  }
  
  public void showBanner()
  {
    driverRideAcceptSlidableView.showBanner(routeProvider.getDriverRide());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.driver.ridescreens.DriverRideAcceptController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */