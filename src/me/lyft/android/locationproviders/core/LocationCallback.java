package me.lyft.android.locationproviders.core;

import android.location.Location;

public abstract interface LocationCallback
{
  public abstract void onError(String paramString, int paramInt);
  
  public abstract void onLocationChanged(Location paramLocation);
}

/* Location:
 * Qualified Name:     me.lyft.android.locationproviders.core.LocationCallback
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */