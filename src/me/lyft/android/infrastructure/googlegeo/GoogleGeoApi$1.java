package me.lyft.android.infrastructure.googlegeo;

import me.lyft.android.infrastructure.googlegeo.model.GoogleGeoResponseDTO;
import rx.Observable;
import rx.functions.Func1;

class GoogleGeoApi$1
  implements Func1<T, Observable<T>>
{
  GoogleGeoApi$1(GoogleGeoApi paramGoogleGeoApi) {}
  
  public Observable<T> call(T paramT)
  {
    if (paramT.isOK()) {
      return Observable.just(paramT);
    }
    return Observable.error(new GoogleGeoApiException(paramT.getStatus()));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.googlegeo.GoogleGeoApi.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */