package com.lyft.googlemaps.core.camera;

import com.lyft.googlemaps.core.common.INullable;
import com.lyft.googlemaps.core.latlng.MapLatLng;
import java.util.List;

public abstract interface IMapBound
  extends INullable
{
  public abstract int getHeight();
  
  public abstract List<? extends MapLatLng> getLocationList();
  
  public abstract int getPadding();
  
  public abstract int getWidth();
}

/* Location:
 * Qualified Name:     com.lyft.googlemaps.core.camera.IMapBound
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */