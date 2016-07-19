package com.lyft.googlemaps.core.latlng;

public class MapLatLng
{
  private static final MapLatLng NULL_INSTANCE = new MapLatLng(-1.0D, -1.0D);
  private final double lat;
  private final double lng;
  
  public MapLatLng(double paramDouble1, double paramDouble2)
  {
    lat = paramDouble1;
    lng = paramDouble2;
  }
  
  public static MapLatLng empty()
  {
    return NULL_INSTANCE;
  }
  
  public double getLat()
  {
    return lat;
  }
  
  public double getLng()
  {
    return lng;
  }
}

/* Location:
 * Qualified Name:     com.lyft.googlemaps.core.latlng.MapLatLng
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */