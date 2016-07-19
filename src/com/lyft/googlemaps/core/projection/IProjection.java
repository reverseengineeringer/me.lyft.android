package com.lyft.googlemaps.core.projection;

import android.graphics.Point;
import com.lyft.googlemaps.core.common.INullable;
import com.lyft.googlemaps.core.latlng.MapLatLng;

public abstract interface IProjection
  extends INullable
{
  public abstract MapLatLng fromScreenLocation(Point paramPoint);
  
  public abstract double getPixelsPerMeter();
  
  public abstract Point toScreenLocation(double paramDouble1, double paramDouble2);
  
  public abstract Point toScreenLocation(MapLatLng paramMapLatLng);
}

/* Location:
 * Qualified Name:     com.lyft.googlemaps.core.projection.IProjection
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */