package me.lyft.android.domain.passenger.ride;

import com.lyft.android.api.dto.RideDTO;
import com.lyft.android.api.dto.RideRequestDetailsDTO;
import com.lyft.android.api.dto.RideUserDTO;
import com.lyft.android.api.dto.RouteDTO;
import com.lyft.android.api.dto.StopDTO;
import com.lyft.android.api.dto.UserDTO;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import me.lyft.android.common.Enums;
import me.lyft.android.common.Objects;
import me.lyft.android.domain.location.LocationMapper;
import me.lyft.android.domain.ride.RideStatus;
import me.lyft.android.domain.ride.RideStatusMapper;
import me.lyft.android.domain.ride.RideType;
import me.lyft.android.domain.ride.ScheduledIntervalMapper;
import me.lyft.android.domain.time.Time;

public class PassengerRideMapper
{
  private static final List<String> CANCELED_OPTIONS = Arrays.asList(new String[] { "canceled", "canceledNoShow", "canceledWithPenalty", "canceledWrongPartySize" });
  private static final String USER_MODE_DRIVER = "driver";
  
  static Time createDriverWaitTime(RideDTO paramRideDTO, RideStatus paramRideStatus)
  {
    if ((driverWaitSeconds != null) && (statusTimestamp != null)) {
      return new Time(TimeUnit.SECONDS.toMillis(statusTimestamp.longValue() + driverWaitSeconds.intValue()), timezone);
    }
    return Time.empty();
  }
  
  public static PassengerRide createPassengerRide(RideDTO paramRideDTO, UserDTO paramUserDTO, Long paramLong)
  {
    if ((paramRideDTO == null) || (paramUserDTO == null) || (isCarpoolDriver(paramRideDTO))) {
      return PassengerRide.empty();
    }
    RideStatus localRideStatus = RideStatusMapper.fromRideStatus(paramRideDTO, CANCELED_OPTIONS);
    RideType localRideType = RideType.getInstance(rideTypePublicId);
    Object localObject1 = createPassengers(paramUserDTO, paramRideDTO);
    paramUserDTO = createStops((List)localObject1, paramRideDTO);
    List localList = filterDroppedOffPassengers((List)localObject1, paramUserDTO);
    PassengerStops localPassengerStops = new PassengerStops(paramUserDTO);
    int i = ((Integer)Objects.firstNonNull(waitEstimateInSec, Integer.valueOf(0))).intValue();
    String str2;
    Object localObject2;
    String str1;
    label155:
    int j;
    boolean bool2;
    boolean bool3;
    if (matchByTimestampMs == null)
    {
      paramUserDTO = Time.empty();
      str2 = (String)Objects.firstNonNull(icon, "");
      bool1 = localRideStatus.isAcknowledged();
      localObject2 = driverStatus;
      str1 = (String)Objects.firstNonNull(id, "");
      if (route == null) {
        break label342;
      }
      localObject1 = route.driver;
      localObject1 = DriverMapper.createDriver((RideUserDTO)localObject1, str2, bool1, (String)localObject2);
      j = ((Integer)Objects.firstNonNull(cancelPenalty, Integer.valueOf(0))).intValue();
      bool2 = ((Boolean)Objects.firstNonNull(hideCurrentLocationMarker, Boolean.FALSE)).booleanValue();
      str2 = cancelSubtitleTextNoChargeOverride;
      localObject2 = Enums.asList(RideFeature.class, features);
      bool3 = ((Boolean)Objects.firstNonNull(isPickupEditable, Boolean.valueOf(false))).booleanValue();
      if (localRideType.isCarpool()) {
        break label348;
      }
    }
    label342:
    label348:
    for (boolean bool1 = true;; bool1 = false)
    {
      return new PassengerRide(str1, (Driver)localObject1, localRideType, localRideStatus, localPassengerStops, localList, j, bool2, i, str2, (List)localObject2, bool3, bool1, ((Boolean)Objects.firstNonNull(isEditPickupTooltipVisible, Boolean.valueOf(false))).booleanValue(), isQueued(route), paramUserDTO, createDriverWaitTime(paramRideDTO, localRideStatus), paramLong.longValue());
      paramUserDTO = new Time(matchByTimestampMs.longValue(), timezone);
      break;
      localObject1 = null;
      break label155;
    }
  }
  
  private static List<PassengerRidePassenger> createPassengers(UserDTO paramUserDTO, RideDTO paramRideDTO)
  {
    if ((route != null) && (route.passengers != null)) {}
    ArrayList localArrayList;
    for (paramRideDTO = route.passengers;; paramRideDTO = Collections.emptyList())
    {
      localArrayList = new ArrayList();
      paramRideDTO = paramRideDTO.iterator();
      while (paramRideDTO.hasNext())
      {
        RideUserDTO localRideUserDTO = (RideUserDTO)paramRideDTO.next();
        localArrayList.add(new PassengerRidePassenger(id, Objects.equals(id, id), firstName, userPhoto, ((Integer)Objects.firstNonNull(partySize, Integer.valueOf(0))).intValue()));
      }
    }
    return localArrayList;
  }
  
  private static List<PassengerStop> createStops(List<PassengerRidePassenger> paramList, RideDTO paramRideDTO)
  {
    return createStopsFromRoute(paramRideDTO, paramList);
  }
  
  private static List<PassengerStop> createStopsFromRoute(RideDTO paramRideDTO, List<PassengerRidePassenger> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((route != null) && (route.stops != null)) {}
    for (Object localObject = route.stops;; localObject = Collections.emptyList())
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        StopDTO localStopDTO = (StopDTO)((Iterator)localObject).next();
        localArrayList.add(PassengerStopMapper.fromStopDTO(localStopDTO, findPassengerById((String)Objects.firstNonNull(passengerId, ""), paramList), timezone));
      }
    }
    return localArrayList;
  }
  
  private static PassengerStops extractPassengerStops(RideRequestDetailsDTO paramRideRequestDetailsDTO)
  {
    ArrayList localArrayList = new ArrayList(2);
    localArrayList.add(new PassengerStop(PassengerRidePassenger.emptySelf(), LocationMapper.fromPlaceDTOV2(origin), PassengerStop.Type.PICKUP, false, ScheduledIntervalMapper.fromTimeRangeDTO(pickup_time_range, timezone, 0L)));
    localArrayList.add(new PassengerStop(PassengerRidePassenger.emptySelf(), LocationMapper.fromPlaceDTOV2(destination), PassengerStop.Type.DROPOFF, false, ScheduledIntervalMapper.fromTimeRangeDTO(dropoff_time_range, timezone, 0L)));
    return new PassengerStops(localArrayList);
  }
  
  private static List<PassengerRidePassenger> filterDroppedOffPassengers(List<PassengerRidePassenger> paramList, List<PassengerStop> paramList1)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(paramList);
    paramList = paramList1.iterator();
    while (paramList.hasNext())
    {
      paramList1 = (PassengerStop)paramList.next();
      if ((paramList1.isCompleted()) && (paramList1.isDropOff()) && (!paramList1.getPassenger().isSelf())) {
        localArrayList.remove(paramList1.getPassenger());
      }
    }
    return localArrayList;
  }
  
  private static PassengerRidePassenger findPassengerById(String paramString, List<PassengerRidePassenger> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      PassengerRidePassenger localPassengerRidePassenger = (PassengerRidePassenger)paramList.next();
      if (Objects.equals(paramString, localPassengerRidePassenger.getId())) {
        return localPassengerRidePassenger;
      }
    }
    return PassengerRidePassenger.empty();
  }
  
  public static PassengerRide fromRideRequestDetailsDTO(RideRequestDetailsDTO paramRideRequestDetailsDTO)
  {
    return new PassengerRide(ride_id, Driver.empty(), RideType.getInstance(ride_type), RideStatusMapper.fromRideStatus(status, Long.valueOf(0L), Collections.emptyList()), extractPassengerStops(paramRideRequestDetailsDTO), Collections.emptyList(), 0, false, ((Integer)Objects.firstNonNull(wait_estimate_seconds, Integer.valueOf(0))).intValue(), "", Enums.asList(RideFeature.class, features), false, false, false, false, Time.empty(), Time.empty(), ((Long)Objects.firstNonNull(generated_at_ms, Long.valueOf(0L))).longValue());
  }
  
  private static boolean isCarpoolDriver(RideDTO paramRideDTO)
  {
    return (Objects.equals(rideTypePublicId, "lyft_carpool")) && (Objects.equals(userMode, "driver"));
  }
  
  private static boolean isQueued(RouteDTO paramRouteDTO)
  {
    return (paramRouteDTO != null) && (isQueuedRoute != null) && (isQueuedRoute.booleanValue());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.passenger.ride.PassengerRideMapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */