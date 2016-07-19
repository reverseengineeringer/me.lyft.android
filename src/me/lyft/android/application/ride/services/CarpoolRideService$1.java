package me.lyft.android.application.ride.services;

import me.lyft.android.analytics.core.ActionAnalytics;
import me.lyft.android.common.Unit;
import rx.Observable;
import rx.functions.Func1;

class CarpoolRideService$1
  implements Func1<Throwable, Observable<? extends Unit>>
{
  CarpoolRideService$1(CarpoolRideService paramCarpoolRideService, ActionAnalytics paramActionAnalytics) {}
  
  public Observable<? extends Unit> call(Throwable paramThrowable)
  {
    val$analytics.trackFailure(paramThrowable);
    return Observable.error(CarpoolRideService.access$000(paramThrowable));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ride.services.CarpoolRideService.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */