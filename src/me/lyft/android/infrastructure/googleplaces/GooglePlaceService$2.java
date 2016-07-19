package me.lyft.android.infrastructure.googleplaces;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.GeoDataApi;
import com.google.android.gms.location.places.PlaceBuffer;
import com.google.android.gms.location.places.Places;
import me.lyft.android.domain.googleplaces.GooglePlace;
import me.lyft.android.infrastructure.googleplay.IGoogleApiProvider;
import rx.Observable.OnSubscribe;
import rx.Subscriber;

class GooglePlaceService$2
  implements Observable.OnSubscribe<GooglePlace>
{
  GooglePlaceService$2(GooglePlaceService paramGooglePlaceService, String paramString) {}
  
  public void call(Subscriber<? super GooglePlace> paramSubscriber)
  {
    localObject2 = null;
    localObject1 = null;
    try
    {
      localPlaceBuffer = (PlaceBuffer)Places.GeoDataApi.getPlaceById(GooglePlaceService.access$000(this$0).getApi(), new String[] { val$placeId }).await();
      localObject1 = localPlaceBuffer;
      localObject2 = localPlaceBuffer;
      if (!localPlaceBuffer.getStatus().isSuccess()) {
        break label174;
      }
      localObject1 = localPlaceBuffer;
      localObject2 = localPlaceBuffer;
      if (localPlaceBuffer.getCount() > 0)
      {
        localObject1 = localPlaceBuffer;
        localObject2 = localPlaceBuffer;
        paramSubscriber.onNext(GooglePlaceMapper.fromGooglePlayPlace(localPlaceBuffer.get(0)));
        localObject1 = localPlaceBuffer;
        localObject2 = localPlaceBuffer;
        paramSubscriber.onCompleted();
        if (localPlaceBuffer != null) {
          localPlaceBuffer.release();
        }
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      PlaceBuffer localPlaceBuffer;
      localObject2 = localObject1;
      paramSubscriber.onError(localThrowable);
      return;
      localObject1 = localThrowable;
      localObject2 = localThrowable;
      throw new GooglePlaceException("GeoDataApi.getPlaceById failed with status: " + localThrowable.getStatus().getStatusMessage());
    }
    finally
    {
      if (localObject2 == null) {
        break label223;
      }
      ((PlaceBuffer)localObject2).release();
    }
    localObject1 = localPlaceBuffer;
    localObject2 = localPlaceBuffer;
    throw new GooglePlaceException("Place with id=\"" + val$placeId + "\" was not found");
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.googleplaces.GooglePlaceService.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */