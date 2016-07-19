package com.braintreepayments.api;

import com.braintreepayments.api.exceptions.BraintreeException;
import com.braintreepayments.api.exceptions.ErrorWithResponse;
import com.braintreepayments.api.models.PaymentMethod;
import com.braintreepayments.api.models.PaymentMethod.Builder;

class Braintree$5
  implements Runnable
{
  Braintree$5(Braintree paramBraintree, PaymentMethod.Builder paramBuilder) {}
  
  public void run()
  {
    try
    {
      PaymentMethod localPaymentMethod = Braintree.access$000(this$0).create(val$paymentMethodBuilder);
      Braintree.access$400(this$0, localPaymentMethod);
      Braintree.access$500(this$0, localPaymentMethod);
      Braintree.access$600(this$0, localPaymentMethod.getNonce());
      return;
    }
    catch (BraintreeException localBraintreeException)
    {
      this$0.postUnrecoverableErrorToListeners(localBraintreeException);
      return;
    }
    catch (ErrorWithResponse localErrorWithResponse)
    {
      Braintree.access$300(this$0, localErrorWithResponse);
    }
  }
}

/* Location:
 * Qualified Name:     com.braintreepayments.api.Braintree.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */