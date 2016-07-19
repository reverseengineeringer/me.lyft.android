package me.lyft.android.application.ridehistory;

import me.lyft.android.domain.ridehistory.PassengerRideHistory;
import me.lyft.android.domain.ridehistory.PassengerRideHistoryDetails;
import me.lyft.android.domain.ridehistory.PassengerRideHistoryItem;
import rx.Observable;

public abstract interface IPassengerRideHistoryService
{
  public abstract void clearCachedRideHistory();
  
  public abstract PassengerRideHistory getCachedRideHistory();
  
  public abstract Observable<PassengerRideHistory> getPassengerHistory(int paramInt);
  
  public abstract Observable<PassengerRideHistory> getPassengerHistory(int paramInt, PassengerRideHistoryType paramPassengerRideHistoryType);
  
  public abstract Observable<PassengerRideHistoryDetails> getPassengerHistoryDetails(String paramString);
  
  public abstract Observable<PassengerRideHistoryItem> getRecentRideHistoryItem();
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ridehistory.IPassengerRideHistoryService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */