package me.lyft.android.infrastructure.googleplaces;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.PlaceDetectionApi;
import com.google.android.gms.location.places.PlaceReport;
import com.google.android.gms.location.places.Places;
import me.lyft.android.common.Unit;
import me.lyft.android.infrastructure.googleplay.IGoogleApiProvider;
import rx.Observable.OnSubscribe;
import rx.Subscriber;

class GooglePlaceService$3
  implements Observable.OnSubscribe<Unit>
{
  GooglePlaceService$3(GooglePlaceService paramGooglePlaceService, String paramString1, String paramString2) {}
  
  public void call(Subscriber<? super Unit> paramSubscriber)
  {
    try
    {
      Object localObject = PlaceReport.create(val$placeId, val$tag);
      localObject = (Status)Places.PlaceDetectionApi.reportDeviceAtPlace(GooglePlaceService.access$000(this$0).getApi(), (PlaceReport)localObject).await();
      if (((Status)localObject).isSuccess())
      {
        paramSubscriber.onNext(Unit.create());
        paramSubscriber.onCompleted();
        return;
      }
      throw new GooglePlaceException("PlaceDetectionApi.reportDeviceAtPlace failed with status: " + ((Status)localObject).getStatus().getStatusMessage());
    }
    catch (Throwable localThrowable)
    {
      paramSubscriber.onError(localThrowable);
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.googleplaces.GooglePlaceService.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */