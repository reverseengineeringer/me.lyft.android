package me.lyft.android.domain.passenger.ride;

import com.lyft.android.api.dto.LocationDTO;
import me.lyft.android.domain.location.Location;
import me.lyft.android.domain.location.LocationMapper;
import rx.functions.Func1;

final class DriverMapper$1
  implements Func1<LocationDTO, Location>
{
  public Location call(LocationDTO paramLocationDTO)
  {
    return LocationMapper.fromLocationDTO(paramLocationDTO);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.passenger.ride.DriverMapper.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */