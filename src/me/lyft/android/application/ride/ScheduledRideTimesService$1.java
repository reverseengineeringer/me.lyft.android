package me.lyft.android.application.ride;

import java.util.List;
import me.lyft.android.domain.location.Location;
import me.lyft.android.domain.passenger.ridetypes.RequestRideType;
import me.lyft.android.domain.ride.ScheduledInterval;
import rx.functions.Action1;

class ScheduledRideTimesService$1
  implements Action1<List<ScheduledInterval>>
{
  ScheduledRideTimesService$1(ScheduledRideTimesService paramScheduledRideTimesService, RequestRideType paramRequestRideType, Location paramLocation1, Location paramLocation2) {}
  
  public void call(List<ScheduledInterval> paramList)
  {
    ScheduledRideTimesService.access$000(this$0, val$requestRideType, val$pickup, val$destination, paramList);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ride.ScheduledRideTimesService.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */