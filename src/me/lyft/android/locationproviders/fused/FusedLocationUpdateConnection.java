package me.lyft.android.locationproviders.fused;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.location.FusedLocationProviderApi;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationServices;
import me.lyft.android.locationproviders.core.LocationCallback;
import me.lyft.android.locationproviders.core.LocationClientConfiguration;

public class FusedLocationUpdateConnection
  implements LocationConnection
{
  private final GoogleApiClient apiClient;
  private final LocationListener locationListener;
  
  FusedLocationUpdateConnection(Context paramContext, final LocationClientConfiguration paramLocationClientConfiguration, final LocationCallback paramLocationCallback)
  {
    locationListener = new LocationListener()
    {
      public void onLocationChanged(Location paramAnonymousLocation)
      {
        paramLocationCallback.onLocationChanged(paramAnonymousLocation);
      }
    };
    paramContext = new GoogleApiClient.Builder(paramContext);
    paramContext.addApi(LocationServices.API);
    paramLocationClientConfiguration = new GoogleApiListener()
    {
      public void onConnected(Bundle paramAnonymousBundle)
      {
        LocationServices.FusedLocationApi.requestLocationUpdates(apiClient, LocationRequestMapper.toLocationRequest(paramLocationClientConfiguration), locationListener);
      }
      
      public void onConnectionFailed(ConnectionResult paramAnonymousConnectionResult)
      {
        paramLocationCallback.onError("connection_failure", paramAnonymousConnectionResult.getErrorCode());
      }
      
      public void onConnectionSuspended(int paramAnonymousInt)
      {
        paramLocationCallback.onError("suspension", paramAnonymousInt);
        try
        {
          LocationServices.FusedLocationApi.removeLocationUpdates(apiClient, locationListener);
          return;
        }
        catch (Throwable localThrowable) {}
      }
    };
    paramContext.addConnectionCallbacks(paramLocationClientConfiguration);
    paramContext.addOnConnectionFailedListener(paramLocationClientConfiguration);
    apiClient = paramContext.build();
  }
  
  public void connect()
  {
    if (!apiClient.isConnected()) {
      apiClient.connect();
    }
  }
  
  public void disconnect()
  {
    try
    {
      LocationServices.FusedLocationApi.removeLocationUpdates(apiClient, locationListener);
      if (apiClient.isConnected()) {
        apiClient.disconnect();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      do
      {
        localThrowable = localThrowable;
      } while (!apiClient.isConnected());
      apiClient.disconnect();
      return;
    }
    finally
    {
      localObject = finally;
      if (apiClient.isConnected()) {
        apiClient.disconnect();
      }
      throw ((Throwable)localObject);
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.locationproviders.fused.FusedLocationUpdateConnection
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */