package me.lyft.android.application.passenger;

import com.lyft.android.api.dto.RideUpdateRequestDTOBuilder;
import com.lyft.android.api.dto.UniversalDTO;
import me.lyft.android.common.DeviceClock;
import me.lyft.android.common.Strings;
import me.lyft.android.domain.location.Location;
import me.lyft.android.domain.location.LocationMapper;
import me.lyft.android.domain.passenger.ride.PassengerRide;
import me.lyft.android.domain.ride.CancellationOption;
import me.lyft.android.infrastructure.lyft.ILyftApi;
import rx.Observable;
import rx.functions.Func1;

class PassengerRideService$5
  implements Func1<Location, Observable<UniversalDTO>>
{
  PassengerRideService$5(PassengerRideService paramPassengerRideService, PassengerRide paramPassengerRide, String paramString, CancellationOption paramCancellationOption) {}
  
  public Observable<UniversalDTO> call(Location paramLocation)
  {
    return PassengerRideService.access$400(this$0).updateRide(val$passengerRide.getId(), new RideUpdateRequestDTOBuilder().withStatus(val$cancelStatus).withActionTimestampMs(Long.valueOf(DeviceClock.getCurrentTimeMs())).withLocation(LocationMapper.toLocationDTO(paramLocation)).withCanceledReason(Strings.emptyToNull(val$cancellationOption.getId())).build());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.passenger.PassengerRideService.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */