package me.lyft.android.application.ride;

import me.lyft.android.domain.driver.Vehicle;

public class InsuranceExpiringException
  extends UserDispatchException
{
  private final Vehicle vehicle;
  
  public InsuranceExpiringException(Vehicle paramVehicle)
  {
    vehicle = paramVehicle;
  }
  
  public String getMessage()
  {
    return "Insurance has expired or will expire soon";
  }
  
  public String getReason()
  {
    return "insurance_expired_or_expiring";
  }
  
  public Vehicle getVehicle()
  {
    return vehicle;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ride.InsuranceExpiringException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */