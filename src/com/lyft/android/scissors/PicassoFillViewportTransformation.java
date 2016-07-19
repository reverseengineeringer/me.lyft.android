package com.lyft.android.scissors;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.squareup.picasso.Transformation;

class PicassoFillViewportTransformation
  implements Transformation
{
  private final int viewportHeight;
  private final int viewportWidth;
  
  public PicassoFillViewportTransformation(int paramInt1, int paramInt2)
  {
    viewportWidth = paramInt1;
    viewportHeight = paramInt2;
  }
  
  public static Transformation createUsing(int paramInt1, int paramInt2)
  {
    return new PicassoFillViewportTransformation(paramInt1, paramInt2);
  }
  
  public String key()
  {
    return viewportWidth + "x" + viewportHeight;
  }
  
  public Bitmap transform(Bitmap paramBitmap)
  {
    Object localObject = CropViewExtensions.computeTargetSize(paramBitmap.getWidth(), paramBitmap.getHeight(), viewportWidth, viewportHeight);
    localObject = Bitmap.createScaledBitmap(paramBitmap, ((Rect)localObject).width(), ((Rect)localObject).height(), true);
    if (localObject != paramBitmap) {
      paramBitmap.recycle();
    }
    return (Bitmap)localObject;
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.scissors.PicassoFillViewportTransformation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */