package com.lyft.googlemaps.core.camera;

import com.lyft.googlemaps.core.latlng.MapLatLng;
import java.util.List;

public class MapBound
  implements IMapBound
{
  private int height;
  private List<? extends MapLatLng> locationList;
  private int padding;
  private int width;
  
  public MapBound(List<? extends MapLatLng> paramList, int paramInt1, int paramInt2, int paramInt3)
  {
    locationList = paramList;
    width = paramInt1;
    height = paramInt2;
    padding = paramInt3;
  }
  
  public int getHeight()
  {
    return height;
  }
  
  public List<? extends MapLatLng> getLocationList()
  {
    return locationList;
  }
  
  public int getPadding()
  {
    return padding;
  }
  
  public int getWidth()
  {
    return width;
  }
  
  public boolean isNull()
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     com.lyft.googlemaps.core.camera.MapBound
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */