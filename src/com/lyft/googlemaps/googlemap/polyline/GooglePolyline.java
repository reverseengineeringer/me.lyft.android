package com.lyft.googlemaps.googlemap.polyline;

import com.google.android.gms.maps.model.Polyline;
import com.lyft.googlemaps.core.polyline.IPolyline;

public class GooglePolyline
  implements IPolyline
{
  private final Polyline googlePolyline;
  
  public GooglePolyline(Polyline paramPolyline)
  {
    googlePolyline = paramPolyline;
  }
  
  public boolean isNull()
  {
    return false;
  }
  
  public void remove()
  {
    googlePolyline.remove();
  }
}

/* Location:
 * Qualified Name:     com.lyft.googlemaps.googlemap.polyline.GooglePolyline
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */