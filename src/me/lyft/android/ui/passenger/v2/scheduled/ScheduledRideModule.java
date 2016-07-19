package me.lyft.android.ui.passenger.v2.scheduled;

import dagger.Module;
import dagger.Provides;
import me.lyft.android.application.requestridetypes.IRequestRideTypeService;
import me.lyft.android.application.ride.services.IScheduledRideService;
import me.lyft.android.infrastructure.assets.IAssetLoadingService;
import me.lyft.android.ui.passenger.v2.PassengerMapController;
import me.lyft.android.ui.passenger.v2.PassengerRideRouter;
import me.lyft.android.ui.ride.PassengerRideModule;

@Module(addsTo=PassengerRideModule.class, complete=false, injects={ScheduledRideViewController.class}, library=true)
public class ScheduledRideModule
{
  @Provides
  public ScheduledRideViewController provideScheduledRideViewController(PassengerMapController paramPassengerMapController, IAssetLoadingService paramIAssetLoadingService, IRequestRideTypeService paramIRequestRideTypeService, IScheduledRideService paramIScheduledRideService, PassengerRideRouter paramPassengerRideRouter)
  {
    return new ScheduledRideViewController(paramPassengerMapController, paramIAssetLoadingService, paramIRequestRideTypeService, paramIScheduledRideService, paramPassengerRideRouter);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.passenger.v2.scheduled.ScheduledRideModule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */