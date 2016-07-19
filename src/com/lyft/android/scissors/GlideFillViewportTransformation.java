package com.lyft.android.scissors;

import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;

class GlideFillViewportTransformation
  extends BitmapTransformation
{
  private final int viewportHeight;
  private final int viewportWidth;
  
  public GlideFillViewportTransformation(BitmapPool paramBitmapPool, int paramInt1, int paramInt2)
  {
    super(paramBitmapPool);
    viewportWidth = paramInt1;
    viewportHeight = paramInt2;
  }
  
  public static BitmapTransformation createUsing(BitmapPool paramBitmapPool, int paramInt1, int paramInt2)
  {
    return new GlideFillViewportTransformation(paramBitmapPool, paramInt1, paramInt2);
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.scissors.GlideFillViewportTransformation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */