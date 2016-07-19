package me.lyft.android.application;

import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.application.checkout.ICheckoutSession;
import me.lyft.android.application.constants.IConstantsProvider;
import me.lyft.android.application.cost.ICostService;
import me.lyft.android.application.features.IFeaturesProvider;
import me.lyft.android.application.passenger.IPassengerRideProvider;
import me.lyft.android.application.payment.IPaymentDefaultsService;
import me.lyft.android.application.payment.IPaymentService;
import me.lyft.android.application.requestridetypes.IRequestRideTypeService;
import me.lyft.android.application.ride.IRideRequestService;
import me.lyft.android.application.ride.IRideRequestSession;
import me.lyft.android.infrastructure.location.ILocationService;
import me.lyft.android.infrastructure.lyft.ILyftApi;
import me.lyft.android.infrastructure.paypal.IPayPalService;
import me.lyft.android.persistence.payment.IChargeAccountsProvider;

public final class ApplicationServicesModule$$ModuleAdapter$ProvideRideRequestServiceProvidesAdapter
  extends ProvidesBinding<IRideRequestService>
{
  private Binding<IChargeAccountsProvider> chargeAccountsProvider;
  private Binding<ICheckoutSession> checkoutSession;
  private Binding<IConstantsProvider> constantsProvider;
  private Binding<ICostService> costService;
  private Binding<IPaymentDefaultsService> defaultPaymentSettingsService;
  private Binding<IFeaturesProvider> featuresProvider;
  private Binding<ILocationService> locationService;
  private Binding<ILyftApi> lyftApi;
  private final ApplicationServicesModule module;
  private Binding<IPassengerRideProvider> passengerRideProvider;
  private Binding<IPayPalService> payPalService;
  private Binding<IPaymentService> paymentService;
  private Binding<IRequestRideTypeService> requestRideTypeService;
  private Binding<IRideRequestSession> rideRequestSession;
  private Binding<IUserProvider> userProvider;
  
  public ApplicationServicesModule$$ModuleAdapter$ProvideRideRequestServiceProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
  {
    super("me.lyft.android.application.ride.IRideRequestService", true, "me.lyft.android.application.ApplicationServicesModule", "provideRideRequestService");
    module = paramApplicationServicesModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    userProvider = paramLinker.requestBinding("me.lyft.android.application.IUserProvider", ApplicationServicesModule.class, getClass().getClassLoader());
    chargeAccountsProvider = paramLinker.requestBinding("me.lyft.android.persistence.payment.IChargeAccountsProvider", ApplicationServicesModule.class, getClass().getClassLoader());
    locationService = paramLinker.requestBinding("me.lyft.android.infrastructure.location.ILocationService", ApplicationServicesModule.class, getClass().getClassLoader());
    rideRequestSession = paramLinker.requestBinding("me.lyft.android.application.ride.IRideRequestSession", ApplicationServicesModule.class, getClass().getClassLoader());
    lyftApi = paramLinker.requestBinding("me.lyft.android.infrastructure.lyft.ILyftApi", ApplicationServicesModule.class, getClass().getClassLoader());
    checkoutSession = paramLinker.requestBinding("me.lyft.android.application.checkout.ICheckoutSession", ApplicationServicesModule.class, getClass().getClassLoader());
    constantsProvider = paramLinker.requestBinding("me.lyft.android.application.constants.IConstantsProvider", ApplicationServicesModule.class, getClass().getClassLoader());
    featuresProvider = paramLinker.requestBinding("me.lyft.android.application.features.IFeaturesProvider", ApplicationServicesModule.class, getClass().getClassLoader());
    paymentService = paramLinker.requestBinding("me.lyft.android.application.payment.IPaymentService", ApplicationServicesModule.class, getClass().getClassLoader());
    defaultPaymentSettingsService = paramLinker.requestBinding("me.lyft.android.application.payment.IPaymentDefaultsService", ApplicationServicesModule.class, getClass().getClassLoader());
    payPalService = paramLinker.requestBinding("me.lyft.android.infrastructure.paypal.IPayPalService", ApplicationServicesModule.class, getClass().getClassLoader());
    costService = paramLinker.requestBinding("me.lyft.android.application.cost.ICostService", ApplicationServicesModule.class, getClass().getClassLoader());
    passengerRideProvider = paramLinker.requestBinding("me.lyft.android.application.passenger.IPassengerRideProvider", ApplicationServicesModule.class, getClass().getClassLoader());
    requestRideTypeService = paramLinker.requestBinding("me.lyft.android.application.requestridetypes.IRequestRideTypeService", ApplicationServicesModule.class, getClass().getClassLoader());
  }
  
  public IRideRequestService get()
  {
    return module.provideRideRequestService((IUserProvider)userProvider.get(), (IChargeAccountsProvider)chargeAccountsProvider.get(), (ILocationService)locationService.get(), (IRideRequestSession)rideRequestSession.get(), (ILyftApi)lyftApi.get(), (ICheckoutSession)checkoutSession.get(), (IConstantsProvider)constantsProvider.get(), (IFeaturesProvider)featuresProvider.get(), (IPaymentService)paymentService.get(), (IPaymentDefaultsService)defaultPaymentSettingsService.get(), (IPayPalService)payPalService.get(), (ICostService)costService.get(), (IPassengerRideProvider)passengerRideProvider.get(), (IRequestRideTypeService)requestRideTypeService.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(userProvider);
    paramSet1.add(chargeAccountsProvider);
    paramSet1.add(locationService);
    paramSet1.add(rideRequestSession);
    paramSet1.add(lyftApi);
    paramSet1.add(checkoutSession);
    paramSet1.add(constantsProvider);
    paramSet1.add(featuresProvider);
    paramSet1.add(paymentService);
    paramSet1.add(defaultPaymentSettingsService);
    paramSet1.add(payPalService);
    paramSet1.add(costService);
    paramSet1.add(passengerRideProvider);
    paramSet1.add(requestRideTypeService);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ApplicationServicesModule..ModuleAdapter.ProvideRideRequestServiceProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */