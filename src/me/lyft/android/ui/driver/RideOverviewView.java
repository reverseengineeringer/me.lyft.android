package me.lyft.android.ui.driver;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.lyft.scoop.Screen;
import com.lyft.scoop.dagger.DaggerInjector;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import me.lyft.android.application.ride.IDriverRideProvider;
import me.lyft.android.common.AppFlow;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.controls.Toolbar;
import me.lyft.android.domain.driver.ride.DriverRide;
import me.lyft.android.domain.driver.ride.DriverRidePassenger;
import me.lyft.android.domain.driver.ride.DriverStop;
import me.lyft.android.domain.location.Location;
import me.lyft.android.rx.Binder;

public class RideOverviewView
  extends LinearLayout
{
  @Inject
  AppFlow appFlow;
  @Inject
  DialogFlow dialogFlow;
  LinearLayout partyContainer;
  TextView poorConnectionBanner;
  LinearLayout routeContainer;
  @Inject
  IDriverRideProvider routeProvider;
  private DriverScreens.RideOverviewScreen screen;
  Toolbar toolbar;
  
  public RideOverviewView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
    screen = ((DriverScreens.RideOverviewScreen)Screen.fromView(this));
  }
  
  private void updatePartyView()
  {
    partyContainer.removeAllViews();
    Iterator localIterator = routeProvider.getDriverRide().getAllPassengers().iterator();
    while (localIterator.hasNext())
    {
      DriverRidePassenger localDriverRidePassenger = (DriverRidePassenger)localIterator.next();
      RideOverviewPartyItem localRideOverviewPartyItem = new RideOverviewPartyItem(getContext());
      localRideOverviewPartyItem.setPartyFirstName(localDriverRidePassenger.getFirstName());
      localRideOverviewPartyItem.setPartyProfilePhoto(localDriverRidePassenger.getPhotoUrl());
      localRideOverviewPartyItem.setCallPassengerButtonAction(new RideOverviewView.2(this, localDriverRidePassenger));
      localRideOverviewPartyItem.setPartySize(Integer.valueOf(localDriverRidePassenger.getPartySize()));
      localRideOverviewPartyItem.setCallEnabled();
      partyContainer.addView(localRideOverviewPartyItem);
    }
  }
  
  private void updateRouteView()
  {
    routeContainer.removeAllViews();
    DriverRide localDriverRide = routeProvider.getDriverRide();
    Iterator localIterator = localDriverRide.getAllStops().iterator();
    if (localIterator.hasNext())
    {
      DriverStop localDriverStop = (DriverStop)localIterator.next();
      RideOverviewRouteItem localRideOverviewRouteItem = new RideOverviewRouteItem(getContext());
      localRideOverviewRouteItem.setStop(localDriverStop);
      int i;
      label85:
      boolean bool;
      if (!localDriverStop.getLocation().isNull())
      {
        i = 1;
        bool = localDriverRide.isCurrentStop(localDriverStop);
        if ((!localDriverRide.isNextStop(localDriverStop)) || (!localDriverRide.isArrived())) {
          break label147;
        }
      }
      label147:
      for (int j = 1;; j = 0)
      {
        if ((i != 0) && ((bool) || (j != 0))) {
          localRideOverviewRouteItem.showNavigation();
        }
        routeContainer.addView(localRideOverviewRouteItem);
        break;
        i = 0;
        break label85;
      }
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (isInEditMode()) {
      return;
    }
    Binder localBinder = Binder.attach(this);
    if (screen.isNetworkError().booleanValue()) {
      poorConnectionBanner.setVisibility(0);
    }
    toolbar.displayBackButton();
    toolbar.setTitle(getResources().getString(2131166276));
    updatePartyView();
    updateRouteView();
    localBinder.bind(toolbar.observeHomeClick(), new RideOverviewView.1(this));
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    ButterKnife.bind(this);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.driver.RideOverviewView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */