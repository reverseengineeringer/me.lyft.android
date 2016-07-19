package me.lyft.android.application.ride;

public class NoValidPhoneException
  extends RideRequestException
{
  public String getMessage()
  {
    return "Valid phone is required to request ride";
  }
  
  public String getReason()
  {
    return "no_valid_phone";
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ride.NoValidPhoneException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */