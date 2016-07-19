package me.lyft.android.application.passenger;

import java.util.List;
import me.lyft.android.domain.location.LatLng;

public abstract interface IPassengerZoomProvider
{
  public abstract List<LatLng> getFullRoute();
  
  public abstract List<LatLng> getRouteUntilMyNextStop();
}

/* Location:
 * Qualified Name:     me.lyft.android.application.passenger.IPassengerZoomProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */