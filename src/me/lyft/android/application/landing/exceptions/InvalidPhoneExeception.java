package me.lyft.android.application.landing.exceptions;

public class InvalidPhoneExeception
  extends PhoneVerificationException
{
  public InvalidPhoneExeception(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public String getReason()
  {
    return "invalid_phone_number";
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.landing.exceptions.InvalidPhoneExeception
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */