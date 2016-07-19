package com.stripe.exception;

public class AuthenticationException
  extends StripeException
{
  private static final long serialVersionUID = 1L;
  
  public AuthenticationException(String paramString)
  {
    super(paramString);
  }
}

/* Location:
 * Qualified Name:     com.stripe.exception.AuthenticationException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */