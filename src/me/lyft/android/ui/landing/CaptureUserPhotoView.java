package me.lyft.android.ui.landing;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import butterknife.ButterKnife;
import com.lyft.rx.MessageBus;
import com.lyft.scoop.dagger.DaggerInjector;
import javax.inject.Inject;
import me.lyft.android.events.RideStatusChangedEvent;
import me.lyft.android.rx.Binder;
import me.lyft.android.ui.MainScreensRouter;
import me.lyft.android.ui.camera.CaptureView;

public class CaptureUserPhotoView
  extends RelativeLayout
{
  @Inject
  MessageBus bus;
  CaptureView captureView;
  @Inject
  MainScreensRouter mainScreensRouter;
  
  public CaptureUserPhotoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    captureView.setSwitchCameraButtonVisibility(0);
    Binder.attach(this).bind(bus.observe(RideStatusChangedEvent.class), new CaptureUserPhotoView.1(this));
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    ButterKnife.bind(this);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.landing.CaptureUserPhotoView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */