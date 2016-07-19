package me.lyft.android.application.ride;

import com.lyft.android.api.dto.RideUpdateRequestDTOBuilder;
import com.lyft.android.api.dto.UniversalDTO;
import me.lyft.android.common.DeviceClock;
import me.lyft.android.common.Strings;
import me.lyft.android.domain.driver.ride.DriverStop;
import me.lyft.android.domain.location.Location;
import me.lyft.android.domain.location.LocationMapper;
import me.lyft.android.infrastructure.lyft.ILyftApi;
import rx.Observable;
import rx.functions.Func1;

class DriverRouteService$5
  implements Func1<Location, Observable<UniversalDTO>>
{
  DriverRouteService$5(DriverRouteService paramDriverRouteService, DriverStop paramDriverStop, String paramString) {}
  
  public Observable<UniversalDTO> call(Location paramLocation)
  {
    return DriverRouteService.access$200(this$0).updateRide(val$stop.getRideId(), new RideUpdateRequestDTOBuilder().withStatus("arrived").withActionTimestampMs(Long.valueOf(DeviceClock.getCurrentTimeMs())).withArrivedReason(Strings.emptyToNull(val$reason)).withLocation(LocationMapper.toLocationDTO(paramLocation)).build());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ride.DriverRouteService.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */