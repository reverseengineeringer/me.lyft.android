package me.lyft.android.application;

import dagger.internal.ProvidesBinding;
import me.lyft.android.application.driver.IDailyTotalsRepository;

public final class ApplicationServicesModule$$ModuleAdapter$ProvideDailyTotalsRepositoryProvidesAdapter
  extends ProvidesBinding<IDailyTotalsRepository>
{
  private final ApplicationServicesModule module;
  
  public ApplicationServicesModule$$ModuleAdapter$ProvideDailyTotalsRepositoryProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
  {
    super("me.lyft.android.application.driver.IDailyTotalsRepository", true, "me.lyft.android.application.ApplicationServicesModule", "provideDailyTotalsRepository");
    module = paramApplicationServicesModule;
    setLibrary(true);
  }
  
  public IDailyTotalsRepository get()
  {
    return module.provideDailyTotalsRepository();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ApplicationServicesModule..ModuleAdapter.ProvideDailyTotalsRepositoryProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */