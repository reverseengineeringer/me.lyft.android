package me.lyft.android.domain.driver.ride;

import com.lyft.android.api.dto.PhoneDTO;
import com.lyft.android.api.dto.RideDTO;
import com.lyft.android.api.dto.RideUserDTO;
import com.lyft.android.api.dto.RouteDTO;
import com.lyft.android.api.dto.StopDTO;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import me.lyft.android.common.Enums;
import me.lyft.android.common.Objects;
import me.lyft.android.common.Strings;
import me.lyft.android.domain.driver.carpool.CarpoolInfoMapper;
import me.lyft.android.domain.location.LocationMapper;
import me.lyft.android.domain.passenger.ride.RideFeature;
import me.lyft.android.domain.payment.Money;
import me.lyft.android.domain.payment.MoneyMapper;
import me.lyft.android.domain.ride.RideStatusMapper;
import me.lyft.android.domain.ride.RideType;

public class DriverRideMapper
{
  private static final List<String> CANCELED_OPTIONS = Arrays.asList(new String[] { "canceled", "canceledNoShow", "canceledWithPenalty", "canceledWrongPartySize" });
  public static final int DRIVER_WAIT_SECONDS = 100;
  public static final int PAY_START_SECONDS = 10;
  public static final String USER_MODE_DRIVER = "driver";
  public static final String USER_MODE_PASSENGER = "passenger";
  
  public static DriverRide createDriverRide(RideDTO paramRideDTO, String paramString)
  {
    if ((paramRideDTO == null) || (isCarpoolPassenger(paramRideDTO))) {
      return DriverRide.empty();
    }
    RouteDTO localRouteDTO = route;
    if (localRouteDTO == null) {
      return DriverRide.empty();
    }
    RideType localRideType = RideType.getInstance(rideTypePublicId);
    boolean bool;
    long l;
    if (showDriverHints == null)
    {
      bool = false;
      if (clientTimeout != null) {
        break label242;
      }
      l = 15L;
      label60:
      if (dynamicPricing != null) {
        break label254;
      }
    }
    label242:
    label254:
    for (int i = 0;; i = dynamicPricing.intValue())
    {
      Money localMoney = MoneyMapper.fromMoneyDTO(profitMinusTip);
      String str = getRideId(paramRideDTO, localRouteDTO);
      return new DriverRide(createRoutes(paramRideDTO, localRouteDTO, localRideType, paramString), RideStatusMapper.fromRideStatus(paramRideDTO, CANCELED_OPTIONS), localRideType, eta, str, bool, l, i, localMoney, ((Boolean)Objects.firstNonNull(isTrainingRide, Boolean.valueOf(false))).booleanValue(), ((Boolean)Objects.firstNonNull(showEndRideConfirmation, Boolean.valueOf(false))).booleanValue(), bannerText, bannerStyle, CarpoolInfoMapper.mapCarpoolInfo(paramRideDTO, paramString), ((Integer)Objects.firstNonNull(driverWaitSeconds, Integer.valueOf(0))).intValue(), ((Integer)Objects.firstNonNull(payStartSeconds, Integer.valueOf(0))).intValue(), ((Boolean)Objects.firstNonNull(shouldSignOutOnLapse, Boolean.valueOf(false))).booleanValue(), Enums.asList(RideFeature.class, features));
      bool = showDriverHints.booleanValue();
      break;
      l = clientTimeout.longValue();
      break label60;
    }
  }
  
  private static DriverRidePassenger createPassenger(RideUserDTO paramRideUserDTO, boolean paramBoolean, String paramString, List<StopDTO> paramList)
  {
    if (paramRideUserDTO == null) {
      return DriverRidePassenger.empty();
    }
    boolean bool2 = false;
    boolean bool1 = false;
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      StopDTO localStopDTO = (StopDTO)paramList.next();
      if ((Strings.equalsIgnoreCase(passengerId, id)) && (((Boolean)Objects.firstNonNull(completed, Boolean.valueOf(false))).booleanValue())) {
        if ("pickup".equals(stopType)) {
          bool2 = true;
        } else if ("dropoff".equals(stopType)) {
          bool1 = true;
        }
      }
    }
    if (phone != null) {}
    for (paramList = phone.number;; paramList = null)
    {
      int i = ((Integer)Objects.firstNonNull(partySize, Integer.valueOf(0))).intValue();
      boolean bool3 = ((Boolean)Objects.firstNonNull(ratingCompleted, Boolean.valueOf(false))).booleanValue();
      paramList = new DriverRidePassenger(id, false, firstName, userPhoto, paramList, i, bool2, bool1, bool3, LocationMapper.fromLocationDTO(location));
      paramList.setRideId(paramString);
      paramList.setDriverCanPenalize(paramBoolean);
      paramList.setRating(((Double)Objects.firstNonNull(passengerRating, Double.valueOf(0.0D))).floatValue());
      return paramList;
    }
  }
  
  private static List<DriverRidePassenger> createPassengers(String paramString1, boolean paramBoolean, String paramString2, List<RideUserDTO> paramList, List<StopDTO> paramList1)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      RideUserDTO localRideUserDTO = (RideUserDTO)paramList.next();
      if ((localRideUserDTO == null) || (!Objects.equals(id, paramString1))) {
        localArrayList.add(createPassenger(localRideUserDTO, paramBoolean, paramString2, paramList1));
      }
    }
    return localArrayList;
  }
  
  private static Route createRoute(String paramString1, RouteDTO paramRouteDTO, boolean paramBoolean1, String paramString2, boolean paramBoolean2, String paramString3)
  {
    List localList = (List)Objects.firstNonNull(passengers, Collections.emptyList());
    paramRouteDTO = (List)Objects.firstNonNull(stops, Collections.emptyList());
    localList = createPassengers(paramString1, paramBoolean1, paramString2, localList, paramRouteDTO);
    return new Route(createStops(paramString1, localList, paramBoolean2, paramString2, paramRouteDTO, paramString3), localList);
  }
  
  private static List<Route> createRoutes(RideDTO paramRideDTO, RouteDTO paramRouteDTO, RideType paramRideType, String paramString)
  {
    Object localObject = (List)Objects.firstNonNull(queuedRoutes, Collections.emptyList());
    paramRideType = new ArrayList(((List)localObject).size() + 1);
    boolean bool = ((Boolean)Objects.firstNonNull(driverCanPenalize, Boolean.valueOf(false))).booleanValue();
    paramRideType.add(createRoute(paramString, paramRouteDTO, bool, getRideId(paramRideDTO, paramRouteDTO), "arrived".equalsIgnoreCase(status), timezone));
    paramRouteDTO = ((List)localObject).iterator();
    while (paramRouteDTO.hasNext())
    {
      localObject = (RouteDTO)paramRouteDTO.next();
      paramRideType.add(createRoute(paramString, (RouteDTO)localObject, bool, getRideIfFromCurrentStop((RouteDTO)localObject), false, timezone));
    }
    return paramRideType;
  }
  
  private static DriverStop createStop(StopDTO paramStopDTO, DriverRidePassenger paramDriverRidePassenger, String paramString1, boolean paramBoolean, String paramString2)
  {
    paramStopDTO = DriverStopMapper.fromStopDTO(paramStopDTO, paramDriverRidePassenger, paramString2);
    if (Objects.equals(paramStopDTO.getRideId(), paramString1)) {
      paramStopDTO.setArrived(paramBoolean);
    }
    return paramStopDTO;
  }
  
  private static List<DriverStop> createStops(String paramString1, List<DriverRidePassenger> paramList, boolean paramBoolean, String paramString2, List<StopDTO> paramList1, String paramString3)
  {
    ArrayList localArrayList = new ArrayList();
    paramList1 = paramList1.iterator();
    while (paramList1.hasNext())
    {
      StopDTO localStopDTO = (StopDTO)paramList1.next();
      if (!Objects.equals(passengerId, paramString1)) {
        localArrayList.add(createStop(localStopDTO, findPassengerById(passengerId, paramList), paramString2, paramBoolean, paramString3));
      }
    }
    return localArrayList;
  }
  
  private static DriverRidePassenger findPassengerById(String paramString, List<DriverRidePassenger> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      DriverRidePassenger localDriverRidePassenger = (DriverRidePassenger)paramList.next();
      if (Objects.equals(paramString, localDriverRidePassenger.getId())) {
        return localDriverRidePassenger;
      }
    }
    return DriverRidePassenger.empty();
  }
  
  private static String getRideId(RideDTO paramRideDTO, RouteDTO paramRouteDTO)
  {
    if (Strings.equalsIgnoreCase(rideTypePublicId, "lyft_line")) {
      return currentStopRideId;
    }
    return id;
  }
  
  private static String getRideIfFromCurrentStop(RouteDTO paramRouteDTO)
  {
    paramRouteDTO = ((List)Objects.firstNonNull(stops, Collections.emptyList())).iterator();
    while (paramRouteDTO.hasNext())
    {
      StopDTO localStopDTO = (StopDTO)paramRouteDTO.next();
      if (!((Boolean)Objects.firstNonNull(completed, Boolean.valueOf(false))).booleanValue()) {
        return rideId;
      }
    }
    return "";
  }
  
  private static boolean isCarpoolPassenger(RideDTO paramRideDTO)
  {
    return (Objects.equals(rideTypePublicId, "lyft_carpool")) && (!Objects.equals(userMode, "driver"));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.driver.ride.DriverRideMapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */