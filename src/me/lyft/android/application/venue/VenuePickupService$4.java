package me.lyft.android.application.venue;

import me.lyft.android.application.ride.IRideRequestSession;
import me.lyft.android.common.Unit;
import me.lyft.android.domain.venue.Venue;
import rx.functions.Func1;

class VenuePickupService$4
  implements Func1<Unit, Venue>
{
  VenuePickupService$4(VenuePickupService paramVenuePickupService, IRideRequestSession paramIRideRequestSession) {}
  
  public Venue call(Unit paramUnit)
  {
    return this$0.getVenue(val$rideRequestSession.getPickupLocation());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.venue.VenuePickupService.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */