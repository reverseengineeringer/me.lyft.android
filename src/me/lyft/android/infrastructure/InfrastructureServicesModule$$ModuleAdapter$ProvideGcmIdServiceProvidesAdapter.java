package me.lyft.android.infrastructure;

import dagger.internal.ProvidesBinding;
import me.lyft.android.infrastructure.gcm.IGcmIdService;

public final class InfrastructureServicesModule$$ModuleAdapter$ProvideGcmIdServiceProvidesAdapter
  extends ProvidesBinding<IGcmIdService>
{
  private final InfrastructureServicesModule module;
  
  public InfrastructureServicesModule$$ModuleAdapter$ProvideGcmIdServiceProvidesAdapter(InfrastructureServicesModule paramInfrastructureServicesModule)
  {
    super("me.lyft.android.infrastructure.gcm.IGcmIdService", false, "me.lyft.android.infrastructure.InfrastructureServicesModule", "provideGcmIdService");
    module = paramInfrastructureServicesModule;
    setLibrary(true);
  }
  
  public IGcmIdService get()
  {
    return module.provideGcmIdService();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.InfrastructureServicesModule..ModuleAdapter.ProvideGcmIdServiceProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */