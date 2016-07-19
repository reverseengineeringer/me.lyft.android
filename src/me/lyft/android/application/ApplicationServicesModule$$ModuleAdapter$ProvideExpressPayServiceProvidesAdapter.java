package me.lyft.android.application;

import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.application.driver.expresspay.IExpressPayRepository;
import me.lyft.android.application.driver.expresspay.IExpressPayService;
import me.lyft.android.infrastructure.lyft.ILyftApi;
import me.lyft.android.infrastructure.stripe.IStripeService;

public final class ApplicationServicesModule$$ModuleAdapter$ProvideExpressPayServiceProvidesAdapter
  extends ProvidesBinding<IExpressPayService>
{
  private Binding<IExpressPayRepository> expressPayRepository;
  private Binding<ILyftApi> lyftApi;
  private final ApplicationServicesModule module;
  private Binding<IStripeService> stripeService;
  private Binding<IUserProvider> userProvider;
  
  public ApplicationServicesModule$$ModuleAdapter$ProvideExpressPayServiceProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
  {
    super("me.lyft.android.application.driver.expresspay.IExpressPayService", true, "me.lyft.android.application.ApplicationServicesModule", "provideExpressPayService");
    module = paramApplicationServicesModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    lyftApi = paramLinker.requestBinding("me.lyft.android.infrastructure.lyft.ILyftApi", ApplicationServicesModule.class, getClass().getClassLoader());
    userProvider = paramLinker.requestBinding("me.lyft.android.application.IUserProvider", ApplicationServicesModule.class, getClass().getClassLoader());
    expressPayRepository = paramLinker.requestBinding("me.lyft.android.application.driver.expresspay.IExpressPayRepository", ApplicationServicesModule.class, getClass().getClassLoader());
    stripeService = paramLinker.requestBinding("me.lyft.android.infrastructure.stripe.IStripeService", ApplicationServicesModule.class, getClass().getClassLoader());
  }
  
  public IExpressPayService get()
  {
    return module.provideExpressPayService((ILyftApi)lyftApi.get(), (IUserProvider)userProvider.get(), (IExpressPayRepository)expressPayRepository.get(), (IStripeService)stripeService.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(lyftApi);
    paramSet1.add(userProvider);
    paramSet1.add(expressPayRepository);
    paramSet1.add(stripeService);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ApplicationServicesModule..ModuleAdapter.ProvideExpressPayServiceProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */