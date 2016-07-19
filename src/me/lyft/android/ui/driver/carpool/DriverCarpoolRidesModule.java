package me.lyft.android.ui.driver.carpool;

import android.content.res.Resources;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import me.lyft.android.maps.renderers.PinTextRenderer;
import me.lyft.android.ui.MainActivityModule;
import me.lyft.android.ui.driver.DriverRideRatingAndEarningsView;
import me.lyft.android.ui.driver.carpool.screens.CarpoolDriverRideController;
import me.lyft.android.ui.ride.RideMap;

@Module(addsTo=MainActivityModule.class, complete=false, injects={CarpoolDriverRideController.class, DriverRideRatingAndEarningsView.class, CarpoolPassengerView.class}, library=true)
public class DriverCarpoolRidesModule
{
  @Provides
  @Singleton
  CarpoolDriverMapController provideCarpoolDriverMapController(RideMap paramRideMap, Resources paramResources, PinTextRenderer paramPinTextRenderer)
  {
    return new CarpoolDriverMapController(paramRideMap, paramResources, paramPinTextRenderer);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.driver.carpool.DriverCarpoolRidesModule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */