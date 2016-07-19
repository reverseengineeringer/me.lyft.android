package me.lyft.android.ui.passenger.v2.request.destination;

import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import me.lyft.android.application.eta.IPickupEtaService;
import me.lyft.android.application.geo.IGeoService;
import me.lyft.android.application.polling.ILocationUpdateService;
import me.lyft.android.application.ride.IRideRequestSession;
import me.lyft.android.application.ride.IScheduledRideTimesService;
import me.lyft.android.application.ride.flow.IRequestFlowProvider;
import me.lyft.android.infrastructure.location.ILocationService;
import me.lyft.android.ui.passenger.v2.PassengerAnalytics;
import me.lyft.android.ui.passenger.v2.PassengerMapController;
import me.lyft.android.ui.passenger.v2.PassengerRideRouter;
import me.lyft.android.ui.passenger.v2.request.LockedRouteErrorHandler;
import me.lyft.android.ui.passenger.v2.request.RequestModule;

@Module(addsTo=RequestModule.class, complete=false, injects={SetDestinationView.class})
public class SetDestinationModule
{
  @Provides
  @Singleton
  SetDestinationPresenter provideSetDestinationPresenter(PassengerMapController paramPassengerMapController, ILocationService paramILocationService, IRideRequestSession paramIRideRequestSession, ILocationUpdateService paramILocationUpdateService, IGeoService paramIGeoService, PassengerRideRouter paramPassengerRideRouter, IRequestFlowProvider paramIRequestFlowProvider, IPickupEtaService paramIPickupEtaService, IScheduledRideTimesService paramIScheduledRideTimesService, LockedRouteErrorHandler paramLockedRouteErrorHandler, PassengerAnalytics paramPassengerAnalytics)
  {
    return new SetDestinationPresenter(paramPassengerMapController, paramILocationService, paramIRideRequestSession, paramIGeoService, paramILocationUpdateService, paramPassengerRideRouter, paramIRequestFlowProvider, paramIPickupEtaService, paramIScheduledRideTimesService, paramLockedRouteErrorHandler, paramPassengerAnalytics);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.passenger.v2.request.destination.SetDestinationModule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */