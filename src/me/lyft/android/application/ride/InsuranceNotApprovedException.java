package me.lyft.android.application.ride;

import me.lyft.android.domain.driver.Vehicle;

public class InsuranceNotApprovedException
  extends UserDispatchException
{
  private final Vehicle vehicle;
  
  public InsuranceNotApprovedException(Vehicle paramVehicle)
  {
    vehicle = paramVehicle;
  }
  
  public String getMessage()
  {
    return "Insurance needs approval";
  }
  
  public String getReason()
  {
    return "insurance_not_approved";
  }
  
  public Vehicle getVehicle()
  {
    return vehicle;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ride.InsuranceNotApprovedException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */