package me.lyft.android.locationproviders.fused;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.location.FusedLocationProviderApi;
import com.google.android.gms.location.LocationServices;
import me.lyft.android.locationproviders.core.LocationCallback;

public class FusedLastLocationConnection
  implements LocationConnection
{
  private final GoogleApiClient apiClient;
  
  public FusedLastLocationConnection(Context paramContext, final LocationCallback paramLocationCallback)
  {
    paramContext = new GoogleApiClient.Builder(paramContext);
    paramContext.addApi(LocationServices.API);
    paramLocationCallback = new GoogleApiListener()
    {
      public void onConnected(Bundle paramAnonymousBundle)
      {
        paramAnonymousBundle = LocationServices.FusedLocationApi.getLastLocation(apiClient);
        paramLocationCallback.onLocationChanged(paramAnonymousBundle);
      }
      
      public void onConnectionFailed(ConnectionResult paramAnonymousConnectionResult)
      {
        paramLocationCallback.onError("connection_failure", paramAnonymousConnectionResult.getErrorCode());
      }
      
      public void onConnectionSuspended(int paramAnonymousInt)
      {
        paramLocationCallback.onError("suspension", paramAnonymousInt);
      }
    };
    paramContext.addConnectionCallbacks(paramLocationCallback);
    paramContext.addOnConnectionFailedListener(paramLocationCallback);
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
    if (apiClient.isConnected()) {
      apiClient.disconnect();
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.locationproviders.fused.FusedLastLocationConnection
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */