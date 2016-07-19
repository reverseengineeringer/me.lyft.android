package me.lyft.android.application.landing.exceptions;

public class DriverLicenseAuthRequiredException
  extends AdditionalAuthRequiredException
{
  public DriverLicenseAuthRequiredException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public String getReason()
  {
    return "driver_license_auth_required";
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.landing.exceptions.DriverLicenseAuthRequiredException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */