package me.lyft.android.application.polling;

import me.lyft.android.common.Unit;
import me.lyft.android.domain.location.Location;
import me.lyft.android.rx.RetryWithDelay;
import me.lyft.android.rx.SimpleSubscriber;
import rx.Observable;

class BackgroundLocationTracker$1
  extends SimpleSubscriber<Location>
{
  BackgroundLocationTracker$1(BackgroundLocationTracker paramBackgroundLocationTracker) {}
  
  public void onError(Throwable paramThrowable) {}
  
  public void onNext(Location paramLocation)
  {
    this$0.locationUpdateService.updateCoarseLocation(paramLocation).retryWhen(new RetryWithDelay(5, 30000)).subscribe(new SimpleSubscriber()
    {
      public void onError(Throwable paramAnonymousThrowable) {}
    });
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.polling.BackgroundLocationTracker.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */