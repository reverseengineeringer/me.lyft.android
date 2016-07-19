package me.lyft.android.jobs;

import com.lyft.android.api.dto.RideDTO;
import com.lyft.android.api.dto.RideUserDTO;
import com.lyft.android.api.dto.RouteDTO;
import com.lyft.android.api.dto.StopDTO;
import com.lyft.android.api.dto.UniversalDTO;
import com.lyft.android.api.dto.UserDTO;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.LyftApplication;
import me.lyft.android.RideFlags;
import me.lyft.android.common.Iterables;
import me.lyft.android.common.Objects;
import me.lyft.android.common.Strings;
import me.lyft.android.domain.location.LocationMapper;
import me.lyft.android.driver.notifications.IDriverNotificationService;
import me.lyft.android.infrastructure.foreground.IAppForegroundDetector;
import rx.functions.Func1;
import rx.functions.Func2;

public class CourierDriverRideUpdatedJob
  implements Job
{
  @Inject
  IAppForegroundDetector appForegroundDetector;
  @Inject
  LyftApplication application;
  private final UniversalDTO currentAppState;
  private final List<RideUserDTO> currentPassengers;
  private final RideDTO currentRide;
  private final RouteDTO currentRoute;
  @Inject
  IDriverNotificationService driverNotificationService;
  @Inject
  ILyftPreferences lyftPreferences;
  private final UniversalDTO previousAppState;
  private final List<RideUserDTO> previousPassengers;
  private final RouteDTO previousRoute;
  
  public CourierDriverRideUpdatedJob(UniversalDTO paramUniversalDTO1, UniversalDTO paramUniversalDTO2)
  {
    previousAppState = paramUniversalDTO1;
    currentAppState = paramUniversalDTO2;
    if (ride == null)
    {
      paramUniversalDTO1 = null;
      previousRoute = paramUniversalDTO1;
      previousPassengers = getPreviousPassengers();
      currentRide = ride;
      if (currentRide != null) {
        break label80;
      }
    }
    label80:
    for (paramUniversalDTO1 = (UniversalDTO)localObject;; paramUniversalDTO1 = currentRide.route)
    {
      currentRoute = paramUniversalDTO1;
      currentPassengers = getCurrentPassengers();
      return;
      paramUniversalDTO1 = ride.route;
      break;
    }
  }
  
  private String getCurrentActor()
  {
    if (currentRide == null) {
      return null;
    }
    return currentRide.actor;
  }
  
  private List<RideUserDTO> getCurrentPassengers()
  {
    if ((currentRide == null) || (currentRide.route == null) || (currentRide.route.passengers == null)) {
      return Collections.emptyList();
    }
    return currentRide.route.passengers;
  }
  
  private String getCurrentRideType()
  {
    if (currentRide == null) {
      return null;
    }
    return currentRide.rideTypePublicId;
  }
  
  private String getCurrentStatus()
  {
    if (currentRide == null) {
      return null;
    }
    return currentRide.status;
  }
  
  private StopDTO getCurrentStop(RouteDTO paramRouteDTO)
  {
    if (paramRouteDTO != null)
    {
      paramRouteDTO = ((List)Objects.firstNonNull(stops, Collections.emptyList())).iterator();
      while (paramRouteDTO.hasNext())
      {
        StopDTO localStopDTO = (StopDTO)paramRouteDTO.next();
        if (!((Boolean)Objects.firstNonNull(completed, Boolean.valueOf(false))).booleanValue()) {
          return localStopDTO;
        }
      }
    }
    return new StopDTO(null, null, null, null, null, null, null);
  }
  
  private Set<String> getPassengerIds(List<RideUserDTO> paramList)
  {
    (Set)Iterables.aggregate(Iterables.map(paramList, new Func1()
    {
      public String call(RideUserDTO paramAnonymousRideUserDTO)
      {
        return id;
      }
    }), new HashSet(), new Func2()
    {
      public HashSet<String> call(HashSet<String> paramAnonymousHashSet, String paramAnonymousString)
      {
        paramAnonymousHashSet.add(paramAnonymousString);
        return paramAnonymousHashSet;
      }
    });
  }
  
  private List<RideUserDTO> getPreviousPassengers()
  {
    if ((previousRoute == null) || (previousRoute.passengers == null)) {
      return Collections.emptyList();
    }
    return previousRoute.passengers;
  }
  
  private String getUserId()
  {
    if (currentAppState.user == null) {
      return null;
    }
    return currentAppState.user.id;
  }
  
  private String getUserMode()
  {
    if (currentAppState.user == null) {
      return null;
    }
    return currentAppState.user.mode;
  }
  
  private boolean isNewPassengerAdded()
  {
    Set localSet1 = getPassengerIds(previousPassengers);
    Set localSet2 = getPassengerIds(currentPassengers);
    return localSet1.size() < localSet2.size();
  }
  
  private void setRideFlags()
  {
    RideFlags localRideFlags = lyftPreferences.getRideFlags();
    String str = getCurrentStatus();
    if (("accepted".equalsIgnoreCase(str)) || ("approaching".equalsIgnoreCase(str)) || ("arrived".equalsIgnoreCase(str))) {
      localRideFlags.setPickupMessageShown(true);
    }
    for (;;)
    {
      lyftPreferences.setRideFlags(localRideFlags);
      return;
      localRideFlags.setDropoffMessageShown(true);
    }
  }
  
  private boolean shouldDisplayCourierRouteChanged()
  {
    return (Arrays.asList(new String[] { "accepted", "approaching", "arrived", "pickedUp", "droppedOff" }).contains(getCurrentStatus())) && (!Strings.equalsIgnoreCase(getUserId(), getCurrentActor())) && (shouldReroute());
  }
  
  private boolean shouldReroute()
  {
    StopDTO localStopDTO1 = getCurrentStop(previousRoute);
    StopDTO localStopDTO2 = getCurrentStop(currentRoute);
    Set localSet1 = getPassengerIds(previousPassengers);
    Set localSet2 = getPassengerIds(currentPassengers);
    return (!Objects.equals(passengerId, passengerId)) && (!Objects.equals(localSet1, localSet2));
  }
  
  public void execute()
    throws Throwable
  {
    if ((!"driver".equalsIgnoreCase(getUserMode())) || (!"lyft_line".equalsIgnoreCase(getCurrentRideType())) || (previousAppState.ride == null)) {}
    do
    {
      do
      {
        return;
        if (!shouldDisplayCourierRouteChanged()) {
          break;
        }
        driverNotificationService.courierRouteChanged(LocationMapper.fromPlaceDTO(getCurrentStopcurrentRoute).location));
      } while (appForegroundDetector.isForegrounded());
      setRideFlags();
      return;
    } while (!isNewPassengerAdded());
    driverNotificationService.newPassengerAdded();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.jobs.CourierDriverRideUpdatedJob
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */