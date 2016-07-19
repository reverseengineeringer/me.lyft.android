package me.lyft.android.application.ridehistory;

import com.lyft.android.api.dto.RideHistoryItemDetailedDTO;
import me.lyft.android.domain.ridehistory.IPassengerRideHistoryMapper;
import me.lyft.android.domain.ridehistory.PassengerRideHistoryDetails;
import rx.functions.Func1;

class PassengerRideHistoryService$3
  implements Func1<RideHistoryItemDetailedDTO, PassengerRideHistoryDetails>
{
  PassengerRideHistoryService$3(PassengerRideHistoryService paramPassengerRideHistoryService) {}
  
  public PassengerRideHistoryDetails call(RideHistoryItemDetailedDTO paramRideHistoryItemDetailedDTO)
  {
    return PassengerRideHistoryService.access$100(this$0).fromDTO(paramRideHistoryItemDetailedDTO);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ridehistory.PassengerRideHistoryService.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */