package me.lyft.android.application.ride;

public class DriverTermsNotAcceptedException
  extends UserDispatchException
{
  public String getMessage()
  {
    return "Terms of Service must be accepted to switch to driver mode";
  }
  
  public String getReason()
  {
    return "terms_not_accepted";
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ride.DriverTermsNotAcceptedException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */