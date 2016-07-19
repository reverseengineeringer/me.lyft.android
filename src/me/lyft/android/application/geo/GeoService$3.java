package me.lyft.android.application.geo;

import me.lyft.android.domain.location.Location;
import rx.functions.Func1;

class GeoService$3
  implements Func1<Location, String>
{
  GeoService$3(GeoService paramGeoService) {}
  
  public String call(Location paramLocation)
  {
    return paramLocation.toQueryString();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.geo.GeoService.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */