package me.lyft.android.ui.driver;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import butterknife.ButterKnife;
import com.lyft.scoop.Scoop;
import com.lyft.scoop.dagger.DaggerInjector;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import me.lyft.android.application.ride.IDriverRideProvider;
import me.lyft.android.common.AppFlow;
import me.lyft.android.domain.driver.ride.DriverRide;
import me.lyft.android.domain.driver.ride.DriverRidePassenger;
import me.lyft.android.rx.Binder;
import me.lyft.android.rx.ReactiveProperty;
import rx.functions.Action1;

public class RideOverviewMapButton
  extends LinearLayout
{
  private static final int MAX_DISPLAYED_PASSENGERS = 4;
  @Inject
  AppFlow appFlow;
  private ReactiveProperty<List<DriverRidePassenger>> currentPassengersSubject = ReactiveProperty.create(Collections.emptyList());
  private Action1<DriverRide> onRouteChanged = new RideOverviewMapButton.3(this);
  LinearLayout passengersContainer;
  LinearLayout queuedPassengersContainer;
  private ReactiveProperty<List<DriverRidePassenger>> queuedPassengersSubject = ReactiveProperty.create(Collections.emptyList());
  @Inject
  IDriverRideProvider routeProvider;
  
  public RideOverviewMapButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
    Scoop.fromView(this).inflater(paramContext).inflate(2130903430, this);
  }
  
  private RideProgressPassengerItem createPassengerItem(DriverRidePassenger paramDriverRidePassenger)
  {
    RideProgressPassengerItem localRideProgressPassengerItem = new RideProgressPassengerItem(getContext());
    localRideProgressPassengerItem.setPartyProfilePhoto(paramDriverRidePassenger.getPhotoUrl());
    localRideProgressPassengerItem.setPartySize(Integer.valueOf(paramDriverRidePassenger.getPartySize()));
    localRideProgressPassengerItem.setPickedUp(paramDriverRidePassenger.isPickedup());
    return localRideProgressPassengerItem;
  }
  
  private void updateQueuedRoutesOverviewLayout(List<DriverRidePassenger> paramList)
  {
    if (paramList.isEmpty()) {
      queuedPassengersContainer.setVisibility(8);
    }
    for (;;)
    {
      return;
      queuedPassengersContainer.setVisibility(0);
      queuedPassengersContainer.removeAllViews();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        RideProgressPassengerItem localRideProgressPassengerItem = createPassengerItem((DriverRidePassenger)paramList.next());
        queuedPassengersContainer.addView(localRideProgressPassengerItem);
      }
    }
  }
  
  private void updateRouteOverviewLayout(List<DriverRidePassenger> paramList)
  {
    passengersContainer.removeAllViews();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      RideProgressPassengerItem localRideProgressPassengerItem = createPassengerItem((DriverRidePassenger)paramList.next());
      passengersContainer.addView(localRideProgressPassengerItem);
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (isInEditMode()) {
      return;
    }
    Binder localBinder = Binder.attach(this);
    localBinder.bind(routeProvider.observeRide(), onRouteChanged);
    localBinder.bind(currentPassengersSubject, new RideOverviewMapButton.1(this));
    localBinder.bind(queuedPassengersSubject, new RideOverviewMapButton.2(this));
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    if (isInEditMode()) {
      return;
    }
    ButterKnife.bind(this);
  }
  
  public void openRideOverviewScreen()
  {
    appFlow.goTo(new DriverScreens.RideOverviewScreen(false));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.driver.RideOverviewMapButton
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */