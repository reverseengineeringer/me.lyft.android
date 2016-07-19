package me.lyft.android.jobs;

import com.lyft.android.api.dto.RideDTO;
import javax.inject.Inject;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.common.Objects;

public class RideAssignedJob
  implements Job
{
  private final RideDTO currentRide;
  @Inject
  ILyftPreferences preferences;
  private final RideDTO previousRide;
  
  public RideAssignedJob(RideDTO paramRideDTO1, RideDTO paramRideDTO2)
  {
    previousRide = paramRideDTO1;
    currentRide = paramRideDTO2;
  }
  
  public void execute()
    throws Throwable
  {
    Object localObject1;
    if (previousRide == null)
    {
      localObject1 = null;
      if (currentRide != null) {
        break label55;
      }
    }
    label55:
    for (Object localObject2 = null;; localObject2 = (String)Objects.firstNonNull(currentRide.id, ""))
    {
      if (!Objects.equals(localObject1, localObject2)) {
        preferences.resetRideFlags();
      }
      return;
      localObject1 = (String)Objects.firstNonNull(previousRide.id, "");
      break;
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.jobs.RideAssignedJob
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */