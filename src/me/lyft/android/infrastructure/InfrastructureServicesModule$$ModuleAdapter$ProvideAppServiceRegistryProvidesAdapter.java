package me.lyft.android.infrastructure;

import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.application.polling.IBackgroundLocationAppProcess;
import me.lyft.android.application.polling.IPollingAppProcess;
import me.lyft.android.infrastructure.service.AppProcessRegistry;

public final class InfrastructureServicesModule$$ModuleAdapter$ProvideAppServiceRegistryProvidesAdapter
  extends ProvidesBinding<AppProcessRegistry>
{
  private Binding<IBackgroundLocationAppProcess> backgroundLocationSupervisor;
  private final InfrastructureServicesModule module;
  private Binding<IPollingAppProcess> pollingSupervisor;
  
  public InfrastructureServicesModule$$ModuleAdapter$ProvideAppServiceRegistryProvidesAdapter(InfrastructureServicesModule paramInfrastructureServicesModule)
  {
    super("me.lyft.android.infrastructure.service.AppProcessRegistry", true, "me.lyft.android.infrastructure.InfrastructureServicesModule", "provideAppServiceRegistry");
    module = paramInfrastructureServicesModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    pollingSupervisor = paramLinker.requestBinding("me.lyft.android.application.polling.IPollingAppProcess", InfrastructureServicesModule.class, getClass().getClassLoader());
    backgroundLocationSupervisor = paramLinker.requestBinding("me.lyft.android.application.polling.IBackgroundLocationAppProcess", InfrastructureServicesModule.class, getClass().getClassLoader());
  }
  
  public AppProcessRegistry get()
  {
    return module.provideAppServiceRegistry((IPollingAppProcess)pollingSupervisor.get(), (IBackgroundLocationAppProcess)backgroundLocationSupervisor.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(pollingSupervisor);
    paramSet1.add(backgroundLocationSupervisor);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.InfrastructureServicesModule..ModuleAdapter.ProvideAppServiceRegistryProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */