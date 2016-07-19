package me.lyft.android.application.landing.exceptions;

public class SuspendedPhoneException
  extends LandingServiceException
{
  public SuspendedPhoneException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public String getReason()
  {
    return "account_suspended";
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.landing.exceptions.SuspendedPhoneException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */