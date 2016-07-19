package me.lyft.android.infrastructure;

import dagger.internal.ProvidesBinding;
import me.lyft.android.infrastructure.sms.IVerificationAutoFillService;

public final class InfrastructureServicesModule$$ModuleAdapter$ProvideVerificationAutoFillServiceProvidesAdapter
  extends ProvidesBinding<IVerificationAutoFillService>
{
  private final InfrastructureServicesModule module;
  
  public InfrastructureServicesModule$$ModuleAdapter$ProvideVerificationAutoFillServiceProvidesAdapter(InfrastructureServicesModule paramInfrastructureServicesModule)
  {
    super("me.lyft.android.infrastructure.sms.IVerificationAutoFillService", false, "me.lyft.android.infrastructure.InfrastructureServicesModule", "provideVerificationAutoFillService");
    module = paramInfrastructureServicesModule;
    setLibrary(true);
  }
  
  public IVerificationAutoFillService get()
  {
    return module.provideVerificationAutoFillService();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.InfrastructureServicesModule..ModuleAdapter.ProvideVerificationAutoFillServiceProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */