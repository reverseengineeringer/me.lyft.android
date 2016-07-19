package me.lyft.android.maps;

import android.content.res.Resources;
import android.view.LayoutInflater;
import dagger.Lazy;
import dagger.Module;
import dagger.Provides;
import javax.inject.Named;
import javax.inject.Singleton;
import me.lyft.android.LyftApplication;
import me.lyft.android.application.constants.IConstantsProvider;
import me.lyft.android.application.drivers.INearbyDriversService;
import me.lyft.android.application.geo.IDirectionsService;
import me.lyft.android.application.passenger.IPassengerRideProvider;
import me.lyft.android.application.passenger.IPassengerRoutingService;
import me.lyft.android.application.requestridetypes.IRideTypeMetaService;
import me.lyft.android.application.ride.IDriverRideProvider;
import me.lyft.android.application.ride.IRideRequestSession;
import me.lyft.android.application.shortcuts.IShortcutService;
import me.lyft.android.driver.ui.IDriverAssetService;
import me.lyft.android.infrastructure.location.ILocationService;
import me.lyft.android.maps.markers.MarkerManager;
import me.lyft.android.maps.renderers.DriverCarRenderer;
import me.lyft.android.maps.renderers.DriverRouteRenderer;
import me.lyft.android.maps.renderers.HeatmapRenderer;
import me.lyft.android.maps.renderers.LineDriverRouteRenderer;
import me.lyft.android.maps.renderers.NearbyDriversRenderer;
import me.lyft.android.maps.renderers.PassengerDestinationPinRenderer;
import me.lyft.android.maps.renderers.PassengerDestinationReceiptRenderer;
import me.lyft.android.maps.renderers.PassengerLineStopsRenderer;
import me.lyft.android.maps.renderers.PassengerLocationRenderer;
import me.lyft.android.maps.renderers.PickupGeofenceRenderer;
import me.lyft.android.maps.renderers.PinTextRenderer;
import me.lyft.android.maps.renderers.ShortcutRenderer;
import me.lyft.android.maps.renderers.common.PolylineRenderer;
import me.lyft.android.maps.renderers.passenger.routing.ActiveSegmentRenderer;
import me.lyft.android.maps.renderers.passenger.routing.FullRouteRenderer;
import me.lyft.android.maps.renderers.passenger.routing.OnlyDropoffRenderer;
import me.lyft.android.maps.renderers.passenger.routing.PassengerRouteRenderer;
import me.lyft.android.maps.renderers.passenger.routing.RideTypeDependentRouteRenderer;
import me.lyft.android.maps.zooming.FitToIncompleteStops;
import me.lyft.android.maps.zooming.FitToShortcuts;
import me.lyft.android.maps.zooming.FollowCurrentLocation;
import me.lyft.android.maps.zooming.FollowCurrentLocationAndFitToNextStop;
import me.lyft.android.persistence.ride.IPassengerRideReceiptService;
import me.lyft.android.ui.ride.RideMap;

@Module(complete=false, library=true)
public class MapsModule
{
  @Provides
  @Singleton
  PolylineRenderer polylineRenderer(MapOwner paramMapOwner)
  {
    return new PolylineRenderer(paramMapOwner);
  }
  
  @Provides
  @Singleton
  ActiveSegmentRenderer provideActiveSegmentRenderer(IPassengerRideProvider paramIPassengerRideProvider, IPassengerRoutingService paramIPassengerRoutingService, PolylineRenderer paramPolylineRenderer, Resources paramResources)
  {
    return new ActiveSegmentRenderer(paramIPassengerRideProvider, paramIPassengerRoutingService, paramPolylineRenderer, paramResources);
  }
  
  @Provides
  @Singleton
  DriverCarRenderer provideDriverCarRenderer(LyftApplication paramLyftApplication, IPassengerRideProvider paramIPassengerRideProvider, MapOwner paramMapOwner, IDriverAssetService paramIDriverAssetService)
  {
    return new DriverCarRenderer(new SquaredTooltipFactory(paramLyftApplication), paramIPassengerRideProvider, paramMapOwner, paramIDriverAssetService);
  }
  
  @Provides
  @Singleton
  DriverRouteRenderer provideDriverRouteRenderer(IDriverRideProvider paramIDriverRideProvider, @Named("driver") IDirectionsService paramIDirectionsService, MapOwner paramMapOwner)
  {
    return new DriverRouteRenderer(paramIDriverRideProvider, paramIDirectionsService, paramMapOwner);
  }
  
  @Provides
  PassengerDestinationReceiptRenderer provideFitToPickupAndDestination(MapOwner paramMapOwner, IPassengerRideProvider paramIPassengerRideProvider, IPassengerRideReceiptService paramIPassengerRideReceiptService, PinTextRenderer paramPinTextRenderer, Resources paramResources)
  {
    return new PassengerDestinationReceiptRenderer(paramMapOwner, paramIPassengerRideProvider, paramIPassengerRideReceiptService, paramPinTextRenderer, paramResources);
  }
  
  @Provides
  @Singleton
  FitToShortcuts provideFitToShortcuts(MapOwner paramMapOwner, IShortcutService paramIShortcutService)
  {
    return new FitToShortcuts(paramMapOwner, paramIShortcutService);
  }
  
  @Provides
  @Singleton
  FollowCurrentLocation provideFollowCurrentLocation(MapOwner paramMapOwner, ILocationService paramILocationService)
  {
    return new FollowCurrentLocation(paramMapOwner, paramILocationService);
  }
  
  @Provides
  @Singleton
  FitToIncompleteStops provideFollowCurrentLocationAndFitToIncompleteStops(MapOwner paramMapOwner, ILocationService paramILocationService, IDriverRideProvider paramIDriverRideProvider)
  {
    return new FitToIncompleteStops(paramMapOwner, paramILocationService, paramIDriverRideProvider);
  }
  
  @Provides
  @Singleton
  FollowCurrentLocationAndFitToNextStop provideFollowCurrentLocationAndFitToNextStop(MapOwner paramMapOwner, ILocationService paramILocationService, IDriverRideProvider paramIDriverRideProvider)
  {
    return new FollowCurrentLocationAndFitToNextStop(paramMapOwner, paramILocationService, paramIDriverRideProvider);
  }
  
  @Provides
  @Singleton
  FullRouteRenderer provideFullRouteRenderer(IPassengerRideProvider paramIPassengerRideProvider, IPassengerRoutingService paramIPassengerRoutingService, PolylineRenderer paramPolylineRenderer, Resources paramResources)
  {
    return new FullRouteRenderer(paramIPassengerRideProvider, paramIPassengerRoutingService, paramPolylineRenderer, paramResources);
  }
  
  @Provides
  @Singleton
  HeatmapRenderer provideHeatmapRenderer(MapOwner paramMapOwner, IConstantsProvider paramIConstantsProvider)
  {
    return new HeatmapRenderer(paramMapOwner, paramIConstantsProvider);
  }
  
  @Provides
  @Singleton
  LineDriverRouteRenderer provideLineDriverRouteRenderer(IDriverRideProvider paramIDriverRideProvider, @Named("driver") IDirectionsService paramIDirectionsService, MapOwner paramMapOwner, Resources paramResources)
  {
    return new LineDriverRouteRenderer(paramIDriverRideProvider, paramIDirectionsService, paramMapOwner, paramResources);
  }
  
  @Provides
  @Singleton
  PassengerLineStopsRenderer provideLineStopsRenderer(MapOwner paramMapOwner, IPassengerRideProvider paramIPassengerRideProvider, Resources paramResources)
  {
    return new PassengerLineStopsRenderer(paramMapOwner, paramIPassengerRideProvider, paramResources);
  }
  
  @Provides
  @Singleton
  MarkerManager provideMapMarkerManager(LyftMapView paramLyftMapView)
  {
    return new MarkerManager(paramLyftMapView);
  }
  
  @Provides
  @Singleton
  MapOwner provideMapOwner(LyftMapView paramLyftMapView, MarkerManager paramMarkerManager, MarkerClickManager paramMarkerClickManager)
  {
    return new MapOwner(paramLyftMapView, paramMarkerManager, paramMarkerClickManager);
  }
  
  @Provides
  @Singleton
  MarkerClickManager provideMarkerClickManager(MarkerManager paramMarkerManager)
  {
    return new MarkerClickManager(paramMarkerManager);
  }
  
  @Provides
  @Singleton
  OnlyDropoffRenderer provideOnlyDropoffRenderer(IPassengerRideProvider paramIPassengerRideProvider, IPassengerRoutingService paramIPassengerRoutingService, PolylineRenderer paramPolylineRenderer, Resources paramResources)
  {
    return new OnlyDropoffRenderer(paramIPassengerRideProvider, paramIPassengerRoutingService, paramPolylineRenderer, paramResources);
  }
  
  @Provides
  @Singleton
  PassengerDestinationPinRenderer providePassengerDestinationPinRenderer(IPassengerRideProvider paramIPassengerRideProvider, MapOwner paramMapOwner, Resources paramResources)
  {
    return new PassengerDestinationPinRenderer(paramMapOwner, paramResources, paramIPassengerRideProvider);
  }
  
  @Provides
  @Singleton
  PassengerLocationRenderer providePassengerLocationRenderer(MapOwner paramMapOwner, Resources paramResources, IDriverRideProvider paramIDriverRideProvider)
  {
    return new PassengerLocationRenderer(paramMapOwner, paramResources, paramIDriverRideProvider);
  }
  
  @Provides
  @Singleton
  PassengerRouteRenderer providePassengerRouteRenderer(IPassengerRideProvider paramIPassengerRideProvider, IConstantsProvider paramIConstantsProvider, Lazy<ActiveSegmentRenderer> paramLazy, Lazy<FullRouteRenderer> paramLazy1, Lazy<OnlyDropoffRenderer> paramLazy2)
  {
    return new RideTypeDependentRouteRenderer(paramIPassengerRideProvider, paramIConstantsProvider, paramLazy, paramLazy1, paramLazy2);
  }
  
  @Provides
  @Singleton
  PickupGeofenceRenderer providePickupGeofenceRenderer(IPassengerRideProvider paramIPassengerRideProvider, MapOwner paramMapOwner, Resources paramResources)
  {
    return new PickupGeofenceRenderer(paramMapOwner, paramResources, paramIPassengerRideProvider);
  }
  
  @Provides
  @Singleton
  PinTextRenderer providePinTextRenderer(RideMap paramRideMap, LayoutInflater paramLayoutInflater)
  {
    return new PinTextRenderer(paramRideMap, paramLayoutInflater);
  }
  
  @Provides
  @Singleton
  ShortcutRenderer provideShortcutRenderer(MapOwner paramMapOwner, IShortcutService paramIShortcutService, Resources paramResources)
  {
    return new ShortcutRenderer(paramMapOwner, paramIShortcutService, paramResources);
  }
  
  @Provides
  @Singleton
  NearbyDriversRenderer providerNearbyDriversRenderer(MapOwner paramMapOwner, IRideTypeMetaService paramIRideTypeMetaService, IRideRequestSession paramIRideRequestSession, INearbyDriversService paramINearbyDriversService, IDriverAssetService paramIDriverAssetService)
  {
    return new NearbyDriversRenderer(paramMapOwner, paramIRideTypeMetaService, paramIRideRequestSession, paramINearbyDriversService, paramIDriverAssetService);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.maps.MapsModule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */