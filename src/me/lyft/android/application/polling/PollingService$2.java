package me.lyft.android.application.polling;

import me.lyft.android.domain.location.Location;
import me.lyft.android.rx.SimpleSubscriber;
import rx.Subscription;

class PollingService$2
  extends SimpleSubscriber<Location>
{
  PollingService$2(PollingService paramPollingService) {}
  
  public void onError(Throwable paramThrowable)
  {
    super.onError(paramThrowable);
    PollingService.access$400(this$0).unsubscribe();
  }
  
  public void onNext(Location paramLocation)
  {
    PollingService.access$100(this$0).addLocationToHistory(paramLocation);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.polling.PollingService.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */