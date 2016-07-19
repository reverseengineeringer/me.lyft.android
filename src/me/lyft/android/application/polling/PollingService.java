package me.lyft.android.application.polling;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.domain.location.Location;
import me.lyft.android.infrastructure.location.ILocationService;
import me.lyft.android.rx.SimpleSubscriber;
import rx.Observable;
import rx.Observer;
import rx.Scheduler;
import rx.Scheduler.Worker;
import rx.Subscription;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import rx.subscriptions.Subscriptions;

public class PollingService
  implements IPollingService
{
  private Action1<Throwable> errorHandler;
  private final ILocationService locationService;
  private final ILocationUpdateService locationUpdateService;
  private Subscription locationUpdatesSubscription = Subscriptions.unsubscribed();
  private final ILyftPreferences lyftPreferences;
  private Subscription pollingSubscription = Subscriptions.empty();
  private AtomicBoolean resumed = new AtomicBoolean(false);
  
  public PollingService(ILocationUpdateService paramILocationUpdateService, ILocationService paramILocationService, ILyftPreferences paramILyftPreferences)
  {
    locationUpdateService = paramILocationUpdateService;
    locationService = paramILocationService;
    lyftPreferences = paramILyftPreferences;
  }
  
  private Observer<Location> createLocationUpdatesSubscriber()
  {
    new SimpleSubscriber()
    {
      public void onError(Throwable paramAnonymousThrowable)
      {
        super.onError(paramAnonymousThrowable);
        locationUpdatesSubscription.unsubscribe();
      }
      
      public void onNext(Location paramAnonymousLocation)
      {
        locationUpdateService.addLocationToHistory(paramAnonymousLocation);
      }
    };
  }
  
  private boolean isResumed()
  {
    return resumed.get();
  }
  
  private void schedulePolling()
  {
    pollingSubscription.unsubscribe();
    final Scheduler.Worker localWorker = Schedulers.io().createWorker();
    pollingSubscription = localWorker;
    localWorker.schedule(new Action0()
    {
      public void call()
      {
        try
        {
          if (!localWorker.isUnsubscribed())
          {
            PollingService.this.startLocationUpdatesIfNeeded();
            locationUpdateService.updateLocationSync();
          }
          if (localWorker.isUnsubscribed()) {
            return;
          }
        }
        catch (Throwable localThrowable)
        {
          boolean bool = localThrowable instanceof InterruptedIOException;
          if (!bool) {
            break label110;
          }
          return;
          label110:
          errorHandler.call(localThrowable);
          return;
        }
        finally
        {
          while (localWorker.isUnsubscribed()) {}
          localWorker.schedule(this, lyftPreferences.getPollingRate(), TimeUnit.MILLISECONDS);
        }
        localWorker.schedule(this, lyftPreferences.getPollingRate(), TimeUnit.MILLISECONDS);
      }
    });
  }
  
  private void startLocationUpdatesIfNeeded()
  {
    if (locationUpdatesSubscription.isUnsubscribed()) {
      locationUpdatesSubscription = locationService.observeLocationUpdates().subscribe(createLocationUpdatesSubscriber());
    }
  }
  
  private void startPolling()
  {
    if (isResumed()) {
      schedulePolling();
    }
  }
  
  private void stopLocationUpdates()
  {
    locationUpdatesSubscription.unsubscribe();
  }
  
  public void setErrorHandler(Action1<Throwable> paramAction1)
  {
    errorHandler = paramAction1;
  }
  
  public void start()
  {
    if (!resumed.getAndSet(true)) {
      startPolling();
    }
  }
  
  public void stop()
  {
    if (resumed.getAndSet(false))
    {
      pollingSubscription.unsubscribe();
      stopLocationUpdates();
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.polling.PollingService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */