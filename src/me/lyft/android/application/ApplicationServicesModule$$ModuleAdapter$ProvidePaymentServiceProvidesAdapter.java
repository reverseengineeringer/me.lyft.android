package me.lyft.android.application;

import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.application.payment.IPaymentService;
import me.lyft.android.infrastructure.androidpay.IAndroidPayService;
import me.lyft.android.infrastructure.lyft.ILyftApi;
import me.lyft.android.infrastructure.paypal.IPayPalService;
import me.lyft.android.infrastructure.stripe.IStripeService;
import me.lyft.android.persistence.payment.IChargeAccountsProvider;

public final class ApplicationServicesModule$$ModuleAdapter$ProvidePaymentServiceProvidesAdapter
  extends ProvidesBinding<IPaymentService>
{
  private Binding<IChargeAccountsProvider> chargeAccountsProvider;
  private Binding<ILyftApi> lyftApi;
  private final ApplicationServicesModule module;
  private Binding<IPayPalService> payPalService;
  private Binding<IStripeService> stripeService;
  private Binding<IUserProvider> userProvider;
  private Binding<IAndroidPayService> walletService;
  
  public ApplicationServicesModule$$ModuleAdapter$ProvidePaymentServiceProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
  {
    super("me.lyft.android.application.payment.IPaymentService", true, "me.lyft.android.application.ApplicationServicesModule", "providePaymentService");
    module = paramApplicationServicesModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    lyftApi = paramLinker.requestBinding("me.lyft.android.infrastructure.lyft.ILyftApi", ApplicationServicesModule.class, getClass().getClassLoader());
    userProvider = paramLinker.requestBinding("me.lyft.android.application.IUserProvider", ApplicationServicesModule.class, getClass().getClassLoader());
    stripeService = paramLinker.requestBinding("me.lyft.android.infrastructure.stripe.IStripeService", ApplicationServicesModule.class, getClass().getClassLoader());
    walletService = paramLinker.requestBinding("me.lyft.android.infrastructure.androidpay.IAndroidPayService", ApplicationServicesModule.class, getClass().getClassLoader());
    payPalService = paramLinker.requestBinding("me.lyft.android.infrastructure.paypal.IPayPalService", ApplicationServicesModule.class, getClass().getClassLoader());
    chargeAccountsProvider = paramLinker.requestBinding("me.lyft.android.persistence.payment.IChargeAccountsProvider", ApplicationServicesModule.class, getClass().getClassLoader());
  }
  
  public IPaymentService get()
  {
    return module.providePaymentService((ILyftApi)lyftApi.get(), (IUserProvider)userProvider.get(), (IStripeService)stripeService.get(), (IAndroidPayService)walletService.get(), (IPayPalService)payPalService.get(), (IChargeAccountsProvider)chargeAccountsProvider.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(lyftApi);
    paramSet1.add(userProvider);
    paramSet1.add(stripeService);
    paramSet1.add(walletService);
    paramSet1.add(payPalService);
    paramSet1.add(chargeAccountsProvider);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ApplicationServicesModule..ModuleAdapter.ProvidePaymentServiceProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */