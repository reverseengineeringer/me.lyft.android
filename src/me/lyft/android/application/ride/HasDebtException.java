package me.lyft.android.application.ride;

public class HasDebtException
  extends RideRequestException
{
  public String getMessage()
  {
    return "Cannot request ride because user has debt";
  }
  
  public String getReason()
  {
    return "has_debt";
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ride.HasDebtException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */