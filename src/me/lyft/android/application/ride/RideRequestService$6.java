package me.lyft.android.application.ride;

import me.lyft.android.common.Unit;
import rx.Observable;
import rx.functions.Func1;

class RideRequestService$6
  implements Func1<Unit, Observable<Unit>>
{
  RideRequestService$6(RideRequestService paramRideRequestService, Observable paramObservable) {}
  
  public Observable<Unit> call(Unit paramUnit)
  {
    return val$requestRideObservable;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ride.RideRequestService.6
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */