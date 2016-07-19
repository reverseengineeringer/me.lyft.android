package me.lyft.android.ui.passenger;

import android.content.res.Resources;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.application.checkout.ICheckoutSession;
import me.lyft.android.application.constants.IConstantsProvider;
import me.lyft.android.application.features.IFeaturesProvider;
import me.lyft.android.application.requestridetypes.IRequestRideTypeService;
import me.lyft.android.application.ride.IRideRequestSession;
import me.lyft.android.application.ride.services.IScheduledRideService;
import me.lyft.android.application.ride.services.ScheduledRideService;
import me.lyft.android.common.AppFlow;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.controls.PassengerToolbar;
import me.lyft.android.infrastructure.lyft.ILyftApi;
import me.lyft.android.ui.IViewErrorHandler;
import me.lyft.android.ui.MainScreensRouter;
import me.lyft.android.ui.dialogs.RateCardDialogController;
import me.lyft.android.ui.landing.LandingFlow;
import me.lyft.android.ui.passenger.autofill.AutoFillConfirmationDialogController;
import me.lyft.android.ui.passenger.rateandpay.PassengerRateView;
import me.lyft.android.ui.passenger.rateandpay.PassengerRideExpenseNoteView;
import me.lyft.android.ui.passenger.rateandpay.PassengerSubmitRatingButton;
import me.lyft.android.ui.passenger.rateandpay.PaymentHelpView;
import me.lyft.android.ui.passenger.rateandpay.PriceBreakdownDialogController;
import me.lyft.android.ui.passenger.rateandpay.TipDialogController;
import me.lyft.android.ui.passenger.v2.PassengerRideRouter;
import me.lyft.android.ui.passenger.v2.inride.ContactDriverDialogController;
import me.lyft.android.ui.passenger.v2.inride.EditPickupInRideView;
import me.lyft.android.ui.passenger.v2.inride.InRideActionsView;
import me.lyft.android.ui.passenger.v2.request.PromptToRateDialogController;
import me.lyft.android.ui.passenger.v2.request.dialogs.CarpoolDriverAboutDialogController;
import me.lyft.android.ui.passenger.v2.request.dialogs.CarpoolDriverInfoDialogController;
import me.lyft.android.ui.passenger.v2.request.dialogs.CarpoolLineFallbackDialogController;
import me.lyft.android.ui.passenger.v2.request.dialogs.CarpoolRideTypeInfoDialogController;
import me.lyft.android.ui.passenger.v2.request.dialogs.CarpoolUnlockRouteDialogController;
import me.lyft.android.ui.passenger.v2.request.pickup.ScheduledRidesToolbarItem;
import me.lyft.android.ui.passenger.v2.request.venue.ProhibitedVenueDialogController;
import me.lyft.android.ui.passenger.v2.scheduled.PassengerScheduledRideCancellationDialogController;

@Module(complete=false, injects={PaymentHelpView.class, PassengerRateView.class, PassengerRideExpenseNoteView.class, PassengerSubmitRatingButton.class, PassengerToolbar.class, ScheduledRidesToolbarItem.class, RateCardDialogController.class, CourierRideTypeInfoDialogController.class, PromptToRateDialogController.class, PrimeTimeRequestRideDialogController.class, PrimeTimeInfoDialogController.class, TipDialogController.class, PriceBreakdownDialogController.class, EditPickupInRideView.class, InRideActionsView.class, PostRideSocialDialogController.class, PartySizePickerDialogController.class, CarpoolDriverInfoDialogController.class, CarpoolDriverAboutDialogController.class, CarpoolUnlockRouteDialogController.class, CarpoolLineFallbackDialogController.class, CarpoolRideTypeInfoDialogController.class, PassengerCancelRideDialogViewController.class, ConfirmPickupLocationDialogController.class, ConfirmDefaultedPickupLocationDialogController.class, LockedAddressDialogController.class, ProhibitedVenueDialogController.class, ContactDriverDialogController.class, AutoFillConfirmationDialogController.class, PassengerScheduledRideCancellationDialogController.class})
public class PassengerModule
{
  @Provides
  @Singleton
  PassengerRideRouter providePassengerRequestRideRouter(AppFlow paramAppFlow, DialogFlow paramDialogFlow, LandingFlow paramLandingFlow, MainScreensRouter paramMainScreensRouter, IViewErrorHandler paramIViewErrorHandler, Resources paramResources, IConstantsProvider paramIConstantsProvider, IFeaturesProvider paramIFeaturesProvider, IUserProvider paramIUserProvider, ICheckoutSession paramICheckoutSession, IRideRequestSession paramIRideRequestSession)
  {
    return new PassengerRideRouter(paramAppFlow, paramDialogFlow, paramLandingFlow, paramMainScreensRouter, paramIViewErrorHandler, paramResources, paramIConstantsProvider, paramIFeaturesProvider, paramIUserProvider, paramICheckoutSession, paramIRideRequestSession);
  }
  
  @Provides
  @Singleton
  IScheduledRideService provideScheduledRideService(ILyftApi paramILyftApi, IFeaturesProvider paramIFeaturesProvider, IRequestRideTypeService paramIRequestRideTypeService)
  {
    return new ScheduledRideService(paramILyftApi, paramIFeaturesProvider, paramIRequestRideTypeService);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.passenger.PassengerModule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */