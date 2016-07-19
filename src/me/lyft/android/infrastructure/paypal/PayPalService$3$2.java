package me.lyft.android.infrastructure.paypal;

import com.braintreepayments.api.Braintree.ErrorListener;
import com.braintreepayments.api.exceptions.ErrorWithResponse;
import rx.Subscriber;

class PayPalService$3$2
  implements Braintree.ErrorListener
{
  PayPalService$3$2(PayPalService.3 param3, Subscriber paramSubscriber) {}
  
  public void onRecoverableError(ErrorWithResponse paramErrorWithResponse)
  {
    val$subscriber.onError(new PayPalServiceException(paramErrorWithResponse, "recoverable_error_" + paramErrorWithResponse.toString()));
  }
  
  public void onUnrecoverableError(Throwable paramThrowable)
  {
    val$subscriber.onError(new PayPalServiceException(paramThrowable, "unrecoverable_error_" + paramThrowable.getMessage()));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.paypal.PayPalService.3.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */