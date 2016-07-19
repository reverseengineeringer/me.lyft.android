package me.lyft.android.application.ride;

public class NoChargeAccountException
  extends RideRequestException
{
  public String getMessage()
  {
    return "Charge account is required to request ride";
  }
  
  public String getReason()
  {
    return "no_charge_account";
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ride.NoChargeAccountException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */