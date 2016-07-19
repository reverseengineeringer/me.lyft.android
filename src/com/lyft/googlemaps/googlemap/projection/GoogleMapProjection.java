package com.lyft.googlemaps.googlemap.projection;

import android.graphics.Point;
import com.google.android.gms.maps.Projection;
import com.google.android.gms.maps.model.LatLng;
import com.lyft.googlemaps.core.latlng.MapLatLng;
import com.lyft.googlemaps.core.projection.IProjection;

public class GoogleMapProjection
  implements IProjection
{
  private static final LatLng LOCATION_1 = new LatLng(37.76034D, -122.413151D);
  private static final LatLng LOCATION_2 = new LatLng(37.334647D, -121.890039D);
  private final Projection googleProjection;
  private Double pixelsPerMeter;
  
  public GoogleMapProjection(Projection paramProjection)
  {
    googleProjection = paramProjection;
  }
  
  private static double getPixelsPerMeter(Projection paramProjection)
  {
    Point localPoint = paramProjection.toScreenLocation(LOCATION_1);
    paramProjection = paramProjection.toScreenLocation(LOCATION_2);
    double d1 = x - x;
    double d2 = y - y;
    return Math.sqrt(d1 * d1 + d2 * d2) / 66000.08648D;
  }
  
  public MapLatLng fromScreenLocation(Point paramPoint)
  {
    paramPoint = googleProjection.fromScreenLocation(paramPoint);
    return new MapLatLng(latitude, longitude);
  }
  
  public double getPixelsPerMeter()
  {
    if (pixelsPerMeter == null) {
      pixelsPerMeter = Double.valueOf(getPixelsPerMeter(googleProjection));
    }
    return pixelsPerMeter.doubleValue();
  }
  
  public boolean isNull()
  {
    return false;
  }
  
  public Point toScreenLocation(double paramDouble1, double paramDouble2)
  {
    return googleProjection.toScreenLocation(new LatLng(paramDouble1, paramDouble2));
  }
  
  public Point toScreenLocation(MapLatLng paramMapLatLng)
  {
    return toScreenLocation(paramMapLatLng.getLat(), paramMapLatLng.getLng());
  }
}

/* Location:
 * Qualified Name:     com.lyft.googlemaps.googlemap.projection.GoogleMapProjection
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */