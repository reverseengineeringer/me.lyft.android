package me.lyft.android.infrastructure.photo;

import me.lyft.android.common.Unit;
import me.lyft.android.infrastructure.camera.ICaptureImage;
import rx.Observable;

public class PhotoPickerService
  implements IPhotoPickerService
{
  private final ICaptureImage captureImage;
  
  public PhotoPickerService(ICaptureImage paramICaptureImage)
  {
    captureImage = paramICaptureImage;
  }
  
  public Observable<Unit> observePhotoPickerResult()
  {
    return captureImage.observeCaptureResult();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.photo.PhotoPickerService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */