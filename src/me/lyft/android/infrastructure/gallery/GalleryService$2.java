package me.lyft.android.infrastructure.gallery;

import android.content.Intent;
import java.io.File;
import me.lyft.android.common.Unit;
import me.lyft.android.utils.ActivityResult;
import rx.Observable;
import rx.functions.Func1;

class GalleryService$2
  implements Func1<ActivityResult, Observable<Unit>>
{
  GalleryService$2(GalleryService paramGalleryService, File paramFile) {}
  
  public Observable<Unit> call(ActivityResult paramActivityResult)
  {
    if (paramActivityResult.getResultCode() == -1)
    {
      paramActivityResult = paramActivityResult.getIntent().getData();
      return GalleryService.access$200(this$0, GalleryService.access$100(this$0), paramActivityResult, val$tmpFile);
    }
    return Observable.empty();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.gallery.GalleryService.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */