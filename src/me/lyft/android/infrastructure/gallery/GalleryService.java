package me.lyft.android.infrastructure.gallery;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.lyft.scoop.Screen;
import java.io.File;
import me.lyft.android.common.Unit;
import me.lyft.android.infrastructure.activity.ActivityService;
import me.lyft.android.infrastructure.camera.ICaptureImageSession;
import me.lyft.android.logging.L;
import me.lyft.android.rx.SimpleSubscriber;
import me.lyft.android.utils.ActivityResult;
import me.lyft.android.utils.FileUtils;
import me.lyft.android.utils.Files;
import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import rx.subjects.PublishSubject;

public class GalleryService
  extends ActivityService
  implements IGalleryService
{
  private PublishSubject<ActivityResult> activityResultSubject = PublishSubject.create();
  private ICaptureImageSession captureImageSession;
  
  public GalleryService(ICaptureImageSession paramICaptureImageSession)
  {
    captureImageSession = paramICaptureImageSession;
  }
  
  private Observable<Unit> copyGalleryPhotoToFile(final Context paramContext, final Uri paramUri, final File paramFile)
  {
    Observable.create(new Observable.OnSubscribe()
    {
      public void call(Subscriber<? super Unit> paramAnonymousSubscriber)
      {
        try
        {
          Files.copy(paramContext.getContentResolver().openInputStream(paramUri), paramFile);
          paramAnonymousSubscriber.onNext(Unit.create());
          paramAnonymousSubscriber.onCompleted();
          return;
        }
        catch (Throwable localThrowable)
        {
          paramAnonymousSubscriber.onError(localThrowable);
        }
      }
    }).subscribeOn(Schedulers.io());
  }
  
  private void openGallery()
  {
    Intent localIntent = new Intent();
    localIntent.setType("image/*");
    localIntent.setAction("android.intent.action.GET_CONTENT");
    localIntent.addCategory("android.intent.category.OPENABLE");
    localIntent = Intent.createChooser(localIntent, getCurrentActivity().getString(2131165448));
    getCurrentActivity().startActivityForResult(localIntent, 10);
  }
  
  public void onActivityResult(Activity paramActivity, ActivityResult paramActivityResult)
  {
    super.onActivityResult(paramActivity, paramActivityResult);
    activityResultSubject.onNext(paramActivityResult);
  }
  
  public void pickFileFromGallery(final Context paramContext, final Screen paramScreen1, final Screen paramScreen2, final File paramFile)
  {
    paramContext = FileUtils.getTemporaryFile(paramContext, "camera_capture.jpg");
    activityResultSubject.doOnSubscribe(new Action0()
    {
      public void call()
      {
        GalleryService.this.openGallery();
      }
    }).first(new Func1()
    {
      public Boolean call(ActivityResult paramAnonymousActivityResult)
      {
        if (paramAnonymousActivityResult.getRequestCode() == 10) {}
        for (boolean bool = true;; bool = false) {
          return Boolean.valueOf(bool);
        }
      }
    }).flatMap(new Func1()
    {
      public Observable<Unit> call(ActivityResult paramAnonymousActivityResult)
      {
        if (paramAnonymousActivityResult.getResultCode() == -1)
        {
          paramAnonymousActivityResult = paramAnonymousActivityResult.getIntent().getData();
          return GalleryService.this.copyGalleryPhotoToFile(GalleryService.access$100(GalleryService.this), paramAnonymousActivityResult, paramContext);
        }
        return Observable.empty();
      }
    }).subscribe(new SimpleSubscriber()
    {
      public void onError(Throwable paramAnonymousThrowable)
      {
        L.e(paramAnonymousThrowable.getMessage(), new Object[] { paramAnonymousThrowable });
      }
      
      public void onNext(Unit paramAnonymousUnit)
      {
        captureImageSession.onGalleryResult(paramScreen1, paramFile, paramContext, paramScreen2);
      }
    });
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.gallery.GalleryService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */