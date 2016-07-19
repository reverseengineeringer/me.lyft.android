package me.lyft.android.infrastructure;

import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.analytics.trackers.IAnalyticsService;
import me.lyft.android.infrastructure.environment.IEnvironmentService;
import me.lyft.android.infrastructure.json.IJsonSerializer;
import me.lyft.android.infrastructure.lyft.ILyftApi;

public final class InfrastructureServicesModule$$ModuleAdapter$ProvideEnvironmentHelperProvidesAdapter
  extends ProvidesBinding<IEnvironmentService>
{
  private Binding<IAnalyticsService> analyticsService;
  private Binding<IJsonSerializer> jsonSerializer;
  private Binding<ILyftApi> lyftApi;
  private final InfrastructureServicesModule module;
  private Binding<ILyftPreferences> preferences;
  
  public InfrastructureServicesModule$$ModuleAdapter$ProvideEnvironmentHelperProvidesAdapter(InfrastructureServicesModule paramInfrastructureServicesModule)
  {
    super("me.lyft.android.infrastructure.environment.IEnvironmentService", true, "me.lyft.android.infrastructure.InfrastructureServicesModule", "provideEnvironmentHelper");
    module = paramInfrastructureServicesModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    preferences = paramLinker.requestBinding("me.lyft.android.ILyftPreferences", InfrastructureServicesModule.class, getClass().getClassLoader());
    lyftApi = paramLinker.requestBinding("me.lyft.android.infrastructure.lyft.ILyftApi", InfrastructureServicesModule.class, getClass().getClassLoader());
    jsonSerializer = paramLinker.requestBinding("me.lyft.android.infrastructure.json.IJsonSerializer", InfrastructureServicesModule.class, getClass().getClassLoader());
    analyticsService = paramLinker.requestBinding("me.lyft.android.analytics.trackers.IAnalyticsService", InfrastructureServicesModule.class, getClass().getClassLoader());
  }
  
  public IEnvironmentService get()
  {
    return module.provideEnvironmentHelper((ILyftPreferences)preferences.get(), (ILyftApi)lyftApi.get(), (IJsonSerializer)jsonSerializer.get(), (IAnalyticsService)analyticsService.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(preferences);
    paramSet1.add(lyftApi);
    paramSet1.add(jsonSerializer);
    paramSet1.add(analyticsService);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.InfrastructureServicesModule..ModuleAdapter.ProvideEnvironmentHelperProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */