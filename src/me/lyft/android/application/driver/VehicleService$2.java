package me.lyft.android.application.driver;

import java.util.Iterator;
import java.util.List;
import me.lyft.android.common.Iterables;
import me.lyft.android.domain.driver.Vehicle;
import rx.functions.Func1;

class VehicleService$2
  implements Func1<List<Vehicle>, Vehicle>
{
  VehicleService$2(VehicleService paramVehicleService) {}
  
  public Vehicle call(List<Vehicle> paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      Vehicle localVehicle = (Vehicle)localIterator.next();
      if (localVehicle.getId().equals(localVehicle.getId())) {
        return localVehicle;
      }
    }
    return (Vehicle)Iterables.firstOrDefault(paramList, Vehicle.empty());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.driver.VehicleService.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */