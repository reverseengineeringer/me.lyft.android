package com.lyft.googlemaps.googlemap;

import android.location.Location;
import com.google.android.gms.maps.LocationSource.OnLocationChangedListener;
import com.lyft.googlemaps.core.callback.Callback1;

class GooglePlayMap$2$1
  implements Callback1<Location>
{
  GooglePlayMap$2$1(GooglePlayMap.2 param2, LocationSource.OnLocationChangedListener paramOnLocationChangedListener) {}
  
  public void call(Location paramLocation)
  {
    val$onLocationChangedListener.onLocationChanged(paramLocation);
  }
}

/* Location:
 * Qualified Name:     com.lyft.googlemaps.googlemap.GooglePlayMap.2.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */