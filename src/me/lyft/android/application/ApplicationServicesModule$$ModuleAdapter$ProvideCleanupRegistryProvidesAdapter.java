package me.lyft.android.application;

import dagger.internal.ProvidesBinding;
import me.lyft.android.application.cleanup.ICleanupRegistry;

public final class ApplicationServicesModule$$ModuleAdapter$ProvideCleanupRegistryProvidesAdapter
  extends ProvidesBinding<ICleanupRegistry>
{
  private final ApplicationServicesModule module;
  
  public ApplicationServicesModule$$ModuleAdapter$ProvideCleanupRegistryProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
  {
    super("me.lyft.android.application.cleanup.ICleanupRegistry", true, "me.lyft.android.application.ApplicationServicesModule", "provideCleanupRegistry");
    module = paramApplicationServicesModule;
    setLibrary(true);
  }
  
  public ICleanupRegistry get()
  {
    return module.provideCleanupRegistry();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ApplicationServicesModule..ModuleAdapter.ProvideCleanupRegistryProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */