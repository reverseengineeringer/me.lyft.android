package me.lyft.android.ui.ride;

import android.content.res.Resources;
import android.view.LayoutInflater;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import me.lyft.android.analytics.EditPickupAnalytics;
import me.lyft.android.application.eta.IPickupEtaService;
import me.lyft.android.application.features.IFeaturesProvider;
import me.lyft.android.application.passenger.IPassengerRideProvider;
import me.lyft.android.application.requestridetypes.IRequestRideTypeService;
import me.lyft.android.application.ride.IRideRequestSession;
import me.lyft.android.common.AppFlow;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.maps.MapOwner;
import me.lyft.android.maps.renderers.PinTextRenderer;
import me.lyft.android.maps.renderers.VenueMarkerRenderer;
import me.lyft.android.maps.renderers.VenueMergingMarkerRenderer;
import me.lyft.android.maps.renderers.VenuePolygonRenderer;
import me.lyft.android.ui.IViewErrorHandler;
import me.lyft.android.ui.MainActivityModule;
import me.lyft.android.ui.driver.RideOverviewMapButton;
import me.lyft.android.ui.passenger.PromoBannerView;
import me.lyft.android.ui.passenger.v2.PassengerAnalytics;
import me.lyft.android.ui.passenger.v2.PassengerMapController;
import me.lyft.android.ui.passenger.v2.PassengerRideRouter;
import me.lyft.android.ui.passenger.v2.RideTypeInfoHeaderView;
import me.lyft.android.ui.passenger.v2.inride.PassengerAddressActions;
import me.lyft.android.ui.passenger.v2.inride.RideFooterView;
import me.lyft.android.ui.passenger.v2.request.LockedRouteErrorHandler;
import me.lyft.android.ui.passenger.v2.request.pickup.PickupPinPresenter;
import me.lyft.android.ui.passenger.v2.request.pickup.ScheduledRidesPicker;
import me.lyft.android.ui.passenger.v2.request.venue.IntroduceVenueController;

@Module(addsTo=MainActivityModule.class, complete=false, injects={PromoBannerView.class, RideOverviewMapButton.class, RideTypeInfoHeaderView.class, RideFooterView.class, ScheduledRidesPicker.class, IntroduceVenueController.class}, library=true)
public class PassengerRideModule
{
  @Provides
  PassengerAddressActions provideAddressActions(AppFlow paramAppFlow, DialogFlow paramDialogFlow, IPassengerRideProvider paramIPassengerRideProvider, EditPickupAnalytics paramEditPickupAnalytics)
  {
    return new PassengerAddressActions(paramAppFlow, paramDialogFlow, paramIPassengerRideProvider, paramEditPickupAnalytics);
  }
  
  @Provides
  LockedRouteErrorHandler provideLockedRouteErrorHandler(PassengerRideRouter paramPassengerRideRouter, IViewErrorHandler paramIViewErrorHandler)
  {
    return new LockedRouteErrorHandler(paramPassengerRideRouter, paramIViewErrorHandler);
  }
  
  @Provides
  @Singleton
  VenueMarkerRenderer provideMarkerRenderer(MapOwner paramMapOwner, Resources paramResources)
  {
    return new VenueMarkerRenderer(paramMapOwner, paramResources);
  }
  
  @Provides
  @Singleton
  VenueMergingMarkerRenderer provideMergingMarkerRenderer(MapOwner paramMapOwner, Resources paramResources)
  {
    return new VenueMergingMarkerRenderer(paramMapOwner, paramResources);
  }
  
  @Provides
  @Singleton
  PassengerAnalytics providePassengerAnalytics()
  {
    return new PassengerAnalytics();
  }
  
  @Provides
  @Singleton
  PassengerMapController providePassengerMapPresenter(RideMap paramRideMap, LayoutInflater paramLayoutInflater, Resources paramResources, PinTextRenderer paramPinTextRenderer, PassengerAnalytics paramPassengerAnalytics, IFeaturesProvider paramIFeaturesProvider)
  {
    return new PassengerMapController(paramRideMap, paramLayoutInflater, paramResources, paramPinTextRenderer, paramPassengerAnalytics, paramIFeaturesProvider);
  }
  
  @Provides
  @Singleton
  PickupPinPresenter providePickupPinPresenter(IPickupEtaService paramIPickupEtaService, IRideRequestSession paramIRideRequestSession, PassengerMapController paramPassengerMapController, IRequestRideTypeService paramIRequestRideTypeService)
  {
    return new PickupPinPresenter(paramIPickupEtaService, paramIRideRequestSession, paramIRequestRideTypeService, paramPassengerMapController);
  }
  
  @Provides
  @Singleton
  VenuePolygonRenderer provideVenuePolygonRenderer(MapOwner paramMapOwner, Resources paramResources)
  {
    return new VenuePolygonRenderer(paramMapOwner, paramResources);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.ride.PassengerRideModule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */