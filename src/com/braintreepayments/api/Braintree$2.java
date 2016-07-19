package com.braintreepayments.api;

import com.braintreepayments.api.exceptions.BraintreeException;
import com.braintreepayments.api.exceptions.ErrorWithResponse;
import com.braintreepayments.api.models.PaymentMethod;
import org.json.JSONException;

class Braintree$2
  implements Runnable
{
  Braintree$2(Braintree paramBraintree, String paramString) {}
  
  public void run()
  {
    try
    {
      PaymentMethod localPaymentMethod = Braintree.access$000(this$0).getPaymentMethod(val$nonce);
      localPaymentMethod.setSource("venmo-app");
      Braintree.access$400(this$0, localPaymentMethod);
      Braintree.access$500(this$0, localPaymentMethod);
      Braintree.access$600(this$0, val$nonce);
      this$0.sendAnalyticsEvent("venmo-app.success");
      return;
    }
    catch (BraintreeException localBraintreeException)
    {
      this$0.postUnrecoverableErrorToListeners(localBraintreeException);
      return;
    }
    catch (JSONException localJSONException)
    {
      this$0.postUnrecoverableErrorToListeners(localJSONException);
      return;
    }
    catch (ErrorWithResponse localErrorWithResponse)
    {
      Braintree.access$300(this$0, localErrorWithResponse);
    }
  }
}

/* Location:
 * Qualified Name:     com.braintreepayments.api.Braintree.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */