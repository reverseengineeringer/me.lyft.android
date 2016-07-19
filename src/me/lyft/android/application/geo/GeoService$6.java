package me.lyft.android.application.geo;

import java.util.List;
import me.lyft.android.domain.geo.City;
import me.lyft.android.domain.geo.CityMapper;
import me.lyft.android.infrastructure.googlegeo.GoogleGeoApiException;
import me.lyft.android.infrastructure.googlegeo.model.GoogleGeocodeResponseDTO;
import me.lyft.android.infrastructure.googlegeo.model.GoogleGeocodeResultDTO;
import rx.Observable;
import rx.functions.Func1;

class GeoService$6
  implements Func1<GoogleGeocodeResponseDTO, Observable<City>>
{
  GeoService$6(GeoService paramGeoService) {}
  
  public Observable<City> call(GoogleGeocodeResponseDTO paramGoogleGeocodeResponseDTO)
  {
    paramGoogleGeocodeResponseDTO = paramGoogleGeocodeResponseDTO.getResults();
    if ((paramGoogleGeocodeResponseDTO != null) && (!paramGoogleGeocodeResponseDTO.isEmpty())) {
      return Observable.just(CityMapper.fromGoogleAddressComponentsDTO(get0addressComponents));
    }
    return Observable.error(new GoogleGeoApiException("No address components returned"));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.geo.GeoService.6
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */