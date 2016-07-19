package me.lyft.android.locationproviders.fused;

import android.content.Context;
import me.lyft.android.locationproviders.core.LocationCallback;
import me.lyft.android.locationproviders.core.LocationClient;
import me.lyft.android.locationproviders.core.LocationClientConfiguration;

public class FusedLocationClient
  implements LocationClient
{
  private final Context context;
  
  public FusedLocationClient(Context paramContext)
  {
    context = paramContext;
  }
  
  public LocationConnection requestLastLocation(LocationCallback paramLocationCallback)
  {
    return new FusedLastLocationConnection(context, paramLocationCallback);
  }
  
  public LocationConnection requestLocationUpdates(LocationClientConfiguration paramLocationClientConfiguration, LocationCallback paramLocationCallback)
  {
    return new FusedLocationUpdateConnection(context, paramLocationClientConfiguration, paramLocationCallback);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.locationproviders.fused.FusedLocationClient
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */