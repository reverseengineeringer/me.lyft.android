package me.lyft.android.domain.ride;

import java.util.Arrays;
import java.util.List;
import me.lyft.android.common.Objects;
import me.lyft.android.domain.driver.ride.DriverRide;
import me.lyft.android.rx.ReactiveProperty.EqualityComparator;

public class RouteEqualityComparator
  implements ReactiveProperty.EqualityComparator<DriverRide>
{
  public boolean equals(DriverRide paramDriverRide1, DriverRide paramDriverRide2)
  {
    if (paramDriverRide1 == paramDriverRide2) {}
    do
    {
      return true;
      if ((paramDriverRide1 == null) || (paramDriverRide2 == null)) {
        return false;
      }
      if ((!paramDriverRide1.getType().equals(paramDriverRide2.getType())) || (!paramDriverRide1.getStatus().equals(paramDriverRide2.getStatus())) || (paramDriverRide1.getPrimeTimePercent() != paramDriverRide2.getPrimeTimePercent()) || (paramDriverRide1.showEndRideConfirmation() != paramDriverRide2.showEndRideConfirmation()) || (!Objects.equals(paramDriverRide1.getEta(), paramDriverRide2.getEta()))) {
        return false;
      }
      if (!Arrays.equals(paramDriverRide1.getAllPassengers().toArray(), paramDriverRide2.getAllPassengers().toArray())) {
        return false;
      }
    } while (Arrays.equals(paramDriverRide1.getAllStops().toArray(), paramDriverRide2.getAllStops().toArray()));
    return false;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.ride.RouteEqualityComparator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */