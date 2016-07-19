package com.braintreepayments.api;

import android.os.Handler;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

class Braintree$8
  implements Braintree.ListenerCallback
{
  Braintree$8(Braintree paramBraintree, List paramList) {}
  
  public void execute()
  {
    Iterator localIterator = Braintree.access$700(this$0).iterator();
    while (localIterator.hasNext())
    {
      final Braintree.PaymentMethodsUpdatedListener localPaymentMethodsUpdatedListener = (Braintree.PaymentMethodsUpdatedListener)localIterator.next();
      Braintree.access$800(this$0).post(new Runnable()
      {
        public void run()
        {
          localPaymentMethodsUpdatedListener.onPaymentMethodsUpdated(val$paymentMethodsSafe);
        }
      });
    }
  }
  
  public boolean hasListeners()
  {
    return !Braintree.access$700(this$0).isEmpty();
  }
}

/* Location:
 * Qualified Name:     com.braintreepayments.api.Braintree.8
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */