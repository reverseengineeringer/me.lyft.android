package me.lyft.android.infrastructure.location;

import me.lyft.android.domain.location.Location;
import me.lyft.android.locationproviders.fused.LocationConnection;
import rx.Observable.OnSubscribe;
import rx.Subscriber;
import rx.functions.Action0;
import rx.subscriptions.Subscriptions;

class RxLocationService$2
  implements Observable.OnSubscribe<Location>
{
  RxLocationService$2(RxLocationService paramRxLocationService) {}
  
  public void call(Subscriber<? super Location> paramSubscriber)
  {
    final LocationConnection localLocationConnection = RxLocationService.access$200(this$0, paramSubscriber);
    localLocationConnection.connect();
    paramSubscriber.add(Subscriptions.create(new Action0()
    {
      public void call()
      {
        localLocationConnection.disconnect();
      }
    }));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.location.RxLocationService.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */