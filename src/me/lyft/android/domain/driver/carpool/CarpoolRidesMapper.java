package me.lyft.android.domain.driver.carpool;

import com.lyft.android.api.dto.CarpoolRidesResponseDTO;
import com.lyft.android.api.dto.RideDTO;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import me.lyft.android.domain.driver.ride.DriverRide;
import me.lyft.android.domain.driver.ride.DriverRideMapper;

public class CarpoolRidesMapper
{
  public static List<DriverRide> fromCarpoolRidesResponse(CarpoolRidesResponseDTO paramCarpoolRidesResponseDTO, String paramString)
  {
    if ((paramCarpoolRidesResponseDTO == null) || (rides == null) || (rides.isEmpty()))
    {
      paramCarpoolRidesResponseDTO = Collections.emptyList();
      return paramCarpoolRidesResponseDTO;
    }
    ArrayList localArrayList = new ArrayList(rides.size());
    Iterator localIterator = rides.iterator();
    for (;;)
    {
      paramCarpoolRidesResponseDTO = localArrayList;
      if (!localIterator.hasNext()) {
        break;
      }
      localArrayList.add(DriverRideMapper.createDriverRide((RideDTO)localIterator.next(), paramString));
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.driver.carpool.CarpoolRidesMapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */