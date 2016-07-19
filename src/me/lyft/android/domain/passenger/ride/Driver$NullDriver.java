package me.lyft.android.domain.passenger.ride;

import java.util.Collections;
import me.lyft.android.domain.location.NullLocation;

class Driver$NullDriver
  extends Driver
{
  private static final Driver INSTANCE = new NullDriver();
  
  private Driver$NullDriver()
  {
    super("", "", "", "", DriverVehicle.empty(), NullLocation.getInstance(), Double.valueOf(0.0D), Collections.emptyList(), "", "");
  }
  
  public static Driver getInstance()
  {
    return INSTANCE;
  }
  
  public boolean isNull()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.passenger.ride.Driver.NullDriver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */