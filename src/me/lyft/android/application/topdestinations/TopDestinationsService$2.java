package me.lyft.android.application.topdestinations;

import com.lyft.android.api.dto.DeprecatedPlaceDTO;
import me.lyft.android.domain.location.Location;
import me.lyft.android.domain.location.LocationMapper;
import rx.functions.Func1;

final class TopDestinationsService$2
  implements Func1<DeprecatedPlaceDTO, Location>
{
  public Location call(DeprecatedPlaceDTO paramDeprecatedPlaceDTO)
  {
    return LocationMapper.fromPlaceDTO(paramDeprecatedPlaceDTO);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.topdestinations.TopDestinationsService.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */