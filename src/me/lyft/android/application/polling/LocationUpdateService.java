package me.lyft.android.application.polling;

import com.lyft.android.api.dto.DeprecatedPlaceDTO;
import com.lyft.android.api.dto.LocationDTO;
import com.lyft.android.api.dto.UpdateLocationRequestDTO;
import com.lyft.android.api.dto.UpdateUserLocationRequestDTO;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import me.lyft.android.application.IAppInfoService;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.application.geo.IEtaAnalyticService;
import me.lyft.android.application.passenger.IPassengerRideProvider;
import me.lyft.android.application.ride.IDriverRideProvider;
import me.lyft.android.application.ride.IRideRequestSession;
import me.lyft.android.common.Unit;
import me.lyft.android.domain.User;
import me.lyft.android.domain.driver.ride.DriverRide;
import me.lyft.android.domain.location.Location;
import me.lyft.android.domain.location.LocationMapper;
import me.lyft.android.domain.passenger.ride.PassengerRide;
import me.lyft.android.domain.passenger.ridetypes.RequestRideType;
import me.lyft.android.domain.ride.RideStatus;
import me.lyft.android.domain.ride.RideType;
import me.lyft.android.infrastructure.foreground.IAppForegroundDetector;
import me.lyft.android.infrastructure.location.ILocationService;
import me.lyft.android.infrastructure.lyft.ILyftApi;
import me.lyft.android.infrastructure.lyft.LocationHistory;
import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Subscriber;
import rx.schedulers.Schedulers;

public class LocationUpdateService
  implements ILocationUpdateService
{
  private static final int MAX_STORED_LOCATION_SIZE = 240;
  private static final long MIN_LOCATION_TIME_UPDATE = TimeUnit.SECONDS.toMillis(1L);
  private final IAppForegroundDetector appForegroundDetector;
  private final IAppInfoService appInfoService;
  private Location currentBestLocation;
  private final IDriverRideProvider driverRideProvider;
  private final IEtaAnalyticService etaAnalyticService;
  private final LocationAnalytics locationAnalytics;
  private final ILocationService locationService;
  private final LocationHistory locationsHistory = new LocationHistory(240);
  private final ILyftApi lyftApi;
  private final IPassengerRideProvider passengerRideProvider;
  private final IRideRequestSession rideRequestSession;
  private final IUserProvider userProvider;
  
  public LocationUpdateService(ILocationService paramILocationService, IAppForegroundDetector paramIAppForegroundDetector, IRideRequestSession paramIRideRequestSession, IEtaAnalyticService paramIEtaAnalyticService, ILyftApi paramILyftApi, IAppInfoService paramIAppInfoService, IUserProvider paramIUserProvider, IDriverRideProvider paramIDriverRideProvider, IPassengerRideProvider paramIPassengerRideProvider, LocationAnalytics paramLocationAnalytics)
  {
    locationService = paramILocationService;
    appForegroundDetector = paramIAppForegroundDetector;
    rideRequestSession = paramIRideRequestSession;
    etaAnalyticService = paramIEtaAnalyticService;
    lyftApi = paramILyftApi;
    appInfoService = paramIAppInfoService;
    userProvider = paramIUserProvider;
    driverRideProvider = paramIDriverRideProvider;
    passengerRideProvider = paramIPassengerRideProvider;
    locationAnalytics = paramLocationAnalytics;
  }
  
  private UpdateUserLocationRequestDTO getUpdateUserLocationRequestDTO(Location paramLocation, List<LocationDTO> paramList)
  {
    if (userProvider.getUser().isDispatchable())
    {
      localObject = driverRideProvider.getDriverRide();
      if (((DriverRide)localObject).isInProgress())
      {
        if (paramList.isEmpty()) {}
        for (paramLocation = null;; paramLocation = paramList) {
          return new UpdateUserLocationRequestDTO(paramLocation, null, null, ((DriverRide)localObject).getType().getType(), appInfoService.getAppInfoRevision(), ((DriverRide)localObject).getCurrentRideId());
        }
      }
      DeprecatedPlaceDTO localDeprecatedPlaceDTO;
      label111:
      String str;
      if (paramList.isEmpty())
      {
        paramList = null;
        localDeprecatedPlaceDTO = LocationMapper.toDeprecatedPlaceDTO(paramLocation);
        if (!((DriverRide)localObject).isPending()) {
          break label153;
        }
        paramLocation = ((DriverRide)localObject).getType().getType();
        str = appInfoService.getAppInfoRevision();
        if (!((DriverRide)localObject).isPending()) {
          break label169;
        }
      }
      label153:
      label169:
      for (localObject = ((DriverRide)localObject).getCurrentRideId();; localObject = null)
      {
        return new UpdateUserLocationRequestDTO(paramList, localDeprecatedPlaceDTO, null, paramLocation, str, (String)localObject);
        break;
        paramLocation = rideRequestSession.getCurrentRideType().getPublicId();
        break label111;
      }
    }
    Object localObject = passengerRideProvider.getPassengerRide();
    if (((PassengerRide)localObject).isInProgress())
    {
      if (paramList.isEmpty()) {}
      for (paramLocation = null;; paramLocation = paramList) {
        return new UpdateUserLocationRequestDTO(paramLocation, null, null, ((PassengerRide)localObject).getRideType().getType(), appInfoService.getAppInfoRevision(), ((PassengerRide)localObject).getId());
      }
    }
    localObject = rideRequestSession.getPickupLocation();
    if (((Location)localObject).isNull())
    {
      paramLocation = LocationMapper.toDeprecatedPlaceDTO(paramLocation);
      localObject = LocationMapper.toDeprecatedPlaceDTO(rideRequestSession.getDropoffLocation());
      if (!paramList.isEmpty()) {
        break label325;
      }
      paramList = null;
    }
    label325:
    for (;;)
    {
      return new UpdateUserLocationRequestDTO(paramList, paramLocation, (DeprecatedPlaceDTO)localObject, rideRequestSession.getCurrentRideType().getPublicId(), appInfoService.getAppInfoRevision(), null);
      paramLocation = LocationMapper.toDeprecatedPlaceDTO((Location)localObject);
      break;
    }
  }
  
  private boolean shouldIgnoreLocationUpdate(Location paramLocation1, Location paramLocation2)
  {
    if (paramLocation2.isNull()) {}
    do
    {
      return true;
      if (paramLocation1 == null) {
        break;
      }
    } while (Math.abs(paramLocation1.getTime().longValue() - paramLocation2.getTime().longValue()) < MIN_LOCATION_TIME_UPDATE);
    return false;
    return false;
  }
  
  public void addLocationToHistory(Location paramLocation)
  {
    String str2 = null;
    DriverRide localDriverRide;
    String str1;
    if (!shouldIgnoreLocationUpdate(currentBestLocation, paramLocation))
    {
      currentBestLocation = paramLocation;
      if (userProvider.getUser().isDispatchable())
      {
        localDriverRide = driverRideProvider.getDriverRide();
        if (!localDriverRide.isNull()) {
          break label101;
        }
        str1 = null;
        if (!localDriverRide.isNull()) {
          break label110;
        }
      }
    }
    for (;;)
    {
      paramLocation = LocationMapper.toLocationDTO(paramLocation, str1, str2, appForegroundDetector.isForegrounded(), etaAnalyticService.getRecord());
      if (paramLocation != null) {
        locationsHistory.add(paramLocation);
      }
      return;
      label101:
      str1 = localDriverRide.getCurrentRideId();
      break;
      label110:
      str2 = localDriverRide.getStatus().toString();
    }
  }
  
  public Observable<Unit> updateCoarseLocation(Location paramLocation)
  {
    if (appForegroundDetector.isForegrounded()) {}
    for (String str = "significant_location_change_fg";; str = "significant_location_change_bg")
    {
      paramLocation = new UpdateLocationRequestDTO(Collections.singletonList(LocationMapper.toLocationDTO(paramLocation, str)));
      return lyftApi.updateCoarseLocation(paramLocation);
    }
  }
  
  public Observable<Unit> updateLocation()
  {
    Observable.create(new Observable.OnSubscribe()
    {
      public void call(Subscriber<? super Unit> paramAnonymousSubscriber)
      {
        try
        {
          updateLocationSync();
          paramAnonymousSubscriber.onNext(Unit.create());
          paramAnonymousSubscriber.onCompleted();
          return;
        }
        catch (Throwable localThrowable)
        {
          paramAnonymousSubscriber.onError(localThrowable);
        }
      }
    }).subscribeOn(Schedulers.io());
  }
  
  public void updateLocationSync()
    throws Throwable
  {
    Object localObject2 = null;
    if (userProvider.getUser().isNull()) {
      return;
    }
    Location localLocation = locationService.getLastCachedLocation();
    ArrayList localArrayList = new ArrayList();
    if (userProvider.getUser().isDispatchable())
    {
      localObject1 = locationsHistory.getCopy();
      locationAnalytics.initializeUluRequest();
      localObject2 = getUpdateUserLocationRequestDTO(localLocation, (List)localObject1);
    }
    try
    {
      lyftApi.updateLocationSync(userProvider.getUser().getId(), (UpdateUserLocationRequestDTO)localObject2);
      locationAnalytics.trackUluSuccess(((List)localObject1).size());
      locationsHistory.removeAll((Collection)localObject1);
      return;
    }
    catch (Throwable localThrowable)
    {
      PassengerRide localPassengerRide;
      locationAnalytics.trackUluFailure(((List)localObject1).size());
      throw localThrowable;
    }
    localPassengerRide = passengerRideProvider.getPassengerRide();
    if (localPassengerRide.isNull())
    {
      localObject1 = null;
      label141:
      if (!localPassengerRide.isNull()) {
        break label203;
      }
    }
    for (;;)
    {
      localObject2 = LocationMapper.toLocationDTO(localLocation, (String)localObject1, (String)localObject2, appForegroundDetector.isForegrounded(), etaAnalyticService.getRecord());
      localObject1 = localArrayList;
      if (localObject2 == null) {
        break;
      }
      localArrayList.add(localObject2);
      localObject1 = localArrayList;
      break;
      localObject1 = localPassengerRide.getId();
      break label141;
      label203:
      localObject2 = localPassengerRide.getStatus().toString();
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.polling.LocationUpdateService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */