package com.lyft.googlemaps.googlemap.polygon;

import com.google.android.gms.maps.model.Polygon;
import com.lyft.googlemaps.core.polygon.IPolygon;

public class GooglePolygon
  implements IPolygon
{
  private final Polygon polygon;
  
  public GooglePolygon(Polygon paramPolygon)
  {
    polygon = paramPolygon;
  }
  
  public boolean isNull()
  {
    return false;
  }
  
  public void remove()
  {
    polygon.remove();
  }
}

/* Location:
 * Qualified Name:     com.lyft.googlemaps.googlemap.polygon.GooglePolygon
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */