package com.braintreepayments.api;

class Braintree$9$1
  implements Runnable
{
  Braintree$9$1(Braintree.9 param9, Braintree.PaymentMethodCreatedListener paramPaymentMethodCreatedListener) {}
  
  public void run()
  {
    val$listener.onPaymentMethodCreated(this$1.val$paymentMethod);
  }
}

/* Location:
 * Qualified Name:     com.braintreepayments.api.Braintree.9.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */