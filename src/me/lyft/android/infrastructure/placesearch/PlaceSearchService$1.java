package me.lyft.android.infrastructure.placesearch;

import com.lyft.android.api.dto.PlacesDTO;
import java.util.List;
import me.lyft.android.domain.location.Location;
import rx.functions.Func1;

class PlaceSearchService$1
  implements Func1<PlacesDTO, List<Location>>
{
  PlaceSearchService$1(PlaceSearchService paramPlaceSearchService) {}
  
  public List<Location> call(PlacesDTO paramPlacesDTO)
  {
    return PlaceSearchMapper.fromPlaceSearchResponseDTO(paramPlacesDTO);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.placesearch.PlaceSearchService.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */