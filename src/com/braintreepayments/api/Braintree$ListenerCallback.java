package com.braintreepayments.api;

public abstract interface Braintree$ListenerCallback
{
  public abstract void execute();
  
  public abstract boolean hasListeners();
}

/* Location:
 * Qualified Name:     com.braintreepayments.api.Braintree.ListenerCallback
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */