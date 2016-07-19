package me.lyft.android.domain.ridehistory;

import java.util.UUID;

class PassengerRideHistoryItem$NullPassengerRideHistoryItem
  extends PassengerRideHistoryItem
{
  private static final PassengerRideHistoryItem INSTANCE = new NullPassengerRideHistoryItem();
  
  private PassengerRideHistoryItem$NullPassengerRideHistoryItem()
  {
    super(UUID.randomUUID().toString(), "", "", "", "", "", "", false);
  }
  
  public boolean isNull()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.ridehistory.PassengerRideHistoryItem.NullPassengerRideHistoryItem
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */