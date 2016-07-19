package me.lyft.android.application;

import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.application.constants.IConstantsProvider;
import me.lyft.android.application.landing.ILandingService;
import me.lyft.android.application.payment.IPaymentService;
import me.lyft.android.common.IAppStore;
import me.lyft.android.infrastructure.location.ILocationService;
import me.lyft.android.infrastructure.lyft.ILyftApi;
import me.lyft.android.persistence.landing.ISignUpUserRepository;
import me.lyft.android.persistence.payment.IChargeAccountsProvider;

public final class ApplicationServicesModule$$ModuleAdapter$ProvideLandingServiceProvidesAdapter
  extends ProvidesBinding<ILandingService>
{
  private Binding<IAppStore> appStore;
  private Binding<IChargeAccountsProvider> chargeAccountsProvider;
  private Binding<IConstantsProvider> constantsProvider;
  private Binding<ILocationService> locationService;
  private Binding<ILyftApi> lyftApi;
  private final ApplicationServicesModule module;
  private Binding<IPaymentService> paymentService;
  private Binding<ILyftPreferences> preferences;
  private Binding<ISignUpUserRepository> singUpUserRepository;
  private Binding<IUserProvider> userProvider;
  
  public ApplicationServicesModule$$ModuleAdapter$ProvideLandingServiceProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
  {
    super("me.lyft.android.application.landing.ILandingService", false, "me.lyft.android.application.ApplicationServicesModule", "provideLandingService");
    module = paramApplicationServicesModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    singUpUserRepository = paramLinker.requestBinding("me.lyft.android.persistence.landing.ISignUpUserRepository", ApplicationServicesModule.class, getClass().getClassLoader());
    userProvider = paramLinker.requestBinding("me.lyft.android.application.IUserProvider", ApplicationServicesModule.class, getClass().getClassLoader());
    lyftApi = paramLinker.requestBinding("me.lyft.android.infrastructure.lyft.ILyftApi", ApplicationServicesModule.class, getClass().getClassLoader());
    locationService = paramLinker.requestBinding("me.lyft.android.infrastructure.location.ILocationService", ApplicationServicesModule.class, getClass().getClassLoader());
    preferences = paramLinker.requestBinding("me.lyft.android.ILyftPreferences", ApplicationServicesModule.class, getClass().getClassLoader());
    paymentService = paramLinker.requestBinding("me.lyft.android.application.payment.IPaymentService", ApplicationServicesModule.class, getClass().getClassLoader());
    chargeAccountsProvider = paramLinker.requestBinding("me.lyft.android.persistence.payment.IChargeAccountsProvider", ApplicationServicesModule.class, getClass().getClassLoader());
    constantsProvider = paramLinker.requestBinding("me.lyft.android.application.constants.IConstantsProvider", ApplicationServicesModule.class, getClass().getClassLoader());
    appStore = paramLinker.requestBinding("me.lyft.android.common.IAppStore", ApplicationServicesModule.class, getClass().getClassLoader());
  }
  
  public ILandingService get()
  {
    return module.provideLandingService((ISignUpUserRepository)singUpUserRepository.get(), (IUserProvider)userProvider.get(), (ILyftApi)lyftApi.get(), (ILocationService)locationService.get(), (ILyftPreferences)preferences.get(), (IPaymentService)paymentService.get(), (IChargeAccountsProvider)chargeAccountsProvider.get(), (IConstantsProvider)constantsProvider.get(), (IAppStore)appStore.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(singUpUserRepository);
    paramSet1.add(userProvider);
    paramSet1.add(lyftApi);
    paramSet1.add(locationService);
    paramSet1.add(preferences);
    paramSet1.add(paymentService);
    paramSet1.add(chargeAccountsProvider);
    paramSet1.add(constantsProvider);
    paramSet1.add(appStore);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ApplicationServicesModule..ModuleAdapter.ProvideLandingServiceProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */