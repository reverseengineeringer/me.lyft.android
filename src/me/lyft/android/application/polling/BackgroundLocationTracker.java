package me.lyft.android.application.polling;

import java.util.concurrent.atomic.AtomicBoolean;
import me.lyft.android.common.Unit;
import me.lyft.android.domain.location.Location;
import me.lyft.android.infrastructure.location.ILocationService;
import me.lyft.android.rx.RetryWithDelay;
import me.lyft.android.rx.SimpleSubscriber;
import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.subscriptions.Subscriptions;

public class BackgroundLocationTracker
  implements IBackgroundLocationTracker
{
  public static final int RETRY_COUNT = 5;
  public static final int RETRY_DELAY_MILLIS = 30000;
  ILocationService locationService;
  ILocationUpdateService locationUpdateService;
  private Subscription locationUpdatesSubscription = Subscriptions.unsubscribed();
  private AtomicBoolean resumed = new AtomicBoolean(false);
  
  public BackgroundLocationTracker(ILocationUpdateService paramILocationUpdateService, ILocationService paramILocationService)
  {
    locationUpdateService = paramILocationUpdateService;
    locationService = paramILocationService;
  }
  
  private Observer<Location> createLocationUpdatesSubscriber()
  {
    new SimpleSubscriber()
    {
      public void onError(Throwable paramAnonymousThrowable) {}
      
      public void onNext(Location paramAnonymousLocation)
      {
        locationUpdateService.updateCoarseLocation(paramAnonymousLocation).retryWhen(new RetryWithDelay(5, 30000)).subscribe(new SimpleSubscriber()
        {
          public void onError(Throwable paramAnonymous2Throwable) {}
        });
      }
    };
  }
  
  private void startLocationUpdates()
  {
    if (locationUpdatesSubscription.isUnsubscribed()) {
      locationUpdatesSubscription = locationService.observeBackgroundLocationUpdates().subscribe(createLocationUpdatesSubscriber());
    }
  }
  
  private void stopLocationUpdates()
  {
    locationUpdatesSubscription.unsubscribe();
  }
  
  public void start()
  {
    if (!resumed.getAndSet(true)) {
      startLocationUpdates();
    }
  }
  
  public void stop()
  {
    if (resumed.getAndSet(false)) {
      stopLocationUpdates();
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.polling.BackgroundLocationTracker
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */