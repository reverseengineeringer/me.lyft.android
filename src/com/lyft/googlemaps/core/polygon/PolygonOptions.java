package com.lyft.googlemaps.core.polygon;

import com.lyft.googlemaps.core.latlng.MapLatLng;
import java.util.ArrayList;
import java.util.List;

public class PolygonOptions
  implements IPolygonOptions
{
  private ColorOptions colorOptions = new ColorOptions(0, 0, 0.0F);
  private List<MapLatLng> locations = new ArrayList();
  
  public static IPolygonOptions create()
  {
    return new PolygonOptions();
  }
  
  public IPolygonOptions addAll(List<MapLatLng> paramList)
  {
    locations.addAll(paramList);
    return this;
  }
  
  public IPolygonOptions colorOptions(ColorOptions paramColorOptions)
  {
    colorOptions = paramColorOptions;
    return this;
  }
  
  public ColorOptions getColorOptions()
  {
    return colorOptions;
  }
  
  public List<MapLatLng> getLocations()
  {
    return locations;
  }
}

/* Location:
 * Qualified Name:     com.lyft.googlemaps.core.polygon.PolygonOptions
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */