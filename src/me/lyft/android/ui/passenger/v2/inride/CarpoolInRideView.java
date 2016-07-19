package me.lyft.android.ui.passenger.v2.inride;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import butterknife.ButterKnife;
import com.lyft.scoop.dagger.DaggerInjector;
import javax.inject.Inject;
import me.lyft.android.analytics.EditPickupAnalytics;
import me.lyft.android.application.geo.IGeoService;
import me.lyft.android.application.passenger.IPassengerRideProvider;
import me.lyft.android.common.AppFlow;
import me.lyft.android.common.Unit;
import me.lyft.android.domain.location.Location;
import me.lyft.android.domain.passenger.ride.Driver;
import me.lyft.android.domain.passenger.ride.PassengerRide;
import me.lyft.android.domain.passenger.ride.PassengerStop;
import me.lyft.android.domain.ride.RideStatus;
import me.lyft.android.domain.time.Time;
import me.lyft.android.logging.L;
import me.lyft.android.maps.renderers.PinTextRenderer;
import me.lyft.android.rx.Binder;
import me.lyft.android.ui.HeightObservableLayout;
import me.lyft.android.ui.SlideMenuController;
import me.lyft.android.ui.passenger.PassengerActiveRideZoomingController;
import me.lyft.android.ui.passenger.v2.PassengerMapController;
import rx.Observable;
import rx.functions.Action1;
import rx.subjects.BehaviorSubject;

public class CarpoolInRideView
  extends LinearLayout
{
  public static final String EMPTY_DRIVER_STATUS = null;
  @Inject
  AppFlow appFlow;
  private Binder binder;
  ImageButton centerToCurrentLocationButton;
  @Inject
  EditPickupAnalytics editPickupAnalytics;
  @Inject
  IGeoService geoService;
  private final Action1<Driver> onDriverChange = new CarpoolInRideView.4(this);
  private final Action1<Unit> onMapLoaded = new CarpoolInRideView.2(this);
  private final Action1<Unit> onRideUpdated = new CarpoolInRideView.3(this);
  @Inject
  PassengerActiveRideZoomingController passengerActiveRideZoomingController;
  @Inject
  PassengerMapController passengerMapController;
  HeightObservableLayout passengerRideBottom;
  @Inject
  IPassengerRideProvider passengerRideProvider;
  HeightObservableLayout passengerRideTop;
  @Inject
  PinTextRenderer pinTextRenderer;
  RideFooterView rideFooterView;
  @Inject
  SlideMenuController slideMenuController;
  
  public CarpoolInRideView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
  }
  
  private Observable<Long> getCachedDriverETAObservable(PassengerRide paramPassengerRide)
  {
    return geoService.getDriverEta(paramPassengerRide.getId(), paramPassengerRide.getDriver().getLocation(), new Location[] { paramPassengerRide.getPickup() });
  }
  
  private void updateDriverDetails()
  {
    Driver localDriver = passengerRideProvider.getPassengerRide().getDriver();
    rideFooterView.updateDriver(localDriver);
  }
  
  private void updateMapMarkers(PassengerRide paramPassengerRide)
  {
    PassengerStop localPassengerStop = paramPassengerRide.getIncompletedPickupStop();
    if (localPassengerStop.isCompleted()) {
      passengerMapController.clearPickupMarker();
    }
    for (;;)
    {
      localPassengerStop = paramPassengerRide.getIncompletedDropoffStop();
      if (!localPassengerStop.getScheduledTime().isNull()) {
        break;
      }
      passengerMapController.showDropoffMarker(localPassengerStop.getLocation());
      return;
      if (localPassengerStop.getScheduledTime().isNull())
      {
        passengerMapController.showPickupMarker(localPassengerStop.getLocation());
      }
      else
      {
        String str1 = getContext().getString(2131166136, new Object[] { localPassengerStop.getScheduledTime().formatDay() });
        String str2 = localPassengerStop.getScheduledTime().formatTime();
        passengerMapController.showPickupMarkerWithSchedule(localPassengerStop.getLocation(), str1, str2);
      }
    }
    if (paramPassengerRide.getStatus().isAcknowledged()) {}
    for (paramPassengerRide = getResources().getString(2131165663);; paramPassengerRide = getResources().getString(2131165664))
    {
      int i = getResources().getDimensionPixelSize(2131230744);
      pinTextRenderer.createDestinationPin(localPassengerStop.getLocation(), paramPassengerRide, localPassengerStop.getScheduledTime().formatTime(), i, false);
      return;
    }
  }
  
  private void updateMatchedRideBannerMessage(PassengerRide paramPassengerRide)
  {
    rideFooterView.setBannerMessage(getResources().getString(2131165964));
    rideFooterView.setBannerMessageTextColor(2131493014);
    binder.bind(getCachedDriverETAObservable(paramPassengerRide), new CarpoolInRideView.5(this));
  }
  
  private void updateRide()
  {
    PassengerRide localPassengerRide = passengerRideProvider.getPassengerRide();
    rideFooterView.setPickupLocation(localPassengerRide.getPickup());
    rideFooterView.setDestinationLocation(localPassengerRide.getDropoff());
    if (!localPassengerRide.getStatus().isAcknowledged()) {
      passengerMapController.refreshDriverMarker();
    }
    updateRideBannerText(localPassengerRide);
    updateMapMarkers(localPassengerRide);
  }
  
  private void updateRideBannerText(PassengerRide paramPassengerRide)
  {
    if (paramPassengerRide.getStatus().isPickedUp())
    {
      rideFooterView.setBannerMessage(getResources().getString(2131165966));
      rideFooterView.setBannerMessageTextColor(2131493004);
      passengerMapController.clearPickupMarker();
      return;
    }
    if (paramPassengerRide.getStatus().isArrived())
    {
      rideFooterView.setBannerMessage(getResources().getString(2131165943));
      rideFooterView.setBannerMessageTextColor(2131493004);
      passengerMapController.clearPickupMarker();
      return;
    }
    if (paramPassengerRide.getStatus().isAcknowledged())
    {
      paramPassengerRide = paramPassengerRide.getCurrentStop().getScheduledTime();
      rideFooterView.setBannerMessage(getResources().getString(2131165961, new Object[] { paramPassengerRide.formatDay(), paramPassengerRide.formatTime() }).toUpperCase());
      rideFooterView.setBannerMessageTextColor(2131493014);
      return;
    }
    if (paramPassengerRide.getStatus().isAccepted())
    {
      updateMatchedRideBannerMessage(paramPassengerRide);
      return;
    }
    L.w("Carpool in ride banner missing", new Object[0]);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (isInEditMode()) {
      return;
    }
    slideMenuController.enableMenu();
    updateDriverDetails();
    binder = Binder.attach(this);
    binder.bind(passengerMapController.observeMapLoaded(), onMapLoaded);
    binder.bind(passengerMapController.observeAndApplyPaddingChanges(BehaviorSubject.create(Integer.valueOf(getResources().getDimensionPixelSize(2131230823))), passengerRideBottom.observeHeightChange()), new CarpoolInRideView.1(this));
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    passengerActiveRideZoomingController.detach();
    slideMenuController.disableMenu();
    passengerMapController.clearAllMarkers();
    passengerMapController.displayLocation();
    passengerMapController.reset();
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    if (isInEditMode()) {
      return;
    }
    ButterKnife.bind(this);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.passenger.v2.inride.CarpoolInRideView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */