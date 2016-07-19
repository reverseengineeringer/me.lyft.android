package me.lyft.android.infrastructure.camera;

import com.lyft.scoop.Screen;
import java.io.File;

public abstract interface ICaptureImageSession
{
  public abstract void cancel();
  
  public abstract File getImage();
  
  public abstract void onGalleryResult(Screen paramScreen1, File paramFile1, File paramFile2, Screen paramScreen2);
  
  public abstract void onImageCaptured(File paramFile);
  
  public abstract void retakePicture();
  
  public abstract void saveCroppedPicture(File paramFile);
  
  public abstract void savePicture();
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.camera.ICaptureImageSession
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */