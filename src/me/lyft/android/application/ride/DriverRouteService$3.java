package me.lyft.android.application.ride;

import me.lyft.android.common.Unit;
import rx.Observable;
import rx.functions.Func1;

class DriverRouteService$3
  implements Func1<Unit, Observable<Unit>>
{
  DriverRouteService$3(DriverRouteService paramDriverRouteService, boolean paramBoolean) {}
  
  public Observable<Unit> call(Unit paramUnit)
  {
    if (val$signOutOnLapse) {
      return DriverRouteService.access$000(this$0).switchToDispatchable(false);
    }
    return Unit.just();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ride.DriverRouteService.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */