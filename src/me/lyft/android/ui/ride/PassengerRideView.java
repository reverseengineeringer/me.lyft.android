package me.lyft.android.ui.ride;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import butterknife.ButterKnife;
import com.lyft.scoop.HandleBack;
import com.lyft.scoop.Scoop;
import com.lyft.scoop.Screen;
import com.lyft.scoop.dagger.DaggerInjector;
import javax.inject.Inject;
import me.lyft.android.analytics.core.ExperimentAnalytics;
import me.lyft.android.analytics.core.definitions.Experiment;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.application.features.Features;
import me.lyft.android.application.features.IFeaturesProvider;
import me.lyft.android.application.passenger.IPassengerRideProvider;
import me.lyft.android.application.ride.IDriverRideProvider;
import me.lyft.android.application.ride.IUserUiService;
import me.lyft.android.common.ActivityController;
import me.lyft.android.common.AppFlow;
import me.lyft.android.common.Unit;
import me.lyft.android.domain.User;
import me.lyft.android.domain.driver.UiState;
import me.lyft.android.domain.driver.ride.DriverRide;
import me.lyft.android.domain.passenger.ride.PassengerRide;
import me.lyft.android.domain.ride.RideStatus;
import me.lyft.android.domain.ride.RideType;
import me.lyft.android.rx.Binder;
import me.lyft.android.rx.ReactiveProperty;
import me.lyft.android.ui.MainScreens.DriverRideScreen;
import me.lyft.android.ui.passenger.rateandpay.RateAndPayModule;
import me.lyft.android.ui.passenger.v2.inride.InRideModule;
import me.lyft.android.ui.passenger.v2.pending.PendingModule;
import me.lyft.android.ui.passenger.v2.rateandpay.RateAndPayScreens.PaymentScreen;
import me.lyft.android.ui.passenger.v2.request.RequestModule;
import rx.Observable;
import rx.functions.Action1;

public class PassengerRideView
  extends FrameLayout
  implements HandleBack
{
  @Inject
  ActivityController activityController;
  @Inject
  AppFlow appFlow;
  private int currentRideViewId = 0;
  @Inject
  IFeaturesProvider featuresProvider;
  private final ReactiveProperty<Boolean> isInDriverModeSubject = ReactiveProperty.create();
  FrameLayout mapPlaceholder;
  private Action1<Unit> onRideStateChange = new PassengerRideView.1(this);
  private Action1<User> onUserChanged = new PassengerRideView.2(this);
  @Inject
  IPassengerRideProvider passengerRideProvider;
  @Inject
  RideMap rideMap;
  FrameLayout rideViewContainer;
  @Inject
  IDriverRideProvider routeProvider;
  @Inject
  IUserProvider userProvider;
  @Inject
  IUserUiService userService;
  
  public PassengerRideView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
  }
  
  private void checkWakeLock()
  {
    if (userService.getUiState().isDriverUi())
    {
      activityController.enableKeepScreenOn();
      return;
    }
    PassengerRide localPassengerRide = passengerRideProvider.getPassengerRide();
    RideStatus localRideStatus = localPassengerRide.getStatus();
    if (((localRideStatus.isPending()) || (localRideStatus.isAccepted())) && (localPassengerRide.isRealTimeMatching()))
    {
      activityController.enableKeepScreenOn();
      return;
    }
    activityController.disableKeepScreenOn();
  }
  
  private Scoop createScoop(Object... paramVarArgs)
  {
    return DaggerInjector.extend(Scoop.fromView(this), paramVarArgs);
  }
  
  private int getPassengerRideViewId()
  {
    PassengerRide localPassengerRide = passengerRideProvider.getPassengerRide();
    RideStatus localRideStatus = localPassengerRide.getStatus();
    if (localRideStatus.isPending())
    {
      if (localPassengerRide.isCourier()) {
        return 2130903135;
      }
      if (localPassengerRide.isCarpool()) {
        return 2130903090;
      }
      return 2130903094;
    }
    if ((localRideStatus.isAcknowledged()) || (localRideStatus.isAccepted()) || (localRideStatus.isArrived()) || (localRideStatus.isPickedUp()))
    {
      if (localPassengerRide.isCourier()) {
        return 2130903312;
      }
      if (localPassengerRide.isCarpool()) {
        return 2130903310;
      }
      return 2130903311;
    }
    if (localRideStatus.isDroppedOff()) {
      return 2130903321;
    }
    return 2130903336;
  }
  
  private Scoop getPassengerScoop()
  {
    RideStatus localRideStatus = passengerRideProvider.getPassengerRide().getStatus();
    if (localRideStatus.isPending()) {
      return createScoop(new Object[] { new PendingModule() });
    }
    if ((localRideStatus.isAcknowledged()) || (localRideStatus.isAccepted()) || (localRideStatus.isArrived()) || (localRideStatus.isPickedUp())) {
      return createScoop(new Object[] { new InRideModule() });
    }
    if (localRideStatus.isDroppedOff()) {
      return createScoop(new Object[] { new RateAndPayModule() });
    }
    return createScoop(new Object[] { new RequestModule() });
  }
  
  private void handleRateAndPayV2()
  {
    if (passengerRideProvider.getPassengerRide().getStatus().isDroppedOff())
    {
      ExperimentAnalytics.trackExposure(Experiment.RE_RATE_AND_PAY_V2);
      if (featuresProvider.isEnabled(Features.RATE_AND_PAY_V2)) {
        appFlow.resetTo(new RateAndPayScreens.PaymentScreen());
      }
    }
  }
  
  private void setRideView(int paramInt)
  {
    if ((userService.getUiState().isDriverUi()) && (!routeProvider.getDriverRide().getType().isCarpool())) {
      appFlow.replaceAllWith(new Screen[] { new MainScreens.DriverRideScreen() });
    }
    while ((paramInt == 0) || (currentRideViewId == paramInt)) {
      return;
    }
    currentRideViewId = paramInt;
    rideViewContainer.removeAllViews();
    getPassengerScoop().inflater(getContext()).inflate(paramInt, rideViewContainer, true);
  }
  
  private void updateRideView()
  {
    checkWakeLock();
    handleRateAndPayV2();
    int i = getPassengerRideViewId();
    if (i != 0) {
      setRideView(i);
    }
  }
  
  public View getView()
  {
    if (getChildCount() > 0) {
      return rideViewContainer.getChildAt(0);
    }
    return null;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    ButterKnife.bind(this);
    Binder localBinder = Binder.attach(this);
    rideMap.attach(mapPlaceholder);
    localBinder.bind(Observable.combineLatest(passengerRideProvider.observeRideUpdateEvent(), routeProvider.observeRide(), Unit.func2()), onRideStateChange);
    localBinder.bind(userProvider.observeUserUpdates(), onUserChanged);
    localBinder.bind(isInDriverModeSubject.map(Unit.func1()), onRideStateChange);
  }
  
  public boolean onBack()
  {
    View localView = getView();
    return ((localView instanceof HandleBack)) && (((HandleBack)localView).onBack());
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    mapPlaceholder.removeAllViews();
    rideMap.detach();
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    ButterKnife.bind(this);
    updateRideView();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.ride.PassengerRideView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */