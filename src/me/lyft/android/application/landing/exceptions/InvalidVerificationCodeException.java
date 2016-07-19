package me.lyft.android.application.landing.exceptions;

public class InvalidVerificationCodeException
  extends PhoneVerificationException
{
  public InvalidVerificationCodeException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public String getReason()
  {
    return "invalid_verification_code";
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.landing.exceptions.InvalidVerificationCodeException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */