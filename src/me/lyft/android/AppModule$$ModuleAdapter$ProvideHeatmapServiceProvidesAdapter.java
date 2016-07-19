package me.lyft.android;

import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.errorhandling.IDefaultErrorHandler;
import me.lyft.android.infrastructure.location.ILocationService;
import me.lyft.android.infrastructure.lyft.ILyftApi;
import me.lyft.android.services.HeatMapService;

public final class AppModule$$ModuleAdapter$ProvideHeatmapServiceProvidesAdapter
  extends ProvidesBinding<HeatMapService>
{
  private Binding<IDefaultErrorHandler> defaultErrorHandler;
  private Binding<ILocationService> locationService;
  private Binding<ILyftApi> lyftApi;
  private final AppModule module;
  
  public AppModule$$ModuleAdapter$ProvideHeatmapServiceProvidesAdapter(AppModule paramAppModule)
  {
    super("me.lyft.android.services.HeatMapService", true, "me.lyft.android.AppModule", "provideHeatmapService");
    module = paramAppModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    lyftApi = paramLinker.requestBinding("me.lyft.android.infrastructure.lyft.ILyftApi", AppModule.class, getClass().getClassLoader());
    locationService = paramLinker.requestBinding("me.lyft.android.infrastructure.location.ILocationService", AppModule.class, getClass().getClassLoader());
    defaultErrorHandler = paramLinker.requestBinding("me.lyft.android.errorhandling.IDefaultErrorHandler", AppModule.class, getClass().getClassLoader());
  }
  
  public HeatMapService get()
  {
    return module.provideHeatmapService((ILyftApi)lyftApi.get(), (ILocationService)locationService.get(), (IDefaultErrorHandler)defaultErrorHandler.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(lyftApi);
    paramSet1.add(locationService);
    paramSet1.add(defaultErrorHandler);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.AppModule..ModuleAdapter.ProvideHeatmapServiceProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */