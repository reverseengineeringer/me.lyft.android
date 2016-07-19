package me.lyft.android.application.polling;

import me.lyft.android.common.Unit;
import rx.Observable.OnSubscribe;
import rx.Subscriber;

class LocationUpdateService$1
  implements Observable.OnSubscribe<Unit>
{
  LocationUpdateService$1(LocationUpdateService paramLocationUpdateService) {}
  
  public void call(Subscriber<? super Unit> paramSubscriber)
  {
    try
    {
      this$0.updateLocationSync();
      paramSubscriber.onNext(Unit.create());
      paramSubscriber.onCompleted();
      return;
    }
    catch (Throwable localThrowable)
    {
      paramSubscriber.onError(localThrowable);
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.polling.LocationUpdateService.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */