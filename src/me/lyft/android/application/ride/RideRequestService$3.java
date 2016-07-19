package me.lyft.android.application.ride;

import com.lyft.android.api.dto.ScheduledRideDTO;
import me.lyft.android.application.requestridetypes.IRequestRideTypeService;
import me.lyft.android.domain.ride.ScheduledRide;
import me.lyft.android.domain.ride.ScheduledRideMapper;
import rx.functions.Func1;

class RideRequestService$3
  implements Func1<ScheduledRideDTO, ScheduledRide>
{
  RideRequestService$3(RideRequestService paramRideRequestService) {}
  
  public ScheduledRide call(ScheduledRideDTO paramScheduledRideDTO)
  {
    return ScheduledRideMapper.fromScheduledRideDTO(paramScheduledRideDTO, RideRequestService.access$200(this$0).getRideTypes());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ride.RideRequestService.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */