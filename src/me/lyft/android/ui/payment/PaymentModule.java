package me.lyft.android.ui.payment;

import android.content.res.Resources;
import com.lyft.rx.MessageBus;
import dagger.Module;
import dagger.Provides;
import me.lyft.android.application.constants.IConstantsProvider;
import me.lyft.android.application.payment.IPaymentService;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.ui.IProgressController;
import me.lyft.android.ui.IViewErrorHandler;
import me.lyft.android.ui.dialogs.PaymentDialogController;
import me.lyft.android.ui.payment.cardinput.CreditCardInput;

@Module(complete=false, injects={AddCreditCardView.class, AddChargeAccountView.class, AddCreditCardPaymentItemView.class, AddWalletCardPaymentItemView.class, AddCouponView.class, CommuteCreditPaymentListItemView.class, CreditCardPaymentItemView.class, CreditLinePaymentItemView.class, DebtAddCardListItemView.class, DebtChargeAccountView.class, DebtCreditCardListItemView.class, DebtListItemView.class, DebtView.class, DebtWalletListItemView.class, EditCreditCardView.class, EditCreditLineView.class, EditAndroidPayView.class, LyftCreditPaymentListItemView.class, LyftCreditView.class, PaymentSelectCheckoutController.class, PaymentSelectDefaultController.class, WalletPaymentItemView.class, CreditCardInput.class, AddPayPalPaymentItemView.class, PayPalPaymentItemView.class, EditPayPalView.class, DebtPayPalListItemView.class, AddCreditCardFraudView.class, ConcurView.class, ConcurRideView.class, ConcurSendRideReceiptsView.class, FacebookPaymentItemView.class, EditFacebookCreditCardView.class, PaymentCardListWidgetView.class, PaymentDefaultCardListWidgetView.class, PaymentCreditsListWidgetView.class, PaymentSelectableCardListWidgetView.class, PaymentSelectableCreditsListWidgetView.class, PaymentBusinessDefaultsWidgetView.class, BusinessDefaultPaymentListItemView.class, EditCreditCardPaymentItemView.class, EditCreditLinePaymentItemView.class, EditFacebookPaymentItemView.class, EditPayPalPaymentItemView.class, EditAndroidPayPaymentItemView.class, SelectableCommuteCreditPaymentListItemView.class, SelectableLyftCreditPaymentListItemView.class, SelectableCreditCardPaymentItemView.class, SelectableCreditLinePaymentItemView.class, SelectableFacebookPaymentItemView.class, SelectablePayPalPaymentItemView.class, SelectableWalletPaymentItemView.class, PaymentDialogController.class, FacebookMessengerNotInstalledDialogController.class})
public class PaymentModule
{
  @Provides
  public FacebookMessengerNotInstalledDialogController facebookMessengerNotInstalledDialogController(DialogFlow paramDialogFlow)
  {
    return new FacebookMessengerNotInstalledDialogController(paramDialogFlow);
  }
  
  @Provides
  public PaymentDialogController paymentDialogController(DialogFlow paramDialogFlow, IPaymentService paramIPaymentService, IProgressController paramIProgressController, IPaymentErrorHandler paramIPaymentErrorHandler, MessageBus paramMessageBus, IConstantsProvider paramIConstantsProvider)
  {
    return new PaymentDialogController(paramDialogFlow, paramIPaymentService, paramIProgressController, paramIPaymentErrorHandler, paramMessageBus, paramIConstantsProvider);
  }
  
  @Provides
  public IPaymentErrorHandler providePaymentErrorHandler(IViewErrorHandler paramIViewErrorHandler, Resources paramResources, DialogFlow paramDialogFlow)
  {
    return new PaymentErrorHandler(paramIViewErrorHandler, paramResources, paramDialogFlow);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.payment.PaymentModule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */