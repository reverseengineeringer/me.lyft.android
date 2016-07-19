package me.lyft.android.application.ride;

import com.lyft.android.api.dto.RideUpdateRequestDTOBuilder;
import me.lyft.android.application.features.Features;
import me.lyft.android.application.features.IFeaturesProvider;
import me.lyft.android.common.DeviceClock;
import me.lyft.android.common.Unit;
import me.lyft.android.domain.driver.ride.DriverRide;
import me.lyft.android.domain.driver.ride.DriverRidePassenger;
import me.lyft.android.domain.location.Location;
import me.lyft.android.domain.location.LocationMapper;
import me.lyft.android.infrastructure.deferred.IDeferredCallService;
import me.lyft.android.infrastructure.deferred.deferredcalls.DropOffDeferredCall;
import me.lyft.android.infrastructure.lyft.ILyftApi;
import rx.Observable;
import rx.functions.Func1;

class DriverRouteService$10
  implements Func1<Location, Observable<Unit>>
{
  DriverRouteService$10(DriverRouteService paramDriverRouteService, DriverRide paramDriverRide, DriverRidePassenger paramDriverRidePassenger) {}
  
  public Observable<Unit> call(Location paramLocation)
  {
    if (DriverRouteService.access$400(this$0).isEnabled(Features.OFFLINE_DROP_OFF_ENABLED))
    {
      DriverRide localDriverRide = val$driverRide.dropOff(val$passenger);
      DriverRouteService.access$100(this$0).setOfflineRide(localDriverRide);
      DriverRouteService.access$500(this$0).add(new DropOffDeferredCall(val$passenger.getRideId(), paramLocation, DeviceClock.getCurrentTimeMs()));
      return Unit.just();
    }
    return DriverRouteService.access$200(this$0).updateRide(val$passenger.getRideId(), new RideUpdateRequestDTOBuilder().withStatus("droppedOff").withActionTimestampMs(Long.valueOf(DeviceClock.getCurrentTimeMs())).withLocation(LocationMapper.toLocationDTO(paramLocation)).build()).map(Unit.func1());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ride.DriverRouteService.10
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */