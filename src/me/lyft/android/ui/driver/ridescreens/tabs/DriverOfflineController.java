package me.lyft.android.ui.driver.ridescreens.tabs;

import android.content.res.Resources;
import android.support.v4.view.GestureDetectorCompat;
import android.view.GestureDetector.OnGestureListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.jakewharton.rxrelay.BehaviorRelay;
import com.lyft.android.api.dto.HeatmapMetaDTO;
import java.util.List;
import javax.inject.Inject;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.analytics.studies.DriverConsoleAnalytics;
import me.lyft.android.application.driver.INewsFeedService;
import me.lyft.android.application.driver.NewsFeedService.NewsFeedMessageSplit;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.common.Objects;
import me.lyft.android.common.RxViewController;
import me.lyft.android.common.Unit;
import me.lyft.android.controls.DriverToolbar;
import me.lyft.android.infrastructure.appboy.IAppboyService;
import me.lyft.android.infrastructure.device.IDevice;
import me.lyft.android.infrastructure.foreground.IAppForegroundDetector;
import me.lyft.android.rx.RxUIBinder;
import me.lyft.android.rx.ViewExtensions;
import me.lyft.android.services.HeatMapService;
import me.lyft.android.ui.HeightObservableLayout;
import me.lyft.android.ui.SlideMenuController;
import me.lyft.android.ui.driver.DriverDialogs.GoOnlineDescriptionDialog;
import me.lyft.android.ui.driver.ridescreens.tabs.newsfeed.NewsFeedLayoutManager;
import me.lyft.android.ui.driver.ridescreens.tabs.newsfeed.NewsFeedScrollAnimator;
import me.lyft.android.ui.driver.ridescreens.tabs.newsfeed.NewsFeedScrollView;
import me.lyft.android.ui.driver.ridescreens.tabs.newsfeed.NewsFeedSingleTapListener;
import me.lyft.android.ui.driver.ridescreens.tabs.newsfeed.NewsFeedView;
import me.lyft.android.ui.ride.RideMap;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;
import rx.subscriptions.Subscriptions;

public class DriverOfflineController
  extends RxViewController
{
  private static final int DEFAULT_ZOOM_LEVEL = 12;
  private static final int ZOOM_CACHE_KILL_THRESHOLD = 1;
  private final IAppForegroundDetector appForegroundDetector;
  private final IAppboyService appboyService;
  private final IDevice device;
  private final DialogFlow dialogFlow;
  View dividerView;
  private final DriverConsoleAnalytics driverConsoleAnalytics;
  HeightObservableLayout driverRideTop;
  ImageButton followCurrentLocationButton;
  private final HeatMapService heatMapService;
  LinearLayout heatmapHeader;
  private Observable<Boolean> heatmapPrimeTimeHasRangeObservable = heatmapPrimeTimeRateChange.map(new DriverOfflineController.1(this));
  TextView heatmapPrimeTimeRate;
  private BehaviorRelay<String> heatmapPrimeTimeRateChange = BehaviorRelay.create();
  private Action1<String> heatmapPrimeTimeRateChangeCallback = new DriverOfflineController.6(this);
  private boolean isNewsFeedLoaded = false;
  private final ILyftPreferences lyftPreferences;
  private Subscription nearbyDriversUpdateSubscription = Subscriptions.empty();
  NewsFeedView newsFeedContainerView;
  private NewsFeedLayoutManager newsFeedLayoutManager;
  private NewsFeedScrollAnimator newsFeedScrollAnimator;
  NewsFeedScrollView newsFeedScrollView;
  private final INewsFeedService newsFeedService;
  private Action1<Float> onCameraZoomChanged = new DriverOfflineController.5(this);
  private View.OnClickListener onFollowCurrentLocationClicked = new DriverOfflineController.12(this);
  private Action1<String> onHeatMapMetaDataChanged = new DriverOfflineController.7(this);
  private Action1<Unit> onMapDragStart = new DriverOfflineController.8(this);
  private Action1<Unit> onMapLoaded = new DriverOfflineController.4(this);
  private final RideMap rideMap;
  private final SlideMenuController slideMenuController;
  DriverToolbar toolbar;
  
  @Inject
  public DriverOfflineController(HeatMapService paramHeatMapService, IAppForegroundDetector paramIAppForegroundDetector, INewsFeedService paramINewsFeedService, DialogFlow paramDialogFlow, RideMap paramRideMap, SlideMenuController paramSlideMenuController, DriverConsoleAnalytics paramDriverConsoleAnalytics, IDevice paramIDevice, IAppboyService paramIAppboyService, ILyftPreferences paramILyftPreferences)
  {
    heatMapService = paramHeatMapService;
    appForegroundDetector = paramIAppForegroundDetector;
    newsFeedService = paramINewsFeedService;
    dialogFlow = paramDialogFlow;
    rideMap = paramRideMap;
    slideMenuController = paramSlideMenuController;
    driverConsoleAnalytics = paramDriverConsoleAnalytics;
    device = paramIDevice;
    appboyService = paramIAppboyService;
    lyftPreferences = paramILyftPreferences;
  }
  
  private void addTileOverlay()
  {
    rideMap.removeHeatmap();
    rideMap.addHeatmap();
  }
  
  private void followCurrentLocation()
  {
    followCurrentLocationButton.setSelected(true);
    followCurrentLocationButton.setVisibility(8);
    rideMap.followCurrentLocation();
  }
  
  private void initializeFeed(NewsFeedService.NewsFeedMessageSplit paramNewsFeedMessageSplit)
  {
    newsFeedScrollView.setVisibility(0);
    binder.bindAction(ViewExtensions.onLoadedObservable(newsFeedContainerView), new DriverOfflineController.9(this, paramNewsFeedMessageSplit));
  }
  
  private void initializeForegroundDetector()
  {
    binder.bindAction(appForegroundDetector.observeAppForegrounded(), new DriverOfflineController.10(this));
  }
  
  private void initializeLocationButtonMovement(boolean paramBoolean)
  {
    int i = newsFeedLayoutManager.getStartYOfFollowCurrentLocationButton(paramBoolean);
    updateAnimation(i);
    newsFeedScrollView.setNewsFeedScrollListener(new DriverOfflineController.11(this, i));
  }
  
  private void initializeSingleTapListener()
  {
    Object localObject = new NewsFeedSingleTapListener(newsFeedScrollView, newsFeedLayoutManager);
    localObject = new GestureDetectorCompat(getView().getContext(), (GestureDetector.OnGestureListener)localObject);
    newsFeedScrollView.setNewsFeedSingleTapListener((GestureDetectorCompat)localObject);
  }
  
  private void setNewAlpha(int paramInt)
  {
    float f = newsFeedScrollAnimator.calculateLocationButtonAlpha(paramInt, getResources());
    followCurrentLocationButton.setAlpha(f);
    f = newsFeedScrollAnimator.calculateHeatmapAlpha(paramInt, getResources());
    heatmapHeader.setAlpha(f);
    dividerView.setAlpha(f);
  }
  
  private void setNewLocationButtonPositionY(int paramInt)
  {
    followCurrentLocationButton.setY(paramInt);
  }
  
  private void setNewScrollViewMargin(int paramInt)
  {
    paramInt = Math.round(newsFeedScrollAnimator.calculateMargin(paramInt, getResources().getDimension(2131230893), getResources()));
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)newsFeedScrollView.getLayoutParams();
    localLayoutParams.setMargins(paramInt, 0, paramInt, 0);
    newsFeedScrollView.setLayoutParams(localLayoutParams);
  }
  
  private void showMessages(NewsFeedService.NewsFeedMessageSplit paramNewsFeedMessageSplit)
  {
    newsFeedContainerView.setMessages(paramNewsFeedMessageSplit.getUnreadMessages(), paramNewsFeedMessageSplit.getReadMessages(), newsFeedLayoutManager);
    if (paramNewsFeedMessageSplit.getUnreadMessages().isEmpty())
    {
      newsFeedLayoutManager.animateToCollapsedSmall(newsFeedScrollView);
      initializeLocationButtonMovement(false);
    }
    for (;;)
    {
      slideUpFollowLocationButton();
      initializeSingleTapListener();
      return;
      newsFeedLayoutManager.animateToCollapsedLarge(newsFeedScrollView);
      initializeLocationButtonMovement(true);
    }
  }
  
  private void slideUpFollowLocationButton()
  {
    followCurrentLocationButton.setVisibility(0);
    Animation localAnimation = AnimationUtils.loadAnimation(newsFeedContainerView.getContext(), 2130968584);
    localAnimation.setInterpolator(new OvershootInterpolator(1.0F));
    newsFeedContainerView.startAnimation(localAnimation);
    localAnimation = AnimationUtils.loadAnimation(getView().getContext(), 2130968584);
    localAnimation.setInterpolator(new OvershootInterpolator(1.0F));
    followCurrentLocationButton.startAnimation(localAnimation);
  }
  
  private void trackShown()
  {
    if (heatMapService.getHeatMapMetaData() != null)
    {
      driverConsoleAnalytics.trackDriverHomeView((String)Objects.firstNonNull(heatMapService.getHeatMapMetaData().primeTimeRange, ""));
      return;
    }
    driverConsoleAnalytics.trackDriverHomeView("");
  }
  
  private void unfollowCurrentLocation()
  {
    followCurrentLocationButton.setSelected(false);
    if (isNewsFeedLoaded) {
      followCurrentLocationButton.setVisibility(0);
    }
    rideMap.unfollowCurrentLocation();
  }
  
  private void updateAnimation(int paramInt)
  {
    setNewLocationButtonPositionY(paramInt);
    setNewAlpha(paramInt);
    setNewScrollViewMargin(paramInt);
  }
  
  protected int layoutId()
  {
    return 2130903174;
  }
  
  public void onAttach()
  {
    super.onAttach();
    trackShown();
    slideMenuController.enableMenu();
    newsFeedLayoutManager = new NewsFeedLayoutManager(driverRideTop, getResources(), device, followCurrentLocationButton);
    newsFeedScrollAnimator = new NewsFeedScrollAnimator(newsFeedLayoutManager, toolbar);
    nearbyDriversUpdateSubscription.unsubscribe();
    rideMap.clearDriverMarkers();
    heatMapService.start();
    addTileOverlay();
    followCurrentLocationButton.setOnClickListener(onFollowCurrentLocationClicked);
    unfollowCurrentLocation();
    followCurrentLocationButton.setVisibility(4);
    heatmapHeader.setOnClickListener(new DriverOfflineController.2(this));
    toolbar.showDivider();
    binder.bindAction(rideMap.observeMapLoaded(), onMapLoaded);
    binder.bindAsyncCall(newsFeedService.getNewsFeedMessages(), new DriverOfflineController.3(this));
    appboyService.enableInappNoteDisplay();
    if (!lyftPreferences.wasGoOnlineDialogShown()) {
      dialogFlow.show(new DriverDialogs.GoOnlineDescriptionDialog());
    }
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
    appboyService.disableInappNoteDisplay();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.driver.ridescreens.tabs.DriverOfflineController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */