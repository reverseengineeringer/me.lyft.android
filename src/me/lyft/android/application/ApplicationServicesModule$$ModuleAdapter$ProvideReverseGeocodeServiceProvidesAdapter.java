package me.lyft.android.application;

import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.application.geo.GoogleGeoAnalytics;
import me.lyft.android.application.geo.ReverseGeocodeService;
import me.lyft.android.infrastructure.googlegeo.IGoogleGeoApi;

public final class ApplicationServicesModule$$ModuleAdapter$ProvideReverseGeocodeServiceProvidesAdapter
  extends ProvidesBinding<ReverseGeocodeService>
{
  private Binding<GoogleGeoAnalytics> googleGeoAnalytics;
  private Binding<IGoogleGeoApi> googleGeoApiService;
  private final ApplicationServicesModule module;
  
  public ApplicationServicesModule$$ModuleAdapter$ProvideReverseGeocodeServiceProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
  {
    super("me.lyft.android.application.geo.ReverseGeocodeService", true, "me.lyft.android.application.ApplicationServicesModule", "provideReverseGeocodeService");
    module = paramApplicationServicesModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    googleGeoApiService = paramLinker.requestBinding("me.lyft.android.infrastructure.googlegeo.IGoogleGeoApi", ApplicationServicesModule.class, getClass().getClassLoader());
    googleGeoAnalytics = paramLinker.requestBinding("me.lyft.android.application.geo.GoogleGeoAnalytics", ApplicationServicesModule.class, getClass().getClassLoader());
  }
  
  public ReverseGeocodeService get()
  {
    return module.provideReverseGeocodeService((IGoogleGeoApi)googleGeoApiService.get(), (GoogleGeoAnalytics)googleGeoAnalytics.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(googleGeoApiService);
    paramSet1.add(googleGeoAnalytics);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ApplicationServicesModule..ModuleAdapter.ProvideReverseGeocodeServiceProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */