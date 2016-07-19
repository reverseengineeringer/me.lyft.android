package com.braintreepayments.api;

class Braintree$8$1
  implements Runnable
{
  Braintree$8$1(Braintree.8 param8, Braintree.PaymentMethodsUpdatedListener paramPaymentMethodsUpdatedListener) {}
  
  public void run()
  {
    val$listener.onPaymentMethodsUpdated(this$1.val$paymentMethodsSafe);
  }
}

/* Location:
 * Qualified Name:     com.braintreepayments.api.Braintree.8.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */