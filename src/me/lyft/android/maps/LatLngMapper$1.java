package me.lyft.android.maps;

import com.lyft.googlemaps.core.latlng.MapLatLng;
import me.lyft.android.domain.location.LatLng;
import rx.functions.Func1;

final class LatLngMapper$1
  implements Func1<LatLng, MapLatLng>
{
  public MapLatLng call(LatLng paramLatLng)
  {
    return new MapLatLng(paramLatLng.getLat(), paramLatLng.getLng());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.maps.LatLngMapper.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */