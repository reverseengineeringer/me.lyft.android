package com.braintreepayments.api;

class Braintree$10$1
  implements Runnable
{
  Braintree$10$1(Braintree.10 param10, Braintree.PaymentMethodNonceListener paramPaymentMethodNonceListener) {}
  
  public void run()
  {
    val$listener.onPaymentMethodNonce(this$1.val$nonce);
  }
}

/* Location:
 * Qualified Name:     com.braintreepayments.api.Braintree.10.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */