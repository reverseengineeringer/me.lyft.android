package me.lyft.android.domain.driver.ride;

import com.lyft.android.api.dto.StopDTO;
import me.lyft.android.common.Objects;
import me.lyft.android.domain.location.LocationMapper;
import me.lyft.android.domain.ride.ScheduledIntervalMapper;

public class DriverStopMapper
{
  public static final String STOP_TYPE_DROPOFF = "dropoff";
  public static final String STOP_TYPE_PICKUP = "pickup";
  
  public static DriverStop fromStopDTO(StopDTO paramStopDTO, DriverRidePassenger paramDriverRidePassenger, String paramString)
  {
    paramDriverRidePassenger = new DriverStop(paramDriverRidePassenger, rideId, LocationMapper.fromPlaceDTO(location), getStopType(paramStopDTO), ((Boolean)Objects.firstNonNull(completed, Boolean.valueOf(false))).booleanValue(), ScheduledIntervalMapper.fromTimeRangeDTODeprecated(scheduledTimeRange, paramString));
    paramDriverRidePassenger.setInGeofence(((Boolean)Objects.firstNonNull(inGeoFence, Boolean.FALSE)).booleanValue());
    return paramDriverRidePassenger;
  }
  
  private static DriverStop.Type getStopType(StopDTO paramStopDTO)
  {
    if ("pickup".equals(stopType)) {
      return DriverStop.Type.PICKUP;
    }
    return DriverStop.Type.DROPOFF;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.driver.ride.DriverStopMapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */