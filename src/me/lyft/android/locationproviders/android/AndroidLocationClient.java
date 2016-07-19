package me.lyft.android.locationproviders.android;

import android.location.LocationManager;
import me.lyft.android.locationproviders.core.LocationCallback;
import me.lyft.android.locationproviders.core.LocationClient;
import me.lyft.android.locationproviders.core.LocationClientConfiguration;
import me.lyft.android.locationproviders.fused.LocationConnection;

public class AndroidLocationClient
  implements LocationClient
{
  static final long LOCATION_EXPIRATION_TIME = 30L;
  private final LocationManager locationManager;
  
  public AndroidLocationClient(LocationManager paramLocationManager)
  {
    locationManager = paramLocationManager;
  }
  
  public LocationConnection requestLastLocation(LocationCallback paramLocationCallback)
  {
    return new AndroidLastLocationConnection(locationManager, paramLocationCallback);
  }
  
  public LocationConnection requestLocationUpdates(LocationClientConfiguration paramLocationClientConfiguration, LocationCallback paramLocationCallback)
  {
    return new AndroidLocationUpdateConnection(locationManager, paramLocationClientConfiguration, paramLocationCallback);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.locationproviders.android.AndroidLocationClient
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */