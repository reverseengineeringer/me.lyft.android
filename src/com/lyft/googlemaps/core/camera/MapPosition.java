package com.lyft.googlemaps.core.camera;

import com.lyft.googlemaps.core.latlng.MapLatLng;

public class MapPosition
  implements IMapPosition
{
  private float bearing;
  private MapLatLng location;
  private float tilt;
  private float zoom;
  
  public MapPosition(MapLatLng paramMapLatLng, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    location = paramMapLatLng;
    zoom = paramFloat1;
    tilt = paramFloat2;
    bearing = paramFloat3;
  }
  
  public float getBearing()
  {
    return bearing;
  }
  
  public MapLatLng getLocation()
  {
    return location;
  }
  
  public float getTilt()
  {
    return tilt;
  }
  
  public float getZoom()
  {
    return zoom;
  }
  
  public boolean isNull()
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     com.lyft.googlemaps.core.camera.MapPosition
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */