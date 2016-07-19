package me.lyft.android.domain.drivers;

import com.lyft.android.api.dto.DriverInfoDTO;
import com.lyft.android.api.dto.DriverLocationDTO;
import com.lyft.android.api.dto.LocationDTO;
import com.lyft.android.api.dto.NearbyDriverDTO;
import com.lyft.android.api.dto.NearbyDriversDTO;
import com.lyft.android.api.dto.NearbyDriversResponseDTO;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import me.lyft.android.common.Iterables;
import me.lyft.android.domain.location.Location;
import me.lyft.android.domain.location.LocationMapper;
import rx.functions.Func1;

public class NearbyDriverMapper
{
  private static Location createLocationFromDriverLocation(DriverLocationDTO paramDriverLocationDTO)
  {
    Location localLocation = new Location(lat.doubleValue(), lng.doubleValue(), "defaultLocation");
    localLocation.setBearing(bearing);
    localLocation.setTime(recorded_at_ms);
    return localLocation;
  }
  
  private static NearbyDriver fromDriverInfoDTO(DriverInfoDTO paramDriverInfoDTO)
  {
    NearbyDriver localNearbyDriver = new NearbyDriver();
    localNearbyDriver.setId(id);
    Location localLocation = LocationMapper.fromLocationDTO(location);
    paramDriverInfoDTO = Iterables.map(recentLocations, new Func1()
    {
      public Location call(LocationDTO paramAnonymousLocationDTO)
      {
        return LocationMapper.fromLocationDTO(paramAnonymousLocationDTO);
      }
    });
    localNearbyDriver.setRecentLocations(paramDriverInfoDTO);
    if (paramDriverInfoDTO.isEmpty()) {}
    for (paramDriverInfoDTO = localLocation;; paramDriverInfoDTO = (Location)Iterables.last(paramDriverInfoDTO))
    {
      localNearbyDriver.setLocation(paramDriverInfoDTO);
      return localNearbyDriver;
    }
  }
  
  private static NearbyDriver fromNearbyDriverDTO(NearbyDriverDTO paramNearbyDriverDTO)
  {
    NearbyDriver localNearbyDriver = new NearbyDriver();
    localNearbyDriver.setId(id);
    paramNearbyDriverDTO = Iterables.map(locations, new Func1()
    {
      public Location call(DriverLocationDTO paramAnonymousDriverLocationDTO)
      {
        return NearbyDriverMapper.createLocationFromDriverLocation(paramAnonymousDriverLocationDTO);
      }
    });
    localNearbyDriver.setRecentLocations(paramNearbyDriverDTO);
    if (paramNearbyDriverDTO.size() > 0) {
      localNearbyDriver.setLocation((Location)paramNearbyDriverDTO.get(0));
    }
    return localNearbyDriver;
  }
  
  public static Map<String, List<NearbyDriver>> fromNearbyDriversResponse(NearbyDriversResponseDTO paramNearbyDriversResponseDTO)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator1 = nearby_drivers.iterator();
    while (localIterator1.hasNext())
    {
      NearbyDriversDTO localNearbyDriversDTO = (NearbyDriversDTO)localIterator1.next();
      Object localObject = Collections.emptyList();
      paramNearbyDriversResponseDTO = (NearbyDriversResponseDTO)localObject;
      if (drivers != null)
      {
        paramNearbyDriversResponseDTO = (NearbyDriversResponseDTO)localObject;
        if (drivers.size() > 0)
        {
          localObject = new ArrayList(drivers.size());
          Iterator localIterator2 = drivers.iterator();
          for (;;)
          {
            paramNearbyDriversResponseDTO = (NearbyDriversResponseDTO)localObject;
            if (!localIterator2.hasNext()) {
              break;
            }
            ((List)localObject).add(fromNearbyDriverDTO((NearbyDriverDTO)localIterator2.next()));
          }
        }
      }
      localHashMap.put(ride_type, paramNearbyDriversResponseDTO);
    }
    return localHashMap;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.drivers.NearbyDriverMapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */