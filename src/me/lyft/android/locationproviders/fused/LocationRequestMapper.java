package me.lyft.android.locationproviders.fused;

import com.google.android.gms.location.LocationRequest;
import me.lyft.android.locationproviders.core.LocationClientConfiguration;

public class LocationRequestMapper
{
  public static LocationRequest toLocationRequest(LocationClientConfiguration paramLocationClientConfiguration)
  {
    int i = 100;
    if (isBackgroundUpdate) {
      i = 102;
    }
    return LocationRequest.create().setPriority(i).setInterval(updateInterval).setFastestInterval(fastestInterval).setSmallestDisplacement(smallestDisplacement);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.locationproviders.fused.LocationRequestMapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */