package me.lyft.android.application.ride;

public class PartySizeNotSetException
  extends RideRequestException
{
  public String getMessage()
  {
    return "Party size need to be confirmed to request ride";
  }
  
  public String getReason()
  {
    return "party_size_not_set";
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ride.PartySizeNotSetException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */