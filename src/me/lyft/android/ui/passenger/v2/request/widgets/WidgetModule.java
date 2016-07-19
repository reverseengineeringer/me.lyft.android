package me.lyft.android.ui.passenger.v2.request.widgets;

import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.application.checkout.ICheckoutSession;
import me.lyft.android.application.cost.ICostService;
import me.lyft.android.application.features.IFeaturesProvider;
import me.lyft.android.application.requestridetypes.IRequestRideTypeService;
import me.lyft.android.application.ride.IRideRequestSession;
import me.lyft.android.persistence.payment.IChargeAccountsProvider;
import me.lyft.android.ui.passenger.v2.PassengerAnalytics;
import me.lyft.android.ui.passenger.v2.PassengerRideRouter;
import me.lyft.android.ui.passenger.v2.request.RequestModule;

@Module(addsTo=RequestModule.class, complete=false, injects={WidgetContainer.class})
public class WidgetModule
{
  @Provides
  @Singleton
  BusinessProfileWidgetPresenter provideBusinessProfileWidgetPresenter(IChargeAccountsProvider paramIChargeAccountsProvider, IUserProvider paramIUserProvider, PassengerRideRouter paramPassengerRideRouter, ICheckoutSession paramICheckoutSession)
  {
    return new BusinessProfileWidgetPresenter(paramIChargeAccountsProvider, paramIUserProvider, paramPassengerRideRouter, paramICheckoutSession);
  }
  
  @Provides
  @Singleton
  PriceEstimatePresenter provideFareEstimatePresenter(ICostService paramICostService, IRideRequestSession paramIRideRequestSession, PassengerRideRouter paramPassengerRideRouter)
  {
    return new PriceEstimatePresenter(paramICostService, paramIRideRequestSession, paramPassengerRideRouter);
  }
  
  @Provides
  @Singleton
  FixedFareWidgetPresenter provideFixedFareWidgetPresenter(ICostService paramICostService, IRideRequestSession paramIRideRequestSession, PassengerRideRouter paramPassengerRideRouter)
  {
    return new FixedFareWidgetPresenter(paramICostService, paramIRideRequestSession, paramPassengerRideRouter);
  }
  
  @Provides
  PaymentWidgetPresenter providePaymentWidgetPresenter(IChargeAccountsProvider paramIChargeAccountsProvider, IUserProvider paramIUserProvider, PassengerRideRouter paramPassengerRideRouter, ICheckoutSession paramICheckoutSession)
  {
    return new PaymentWidgetPresenter(paramIChargeAccountsProvider, paramIUserProvider, paramPassengerRideRouter, paramICheckoutSession);
  }
  
  @Provides
  @Singleton
  PrimeTimeWidgetPresenter providePrimeTimeWidgetPresenter(IRideRequestSession paramIRideRequestSession, ICostService paramICostService, PassengerRideRouter paramPassengerRideRouter, PassengerAnalytics paramPassengerAnalytics)
  {
    return new PrimeTimeWidgetPresenter(paramIRideRequestSession, paramICostService, paramPassengerRideRouter, paramPassengerAnalytics);
  }
  
  @Provides
  @Singleton
  WidgetContainerPresenter provideWidgetContainerPresenter(IRideRequestSession paramIRideRequestSession, IRequestRideTypeService paramIRequestRideTypeService, ICostService paramICostService, IFeaturesProvider paramIFeaturesProvider, IUserProvider paramIUserProvider, PassengerAnalytics paramPassengerAnalytics)
  {
    return new WidgetContainerPresenter(paramIRideRequestSession, paramIRequestRideTypeService, paramICostService, paramIFeaturesProvider, paramIUserProvider, paramPassengerAnalytics);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.passenger.v2.request.widgets.WidgetModule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */