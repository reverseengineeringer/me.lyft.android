package me.lyft.android.application;

import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.application.drivers.INearbyDriversService;
import me.lyft.android.application.eta.IPickupEtaFallbackService;
import me.lyft.android.application.geo.GoogleGeoAnalytics;
import me.lyft.android.application.ride.IRideRequestSession;
import me.lyft.android.infrastructure.googlegeo.IGoogleGeoApi;

public final class ApplicationServicesModule$$ModuleAdapter$ProvidePickupEtaFallbackServiceProvidesAdapter
  extends ProvidesBinding<IPickupEtaFallbackService>
{
  private Binding<GoogleGeoAnalytics> googleGeoAnalytics;
  private Binding<IGoogleGeoApi> googleGeoApi;
  private final ApplicationServicesModule module;
  private Binding<INearbyDriversService> nearbyDriversService;
  private Binding<IRideRequestSession> rideRequestSession;
  
  public ApplicationServicesModule$$ModuleAdapter$ProvidePickupEtaFallbackServiceProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
  {
    super("me.lyft.android.application.eta.IPickupEtaFallbackService", true, "me.lyft.android.application.ApplicationServicesModule", "providePickupEtaFallbackService");
    module = paramApplicationServicesModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    nearbyDriversService = paramLinker.requestBinding("me.lyft.android.application.drivers.INearbyDriversService", ApplicationServicesModule.class, getClass().getClassLoader());
    rideRequestSession = paramLinker.requestBinding("me.lyft.android.application.ride.IRideRequestSession", ApplicationServicesModule.class, getClass().getClassLoader());
    googleGeoApi = paramLinker.requestBinding("me.lyft.android.infrastructure.googlegeo.IGoogleGeoApi", ApplicationServicesModule.class, getClass().getClassLoader());
    googleGeoAnalytics = paramLinker.requestBinding("me.lyft.android.application.geo.GoogleGeoAnalytics", ApplicationServicesModule.class, getClass().getClassLoader());
  }
  
  public IPickupEtaFallbackService get()
  {
    return module.providePickupEtaFallbackService((INearbyDriversService)nearbyDriversService.get(), (IRideRequestSession)rideRequestSession.get(), (IGoogleGeoApi)googleGeoApi.get(), (GoogleGeoAnalytics)googleGeoAnalytics.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(nearbyDriversService);
    paramSet1.add(rideRequestSession);
    paramSet1.add(googleGeoApi);
    paramSet1.add(googleGeoAnalytics);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ApplicationServicesModule..ModuleAdapter.ProvidePickupEtaFallbackServiceProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */