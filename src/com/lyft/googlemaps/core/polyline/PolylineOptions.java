package com.lyft.googlemaps.core.polyline;

import com.lyft.googlemaps.core.latlng.MapLatLng;
import java.util.ArrayList;
import java.util.List;

public class PolylineOptions
  implements IPolylineOptions
{
  private int color = 0;
  private List<MapLatLng> locations = new ArrayList();
  private float width = 0.0F;
  
  public static IPolylineOptions create()
  {
    return new PolylineOptions();
  }
  
  public IPolylineOptions addAll(List<MapLatLng> paramList)
  {
    locations.addAll(paramList);
    return this;
  }
  
  public IPolylineOptions color(int paramInt)
  {
    color = paramInt;
    return this;
  }
  
  public int getColor()
  {
    return color;
  }
  
  public List<MapLatLng> getLocations()
  {
    return locations;
  }
  
  public float getWidth()
  {
    return width;
  }
  
  public IPolylineOptions width(float paramFloat)
  {
    width = paramFloat;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.lyft.googlemaps.core.polyline.PolylineOptions
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */