package me.lyft.android.application;

import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.application.constants.IConstantsProvider;
import me.lyft.android.application.geo.GoogleGeoAnalytics;
import me.lyft.android.application.geo.IDirectionsService;
import me.lyft.android.infrastructure.googlegeo.IGoogleGeoApi;

public final class ApplicationServicesModule$$ModuleAdapter$ProvideDriverDirectionsServiceProvidesAdapter
  extends ProvidesBinding<IDirectionsService>
{
  private Binding<IConstantsProvider> constantsProvider;
  private Binding<GoogleGeoAnalytics> googleGeoAnalytics;
  private Binding<IGoogleGeoApi> googleGeoApi;
  private final ApplicationServicesModule module;
  
  public ApplicationServicesModule$$ModuleAdapter$ProvideDriverDirectionsServiceProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
  {
    super("@javax.inject.Named(value=driver)/me.lyft.android.application.geo.IDirectionsService", true, "me.lyft.android.application.ApplicationServicesModule", "provideDriverDirectionsService");
    module = paramApplicationServicesModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    googleGeoApi = paramLinker.requestBinding("me.lyft.android.infrastructure.googlegeo.IGoogleGeoApi", ApplicationServicesModule.class, getClass().getClassLoader());
    googleGeoAnalytics = paramLinker.requestBinding("me.lyft.android.application.geo.GoogleGeoAnalytics", ApplicationServicesModule.class, getClass().getClassLoader());
    constantsProvider = paramLinker.requestBinding("me.lyft.android.application.constants.IConstantsProvider", ApplicationServicesModule.class, getClass().getClassLoader());
  }
  
  public IDirectionsService get()
  {
    return module.provideDriverDirectionsService((IGoogleGeoApi)googleGeoApi.get(), (GoogleGeoAnalytics)googleGeoAnalytics.get(), (IConstantsProvider)constantsProvider.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(googleGeoApi);
    paramSet1.add(googleGeoAnalytics);
    paramSet1.add(constantsProvider);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ApplicationServicesModule..ModuleAdapter.ProvideDriverDirectionsServiceProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */