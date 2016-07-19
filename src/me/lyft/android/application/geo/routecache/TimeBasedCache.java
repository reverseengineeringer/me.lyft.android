package me.lyft.android.application.geo.routecache;

import java.util.List;
import java.util.concurrent.TimeUnit;
import me.lyft.android.application.constants.Constants;
import me.lyft.android.application.constants.IConstantsProvider;
import me.lyft.android.domain.geo.Leg;
import me.lyft.android.domain.location.LatLng;

public class TimeBasedCache
  implements IDirectionsCache
{
  private CachedDirections cachedDirections = CachedDirections.empty();
  private IConstantsProvider constantsProvider;
  
  public TimeBasedCache(IConstantsProvider paramIConstantsProvider)
  {
    constantsProvider = paramIConstantsProvider;
  }
  
  private boolean isDirectionsCacheStale(List<? extends LatLng> paramList)
  {
    long l = ((Long)constantsProvider.get(Constants.ROUTE_DIRECTIONS_REFRESH_INTERVAL)).longValue();
    return (cachedDirections.isEmpty()) || (System.currentTimeMillis() - cachedDirections.getTimestamp() >= TimeUnit.SECONDS.toMillis(l)) || (!cachedDirections.areForSameRoute(paramList));
  }
  
  public void cache(List<? extends LatLng> paramList, List<Leg> paramList1)
  {
    cachedDirections = new CachedDirections(System.currentTimeMillis(), paramList, paramList1);
  }
  
  public List<Leg> getRoute(List<? extends LatLng> paramList)
  {
    if (isDirectionsCacheStale(paramList)) {
      return null;
    }
    return cachedDirections.getLegs();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.geo.routecache.TimeBasedCache
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */