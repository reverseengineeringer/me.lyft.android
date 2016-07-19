package me.lyft.android;

import dagger.internal.ProvidesBinding;
import me.lyft.android.application.system.ICountryRepository;

public final class AppModule$$ModuleAdapter$ProvideCountryRepositoryProvidesAdapter
  extends ProvidesBinding<ICountryRepository>
{
  private final AppModule module;
  
  public AppModule$$ModuleAdapter$ProvideCountryRepositoryProvidesAdapter(AppModule paramAppModule)
  {
    super("me.lyft.android.application.system.ICountryRepository", true, "me.lyft.android.AppModule", "provideCountryRepository");
    module = paramAppModule;
    setLibrary(true);
  }
  
  public ICountryRepository get()
  {
    return module.provideCountryRepository();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.AppModule..ModuleAdapter.ProvideCountryRepositoryProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */