package me.lyft.android.locationproviders.core;

import me.lyft.android.locationproviders.fused.LocationConnection;

public abstract interface LocationClient
{
  public abstract LocationConnection requestLastLocation(LocationCallback paramLocationCallback);
  
  public abstract LocationConnection requestLocationUpdates(LocationClientConfiguration paramLocationClientConfiguration, LocationCallback paramLocationCallback);
}

/* Location:
 * Qualified Name:     me.lyft.android.locationproviders.core.LocationClient
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */