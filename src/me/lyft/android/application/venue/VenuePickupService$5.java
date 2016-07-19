package me.lyft.android.application.venue;

import java.util.Collections;
import java.util.List;
import me.lyft.android.domain.venue.Venue;
import rx.Observable;
import rx.functions.Func1;

class VenuePickupService$5
  implements Func1<Throwable, Observable<? extends List<Venue>>>
{
  VenuePickupService$5(VenuePickupService paramVenuePickupService) {}
  
  public Observable<? extends List<Venue>> call(Throwable paramThrowable)
  {
    return Observable.just(Collections.emptyList());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.venue.VenuePickupService.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */