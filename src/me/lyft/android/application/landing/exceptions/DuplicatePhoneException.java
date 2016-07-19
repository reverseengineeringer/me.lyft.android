package me.lyft.android.application.landing.exceptions;

public class DuplicatePhoneException
  extends PhoneVerificationException
{
  public DuplicatePhoneException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public String getReason()
  {
    return "duplicate_phone";
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.landing.exceptions.DuplicatePhoneException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */