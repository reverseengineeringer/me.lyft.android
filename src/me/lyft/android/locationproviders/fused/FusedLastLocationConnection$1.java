package me.lyft.android.locationproviders.fused;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.location.FusedLocationProviderApi;
import com.google.android.gms.location.LocationServices;
import me.lyft.android.locationproviders.core.LocationCallback;

class FusedLastLocationConnection$1
  implements GoogleApiListener
{
  FusedLastLocationConnection$1(FusedLastLocationConnection paramFusedLastLocationConnection, LocationCallback paramLocationCallback) {}
  
  public void onConnected(Bundle paramBundle)
  {
    paramBundle = LocationServices.FusedLocationApi.getLastLocation(FusedLastLocationConnection.access$000(this$0));
    val$locationCallback.onLocationChanged(paramBundle);
  }
  
  public void onConnectionFailed(ConnectionResult paramConnectionResult)
  {
    val$locationCallback.onError("connection_failure", paramConnectionResult.getErrorCode());
  }
  
  public void onConnectionSuspended(int paramInt)
  {
    val$locationCallback.onError("suspension", paramInt);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.locationproviders.fused.FusedLastLocationConnection.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */