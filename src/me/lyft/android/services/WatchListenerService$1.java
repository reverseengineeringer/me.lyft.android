package me.lyft.android.services;

import me.lyft.android.common.Unit;
import me.lyft.android.logging.L;
import me.lyft.android.rx.SimpleSubscriber;

class WatchListenerService$1
  extends SimpleSubscriber<Unit>
{
  WatchListenerService$1(WatchListenerService paramWatchListenerService) {}
  
  public void onError(Throwable paramThrowable)
  {
    super.onError(paramThrowable);
    L.w(paramThrowable, "failed to request ride from watch", new Object[0]);
  }
  
  public void onNext(Unit paramUnit)
  {
    super.onNext(paramUnit);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.services.WatchListenerService.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */