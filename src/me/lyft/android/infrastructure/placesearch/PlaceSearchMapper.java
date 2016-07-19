package me.lyft.android.infrastructure.placesearch;

import com.lyft.android.api.dto.DeprecatedPlaceDTO;
import com.lyft.android.api.dto.PlacesDTO;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import me.lyft.android.common.AddressUtils;
import me.lyft.android.domain.googleplaces.GooglePlace;
import me.lyft.android.domain.googleplaces.GooglePlaceType;
import me.lyft.android.domain.location.Location;

public class PlaceSearchMapper
{
  public static Location fromGooglePlace(GooglePlace paramGooglePlace)
  {
    Location localLocation = new Location(paramGooglePlace.getLat().doubleValue(), paramGooglePlace.getLng().doubleValue(), "placeSearch");
    localLocation.setPlaceName(paramGooglePlace.getName());
    localLocation.setAddress(AddressUtils.getStreetAddress(paramGooglePlace.getAddress()));
    localLocation.setRoutableAddress(paramGooglePlace.getAddress());
    if (paramGooglePlace.getPlaceType() == null) {}
    for (String str = "";; str = paramGooglePlace.getPlaceType().name())
    {
      localLocation.setGooglePlaceType(str);
      localLocation.setPlaceId(paramGooglePlace.getPlaceId());
      return localLocation;
    }
  }
  
  public static Location fromPlaceSearchDTO(DeprecatedPlaceDTO paramDeprecatedPlaceDTO)
  {
    Location localLocation = new Location(lat.doubleValue(), lng.doubleValue(), "placeSearch");
    localLocation.setPlaceName(placeName);
    localLocation.setRoutableAddress(routableAddress);
    localLocation.setPlaceId(placeId);
    return localLocation;
  }
  
  public static List<Location> fromPlaceSearchResponseDTO(PlacesDTO paramPlacesDTO)
  {
    if ((places == null) || (places.size() <= 0))
    {
      paramPlacesDTO = Collections.emptyList();
      return paramPlacesDTO;
    }
    ArrayList localArrayList = new ArrayList(places.size());
    Iterator localIterator = places.iterator();
    for (;;)
    {
      paramPlacesDTO = localArrayList;
      if (!localIterator.hasNext()) {
        break;
      }
      localArrayList.add(fromPlaceSearchDTO((DeprecatedPlaceDTO)localIterator.next()));
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.placesearch.PlaceSearchMapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */