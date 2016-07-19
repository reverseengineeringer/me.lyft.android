package me.lyft.android.ui.ridehistory;

import com.lyft.scoop.Controller;

@Controller(PassengerRideHistoryDetailedView.class)
public class RideHistoryScreens$PassengerRideHistoryDetailedScreen
  extends RideHistoryScreens
{
  private final String rideId;
  
  public RideHistoryScreens$PassengerRideHistoryDetailedScreen(String paramString)
  {
    rideId = paramString;
  }
  
  public String getRideId()
  {
    return rideId;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.ridehistory.RideHistoryScreens.PassengerRideHistoryDetailedScreen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */