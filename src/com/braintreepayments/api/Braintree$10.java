package com.braintreepayments.api;

import android.os.Handler;
import java.util.Iterator;
import java.util.Set;

class Braintree$10
  implements Braintree.ListenerCallback
{
  Braintree$10(Braintree paramBraintree, String paramString) {}
  
  public void execute()
  {
    Iterator localIterator = Braintree.access$1000(this$0).iterator();
    while (localIterator.hasNext())
    {
      final Braintree.PaymentMethodNonceListener localPaymentMethodNonceListener = (Braintree.PaymentMethodNonceListener)localIterator.next();
      Braintree.access$800(this$0).post(new Runnable()
      {
        public void run()
        {
          localPaymentMethodNonceListener.onPaymentMethodNonce(val$nonce);
        }
      });
    }
  }
  
  public boolean hasListeners()
  {
    return !Braintree.access$1000(this$0).isEmpty();
  }
}

/* Location:
 * Qualified Name:     com.braintreepayments.api.Braintree.10
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */