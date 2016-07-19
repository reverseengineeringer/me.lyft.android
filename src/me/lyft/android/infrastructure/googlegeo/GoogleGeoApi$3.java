package me.lyft.android.infrastructure.googlegeo;

import me.lyft.android.infrastructure.googlegeo.model.DistanceMatrixResponseDTO;
import rx.Observable;
import rx.functions.Func1;

class GoogleGeoApi$3
  implements Func1<DistanceMatrixResponseDTO, Observable<Long>>
{
  GoogleGeoApi$3(GoogleGeoApi paramGoogleGeoApi) {}
  
  public Observable<Long> call(DistanceMatrixResponseDTO paramDistanceMatrixResponseDTO)
  {
    return GoogleGeoApi.access$000(paramDistanceMatrixResponseDTO);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.googlegeo.GoogleGeoApi.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */