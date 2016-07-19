package me.lyft.android.application.ride.services;

import com.lyft.android.api.dto.CarpoolRidesResponseDTO;
import java.util.List;
import me.lyft.android.domain.driver.ride.DriverRide;
import rx.functions.Func1;

class CarpoolRideService$4
  implements Func1<CarpoolRidesResponseDTO, List<DriverRide>>
{
  CarpoolRideService$4(CarpoolRideService paramCarpoolRideService, String paramString) {}
  
  public List<DriverRide> call(CarpoolRidesResponseDTO paramCarpoolRidesResponseDTO)
  {
    return CarpoolRideService.access$200(this$0, paramCarpoolRidesResponseDTO, val$userId);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ride.services.CarpoolRideService.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */