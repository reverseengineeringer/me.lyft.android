package com.lyft.googlemaps.googlemap;

import com.google.android.gms.maps.GoogleMap.OnInfoWindowCloseListener;
import com.google.android.gms.maps.model.Marker;
import com.lyft.googlemaps.core.ITooltipManager;

class GooglePlayMap$8
  implements GoogleMap.OnInfoWindowCloseListener
{
  GooglePlayMap$8(GooglePlayMap paramGooglePlayMap, ITooltipManager paramITooltipManager) {}
  
  public void onInfoWindowClose(Marker paramMarker)
  {
    val$tooltipManager.handleTooltipClosed(paramMarker.getId());
  }
}

/* Location:
 * Qualified Name:     com.lyft.googlemaps.googlemap.GooglePlayMap.8
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */