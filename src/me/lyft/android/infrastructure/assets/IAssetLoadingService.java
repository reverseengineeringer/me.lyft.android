package me.lyft.android.infrastructure.assets;

import android.graphics.Bitmap;
import com.squareup.picasso.RequestCreator;
import rx.Observable;

public abstract interface IAssetLoadingService
{
  public abstract RequestCreator loadImage(String paramString);
  
  public abstract RequestCreator loadImageWithoutDensityTransformation(String paramString);
  
  public abstract Observable<Bitmap> loadMarkerBitmap(String paramString);
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.assets.IAssetLoadingService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */