package me.lyft.android.application.geo;

import me.lyft.android.domain.location.LatLng;
import rx.functions.Func1;

class GoogleDirectionsService$1
  implements Func1<LatLng, String>
{
  GoogleDirectionsService$1(GoogleDirectionsService paramGoogleDirectionsService) {}
  
  public String call(LatLng paramLatLng)
  {
    return paramLatLng.toQueryString();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.geo.GoogleDirectionsService.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */