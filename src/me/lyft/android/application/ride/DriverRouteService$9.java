package me.lyft.android.application.ride;

import me.lyft.android.common.Unit;
import me.lyft.android.infrastructure.googleplaces.IGooglePlaceService;
import me.lyft.android.rx.SimpleSubscriber;
import rx.Observable;
import rx.functions.Action1;

class DriverRouteService$9
  implements Action1<Unit>
{
  DriverRouteService$9(DriverRouteService paramDriverRouteService, String paramString) {}
  
  public void call(Unit paramUnit)
  {
    DriverRouteService.access$300(this$0).reportPlace(val$placeId, "passenger_dropoff").subscribe(new SimpleSubscriber());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ride.DriverRouteService.9
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */