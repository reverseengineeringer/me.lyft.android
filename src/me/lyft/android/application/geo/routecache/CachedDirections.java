package me.lyft.android.application.geo.routecache;

import java.util.List;
import me.lyft.android.domain.geo.Leg;
import me.lyft.android.domain.location.LatLng;

public class CachedDirections
{
  private final List<Leg> legs;
  private final List<? extends LatLng> route;
  private final long timestamp;
  
  public CachedDirections(long paramLong, List<? extends LatLng> paramList, List<Leg> paramList1)
  {
    timestamp = paramLong;
    route = paramList;
    legs = paramList1;
  }
  
  public static CachedDirections empty()
  {
    return new CachedDirections(-1L, null, null);
  }
  
  private boolean isSameRoute(List<? extends LatLng> paramList1, List<? extends LatLng> paramList2)
  {
    if ((paramList1 == null) || (paramList2 == null) || (paramList1.size() != paramList2.size())) {
      return false;
    }
    int i = 0;
    for (;;)
    {
      if (i >= paramList1.size()) {
        break label72;
      }
      if (!((LatLng)paramList1.get(i)).hasSameCoordinates((LatLng)paramList2.get(i))) {
        break;
      }
      i += 1;
    }
    label72:
    return true;
  }
  
  public boolean areForSameRoute(List<? extends LatLng> paramList)
  {
    return isSameRoute(route, paramList);
  }
  
  public List<Leg> getLegs()
  {
    return legs;
  }
  
  public List<? extends LatLng> getRoute()
  {
    return route;
  }
  
  public long getTimestamp()
  {
    return timestamp;
  }
  
  public boolean isEmpty()
  {
    return legs == null;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.geo.routecache.CachedDirections
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */