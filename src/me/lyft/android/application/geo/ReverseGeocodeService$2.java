package me.lyft.android.application.geo;

import me.lyft.android.common.Strings;
import me.lyft.android.domain.geo.AddressMapper;
import me.lyft.android.domain.location.Location;
import me.lyft.android.infrastructure.cache.ICache;
import me.lyft.android.infrastructure.googlegeo.model.GoogleGeocodeResponseDTO;
import rx.functions.Func1;

class ReverseGeocodeService$2
  implements Func1<GoogleGeocodeResponseDTO, Location>
{
  ReverseGeocodeService$2(ReverseGeocodeService paramReverseGeocodeService, Location paramLocation, String paramString) {}
  
  public Location call(GoogleGeocodeResponseDTO paramGoogleGeocodeResponseDTO)
  {
    paramGoogleGeocodeResponseDTO = AddressMapper.fromGoogleGeocodeResult(paramGoogleGeocodeResponseDTO);
    paramGoogleGeocodeResponseDTO = val$location.cloneWithAddress(paramGoogleGeocodeResponseDTO);
    if (!Strings.isNullOrEmpty(paramGoogleGeocodeResponseDTO.getDisplayName())) {
      ReverseGeocodeService.access$000(this$0).put(val$locationQuery, paramGoogleGeocodeResponseDTO);
    }
    return paramGoogleGeocodeResponseDTO;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.geo.ReverseGeocodeService.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */