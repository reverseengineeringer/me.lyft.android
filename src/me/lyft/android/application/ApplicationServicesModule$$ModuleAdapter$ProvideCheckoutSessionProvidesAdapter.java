package me.lyft.android.application;

import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.application.checkout.CheckoutSession;
import me.lyft.android.application.checkout.ICheckoutSession;

public final class ApplicationServicesModule$$ModuleAdapter$ProvideCheckoutSessionProvidesAdapter
  extends ProvidesBinding<ICheckoutSession>
{
  private Binding<CheckoutSession> checkoutSession;
  private final ApplicationServicesModule module;
  
  public ApplicationServicesModule$$ModuleAdapter$ProvideCheckoutSessionProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
  {
    super("me.lyft.android.application.checkout.ICheckoutSession", true, "me.lyft.android.application.ApplicationServicesModule", "provideCheckoutSession");
    module = paramApplicationServicesModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    checkoutSession = paramLinker.requestBinding("me.lyft.android.application.checkout.CheckoutSession", ApplicationServicesModule.class, getClass().getClassLoader());
  }
  
  public ICheckoutSession get()
  {
    return module.provideCheckoutSession((CheckoutSession)checkoutSession.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(checkoutSession);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ApplicationServicesModule..ModuleAdapter.ProvideCheckoutSessionProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */