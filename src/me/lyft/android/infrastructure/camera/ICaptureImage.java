package me.lyft.android.infrastructure.camera;

import com.lyft.scoop.Screen;
import java.io.File;
import me.lyft.android.common.Unit;
import rx.Observable;

public abstract interface ICaptureImage
{
  public abstract void capturePhoto(Screen paramScreen1, Screen paramScreen2, Screen paramScreen3, File paramFile);
  
  public abstract void capturePhoto(Screen paramScreen1, Screen paramScreen2, File paramFile);
  
  public abstract Observable<Unit> observeCaptureResult();
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.camera.ICaptureImage
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */