package com.braintreepayments.api.exceptions;

import java.io.IOException;

public class BraintreeException
  extends IOException
{
  public BraintreeException() {}
  
  public BraintreeException(String paramString)
  {
    super(paramString);
  }
}

/* Location:
 * Qualified Name:     com.braintreepayments.api.exceptions.BraintreeException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */