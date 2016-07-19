package me.lyft.android;

import com.lyft.android.api.dto.RideDTO;
import com.lyft.android.api.dto.UniversalDTO;
import me.lyft.android.infrastructure.lyft.IAppStateHandler;

public class AppStateHandler
  implements IAppStateHandler
{
  private final UserSession userSession;
  
  AppStateHandler(IUserSession paramIUserSession)
  {
    userSession = ((UserSession)paramIUserSession);
  }
  
  public void setAppState(UniversalDTO paramUniversalDTO)
  {
    userSession.setAppState(paramUniversalDTO);
  }
  
  public void setRide(Long paramLong, RideDTO paramRideDTO)
  {
    if ((paramLong == null) || (paramRideDTO == null)) {}
    UniversalDTO localUniversalDTO;
    do
    {
      return;
      localUniversalDTO = userSession.getAppState();
    } while (localUniversalDTO == null);
    paramLong = new UniversalDTO(paramLong, paramLong, user, paramRideDTO, appInfo, banners, rideTypes, contributorRequests, prefillLocations);
    userSession.setAppState(paramLong);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.AppStateHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */