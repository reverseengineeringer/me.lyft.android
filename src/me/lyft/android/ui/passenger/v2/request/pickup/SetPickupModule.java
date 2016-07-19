package me.lyft.android.ui.passenger.v2.request.pickup;

import com.lyft.rx.MessageBus;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.application.eta.IPickupEtaService;
import me.lyft.android.application.geo.IGeoService;
import me.lyft.android.application.polling.ILocationUpdateService;
import me.lyft.android.application.requestridetypes.IRequestRideTypeService;
import me.lyft.android.application.ride.IFollowLocationManager;
import me.lyft.android.application.ride.IRideRequestSession;
import me.lyft.android.application.ride.flow.IRequestFlowProvider;
import me.lyft.android.application.ride.services.IScheduledRideService;
import me.lyft.android.application.venue.IVenuePickupService;
import me.lyft.android.infrastructure.location.ILocationService;
import me.lyft.android.maps.renderers.VenueMergingMarkerRenderer;
import me.lyft.android.ui.passenger.v2.PassengerAnalytics;
import me.lyft.android.ui.passenger.v2.PassengerMapController;
import me.lyft.android.ui.passenger.v2.PassengerRideRouter;
import me.lyft.android.ui.passenger.v2.request.RequestModule;

@Module(addsTo=RequestModule.class, complete=false, injects={SetPickupView.class, RideTypeSelectionView.class, RideTypeSelectionItemView.class})
public class SetPickupModule
{
  @Provides
  @Singleton
  SetPickupPresenter provideSetPickupPresenter(ILocationService paramILocationService, IRideRequestSession paramIRideRequestSession, IGeoService paramIGeoService, IRequestRideTypeService paramIRequestRideTypeService, PassengerMapController paramPassengerMapController, IUserProvider paramIUserProvider, ILocationUpdateService paramILocationUpdateService, PassengerRideRouter paramPassengerRideRouter, IVenuePickupService paramIVenuePickupService, IRequestFlowProvider paramIRequestFlowProvider, ILyftPreferences paramILyftPreferences, IFollowLocationManager paramIFollowLocationManager, VenueMergingMarkerRenderer paramVenueMergingMarkerRenderer, MessageBus paramMessageBus, IScheduledRideService paramIScheduledRideService, PassengerAnalytics paramPassengerAnalytics, IPickupEtaService paramIPickupEtaService)
  {
    return new SetPickupPresenter(paramILocationService, paramIRideRequestSession, paramIGeoService, paramIRequestRideTypeService, paramIUserProvider, paramILocationUpdateService, paramPassengerRideRouter, paramIVenuePickupService, paramIRequestFlowProvider, paramPassengerMapController, paramILyftPreferences, paramIFollowLocationManager, paramVenueMergingMarkerRenderer, paramMessageBus, paramIScheduledRideService, paramPassengerAnalytics, paramIPickupEtaService);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.passenger.v2.request.pickup.SetPickupModule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */