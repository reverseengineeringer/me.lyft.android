package me.lyft.android.ui.passenger.v2.inride;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.lyft.scoop.HandleBack;
import com.lyft.scoop.Screen;
import com.lyft.scoop.dagger.DaggerInjector;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import me.lyft.android.analytics.EditPickupAnalytics;
import me.lyft.android.application.features.IFeaturesProvider;
import me.lyft.android.application.geo.IGeoService;
import me.lyft.android.application.passenger.IPassengerRideProvider;
import me.lyft.android.application.passenger.IPassengerRideService;
import me.lyft.android.application.ride.IRideSession;
import me.lyft.android.common.AppFlow;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.common.Unit;
import me.lyft.android.domain.location.Location;
import me.lyft.android.domain.location.SphericalUtils;
import me.lyft.android.domain.passenger.ride.PassengerRide;
import me.lyft.android.domain.passenger.ride.PickupGeofence;
import me.lyft.android.infrastructure.location.ILocationService;
import me.lyft.android.maps.MapOwner;
import me.lyft.android.maps.renderers.DriverCarRenderer;
import me.lyft.android.maps.renderers.PassengerDestinationPinRenderer;
import me.lyft.android.maps.renderers.PickupGeofenceRenderer;
import me.lyft.android.maps.renderers.passenger.routing.PassengerRouteRenderer;
import me.lyft.android.rx.Binder;
import me.lyft.android.ui.HeightObservableLayout;
import me.lyft.android.ui.dialogs.Toast;
import me.lyft.android.ui.passenger.PassengerScreens.PassengerEditPickup;
import me.lyft.android.ui.placesearch.PlaceSearchScreens.EditPickupPlaceSearch;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;
import rx.subscriptions.Subscriptions;

public class EditPickupInRideView
  extends FrameLayout
  implements HandleBack
{
  public static final int DELAY = 1000;
  public static final String EMPTY_TEXT = "";
  @Inject
  AppFlow appFlow;
  private Binder binder;
  View changingPickupProgressbar;
  @Inject
  DialogFlow dialogFlow;
  @Inject
  DriverCarRenderer driverCarRenderer;
  @Inject
  EditPickupAnalytics editPickupAnalytics;
  @Inject
  IFeaturesProvider featuresProvider;
  @Inject
  IGeoService geoService;
  private boolean isDragging;
  private boolean isFirstTime;
  private boolean isPinInCorrectLocation = true;
  @Inject
  ILocationService locationService;
  @Inject
  MapOwner mapOwner;
  FrameLayout mapPlaceholder;
  private Action1<Unit> onMapDrag = new EditPickupInRideView.6(this);
  private Action1<Unit> onMapDragEnd = new EditPickupInRideView.7(this);
  private Action1<Unit> onPinMoved = new EditPickupInRideView.4(this);
  private Action1<Integer> onScreenReady = new EditPickupInRideView.5(this);
  @Inject
  PassengerDestinationPinRenderer passengerDestinationPinRenderer;
  HeightObservableLayout passengerRideBottom;
  @Inject
  IPassengerRideProvider passengerRideProvider;
  @Inject
  IPassengerRideService passengerRideService;
  @Inject
  PassengerRouteRenderer passengerRouteRenderer;
  TextView pickupAddressField;
  private PickupGeofence pickupGeofence;
  @Inject
  PickupGeofenceRenderer pickupGeofenceRenderer;
  ImageView pickupPin;
  private Drawable pinDrawable;
  private Drawable pinErrorDrawable;
  private Subscription reverseGeocodeSubscription = Subscriptions.empty();
  @Inject
  IRideSession rideSession;
  Button setPickupButton;
  
  public EditPickupInRideView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = (PassengerScreens.PassengerEditPickup)Screen.fromView(this);
    isFirstTime = paramContext.isFirstTime();
    paramContext.setFirstTime(false);
    DaggerInjector.fromView(this).inject(this);
  }
  
  private Observable<Unit> centerTo(Location paramLocation)
  {
    return mapOwner.centerWithPadding(paramLocation, pickupGeofence.getZoomLevel());
  }
  
  private void reverseGeocode(Location paramLocation)
  {
    reverseGeocodeSubscription.unsubscribe();
    reverseGeocodeSubscription = binder.bind(geoService.reverseGeocode(paramLocation), new EditPickupInRideView.8(this));
  }
  
  private void setInitialLocation()
  {
    Location localLocation = rideSession.getPickupLocation();
    boolean bool = pickupGeofence.contains(localLocation);
    if (bool)
    {
      pickupAddressField.setText(localLocation.getDisplayName());
      centerTo(localLocation);
    }
    for (;;)
    {
      if (rideSession.hasPickupChanged())
      {
        editPickupAnalytics.trackPinMoveStartedFromPlaceSearch();
        double d = SphericalUtils.computeDistanceBetween(pickupGeofence.getCenter(), localLocation);
        editPickupAnalytics.trackPinMoveEndedFromPlaceSearch(bool, (int)d);
      }
      return;
      rideSession.resetPickup();
      pickupAddressField.setText(rideSession.getPickupLocation().getDisplayName());
      binder.bind(centerTo(localLocation).delay(1000L, TimeUnit.MILLISECONDS), new EditPickupInRideView.3(this));
    }
  }
  
  private void setPickupButtonEnabled(boolean paramBoolean)
  {
    Object localObject = changingPickupProgressbar;
    int i;
    Button localButton;
    if (paramBoolean)
    {
      i = 8;
      ((View)localObject).setVisibility(i);
      setPickupButton.setEnabled(paramBoolean);
      localButton = setPickupButton;
      if (!paramBoolean) {
        break label58;
      }
    }
    label58:
    for (localObject = getResources().getString(2131166302);; localObject = "")
    {
      localButton.setText((CharSequence)localObject);
      return;
      i = 0;
      break;
    }
  }
  
  private boolean shouldShowRouteLines()
  {
    PassengerRide localPassengerRide = passengerRideProvider.getPassengerRide();
    return (localPassengerRide.isCourier()) || (!localPassengerRide.isQueued());
  }
  
  private void showToast()
  {
    Toast localToast = new Toast(getResources().getString(2131165297));
    localToast.setBottomPadding(passengerRideBottom.getHeight());
    dialogFlow.show(localToast);
  }
  
  private void updatePickupPin(boolean paramBoolean)
  {
    ImageView localImageView;
    if (isPinInCorrectLocation != paramBoolean)
    {
      localImageView = pickupPin;
      if (!paramBoolean) {
        break label33;
      }
    }
    label33:
    for (Drawable localDrawable = pinDrawable;; localDrawable = pinErrorDrawable)
    {
      localImageView.setImageDrawable(localDrawable);
      isPinInCorrectLocation = paramBoolean;
      return;
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (isInEditMode()) {
      return;
    }
    mapOwner.attach(mapPlaceholder);
    binder = Binder.attach(this);
    pickupGeofence = passengerRideProvider.getPickupGeofence();
    binder.bind(mapOwner.observeCameraPositionChanged(), onPinMoved);
    binder.bind(mapOwner.observeMapDrag(), onMapDrag);
    binder.bind(mapOwner.observeMapDragEnd(), onMapDragEnd);
    binder.bind(passengerRideBottom.observeHeightChange(), onScreenReady);
  }
  
  public boolean onBack()
  {
    onBackClick();
    return true;
  }
  
  void onBackClick()
  {
    rideSession.resetPickup();
    appFlow.goBack();
    dialogFlow.dismiss();
  }
  
  void onCenterToCurrentLocationButtonClick()
  {
    binder.bind(locationService.getLastLocation(), new EditPickupInRideView.2(this));
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    pickupGeofenceRenderer.clear();
    driverCarRenderer.clear();
    passengerRouteRenderer.clear();
    passengerDestinationPinRenderer.clear();
    mapOwner.detach();
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    if (isInEditMode()) {
      return;
    }
    ButterKnife.bind(this);
    pinDrawable = getResources().getDrawable(2130838461);
    pinErrorDrawable = getResources().getDrawable(2130838460);
    setPickupButton.setText(2131166302);
  }
  
  void onPickupAddressFieldClick()
  {
    dialogFlow.dismiss();
    appFlow.goTo(new PlaceSearchScreens.EditPickupPlaceSearch());
  }
  
  void onSetPickupButtonClick()
  {
    if (!rideSession.hasPickupChanged())
    {
      appFlow.goBack();
      return;
    }
    setPickupButtonEnabled(false);
    Location localLocation = rideSession.getPickupLocation();
    binder.bind(passengerRideService.changePickup(localLocation), new EditPickupInRideView.1(this));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.passenger.v2.inride.EditPickupInRideView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */