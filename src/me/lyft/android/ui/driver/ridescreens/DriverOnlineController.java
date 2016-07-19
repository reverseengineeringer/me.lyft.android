package me.lyft.android.ui.driver.ridescreens;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.jakewharton.rxrelay.BehaviorRelay;
import com.lyft.rx.MessageBus;
import javax.inject.Inject;
import me.lyft.android.application.constants.Constants;
import me.lyft.android.application.constants.IConstantsProvider;
import me.lyft.android.application.driver.IDailyTotalsRepository;
import me.lyft.android.application.driver.IDriverDestinationService;
import me.lyft.android.application.features.IFeaturesProvider;
import me.lyft.android.application.geo.IGeoService;
import me.lyft.android.application.ride.IDestinyService;
import me.lyft.android.common.AppFlow;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.common.RxViewController;
import me.lyft.android.common.Strings;
import me.lyft.android.common.Unit;
import me.lyft.android.controls.DriverToolbar;
import me.lyft.android.domain.driver.DriverOverflowMenuDisplayManager;
import me.lyft.android.domain.location.Location;
import me.lyft.android.domain.payment.Money;
import me.lyft.android.errorhandling.IDefaultErrorHandler;
import me.lyft.android.infrastructure.location.ILocationService;
import me.lyft.android.rx.RxUIBinder;
import me.lyft.android.services.HeatMapService;
import me.lyft.android.ui.Dialogs.AlertDialog;
import me.lyft.android.ui.HeightObservableLayout;
import me.lyft.android.ui.SlideMenuController;
import me.lyft.android.ui.dialogs.DialogResult;
import me.lyft.android.ui.dialogs.Toast;
import me.lyft.android.ui.ride.RideMap;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;
import rx.subscriptions.Subscriptions;

public class DriverOnlineController
  extends RxViewController
{
  private static final int DEFAULT_ZOOM_LEVEL = 12;
  private static final int ZOOM_CACHE_KILL_THRESHOLD = 1;
  private final AppFlow appFlow;
  private final IConstantsProvider constantsProvider;
  private final IDailyTotalsRepository dailyTotalsRepository;
  private final IDefaultErrorHandler defaultErrorHandler;
  TextView destinyAddressTextView;
  TextView destinyBottom;
  View destinyDividerView;
  private final IDestinyService destinyService;
  FrameLayout destinyTop;
  private final DialogFlow dialogFlow;
  Button driverDailyTotalButtonView;
  private final IDriverDestinationService driverDestinationService;
  private final DriverOverflowMenuDisplayManager driverOverflowMenuDisplayManager;
  HeightObservableLayout driverRideBottom;
  HeightObservableLayout driverRideTop;
  LinearLayout editDestinyAddressView;
  ImageView exitDestinyButton;
  private final IFeaturesProvider featuresProvider;
  ImageButton followCurrentLocationButton;
  private final IGeoService geoService;
  private final HeatMapService heatMapService;
  LinearLayout heatmapHeader;
  private Observable<Boolean> heatmapPrimeTimeHasRangeObservable = heatmapPrimeTimeRateChange.map(new DriverOnlineController.1(this));
  TextView heatmapPrimeTimeRate;
  private BehaviorRelay<String> heatmapPrimeTimeRateChange = BehaviorRelay.create();
  private Action1<String> heatmapPrimeTimeRateChangeCallback = new DriverOnlineController.8(this);
  private final ILocationService locationService;
  private final MessageBus messageBus;
  private Subscription nearbyDriversUpdateSubscription = Subscriptions.empty();
  private Action1<Float> onCameraZoomChanged = new DriverOnlineController.7(this);
  private Action1<Location> onDriverDestinationChanged = new DriverOnlineController.6(this);
  private View.OnClickListener onFollowCurrentLocationClicked = new DriverOnlineController.18(this);
  private Action1<String> onHeatMapMetaDataChanged = new DriverOnlineController.9(this);
  private Action1<Unit> onMapDragStart = new DriverOnlineController.10(this);
  private Action1<Unit> onMapLoaded = new DriverOnlineController.4(this);
  private Action1<DialogResult> onTurnOffDestinyConfirmation = new DriverOnlineController.5(this);
  private final RideMap rideMap;
  private final SlideMenuController slideMenuController;
  DriverToolbar toolbar;
  
  @Inject
  public DriverOnlineController(HeatMapService paramHeatMapService, AppFlow paramAppFlow, DialogFlow paramDialogFlow, RideMap paramRideMap, SlideMenuController paramSlideMenuController, IDailyTotalsRepository paramIDailyTotalsRepository, IDriverDestinationService paramIDriverDestinationService, IGeoService paramIGeoService, IConstantsProvider paramIConstantsProvider, IDestinyService paramIDestinyService, MessageBus paramMessageBus, ILocationService paramILocationService, IDefaultErrorHandler paramIDefaultErrorHandler, IFeaturesProvider paramIFeaturesProvider, DriverOverflowMenuDisplayManager paramDriverOverflowMenuDisplayManager)
  {
    heatMapService = paramHeatMapService;
    appFlow = paramAppFlow;
    dialogFlow = paramDialogFlow;
    rideMap = paramRideMap;
    slideMenuController = paramSlideMenuController;
    dailyTotalsRepository = paramIDailyTotalsRepository;
    driverDestinationService = paramIDriverDestinationService;
    geoService = paramIGeoService;
    constantsProvider = paramIConstantsProvider;
    destinyService = paramIDestinyService;
    messageBus = paramMessageBus;
    locationService = paramILocationService;
    defaultErrorHandler = paramIDefaultErrorHandler;
    featuresProvider = paramIFeaturesProvider;
    driverOverflowMenuDisplayManager = paramDriverOverflowMenuDisplayManager;
  }
  
  private void addTileOverlay()
  {
    rideMap.removeHeatmap();
    rideMap.addHeatmap();
  }
  
  private void displayAddress(Location paramLocation)
  {
    String str = paramLocation.getDisplayName();
    if (Strings.isNullOrEmpty(str))
    {
      destinyAddressTextView.setText(2131165292);
      binder.bindAsyncCall(geoService.reverseGeocode(paramLocation), new DriverOnlineController.15(this));
      return;
    }
    destinyAddressTextView.setText(str);
  }
  
  private void exitDestinyMode()
  {
    binder.bindAsyncCall(destinyService.exitDestiny(), new DriverOnlineController.16(this));
  }
  
  private void followCurrentLocation()
  {
    followCurrentLocationButton.setSelected(true);
    rideMap.followCurrentLocation();
  }
  
  private void hideDestiny()
  {
    if (driverOverflowMenuDisplayManager.enableShowOverflowMenu()) {
      toolbar.showOverflowMenu();
    }
    toolbar.hideDivider();
    destinyTop.setVisibility(8);
    destinyBottom.setVisibility(8);
  }
  
  private void initializeDriverDestination()
  {
    String str = (String)constantsProvider.get(Constants.DESTINY_MATCHING_LABEL_TEXT, getResources().getString(2131165585));
    destinyBottom.setText(str);
    destinyBottom.setOnClickListener(new DriverOnlineController.11(this));
    editDestinyAddressView.setOnClickListener(new DriverOnlineController.12(this));
    exitDestinyButton.setOnClickListener(new DriverOnlineController.13(this));
  }
  
  private void observeHeaderChanges()
  {
    Observable.combineLatest(heatmapPrimeTimeHasRangeObservable, driverDestinationService.observeDriverDestination(), new DriverOnlineController.17(this));
  }
  
  private void showDestiny()
  {
    toolbar.hideOverflowMenu();
    toolbar.showDivider();
    destinyTop.setVisibility(0);
    destinyBottom.setVisibility(0);
  }
  
  private void showDestinyTurnoffDialog()
  {
    Dialogs.AlertDialog localAlertDialog = new Dialogs.AlertDialog("destiny_turnoff_dialog").setButtonsOrientation(Integer.valueOf(1)).setTitle(getResources().getString(2131165678)).setTitleColorResource(2131492898).addPositiveButton(getResources().getString(2131165677), 2130903157).addNegativeButton(getResources().getString(2131165564)).setDialogEventClass(DriverOnlineController.DestinyConfirmationResultEvent.class);
    dialogFlow.show(localAlertDialog);
  }
  
  private void unfollowCurrentLocation()
  {
    followCurrentLocationButton.setSelected(false);
    rideMap.unfollowCurrentLocation();
  }
  
  private void updateDriverDestinationWithNewLocation(Location paramLocation1, Location paramLocation2)
  {
    if ((!paramLocation1.isNull()) && (paramLocation2.isNull()))
    {
      paramLocation1 = (String)constantsProvider.get(Constants.DESTINY_ENDED_MODAL_TEXT, getResources().getString(2131165553));
      dialogFlow.show(new Toast(paramLocation1));
    }
    displayAddress(paramLocation2);
    rideMap.clearAllMarkers();
    rideMap.clearRoutes();
    if (!paramLocation2.isNull())
    {
      rideMap.showDestinationMarker(paramLocation2);
      binder.bindAsyncCall(locationService.getLastLocation(), new DriverOnlineController.14(this, paramLocation2));
    }
  }
  
  protected int layoutId()
  {
    return 2130903175;
  }
  
  public void onAttach()
  {
    super.onAttach();
    slideMenuController.enableMenu();
    nearbyDriversUpdateSubscription.unsubscribe();
    rideMap.clearDriverMarkers();
    heatMapService.start();
    addTileOverlay();
    followCurrentLocationButton.setOnClickListener(onFollowCurrentLocationClicked);
    unfollowCurrentLocation();
    heatmapHeader.setOnClickListener(new DriverOnlineController.2(this));
    driverDailyTotalButtonView.setText(dailyTotalsRepository.getDailyTotal().format());
    driverDailyTotalButtonView.setOnClickListener(new DriverOnlineController.3(this));
    initializeDriverDestination();
    binder.bindAction(rideMap.observeMapLoaded(), onMapLoaded);
  }
  
  public void onDetach()
  {
    super.onDetach();
    heatMapService.stop();
    rideMap.removeHeatmap();
    rideMap.clearDriverMarkers();
    rideMap.clearRoutes();
    rideMap.clearPickupMarker();
    rideMap.clearDestinationMarker();
    rideMap.reset();
    slideMenuController.disableMenu();
    unfollowCurrentLocation();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.driver.ridescreens.DriverOnlineController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */