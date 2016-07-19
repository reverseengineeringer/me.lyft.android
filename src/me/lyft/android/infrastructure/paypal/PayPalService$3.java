package me.lyft.android.infrastructure.paypal;

import com.braintreepayments.api.Braintree;
import com.braintreepayments.api.Braintree.ErrorListener;
import com.braintreepayments.api.Braintree.PaymentMethodNonceListener;
import com.braintreepayments.api.exceptions.ErrorWithResponse;
import me.lyft.android.utils.ActivityResult;
import rx.Observable.OnSubscribe;
import rx.Subscriber;
import rx.functions.Action0;
import rx.subscriptions.Subscriptions;

class PayPalService$3
  implements Observable.OnSubscribe<PayPalChargeData>
{
  PayPalService$3(PayPalService paramPayPalService, Braintree paramBraintree, ActivityResult paramActivityResult) {}
  
  public void call(final Subscriber<? super PayPalChargeData> paramSubscriber)
  {
    final Braintree.PaymentMethodNonceListener local1 = new Braintree.PaymentMethodNonceListener()
    {
      public void onPaymentMethodNonce(String paramAnonymousString)
      {
        String str = val$braintree.collectDeviceData(PayPalService.access$100(this$0), PayPalService.access$200());
        paramSubscriber.onNext(new PayPalChargeData(paramAnonymousString, str));
        paramSubscriber.onCompleted();
      }
    };
    final Braintree.ErrorListener local2 = new Braintree.ErrorListener()
    {
      public void onRecoverableError(ErrorWithResponse paramAnonymousErrorWithResponse)
      {
        paramSubscriber.onError(new PayPalServiceException(paramAnonymousErrorWithResponse, "recoverable_error_" + paramAnonymousErrorWithResponse.toString()));
      }
      
      public void onUnrecoverableError(Throwable paramAnonymousThrowable)
      {
        paramSubscriber.onError(new PayPalServiceException(paramAnonymousThrowable, "unrecoverable_error_" + paramAnonymousThrowable.getMessage()));
      }
    };
    paramSubscriber.add(Subscriptions.create(new Action0()
    {
      public void call()
      {
        val$braintree.removeListener(local1);
        val$braintree.removeListener(local2);
      }
    }));
    val$braintree.addListener(local1);
    val$braintree.addListener(local2);
    val$braintree.finishPayWithPayPal(PayPalService.access$300(this$0), val$activityResult.getResultCode(), val$activityResult.getIntent());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.paypal.PayPalService.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */