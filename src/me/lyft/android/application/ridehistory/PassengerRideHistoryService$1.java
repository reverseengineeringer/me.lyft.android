package me.lyft.android.application.ridehistory;

import java.util.List;
import me.lyft.android.domain.ridehistory.PassengerRideHistory;
import rx.functions.Action1;

class PassengerRideHistoryService$1
  implements Action1<PassengerRideHistory>
{
  PassengerRideHistoryService$1(PassengerRideHistoryService paramPassengerRideHistoryService) {}
  
  public void call(PassengerRideHistory paramPassengerRideHistory)
  {
    PassengerRideHistoryService.access$000(this$0).getRideHistory().addAll(paramPassengerRideHistory.getRideHistory());
    PassengerRideHistoryService.access$000(this$0).setHasMore(paramPassengerRideHistory.hasMore());
    PassengerRideHistoryService.access$000(this$0).setLimit(paramPassengerRideHistory.getLimit());
    PassengerRideHistoryService.access$000(this$0).setOffset(paramPassengerRideHistory.getOffset());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ridehistory.PassengerRideHistoryService.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */