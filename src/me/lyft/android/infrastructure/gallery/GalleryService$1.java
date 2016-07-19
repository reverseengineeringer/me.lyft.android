package me.lyft.android.infrastructure.gallery;

import com.lyft.scoop.Screen;
import java.io.File;
import me.lyft.android.common.Unit;
import me.lyft.android.infrastructure.camera.ICaptureImageSession;
import me.lyft.android.logging.L;
import me.lyft.android.rx.SimpleSubscriber;

class GalleryService$1
  extends SimpleSubscriber<Unit>
{
  GalleryService$1(GalleryService paramGalleryService, Screen paramScreen1, File paramFile1, File paramFile2, Screen paramScreen2) {}
  
  public void onError(Throwable paramThrowable)
  {
    L.e(paramThrowable.getMessage(), new Object[] { paramThrowable });
  }
  
  public void onNext(Unit paramUnit)
  {
    GalleryService.access$000(this$0).onGalleryResult(val$returnScreen, val$outFile, val$tmpFile, val$previewScreen);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.gallery.GalleryService.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */