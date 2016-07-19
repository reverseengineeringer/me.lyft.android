package com.lyft.googlemaps.core.circle;

import com.lyft.googlemaps.core.latlng.MapLatLng;

public abstract interface ICircleOptions
{
  public abstract MapLatLng getCenter();
  
  public abstract int getFillColor();
  
  public abstract double getRadius();
  
  public abstract int getStrokeColor();
  
  public abstract float getStrokeWidth();
}

/* Location:
 * Qualified Name:     com.lyft.googlemaps.core.circle.ICircleOptions
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */