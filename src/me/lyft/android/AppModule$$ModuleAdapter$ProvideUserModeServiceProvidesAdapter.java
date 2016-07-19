package me.lyft.android;

import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.application.driver.IVehicleService;
import me.lyft.android.application.ride.IUserDispatchService;
import me.lyft.android.infrastructure.locationsettings.ILocationSettingsService;
import me.lyft.android.infrastructure.lyft.ILyftApi;

public final class AppModule$$ModuleAdapter$ProvideUserModeServiceProvidesAdapter
  extends ProvidesBinding<IUserDispatchService>
{
  private Binding<ILocationSettingsService> locationSettingsService;
  private Binding<ILyftApi> lyftApi;
  private final AppModule module;
  private Binding<IUserProvider> userProvider;
  private Binding<IVehicleService> vehicleService;
  
  public AppModule$$ModuleAdapter$ProvideUserModeServiceProvidesAdapter(AppModule paramAppModule)
  {
    super("me.lyft.android.application.ride.IUserDispatchService", true, "me.lyft.android.AppModule", "provideUserModeService");
    module = paramAppModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    userProvider = paramLinker.requestBinding("me.lyft.android.application.IUserProvider", AppModule.class, getClass().getClassLoader());
    lyftApi = paramLinker.requestBinding("me.lyft.android.infrastructure.lyft.ILyftApi", AppModule.class, getClass().getClassLoader());
    vehicleService = paramLinker.requestBinding("me.lyft.android.application.driver.IVehicleService", AppModule.class, getClass().getClassLoader());
    locationSettingsService = paramLinker.requestBinding("me.lyft.android.infrastructure.locationsettings.ILocationSettingsService", AppModule.class, getClass().getClassLoader());
  }
  
  public IUserDispatchService get()
  {
    return module.provideUserModeService((IUserProvider)userProvider.get(), (ILyftApi)lyftApi.get(), (IVehicleService)vehicleService.get(), (ILocationSettingsService)locationSettingsService.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(userProvider);
    paramSet1.add(lyftApi);
    paramSet1.add(vehicleService);
    paramSet1.add(locationSettingsService);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.AppModule..ModuleAdapter.ProvideUserModeServiceProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */