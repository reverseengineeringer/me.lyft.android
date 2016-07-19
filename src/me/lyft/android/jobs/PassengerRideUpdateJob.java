package me.lyft.android.jobs;

import com.lyft.android.api.dto.RideDTO;
import com.lyft.android.api.dto.UniversalDTO;
import com.lyft.android.api.dto.UserDTO;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;
import me.lyft.android.application.passenger.IPassengerRideProvider;
import me.lyft.android.application.passenger.IPassengerRideService;
import me.lyft.android.application.ride.ICancellationOptionsProvider;
import me.lyft.android.common.Objects;
import me.lyft.android.domain.passenger.ride.PassengerRide;
import me.lyft.android.domain.passenger.ride.PassengerRideMapper;
import me.lyft.android.logging.L;

public class PassengerRideUpdateJob
  implements Job
{
  @Inject
  ICancellationOptionsProvider cancellationOptionsProvider;
  private final UniversalDTO currentAppState;
  @Inject
  IPassengerRideProvider passengerRideProvider;
  @Inject
  IPassengerRideService passengerRideService;
  
  public PassengerRideUpdateJob(UniversalDTO paramUniversalDTO)
  {
    currentAppState = paramUniversalDTO;
  }
  
  private String getUserMode()
  {
    if (currentAppState.user == null) {
      return null;
    }
    return currentAppState.user.mode;
  }
  
  private boolean isPassenger()
  {
    return "passenger".equalsIgnoreCase(getUserMode());
  }
  
  public void execute()
    throws Throwable
  {
    cancellationOptionsProvider.updateCancellationOptions(getCancellationStatus());
    if (!isPassenger()) {}
    for (;;)
    {
      return;
      try
      {
        long l = ((Long)Objects.firstNonNull(currentAppState.preDispatchTimestamp, Objects.firstNonNull(currentAppState.timestamp, Long.valueOf(0L)))).longValue();
        if (l > passengerRideProvider.getPassengerRide().getTimestamp())
        {
          PassengerRide localPassengerRide = PassengerRideMapper.createPassengerRide(currentAppState.ride, currentAppState.user, Long.valueOf(l));
          passengerRideService.updatePassengerRide(localPassengerRide);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        L.e(localThrowable, "ride mapping failed", new Object[0]);
      }
    }
  }
  
  public List<String> getCancellationStatus()
  {
    if (currentAppState.ride == null) {
      return Collections.emptyList();
    }
    return (List)Objects.firstNonNull(currentAppState.ride.cancelationStatuses, Collections.emptyList());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.jobs.PassengerRideUpdateJob
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */