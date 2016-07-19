package me.lyft.android.ui.camera;

import com.lyft.rx.MessageBus;
import dagger.Module;
import dagger.Provides;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.infrastructure.camera.ICaptureImage;
import me.lyft.android.infrastructure.gallery.IGalleryService;
import me.lyft.android.ui.landing.CaptureUserPhotoView;
import me.lyft.android.ui.photo.PhotoPickerDialogController;

@Module(complete=false, injects={CaptureView.class, CaptureResultView.class, CaptureUserPhotoView.class, PhotoPickerDialogController.class})
public class CameraModule
{
  @Provides
  public PhotoPickerDialogController providePhotoPickerDialogController(ICaptureImage paramICaptureImage, IGalleryService paramIGalleryService, DialogFlow paramDialogFlow, MessageBus paramMessageBus)
  {
    return new PhotoPickerDialogController(paramICaptureImage, paramIGalleryService, paramDialogFlow, paramMessageBus);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.camera.CameraModule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */