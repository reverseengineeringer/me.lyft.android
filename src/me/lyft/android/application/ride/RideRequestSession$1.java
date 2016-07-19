package me.lyft.android.application.ride;

import me.lyft.android.domain.location.Location;
import rx.functions.Func1;

final class RideRequestSession$1
  implements Func1<Location, String>
{
  public String call(Location paramLocation)
  {
    return paramLocation.toQueryString();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ride.RideRequestSession.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */