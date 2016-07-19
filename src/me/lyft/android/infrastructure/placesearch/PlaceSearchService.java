package me.lyft.android.infrastructure.placesearch;

import com.lyft.android.api.dto.LocationDTO;
import com.lyft.android.api.dto.PlacesDTO;
import java.util.List;
import me.lyft.android.domain.location.Location;
import me.lyft.android.domain.location.LocationMapper;
import me.lyft.android.infrastructure.location.ILocationService;
import me.lyft.android.infrastructure.lyft.ILyftApi;
import rx.Observable;
import rx.functions.Func1;

public class PlaceSearchService
  implements IPlaceSearchService
{
  private ILocationService locationService;
  private ILyftApi lyftApi;
  
  public PlaceSearchService(ILyftApi paramILyftApi, ILocationService paramILocationService)
  {
    lyftApi = paramILyftApi;
    locationService = paramILocationService;
  }
  
  public Observable<List<Location>> placeSearchFallback(String paramString)
  {
    LocationDTO localLocationDTO = LocationMapper.toLocationDTO(locationService.getLastCachedLocation());
    if (localLocationDTO != null) {
      lyftApi.placeSearch(paramString, localLocationDTO).map(new Func1()
      {
        public List<Location> call(PlacesDTO paramAnonymousPlacesDTO)
        {
          return PlaceSearchMapper.fromPlaceSearchResponseDTO(paramAnonymousPlacesDTO);
        }
      });
    }
    return Observable.empty();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.placesearch.PlaceSearchService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */