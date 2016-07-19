package com.braintreepayments.api;

import android.os.Handler;
import com.braintreepayments.api.models.PaymentMethod;
import java.util.Iterator;
import java.util.Set;

class Braintree$9
  implements Braintree.ListenerCallback
{
  Braintree$9(Braintree paramBraintree, PaymentMethod paramPaymentMethod) {}
  
  public void execute()
  {
    Iterator localIterator = Braintree.access$900(this$0).iterator();
    while (localIterator.hasNext())
    {
      final Braintree.PaymentMethodCreatedListener localPaymentMethodCreatedListener = (Braintree.PaymentMethodCreatedListener)localIterator.next();
      Braintree.access$800(this$0).post(new Runnable()
      {
        public void run()
        {
          localPaymentMethodCreatedListener.onPaymentMethodCreated(val$paymentMethod);
        }
      });
    }
  }
  
  public boolean hasListeners()
  {
    return !Braintree.access$900(this$0).isEmpty();
  }
}

/* Location:
 * Qualified Name:     com.braintreepayments.api.Braintree.9
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */