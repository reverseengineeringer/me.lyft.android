package me.lyft.android.ui.passenger.v2.pending;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import butterknife.ButterKnife;
import com.lyft.scoop.dagger.DaggerInjector;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.application.drivers.INearbyDriversService;
import me.lyft.android.application.geo.IGeoService;
import me.lyft.android.application.passenger.IPassengerRideProvider;
import me.lyft.android.application.requestridetypes.IRideTypeMetaService;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.common.Objects;
import me.lyft.android.common.Unit;
import me.lyft.android.domain.location.Location;
import me.lyft.android.domain.passenger.ride.Driver;
import me.lyft.android.domain.passenger.ride.PassengerRide;
import me.lyft.android.domain.passenger.ride.RideFeature;
import me.lyft.android.infrastructure.location.ILocationService;
import me.lyft.android.rx.Binder;
import me.lyft.android.ui.HeightObservableLayout;
import me.lyft.android.ui.SlideMenuController;
import me.lyft.android.ui.passenger.MatchingStartTime;
import me.lyft.android.ui.passenger.v2.PassengerMapController;
import me.lyft.android.ui.passenger.v2.PassengerRideRouter;
import rx.Observable;
import rx.functions.Action1;
import rx.subjects.BehaviorSubject;

public class CourierMatchingView
  extends RelativeLayout
{
  private Binder binder;
  @Inject
  DialogFlow dialogFlow;
  @Inject
  IGeoService geoService;
  @Inject
  ILocationService locationService;
  MatchingFooterView matchingFooterView;
  @Inject
  INearbyDriversService nearbyDriversService;
  private final Action1<Unit> onMapLoaded = new CourierMatchingView.5(this);
  private final Action1<Unit> onRefreshNearbyDrivers = new CourierMatchingView.6(this);
  private final Action1<Unit> onRideUpdate = new CourierMatchingView.7(this);
  @Inject
  PassengerMapController passengerMapController;
  HeightObservableLayout passengerRideBottom;
  @Inject
  IPassengerRideProvider passengerRideProvider;
  @Inject
  PassengerRideRouter passengerRideRouter;
  @Inject
  ILyftPreferences preferences;
  @Inject
  IRideTypeMetaService rideTypeMetaService;
  @Inject
  SlideMenuController slideMenuController;
  
  public CourierMatchingView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
  }
  
  private Observable<Long> getCachedDriverETAObservable(PassengerRide paramPassengerRide)
  {
    return geoService.getDriverEta(paramPassengerRide.getId(), paramPassengerRide.getDriver().getLocation(), new Location[] { paramPassengerRide.getPickup() });
  }
  
  private long getMatchingStartTime(String paramString)
  {
    MatchingStartTime localMatchingStartTime2 = preferences.getPassengerMatchingStartTime();
    MatchingStartTime localMatchingStartTime1 = localMatchingStartTime2;
    if (!Objects.equals(localMatchingStartTime2.getRideId(), paramString))
    {
      localMatchingStartTime1 = new MatchingStartTime(paramString);
      preferences.setPassengerMatchingStartTime(localMatchingStartTime1);
    }
    return localMatchingStartTime1.getStartTime();
  }
  
  private void setupMatchingFooterView()
  {
    PassengerRide localPassengerRide = passengerRideProvider.getPassengerRide();
    matchingFooterView.setPickupLocation(localPassengerRide.getPickup());
    matchingFooterView.setDestinationLocation(localPassengerRide.getDropoff());
    matchingFooterView.setWaitTimeInMillis(TimeUnit.SECONDS.toMillis(localPassengerRide.getWaitEstimateInSec()), getMatchingStartTime(localPassengerRide.getId()));
    List localList = rideTypeMetaService.findMatchingStringsByRideType(localPassengerRide.getRideType());
    matchingFooterView.setRotatingMessages(localList);
    matchingFooterView.setIsRealTimeMatching(localPassengerRide.isRealTimeMatching());
    if (localPassengerRide.isFeatureEnabled(RideFeature.PASSENGER_CANCEL)) {}
    for (int i = 0;; i = 8)
    {
      matchingFooterView.setCancelRideButtonVisibility(i);
      return;
    }
  }
  
  private void updateDestinationPin(PassengerRide paramPassengerRide)
  {
    passengerMapController.showDropoffMarker(paramPassengerRide.getDropoff());
  }
  
  private void updatePinETA(PassengerRide paramPassengerRide)
  {
    binder.bind(getCachedDriverETAObservable(paramPassengerRide), new CourierMatchingView.8(this, paramPassengerRide));
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (isInEditMode()) {
      return;
    }
    slideMenuController.enableMenu();
    binder = Binder.attach(this);
    setupMatchingFooterView();
    binder.bind(passengerMapController.observeMapLoaded(), onMapLoaded);
    binder.bind(passengerMapController.observeAndApplyPaddingChanges(BehaviorSubject.create(Integer.valueOf(getResources().getDimensionPixelSize(2131230823))), passengerRideBottom.observeHeightChange()), new CourierMatchingView.4(this));
    binder.bind(nearbyDriversService.observeDriverUpdated(), onRefreshNearbyDrivers);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    slideMenuController.disableMenu();
    passengerMapController.clearAllMarkers();
    passengerMapController.clearRoutes();
    passengerMapController.reset();
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    if (isInEditMode()) {
      return;
    }
    ButterKnife.bind(this);
    matchingFooterView.setPickupAddressClickListener(new CourierMatchingView.1(this));
    matchingFooterView.setDestinationAddressClickListener(new CourierMatchingView.2(this));
    matchingFooterView.setCancelRideButtonClickListener(new CourierMatchingView.3(this));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.passenger.v2.pending.CourierMatchingView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */