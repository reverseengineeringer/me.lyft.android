package me.lyft.android.ui.driver.carpool.screens;

import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;
import me.lyft.android.analytics.studies.CarpoolRideAnalytics;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.application.ride.IDriverRideProvider;
import me.lyft.android.application.ride.services.ICarpoolRideService;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.common.RxViewController;
import me.lyft.android.domain.User;
import me.lyft.android.domain.driver.ride.DriverRide;
import me.lyft.android.domain.driver.ride.DriverRidePassenger;
import me.lyft.android.rx.RxUIBinder;
import me.lyft.android.ui.HeightObservableLayout;
import me.lyft.android.ui.IProgressController;
import me.lyft.android.ui.IViewErrorHandler;
import me.lyft.android.ui.MainScreensRouter;
import me.lyft.android.ui.dialogs.Toast;
import me.lyft.android.ui.driver.carpool.CarpoolDriverMapController;
import me.lyft.android.ui.driver.carpool.CarpoolRequestPagerAdapter;

public class DriverRequestsPendingController
  extends RxViewController
{
  public static final long REQUESTS_CHANGED_ANIMATION_DURATION_MS = 1000L;
  private int MULTIPLE_REQUESTS_PADDING;
  private int SINGLE_REQUEST_PADDING;
  Button acceptButton;
  ViewGroup acceptButtonContainer;
  HeightObservableLayout bottomLayout;
  private final ICarpoolRideService carpoolRideService;
  Button declineButton;
  private final DialogFlow dialogFlow;
  private final IDriverRideProvider driverRideProvider;
  private List<DriverRide> driverRides;
  private final MainScreensRouter mainScreensRouter;
  private final CarpoolDriverMapController mapController;
  View mapZoomButton;
  private final IProgressController progressController;
  ViewPager requestViewPager;
  HeightObservableLayout topLayout;
  private final IUserProvider userProvider;
  private final IViewErrorHandler viewErrorHandler;
  
  @Inject
  public DriverRequestsPendingController(IDriverRideProvider paramIDriverRideProvider, IProgressController paramIProgressController, IViewErrorHandler paramIViewErrorHandler, DialogFlow paramDialogFlow, ICarpoolRideService paramICarpoolRideService, IUserProvider paramIUserProvider, MainScreensRouter paramMainScreensRouter, CarpoolDriverMapController paramCarpoolDriverMapController)
  {
    driverRideProvider = paramIDriverRideProvider;
    progressController = paramIProgressController;
    viewErrorHandler = paramIViewErrorHandler;
    dialogFlow = paramDialogFlow;
    carpoolRideService = paramICarpoolRideService;
    userProvider = paramIUserProvider;
    mainScreensRouter = paramMainScreensRouter;
    mapController = paramCarpoolDriverMapController;
  }
  
  private void adjustRequestsPadding(List<DriverRide> paramList1, List<DriverRide> paramList2)
  {
    if ((paramList1.size() == 1) && (paramList2.size() > 1)) {
      animatePaddingChange(SINGLE_REQUEST_PADDING, MULTIPLE_REQUESTS_PADDING);
    }
    while ((paramList1.size() <= 1) || (paramList2.size() != 1)) {
      return;
    }
    animatePaddingChange(MULTIPLE_REQUESTS_PADDING, SINGLE_REQUEST_PADDING);
  }
  
  private void animatePaddingChange(int paramInt1, int paramInt2)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { paramInt1, paramInt2 });
    localValueAnimator.addUpdateListener(new DriverRequestsPendingController.3(this));
    localValueAnimator.setDuration(1000L);
    localValueAnimator.start();
  }
  
  private void fetchRides(boolean paramBoolean)
  {
    binder.bindAsyncCall(carpoolRideService.fetchCarpoolRides(userProvider.getUser().getId()), new DriverRequestsPendingController.2(this, paramBoolean));
  }
  
  private void initRequest()
  {
    driverRides = Collections.singletonList(driverRideProvider.getDriverRide());
    SINGLE_REQUEST_PADDING = getResources().getDimensionPixelOffset(2131230893);
    MULTIPLE_REQUESTS_PADDING = getResources().getDimensionPixelOffset(2131230856);
    fetchRides(false);
    if (driverRides.size() == 1) {}
    for (int i = SINGLE_REQUEST_PADDING;; i = MULTIPLE_REQUESTS_PADDING)
    {
      setRequestsPadding(i);
      binder.bindAction(mapController.observeMapLoaded(topLayout.observeHeightChange(), bottomLayout.observeHeightChange()), new DriverRequestsPendingController.1(this));
      return;
    }
  }
  
  private void onRidesUpdated(List<DriverRide> paramList)
  {
    if (paramList.isEmpty())
    {
      mainScreensRouter.resetToHomeScreen();
      return;
    }
    adjustRequestsPadding(driverRides, paramList);
    driverRides = paramList;
    updateRequestUI();
  }
  
  private void setRequestsPadding(int paramInt)
  {
    requestViewPager.setPadding(paramInt, requestViewPager.getPaddingTop(), paramInt, requestViewPager.getPaddingBottom());
    acceptButtonContainer.setPadding(paramInt, acceptButtonContainer.getPaddingTop(), paramInt, acceptButtonContainer.getPaddingBottom());
  }
  
  private void setupAcceptButton(DriverRide paramDriverRide)
  {
    acceptButton.setText(getResources().getString(2131165375, new Object[] { paramDriverRide.getCurrentPassenger().getFirstName() }));
    acceptButton.setOnClickListener(new DriverRequestsPendingController.5(this, paramDriverRide));
  }
  
  private void setupDeclineAllButton()
  {
    declineButton.setText(getResources().getQuantityText(2131689473, driverRides.size()));
    declineButton.setOnClickListener(new DriverRequestsPendingController.4(this));
  }
  
  private void setupMapZoomButton(DriverRide paramDriverRide)
  {
    mapZoomButton.setVisibility(4);
    mapZoomButton.setOnClickListener(new DriverRequestsPendingController.7(this, paramDriverRide));
    binder.bindAction(mapController.observeMapInteraction(), new DriverRequestsPendingController.8(this));
  }
  
  private void setupRequestPager()
  {
    requestViewPager.setAdapter(new CarpoolRequestPagerAdapter(driverRides));
    requestViewPager.addOnPageChangeListener(new DriverRequestsPendingController.6(this));
    requestViewPager.setClipToPadding(false);
    requestViewPager.setPageMargin(getResources().getDimensionPixelSize(2131230872));
  }
  
  private void showRideScheduledToast()
  {
    dialogFlow.show(new Toast(getResources().getString(2131165384), Integer.valueOf(2130838387)));
  }
  
  private void trackRequestShown(int paramInt)
  {
    CarpoolRideAnalytics.trackRideRequestViewed(paramInt + 1);
  }
  
  private void updateRequestUI()
  {
    if (driverRides.isEmpty()) {
      return;
    }
    DriverRide localDriverRide = (DriverRide)driverRides.get(0);
    mapController.showRide(localDriverRide);
    setupMapZoomButton(localDriverRide);
    setupDeclineAllButton();
    setupAcceptButton(localDriverRide);
    setupRequestPager();
  }
  
  protected int layoutId()
  {
    return 2130903178;
  }
  
  public void onAttach()
  {
    super.onAttach();
    initRequest();
    updateRequestUI();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.driver.carpool.screens.DriverRequestsPendingController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */