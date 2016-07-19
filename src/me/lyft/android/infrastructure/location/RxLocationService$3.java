package me.lyft.android.infrastructure.location;

import java.util.concurrent.TimeUnit;
import me.lyft.android.application.polling.LocationAnalytics;
import me.lyft.android.domain.location.Location;
import me.lyft.android.locationproviders.core.LocationClientConfiguration;
import me.lyft.android.locationproviders.fused.LocationConnection;
import rx.Observable.OnSubscribe;
import rx.Scheduler;
import rx.Scheduler.Worker;
import rx.Subscriber;
import rx.functions.Action0;
import rx.schedulers.Schedulers;
import rx.subscriptions.Subscriptions;

class RxLocationService$3
  implements Observable.OnSubscribe<Location>
{
  RxLocationService$3(RxLocationService paramRxLocationService, LocationClientConfiguration paramLocationClientConfiguration) {}
  
  public void call(Subscriber<? super Location> paramSubscriber)
  {
    final LocationConnection localLocationConnection1 = RxLocationService.access$300(this$0, paramSubscriber, val$locationClientConfiguration);
    localLocationConnection1.connect();
    final LocationConnection localLocationConnection2 = RxLocationService.access$400(this$0, paramSubscriber, val$locationClientConfiguration);
    final Scheduler.Worker localWorker = Schedulers.newThread().createWorker();
    localWorker.schedulePeriodically(new Action0()
    {
      public void call()
      {
        RxLocationService.access$500(this$0).trackFusedLocationInitialization();
        localLocationConnection2.connect();
      }
    }, 0L, 5L, TimeUnit.SECONDS);
    paramSubscriber.add(Subscriptions.create(new Action0()
    {
      public void call()
      {
        localWorker.unsubscribe();
        localLocationConnection1.disconnect();
        localLocationConnection2.disconnect();
      }
    }));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.location.RxLocationService.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */