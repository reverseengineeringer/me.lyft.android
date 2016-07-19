package me.lyft.android.infrastructure.location;

import me.lyft.android.domain.location.Location;
import rx.functions.Action1;
import rx.subjects.BehaviorSubject;

class RxLocationService$1
  implements Action1<Location>
{
  RxLocationService$1(RxLocationService paramRxLocationService) {}
  
  public void call(Location paramLocation)
  {
    RxLocationService.access$002(this$0, paramLocation);
    RxLocationService.access$100(this$0).onNext(paramLocation);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.location.RxLocationService.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */