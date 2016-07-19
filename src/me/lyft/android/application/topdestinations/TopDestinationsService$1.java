package me.lyft.android.application.topdestinations;

import com.lyft.android.api.dto.PlacesDTO;
import java.util.Collections;
import java.util.List;
import me.lyft.android.common.Iterables;
import me.lyft.android.domain.location.Location;
import rx.functions.Func1;

class TopDestinationsService$1
  implements Func1<PlacesDTO, List<Location>>
{
  TopDestinationsService$1(TopDestinationsService paramTopDestinationsService) {}
  
  public List<Location> call(PlacesDTO paramPlacesDTO)
  {
    if (places == null) {}
    for (paramPlacesDTO = Collections.emptyList();; paramPlacesDTO = places) {
      return Iterables.map(paramPlacesDTO, TopDestinationsService.access$000());
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.topdestinations.TopDestinationsService.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */