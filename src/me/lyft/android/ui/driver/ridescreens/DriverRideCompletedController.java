package me.lyft.android.ui.driver.ridescreens;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.lyft.rx.MessageBus;
import com.lyft.scoop.Scoop;
import javax.inject.Inject;
import me.lyft.android.application.ride.IDriverRideProvider;
import me.lyft.android.common.AppFlow;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.common.RxViewController;
import me.lyft.android.controls.Toolbar;
import me.lyft.android.domain.driver.ride.DriverRide;
import me.lyft.android.rx.RxUIBinder;
import me.lyft.android.ui.driver.DriverOverflowMenuView.OverflowMenuItemPressedEvent;
import me.lyft.android.ui.driver.DriverRideRatingAndEarningsView;
import rx.functions.Action1;

public class DriverRideCompletedController
  extends RxViewController
{
  private final AppFlow appFlow;
  private final MessageBus bus;
  private final DialogFlow dialogFlow;
  private DriverRideRatingAndEarningsView driverEarningsView;
  private Action1<Integer> onMenuItemClicked = new DriverRideCompletedController.1(this);
  ViewGroup ratingAndEarningScreen;
  private final IDriverRideProvider rideProvider;
  Toolbar toolbar;
  
  @Inject
  public DriverRideCompletedController(IDriverRideProvider paramIDriverRideProvider, MessageBus paramMessageBus, DialogFlow paramDialogFlow, AppFlow paramAppFlow)
  {
    rideProvider = paramIDriverRideProvider;
    bus = paramMessageBus;
    dialogFlow = paramDialogFlow;
    appFlow = paramAppFlow;
  }
  
  private void initRatingScreen()
  {
    ratingAndEarningScreen.setVisibility(0);
    if (driverEarningsView == null)
    {
      driverEarningsView = ((DriverRideRatingAndEarningsView)Scoop.fromView(getView()).inflater(getView().getContext()).inflate(2130903192, ratingAndEarningScreen, false));
      ratingAndEarningScreen.addView(driverEarningsView);
    }
    binder.bindAction(toolbar.observeItemClick(), onMenuItemClicked);
    binder.bindAction(bus.observe(DriverOverflowMenuView.OverflowMenuItemPressedEvent.class), onMenuItemClicked);
  }
  
  private void initToolbar()
  {
    int i = 2130838116;
    if (rideProvider.getDriverRide().isCourier()) {
      i = 2130838110;
    }
    for (;;)
    {
      toolbar.hideHomeIcon().setLogo(i);
      toolbar.addItem(2131558450, 2130838283).showItem(2131558450);
      return;
      if (rideProvider.getDriverRide().isPlus()) {
        i = 2130838118;
      }
    }
  }
  
  protected int layoutId()
  {
    return 2130903189;
  }
  
  public void onAttach()
  {
    super.onAttach();
    initToolbar();
    initRatingScreen();
  }
  
  public void onDetach()
  {
    super.onDetach();
    ratingAndEarningScreen.removeAllViews();
    ratingAndEarningScreen.setVisibility(8);
    toolbar.removeItem(2131558431);
    driverEarningsView = null;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.driver.ridescreens.DriverRideCompletedController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */