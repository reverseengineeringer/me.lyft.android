package com.stripe.exception;

public class APIException
  extends StripeException
{
  private static final long serialVersionUID = 1L;
  
  public APIException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
}

/* Location:
 * Qualified Name:     com.stripe.exception.APIException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */