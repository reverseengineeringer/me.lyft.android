package me.lyft.android.application.ride;

public class DriverNotApprovedException
  extends UserDispatchException
{
  public String getMessage()
  {
    return "Driver status is not approved";
  }
  
  public String getReason()
  {
    return "driver_not_approved";
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ride.DriverNotApprovedException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */