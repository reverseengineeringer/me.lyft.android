package com.braintreepayments.api;

import com.braintreepayments.api.exceptions.BraintreeException;
import com.braintreepayments.api.exceptions.ErrorWithResponse;
import com.braintreepayments.api.models.PaymentMethod.Builder;

class Braintree$6
  implements Runnable
{
  Braintree$6(Braintree paramBraintree, PaymentMethod.Builder paramBuilder) {}
  
  public void run()
  {
    try
    {
      String str = Braintree.access$000(this$0).tokenize(val$paymentMethodBuilder);
      Braintree.access$600(this$0, str);
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
 * Qualified Name:     com.braintreepayments.api.Braintree.6
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */