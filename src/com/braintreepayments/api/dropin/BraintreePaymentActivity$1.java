package com.braintreepayments.api.dropin;

import com.braintreepayments.api.models.PaymentMethod;

class BraintreePaymentActivity$1
  implements Runnable
{
  BraintreePaymentActivity$1(BraintreePaymentActivity paramBraintreePaymentActivity, PaymentMethod paramPaymentMethod) {}
  
  public void run()
  {
    this$0.runOnUiThread(new Runnable()
    {
      public void run()
      {
        this$0.finalizeSelection(val$paymentMethod);
      }
    });
  }
}

/* Location:
 * Qualified Name:     com.braintreepayments.api.dropin.BraintreePaymentActivity.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */