package com.lyft.googlemaps.core.projection;

import android.graphics.Point;
import com.lyft.googlemaps.core.latlng.MapLatLng;

public class NullProjection
  implements IProjection
{
  private static final IProjection INSTANCE = new NullProjection();
  private static final Point NULL_POINT = new Point(0, 0);
  
  public static IProjection getInstance()
  {
    return INSTANCE;
  }
  
  public MapLatLng fromScreenLocation(Point paramPoint)
  {
    return MapLatLng.empty();
  }
  
  public double getPixelsPerMeter()
  {
    return 1.0D;
  }
  
  public boolean isNull()
  {
    return true;
  }
  
  public Point toScreenLocation(double paramDouble1, double paramDouble2)
  {
    return NULL_POINT;
  }
  
  public Point toScreenLocation(MapLatLng paramMapLatLng)
  {
    return NULL_POINT;
  }
}

/* Location:
 * Qualified Name:     com.lyft.googlemaps.core.projection.NullProjection
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */