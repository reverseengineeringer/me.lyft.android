package me.lyft.android.application;

import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.domain.payment.IPaymentFactory.IPaymentMetadataProvider;
import me.lyft.android.infrastructure.paypal.IPayPalService;

public final class ApplicationServicesModule$$ModuleAdapter$ProvidePaymentMetadataProviderProvidesAdapter
  extends ProvidesBinding<IPaymentFactory.IPaymentMetadataProvider>
{
  private final ApplicationServicesModule module;
  private Binding<IPayPalService> service;
  
  public ApplicationServicesModule$$ModuleAdapter$ProvidePaymentMetadataProviderProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
  {
    super("me.lyft.android.domain.payment.IPaymentFactory$IPaymentMetadataProvider", false, "me.lyft.android.application.ApplicationServicesModule", "providePaymentMetadataProvider");
    module = paramApplicationServicesModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    service = paramLinker.requestBinding("me.lyft.android.infrastructure.paypal.IPayPalService", ApplicationServicesModule.class, getClass().getClassLoader());
  }
  
  public IPaymentFactory.IPaymentMetadataProvider get()
  {
    return module.providePaymentMetadataProvider((IPayPalService)service.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(service);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ApplicationServicesModule..ModuleAdapter.ProvidePaymentMetadataProviderProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */