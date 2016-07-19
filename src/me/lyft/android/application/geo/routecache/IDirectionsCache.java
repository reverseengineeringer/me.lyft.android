package me.lyft.android.application.geo.routecache;

import java.util.List;
import me.lyft.android.domain.geo.Leg;
import me.lyft.android.domain.location.LatLng;

public abstract interface IDirectionsCache
{
  public abstract void cache(List<? extends LatLng> paramList, List<Leg> paramList1);
  
  public abstract List<Leg> getRoute(List<? extends LatLng> paramList);
}

/* Location:
 * Qualified Name:     me.lyft.android.application.geo.routecache.IDirectionsCache
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */