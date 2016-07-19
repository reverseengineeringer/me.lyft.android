package me.lyft.android.application;

import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.application.checkout.ICheckoutSession;
import me.lyft.android.application.ride.IWearRideRequestService;
import me.lyft.android.infrastructure.lyft.ILyftApi;
import me.lyft.android.persistence.payment.IChargeAccountsProvider;

public final class ApplicationServicesModule$$ModuleAdapter$ProvideWearRideRequestServiceProvidesAdapter
  extends ProvidesBinding<IWearRideRequestService>
{
  private Binding<IChargeAccountsProvider> chargeAccountsProvider;
  private Binding<ICheckoutSession> checkoutSession;
  private Binding<ILyftApi> lyftApi;
  private final ApplicationServicesModule module;
  private Binding<IUserProvider> userProvider;
  
  public ApplicationServicesModule$$ModuleAdapter$ProvideWearRideRequestServiceProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
  {
    super("me.lyft.android.application.ride.IWearRideRequestService", false, "me.lyft.android.application.ApplicationServicesModule", "provideWearRideRequestService");
    module = paramApplicationServicesModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    userProvider = paramLinker.requestBinding("me.lyft.android.application.IUserProvider", ApplicationServicesModule.class, getClass().getClassLoader());
    chargeAccountsProvider = paramLinker.requestBinding("me.lyft.android.persistence.payment.IChargeAccountsProvider", ApplicationServicesModule.class, getClass().getClassLoader());
    lyftApi = paramLinker.requestBinding("me.lyft.android.infrastructure.lyft.ILyftApi", ApplicationServicesModule.class, getClass().getClassLoader());
    checkoutSession = paramLinker.requestBinding("me.lyft.android.application.checkout.ICheckoutSession", ApplicationServicesModule.class, getClass().getClassLoader());
  }
  
  public IWearRideRequestService get()
  {
    return module.provideWearRideRequestService((IUserProvider)userProvider.get(), (IChargeAccountsProvider)chargeAccountsProvider.get(), (ILyftApi)lyftApi.get(), (ICheckoutSession)checkoutSession.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(userProvider);
    paramSet1.add(chargeAccountsProvider);
    paramSet1.add(lyftApi);
    paramSet1.add(checkoutSession);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ApplicationServicesModule..ModuleAdapter.ProvideWearRideRequestServiceProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */