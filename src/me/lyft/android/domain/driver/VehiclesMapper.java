package me.lyft.android.domain.driver;

import com.lyft.android.api.dto.VehicleDTO;
import com.lyft.android.api.dto.VehiclesDTO;
import java.util.Collections;
import java.util.List;
import me.lyft.android.common.Iterables;
import me.lyft.android.common.Objects;
import rx.functions.Func1;

public class VehiclesMapper
{
  public static List<Vehicle> fromDriverVehiclesDto(VehiclesDTO paramVehiclesDTO)
  {
    Iterables.map((List)Objects.firstNonNull(vehicles, Collections.emptyList()), new Func1()
    {
      public Vehicle call(VehicleDTO paramAnonymousVehicleDTO)
      {
        return VehicleMapper.fromVehicleDTO(paramAnonymousVehicleDTO);
      }
    });
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.driver.VehiclesMapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */