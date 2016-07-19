package me.lyft.android.ui.passenger;

import com.lyft.scoop.Controller;
import com.lyft.scoop.dagger.DaggerModule;
import me.lyft.android.domain.venue.Venue;
import me.lyft.android.ui.passenger.v2.request.venue.IntroduceVenueController;
import me.lyft.android.ui.ride.PassengerRideModule;

@Controller(IntroduceVenueController.class)
@DaggerModule(PassengerRideModule.class)
public class PassengerScreens$IntroduceVenueScreen
  extends PassengerDialogs
{
  public final Venue venue;
  
  public PassengerScreens$IntroduceVenueScreen(Venue paramVenue)
  {
    venue = paramVenue;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.passenger.PassengerScreens.IntroduceVenueScreen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */