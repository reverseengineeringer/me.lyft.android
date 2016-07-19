package me.lyft.android.jobs;

import com.lyft.android.api.dto.UniversalDTO;
import com.lyft.android.api.dto.UserDTO;
import javax.inject.Inject;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.application.requestridetypes.IRequestRideTypeService;
import me.lyft.android.application.ride.IRideRequestSession;
import me.lyft.android.navigation.NavigationSettings;

public class UserModeChangeJob
  implements Job
{
  private final UniversalDTO currentAppState;
  @Inject
  NavigationSettings navigationSettings;
  @Inject
  ILyftPreferences preferences;
  private UniversalDTO previousAppState;
  @Inject
  IRequestRideTypeService requestRideTypeProvider;
  @Inject
  IRideRequestSession rideRequestSession;
  
  public UserModeChangeJob(UniversalDTO paramUniversalDTO1, UniversalDTO paramUniversalDTO2)
  {
    previousAppState = paramUniversalDTO1;
    currentAppState = paramUniversalDTO2;
  }
  
  private boolean changedToDriver()
  {
    return ("passenger".equalsIgnoreCase(getPreviousUserMode())) && ("driver".equalsIgnoreCase(getCurrentUserMode()));
  }
  
  private boolean changedToPassenger()
  {
    return ("driver".equalsIgnoreCase(getPreviousUserMode())) && ("passenger".equalsIgnoreCase(getCurrentUserMode()));
  }
  
  private String getCurrentUserMode()
  {
    if (currentAppState.user == null) {
      return null;
    }
    return currentAppState.user.mode;
  }
  
  private String getPreviousUserMode()
  {
    if (previousAppState.user == null) {
      return null;
    }
    return previousAppState.user.mode;
  }
  
  public void execute()
    throws Throwable
  {
    if (changedToDriver()) {
      preferences.clearRideRequest();
    }
    while (!changedToPassenger()) {
      return;
    }
    rideRequestSession.resetCurrentRideType();
    preferences.clearRideRequest();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.jobs.UserModeChangeJob
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */