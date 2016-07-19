package me.lyft.android.ui.camera;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import butterknife.ButterKnife;
import com.lyft.rx.MessageBus;
import com.lyft.scoop.dagger.DaggerInjector;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.RequestCreator;
import javax.inject.Inject;
import me.lyft.android.controls.CameraToolbar;
import me.lyft.android.events.RideStatusChangedEvent;
import me.lyft.android.infrastructure.camera.ICaptureImageSession;
import me.lyft.android.managers.ImageLoader;
import me.lyft.android.rx.Binder;
import me.lyft.android.ui.MainScreensRouter;

public class CaptureResultView
  extends FrameLayout
{
  @Inject
  MessageBus bus;
  CameraToolbar cameraToolbar;
  @Inject
  ICaptureImageSession captureImageSession;
  @Inject
  ImageLoader imageLoader;
  ImageView imageView;
  @Inject
  MainScreensRouter mainScreensRouter;
  View retakeButton;
  View saveButton;
  
  public CaptureResultView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
  }
  
  private void retakePicture()
  {
    captureImageSession.retakePicture();
  }
  
  private void savePicture()
  {
    captureImageSession.savePicture();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (isInEditMode()) {
      return;
    }
    Binder.attach(this).bind(bus.observe(RideStatusChangedEvent.class), new CaptureResultView.3(this));
    cameraToolbar.setTitle(getResources().getString(2131165362));
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    if (isInEditMode()) {
      return;
    }
    ButterKnife.bind(this);
    saveButton.setOnClickListener(new CaptureResultView.1(this));
    retakeButton.setOnClickListener(new CaptureResultView.2(this));
    imageLoader.load(captureImageSession.getImage()).memoryPolicy(MemoryPolicy.NO_CACHE, new MemoryPolicy[] { MemoryPolicy.NO_STORE }).into(imageView);
  }
  
  public void setOnSaveListener(CaptureResultView.OnSaveListener paramOnSaveListener)
  {
    saveButton.setOnClickListener(new CaptureResultView.4(this, paramOnSaveListener));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.camera.CaptureResultView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */