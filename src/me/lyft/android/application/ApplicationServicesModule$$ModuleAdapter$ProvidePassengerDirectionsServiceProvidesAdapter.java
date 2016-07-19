package me.lyft.android.application;

import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.application.geo.GoogleGeoAnalytics;
import me.lyft.android.application.geo.IDirectionsService;
import me.lyft.android.application.geo.routecache.DriverDeviationBasedCache;
import me.lyft.android.infrastructure.googlegeo.IGoogleGeoApi;
import me.lyft.android.infrastructure.lyft.ILyftApi;

public final class ApplicationServicesModule$$ModuleAdapter$ProvidePassengerDirectionsServiceProvidesAdapter
  extends ProvidesBinding<IDirectionsService>
{
  private Binding<DriverDeviationBasedCache> driverDeviationBasedCache;
  private Binding<GoogleGeoAnalytics> googleGeoAnalytics;
  private Binding<IGoogleGeoApi> googleGeoApi;
  private Binding<ILyftApi> lyftApi;
  private final ApplicationServicesModule module;
  
  public ApplicationServicesModule$$ModuleAdapter$ProvidePassengerDirectionsServiceProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
  {
    super("@javax.inject.Named(value=passenger)/me.lyft.android.application.geo.IDirectionsService", true, "me.lyft.android.application.ApplicationServicesModule", "providePassengerDirectionsService");
    module = paramApplicationServicesModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    lyftApi = paramLinker.requestBinding("me.lyft.android.infrastructure.lyft.ILyftApi", ApplicationServicesModule.class, getClass().getClassLoader());
    googleGeoApi = paramLinker.requestBinding("me.lyft.android.infrastructure.googlegeo.IGoogleGeoApi", ApplicationServicesModule.class, getClass().getClassLoader());
    googleGeoAnalytics = paramLinker.requestBinding("me.lyft.android.application.geo.GoogleGeoAnalytics", ApplicationServicesModule.class, getClass().getClassLoader());
    driverDeviationBasedCache = paramLinker.requestBinding("me.lyft.android.application.geo.routecache.DriverDeviationBasedCache", ApplicationServicesModule.class, getClass().getClassLoader());
  }
  
  public IDirectionsService get()
  {
    return module.providePassengerDirectionsService((ILyftApi)lyftApi.get(), (IGoogleGeoApi)googleGeoApi.get(), (GoogleGeoAnalytics)googleGeoAnalytics.get(), (DriverDeviationBasedCache)driverDeviationBasedCache.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(lyftApi);
    paramSet1.add(googleGeoApi);
    paramSet1.add(googleGeoAnalytics);
    paramSet1.add(driverDeviationBasedCache);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ApplicationServicesModule..ModuleAdapter.ProvidePassengerDirectionsServiceProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */