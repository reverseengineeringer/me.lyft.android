package me.lyft.android.ui.passenger.v2.request.time;

import android.content.res.Resources;
import dagger.Module;
import dagger.Provides;
import me.lyft.android.application.eta.IPickupEtaService;
import me.lyft.android.application.geo.IGeoService;
import me.lyft.android.application.ride.IRideRequestSession;
import me.lyft.android.application.ride.IScheduledRideTimesService;
import me.lyft.android.application.ride.flow.IRequestFlowProvider;
import me.lyft.android.infrastructure.location.ILocationService;
import me.lyft.android.maps.renderers.PinTextRenderer;
import me.lyft.android.ui.passenger.v2.PassengerMapController;
import me.lyft.android.ui.passenger.v2.PassengerRideRouter;
import me.lyft.android.ui.passenger.v2.request.LockedRouteErrorHandler;
import me.lyft.android.ui.passenger.v2.request.RequestModule;

@Module(addsTo=RequestModule.class, complete=false, injects={SetFixedTimeRangeView.class, SetFlexibleTimeRangeView.class})
public class SetTimeModule
{
  @Provides
  SetFixedTimeRangePresenter provideSetFixedTimeRangePresenter(PassengerMapController paramPassengerMapController, ILocationService paramILocationService, IGeoService paramIGeoService, IRideRequestSession paramIRideRequestSession, IRequestFlowProvider paramIRequestFlowProvider, IScheduledRideTimesService paramIScheduledRideTimesService, IPickupEtaService paramIPickupEtaService, PassengerRideRouter paramPassengerRideRouter, LockedRouteErrorHandler paramLockedRouteErrorHandler, PinTextRenderer paramPinTextRenderer, Resources paramResources)
  {
    return new SetFixedTimeRangePresenter(paramPassengerMapController, paramILocationService, paramIGeoService, paramIRideRequestSession, paramIRequestFlowProvider, paramIScheduledRideTimesService, paramIPickupEtaService, paramPassengerRideRouter, paramLockedRouteErrorHandler, paramPinTextRenderer, paramResources);
  }
  
  @Provides
  SetFlexibleTimeRangePresenter provideSetFlexibleTimeRangePresenter(PassengerMapController paramPassengerMapController, ILocationService paramILocationService, IGeoService paramIGeoService, IRideRequestSession paramIRideRequestSession, IRequestFlowProvider paramIRequestFlowProvider, IScheduledRideTimesService paramIScheduledRideTimesService, LockedRouteErrorHandler paramLockedRouteErrorHandler, PinTextRenderer paramPinTextRenderer, Resources paramResources)
  {
    return new SetFlexibleTimeRangePresenter(paramPassengerMapController, paramILocationService, paramIGeoService, paramIRideRequestSession, paramIRequestFlowProvider, paramIScheduledRideTimesService, paramLockedRouteErrorHandler, paramPinTextRenderer, paramResources);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.passenger.v2.request.time.SetTimeModule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */