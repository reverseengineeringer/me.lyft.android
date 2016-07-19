package me.lyft.android.application.driver;

import com.lyft.android.api.dto.VehiclesDTO;
import java.util.List;
import me.lyft.android.domain.driver.Vehicle;
import me.lyft.android.domain.driver.VehiclesMapper;
import rx.functions.Func1;

class VehicleService$3
  implements Func1<VehiclesDTO, List<Vehicle>>
{
  VehicleService$3(VehicleService paramVehicleService) {}
  
  public List<Vehicle> call(VehiclesDTO paramVehiclesDTO)
  {
    VehicleService.access$002(this$0, Vehicle.empty());
    return VehiclesMapper.fromDriverVehiclesDto(paramVehiclesDTO);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.driver.VehicleService.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */