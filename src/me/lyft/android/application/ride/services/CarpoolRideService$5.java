package me.lyft.android.application.ride.services;

import com.lyft.android.api.dto.CarpoolRideDeclineRequestDTOBuilder;
import com.lyft.android.api.dto.UniversalDTO;
import java.util.List;
import me.lyft.android.domain.location.Location;
import me.lyft.android.domain.ride.CancellationOption;
import me.lyft.android.infrastructure.lyft.ILyftApi;
import rx.Observable;
import rx.functions.Func1;

class CarpoolRideService$5
  implements Func1<Location, Observable<UniversalDTO>>
{
  CarpoolRideService$5(CarpoolRideService paramCarpoolRideService, List paramList, CancellationOption paramCancellationOption) {}
  
  public Observable<UniversalDTO> call(Location paramLocation)
  {
    paramLocation = new CarpoolRideDeclineRequestDTOBuilder().withIds(val$rideIds).withReason(val$cancellationOption.getId()).withLat(Double.valueOf(paramLocation.getLat())).withLng(Double.valueOf(paramLocation.getLng())).build();
    return CarpoolRideService.access$100(this$0).declineCarpoolRides(paramLocation);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ride.services.CarpoolRideService.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */