package com.lyft.googlemaps.googlemap;

import android.view.View;
import com.google.android.gms.maps.GoogleMap.InfoWindowAdapter;
import com.google.android.gms.maps.model.Marker;
import com.lyft.googlemaps.core.ITooltipManager;

class GooglePlayMap$6
  implements GoogleMap.InfoWindowAdapter
{
  GooglePlayMap$6(GooglePlayMap paramGooglePlayMap, ITooltipManager paramITooltipManager) {}
  
  public View getInfoContents(Marker paramMarker)
  {
    return null;
  }
  
  public View getInfoWindow(Marker paramMarker)
  {
    return val$tooltipManager.getTooltipView(paramMarker.getId(), paramMarker.getTitle());
  }
}

/* Location:
 * Qualified Name:     com.lyft.googlemaps.googlemap.GooglePlayMap.6
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */