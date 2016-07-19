package com.stripe.exception;

public class APIConnectionException
  extends StripeException
{
  private static final long serialVersionUID = 1L;
  
  public APIConnectionException(String paramString)
  {
    super(paramString);
  }
  
  public APIConnectionException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
}

/* Location:
 * Qualified Name:     com.stripe.exception.APIConnectionException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */