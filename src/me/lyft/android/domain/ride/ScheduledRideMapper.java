package me.lyft.android.domain.ride;

import com.lyft.android.api.dto.ScheduledRideDTO;
import com.lyft.android.api.dto.ScheduledRideResponseDTO;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import me.lyft.android.common.Strings;
import me.lyft.android.domain.location.LocationMapper;
import me.lyft.android.domain.passenger.ridetypes.RequestRideType;
import me.lyft.android.domain.passenger.ridetypes.RequestRideType.Feature;
import me.lyft.android.domain.time.Time;

public class ScheduledRideMapper
{
  private static RequestRideType findRideTypeById(List<RequestRideType> paramList, String paramString)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      RequestRideType localRequestRideType = (RequestRideType)localIterator.next();
      if (Strings.equalsIgnoreCase(localRequestRideType.getPublicId(), paramString)) {
        return localRequestRideType;
      }
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      paramString = (RequestRideType)paramList.next();
      if (paramString.hasFeature(RequestRideType.Feature.IS_DISPLAY_DEFAULT)) {
        return paramString;
      }
    }
    return RequestRideType.empty();
  }
  
  public static ScheduledRide fromScheduledRideDTO(ScheduledRideDTO paramScheduledRideDTO, List<RequestRideType> paramList)
  {
    return new ScheduledRide(LocationMapper.fromPlaceDTOV2(origin), LocationMapper.fromPlaceDTOV2(destination), ride_type, findRideTypeById(paramList, ride_type).getLabel(), id, new Time(scheduled_pickup_time_ms.longValue(), null));
  }
  
  public static List<ScheduledRide> fromScheduledRideResponseDTO(ScheduledRideResponseDTO paramScheduledRideResponseDTO, List<RequestRideType> paramList)
  {
    if ((paramScheduledRideResponseDTO == null) || (scheduled_rides == null) || (scheduled_rides.isEmpty()))
    {
      paramScheduledRideResponseDTO = Collections.emptyList();
      return paramScheduledRideResponseDTO;
    }
    ArrayList localArrayList = new ArrayList(scheduled_rides.size());
    Iterator localIterator = scheduled_rides.iterator();
    for (;;)
    {
      paramScheduledRideResponseDTO = localArrayList;
      if (!localIterator.hasNext()) {
        break;
      }
      localArrayList.add(fromScheduledRideDTO((ScheduledRideDTO)localIterator.next(), paramList));
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.ride.ScheduledRideMapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */