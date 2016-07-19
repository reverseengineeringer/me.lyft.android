package me.lyft.android.domain.passenger.ride;

class DriverVehicle$NullDriverVehicle
  extends DriverVehicle
{
  private static DriverVehicle INSTANCE = new NullDriverVehicle();
  
  private DriverVehicle$NullDriverVehicle()
  {
    super("", "", "", "", "", "");
  }
  
  public static DriverVehicle getInstance()
  {
    return INSTANCE;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.passenger.ride.DriverVehicle.NullDriverVehicle
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */