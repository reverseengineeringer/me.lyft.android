package me.lyft.android.locationproviders.android;

import android.location.Location;
import android.location.LocationManager;
import android.os.HandlerThread;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import me.lyft.android.locationproviders.core.LocationCallback;
import me.lyft.android.locationproviders.core.LocationClientConfiguration;
import me.lyft.android.locationproviders.fused.LocationConnection;

public class AndroidLocationUpdateConnection
  implements LocationConnection
{
  private static final List<String> BACKGROUND_UPDATE_PROVIDERS = Arrays.asList(new String[] { "network", "passive" });
  private static final String HANDLER_THREAD_NAME = "LocationManager";
  private final HandlerThread handlerThread;
  private Location lastLocation = null;
  private final LocationClientConfiguration locationClientConfiguration;
  private final SimpleLocationListener locationListener;
  private final LocationManager locationManager;
  
  public AndroidLocationUpdateConnection(LocationManager paramLocationManager, final LocationClientConfiguration paramLocationClientConfiguration, final LocationCallback paramLocationCallback)
  {
    locationManager = paramLocationManager;
    locationClientConfiguration = paramLocationClientConfiguration;
    locationListener = new SimpleLocationListener()
    {
      public void onLocationChanged(Location paramAnonymousLocation)
      {
        if (LocationUtil.isBetterLocation(paramAnonymousLocation, lastLocation, 30L, paramLocationClientConfigurationsmallestDisplacement)) {
          paramLocationCallback.onLocationChanged(paramAnonymousLocation);
        }
      }
    };
    handlerThread = new HandlerThread("LocationManager");
  }
  
  public void connect()
  {
    if (!handlerThread.isAlive()) {
      handlerThread.start();
    }
    if (locationClientConfiguration.isBackgroundUpdate) {}
    for (Object localObject = BACKGROUND_UPDATE_PROVIDERS;; localObject = locationManager.getAllProviders())
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        locationManager.requestLocationUpdates(str, locationClientConfiguration.updateInterval, locationClientConfiguration.smallestDisplacement, locationListener, handlerThread.getLooper());
      }
    }
  }
  
  public void disconnect()
  {
    locationManager.removeUpdates(locationListener);
    if (handlerThread.isAlive()) {
      handlerThread.quit();
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.locationproviders.android.AndroidLocationUpdateConnection
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */