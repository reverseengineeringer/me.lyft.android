package me.lyft.android.domain.driver;

import com.lyft.android.api.dto.VehicleDTO;
import rx.functions.Func1;

final class VehiclesMapper$1
  implements Func1<VehicleDTO, Vehicle>
{
  public Vehicle call(VehicleDTO paramVehicleDTO)
  {
    return VehicleMapper.fromVehicleDTO(paramVehicleDTO);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.driver.VehiclesMapper.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */