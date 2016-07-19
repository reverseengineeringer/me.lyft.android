package me.lyft.android.domain.drivers;

import com.lyft.android.api.dto.DriverLocationDTO;
import me.lyft.android.domain.location.Location;
import rx.functions.Func1;

final class NearbyDriverMapper$1
  implements Func1<DriverLocationDTO, Location>
{
  public Location call(DriverLocationDTO paramDriverLocationDTO)
  {
    return NearbyDriverMapper.access$000(paramDriverLocationDTO);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.drivers.NearbyDriverMapper.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */