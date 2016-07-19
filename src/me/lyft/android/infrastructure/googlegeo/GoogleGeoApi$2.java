package me.lyft.android.infrastructure.googlegeo;

import java.util.List;
import me.lyft.android.infrastructure.googlegeo.model.GoogleDirectionsResponseDTO;
import rx.Observable;
import rx.functions.Func1;

class GoogleGeoApi$2
  implements Func1<GoogleDirectionsResponseDTO, Observable<GoogleDirectionsResponseDTO>>
{
  GoogleGeoApi$2(GoogleGeoApi paramGoogleGeoApi) {}
  
  public Observable<GoogleDirectionsResponseDTO> call(GoogleDirectionsResponseDTO paramGoogleDirectionsResponseDTO)
  {
    if (paramGoogleDirectionsResponseDTO.getRoutes().size() > 0) {
      return Observable.just(paramGoogleDirectionsResponseDTO);
    }
    return Observable.error(new GoogleGeoApiException(paramGoogleDirectionsResponseDTO.getStatus()));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.googlegeo.GoogleGeoApi.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */