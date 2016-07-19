package me.lyft.android.ui.passenger.v2.inride;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import butterknife.ButterKnife;
import com.lyft.scoop.dagger.DaggerInjector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.analytics.EditPickupAnalytics;
import me.lyft.android.analytics.core.ExperimentAnalytics;
import me.lyft.android.analytics.core.definitions.Experiment;
import me.lyft.android.application.features.Features;
import me.lyft.android.application.features.IFeaturesProvider;
import me.lyft.android.application.geo.IGeoService;
import me.lyft.android.application.passenger.IPassengerRideProvider;
import me.lyft.android.application.tooltip.ITooltipService;
import me.lyft.android.common.AppFlow;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.common.Unit;
import me.lyft.android.controls.PassengerToolbar;
import me.lyft.android.domain.location.Location;
import me.lyft.android.domain.passenger.ride.Driver;
import me.lyft.android.domain.passenger.ride.PassengerRide;
import me.lyft.android.domain.passenger.ride.PassengerRidePassenger;
import me.lyft.android.domain.passenger.ride.PassengerStop;
import me.lyft.android.domain.passenger.ride.PassengerStops;
import me.lyft.android.domain.passenger.ride.RideFeature;
import me.lyft.android.domain.ride.RideStatus;
import me.lyft.android.domain.time.Time;
import me.lyft.android.domain.tooltips.Tooltip;
import me.lyft.android.logging.L;
import me.lyft.android.maps.markers.PickupPinMarker;
import me.lyft.android.rx.Binder;
import me.lyft.android.ui.Dialogs.EditPickupOnboardingDialog;
import me.lyft.android.ui.HeightObservableLayout;
import me.lyft.android.ui.SlideMenuController;
import me.lyft.android.ui.passenger.PassengerActiveRideZoomingController;
import me.lyft.android.ui.passenger.v2.PassengerAnalytics;
import me.lyft.android.ui.passenger.v2.PassengerMapController;
import me.lyft.android.ui.passenger.v2.PassengerRideRouter;
import me.lyft.android.ui.tooltips.TooltipContainerView;
import rx.Observable;
import rx.functions.Action1;
import rx.subjects.BehaviorSubject;

public class CourierInRideView
  extends FrameLayout
{
  @Inject
  AppFlow appFlow;
  private Binder binder;
  ImageButton centerToCurrentLocationButton;
  @Inject
  DialogFlow dialogFlow;
  @Inject
  EditPickupAnalytics editPickupAnalytics;
  @Inject
  IFeaturesProvider featuresProvider;
  @Inject
  IGeoService geoService;
  @Inject
  ILyftPreferences lyftPreferences;
  private final Action1<Unit> onMapLoaded = new CourierInRideView.3(this);
  private final Action1<Boolean> onPickupEditabilityChange = new CourierInRideView.7(this);
  private final Action1<PickupPinMarker> onPickupPinClicked = new CourierInRideView.8(this);
  private final Action1<Unit> onRideUpdated = new CourierInRideView.5(this);
  private final Action1<List<PassengerStop>> onRouteChange = new CourierInRideView.6(this);
  @Inject
  PassengerActiveRideZoomingController passengerActiveRideZoomingController;
  @Inject
  PassengerAnalytics passengerAnalytics;
  @Inject
  PassengerMapController passengerMapController;
  HeightObservableLayout passengerRideBottom;
  @Inject
  IPassengerRideProvider passengerRideProvider;
  @Inject
  PassengerRideRouter passengerRideRouter;
  RideFooterView rideFooterView;
  @Inject
  SlideMenuController slideMenuController;
  PassengerToolbar toolbar;
  TooltipContainerView tooltipContainerView;
  @Inject
  ITooltipService tooltipService;
  private final Action1<List<PassengerRidePassenger>> updateRideDetails = new CourierInRideView.4(this);
  
  public CourierInRideView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
  }
  
  private Observable<Long> getCachedDriverEtaObservable(PassengerRide paramPassengerRide)
  {
    return geoService.getDriverEta(paramPassengerRide.getId(), paramPassengerRide.getDriver().getLocation(), new Location[] { paramPassengerRide.getPickup() });
  }
  
  private Observable<Long> getCachedDriverEtdObservable(PassengerRide paramPassengerRide)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramPassengerRide.getIncompletedStops().toList().iterator();
    PassengerStop localPassengerStop;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localPassengerStop = (PassengerStop)localIterator.next();
      if (!localPassengerStop.isCompleted()) {
        localArrayList.add(localPassengerStop.getLocation());
      }
    } while ((!localPassengerStop.getPassenger().isSelf()) || (!localPassengerStop.isDropOff()));
    return geoService.getPassengerEtd(paramPassengerRide.getId(), paramPassengerRide.getDriver().getLocation(), localArrayList);
  }
  
  private void initToolbar()
  {
    toolbar.setSecondaryItem(2131558440, 2130838237);
    toolbar.setOnItemClickAction(new CourierInRideView.2(this));
  }
  
  private boolean shouldShowEditPickupOnboarding(PassengerRide paramPassengerRide)
  {
    return (paramPassengerRide.isPickupEditEnabled()) && (!lyftPreferences.wasEditPickupOnboardingShown()) && (passengerRideProvider.hasPickupGeofence()) && (paramPassengerRide.isEditPickupTooltipVisible());
  }
  
  private void showReferralTooltipIfNeeded()
  {
    if ((featuresProvider.isEnabled(Features.GIFTBOX_TOOLTIP_ENABLED)) && (!passengerRideProvider.didDisplayGiftBoxTooltip()))
    {
      ExperimentAnalytics.trackExposure(Experiment.PG_PROMOTE_GIFT_BOX);
      Tooltip localTooltip = tooltipService.getTooltip("giftbox");
      if (localTooltip != null)
      {
        tooltipContainerView.tryToShowAndMarkShown(localTooltip, findViewById(2131558440), 80);
        passengerRideProvider.setGiftBoxTooltip(true);
      }
    }
  }
  
  private void showScheduledRidesArrivedPickupPin(Location paramLocation, Time paramTime)
  {
    String str = getContext().getString(2131166136, new Object[] { paramTime.formatDay() });
    passengerMapController.showPickupMarkerWithSchedule(paramLocation, str, paramTime.formatTime());
  }
  
  private void showSplitFareTooltipIfNeeded()
  {
    if ((featuresProvider.isEnabled(Features.SPLIT_SHARE_TOOLTIP_ENABLED)) && (passengerRideProvider.getPassengerRide().isFeatureEnabled(RideFeature.SPLIT_PAY_PROMOTABLE)) && (!passengerRideProvider.didDisplaySplitFareTooltip()))
    {
      ExperimentAnalytics.trackExposure(Experiment.PG_SPLIT_PAY_HINT);
      Tooltip localTooltip = tooltipService.getTooltip("split_fare");
      if (localTooltip != null)
      {
        tooltipContainerView.tryToShowAndMarkShown(localTooltip, findViewById(2131559379), 48);
        passengerRideProvider.setSplitFareTooltipDisplayed(true);
      }
    }
  }
  
  private void updateEtd(PassengerRide paramPassengerRide)
  {
    rideFooterView.setBannerMessage(getResources().getString(2131165968));
    rideFooterView.setBannerMessageTextColor(2131493014);
    binder.bind(getCachedDriverEtdObservable(paramPassengerRide), new CourierInRideView.10(this, paramPassengerRide));
  }
  
  private void updateMatchedRideBannerMessage(PassengerRide paramPassengerRide)
  {
    rideFooterView.setBannerMessage(getResources().getString(2131165964));
    rideFooterView.setBannerMessageTextColor(2131493014);
    binder.bind(getCachedDriverEtaObservable(paramPassengerRide), new CourierInRideView.9(this, paramPassengerRide));
  }
  
  private void updateRide()
  {
    PassengerRide localPassengerRide = passengerRideProvider.getPassengerRide();
    passengerMapController.refreshDriverMarker();
    passengerMapController.showPassengerRoute();
    updateEtd(localPassengerRide);
    updateRideBannerText(localPassengerRide);
    if (localPassengerRide.shouldHideLocationMarker()) {
      passengerMapController.hideLocation();
    }
    for (;;)
    {
      if (shouldShowEditPickupOnboarding(localPassengerRide))
      {
        lyftPreferences.setEditPickupOnboardingShown();
        dialogFlow.show(new Dialogs.EditPickupOnboardingDialog());
      }
      return;
      passengerMapController.displayLocation();
    }
  }
  
  private void updateRideBannerText(PassengerRide paramPassengerRide)
  {
    Object localObject = paramPassengerRide.getStatus();
    if (((RideStatus)localObject).isPickedUp())
    {
      passengerMapController.clearPickupMarker();
      return;
    }
    if ((((RideStatus)localObject).isArrived()) && (!paramPassengerRide.getCurrentStop().getScheduledTime().isNull()))
    {
      localObject = paramPassengerRide.getCurrentStop();
      showScheduledRidesArrivedPickupPin(((PassengerStop)localObject).getLocation(), ((PassengerStop)localObject).getScheduledTime().startTime());
      rideFooterView.setBannerMessage(getResources().getString(2131166020, new Object[] { paramPassengerRide.getDriverWaitTime().formatTime() }));
      rideFooterView.setBannerMessageTextColor(2131493004);
      return;
    }
    if (((RideStatus)localObject).isArrived())
    {
      rideFooterView.setBannerMessage(getResources().getString(2131165944));
      rideFooterView.setBannerMessageTextColor(2131493004);
      passengerMapController.clearPickupMarker();
      return;
    }
    if (((RideStatus)localObject).isAccepted())
    {
      updateMatchedRideBannerMessage(paramPassengerRide);
      return;
    }
    L.w("Courier in ride banner missing", new Object[0]);
  }
  
  private void updateRideDetails()
  {
    Driver localDriver = passengerRideProvider.getPassengerRide().getDriver();
    rideFooterView.updateDriver(localDriver);
    rideFooterView.updatePassengers(passengerRideProvider.getPassengerRide().getPassengers());
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (isInEditMode()) {
      return;
    }
    initToolbar();
    slideMenuController.enableMenu();
    updateRideDetails();
    binder = Binder.attach(this);
    binder.bind(passengerMapController.observeMapLoaded(), onMapLoaded);
    binder.bind(passengerMapController.observeAndApplyPaddingChanges(BehaviorSubject.create(Integer.valueOf(getResources().getDimensionPixelSize(2131230823))), passengerRideBottom.observeHeightChange()), new CourierInRideView.1(this));
    showSplitFareTooltipIfNeeded();
    showReferralTooltipIfNeeded();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    passengerActiveRideZoomingController.detach();
    slideMenuController.disableMenu();
    passengerMapController.clearAllMarkers();
    passengerMapController.clearRoutes();
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
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    super.onRestoreInstanceState(paramParcelable);
    updateRideDetails();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.passenger.v2.inride.CourierInRideView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */