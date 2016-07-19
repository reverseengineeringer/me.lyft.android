package me.lyft.android.infrastructure.location;

import me.lyft.android.application.polling.LocationAnalytics;
import me.lyft.android.locationproviders.fused.LocationConnection;
import rx.functions.Action0;

class RxLocationService$3$1
  implements Action0
{
  RxLocationService$3$1(RxLocationService.3 param3, LocationConnection paramLocationConnection) {}
  
  public void call()
  {
    RxLocationService.access$500(this$1.this$0).trackFusedLocationInitialization();
    val$fusedLocationConnection.connect();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.location.RxLocationService.3.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */