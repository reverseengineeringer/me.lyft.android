package me.lyft.android.application.ride;

import com.lyft.android.api.dto.RideRequestDetailsDTO;
import me.lyft.android.application.passenger.IPassengerRideProvider;
import me.lyft.android.domain.passenger.ride.PassengerRideMapper;
import rx.functions.Action1;

class RideRequestService$7
  implements Action1<RideRequestDetailsDTO>
{
  RideRequestService$7(RideRequestService paramRideRequestService) {}
  
  public void call(RideRequestDetailsDTO paramRideRequestDetailsDTO)
  {
    paramRideRequestDetailsDTO = PassengerRideMapper.fromRideRequestDetailsDTO(paramRideRequestDetailsDTO);
    RideRequestService.access$300(this$0).updatePassengerRide(paramRideRequestDetailsDTO);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ride.RideRequestService.7
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */