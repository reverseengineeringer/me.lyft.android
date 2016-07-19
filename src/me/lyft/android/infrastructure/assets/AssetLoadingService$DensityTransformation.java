package me.lyft.android.infrastructure.assets;

import android.graphics.Bitmap;
import com.squareup.picasso.Transformation;

class AssetLoadingService$DensityTransformation
  implements Transformation
{
  final double scaleRation;
  final int screenDensity;
  
  public AssetLoadingService$DensityTransformation(int paramInt)
  {
    screenDensity = paramInt;
    scaleRation = (1.0D * paramInt / 480.0D);
  }
  
  public String key()
  {
    return "square()";
  }
  
  public Bitmap transform(Bitmap paramBitmap)
  {
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    Bitmap localBitmap = Bitmap.createScaledBitmap(paramBitmap, (int)(scaleRation * i), (int)(scaleRation * j), false);
    if (localBitmap != paramBitmap) {
      paramBitmap.recycle();
    }
    return localBitmap;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.assets.AssetLoadingService.DensityTransformation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */