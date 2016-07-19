package com.lyft.googlemaps.core.camera;

import com.lyft.googlemaps.core.latlng.MapLatLng;

public class NullMapPosition
  implements IMapPosition
{
  private static final IMapPosition INSTANCE = new NullMapPosition();
  
  public static IMapPosition getInstance()
  {
    return INSTANCE;
  }
  
  public float getBearing()
  {
    return 0.0F;
  }
  
  public MapLatLng getLocation()
  {
    return MapLatLng.empty();
  }
  
  public float getTilt()
  {
    return 0.0F;
  }
  
  public float getZoom()
  {
    return 0.0F;
  }
  
  public boolean isNull()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     com.lyft.googlemaps.core.camera.NullMapPosition
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */