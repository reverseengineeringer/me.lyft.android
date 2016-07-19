package com.lyft.googlemaps.core.polygon;

import com.lyft.googlemaps.core.latlng.MapLatLng;
import java.util.List;

public abstract interface IPolygonOptions
{
  public abstract IPolygonOptions addAll(List<MapLatLng> paramList);
  
  public abstract IPolygonOptions colorOptions(ColorOptions paramColorOptions);
  
  public abstract ColorOptions getColorOptions();
  
  public abstract List<MapLatLng> getLocations();
}

/* Location:
 * Qualified Name:     com.lyft.googlemaps.core.polygon.IPolygonOptions
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */