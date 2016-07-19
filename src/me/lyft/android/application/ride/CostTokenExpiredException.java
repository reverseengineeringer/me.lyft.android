package me.lyft.android.application.ride;

public class CostTokenExpiredException
  extends RideRequestException
{
  public static final String ERROR_CODE = "invalid_primetime_confirmation";
  
  public String getReason()
  {
    return "cost_token_expired";
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ride.CostTokenExpiredException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */