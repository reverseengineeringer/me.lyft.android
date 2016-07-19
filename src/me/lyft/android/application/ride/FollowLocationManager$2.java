package me.lyft.android.application.ride;

import me.lyft.android.common.Objects;
import me.lyft.android.domain.location.Location;
import me.lyft.android.domain.passenger.ride.PassengerRideRequest.RequestRideStep;
import rx.functions.Func1;

class FollowLocationManager$2
  implements Func1<Location, Boolean>
{
  FollowLocationManager$2(FollowLocationManager paramFollowLocationManager) {}
  
  public Boolean call(Location paramLocation)
  {
    paramLocation = FollowLocationManager.access$000(this$0).getPickupLocation();
    if ((FollowLocationManager.access$000(this$0).getRequestRideStep() == PassengerRideRequest.RequestRideStep.SET_PICKUP) && ((paramLocation.isNull()) || (Objects.equals(paramLocation.getSource(), "defaultLocation")))) {}
    for (boolean bool = true;; bool = false) {
      return Boolean.valueOf(bool);
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ride.FollowLocationManager.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */