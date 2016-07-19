package me.lyft.android.application.landing.exceptions;

public class CreditCardAuthRequiredException
  extends AdditionalAuthRequiredException
{
  public CreditCardAuthRequiredException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public String getReason()
  {
    return "credit_card_auth_required";
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.landing.exceptions.CreditCardAuthRequiredException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */