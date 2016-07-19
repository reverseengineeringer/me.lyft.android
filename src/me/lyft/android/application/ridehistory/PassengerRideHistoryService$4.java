package me.lyft.android.application.ridehistory;

import com.lyft.android.api.dto.RideHistoryDTO;
import me.lyft.android.common.Iterables;
import me.lyft.android.domain.ridehistory.IPassengerRideHistoryMapper;
import me.lyft.android.domain.ridehistory.PassengerRideHistory;
import me.lyft.android.domain.ridehistory.PassengerRideHistoryItem;
import rx.functions.Func1;

class PassengerRideHistoryService$4
  implements Func1<RideHistoryDTO, PassengerRideHistoryItem>
{
  PassengerRideHistoryService$4(PassengerRideHistoryService paramPassengerRideHistoryService) {}
  
  public PassengerRideHistoryItem call(RideHistoryDTO paramRideHistoryDTO)
  {
    return (PassengerRideHistoryItem)Iterables.firstOrDefault(PassengerRideHistoryService.access$100(this$0).fromDTO(paramRideHistoryDTO).getRideHistory(), PassengerRideHistoryItem.empty());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ridehistory.PassengerRideHistoryService.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */