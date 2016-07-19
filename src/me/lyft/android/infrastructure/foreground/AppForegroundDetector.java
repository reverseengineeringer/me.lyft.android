package me.lyft.android.infrastructure.foreground;

import java.util.concurrent.atomic.AtomicInteger;
import me.lyft.android.analytics.studies.AppAnalytics;
import me.lyft.android.logging.L;
import rx.Observable;
import rx.subjects.BehaviorSubject;

public class AppForegroundDetector
  implements IAppForegroundDetector
{
  private static boolean isColdStart = true;
  private final BehaviorSubject<Boolean> appForegroundedSubject = BehaviorSubject.create();
  private AtomicInteger startedActivities = new AtomicInteger(0);
  
  public boolean isForegrounded()
  {
    return startedActivities.get() > 0;
  }
  
  public Observable<Boolean> observeAppForegrounded()
  {
    return appForegroundedSubject.asObservable();
  }
  
  public void onStart()
  {
    int i = startedActivities.incrementAndGet();
    L.d("onStart startedActivities = " + i + " isForegrounded = " + isForegrounded(), new Object[0]);
    if (i == 1)
    {
      L.d("App considered foreground.", new Object[0]);
      AppAnalytics.trackAppOpen(isColdStart);
      isColdStart = false;
      appForegroundedSubject.onNext(Boolean.valueOf(true));
    }
  }
  
  public void onStop()
  {
    int i = startedActivities.decrementAndGet();
    L.d("onStop startedActivities = " + i + " isForegrounded = " + isForegrounded(), new Object[0]);
    if (i == 0)
    {
      L.d("App considered NOT foreground.", new Object[0]);
      AppAnalytics.trackAppClose();
      appForegroundedSubject.onNext(Boolean.valueOf(false));
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.foreground.AppForegroundDetector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */