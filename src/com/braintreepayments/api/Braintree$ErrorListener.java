package com.braintreepayments.api;

import com.braintreepayments.api.exceptions.ErrorWithResponse;

public abstract interface Braintree$ErrorListener
  extends Braintree.Listener
{
  public abstract void onRecoverableError(ErrorWithResponse paramErrorWithResponse);
  
  public abstract void onUnrecoverableError(Throwable paramThrowable);
}

/* Location:
 * Qualified Name:     com.braintreepayments.api.Braintree.ErrorListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */