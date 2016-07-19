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

class DriverRouteService$11
  implements Func1<Location, Observable<UniversalDTO>>
{
  DriverRouteService$11(DriverRouteService paramDriverRouteService, DriverRidePassenger paramDriverRidePassenger, int paramInt) {}
  
  public Observable<UniversalDTO> call(Location paramLocation)
  {
    return DriverRouteService.access$200(this$0).updateRide(val$passenger.getRideId(), new RideUpdateRequestDTOBuilder().withStatus("canceledWrongPartySize").withLocation(LocationMapper.toLocationDTO(paramLocation)).withActionTimestampMs(Long.valueOf(DeviceClock.getCurrentTimeMs())).withPartySize(Integer.valueOf(val$partySize)).build());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ride.DriverRouteService.11
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */