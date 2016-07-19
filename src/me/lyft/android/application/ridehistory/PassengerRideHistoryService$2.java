package me.lyft.android.application.ridehistory;

import com.lyft.android.api.dto.RideHistoryDTO;
import me.lyft.android.domain.ridehistory.IPassengerRideHistoryMapper;
import me.lyft.android.domain.ridehistory.PassengerRideHistory;
import rx.functions.Func1;

class PassengerRideHistoryService$2
  implements Func1<RideHistoryDTO, PassengerRideHistory>
{
  PassengerRideHistoryService$2(PassengerRideHistoryService paramPassengerRideHistoryService) {}
  
  public PassengerRideHistory call(RideHistoryDTO paramRideHistoryDTO)
  {
    return PassengerRideHistoryService.access$100(this$0).fromDTO(paramRideHistoryDTO);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ridehistory.PassengerRideHistoryService.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */