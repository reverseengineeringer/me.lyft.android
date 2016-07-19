package com.stripe.exception;

public abstract class StripeException
  extends Exception
{
  private static final long serialVersionUID = 1L;
  
  public StripeException(String paramString)
  {
    super(paramString, null);
  }
  
  public StripeException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
}

/* Location:
 * Qualified Name:     com.stripe.exception.StripeException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */