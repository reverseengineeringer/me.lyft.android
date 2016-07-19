package com.braintreepayments.api.models;

import java.io.Serializable;

public class PaymentMethodOptions
  implements Serializable
{
  private boolean validate;
  
  public void setValidate(boolean paramBoolean)
  {
    validate = paramBoolean;
  }
}

/* Location:
 * Qualified Name:     com.braintreepayments.api.models.PaymentMethodOptions
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */