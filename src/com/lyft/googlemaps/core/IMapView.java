package com.lyft.googlemaps.core;

import com.lyft.googlemaps.core.markers.IMarker;
import com.lyft.googlemaps.core.markers.IMarkerOptions;

public abstract interface IMapView
{
  public abstract IMarker addMarker(IMarkerOptions paramIMarkerOptions);
}

/* Location:
 * Qualified Name:     com.lyft.googlemaps.core.IMapView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */