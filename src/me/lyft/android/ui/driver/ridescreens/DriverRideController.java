package me.lyft.android.ui.driver.ridescreens;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.lyft.scoop.HandleBack;
import com.lyft.scoop.RouteChange;
import com.lyft.scoop.Screen;
import javax.inject.Inject;
import me.lyft.android.analytics.studies.ExpressPayAnalytics;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.application.constants.Constants;
import me.lyft.android.application.constants.IConstantsProvider;
import me.lyft.android.application.features.Features;
import me.lyft.android.application.features.IFeaturesProvider;
import me.lyft.android.application.passenger.IPassengerRideProvider;
import me.lyft.android.application.ride.IDriverRideProvider;
import me.lyft.android.application.ride.IUserDispatchService;
import me.lyft.android.application.ride.IUserUiService;
import me.lyft.android.common.ActivityController;
import me.lyft.android.common.AppFlow;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.common.DriverFlow;
import me.lyft.android.common.RxViewController;
import me.lyft.android.common.Strings;
import me.lyft.android.common.Unit;
import me.lyft.android.controls.DriverBottomNavigationView;
import me.lyft.android.controls.DriverBottomNavigationView.DriverTab;
import me.lyft.android.domain.User;
import me.lyft.android.domain.driver.UiState;
import me.lyft.android.domain.driver.ride.DriverRide;
import me.lyft.android.domain.passenger.ride.PassengerRide;
import me.lyft.android.domain.ride.RideStatus;
import me.lyft.android.domain.ride.RideType;
import me.lyft.android.logging.L;
import me.lyft.android.rx.ReactiveProperty;
import me.lyft.android.rx.RxUIBinder;
import me.lyft.android.ui.Dialogs.InAppNotificationDialog;
import me.lyft.android.ui.IProgressController;
import me.lyft.android.ui.MainScreens.DriverRideScreen;
import me.lyft.android.ui.MainScreens.PassengerRideScreen;
import me.lyft.android.ui.ScreensContainer;
import me.lyft.android.ui.dialogs.Toast;
import me.lyft.android.ui.driver.DriverDialogs.LastRideConfirmationDialog;
import me.lyft.android.ui.driver.DriverDialogs.LastRideExitDialog;
import me.lyft.android.ui.driver.expresspay.ExpressPayDialogs.FirstTimeExpressPayDialog;
import me.lyft.android.ui.driver.ridescreens.tabs.DriverOfflineScreen;
import me.lyft.android.ui.ride.IUserModeErrorHandler;
import me.lyft.android.ui.ride.RideMap;
import rx.Observable;
import rx.functions.Action1;

public class DriverRideController
  extends RxViewController
  implements HandleBack
{
  private final ActivityController activityController;
  private final AppFlow appFlow;
  private final IConstantsProvider constantsProvider;
  private String currentRideId = null;
  private final DialogFlow dialogFlow;
  DriverBottomNavigationView driverBottomNavigationView;
  private final DriverFlow driverFlow;
  ScreensContainer driverScreenContainer;
  private final IFeaturesProvider featuresProvider;
  private boolean isDispatchable;
  private final ReactiveProperty<Boolean> isInDriverModeSubject = ReactiveProperty.create();
  FrameLayout mapPlaceholder;
  private Action1<RouteChange> onDriverScreenChanged = new DriverRideController.5(this);
  private Action1<Unit> onRideStateChange = new DriverRideController.1(this);
  private Action1<User> onUserChanged = new DriverRideController.2(this);
  private final IPassengerRideProvider passengerRideProvider;
  private final IProgressController progressController;
  private final RideMap rideMap;
  private final IDriverRideProvider routeProvider;
  private final IUserModeErrorHandler userModeErrorHandler;
  private final IUserDispatchService userModeService;
  private final IUserProvider userProvider;
  private final IUserUiService userService;
  
  @Inject
  public DriverRideController(DialogFlow paramDialogFlow, DriverFlow paramDriverFlow, IUserProvider paramIUserProvider, IUserUiService paramIUserUiService, IPassengerRideProvider paramIPassengerRideProvider, IDriverRideProvider paramIDriverRideProvider, RideMap paramRideMap, AppFlow paramAppFlow, IUserModeErrorHandler paramIUserModeErrorHandler, ActivityController paramActivityController, IConstantsProvider paramIConstantsProvider, IFeaturesProvider paramIFeaturesProvider, IProgressController paramIProgressController, IUserDispatchService paramIUserDispatchService)
  {
    dialogFlow = paramDialogFlow;
    driverFlow = paramDriverFlow;
    userProvider = paramIUserProvider;
    userService = paramIUserUiService;
    passengerRideProvider = paramIPassengerRideProvider;
    routeProvider = paramIDriverRideProvider;
    rideMap = paramRideMap;
    appFlow = paramAppFlow;
    userModeErrorHandler = paramIUserModeErrorHandler;
    activityController = paramActivityController;
    constantsProvider = paramIConstantsProvider;
    featuresProvider = paramIFeaturesProvider;
    progressController = paramIProgressController;
    userModeService = paramIUserDispatchService;
  }
  
  private void adjustForShadow(ViewGroup paramViewGroup, int paramInt)
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramViewGroup.getLayoutParams();
    localLayoutParams.setMargins(0, 0, 0, paramInt);
    paramViewGroup.setLayoutParams(localLayoutParams);
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
  
  private Screen getDriverScreen()
  {
    DriverRide localDriverRide = routeProvider.getDriverRide();
    if (!userService.getUiState().isDriverUi())
    {
      appFlow.replaceAllWith(new Screen[] { new MainScreens.PassengerRideScreen() });
      return null;
    }
    return getDriverScreen(localDriverRide);
  }
  
  private Screen getDriverScreen(DriverRide paramDriverRide)
  {
    if ((paramDriverRide.isNull()) && (!userProvider.getUser().isDispatchable()))
    {
      handleOfflineParams();
      return new DriverOfflineScreen();
    }
    if (paramDriverRide.isNull())
    {
      handleOnlineParams();
      return new DriverOnlineScreen();
    }
    if ((paramDriverRide.isPending()) || (paramDriverRide.getStatus().isLapsed())) {
      return new DriverRideAcceptScreen();
    }
    if (paramDriverRide.isAccepted()) {
      return new DriverRideAcceptedScreen();
    }
    if (paramDriverRide.isArrived()) {
      return new DriverRideArrivedScreen();
    }
    if (paramDriverRide.isPickedUp()) {
      return new DriverRidePickedUpScreen();
    }
    if (paramDriverRide.isDroppedOff()) {
      return new DriverRideCompletedScreen();
    }
    handleOnlineParams();
    return new DriverOnlineScreen();
  }
  
  private void goOffline(MainScreens.DriverRideScreen paramDriverRideScreen)
  {
    paramDriverRideScreen.resetSwitchToPassengerMode();
    if (routeProvider.getDriverRide().isActive())
    {
      if (userProvider.getUser().isDriverLastRide())
      {
        dialogFlow.show(new DriverDialogs.LastRideExitDialog());
        return;
      }
      dialogFlow.show(new DriverDialogs.LastRideConfirmationDialog());
      return;
    }
    progressController.showProgress();
    binder.bindAsyncCall(userModeService.switchToDispatchable(false), new DriverRideController.3(this));
  }
  
  private void goOnline(MainScreens.DriverRideScreen paramDriverRideScreen)
  {
    paramDriverRideScreen.resetSwitchToDriverMode();
    progressController.showProgress();
    binder.bindAsyncCall(userModeService.validateDriverStatusAndSwitchToDispatch(), new DriverRideController.4(this));
  }
  
  private void handleOfflineParams()
  {
    MainScreens.DriverRideScreen localDriverRideScreen = (MainScreens.DriverRideScreen)Screen.fromController(this);
    String str = localDriverRideScreen.getWebDialogParams();
    if (localDriverRideScreen.isGoOnline()) {
      goOnline(localDriverRideScreen);
    }
    while (Strings.isNullOrEmpty(str)) {
      return;
    }
    localDriverRideScreen.resetWebDialogUrl();
    dialogFlow.show(new Dialogs.InAppNotificationDialog(str));
  }
  
  private void handleOnlineParams()
  {
    MainScreens.DriverRideScreen localDriverRideScreen = (MainScreens.DriverRideScreen)Screen.fromController(this);
    if (localDriverRideScreen.isGoOffline()) {
      goOffline(localDriverRideScreen);
    }
  }
  
  private void handleTabVisibility(Screen paramScreen)
  {
    if ((paramScreen instanceof DriverOfflineScreen))
    {
      driverBottomNavigationView.setVisibility(0);
      adjustForShadow(driverScreenContainer, (int)getResources().getDimension(2131230899));
      return;
    }
    driverBottomNavigationView.setVisibility(8);
    adjustForShadow(driverScreenContainer, 0);
  }
  
  private void navigateToScreen(Screen paramScreen)
  {
    if ((routeProvider.getDriverRide() != null) && (!Strings.isNullOrEmpty(routeProvider.getDriverRide().getCurrentRideId())) && (!routeProvider.getDriverRide().getCurrentRideId().equals(currentRideId)))
    {
      L.d("DriverRideAcceptV2:newRideId:" + routeProvider.getDriverRide().getCurrentRideId(), new Object[0]);
      currentRideId = routeProvider.getDriverRide().getCurrentRideId();
      driverFlow.clearAndShow(paramScreen);
      return;
    }
    driverFlow.show(paramScreen);
  }
  
  private void setDriverScreen(Screen paramScreen)
  {
    if (!userService.getUiState().isDriverUi()) {
      appFlow.replaceAllWith(new Screen[] { new MainScreens.PassengerRideScreen() });
    }
    while (paramScreen == null) {
      return;
    }
    if (routeProvider.getDriverRide() != null) {
      L.d("DriverRideAcceptV2:rideStatus:" + routeProvider.getDriverRide().getStatus(), new Object[0]);
    }
    navigateToScreen(paramScreen);
    handleTabVisibility(paramScreen);
  }
  
  private void showModeChangedToastIfNeeded()
  {
    if ((isDispatchable) && (!userProvider.getUser().isDispatchable()) && (!routeProvider.getDriverRide().getType().isCarpool()) && (!(appFlow.peek() instanceof DriverSetDestinyScreen)))
    {
      if (userProvider.getUser().showExpressPayPopUp())
      {
        String str1 = (String)constantsProvider.get(Constants.EXPRESS_PAY_PROMO_POP_UP_TEXT);
        String str2 = (String)constantsProvider.get(Constants.EXPRESS_PAY_PROMO_POP_UP_BUTTON_TEXT);
        boolean bool = featuresProvider.isEnabled(Features.SHOW_DRIVER_EARNINGS_V2);
        if ((str1 != null) && (str2 != null))
        {
          ExpressPayAnalytics.trackExpressPayPromoTaps();
          dialogFlow.show(new ExpressPayDialogs.FirstTimeExpressPayDialog(getResources().getString(2131165703), str1, str2, bool));
        }
      }
      if (!dialogFlow.hasActiveDialog()) {
        dialogFlow.show(new Toast(getResources().getString(2131165869), Integer.valueOf(2130838195)));
      }
    }
  }
  
  private void updateRideView()
  {
    checkWakeLock();
    setDriverScreen(getDriverScreen());
  }
  
  protected int layoutId()
  {
    return 2130903194;
  }
  
  public void onAttach()
  {
    super.onAttach();
    updateRideView();
    driverFlow.dismiss();
    driverBottomNavigationView.setCurrentTab(DriverBottomNavigationView.DriverTab.HOME);
    rideMap.attach(mapPlaceholder);
    isDispatchable = userProvider.getUser().isDispatchable();
    binder.bindAction(driverFlow.observeDriverScreenChange(), onDriverScreenChanged);
    binder.bindAction(Observable.combineLatest(passengerRideProvider.observeRideUpdateEvent(), routeProvider.observeRide(), Unit.func2()), onRideStateChange);
    binder.bindAction(userProvider.observeUserUpdates(), onUserChanged);
    binder.bindAction(isInDriverModeSubject.map(Unit.func1()), onRideStateChange);
  }
  
  public boolean onBack()
  {
    return driverScreenContainer.onBack();
  }
  
  public void onDetach()
  {
    super.onDetach();
    mapPlaceholder.removeAllViews();
    driverFlow.dismiss();
    rideMap.detach();
  }
  
  public void showRideScreen()
  {
    if (userService.getUiState().isDriverUi())
    {
      appFlow.replaceAllWith(new Screen[] { new MainScreens.DriverRideScreen() });
      return;
    }
    appFlow.replaceAllWith(new Screen[] { new MainScreens.PassengerRideScreen() });
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.driver.ridescreens.DriverRideController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */