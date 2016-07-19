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
import me.lyft.android.common.AppFlow;
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

public class ClassicMatchingView
  extends RelativeLayout
{
  private static final int INITIAL_ZOOM_LEVEL = 16;
  @Inject
  AppFlow appFlow;
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
  private final Action1<Unit> onMapLoaded = new ClassicMatchingView.5(this);
  private final Action1<Unit> onRefreshNearbyDrivers = new ClassicMatchingView.6(this);
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
  
  public ClassicMatchingView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
  }
  
  private Observable<Long> getCachedDriverETAObservable(PassengerRide paramPassengerRide)
  {
    return geoService.getDriverEta(paramPassengerRide.getId(), paramPassengerRide.getDriver().getLocation(), new Location[] { paramPassengerRide.getPickup() });
  }
  
  private long getMatchingStartTime()
  {
    MatchingStartTime localMatchingStartTime2 = preferences.getPassengerMatchingStartTime();
    String str = passengerRideProvider.getPassengerRide().getId();
    MatchingStartTime localMatchingStartTime1 = localMatchingStartTime2;
    if (!Objects.equals(localMatchingStartTime2.getRideId(), str))
    {
      localMatchingStartTime1 = new MatchingStartTime(str);
      preferences.setPassengerMatchingStartTime(localMatchingStartTime1);
    }
    return localMatchingStartTime1.getStartTime();
  }
  
  private void setupMatchingFooterView()
  {
    PassengerRide localPassengerRide = passengerRideProvider.getPassengerRide();
    List localList = rideTypeMetaService.findMatchingStringsByRideType(localPassengerRide.getRideType());
    matchingFooterView.setRotatingMessages(localList);
    long l = localPassengerRide.getWaitEstimateInSec();
    matchingFooterView.setWaitTimeInMillis(TimeUnit.SECONDS.toMillis(l), getMatchingStartTime());
    matchingFooterView.setIsRealTimeMatching(localPassengerRide.isRealTimeMatching());
    if (localPassengerRide.isFeatureEnabled(RideFeature.PASSENGER_CANCEL)) {}
    for (int i = 0;; i = 8)
    {
      matchingFooterView.setCancelRideButtonVisibility(i);
      return;
    }
  }
  
  private void setupRideAddressInput()
  {
    Object localObject = passengerRideProvider.getPassengerRide();
    matchingFooterView.setPickupLocation(((PassengerRide)localObject).getPickup());
    localObject = ((PassengerRide)localObject).getDropoff();
    if (!((Location)localObject).isNull()) {
      matchingFooterView.setDestinationLocation((Location)localObject);
    }
  }
  
  private void updatePinETA(PassengerRide paramPassengerRide)
  {
    binder.bind(getCachedDriverETAObservable(paramPassengerRide), new ClassicMatchingView.7(this, paramPassengerRide));
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    slideMenuController.enableMenu();
    setupRideAddressInput();
    setupMatchingFooterView();
    binder = Binder.attach(this);
    binder.bind(passengerMapController.observeMapLoaded(), onMapLoaded);
    binder.bind(passengerMapController.observeAndApplyPaddingChanges(BehaviorSubject.create(Integer.valueOf(getResources().getDimensionPixelSize(2131230823))), passengerRideBottom.observeHeightChange()), new ClassicMatchingView.4(this));
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
    ButterKnife.bind(this);
    matchingFooterView.setPickupAddressClickListener(new ClassicMatchingView.1(this));
    matchingFooterView.setDestinationAddressClickListener(new ClassicMatchingView.2(this));
    matchingFooterView.setCancelRideButtonClickListener(new ClassicMatchingView.3(this));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.passenger.v2.pending.ClassicMatchingView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */