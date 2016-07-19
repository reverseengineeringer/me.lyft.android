package me.lyft.android.domain.passenger.routing;

import java.util.List;
import me.lyft.android.domain.geo.Leg;
import me.lyft.android.domain.location.LatLng;
import me.lyft.android.domain.passenger.ride.PassengerRidePassenger;
import me.lyft.android.domain.passenger.ride.PassengerStop;

public class PassengerLeg
  extends Leg
{
  private final PassengerStop legEnd;
  
  public PassengerLeg(List<LatLng> paramList, PassengerStop paramPassengerStop)
  {
    legEnd = paramPassengerStop;
    addPositions(paramList);
  }
  
  public boolean isMine()
  {
    return legEnd.getPassenger().isSelf();
  }
  
  public boolean isPickup()
  {
    return legEnd.isPickup();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.passenger.routing.PassengerLeg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */