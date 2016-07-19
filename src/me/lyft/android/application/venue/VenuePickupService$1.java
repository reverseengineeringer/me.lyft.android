package me.lyft.android.application.venue;

import java.util.List;
import me.lyft.android.domain.location.LatLng;
import me.lyft.android.domain.venue.Venue;
import rx.Observable;
import rx.functions.Func1;

class VenuePickupService$1
  implements Func1<LatLng, Observable<List<Venue>>>
{
  VenuePickupService$1(VenuePickupService paramVenuePickupService) {}
  
  public Observable<List<Venue>> call(LatLng paramLatLng)
  {
    return VenuePickupService.access$000(this$0, paramLatLng);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.venue.VenuePickupService.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */