package me.lyft.android;

import dagger.internal.ProvidesBinding;
import me.lyft.android.application.payment.IPricingService;

public final class AppModule$$ModuleAdapter$ProvidePricingServiceProvidesAdapter
  extends ProvidesBinding<IPricingService>
{
  private final AppModule module;
  
  public AppModule$$ModuleAdapter$ProvidePricingServiceProvidesAdapter(AppModule paramAppModule)
  {
    super("me.lyft.android.application.payment.IPricingService", true, "me.lyft.android.AppModule", "providePricingService");
    module = paramAppModule;
    setLibrary(true);
  }
  
  public IPricingService get()
  {
    return module.providePricingService();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.AppModule..ModuleAdapter.ProvidePricingServiceProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */