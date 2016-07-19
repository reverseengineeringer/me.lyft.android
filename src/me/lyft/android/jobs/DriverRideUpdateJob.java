package me.lyft.android.jobs;

import com.lyft.android.api.dto.RideDTO;
import com.lyft.android.api.dto.UniversalDTO;
import com.lyft.android.api.dto.UserDTO;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import me.lyft.android.application.features.IFeaturesProvider;
import me.lyft.android.application.ride.IDriverRideProvider;
import me.lyft.android.common.Iterables;
import me.lyft.android.common.Objects;
import me.lyft.android.domain.driver.ride.DriverRide;
import me.lyft.android.domain.driver.ride.DriverRideMapper;
import me.lyft.android.domain.driver.ride.DriverRidePassenger;
import me.lyft.android.domain.driver.ride.DriverStop;
import me.lyft.android.domain.driver.ride.Route;
import me.lyft.android.driver.notifications.IDriverNotificationService;

public class DriverRideUpdateJob
  implements Job
{
  @Inject
  IDriverNotificationService driverNotificationService;
  @Inject
  IDriverRideProvider driverRideProvider;
  @Inject
  IFeaturesProvider featuresProvider;
  private UniversalDTO universalDTO;
  
  public DriverRideUpdateJob(UniversalDTO paramUniversalDTO)
  {
    universalDTO = paramUniversalDTO;
  }
  
  private List<DriverRidePassenger> getNewPassengers(DriverRide paramDriverRide1, DriverRide paramDriverRide2)
  {
    if (paramDriverRide1.isNull())
    {
      paramDriverRide1 = Collections.emptyList();
      return paramDriverRide1;
    }
    paramDriverRide1 = paramDriverRide1.getQueuedRoutes();
    Object localObject = paramDriverRide2.getQueuedRoutes();
    paramDriverRide2 = new ArrayList();
    localObject = Iterables.skip((Iterable)localObject, paramDriverRide1.size()).iterator();
    for (;;)
    {
      paramDriverRide1 = paramDriverRide2;
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      paramDriverRide2.addAll(((Route)((Iterator)localObject).next()).getPassengers());
    }
  }
  
  private String getUserMode()
  {
    if (universalDTO.user == null) {
      return null;
    }
    return universalDTO.user.mode;
  }
  
  private static boolean isCarpoolDriver(RideDTO paramRideDTO)
  {
    return (paramRideDTO != null) && (Objects.equals(rideTypePublicId, "lyft_carpool")) && (Objects.equals(userMode, "driver"));
  }
  
  private boolean isDriver()
  {
    return "driver".equalsIgnoreCase(getUserMode());
  }
  
  public void execute()
    throws Throwable
  {
    if (universalDTO == null) {}
    do
    {
      return;
      boolean bool = isCarpoolDriver(universalDTO.ride);
      if ((!isDriver()) && (!bool))
      {
        driverRideProvider.updateRide(DriverRide.empty());
        return;
      }
      localObject = universalDTO.ride;
    } while (driverRideProvider.shouldIgnoreRide((RideDTO)localObject));
    Object localObject = DriverRideMapper.createDriverRide((RideDTO)localObject, universalDTO.user.id);
    DriverRide localDriverRide = driverRideProvider.getDriverRide();
    List localList = getNewPassengers(localDriverRide, (DriverRide)localObject);
    int i;
    if (!localList.isEmpty())
    {
      i = 1;
      if (i == 0) {
        break label142;
      }
      driverNotificationService.newQueuedRoute(localList);
    }
    for (;;)
    {
      driverRideProvider.updateRide((DriverRide)localObject);
      return;
      i = 0;
      break;
      label142:
      if (localDriverRide.hasPickupChanged((DriverRide)localObject)) {
        driverNotificationService.pickupChanged(((DriverRide)localObject).getCurrentStop().getLocation());
      } else if (localDriverRide.hasDropoffChanged((DriverRide)localObject)) {
        driverNotificationService.destinationChanged(((DriverRide)localObject).getCurrentStop().getLocation());
      }
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.jobs.DriverRideUpdateJob
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */