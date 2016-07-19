package me.lyft.android.ui.driver;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import butterknife.ButterKnife;
import com.lyft.scoop.dagger.DaggerInjector;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.application.ride.IDestinyService;
import me.lyft.android.application.ride.IDriverRideProvider;
import me.lyft.android.common.AppFlow;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.common.Iterables;
import me.lyft.android.domain.User;
import me.lyft.android.domain.driver.DriverOverflowMenuDisplayManager;
import me.lyft.android.domain.driver.ride.DriverRide;
import me.lyft.android.domain.driver.ride.DriverRidePassenger;
import me.lyft.android.domain.driver.ride.DriverStop;
import me.lyft.android.domain.location.Location;
import me.lyft.android.rx.Binder;
import me.lyft.android.ui.CallPassengerMenuItem;
import me.lyft.android.ui.OverflowMenuItem;
import me.lyft.android.ui.driver.ridescreens.DriverSetDestinyScreen;
import me.lyft.android.ui.help.HelpScreens.HelpScreen;
import rx.Observable;
import rx.functions.Action1;

public class DriverOverflowMenuView
  extends FrameLayout
{
  @Inject
  AppFlow appFlow;
  View backgroundView;
  private Binder binder;
  @Inject
  IDestinyService destinyService;
  @Inject
  DialogFlow dialogFlow;
  @Inject
  DriverOverflowMenuDisplayManager driverOverflowMenuDisplayManager;
  private List<String> loadedPassengerIds = Collections.emptyList();
  LinearLayout menuItems;
  private final View.OnClickListener onClickListener = new DriverOverflowMenuView.2(this);
  private final Action1<DriverRide> onRouteUpdated = new DriverOverflowMenuView.3(this);
  @Inject
  IDriverRideProvider routeProvider;
  @Inject
  IUserProvider userProvider;
  
  public DriverOverflowMenuView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
  }
  
  private void addCallPassengerButtons()
  {
    if (!shouldDisplayCallPassenger()) {
      return;
    }
    addCallPassengerButtons(routeProvider.getDriverRide().getCurrentRouteNotDroppedOffPassengers());
  }
  
  private void addCallPassengerButtons(List<DriverRidePassenger> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      DriverRidePassenger localDriverRidePassenger = (DriverRidePassenger)paramList.next();
      CallPassengerMenuItem localCallPassengerMenuItem = new CallPassengerMenuItem(getContext());
      localCallPassengerMenuItem.setPassenger(localDriverRidePassenger.getFirstName(), localDriverRidePassenger.getPhotoUrl(), localDriverRidePassenger.getPartySize(), localDriverRidePassenger.isPickedup());
      localCallPassengerMenuItem.setOnClickListener(new DriverOverflowMenuView.5(this, localDriverRidePassenger));
      localCallPassengerMenuItem.setId(2131558402);
      menuItems.addView(localCallPassengerMenuItem);
    }
  }
  
  private void addMenuItem(int paramInt1, String paramString, int paramInt2, boolean paramBoolean)
  {
    if (menuItems.findViewById(paramInt1) == null)
    {
      OverflowMenuItem localOverflowMenuItem = new OverflowMenuItem(getContext());
      localOverflowMenuItem.setTitle(paramString).setIconId(paramInt2).isNewItem(paramBoolean).setId(paramInt1);
      localOverflowMenuItem.setOnClickListener(onClickListener);
      menuItems.addView(localOverflowMenuItem);
    }
  }
  
  private List<String> getPassengerIds()
  {
    return Iterables.map(routeProvider.getDriverRide().getPassengersFromCurrentRoute(), new DriverOverflowMenuView.4(this));
  }
  
  private void initMenuItems()
  {
    addMenuItem(2131558430, getResources().getString(2131165586), 2130838251, false);
    addCallPassengerButtons();
    addMenuItem(2131558400, getResources().getString(2131165282), 2130838105, false);
    addMenuItem(2131558438, getResources().getString(2131165769), 2130838326, false);
    addMenuItem(2131558403, getResources().getString(2131165361), 2130838160, false);
  }
  
  private void onMenuItemClicked(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 2131558402: 
      dialogFlow.show(new DriverDialogs.CallConfirmationDialog(routeProvider.getDriverRide().getCurrentPassenger(), routeProvider.getDriverRide().getCurrentStop().getScheduledTime()));
      return;
    case 2131558400: 
      dialogFlow.show(new DriverDialogs.CourierDriverInfoDialog());
      return;
    case 2131558403: 
      dialogFlow.show(new DriverDialogs.DriverCancellationConfirmationDialog());
      return;
    case 2131558438: 
      appFlow.goTo(new HelpScreens.HelpScreen(true));
      return;
    }
    if (userProvider.getUser().isDispatchable())
    {
      destinyService.switchToDestiny().first().subscribe(new DriverOverflowMenuView.6(this));
      return;
    }
    appFlow.goTo(new DriverSetDestinyScreen(Location.empty(), false));
  }
  
  private void setItemVisible(int paramInt, boolean paramBoolean)
  {
    View localView = menuItems.findViewById(paramInt);
    if (localView != null) {
      if (!paramBoolean) {
        break label25;
      }
    }
    label25:
    for (paramInt = 0;; paramInt = 8)
    {
      localView.setVisibility(paramInt);
      return;
    }
  }
  
  private boolean shouldDisplayCallPassenger()
  {
    return (routeProvider.getDriverRide().isPending()) || (routeProvider.getDriverRide().isAccepted()) || (routeProvider.getDriverRide().isArrived()) || (routeProvider.getDriverRide().isPickedUp());
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    loadedPassengerIds = getPassengerIds();
    backgroundView.setOnClickListener(new DriverOverflowMenuView.1(this));
    initMenuItems();
    binder = Binder.attach(this);
    binder.bind(routeProvider.observeRide(), onRouteUpdated);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    ButterKnife.bind(this);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.driver.DriverOverflowMenuView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */