package com.braintreepayments.api;

import com.braintreepayments.api.models.PaymentMethod;

public abstract interface Braintree$PaymentMethodCreatedListener
  extends Braintree.Listener
{
  public abstract void onPaymentMethodCreated(PaymentMethod paramPaymentMethod);
}

/* Location:
 * Qualified Name:     com.braintreepayments.api.Braintree.PaymentMethodCreatedListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */