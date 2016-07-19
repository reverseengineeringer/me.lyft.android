package me.lyft.android.domain.passenger.ride;

import com.lyft.android.api.dto.StopDTO;
import me.lyft.android.common.Objects;
import me.lyft.android.domain.location.LocationMapper;
import me.lyft.android.domain.ride.ScheduledIntervalMapper;

public class PassengerStopMapper
{
  public static final String STOP_TYPE_PICKUP = "pickup";
  
  public static PassengerStop fromStopDTO(StopDTO paramStopDTO, PassengerRidePassenger paramPassengerRidePassenger, String paramString)
  {
    return new PassengerStop(paramPassengerRidePassenger, LocationMapper.fromPlaceDTO(location), getStopType(paramStopDTO), ((Boolean)Objects.firstNonNull(completed, Boolean.valueOf(false))).booleanValue(), ScheduledIntervalMapper.fromTimeRangeDTODeprecated(scheduledTimeRange, paramString));
  }
  
  private static PassengerStop.Type getStopType(StopDTO paramStopDTO)
  {
    if ("pickup".equals(stopType)) {
      return PassengerStop.Type.PICKUP;
    }
    return PassengerStop.Type.DROPOFF;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.passenger.ride.PassengerStopMapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */