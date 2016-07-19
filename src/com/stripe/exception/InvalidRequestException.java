package com.stripe.exception;

public class InvalidRequestException
  extends StripeException
{
  private static final long serialVersionUID = 1L;
  private final String param;
  
  public InvalidRequestException(String paramString1, String paramString2, Throwable paramThrowable)
  {
    super(paramString1, paramThrowable);
    param = paramString2;
  }
  
  public String getParam()
  {
    return param;
  }
}

/* Location:
 * Qualified Name:     com.stripe.exception.InvalidRequestException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */