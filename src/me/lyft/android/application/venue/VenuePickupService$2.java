package me.lyft.android.application.venue;

import java.util.Set;
import me.lyft.android.domain.venue.Venue;
import rx.functions.Action1;

class VenuePickupService$2
  implements Action1<Venue>
{
  VenuePickupService$2(VenuePickupService paramVenuePickupService) {}
  
  public void call(Venue paramVenue)
  {
    VenuePickupService.access$100(this$0).add(paramVenue);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.venue.VenuePickupService.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */