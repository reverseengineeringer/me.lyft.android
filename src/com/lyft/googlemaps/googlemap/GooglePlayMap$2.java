package com.lyft.googlemaps.googlemap;

import android.location.Location;
import com.google.android.gms.maps.LocationSource;
import com.google.android.gms.maps.LocationSource.OnLocationChangedListener;
import com.lyft.googlemaps.core.callback.Callback1;
import com.lyft.googlemaps.googlemap.latlng.LocationSourceHook;

class GooglePlayMap$2
  implements LocationSource
{
  GooglePlayMap$2(GooglePlayMap paramGooglePlayMap, LocationSourceHook paramLocationSourceHook) {}
  
  public void activate(final LocationSource.OnLocationChangedListener paramOnLocationChangedListener)
  {
    val$locationSourceHook.activate(new Callback1()
    {
      public void call(Location paramAnonymousLocation)
      {
        paramOnLocationChangedListener.onLocationChanged(paramAnonymousLocation);
      }
    });
  }
  
  public void deactivate()
  {
    val$locationSourceHook.deactivate();
  }
}

/* Location:
 * Qualified Name:     com.lyft.googlemaps.googlemap.GooglePlayMap.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */