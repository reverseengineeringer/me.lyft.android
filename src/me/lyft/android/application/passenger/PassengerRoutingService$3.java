package me.lyft.android.application.passenger;

import java.util.List;
import me.lyft.android.domain.geo.Leg;
import me.lyft.android.domain.passenger.ride.PassengerStops;
import me.lyft.android.domain.passenger.routing.PassengerRoutePath;
import rx.functions.Func1;

class PassengerRoutingService$3
  implements Func1<List<Leg>, PassengerRoutePath>
{
  PassengerRoutingService$3(PassengerRoutingService paramPassengerRoutingService, PassengerStops paramPassengerStops, boolean paramBoolean, String paramString) {}
  
  public PassengerRoutePath call(List<Leg> paramList)
  {
    return new PassengerRoutePath(PassengerRoutingService.access$100(this$0, paramList, val$stops.toList(), val$startFromDriverLocation), val$rideId);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.passenger.PassengerRoutingService.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */