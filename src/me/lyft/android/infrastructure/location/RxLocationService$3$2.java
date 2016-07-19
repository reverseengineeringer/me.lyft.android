package me.lyft.android.infrastructure.location;

import me.lyft.android.locationproviders.fused.LocationConnection;
import rx.Scheduler.Worker;
import rx.functions.Action0;

class RxLocationService$3$2
  implements Action0
{
  RxLocationService$3$2(RxLocationService.3 param3, Scheduler.Worker paramWorker, LocationConnection paramLocationConnection1, LocationConnection paramLocationConnection2) {}
  
  public void call()
  {
    val$reconnectWorker.unsubscribe();
    val$androidLocationConnection.disconnect();
    val$fusedLocationConnection.disconnect();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.location.RxLocationService.3.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */