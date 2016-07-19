package me.lyft.android.application.landing.exceptions;

public class AdditionalAuthRequiredException
  extends LandingServiceException
{
  public AdditionalAuthRequiredException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public String getReason()
  {
    return "additional_auth_required_exception";
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.landing.exceptions.AdditionalAuthRequiredException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */