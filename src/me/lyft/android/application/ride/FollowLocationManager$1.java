package me.lyft.android.application.ride;

import me.lyft.android.domain.location.Location;
import me.lyft.android.rx.SimpleSubscriber;

class FollowLocationManager$1
  extends SimpleSubscriber<Location>
{
  FollowLocationManager$1(FollowLocationManager paramFollowLocationManager) {}
  
  public void onNext(Location paramLocation)
  {
    if (!FollowLocationManager.access$000(this$0).getPickupLocation().hasSameCoordinates(paramLocation)) {
      FollowLocationManager.access$000(this$0).setPickupLocation(paramLocation);
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ride.FollowLocationManager.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */