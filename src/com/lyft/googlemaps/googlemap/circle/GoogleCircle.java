package com.lyft.googlemaps.googlemap.circle;

import com.google.android.gms.maps.model.Circle;
import com.lyft.googlemaps.core.circle.ICircle;

public class GoogleCircle
  implements ICircle
{
  private Circle circle;
  
  public GoogleCircle(Circle paramCircle)
  {
    circle = paramCircle;
  }
  
  public void remove()
  {
    circle.remove();
  }
}

/* Location:
 * Qualified Name:     com.lyft.googlemaps.googlemap.circle.GoogleCircle
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */