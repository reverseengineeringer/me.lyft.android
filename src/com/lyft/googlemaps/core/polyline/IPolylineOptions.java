package com.lyft.googlemaps.core.polyline;

import com.lyft.googlemaps.core.latlng.MapLatLng;
import java.util.List;

public abstract interface IPolylineOptions
{
  public abstract IPolylineOptions addAll(List<MapLatLng> paramList);
  
  public abstract IPolylineOptions color(int paramInt);
  
  public abstract int getColor();
  
  public abstract List<MapLatLng> getLocations();
  
  public abstract float getWidth();
  
  public abstract IPolylineOptions width(float paramFloat);
}

/* Location:
 * Qualified Name:     com.lyft.googlemaps.core.polyline.IPolylineOptions
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */