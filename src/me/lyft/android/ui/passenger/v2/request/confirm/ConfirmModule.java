package me.lyft.android.ui.passenger.v2.request.confirm;

import android.content.res.Resources;
import com.lyft.rx.MessageBus;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.application.eta.IPickupEtaService;
import me.lyft.android.application.geo.IGeoService;
import me.lyft.android.application.polling.ILocationUpdateService;
import me.lyft.android.application.requestridetypes.IRequestRideTypeService;
import me.lyft.android.application.requestridetypes.IRideTypeMetaService;
import me.lyft.android.application.ride.IRideRequestService;
import me.lyft.android.application.ride.IRideRequestSession;
import me.lyft.android.application.ride.flow.IRequestFlowProvider;
import me.lyft.android.infrastructure.location.ILocationService;
import me.lyft.android.infrastructure.locationsettings.ILocationSettingsService;
import me.lyft.android.maps.renderers.PinTextRenderer;
import me.lyft.android.ui.IProgressController;
import me.lyft.android.ui.IViewErrorHandler;
import me.lyft.android.ui.passenger.v2.PassengerAnalytics;
import me.lyft.android.ui.passenger.v2.PassengerMapController;
import me.lyft.android.ui.passenger.v2.PassengerRideRouter;
import me.lyft.android.ui.passenger.v2.request.RequestModule;
import me.lyft.android.ui.passenger.v2.request.destination.SetDestinationView;
import me.lyft.android.ui.ride.RideMap;

@Module(addsTo=RequestModule.class, complete=false, injects={SetDestinationView.class, ConfirmPickupAndDestinationView.class})
public class ConfirmModule
{
  @Provides
  @Singleton
  RequestRideButtonPresenter provideRequestRideButtonController(IRideRequestService paramIRideRequestService, IProgressController paramIProgressController, IViewErrorHandler paramIViewErrorHandler, ILocationSettingsService paramILocationSettingsService, RideMap paramRideMap, MessageBus paramMessageBus, PassengerRideRouter paramPassengerRideRouter, IRideRequestSession paramIRideRequestSession, IRequestFlowProvider paramIRequestFlowProvider)
  {
    return new RequestRideButtonPresenter(paramIRideRequestService, paramIProgressController, paramIViewErrorHandler, paramILocationSettingsService, paramRideMap, paramMessageBus, paramPassengerRideRouter, paramIRideRequestSession, paramIRequestFlowProvider);
  }
  
  @Provides
  @Singleton
  ConfirmPresenter provideSetDestinationController(PassengerMapController paramPassengerMapController, ILocationService paramILocationService, IRideRequestSession paramIRideRequestSession, IGeoService paramIGeoService, ILocationUpdateService paramILocationUpdateService, PassengerRideRouter paramPassengerRideRouter, IRideTypeMetaService paramIRideTypeMetaService, IRequestFlowProvider paramIRequestFlowProvider, IUserProvider paramIUserProvider, IRequestRideTypeService paramIRequestRideTypeService, IPickupEtaService paramIPickupEtaService, PassengerAnalytics paramPassengerAnalytics, PinTextRenderer paramPinTextRenderer, Resources paramResources)
  {
    return new ConfirmPresenter(paramPassengerMapController, paramILocationService, paramIRideRequestSession, paramIGeoService, paramILocationUpdateService, paramPassengerRideRouter, paramIRideTypeMetaService, paramIRequestFlowProvider, paramIUserProvider, paramIRequestRideTypeService, paramIPickupEtaService, paramPassengerAnalytics, paramPinTextRenderer, paramResources);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.passenger.v2.request.confirm.ConfirmModule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */