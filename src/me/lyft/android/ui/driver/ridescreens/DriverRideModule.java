package me.lyft.android.ui.driver.ridescreens;

import dagger.Module;
import dagger.Provides;
import me.lyft.android.application.ride.IDriverRideProvider;
import me.lyft.android.common.AppFlow;
import me.lyft.android.controls.DriverBottomNavigationView;
import me.lyft.android.controls.DriverToolbar;
import me.lyft.android.maps.MapOwner;
import me.lyft.android.maps.zooming.FitToIncompleteStops;
import me.lyft.android.maps.zooming.FollowCurrentLocationAndFitToNextStop;
import me.lyft.android.ui.MainActivityModule;
import me.lyft.android.ui.driver.DriverActiveRideZoomingController;
import me.lyft.android.ui.driver.DriverRideRatingAndEarningsView;
import me.lyft.android.ui.driver.RideOverviewMapButton;
import me.lyft.android.ui.driver.TrainingRideNavigationController;
import me.lyft.android.ui.passenger.PromoBannerView;

@Module(addsTo=MainActivityModule.class, injects={PromoBannerView.class, DriverRideController.class, DriverRideRatingAndEarningsView.class, RideOverviewMapButton.class, DriverBottomNavigationView.class, DriverToolbar.class, TrainingRideNavigationController.class}, library=true)
public class DriverRideModule
{
  @Provides
  public TrainingRideNavigationController provideTrainingRideNavigationController(AppFlow paramAppFlow)
  {
    return new TrainingRideNavigationController(paramAppFlow);
  }
  
  @Provides
  public DriverActiveRideZoomingController provideZoomingController(IDriverRideProvider paramIDriverRideProvider, MapOwner paramMapOwner, FollowCurrentLocationAndFitToNextStop paramFollowCurrentLocationAndFitToNextStop, FitToIncompleteStops paramFitToIncompleteStops)
  {
    return new DriverActiveRideZoomingController(paramMapOwner, paramIDriverRideProvider, paramFollowCurrentLocationAndFitToNextStop, paramFitToIncompleteStops);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.driver.ridescreens.DriverRideModule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */