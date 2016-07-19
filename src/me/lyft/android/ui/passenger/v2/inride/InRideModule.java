package me.lyft.android.ui.passenger.v2.inride;

import dagger.Module;
import dagger.Provides;
import me.lyft.android.application.passenger.IPassengerRideProvider;
import me.lyft.android.application.passenger.IPassengerZoomProvider;
import me.lyft.android.infrastructure.location.ILocationService;
import me.lyft.android.maps.MapOwner;
import me.lyft.android.ui.passenger.PassengerActiveRideZoomingController;
import me.lyft.android.ui.ride.PassengerRideModule;

@Module(addsTo=PassengerRideModule.class, injects={CourierInRideView.class, ClassicInRideView.class, CarpoolInRideView.class})
public class InRideModule
{
  @Provides
  PassengerActiveRideZoomingController providePassengerClassicRideZoomingController(ILocationService paramILocationService, IPassengerRideProvider paramIPassengerRideProvider, MapOwner paramMapOwner, IPassengerZoomProvider paramIPassengerZoomProvider)
  {
    return new PassengerActiveRideZoomingController(paramILocationService, paramIPassengerRideProvider, paramIPassengerZoomProvider, paramMapOwner);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.passenger.v2.inride.InRideModule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */