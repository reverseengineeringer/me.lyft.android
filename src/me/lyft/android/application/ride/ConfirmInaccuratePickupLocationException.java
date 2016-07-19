package me.lyft.android.application.ride;

public class ConfirmInaccuratePickupLocationException
  extends RideRequestException
{
  public String getReason()
  {
    return "Defaulted pickup location needs to be confirmed by user.";
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ride.ConfirmInaccuratePickupLocationException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */