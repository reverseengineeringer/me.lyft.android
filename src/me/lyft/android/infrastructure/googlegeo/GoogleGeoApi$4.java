package me.lyft.android.infrastructure.googlegeo;

import me.lyft.android.infrastructure.googlegeo.model.DistanceMatrixResponseDTO;
import rx.Observable.OnSubscribe;
import rx.Subscriber;

final class GoogleGeoApi$4
  implements Observable.OnSubscribe<Long>
{
  GoogleGeoApi$4(DistanceMatrixResponseDTO paramDistanceMatrixResponseDTO) {}
  
  public void call(Subscriber<? super Long> paramSubscriber)
  {
    try
    {
      paramSubscriber.onNext(GoogleGeoApi.access$100(val$response));
      paramSubscriber.onCompleted();
      return;
    }
    catch (Throwable localThrowable)
    {
      paramSubscriber.onError(localThrowable);
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.googlegeo.GoogleGeoApi.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */