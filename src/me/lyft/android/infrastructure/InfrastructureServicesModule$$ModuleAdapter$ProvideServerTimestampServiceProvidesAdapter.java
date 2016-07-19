package me.lyft.android.infrastructure;

import dagger.internal.ProvidesBinding;
import me.lyft.android.infrastructure.servertimestamp.IServerTimestampService;

public final class InfrastructureServicesModule$$ModuleAdapter$ProvideServerTimestampServiceProvidesAdapter
  extends ProvidesBinding<IServerTimestampService>
{
  private final InfrastructureServicesModule module;
  
  public InfrastructureServicesModule$$ModuleAdapter$ProvideServerTimestampServiceProvidesAdapter(InfrastructureServicesModule paramInfrastructureServicesModule)
  {
    super("me.lyft.android.infrastructure.servertimestamp.IServerTimestampService", true, "me.lyft.android.infrastructure.InfrastructureServicesModule", "provideServerTimestampService");
    module = paramInfrastructureServicesModule;
    setLibrary(true);
  }
  
  public IServerTimestampService get()
  {
    return module.provideServerTimestampService();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.InfrastructureServicesModule..ModuleAdapter.ProvideServerTimestampServiceProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */