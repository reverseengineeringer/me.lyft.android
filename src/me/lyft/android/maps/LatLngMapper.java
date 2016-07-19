package me.lyft.android.maps;

import com.lyft.googlemaps.core.latlng.MapLatLng;
import java.util.List;
import me.lyft.android.common.Iterables;
import me.lyft.android.domain.location.LatLng;
import me.lyft.android.domain.location.SimpleLatLng;
import rx.functions.Func1;

public class LatLngMapper
{
  public static MapLatLng fromDomainLatLng(LatLng paramLatLng)
  {
    return new MapLatLng(paramLatLng.getLat(), paramLatLng.getLng());
  }
  
  public static List<MapLatLng> fromDomainLatLng(List<LatLng> paramList)
  {
    Iterables.map(paramList, new Func1()
    {
      public MapLatLng call(LatLng paramAnonymousLatLng)
      {
        return new MapLatLng(paramAnonymousLatLng.getLat(), paramAnonymousLatLng.getLng());
      }
    });
  }
  
  public static LatLng toDomainLatLng(MapLatLng paramMapLatLng)
  {
    return new SimpleLatLng(paramMapLatLng.getLat(), paramMapLatLng.getLng());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.maps.LatLngMapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */