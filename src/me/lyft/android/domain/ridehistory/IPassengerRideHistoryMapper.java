package me.lyft.android.domain.ridehistory;

import com.lyft.android.api.dto.RideHistoryDTO;
import com.lyft.android.api.dto.RideHistoryItemDetailedDTO;

public abstract interface IPassengerRideHistoryMapper
{
  public abstract PassengerRideHistory fromDTO(RideHistoryDTO paramRideHistoryDTO);
  
  public abstract PassengerRideHistoryDetails fromDTO(RideHistoryItemDetailedDTO paramRideHistoryItemDetailedDTO);
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.ridehistory.IPassengerRideHistoryMapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */