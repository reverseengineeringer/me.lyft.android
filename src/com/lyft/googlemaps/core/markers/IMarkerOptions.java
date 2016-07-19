package com.lyft.googlemaps.core.markers;

import android.graphics.Bitmap;
import com.lyft.googlemaps.core.latlng.MapLatLng;

public abstract interface IMarkerOptions
{
  public abstract Bitmap getIcon();
  
  public abstract MapLatLng getPosition();
  
  public abstract float getRotation();
  
  public abstract float getXOffset();
  
  public abstract float getYOffset();
}

/* Location:
 * Qualified Name:     com.lyft.googlemaps.core.markers.IMarkerOptions
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */