package me.lyft.android.infrastructure;

import dagger.internal.ProvidesBinding;
import me.lyft.android.infrastructure.deferred.IDeferredSyncService;

public final class InfrastructureServicesModule$$ModuleAdapter$ProvideDeferredSyncServiceProvidesAdapter
  extends ProvidesBinding<IDeferredSyncService>
{
  private final InfrastructureServicesModule module;
  
  public InfrastructureServicesModule$$ModuleAdapter$ProvideDeferredSyncServiceProvidesAdapter(InfrastructureServicesModule paramInfrastructureServicesModule)
  {
    super("me.lyft.android.infrastructure.deferred.IDeferredSyncService", true, "me.lyft.android.infrastructure.InfrastructureServicesModule", "provideDeferredSyncService");
    module = paramInfrastructureServicesModule;
    setLibrary(true);
  }
  
  public IDeferredSyncService get()
  {
    return module.provideDeferredSyncService();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.InfrastructureServicesModule..ModuleAdapter.ProvideDeferredSyncServiceProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */