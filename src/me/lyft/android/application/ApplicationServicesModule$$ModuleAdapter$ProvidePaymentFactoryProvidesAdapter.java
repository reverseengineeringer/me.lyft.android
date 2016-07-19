package me.lyft.android.application;

import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.domain.payment.IPaymentFactory;
import me.lyft.android.domain.payment.IPaymentFactory.IPaymentMetadataProvider;

public final class ApplicationServicesModule$$ModuleAdapter$ProvidePaymentFactoryProvidesAdapter
  extends ProvidesBinding<IPaymentFactory>
{
  private final ApplicationServicesModule module;
  private Binding<IPaymentFactory.IPaymentMetadataProvider> provider;
  
  public ApplicationServicesModule$$ModuleAdapter$ProvidePaymentFactoryProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
  {
    super("me.lyft.android.domain.payment.IPaymentFactory", false, "me.lyft.android.application.ApplicationServicesModule", "providePaymentFactory");
    module = paramApplicationServicesModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    provider = paramLinker.requestBinding("me.lyft.android.domain.payment.IPaymentFactory$IPaymentMetadataProvider", ApplicationServicesModule.class, getClass().getClassLoader());
  }
  
  public IPaymentFactory get()
  {
    return module.providePaymentFactory((IPaymentFactory.IPaymentMetadataProvider)provider.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(provider);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ApplicationServicesModule..ModuleAdapter.ProvidePaymentFactoryProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */