package me.lyft.android.infrastructure.camera;

import com.lyft.scoop.Screen;
import java.io.File;
import me.lyft.android.common.AppFlow;
import me.lyft.android.common.Objects;
import me.lyft.android.common.Unit;
import me.lyft.android.logging.L;
import me.lyft.android.rx.SimpleSubscriber;
import me.lyft.android.utils.Files;
import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Subscriber;
import rx.schedulers.Schedulers;

public class CaptureImageSession
  implements ICaptureImage, ICaptureImageSession
{
  public static final String TEMPORARY_PROFILE_PHOTO_NAME = "profile_photo.jpg";
  private final AppFlow appFlow;
  private Screen captureScreen;
  private File capturedImage;
  private File outputFile;
  private Screen previewScreen;
  private Screen returnScreen;
  private File tmpFile;
  
  public CaptureImageSession(AppFlow paramAppFlow)
  {
    appFlow = paramAppFlow;
  }
  
  private static Observable<File> copyFileToFile(File paramFile1, final File paramFile2)
  {
    Observable.create(new Observable.OnSubscribe()
    {
      public void call(Subscriber<? super File> paramAnonymousSubscriber)
      {
        try
        {
          long l = System.currentTimeMillis();
          Files.copy(val$from, paramFile2);
          paramAnonymousSubscriber.onNext(paramFile2);
          paramAnonymousSubscriber.onCompleted();
          L.i("time to copy: %dms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
          return;
        }
        catch (Throwable localThrowable)
        {
          paramAnonymousSubscriber.onError(localThrowable);
        }
      }
    }).subscribeOn(Schedulers.io());
  }
  
  private void goToPreviewScreen()
  {
    appFlow.goTo(previewScreen);
  }
  
  private File popCaptureResult()
  {
    File localFile = outputFile;
    outputFile = null;
    return localFile;
  }
  
  public void cancel()
  {
    appFlow.goBack();
  }
  
  public void capturePhoto(Screen paramScreen1, Screen paramScreen2, Screen paramScreen3, File paramFile)
  {
    captureScreen = paramScreen1;
    returnScreen = paramScreen2;
    tmpFile = paramFile;
    previewScreen = paramScreen3;
    appFlow.goTo(paramScreen1);
  }
  
  public void capturePhoto(Screen paramScreen1, Screen paramScreen2, File paramFile)
  {
    capturePhoto(paramScreen1, paramScreen2, null, paramFile);
  }
  
  public File getImage()
  {
    return capturedImage;
  }
  
  public Observable<Unit> observeCaptureResult()
  {
    if (popCaptureResult() != null) {
      return Unit.just();
    }
    return Observable.empty();
  }
  
  public void onGalleryResult(Screen paramScreen1, File paramFile1, File paramFile2, Screen paramScreen2)
  {
    returnScreen = paramScreen1;
    previewScreen = paramScreen2;
    capturedImage = paramFile2;
    if (paramScreen2 == null)
    {
      outputFile = paramFile1;
      savePicture();
      return;
    }
    goToPreviewScreen();
  }
  
  public void onImageCaptured(File paramFile)
  {
    capturedImage = paramFile;
    if (previewScreen == null)
    {
      outputFile = tmpFile;
      savePicture();
      return;
    }
    goToPreviewScreen();
  }
  
  public void retakePicture()
  {
    appFlow.goBack();
  }
  
  public void saveCroppedPicture(File paramFile)
  {
    outputFile = paramFile;
    appFlow.resetTo(returnScreen);
  }
  
  public void savePicture()
  {
    copyFileToFile(capturedImage, (File)Objects.firstNonNull(outputFile, tmpFile)).subscribe(new SimpleSubscriber()
    {
      public void onError(Throwable paramAnonymousThrowable)
      {
        appFlow.resetTo(returnScreen);
      }
      
      public void onNext(File paramAnonymousFile)
      {
        appFlow.resetTo(returnScreen);
      }
    });
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.camera.CaptureImageSession
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */