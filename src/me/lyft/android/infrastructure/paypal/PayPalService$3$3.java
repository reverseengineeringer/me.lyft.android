package me.lyft.android.infrastructure.paypal;

import com.braintreepayments.api.Braintree;
import com.braintreepayments.api.Braintree.ErrorListener;
import com.braintreepayments.api.Braintree.PaymentMethodNonceListener;
import rx.functions.Action0;

class PayPalService$3$3
  implements Action0
{
  PayPalService$3$3(PayPalService.3 param3, Braintree.PaymentMethodNonceListener paramPaymentMethodNonceListener, Braintree.ErrorListener paramErrorListener) {}
  
  public void call()
  {
    this$1.val$braintree.removeListener(val$nonceListener);
    this$1.val$braintree.removeListener(val$errorListener);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.paypal.PayPalService.3.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */