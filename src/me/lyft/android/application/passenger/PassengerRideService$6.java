package me.lyft.android.application.passenger;

import com.lyft.android.api.dto.PickupGeofenceDTO;
import me.lyft.android.domain.passenger.ride.PickupGeofence;
import me.lyft.android.domain.passenger.ride.PickupGeofenceMapper;
import me.lyft.android.rx.AsyncCall;

class PassengerRideService$6
  extends AsyncCall<PickupGeofenceDTO>
{
  PassengerRideService$6(PassengerRideService paramPassengerRideService, String paramString) {}
  
  public void onFail(Throwable paramThrowable)
  {
    PassengerRideService.access$500(this$0).updatePickupGeofence(PickupGeofence.empty());
  }
  
  public void onSuccess(PickupGeofenceDTO paramPickupGeofenceDTO)
  {
    PassengerRideService.access$500(this$0).updatePickupGeofence(PickupGeofenceMapper.from(paramPickupGeofenceDTO, val$passengerRideId));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.passenger.PassengerRideService.6
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */