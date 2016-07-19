package com.lyft.googlemaps.googlemap;

import com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener;
import com.google.android.gms.maps.model.Marker;
import com.lyft.googlemaps.core.ITooltipManager;

class GooglePlayMap$7
  implements GoogleMap.OnInfoWindowClickListener
{
  GooglePlayMap$7(GooglePlayMap paramGooglePlayMap, ITooltipManager paramITooltipManager) {}
  
  public void onInfoWindowClick(Marker paramMarker)
  {
    val$tooltipManager.handleTooltipClick(paramMarker.getId());
  }
}

/* Location:
 * Qualified Name:     com.lyft.googlemaps.googlemap.GooglePlayMap.7
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */