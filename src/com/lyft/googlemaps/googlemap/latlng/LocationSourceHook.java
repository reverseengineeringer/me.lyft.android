package com.lyft.googlemaps.googlemap.latlng;

import android.location.Location;
import com.lyft.googlemaps.core.callback.Callback1;

public abstract interface LocationSourceHook
{
  public abstract void activate(Callback1<Location> paramCallback1);
  
  public abstract void deactivate();
}

/* Location:
 * Qualified Name:     com.lyft.googlemaps.googlemap.latlng.LocationSourceHook
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */