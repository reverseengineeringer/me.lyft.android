package me.lyft.android.infrastructure.location;

import me.lyft.android.locationproviders.fused.LocationConnection;
import rx.functions.Action0;

class RxLocationService$2$1
  implements Action0
{
  RxLocationService$2$1(RxLocationService.2 param2, LocationConnection paramLocationConnection) {}
  
  public void call()
  {
    val$locationConnection.disconnect();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.location.RxLocationService.2.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */