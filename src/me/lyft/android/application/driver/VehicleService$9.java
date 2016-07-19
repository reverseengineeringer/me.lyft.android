package me.lyft.android.application.driver;

import com.lyft.android.api.dto.VehiclesDTO;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import me.lyft.android.domain.driver.Vehicle;
import me.lyft.android.domain.driver.VehiclesMapper;
import me.lyft.android.domain.driverdocuments.Registration;
import rx.functions.Func1;

class VehicleService$9
  implements Func1<VehiclesDTO, Vehicle>
{
  VehicleService$9(VehicleService paramVehicleService, String paramString, File paramFile) {}
  
  public Vehicle call(VehiclesDTO paramVehiclesDTO)
  {
    paramVehiclesDTO = VehiclesMapper.fromDriverVehiclesDto(paramVehiclesDTO).iterator();
    while (paramVehiclesDTO.hasNext())
    {
      Vehicle localVehicle = (Vehicle)paramVehiclesDTO.next();
      if (localVehicle.getId().equals(val$vehicleId))
      {
        VehicleService.access$002(this$0, localVehicle);
        VehicleService.access$000(this$0).getRegistration().setPhotoFile(val$registrationPhotoFile);
        return localVehicle;
      }
    }
    return Vehicle.empty();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.driver.VehicleService.9
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */