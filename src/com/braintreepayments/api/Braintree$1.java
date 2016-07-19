package com.braintreepayments.api;

import com.braintreepayments.api.exceptions.BraintreeException;
import com.braintreepayments.api.exceptions.ErrorWithResponse;
import java.util.List;

class Braintree$1
  implements Runnable
{
  Braintree$1(Braintree paramBraintree) {}
  
  public void run()
  {
    try
    {
      List localList = Braintree.access$000(this$0).getPaymentMethods();
      Braintree.access$102(this$0, localList);
      Braintree.access$200(this$0, localList);
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
 * Qualified Name:     com.braintreepayments.api.Braintree.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */