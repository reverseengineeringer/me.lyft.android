package me.lyft.android.infrastructure.paypal;

import com.braintreepayments.api.Braintree;
import com.braintreepayments.api.Braintree.PaymentMethodNonceListener;
import rx.Subscriber;

class PayPalService$3$1
  implements Braintree.PaymentMethodNonceListener
{
  PayPalService$3$1(PayPalService.3 param3, Subscriber paramSubscriber) {}
  
  public void onPaymentMethodNonce(String paramString)
  {
    String str = this$1.val$braintree.collectDeviceData(PayPalService.access$100(this$1.this$0), PayPalService.access$200());
    val$subscriber.onNext(new PayPalChargeData(paramString, str));
    val$subscriber.onCompleted();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.paypal.PayPalService.3.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */