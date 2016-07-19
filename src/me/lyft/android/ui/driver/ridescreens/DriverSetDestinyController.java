package me.lyft.android.ui.driver.ridescreens;

import android.content.res.Resources;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import com.lyft.scoop.HandleBack;
import com.lyft.scoop.Screen;
import javax.inject.Inject;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.application.constants.IConstantsProvider;
import me.lyft.android.application.geo.IGeoService;
import me.lyft.android.application.ride.IDestinyService;
import me.lyft.android.common.AppFlow;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.common.RxViewController;
import me.lyft.android.common.Strings;
import me.lyft.android.common.Unit;
import me.lyft.android.controls.Toolbar;
import me.lyft.android.domain.location.Location;
import me.lyft.android.infrastructure.location.ILocationService;
import me.lyft.android.rx.RxUIBinder;
import me.lyft.android.ui.IProgressController;
import me.lyft.android.ui.IViewErrorHandler;
import me.lyft.android.ui.MainScreens.DriverRideScreen;
import me.lyft.android.ui.driver.DriverDialogs.DestinyInfoDialog;
import me.lyft.android.ui.placesearch.PlaceSearchScreens.DestinySearch;
import me.lyft.android.ui.ride.RideMap;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;
import rx.subscriptions.Subscriptions;

public class DriverSetDestinyController
  extends RxViewController
  implements HandleBack
{
  private static final float DEFAULT_ZOOM = 12.0F;
  private final AppFlow appFlow;
  ImageButton centerToCurrentLocationButton;
  private final IConstantsProvider constantsProvider;
  FrameLayout destinyAddressInput;
  TextView destinyAddressTextView;
  private final IDestinyService destinyService;
  private final DialogFlow dialogFlow;
  private Location driverDestination = Location.empty();
  private DriverSetDestinyScreen driverSetDestinyScreen;
  private final IGeoService geoService;
  private final ILocationService locationService;
  FrameLayout mapPlaceholder;
  private Action1<Location> onMapDragEnded = new DriverSetDestinyController.7(this);
  Action1<Unit> onMapLoaded = new DriverSetDestinyController.5(this);
  private Action1<Location> onShortcutClick = new DriverSetDestinyController.6(this);
  private Action1<Integer> onToolbarItemClicked = new DriverSetDestinyController.11(this);
  private final ILyftPreferences preferences;
  private final IProgressController progressController;
  private Subscription reverseGeocodeSubscription = Subscriptions.empty();
  private final RideMap rideMap;
  Button setDestinyButton;
  Toolbar toolbar;
  private final IViewErrorHandler viewErrorHandler;
  
  @Inject
  public DriverSetDestinyController(AppFlow paramAppFlow, IProgressController paramIProgressController, IViewErrorHandler paramIViewErrorHandler, DialogFlow paramDialogFlow, ILyftPreferences paramILyftPreferences, RideMap paramRideMap, IDestinyService paramIDestinyService, IGeoService paramIGeoService, IConstantsProvider paramIConstantsProvider, ILocationService paramILocationService)
  {
    appFlow = paramAppFlow;
    progressController = paramIProgressController;
    viewErrorHandler = paramIViewErrorHandler;
    dialogFlow = paramDialogFlow;
    preferences = paramILyftPreferences;
    rideMap = paramRideMap;
    destinyService = paramIDestinyService;
    geoService = paramIGeoService;
    constantsProvider = paramIConstantsProvider;
    locationService = paramILocationService;
  }
  
  private void exitDestinyMode()
  {
    if (driverSetDestinyScreen.isFromDispatchableScreen())
    {
      progressController.disableUI();
      destinyService.exitSetDestiny().first().subscribe(new DriverSetDestinyController.12(this));
      return;
    }
    appFlow.replaceAllWith(new Screen[] { new MainScreens.DriverRideScreen() });
  }
  
  private void geocodeAddressIfNeeded(Location paramLocation)
  {
    if (paramLocation.isNull()) {
      return;
    }
    String str = paramLocation.getDisplayName();
    if (!Strings.isNullOrEmpty(str))
    {
      destinyAddressTextView.setText(str);
      return;
    }
    destinyAddressTextView.setText(getResources().getString(2131166019));
    reverseGeocodeSubscription.unsubscribe();
    reverseGeocodeSubscription = binder.bindAsyncCall(geoService.reverseGeocode(paramLocation), new DriverSetDestinyController.8(this));
  }
  
  private void setDestinyLocation()
  {
    progressController.disableUI();
    binder.bindAsyncCall(destinyService.setDestiny(driverDestination).doOnNext(new DriverSetDestinyController.9(this)), new DriverSetDestinyController.10(this));
  }
  
  private void updateLocationFromPrevious()
  {
    binder.bindAction(locationService.getLastLocation(), new DriverSetDestinyController.4(this));
  }
  
  private void updateLocationOnMap()
  {
    rideMap.centerToLocationWithoutPadding(driverDestination);
    geocodeAddressIfNeeded(driverDestination);
    rideMap.fitMapToShortcuts(driverDestination);
  }
  
  protected int layoutId()
  {
    return 2130903195;
  }
  
  public void onAttach()
  {
    super.onAttach();
    rideMap.attach(mapPlaceholder);
    driverSetDestinyScreen = ((DriverSetDestinyScreen)Screen.fromController(this));
    driverDestination = driverSetDestinyScreen.getDriverDestination();
    destinyAddressTextView.setFocusable(true);
    destinyAddressTextView.setFocusableInTouchMode(true);
    if (!preferences.isFirstTimeDestinyInfoShown())
    {
      preferences.setFirstTimeDestinyInfoShown(true);
      dialogFlow.show(new DriverDialogs.DestinyInfoDialog());
    }
    toolbar.addItem(2131558405, 2130838160).showItem(2131558405).setTitle(getResources().getString(2131165584)).hideHomeIcon();
    destinyAddressInput.setOnClickListener(new DriverSetDestinyController.1(this));
    centerToCurrentLocationButton.setOnClickListener(new DriverSetDestinyController.2(this));
    setDestinyButton.setOnClickListener(new DriverSetDestinyController.3(this));
    binder.bindAction(rideMap.observeMapLoaded(), onMapLoaded);
    if (driverDestination.isNull())
    {
      updateLocationFromPrevious();
      return;
    }
    updateLocationOnMap();
  }
  
  public boolean onBack()
  {
    exitDestinyMode();
    return true;
  }
  
  public void onDetach()
  {
    super.onDetach();
    mapPlaceholder.removeAllViews();
    rideMap.centerMapGestures(false);
    rideMap.clearAllMarkers();
    rideMap.detach();
  }
  
  public void openPlaceSearch()
  {
    appFlow.goTo(new PlaceSearchScreens.DestinySearch(driverDestination, driverSetDestinyScreen.isFromDispatchableScreen()));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.driver.ridescreens.DriverSetDestinyController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */