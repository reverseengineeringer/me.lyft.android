package com.lyft.googlemaps.core.camera;

import com.lyft.googlemaps.core.common.INullable;
import com.lyft.googlemaps.core.latlng.MapLatLng;

public abstract interface IMapPosition
  extends INullable
{
  public abstract float getBearing();
  
  public abstract MapLatLng getLocation();
  
  public abstract float getTilt();
  
  public abstract float getZoom();
}

/* Location:
 * Qualified Name:     com.lyft.googlemaps.core.camera.IMapPosition
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */