package com.lyft.googlemaps.googlemap;

import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.model.Marker;
import com.lyft.googlemaps.core.function.Listener;

class GooglePlayMap$4
  implements GoogleMap.OnMarkerClickListener
{
  GooglePlayMap$4(GooglePlayMap paramGooglePlayMap, Listener paramListener) {}
  
  public boolean onMarkerClick(Marker paramMarker)
  {
    return ((Boolean)val$onMarkerClickListener.call(paramMarker.getId())).booleanValue();
  }
}

/* Location:
 * Qualified Name:     com.lyft.googlemaps.googlemap.GooglePlayMap.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */