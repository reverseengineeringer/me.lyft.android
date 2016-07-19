package me.lyft.android.application.ride;

import com.lyft.android.api.dto.ScheduledRideDTO;
import me.lyft.android.common.Unit;
import rx.Observable;
import rx.functions.Func1;

class RideRequestService$4
  implements Func1<Unit, Observable<ScheduledRideDTO>>
{
  RideRequestService$4(RideRequestService paramRideRequestService, Observable paramObservable) {}
  
  public Observable<ScheduledRideDTO> call(Unit paramUnit)
  {
    return val$scheduleRideObservable;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ride.RideRequestService.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */