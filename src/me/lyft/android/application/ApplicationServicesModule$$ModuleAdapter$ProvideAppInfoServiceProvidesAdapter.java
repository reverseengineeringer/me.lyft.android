package me.lyft.android.application;

import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.application.constants.IConstantsProvider;
import me.lyft.android.application.tooltip.ITooltipService;
import me.lyft.android.infrastructure.assets.IAssetPackagingService;
import me.lyft.android.infrastructure.location.ILocationService;
import me.lyft.android.infrastructure.lyft.ILyftApi;

public final class ApplicationServicesModule$$ModuleAdapter$ProvideAppInfoServiceProvidesAdapter
  extends ProvidesBinding<IAppInfoService>
{
  private Binding<IAssetPackagingService> assetPackagingService;
  private Binding<IConstantsProvider> constantsProvider;
  private Binding<ILocationService> locationService;
  private Binding<ILyftApi> lyftApi;
  private final ApplicationServicesModule module;
  private Binding<ILyftPreferences> preferences;
  private Binding<ITooltipService> tooltipService;
  
  public ApplicationServicesModule$$ModuleAdapter$ProvideAppInfoServiceProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
  {
    super("me.lyft.android.application.IAppInfoService", true, "me.lyft.android.application.ApplicationServicesModule", "provideAppInfoService");
    module = paramApplicationServicesModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    locationService = paramLinker.requestBinding("me.lyft.android.infrastructure.location.ILocationService", ApplicationServicesModule.class, getClass().getClassLoader());
    lyftApi = paramLinker.requestBinding("me.lyft.android.infrastructure.lyft.ILyftApi", ApplicationServicesModule.class, getClass().getClassLoader());
    constantsProvider = paramLinker.requestBinding("me.lyft.android.application.constants.IConstantsProvider", ApplicationServicesModule.class, getClass().getClassLoader());
    tooltipService = paramLinker.requestBinding("me.lyft.android.application.tooltip.ITooltipService", ApplicationServicesModule.class, getClass().getClassLoader());
    assetPackagingService = paramLinker.requestBinding("me.lyft.android.infrastructure.assets.IAssetPackagingService", ApplicationServicesModule.class, getClass().getClassLoader());
    preferences = paramLinker.requestBinding("me.lyft.android.ILyftPreferences", ApplicationServicesModule.class, getClass().getClassLoader());
  }
  
  public IAppInfoService get()
  {
    return module.provideAppInfoService((ILocationService)locationService.get(), (ILyftApi)lyftApi.get(), (IConstantsProvider)constantsProvider.get(), (ITooltipService)tooltipService.get(), (IAssetPackagingService)assetPackagingService.get(), (ILyftPreferences)preferences.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(locationService);
    paramSet1.add(lyftApi);
    paramSet1.add(constantsProvider);
    paramSet1.add(tooltipService);
    paramSet1.add(assetPackagingService);
    paramSet1.add(preferences);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ApplicationServicesModule..ModuleAdapter.ProvideAppInfoServiceProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */