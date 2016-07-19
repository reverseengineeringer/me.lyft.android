package me.lyft.android.locationproviders.fused;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.location.FusedLocationProviderApi;
import com.google.android.gms.location.LocationServices;
import me.lyft.android.locationproviders.core.LocationCallback;
import me.lyft.android.locationproviders.core.LocationClientConfiguration;

class FusedLocationUpdateConnection$2
  implements GoogleApiListener
{
  FusedLocationUpdateConnection$2(FusedLocationUpdateConnection paramFusedLocationUpdateConnection, LocationClientConfiguration paramLocationClientConfiguration, LocationCallback paramLocationCallback) {}
  
  public void onConnected(Bundle paramBundle)
  {
    LocationServices.FusedLocationApi.requestLocationUpdates(FusedLocationUpdateConnection.access$000(this$0), LocationRequestMapper.toLocationRequest(val$locationClientConfiguration), FusedLocationUpdateConnection.access$100(this$0));
  }
  
  public void onConnectionFailed(ConnectionResult paramConnectionResult)
  {
    val$locationCallback.onError("connection_failure", paramConnectionResult.getErrorCode());
  }
  
  public void onConnectionSuspended(int paramInt)
  {
    val$locationCallback.onError("suspension", paramInt);
    try
    {
      LocationServices.FusedLocationApi.removeLocationUpdates(FusedLocationUpdateConnection.access$000(this$0), FusedLocationUpdateConnection.access$100(this$0));
      return;
    }
    catch (Throwable localThrowable) {}
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.locationproviders.fused.FusedLocationUpdateConnection.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */