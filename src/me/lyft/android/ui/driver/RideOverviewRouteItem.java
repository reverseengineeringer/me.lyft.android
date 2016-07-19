package me.lyft.android.ui.driver;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.lyft.scoop.Scoop;
import com.lyft.scoop.dagger.DaggerInjector;
import javax.inject.Inject;
import me.lyft.android.application.geo.IGeoService;
import me.lyft.android.application.ride.IDriverRideProvider;
import me.lyft.android.common.AppFlow;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.domain.driver.ride.DriverRide;
import me.lyft.android.domain.driver.ride.DriverRidePassenger;
import me.lyft.android.domain.driver.ride.DriverStop;
import me.lyft.android.domain.location.Location;
import me.lyft.android.navigation.Navigator;
import me.lyft.android.rx.Binder;

public class RideOverviewRouteItem
  extends RelativeLayout
{
  @Inject
  AppFlow appFlow;
  private Binder binder;
  View dashedPathView;
  @Inject
  DialogFlow dialogFlow;
  private final DriverRide driverRide;
  @Inject
  IDriverRideProvider driverRideProvider;
  @Inject
  IGeoService geoService;
  Button navigateButton;
  @Inject
  Navigator navigator;
  View pathView;
  private boolean showNavigation;
  private DriverStop stop;
  ImageView stopImageView;
  TextView subtitleTextView;
  TextView titleTextView;
  
  public RideOverviewRouteItem(Context paramContext)
  {
    super(paramContext);
    DaggerInjector.fromView(this).inject(this);
    driverRide = driverRideProvider.getDriverRide();
    Scoop.fromView(this).inflater(getContext()).inflate(2130903432, this, true);
    ButterKnife.bind(this);
  }
  
  private void createRoutPathElements()
  {
    int j = 0;
    boolean bool1 = driverRide.isLastStopInRoute(stop);
    boolean bool2 = driverRide.isLastStop(stop);
    View localView = pathView;
    if ((bool2) || (bool1))
    {
      i = 4;
      localView.setVisibility(i);
      localView = dashedPathView;
      if ((!bool1) || (bool2)) {
        break label111;
      }
      i = j;
      label67:
      localView.setVisibility(i);
      localView = pathView;
      if (!stop.isCompleted()) {
        break label116;
      }
    }
    label111:
    label116:
    for (int i = getResources().getColor(2131492984);; i = getResources().getColor(2131492898))
    {
      localView.setBackgroundColor(i);
      return;
      i = 0;
      break;
      i = 4;
      break label67;
    }
  }
  
  private int getStopImage()
  {
    if (driverRide.isCurrentStop(stop)) {
      return 2130838193;
    }
    if (stop.isCompleted()) {
      return 2130838192;
    }
    return 2130838335;
  }
  
  private void setLocationColor()
  {
    if (stop.isCompleted())
    {
      titleTextView.setTextColor(getResources().getColor(2131492984));
      subtitleTextView.setTextColor(getResources().getColor(2131492984));
      return;
    }
    titleTextView.setTextColor(getResources().getColor(2131492898));
    subtitleTextView.setTextColor(getResources().getColor(2131492984));
  }
  
  private void setLocationSubtitle()
  {
    Location localLocation = stop.getLocation();
    if ((localLocation.isNull()) && (stop.isDropOff()))
    {
      subtitleTextView.setText(getResources().getString(2131166277));
      return;
    }
    binder.bind(geoService.reverseGeocode(localLocation), new RideOverviewRouteItem.1(this));
  }
  
  private void setLocationTitle()
  {
    TextView localTextView = titleTextView;
    Resources localResources = getResources();
    if (stop.isDropOff()) {}
    for (int i = 2131166278;; i = 2131166279)
    {
      localTextView.setText(localResources.getString(i, new Object[] { stop.getPassenger().getFirstName() }));
      return;
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    binder = Binder.attach(this);
    stopImageView.setImageResource(getStopImage());
    Button localButton = navigateButton;
    if (showNavigation) {}
    for (int i = 0;; i = 8)
    {
      localButton.setVisibility(i);
      setLocationTitle();
      setLocationSubtitle();
      setLocationColor();
      createRoutPathElements();
      return;
    }
  }
  
  void openNavigation()
  {
    if (driverRide.isTrainingRide())
    {
      appFlow.goTo(new DriverScreens.TrainingRideNavigationScreen());
      return;
    }
    navigator.navigate(stop.getLocation());
  }
  
  public void setStop(DriverStop paramDriverStop)
  {
    stop = paramDriverStop;
  }
  
  public void showNavigation()
  {
    showNavigation = true;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.driver.RideOverviewRouteItem
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */