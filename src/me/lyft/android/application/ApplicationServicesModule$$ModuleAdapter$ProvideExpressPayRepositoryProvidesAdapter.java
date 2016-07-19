package me.lyft.android.application;

import dagger.internal.ProvidesBinding;
import me.lyft.android.application.driver.expresspay.IExpressPayRepository;

public final class ApplicationServicesModule$$ModuleAdapter$ProvideExpressPayRepositoryProvidesAdapter
  extends ProvidesBinding<IExpressPayRepository>
{
  private final ApplicationServicesModule module;
  
  public ApplicationServicesModule$$ModuleAdapter$ProvideExpressPayRepositoryProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
  {
    super("me.lyft.android.application.driver.expresspay.IExpressPayRepository", true, "me.lyft.android.application.ApplicationServicesModule", "provideExpressPayRepository");
    module = paramApplicationServicesModule;
    setLibrary(true);
  }
  
  public IExpressPayRepository get()
  {
    return module.provideExpressPayRepository();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ApplicationServicesModule..ModuleAdapter.ProvideExpressPayRepositoryProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */