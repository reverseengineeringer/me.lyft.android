package me.lyft.android.application.ride;

public class PickupNotConfirmedException
  extends RideRequestException
{
  public String getMessage()
  {
    return "Pickup needs to be confirmed to request ride";
  }
  
  public String getReason()
  {
    return "pickup_not_confirmed";
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ride.PickupNotConfirmedException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */