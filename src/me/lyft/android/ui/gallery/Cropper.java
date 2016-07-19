package me.lyft.android.ui.gallery;

import android.content.Context;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import com.lyft.android.scissors.CropView;
import com.lyft.android.scissors.CropView.Extensions;
import com.lyft.android.scissors.CropViewExtensions.CropRequest;
import com.lyft.scoop.dagger.DaggerInjector;
import java.io.File;
import javax.inject.Inject;
import me.lyft.android.infrastructure.camera.ICaptureImageSession;
import me.lyft.android.rx.Binder;
import me.lyft.android.rx.ViewExtensions;
import me.lyft.android.utils.FileUtils;
import me.lyft.android.utils.MetricsUtils;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class Cropper
  extends CropView
{
  private static final int CROPVIEW_STROKE_WIDTH = 2;
  private Binder binder;
  @Inject
  ICaptureImageSession captureImageSession;
  private Paint guidePaint;
  
  public Cropper(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
    float f = MetricsUtils.fromView(this).dpToPixels(2.0F);
    guidePaint = new Paint();
    guidePaint.setStyle(Paint.Style.STROKE);
    guidePaint.setStrokeWidth(f);
    guidePaint.setColor(-1);
  }
  
  private File getTemporaryUserPhotoFile()
  {
    return FileUtils.getTemporaryFile(getContext(), "profile_photo.jpg");
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    binder = Binder.attach(this);
    binder.bind(ViewExtensions.onLoadedObservable(this), new Cropper.1(this));
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (getImageBitmap() == null) {
      return;
    }
    int i = (int)(guidePaint.getStrokeWidth() / 2.0F);
    int j = getBottom();
    int k = getViewportHeight();
    int m = (j - k) / 2;
    int n = getWidth() / 2 - k / 2;
    paramCanvas.drawRect(n + i, m + i, n + k - i, j - m - i, guidePaint);
  }
  
  public void retakePicture()
  {
    captureImageSession.retakePicture();
  }
  
  public void savePicture()
  {
    File localFile = getTemporaryUserPhotoFile();
    binder.bind(Observable.from(extensions().crop().quality(100).format(Bitmap.CompressFormat.JPEG).into(localFile)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()), new Cropper.2(this, localFile));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.gallery.Cropper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */