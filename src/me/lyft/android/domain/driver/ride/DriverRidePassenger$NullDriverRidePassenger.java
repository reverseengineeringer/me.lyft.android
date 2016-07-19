package me.lyft.android.domain.driver.ride;

import me.lyft.android.domain.location.NullLocation;

public class DriverRidePassenger$NullDriverRidePassenger
  extends DriverRidePassenger
{
  private static final DriverRidePassenger instance = new NullDriverRidePassenger();
  
  private DriverRidePassenger$NullDriverRidePassenger()
  {
    super("", false, "", "", "", 0, false, false, false, NullLocation.getInstance());
  }
  
  public String getFirstName()
  {
    return "";
  }
  
  public String getId()
  {
    return "";
  }
  
  public String getPhoneNumber()
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
 * Qualified Name:     me.lyft.android.domain.driver.ride.DriverRidePassenger.NullDriverRidePassenger
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */