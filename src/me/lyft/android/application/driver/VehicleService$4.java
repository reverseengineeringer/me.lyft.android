package me.lyft.android.application.driver;

import com.lyft.android.api.dto.VehiclesDTO;
import java.util.Iterator;
import java.util.List;
import me.lyft.android.domain.driver.Vehicle;
import me.lyft.android.domain.driver.VehiclesMapper;
import rx.functions.Func1;

class VehicleService$4
  implements Func1<VehiclesDTO, Vehicle>
{
  VehicleService$4(VehicleService paramVehicleService, String paramString) {}
  
  public Vehicle call(VehiclesDTO paramVehiclesDTO)
  {
    paramVehiclesDTO = VehiclesMapper.fromDriverVehiclesDto(paramVehiclesDTO).iterator();
    while (paramVehiclesDTO.hasNext())
    {
      Vehicle localVehicle = (Vehicle)paramVehiclesDTO.next();
      if (val$vehicleId.equals(localVehicle.getId())) {
        return localVehicle;
      }
    }
    return Vehicle.empty();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.driver.VehicleService.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */