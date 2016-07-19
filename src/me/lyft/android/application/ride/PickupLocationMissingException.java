package me.lyft.android.application.ride;

public class PickupLocationMissingException
  extends RideRequestException
{
  public String getMessage()
  {
    return "Pickup location is missing";
  }
  
  public String getReason()
  {
    return "no_pickup_location";
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ride.PickupLocationMissingException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */