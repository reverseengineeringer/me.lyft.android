package me.lyft.android.infrastructure;

import dagger.internal.ProvidesBinding;
import me.lyft.android.infrastructure.viewserver.IViewServerService;

public final class InfrastructureServicesModule$$ModuleAdapter$ProvideViewServerServiceProvidesAdapter
  extends ProvidesBinding<IViewServerService>
{
  private final InfrastructureServicesModule module;
  
  public InfrastructureServicesModule$$ModuleAdapter$ProvideViewServerServiceProvidesAdapter(InfrastructureServicesModule paramInfrastructureServicesModule)
  {
    super("me.lyft.android.infrastructure.viewserver.IViewServerService", true, "me.lyft.android.infrastructure.InfrastructureServicesModule", "provideViewServerService");
    module = paramInfrastructureServicesModule;
    setLibrary(true);
  }
  
  public IViewServerService get()
  {
    return module.provideViewServerService();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.InfrastructureServicesModule..ModuleAdapter.ProvideViewServerServiceProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */