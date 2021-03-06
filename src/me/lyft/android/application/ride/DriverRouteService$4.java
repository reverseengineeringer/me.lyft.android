package me.lyft.android.application.ride;

import com.lyft.android.api.dto.RideUpdateRequestDTOBuilder;
import com.lyft.android.api.dto.UniversalDTO;
import me.lyft.android.common.DeviceClock;
import me.lyft.android.common.Strings;
import me.lyft.android.domain.driver.ride.DriverRide;
import me.lyft.android.domain.driver.ride.DriverStop;
import me.lyft.android.domain.location.Location;
import me.lyft.android.domain.location.LocationMapper;
import me.lyft.android.domain.ride.CancellationOption;
import me.lyft.android.infrastructure.lyft.ILyftApi;
import rx.Observable;
import rx.functions.Func1;

class DriverRouteService$4
  implements Func1<Location, Observable<UniversalDTO>>
{
  DriverRouteService$4(DriverRouteService paramDriverRouteService, CancellationOption paramCancellationOption) {}
  
  public Observable<UniversalDTO> call(Location paramLocation)
  {
    return DriverRouteService.access$200(this$0).updateRide(DriverRouteService.access$100(this$0).getDriverRide().getCurrentStop().getRideId(), new RideUpdateRequestDTOBuilder().withStatus(val$cancellationOption.getStatus()).withActionTimestampMs(Long.valueOf(DeviceClock.getCurrentTimeMs())).withLocation(LocationMapper.toLocationDTO(paramLocation)).withCanceledReason(Strings.emptyToNull(val$cancellationOption.getId())).build());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ride.DriverRouteService.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */