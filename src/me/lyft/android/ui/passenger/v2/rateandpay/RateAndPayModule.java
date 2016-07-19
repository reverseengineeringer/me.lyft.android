package me.lyft.android.ui.passenger.v2.rateandpay;

import android.content.res.Resources;
import dagger.Module;
import dagger.Provides;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.application.checkout.ICheckoutSession;
import me.lyft.android.application.passenger.IPassengerRideProvider;
import me.lyft.android.application.passenger.IPassengerRideService;
import me.lyft.android.application.ride.IExpenseNoteSession;
import me.lyft.android.application.ride.IRatingSession;
import me.lyft.android.common.AppFlow;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.managers.ImageLoader;
import me.lyft.android.maps.MapOwner;
import me.lyft.android.maps.renderers.PassengerDestinationReceiptRenderer;
import me.lyft.android.persistence.payment.IChargeAccountsProvider;
import me.lyft.android.persistence.ride.IPassengerRideReceiptService;
import me.lyft.android.ui.MainActivityModule;
import me.lyft.android.ui.MainScreensRouter;
import me.lyft.android.ui.payment.PaymentSelectCheckoutController;

@Module(addsTo=MainActivityModule.class, injects={PassengerPaymentController.class, PassengerExpenseNotesController.class, PaymentSelectCheckoutController.class})
public class RateAndPayModule
{
  @Provides
  public PassengerExpenseNotesController providePassengerExpenseNotesController(AppFlow paramAppFlow, MapOwner paramMapOwner, IPassengerRideService paramIPassengerRideService, IRatingSession paramIRatingSession, IExpenseNoteSession paramIExpenseNoteSession, ICheckoutSession paramICheckoutSession, MainScreensRouter paramMainScreensRouter, PassengerDestinationReceiptRenderer paramPassengerDestinationReceiptRenderer, IPassengerRideProvider paramIPassengerRideProvider)
  {
    return new PassengerExpenseNotesController(paramAppFlow, paramMapOwner, paramIPassengerRideService, paramIRatingSession, paramIExpenseNoteSession, paramICheckoutSession, paramMainScreensRouter, paramPassengerDestinationReceiptRenderer, paramIPassengerRideProvider);
  }
  
  @Provides
  public PassengerPaymentPresenter providePassengerPaymentPresenter(IRatingSession paramIRatingSession, IPassengerRideReceiptService paramIPassengerRideReceiptService, ICheckoutSession paramICheckoutSession, IExpenseNoteSession paramIExpenseNoteSession, AppFlow paramAppFlow, IPassengerRideService paramIPassengerRideService, MainScreensRouter paramMainScreensRouter, IPassengerRideProvider paramIPassengerRideProvider, IUserProvider paramIUserProvider)
  {
    return new PassengerPaymentPresenter(paramIRatingSession, paramIPassengerRideReceiptService, paramICheckoutSession, paramIExpenseNoteSession, paramAppFlow, paramIPassengerRideService, paramMainScreensRouter, paramIPassengerRideProvider, paramIUserProvider);
  }
  
  @Provides
  public PassengerPaymentController providePayController(MapOwner paramMapOwner, ImageLoader paramImageLoader, AppFlow paramAppFlow, DialogFlow paramDialogFlow, PassengerPaymentPresenter paramPassengerPaymentPresenter, Resources paramResources, PassengerDestinationReceiptRenderer paramPassengerDestinationReceiptRenderer, IPassengerRideProvider paramIPassengerRideProvider)
  {
    return new PassengerPaymentController(paramMapOwner, paramImageLoader, paramAppFlow, paramDialogFlow, paramPassengerPaymentPresenter, paramPassengerDestinationReceiptRenderer, paramIPassengerRideProvider);
  }
  
  @Provides
  public PaymentSelectCheckoutController providePaymentSelectCheckoutController(MainScreensRouter paramMainScreensRouter, IUserProvider paramIUserProvider, IChargeAccountsProvider paramIChargeAccountsProvider)
  {
    return new PaymentSelectCheckoutController(paramMainScreensRouter, paramIUserProvider, paramIChargeAccountsProvider);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.passenger.v2.rateandpay.RateAndPayModule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */