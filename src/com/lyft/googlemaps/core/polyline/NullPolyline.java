package com.lyft.googlemaps.core.polyline;

public class NullPolyline
  implements IPolyline
{
  private static final IPolyline INSTANCE = new NullPolyline();
  
  public static IPolyline getInstance()
  {
    return INSTANCE;
  }
  
  public boolean isNull()
  {
    return true;
  }
  
  public void remove() {}
}

/* Location:
 * Qualified Name:     com.lyft.googlemaps.core.polyline.NullPolyline
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */