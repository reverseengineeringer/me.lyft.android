package me.lyft.android.infrastructure.gallery;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import java.io.File;
import me.lyft.android.common.Unit;
import me.lyft.android.utils.Files;
import rx.Observable.OnSubscribe;
import rx.Subscriber;

class GalleryService$5
  implements Observable.OnSubscribe<Unit>
{
  GalleryService$5(GalleryService paramGalleryService, Context paramContext, Uri paramUri, File paramFile) {}
  
  public void call(Subscriber<? super Unit> paramSubscriber)
  {
    try
    {
      Files.copy(val$context.getContentResolver().openInputStream(val$galleryPictureUri), val$file);
      paramSubscriber.onNext(Unit.create());
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
 * Qualified Name:     me.lyft.android.infrastructure.gallery.GalleryService.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */