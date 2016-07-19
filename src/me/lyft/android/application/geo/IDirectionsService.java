package me.lyft.android.application.geo;

import java.util.List;
import me.lyft.android.domain.geo.Leg;
import me.lyft.android.domain.location.LatLng;
import rx.Observable;

public abstract interface IDirectionsService
{
  public abstract Observable<List<Leg>> directions(String paramString, List<LatLng> paramList);
}

/* Location:
 * Qualified Name:     me.lyft.android.application.geo.IDirectionsService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */