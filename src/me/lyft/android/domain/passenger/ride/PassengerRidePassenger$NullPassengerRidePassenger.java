package me.lyft.android.domain.passenger.ride;

public class PassengerRidePassenger$NullPassengerRidePassenger
  extends PassengerRidePassenger
{
  private static final PassengerRidePassenger instance = new NullPassengerRidePassenger();
  
  private PassengerRidePassenger$NullPassengerRidePassenger()
  {
    super("", false, "", "", 0);
  }
  
  public String getFirstName()
  {
    return "";
  }
  
  public String getId()
  {
    return "";
  }
  
  public String getPhotoUrl()
  {
    return "";
  }
  
  public boolean isNull()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.passenger.ride.PassengerRidePassenger.NullPassengerRidePassenger
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */