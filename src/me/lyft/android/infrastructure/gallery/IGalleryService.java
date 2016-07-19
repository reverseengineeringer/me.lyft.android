package me.lyft.android.infrastructure.gallery;

import android.content.Context;
import com.lyft.scoop.Screen;
import java.io.File;

public abstract interface IGalleryService
{
  public abstract void pickFileFromGallery(Context paramContext, Screen paramScreen1, Screen paramScreen2, File paramFile);
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.gallery.IGalleryService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */