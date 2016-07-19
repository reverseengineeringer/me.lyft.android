package me.lyft.android.infrastructure;

import dagger.internal.ProvidesBinding;
import me.lyft.android.infrastructure.foreground.IAppForegroundDetector;

public final class InfrastructureServicesModule$$ModuleAdapter$ProvideAppForegroundDetectorProvidesAdapter
  extends ProvidesBinding<IAppForegroundDetector>
{
  private final InfrastructureServicesModule module;
  
  public InfrastructureServicesModule$$ModuleAdapter$ProvideAppForegroundDetectorProvidesAdapter(InfrastructureServicesModule paramInfrastructureServicesModule)
  {
    super("me.lyft.android.infrastructure.foreground.IAppForegroundDetector", true, "me.lyft.android.infrastructure.InfrastructureServicesModule", "provideAppForegroundDetector");
    module = paramInfrastructureServicesModule;
    setLibrary(true);
  }
  
  public IAppForegroundDetector get()
  {
    return module.provideAppForegroundDetector();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.InfrastructureServicesModule..ModuleAdapter.ProvideAppForegroundDetectorProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */