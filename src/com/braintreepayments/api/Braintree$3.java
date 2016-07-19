package com.braintreepayments.api;

import android.app.Activity;
import com.braintreepayments.api.exceptions.BraintreeException;
import com.braintreepayments.api.exceptions.ErrorWithResponse;
import com.braintreepayments.api.models.CardBuilder;

class Braintree$3
  implements Runnable
{
  Braintree$3(Braintree paramBraintree, CardBuilder paramCardBuilder, Activity paramActivity, int paramInt, String paramString) {}
  
  public void run()
  {
    try
    {
      String str = Braintree.access$000(this$0).tokenize(val$cardBuilder);
      this$0.startThreeDSecureVerification(val$activity, val$requestCode, str, val$amount);
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
 * Qualified Name:     com.braintreepayments.api.Braintree.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */