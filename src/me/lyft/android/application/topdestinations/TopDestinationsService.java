package me.lyft.android.application.topdestinations;

import com.lyft.android.api.dto.DeprecatedPlaceDTO;
import com.lyft.android.api.dto.PlacesDTO;
import java.util.Collections;
import java.util.List;
import me.lyft.android.common.Iterables;
import me.lyft.android.domain.location.Location;
import me.lyft.android.domain.location.LocationMapper;
import me.lyft.android.infrastructure.lyft.ILyftApi;
import rx.Observable;
import rx.functions.Func1;

public class TopDestinationsService
  implements ITopDestinationsService
{
  private static final Func1<DeprecatedPlaceDTO, Location> TO_LOCATION = new Func1()
  {
    public Location call(DeprecatedPlaceDTO paramAnonymousDeprecatedPlaceDTO)
    {
      return LocationMapper.fromPlaceDTO(paramAnonymousDeprecatedPlaceDTO);
    }
  };
  private ILyftApi lyftApi;
  
  public TopDestinationsService(ILyftApi paramILyftApi)
  {
    lyftApi = paramILyftApi;
  }
  
  public Observable<List<Location>> observeTopDestinations(Location paramLocation)
  {
    lyftApi.topDestinations(LocationMapper.toLocationDTO(paramLocation)).map(new Func1()
    {
      public List<Location> call(PlacesDTO paramAnonymousPlacesDTO)
      {
        if (places == null) {}
        for (paramAnonymousPlacesDTO = Collections.emptyList();; paramAnonymousPlacesDTO = places) {
          return Iterables.map(paramAnonymousPlacesDTO, TopDestinationsService.TO_LOCATION);
        }
      }
    });
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.topdestinations.TopDestinationsService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */