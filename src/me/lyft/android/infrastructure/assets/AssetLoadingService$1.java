package me.lyft.android.infrastructure.assets;

import android.graphics.Bitmap;
import rx.Observable.OnSubscribe;
import rx.Subscriber;

class AssetLoadingService$1
  implements Observable.OnSubscribe<Bitmap>
{
  AssetLoadingService$1(AssetLoadingService paramAssetLoadingService, String paramString) {}
  
  public void call(Subscriber<? super Bitmap> paramSubscriber)
  {
    try
    {
      paramSubscriber.onNext(AssetLoadingService.access$000(this$0, val$fileName));
      paramSubscriber.onCompleted();
      return;
    }
    catch (Exception localException)
    {
      paramSubscriber.onError(localException);
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.assets.AssetLoadingService.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */