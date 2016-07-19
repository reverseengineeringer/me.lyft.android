package me.lyft.android.locationproviders.android;

import android.location.Location;
import android.location.LocationManager;
import java.util.Iterator;
import java.util.List;
import me.lyft.android.locationproviders.core.LocationCallback;
import me.lyft.android.locationproviders.fused.LocationConnection;

public class AndroidLastLocationConnection
  implements LocationConnection
{
  private static final float SMALLEST_DISPLACEMENT_METERS = 0.0F;
  private final LocationCallback locationCallback;
  private final LocationManager locationManager;
  
  public AndroidLastLocationConnection(LocationManager paramLocationManager, LocationCallback paramLocationCallback)
  {
    locationManager = paramLocationManager;
    locationCallback = paramLocationCallback;
  }
  
  public void connect()
  {
    Object localObject2 = locationManager.getAllProviders();
    Object localObject1 = null;
    Iterator localIterator = ((List)localObject2).iterator();
    while (localIterator.hasNext())
    {
      localObject2 = (String)localIterator.next();
      localObject2 = locationManager.getLastKnownLocation((String)localObject2);
      if (LocationUtil.isBetterLocation((Location)localObject2, (Location)localObject1, 30L, 0.0F)) {
        localObject1 = localObject2;
      }
    }
    locationCallback.onLocationChanged((Location)localObject1);
  }
  
  public void disconnect() {}
}

/* Location:
 * Qualified Name:     me.lyft.android.locationproviders.android.AndroidLastLocationConnection
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */