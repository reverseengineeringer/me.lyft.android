package me.lyft.android.domain.passenger.routing;

import java.util.List;
import me.lyft.android.domain.location.LatLng;
import rx.functions.Func2;

class PassengerRoutePath$1
  implements Func2<List<LatLng>, PassengerLeg, List<LatLng>>
{
  PassengerRoutePath$1(PassengerRoutePath paramPassengerRoutePath) {}
  
  public List<LatLng> call(List<LatLng> paramList, PassengerLeg paramPassengerLeg)
  {
    paramList.addAll(paramPassengerLeg.getLocations());
    return paramList;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.passenger.routing.PassengerRoutePath.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */