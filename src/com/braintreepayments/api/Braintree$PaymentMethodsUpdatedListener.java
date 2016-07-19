package com.braintreepayments.api;

import com.braintreepayments.api.models.PaymentMethod;
import java.util.List;

public abstract interface Braintree$PaymentMethodsUpdatedListener
  extends Braintree.Listener
{
  public abstract void onPaymentMethodsUpdated(List<PaymentMethod> paramList);
}

/* Location:
 * Qualified Name:     com.braintreepayments.api.Braintree.PaymentMethodsUpdatedListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */