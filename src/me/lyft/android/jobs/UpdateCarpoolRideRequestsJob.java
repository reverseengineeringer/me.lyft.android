package me.lyft.android.jobs;

import com.lyft.android.api.dto.RideDTO;
import com.lyft.android.api.dto.UniversalDTO;
import com.lyft.android.api.dto.UserDTO;
import javax.inject.Inject;
import me.lyft.android.application.ride.services.ICarpoolRideService;
import me.lyft.android.common.Strings;

public class UpdateCarpoolRideRequestsJob
  implements Job
{
  @Inject
  ICarpoolRideService carpoolRideService;
  private final UniversalDTO currentAppState;
  private final UniversalDTO previousAppState;
  
  public UpdateCarpoolRideRequestsJob(UniversalDTO paramUniversalDTO1, UniversalDTO paramUniversalDTO2)
  {
    previousAppState = paramUniversalDTO1;
    currentAppState = paramUniversalDTO2;
  }
  
  private static boolean isCarpoolDriverRide(RideDTO paramRideDTO)
  {
    return (paramRideDTO != null) && (Strings.equalsIgnoreCase(userMode, "driver"));
  }
  
  private boolean isNewRide()
  {
    return (previousAppState == null) || (previousAppState.ride == null) || (!previousAppState.ride.id.equals(currentAppState.ride.id));
  }
  
  private static boolean isPendingCarpoolRide(RideDTO paramRideDTO)
  {
    return (paramRideDTO != null) && ("lyft_carpool".equals(rideTypePublicId)) && ("pending".equals(status));
  }
  
  public void execute()
    throws Throwable
  {
    if (currentAppState == null) {}
    do
    {
      return;
      if ((isPendingCarpoolRide(currentAppState.ride)) && (isNewRide()) && (isCarpoolDriverRide(currentAppState.ride)))
      {
        carpoolRideService.updateCarpoolRidesSync(currentAppState.user.id);
        return;
      }
    } while ((previousAppState == null) || (!isPendingCarpoolRide(previousAppState.ride)) || (isPendingCarpoolRide(currentAppState.ride)));
    carpoolRideService.clearRides();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.jobs.UpdateCarpoolRideRequestsJob
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */