package com.lyft.googlemaps.core.polygon;

public class NullPolygon
  implements IPolygon
{
  private static final IPolygon INSTANCE = new NullPolygon();
  
  public static IPolygon getInstance()
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
 * Qualified Name:     com.lyft.googlemaps.core.polygon.NullPolygon
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */