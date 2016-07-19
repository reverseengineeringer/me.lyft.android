package me.lyft.android.application.ride;

public class PrimeTimeNotConfirmedException
  extends RideRequestException
{
  public String getMessage()
  {
    return "Prime time confirmation is required to request ride";
  }
  
  public String getReason()
  {
    return "dynamic_pricing_not_confirmed";
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ride.PrimeTimeNotConfirmedException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */