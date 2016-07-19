package com.lyft.android.scissors;

import android.graphics.Bitmap.CompressFormat;
import android.graphics.Rect;
import java.io.File;
import java.util.concurrent.Future;

class CropViewExtensions
{
  static final boolean HAS_GLIDE = canHasClass("com.bumptech.glide.Glide");
  static final boolean HAS_PICASSO = canHasClass("com.squareup.picasso.Picasso");
  
  static boolean canHasClass(String paramString)
  {
    try
    {
      Class.forName(paramString);
      return true;
    }
    catch (ClassNotFoundException paramString) {}
    return false;
  }
  
  static Rect computeTargetSize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt1 == paramInt3) && (paramInt2 == paramInt4)) {
      return new Rect(0, 0, paramInt3, paramInt4);
    }
    if (paramInt1 * paramInt4 > paramInt3 * paramInt2) {}
    for (float f = paramInt4 / paramInt2;; f = paramInt3 / paramInt1) {
      return new Rect(0, 0, (int)(paramInt1 * f + 0.5F), (int)(paramInt2 * f + 0.5F));
    }
  }
  
  static BitmapLoader resolveBitmapLoader(CropView paramCropView)
  {
    if (HAS_PICASSO) {
      return PicassoBitmapLoader.createUsing(paramCropView);
    }
    if (HAS_GLIDE) {
      return GlideBitmapLoader.createUsing(paramCropView);
    }
    throw new IllegalStateException("You must provide a BitmapLoader.");
  }
  
  public static class CropRequest
  {
    private final CropView cropView;
    private Bitmap.CompressFormat format = Bitmap.CompressFormat.JPEG;
    private int quality = 100;
    
    CropRequest(CropView paramCropView)
    {
      Utils.checkNotNull(paramCropView, "cropView == null");
      cropView = paramCropView;
    }
    
    public CropRequest format(Bitmap.CompressFormat paramCompressFormat)
    {
      Utils.checkNotNull(paramCompressFormat, "format == null");
      format = paramCompressFormat;
      return this;
    }
    
    public Future<Void> into(File paramFile)
    {
      return Utils.flushToFile(cropView.crop(), format, quality, paramFile);
    }
    
    public CropRequest quality(int paramInt)
    {
      if ((paramInt >= 0) && (paramInt <= 100)) {}
      for (boolean bool = true;; bool = false)
      {
        Utils.checkArg(bool, "quality must be 0..100");
        quality = paramInt;
        return this;
      }
    }
  }
  
  public static class LoadRequest
  {
    private BitmapLoader bitmapLoader;
    private final CropView cropView;
    
    LoadRequest(CropView paramCropView)
    {
      Utils.checkNotNull(paramCropView, "cropView == null");
      cropView = paramCropView;
    }
    
    public void load(Object paramObject)
    {
      if (bitmapLoader == null) {
        bitmapLoader = CropViewExtensions.resolveBitmapLoader(cropView);
      }
      bitmapLoader.load(paramObject, cropView);
    }
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.scissors.CropViewExtensions
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */