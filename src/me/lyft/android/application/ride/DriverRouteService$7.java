package me.lyft.android.application.ride;

import com.lyft.android.api.dto.RideUpdateRequestDTOBuilder;
import com.lyft.android.api.dto.UniversalDTO;
import me.lyft.android.common.DeviceClock;
import me.lyft.android.domain.driver.ride.DriverRidePassenger;
import me.lyft.android.domain.location.Location;
import me.lyft.android.domain.location.LocationMapper;
import me.lyft.android.infrastructure.lyft.ILyftApi;
import rx.Observable;
import rx.functions.Func1;

class DriverRouteService$7
  implements Func1<Location, Observable<UniversalDTO>>
{
  DriverRouteService$7(DriverRouteService paramDriverRouteService, DriverRidePassenger paramDriverRidePassenger) {}
  
  public Observable<UniversalDTO> call(Location paramLocation)
  {
    return DriverRouteService.access$200(this$0).updateRide(val$passenger.getRideId(), new RideUpdateRequestDTOBuilder().withStatus("pickedUp").withActionTimestampMs(Long.valueOf(DeviceClock.getCurrentTimeMs())).withLocation(LocationMapper.toLocationDTO(paramLocation)).build());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ride.DriverRouteService.7
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */