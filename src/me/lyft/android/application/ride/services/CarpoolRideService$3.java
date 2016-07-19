package me.lyft.android.application.ride.services;

import com.lyft.android.api.dto.RideUpdateRequestDTOBuilder;
import com.lyft.android.api.dto.UniversalDTO;
import me.lyft.android.common.DeviceClock;
import me.lyft.android.domain.location.Location;
import me.lyft.android.domain.location.LocationMapper;
import me.lyft.android.infrastructure.lyft.ILyftApi;
import rx.Observable;
import rx.functions.Func1;

class CarpoolRideService$3
  implements Func1<Location, Observable<UniversalDTO>>
{
  CarpoolRideService$3(CarpoolRideService paramCarpoolRideService, String paramString1, String paramString2) {}
  
  public Observable<UniversalDTO> call(Location paramLocation)
  {
    return CarpoolRideService.access$100(this$0).updateRide(val$rideId, new RideUpdateRequestDTOBuilder().withStatus(val$rideStatus).withActionTimestampMs(Long.valueOf(DeviceClock.getCurrentTimeMs())).withLocation(LocationMapper.toLocationDTO(paramLocation)).build());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ride.services.CarpoolRideService.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */