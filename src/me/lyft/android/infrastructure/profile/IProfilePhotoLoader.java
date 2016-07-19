package me.lyft.android.infrastructure.profile;

import com.squareup.picasso.RequestCreator;
import java.io.File;

public abstract interface IProfilePhotoLoader
{
  public abstract boolean hasCacheFile();
  
  public abstract RequestCreator load();
  
  public abstract RequestCreator loadPreview();
  
  public abstract void usePhotoFilePreview(File paramFile);
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.profile.IProfilePhotoLoader
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */