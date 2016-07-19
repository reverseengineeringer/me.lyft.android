package me.lyft.android.application.venue;

import java.util.Set;
import me.lyft.android.domain.venue.Venue;
import rx.functions.Func1;

class VenuePickupService$3
  implements Func1<Venue, Boolean>
{
  VenuePickupService$3(VenuePickupService paramVenuePickupService) {}
  
  public Boolean call(Venue paramVenue)
  {
    if ((!paramVenue.isNull()) && (!VenuePickupService.access$100(this$0).contains(paramVenue))) {}
    for (boolean bool = true;; bool = false) {
      return Boolean.valueOf(bool);
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.venue.VenuePickupService.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */