package me.lyft.android.domain.driver.carpool;

import com.lyft.android.api.dto.RideDTO;
import com.lyft.android.api.dto.RouteDTO;
import com.lyft.android.api.dto.StopDTO;
import com.lyft.android.api.dto.TimeRangeDeprecatedDTO;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import me.lyft.android.common.Objects;
import me.lyft.android.domain.driver.ride.DriverStop;
import me.lyft.android.domain.driver.ride.DriverStopMapper;
import me.lyft.android.domain.location.Location;
import me.lyft.android.domain.location.NullLocation;
import me.lyft.android.domain.time.Time;

public class CarpoolInfoMapper
{
  public static CarpoolInfo mapCarpoolInfo(RideDTO paramRideDTO, String paramString)
  {
    if ((paramRideDTO == null) || (route == null) || (!Objects.equals(rideTypePublicId, "lyft_carpool"))) {
      return CarpoolInfo.empty();
    }
    Object localObject = (List)Objects.firstNonNull(route.stops, Collections.emptyList());
    Location localLocation2 = NullLocation.getInstance();
    Location localLocation1 = NullLocation.getInstance();
    Time localTime1 = Time.empty();
    Time localTime2 = Time.empty();
    Time localTime3 = Time.empty();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      StopDTO localStopDTO = (StopDTO)((Iterator)localObject).next();
      if (Objects.equals(passengerId, paramString))
      {
        DriverStop localDriverStop = DriverStopMapper.fromStopDTO(localStopDTO, null, null);
        if (localDriverStop.isPickup())
        {
          localLocation2 = localDriverStop.getLocation();
          if ((status.equals("acknowledged")) || (status.equals("accepted")))
          {
            localTime1 = new Time(scheduledTimeRange.endTimestamp.longValue(), TimeZone.getDefault().getID());
            localTime3 = new Time(scheduledTimeRange.startTimestamp.longValue(), TimeZone.getDefault().getID());
          }
          else
          {
            localTime1 = localDriverStop.getScheduledTime();
          }
        }
        else if (localDriverStop.isDropOff())
        {
          localLocation1 = localDriverStop.getLocation();
          localTime2 = localDriverStop.getScheduledTime();
        }
      }
    }
    return new CarpoolInfo(localLocation2, localLocation1, localTime3, localTime1, localTime2);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.driver.carpool.CarpoolInfoMapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */