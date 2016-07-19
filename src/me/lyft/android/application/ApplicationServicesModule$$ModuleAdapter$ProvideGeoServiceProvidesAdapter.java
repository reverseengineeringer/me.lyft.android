package me.lyft.android.application;

import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.application.geo.GoogleGeoAnalytics;
import me.lyft.android.application.geo.IEtaAnalyticService;
import me.lyft.android.application.geo.IEtaRepository;
import me.lyft.android.application.geo.IGeoService;
import me.lyft.android.application.geo.ReverseGeocodeService;
import me.lyft.android.infrastructure.googlegeo.IGoogleGeoApi;

public final class ApplicationServicesModule$$ModuleAdapter$ProvideGeoServiceProvidesAdapter
  extends ProvidesBinding<IGeoService>
{
  private Binding<IEtaAnalyticService> etaAnalyticService;
  private Binding<IEtaRepository> etaRepository;
  private Binding<IGoogleGeoApi> googleApiService;
  private Binding<GoogleGeoAnalytics> googleGeoAnalytics;
  private final ApplicationServicesModule module;
  private Binding<ReverseGeocodeService> reverseGeocodeService;
  
  public ApplicationServicesModule$$ModuleAdapter$ProvideGeoServiceProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
  {
    super("me.lyft.android.application.geo.IGeoService", true, "me.lyft.android.application.ApplicationServicesModule", "provideGeoService");
    module = paramApplicationServicesModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    reverseGeocodeService = paramLinker.requestBinding("me.lyft.android.application.geo.ReverseGeocodeService", ApplicationServicesModule.class, getClass().getClassLoader());
    googleApiService = paramLinker.requestBinding("me.lyft.android.infrastructure.googlegeo.IGoogleGeoApi", ApplicationServicesModule.class, getClass().getClassLoader());
    etaRepository = paramLinker.requestBinding("me.lyft.android.application.geo.IEtaRepository", ApplicationServicesModule.class, getClass().getClassLoader());
    etaAnalyticService = paramLinker.requestBinding("me.lyft.android.application.geo.IEtaAnalyticService", ApplicationServicesModule.class, getClass().getClassLoader());
    googleGeoAnalytics = paramLinker.requestBinding("me.lyft.android.application.geo.GoogleGeoAnalytics", ApplicationServicesModule.class, getClass().getClassLoader());
  }
  
  public IGeoService get()
  {
    return module.provideGeoService((ReverseGeocodeService)reverseGeocodeService.get(), (IGoogleGeoApi)googleApiService.get(), (IEtaRepository)etaRepository.get(), (IEtaAnalyticService)etaAnalyticService.get(), (GoogleGeoAnalytics)googleGeoAnalytics.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(reverseGeocodeService);
    paramSet1.add(googleApiService);
    paramSet1.add(etaRepository);
    paramSet1.add(etaAnalyticService);
    paramSet1.add(googleGeoAnalytics);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ApplicationServicesModule..ModuleAdapter.ProvideGeoServiceProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */