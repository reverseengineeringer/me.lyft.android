package me.lyft.android.application;

import dagger.internal.ProvidesBinding;
import me.lyft.android.application.geo.IEtaRepository;

public final class ApplicationServicesModule$$ModuleAdapter$ProvideEtaRepositoryProvidesAdapter
  extends ProvidesBinding<IEtaRepository>
{
  private final ApplicationServicesModule module;
  
  public ApplicationServicesModule$$ModuleAdapter$ProvideEtaRepositoryProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
  {
    super("me.lyft.android.application.geo.IEtaRepository", true, "me.lyft.android.application.ApplicationServicesModule", "provideEtaRepository");
    module = paramApplicationServicesModule;
    setLibrary(true);
  }
  
  public IEtaRepository get()
  {
    return module.provideEtaRepository();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ApplicationServicesModule..ModuleAdapter.ProvideEtaRepositoryProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */