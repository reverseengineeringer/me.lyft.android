package me.lyft.android.application.ride;

import me.lyft.android.common.Objects;
import me.lyft.android.domain.location.Location;
import me.lyft.android.domain.passenger.ride.PassengerRideRequest.RequestRideStep;
import me.lyft.android.infrastructure.location.ILocationService;
import me.lyft.android.rx.SimpleSubscriber;
import rx.Observable;
import rx.Subscription;
import rx.functions.Func1;
import rx.subscriptions.Subscriptions;

public class FollowLocationManager
  implements IFollowLocationManager
{
  private final ILocationService locationService;
  private Subscription locationUpdateSubscription = Subscriptions.empty();
  private final IRideRequestSession rideRequestSession;
  
  public FollowLocationManager(ILocationService paramILocationService, IRideRequestSession paramIRideRequestSession)
  {
    locationService = paramILocationService;
    rideRequestSession = paramIRideRequestSession;
  }
  
  public void start()
  {
    locationUpdateSubscription.unsubscribe();
    locationUpdateSubscription = locationService.observePassiveLocationUpdates().filter(new Func1()
    {
      public Boolean call(Location paramAnonymousLocation)
      {
        paramAnonymousLocation = rideRequestSession.getPickupLocation();
        if ((rideRequestSession.getRequestRideStep() == PassengerRideRequest.RequestRideStep.SET_PICKUP) && ((paramAnonymousLocation.isNull()) || (Objects.equals(paramAnonymousLocation.getSource(), "defaultLocation")))) {}
        for (boolean bool = true;; bool = false) {
          return Boolean.valueOf(bool);
        }
      }
    }).subscribe(new SimpleSubscriber()
    {
      public void onNext(Location paramAnonymousLocation)
      {
        if (!rideRequestSession.getPickupLocation().hasSameCoordinates(paramAnonymousLocation)) {
          rideRequestSession.setPickupLocation(paramAnonymousLocation);
        }
      }
    });
  }
  
  public void stop()
  {
    locationUpdateSubscription.unsubscribe();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ride.FollowLocationManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */