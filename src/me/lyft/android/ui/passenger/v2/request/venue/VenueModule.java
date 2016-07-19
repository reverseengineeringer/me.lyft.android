package me.lyft.android.ui.passenger.v2.request.venue;

import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import me.lyft.android.application.geo.IGeoService;
import me.lyft.android.application.ride.IRideRequestSession;
import me.lyft.android.application.ride.flow.IRequestFlowProvider;
import me.lyft.android.application.venue.IVenuePickupService;
import me.lyft.android.infrastructure.location.ILocationService;
import me.lyft.android.maps.renderers.VenueMarkerRenderer;
import me.lyft.android.ui.passenger.v2.PassengerMapController;
import me.lyft.android.ui.passenger.v2.request.RequestModule;

@Module(addsTo=RequestModule.class, complete=false, injects={VenueRideView.class})
public class VenueModule
{
  @Provides
  @Singleton
  VenuePresenter provideVenuePresenter(PassengerMapController paramPassengerMapController, ILocationService paramILocationService, IRideRequestSession paramIRideRequestSession, IGeoService paramIGeoService, IVenuePickupService paramIVenuePickupService, IRequestFlowProvider paramIRequestFlowProvider, VenueMarkerRenderer paramVenueMarkerRenderer)
  {
    return new VenuePresenter(paramPassengerMapController, paramILocationService, paramIRideRequestSession, paramIGeoService, paramIVenuePickupService, paramIRequestFlowProvider, paramVenueMarkerRenderer);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.passenger.v2.request.venue.VenueModule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */