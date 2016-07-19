package me.lyft.android.domain.driver;

import me.lyft.android.domain.driverdocuments.Inspection.NullInspection;
import me.lyft.android.domain.driverdocuments.Insurance.NullInsurance;
import me.lyft.android.domain.driverdocuments.Registration.NullRegistration;

class Vehicle$NullVehicle
  extends Vehicle
{
  private static Vehicle INSTANCE = new NullVehicle();
  
  private Vehicle$NullVehicle()
  {
    super("", "", "", "", "", Integer.valueOf(0), "", "", "", Vehicle.Status.NONE, "", Insurance.NullInsurance.getInstance(), Inspection.NullInspection.getInstance(), Registration.NullRegistration.getInstance(), "");
  }
  
  public static Vehicle getInstance()
  {
    return INSTANCE;
  }
  
  public boolean isNull()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.driver.Vehicle.NullVehicle
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */