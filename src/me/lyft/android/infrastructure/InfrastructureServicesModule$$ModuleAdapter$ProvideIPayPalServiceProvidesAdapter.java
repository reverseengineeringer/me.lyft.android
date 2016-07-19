package me.lyft.android.infrastructure;

import dagger.internal.ProvidesBinding;
import me.lyft.android.infrastructure.paypal.IPayPalService;

public final class InfrastructureServicesModule$$ModuleAdapter$ProvideIPayPalServiceProvidesAdapter
  extends ProvidesBinding<IPayPalService>
{
  private final InfrastructureServicesModule module;
  
  public InfrastructureServicesModule$$ModuleAdapter$ProvideIPayPalServiceProvidesAdapter(InfrastructureServicesModule paramInfrastructureServicesModule)
  {
    super("me.lyft.android.infrastructure.paypal.IPayPalService", true, "me.lyft.android.infrastructure.InfrastructureServicesModule", "provideIPayPalService");
    module = paramInfrastructureServicesModule;
    setLibrary(true);
  }
  
  public IPayPalService get()
  {
    return module.provideIPayPalService();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.InfrastructureServicesModule..ModuleAdapter.ProvideIPayPalServiceProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */