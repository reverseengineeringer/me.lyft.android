package me.lyft.android.domain.location;

import me.lyft.android.common.INullable;

public abstract interface LatLng
  extends INullable
{
  public abstract double distanceTo(LatLng paramLatLng);
  
  public abstract double getLat();
  
  public abstract double getLng();
  
  public abstract boolean hasSameCoordinates(LatLng paramLatLng);
  
  public abstract String toQueryString();
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.location.LatLng
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */