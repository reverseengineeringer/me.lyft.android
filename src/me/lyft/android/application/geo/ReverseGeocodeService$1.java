package me.lyft.android.application.geo;

import me.lyft.android.common.Strings;
import me.lyft.android.domain.location.Location;
import rx.Observable;
import rx.functions.Func1;

class ReverseGeocodeService$1
  implements Func1<Location, Observable<Location>>
{
  ReverseGeocodeService$1(ReverseGeocodeService paramReverseGeocodeService) {}
  
  public Observable<Location> call(Location paramLocation)
  {
    if (Strings.isNullOrEmpty(paramLocation.getDisplayName())) {
      return Observable.error(new RuntimeException("No displayable address available."));
    }
    return Observable.just(paramLocation);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.geo.ReverseGeocodeService.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */