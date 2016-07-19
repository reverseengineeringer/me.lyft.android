package me.lyft.android.application.ride;

public class NoValidChargeAccountException
  extends RideRequestException
{
  public String getMessage()
  {
    return "Valid charge account is required to request ride";
  }
  
  public String getReason()
  {
    return "no_valid_charge_account";
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ride.NoValidChargeAccountException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */