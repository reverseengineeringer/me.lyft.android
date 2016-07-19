package me.lyft.android.infrastructure;

import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.application.constants.IConstantsProvider;
import me.lyft.android.infrastructure.competition.InstallTrackerService;
import me.lyft.android.infrastructure.device.IDevice;

public final class InfrastructureServicesModule$$ModuleAdapter$ProvideInstallTrackerServiceProvidesAdapter
  extends ProvidesBinding<InstallTrackerService>
{
  private Binding<IConstantsProvider> constantsProvider;
  private Binding<IDevice> device;
  private final InfrastructureServicesModule module;
  
  public InfrastructureServicesModule$$ModuleAdapter$ProvideInstallTrackerServiceProvidesAdapter(InfrastructureServicesModule paramInfrastructureServicesModule)
  {
    super("me.lyft.android.infrastructure.competition.InstallTrackerService", true, "me.lyft.android.infrastructure.InfrastructureServicesModule", "provideInstallTrackerService");
    module = paramInfrastructureServicesModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    constantsProvider = paramLinker.requestBinding("me.lyft.android.application.constants.IConstantsProvider", InfrastructureServicesModule.class, getClass().getClassLoader());
    device = paramLinker.requestBinding("me.lyft.android.infrastructure.device.IDevice", InfrastructureServicesModule.class, getClass().getClassLoader());
  }
  
  public InstallTrackerService get()
  {
    return module.provideInstallTrackerService((IConstantsProvider)constantsProvider.get(), (IDevice)device.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(constantsProvider);
    paramSet1.add(device);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.InfrastructureServicesModule..ModuleAdapter.ProvideInstallTrackerServiceProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */