package me.lyft.android.application;

import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.application.driver.IVehicleService;
import me.lyft.android.infrastructure.environment.IS3Api;
import me.lyft.android.infrastructure.lyft.ILyftApi;

public final class ApplicationServicesModule$$ModuleAdapter$ProvideVehicleServiceProvidesAdapter
  extends ProvidesBinding<IVehicleService>
{
  private Binding<IS3Api> is3Api;
  private Binding<ILyftApi> lyftApi;
  private final ApplicationServicesModule module;
  
  public ApplicationServicesModule$$ModuleAdapter$ProvideVehicleServiceProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
  {
    super("me.lyft.android.application.driver.IVehicleService", true, "me.lyft.android.application.ApplicationServicesModule", "provideVehicleService");
    module = paramApplicationServicesModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    lyftApi = paramLinker.requestBinding("me.lyft.android.infrastructure.lyft.ILyftApi", ApplicationServicesModule.class, getClass().getClassLoader());
    is3Api = paramLinker.requestBinding("me.lyft.android.infrastructure.environment.IS3Api", ApplicationServicesModule.class, getClass().getClassLoader());
  }
  
  public IVehicleService get()
  {
    return module.provideVehicleService((ILyftApi)lyftApi.get(), (IS3Api)is3Api.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(lyftApi);
    paramSet1.add(is3Api);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ApplicationServicesModule..ModuleAdapter.ProvideVehicleServiceProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */