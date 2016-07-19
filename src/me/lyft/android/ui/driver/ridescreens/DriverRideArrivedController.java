package me.lyft.android.ui.driver.ridescreens;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.jakewharton.rxrelay.BehaviorRelay;
import com.lyft.rx.MessageBus;
import java.text.DateFormat;
import java.util.List;
import javax.inject.Inject;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.application.constants.Constants;
import me.lyft.android.application.constants.IConstantsProvider;
import me.lyft.android.application.ride.IDriverRideProvider;
import me.lyft.android.application.ride.IDriverRouteService;
import me.lyft.android.common.DateUtils;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.common.RxViewController;
import me.lyft.android.common.Strings;
import me.lyft.android.common.Unit;
import me.lyft.android.domain.driver.ride.DriverRide;
import me.lyft.android.domain.driver.ride.DriverRidePassenger;
import me.lyft.android.domain.driver.ride.DriverStop;
import me.lyft.android.domain.location.Location;
import me.lyft.android.domain.time.Time;
import me.lyft.android.flows.ProfileFlow;
import me.lyft.android.infrastructure.location.ILocationService;
import me.lyft.android.maps.renderers.PinTextRenderer;
import me.lyft.android.rx.RxUIBinder;
import me.lyft.android.services.TimerManager;
import me.lyft.android.ui.HeightObservableLayout;
import me.lyft.android.ui.IProgressController;
import me.lyft.android.ui.IViewErrorHandler;
import me.lyft.android.ui.UserImageView;
import me.lyft.android.ui.driver.DriverActionsCallback;
import me.lyft.android.ui.driver.DriverActiveRideZoomingController;
import me.lyft.android.ui.driver.DriverDialogs.SkipPassengerDialog;
import me.lyft.android.ui.ride.RideMap;
import me.lyft.android.ui.tooltips.TooltipContainerView;
import me.lyft.android.utils.Telephony;
import rx.Subscription;
import rx.functions.Action1;
import rx.subscriptions.Subscriptions;

public class DriverRideArrivedController
  extends RxViewController
{
  private static final String CONFIRMATION_COUNTDOWN_FORMAT = "m:ss";
  private static final String DRIVER_ARRIVED_COUNTDOWN_TIMER = "driver_wait_countdown";
  private static final String RIDE_AUTOSTART_COUNTDOWN_TIMER = "pay_start_countdown";
  private Subscription arrivalCountdownTimerSubscription = Subscriptions.empty();
  private Action1<Long> autostartCountdownCallback = new DriverRideArrivedController.11(this);
  private Subscription autsotartCountdownTimerSubscription = Subscriptions.empty();
  View bottomButtonContainer;
  private final MessageBus bus;
  TextView confirmPartySizeTextView;
  View confirmPickupButton;
  View confirmPickupOtherButton;
  private Action1<Long> confirmationCountdownCallback = new DriverRideArrivedController.10(this);
  private DateFormat confirmationCountdownFormatter = DateUtils.createDateFormat("m:ss");
  private final IConstantsProvider constantsProvider;
  private boolean countdownExpired;
  TextView countdownTimer;
  private final DialogFlow dialogFlow;
  private final DriverActiveRideZoomingController driverActiveRideZoomingController;
  HeightObservableLayout driverRideBottom;
  TextView driverRideButtonTextView;
  HeightObservableLayout driverRideTop;
  ImageButton followCurrentLocationButton;
  private BehaviorRelay<List<DriverStop>> incompleteStopsSubject = BehaviorRelay.create();
  private final ILocationService locationService;
  private final ILyftPreferences lyftPreferences;
  private Subscription mapTransitionSubscription = Subscriptions.empty();
  private Action1<Unit> onMapDrag = new DriverRideArrivedController.8(this);
  private Action1<Unit> onMapLoaded = new DriverRideArrivedController.7(this);
  private Action1<Unit> onNoShowConfirmationResult = new DriverRideArrivedController.13(this);
  private Action1<Integer> onPassengerSkipConfirmationResult = new DriverRideArrivedController.14(this);
  private Action1<Unit> onRideArrivalConfirmationResult = new DriverRideArrivedController.16(this);
  private Action1<Integer> onRidePartySizeChanged = new DriverRideArrivedController.15(this);
  private Action1<Integer> onRidePickupConfirmationResult = new DriverRideArrivedController.12(this);
  private Action1<DriverRide> onRouteUpdated = new DriverRideArrivedController.9(this);
  View passengerActionButton;
  ImageView passengerActionButtonOverlayView;
  TextView passengerActionButtonTextView;
  UserImageView passengerPhotoImageView;
  private final PinTextRenderer pinTextRenderer;
  private final ProfileFlow profileFlow;
  private final IProgressController progressController;
  private final RideMap rideMap;
  private BehaviorRelay<Integer> ridePartySizeChange = BehaviorRelay.create();
  private final IDriverRideProvider routeProvider;
  private final IDriverRouteService routeService;
  TextView subtitleTextView;
  private final Telephony telephony;
  TextView timeToGo;
  private final TimerManager timerManager;
  TooltipContainerView tooltipContainer;
  private BehaviorRelay<String> userImageChangeSubject = BehaviorRelay.create();
  private final IViewErrorHandler viewErrorHandler;
  
  @Inject
  public DriverRideArrivedController(IProgressController paramIProgressController, IDriverRideProvider paramIDriverRideProvider, ILyftPreferences paramILyftPreferences, ILocationService paramILocationService, MessageBus paramMessageBus, DialogFlow paramDialogFlow, RideMap paramRideMap, IViewErrorHandler paramIViewErrorHandler, ProfileFlow paramProfileFlow, IDriverRouteService paramIDriverRouteService, TimerManager paramTimerManager, Telephony paramTelephony, IConstantsProvider paramIConstantsProvider, PinTextRenderer paramPinTextRenderer, DriverActiveRideZoomingController paramDriverActiveRideZoomingController)
  {
    progressController = paramIProgressController;
    routeProvider = paramIDriverRideProvider;
    lyftPreferences = paramILyftPreferences;
    locationService = paramILocationService;
    bus = paramMessageBus;
    dialogFlow = paramDialogFlow;
    rideMap = paramRideMap;
    viewErrorHandler = paramIViewErrorHandler;
    profileFlow = paramProfileFlow;
    routeService = paramIDriverRouteService;
    timerManager = paramTimerManager;
    telephony = paramTelephony;
    constantsProvider = paramIConstantsProvider;
    pinTextRenderer = paramPinTextRenderer;
    driverActiveRideZoomingController = paramDriverActiveRideZoomingController;
  }
  
  private void displayButtonText()
  {
    String str = routeProvider.getDriverRide().getCurrentPassenger().getFirstName();
    driverRideButtonTextView.setText(getResources().getString(2131165628, new Object[] { str }));
  }
  
  private void displayCourierWaitMessage()
  {
    timeToGo.setVisibility(8);
    subtitleTextView.setText(2131165477);
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
  
  private void displayWaitInfo()
  {
    timeToGo.setVisibility(8);
    Time localTime = routeProvider.getDriverRide().getCurrentStop().getScheduledTime();
    if (localTime.isNull())
    {
      subtitleTextView.setText(getResources().getString(2131165642, new Object[] { routeProvider.getDriverRide().getCurrentPassenger().getFirstName() }));
      return;
    }
    subtitleTextView.setText(getResources().getString(2131165619, new Object[] { routeProvider.getDriverRide().getCurrentPassenger().getFirstName(), localTime.formatTime() }));
  }
  
  private void displayWaitingCompensationInfo()
  {
    timeToGo.setVisibility(8);
    String str = Strings.firstNonEmpty(new String[] { (String)constantsProvider.get(Constants.DRIVER_PAY_STARTED_MESSAGE), getResources().getString(2131165641) });
    subtitleTextView.setText(str);
  }
  
  private void hideRideButton()
  {
    driverRideButtonTextView.animate().translationX(driverRideButtonTextView.getWidth());
    confirmPickupButton.startAnimation(AnimationUtils.loadAnimation(getView().getContext(), 2130968582));
    confirmPickupOtherButton.startAnimation(AnimationUtils.loadAnimation(getView().getContext(), 2130968583));
  }
  
  private void onPartySizeConfirmed(int paramInt)
  {
    if (paramInt > routeProvider.getDriverRide().getCurrentPassenger().getPartySize())
    {
      dialogFlow.show(new DriverDialogs.SkipPassengerDialog(routeProvider.getDriverRide().getCurrentPassenger(), Integer.valueOf(paramInt)));
      return;
    }
    pickupPassengerWithPartySize(paramInt);
  }
  
  private void pickupPassenger()
  {
    binder.bindAsyncCall(routeService.pickup(routeProvider.getDriverRide().getCurrentPassenger()), new DriverActionsCallback(progressController, viewErrorHandler));
  }
  
  private void pickupPassengerWithPartySize(int paramInt)
  {
    progressController.disableUI();
    binder.bindAsyncCall(routeService.pickup(routeProvider.getDriverRide().getCurrentPassenger(), paramInt), new DriverActionsCallback(progressController, viewErrorHandler));
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
  
  private void resolvePassengerActionButtonTextAndIcon()
  {
    String str = routeProvider.getDriverRide().getCurrentPassenger().getFirstName();
    int j;
    if (routeProvider.getDriverRide().isCourier())
    {
      str = getResources().getString(2131165640);
      j = 2130838444;
    }
    for (int i = 2130837610;; i = 2130837600)
    {
      passengerActionButton.setBackgroundResource(i);
      passengerActionButtonOverlayView.setBackgroundResource(j);
      passengerActionButtonTextView.setText(str);
      return;
      str = getResources().getString(2131165355, new Object[] { str });
      j = 2130838307;
    }
  }
  
  private void setupTimers()
  {
    countdownExpired = false;
    autsotartCountdownTimerSubscription.unsubscribe();
    autsotartCountdownTimerSubscription = binder.bindAction(timerManager.getTimer("pay_start_countdown", routeProvider.getDriverRide().getCurrentPassenger().getRideId(), routeProvider.getDriverRide().getPayStartSeconds()), autostartCountdownCallback);
    arrivalCountdownTimerSubscription.unsubscribe();
    arrivalCountdownTimerSubscription = binder.bindAction(timerManager.getTimer("driver_wait_countdown", routeProvider.getDriverRide().getCurrentPassenger().getRideId(), routeProvider.getDriverRide().getDriverWaitSeconds()), confirmationCountdownCallback);
  }
  
  private void showCallForAction()
  {
    if (routeProvider.getDriverRide().isCourier())
    {
      timeToGo.setVisibility(0);
      subtitleTextView.setText(2131166361);
      return;
    }
    timeToGo.setVisibility(8);
    subtitleTextView.setText(getResources().getString(2131165639, new Object[] { routeProvider.getDriverRide().getCurrentPassenger().getFirstName() }));
  }
  
  private void showRideButton()
  {
    driverRideButtonTextView.animate().translationX(0.0F);
    confirmPickupButton.startAnimation(AnimationUtils.loadAnimation(getView().getContext(), 2130968580));
    confirmPickupOtherButton.startAnimation(AnimationUtils.loadAnimation(getView().getContext(), 2130968581));
  }
  
  private void showTooltips()
  {
    if (!routeProvider.getDriverRide().showHints()) {
      return;
    }
    tooltipContainer.tryToShowAndMarkShown("pickup_button", bottomButtonContainer, 48);
    tooltipContainer.tryToShowAndMarkShown("timer_started", driverRideTop, 48);
  }
  
  private void skipNoShow()
  {
    progressController.disableUI();
    binder.bindAsyncCall(routeService.skipNoShow(routeProvider.getDriverRide().getCurrentPassenger()), new DriverActionsCallback(progressController, viewErrorHandler));
  }
  
  private void skipWrongPartySize(Integer paramInteger)
  {
    progressController.disableUI();
    binder.bindAsyncCall(routeService.skipWrongPartySize(routeProvider.getDriverRide().getCurrentPassenger(), paramInteger.intValue()), new DriverActionsCallback(progressController, viewErrorHandler));
  }
  
  private void transitionMapToPassengerPickup(DriverStop paramDriverStop)
  {
    mapTransitionSubscription.unsubscribe();
    rideMap.clearPickupMarker();
    rideMap.clearDestinationMarker();
    rideMap.clearRoutes();
    if (!routeProvider.getDriverRide().isCourier())
    {
      Object localObject = routeProvider.getDriverRide().findPickupStopForPassenger(routeProvider.getDriverRide().getCurrentPassenger().getId());
      paramDriverStop = ((DriverStop)localObject).getLocation();
      localObject = ((DriverStop)localObject).getScheduledTime();
      if (((Time)localObject).isNull()) {
        break label152;
      }
      pinTextRenderer.createPickupPin(paramDriverStop, getResources().getString(2131165618), ((Time)localObject).formatTime(), getResources().getDimensionPixelSize(2131230746), false);
    }
    for (;;)
    {
      mapTransitionSubscription = binder.bindAsyncCall(locationService.getLastLocation(), new DriverRideArrivedController.6(this));
      return;
      label152:
      rideMap.showPickupMarker(paramDriverStop);
    }
  }
  
  private void updatePassengerLocation(DriverRide paramDriverRide)
  {
    if ((paramDriverRide.isInProgress()) && (paramDriverRide.getCurrentStop().isPickup()))
    {
      if (!paramDriverRide.getCurrentStop().getPassenger().getLocation().isNull()) {
        rideMap.showPassengerLocation();
      }
    }
    else {
      return;
    }
    rideMap.clearPassengerLocation();
  }
  
  protected int layoutId()
  {
    return 2130903188;
  }
  
  public void onAttach()
  {
    super.onAttach();
    driverActiveRideZoomingController.attach(followCurrentLocationButton);
    passengerPhotoImageView.loadPhoto(routeProvider.getDriverRide().getCurrentPassenger().getPhotoUrl());
    passengerPhotoImageView.setUserPartySize(Integer.valueOf(routeProvider.getDriverRide().getCurrentPassenger().getPartySize()));
    displayButtonText();
    passengerPhotoImageView.setOnClickListener(new DriverRideArrivedController.1(this));
    driverRideButtonTextView.setOnClickListener(new DriverRideArrivedController.2(this));
    confirmPickupButton.setOnClickListener(new DriverRideArrivedController.3(this));
    confirmPickupOtherButton.setOnClickListener(new DriverRideArrivedController.4(this));
    passengerActionButton.setOnClickListener(new DriverRideArrivedController.5(this));
    displayButtonText();
    resolveButtonColor();
    resolvePassengerActionButtonTextAndIcon();
    showTooltips();
    setupTimers();
    binder.bindAction(rideMap.observeMapLoaded(), onMapLoaded);
  }
  
  public void onDetach()
  {
    super.onDetach();
    rideMap.clearAllMarkers();
    rideMap.clearRoutes();
    rideMap.reset();
    driverActiveRideZoomingController.detach();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.driver.ridescreens.DriverRideArrivedController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */